package com.healingtime.healingtime_designrenew;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    static boolean threadCheck = true; 
    static boolean pairedChk = true; 
    private static final int PERMISSION_REQUEST_COARSE_LOCATION = 1; 
    List<String> newlistItems = new ArrayList<String>(); 
    public final static int PERM_REQUEST_CODE_DRAW_OVERLAYS = 1234; 
    boolean packetReceiveSuccess = false;

    public static Context mContext;
    private static final int REQUEST_ENABLE_BT = 3;
    BluetoothAdapter mBluetoothAdapter;
    Set<BluetoothDevice> pairedDevices;
    BluetoothSocket mSocket;
    OutputStream mOutputStream;
    InputStream mInputStream;
    Thread thread1, thread2;
    byte [][] recv_packet;

    @Override
    public void onBackPressed() {
        
        exitConfirm();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();



        
        bluetoothDisconnect();
        threadCheck = false;
        try { Thread.sleep(1000); } catch (InterruptedException e) {e.printStackTrace(); }
        try { 
            mInputStream.close();
            mOutputStream.close();
            mSocket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
            
        }
        try{
            thread1.interrupt();  
            thread2.interrupt();  
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        try{
            ActivityCompat.finishAffinity(MainActivity.this);
            System.exit(0);
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    void exitConfirm(){
        AlertDialog.Builder adialog = new AlertDialog.Builder(this);
        adialog.setIcon(android.R.drawable.ic_dialog_alert);
        adialog.setTitle("알림");
        adialog.setMessage("종료 하시겠습니까?");
        adialog.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                bluetoothDisconnect();
                threadCheck = false;
                try { Thread.sleep(1000); } catch (InterruptedException e) {e.printStackTrace(); }
                try {   
                    mInputStream.close();
                    mOutputStream.close();
                    mSocket.close();
                    
                } catch (IOException e) {
                    e.printStackTrace();
                    
                }
                try{
                    thread1.interrupt();  
                    thread2.interrupt();  
                    
                } catch (Exception e) {
                    e.printStackTrace();
                    
                }
                dialog.dismiss();
                try{
                    ActivityCompat.finishAffinity(MainActivity.this);
                    System.exit(0);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                    
                }
            }
        });
        adialog.setNegativeButton("아니요", null);
        adialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        mContext = this;

/*        
        final Handler handler1 = null;
        final int delaytime = 1000;
        class MyHandler extends Handler{
            public void handleMessage(Message msg){
                doRepeatedly();
                handler1.sendMessageDelayed(new Message(), delaytime);
            }
        }*/

        
        String [] colorAlarmSettings = {"ColorSettings1", "ColorSettings2","ColorSettings3", };
        for (int i = 1; i <= 3; i++) {
            SharedPreferences sp_color_setting = getApplicationContext().getSharedPreferences(colorAlarmSettings[i - 1], Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp_color_setting.edit();
            editor.clear();
            editor.commit();
        }

        
        String [] aromaAlarmSettings = {"aromaSettingsA", "aromaSettingsB","aromaSettingsC"};
        for (int i = 1; i <= 3; i++) {
            SharedPreferences sp_aroma_setting = getApplicationContext().getSharedPreferences(aromaAlarmSettings[i - 1], Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp_aroma_setting.edit();
            editor.clear();
            editor.commit();
        }

        
        checkBlueTooth();
        permissionToDrawOverlays();

        
        ImageButton main_device_setting = (ImageButton) findViewById(R.id.main_refresh_bluetooth);
        main_device_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBlueTooth(); 
            }
        });

        
        LinearLayout main_color_therapy_link = (LinearLayout) findViewById(R.id.main_color_therapy_link);
        main_color_therapy_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mSocket == null) {
                    Toast.makeText(getApplicationContext(), "오른쪽 하단의 버튼을 눌러서 기기와 먼저 연결해주세요.", Toast.LENGTH_LONG).show();
                }else {
                    Intent intent = new Intent(getApplicationContext(), ColorMainActivity.class);
                    startActivity(intent);
                }
            }
        });
        
        LinearLayout main_aroma_therapy_link = (LinearLayout) findViewById(R.id.main_aroma_therapy_link);
        main_aroma_therapy_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mSocket == null) {
                    Toast.makeText(getApplicationContext(), "오른쪽 하단의 버튼을 눌러서 기기와 먼저 연결해주세요.", Toast.LENGTH_LONG).show();
                }else {
                    Intent intent = new Intent(getApplicationContext(), AromaMainActivity.class);
                    startActivity(intent);
                }
            }
        });
        
        LinearLayout therapy_dictionary = (LinearLayout) findViewById(R.id.main_dictionary_link);
        therapy_dictionary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DictionaryAromaActivity.class);
                startActivity(intent);
            }
        });
        
        LinearLayout market = (LinearLayout) findViewById(R.id.main_market_link);
        market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "준비중입니다.^^", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void doRepeatedly(){
        refreshScreen();
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshScreen();
    }

    public void refreshScreen(){

        
        int spray_count = 0;
        SharedPreferences sp_aroma_settings = null;
        byte remain = 0;
        int spray_count_temp = 0;
        Integer spray_exist;
        float used_percent = 0, remain_percent = 0;
        int temp = 0;
        TextView aroma_remaining_percent = null;
        String start_ampm = "오전", end_ampm = "오후";
        Integer start_hour;  
        Integer start_minute; 
        Integer end_hour; 
        Integer end_minute; 

        
        sp_aroma_settings = getApplicationContext().getSharedPreferences("aromaSettingsA", Context.MODE_PRIVATE); 
        spray_count = sp_aroma_settings.getInt("spray_count", 999); 
        spray_exist = sp_aroma_settings.getInt("spray_exist", 0);

        if(spray_count != 999 && spray_exist == 1) {
            remain = (byte) spray_count;
            spray_count_temp = (int) remain & 0xFF; 
            
            used_percent = (float) spray_count_temp * (float) 10 / (float) 24; 
            remain_percent = 100F - used_percent; 
        }

        
        aroma_remaining_percent = (TextView) findViewById(R.id.aroma_remaining_percent_a);
        temp = (int)remain_percent;
        if(temp <= 10) {
            aroma_remaining_percent.setTextColor(0xFFFF0000);
        }
        else if(temp > 10){
            aroma_remaining_percent.setTextColor(0xFFFFFFFF);
        }

        if(spray_count == 999 || spray_exist == 0){
            aroma_remaining_percent.setTextColor(0xFFFFFFFF);
            aroma_remaining_percent.setText("--%");
            remain_percent = 0;
        }
        else {
            aroma_remaining_percent.setText(String.valueOf(temp) + "%");
        }

        
        DrawAromaRemain draw_aroma_remain_a = new DrawAromaRemain(this, remain_percent, 40, 20);
        FrameLayout aroma_remain_circle_layout_a = (FrameLayout) findViewById(R.id.aroma_remain_circle_layout_a);
        aroma_remain_circle_layout_a.addView(draw_aroma_remain_a);

        
        sp_aroma_settings = getApplicationContext().getSharedPreferences("aromaSettingsB", Context.MODE_PRIVATE); 
        spray_count = sp_aroma_settings.getInt("spray_count", 999); 
        spray_exist = sp_aroma_settings.getInt("spray_exist", 0);
        if(spray_count != 999 && spray_exist == 1) {
            remain = (byte) spray_count;
            spray_count_temp = (int) remain & 0xFF; 
            
            used_percent = (float) spray_count_temp * (float) 10 / (float) 24; 
            remain_percent = 100F - used_percent; 
        }

        
        aroma_remaining_percent = (TextView) findViewById(R.id.aroma_remaining_percent_b);
        temp = (int)remain_percent;
        if(temp <= 10) {
            aroma_remaining_percent.setTextColor(0xFFFF0000);
        }
        else if(temp > 10){
            aroma_remaining_percent.setTextColor(0xFFFFFFFF);
        }

        if(spray_count == 999 || spray_exist == 0){
            aroma_remaining_percent.setTextColor(0xFFFFFFFF);
            aroma_remaining_percent.setText("--%");
            remain_percent = 0;
        }
        else {
            aroma_remaining_percent.setText(String.valueOf(temp) + "%");
        }

        
        DrawAromaRemain draw_aroma_remain_b = new DrawAromaRemain(this, remain_percent, 40, 20);
        FrameLayout aroma_remain_circle_layout_b = (FrameLayout) findViewById(R.id.aroma_remain_circle_layout_b);
        aroma_remain_circle_layout_b.addView(draw_aroma_remain_b);

        
        sp_aroma_settings = getApplicationContext().getSharedPreferences("aromaSettingsC", Context.MODE_PRIVATE); 
        spray_count = sp_aroma_settings.getInt("spray_count", 999); 
        spray_exist = sp_aroma_settings.getInt("spray_exist", 0);
        if(spray_count != 999 && spray_exist == 1) {
            remain = (byte) spray_count;
            spray_count_temp = (int) remain & 0xFF; 
            
            used_percent = (float) spray_count_temp * (float) 10 / (float) 24; 
            remain_percent = 100F - used_percent; 
        }

        
        aroma_remaining_percent = (TextView) findViewById(R.id.aroma_remaining_percent_c);
        temp = (int)remain_percent;
        if(temp <= 10) {
            aroma_remaining_percent.setTextColor(0xFFFF0000);
        }
        else if(temp > 10){
            aroma_remaining_percent.setTextColor(0xFFFFFFFF);
        }

        if(spray_count == 999 || spray_exist == 0){
            aroma_remaining_percent.setTextColor(0xFFFFFFFF);
            aroma_remaining_percent.setText("--%");
            remain_percent = 0;
        }
        else {
            aroma_remaining_percent.setText(String.valueOf(temp) + "%");
        }

        
        DrawAromaRemain draw_aroma_remain_c = new DrawAromaRemain(this, remain_percent, 40, 20);
        FrameLayout aroma_remain_circle_layout_c = (FrameLayout) findViewById(R.id.aroma_remain_circle_layout_c);
        aroma_remain_circle_layout_c.addView(draw_aroma_remain_c);

        
        TextView repeat_cycle_textview;
        Integer week_sum, repeat_cycle, type_onoff;
        String aroma_name;
        byte montosun_bit = 0x7F, montosatur_bit = 0x3F, montofri_bit = 0x3E, sunday_bit = 0x40, monday_bit = 0x20, tuesday_bit = 0x10, wednesday_bit = 0x08, thursday_bit = 0x04, friday_bit = 0x02, saturday_bit = 0x01;
        String week_sum_string = "반복: ";
        SharedPreferences sp_aroma_setting = null;

        sp_aroma_settings = getApplicationContext().getSharedPreferences("aromaSettingsA", Context.MODE_PRIVATE); 
/*        type_onoff = sp_aroma_settings.getInt("type_onoff", 0);
        if( (type_onoff & 0x80) == 0x80 ){
            aroma_alarm_switch_a.setChecked(true);
            aroma_alarm_layout_a.setBackgroundColor(0xFFFFFFFF);
        }     */

        
        start_hour = sp_aroma_settings.getInt("start_hour", 0);  
        start_minute = sp_aroma_settings.getInt("start_minute", 0); 
        end_hour = sp_aroma_settings.getInt("end_hour", 0); 
        end_minute = sp_aroma_settings.getInt("end_minute", 0); 
        repeat_cycle = sp_aroma_settings.getInt("repeat_cycle", 0); 
        type_onoff = sp_aroma_settings.getInt("type_onoff", 0);
        spray_exist = sp_aroma_settings.getInt("spray_exist", 999);
        aroma_name = sp_aroma_settings.getString("aroma_name", "이름없음");

        
        if(start_hour > 12) {start_hour -= 12; start_ampm = "오후"; }
        else if(start_hour <= 12)  {start_ampm = "오전"; }
        if(end_hour > 12) {end_hour -= 12; end_ampm = "오후"; }
        else if(end_hour <= 12)  {end_ampm = "오전"; }

        
        
        TextView aroma_alarm_time_textview = (TextView)findViewById(R.id.aroma_alarm_time_textview);
        aroma_alarm_time_textview.setText(start_ampm+" "+String.format("%02d", start_hour)+":"+String.format("%02d", start_minute)+" ~ "+end_ampm+" "+String.format("%02d", end_hour)+":"+String.format("%02d", end_minute));
        TextView aroma_alarm_section_textview = (TextView)findViewById(R.id.aroma_alarm_section_textview);
        aroma_alarm_section_textview.setText("구간" + "A");
        TextView aroma_alarm_aromaname_textview = (TextView)findViewById(R.id.aroma_alarm_aromaname_textview);
        aroma_alarm_aromaname_textview.setText("향기명: " + aroma_name);


        
        SharedPreferences sp_color_setting = getApplicationContext().getSharedPreferences("ColorSettings1", Context.MODE_PRIVATE);
        start_hour = sp_color_setting.getInt("start_hour", 0);  
        start_minute = sp_color_setting.getInt("start_minute", 0); 
        end_hour = sp_color_setting.getInt("end_hour", 0); 
        end_minute = sp_color_setting.getInt("end_minute", 0); 
        Integer rgb_r = sp_color_setting.getInt("user_color_r", 0); 
        Integer rgb_g = sp_color_setting.getInt("user_color_g", 0); 
        Integer rgb_b = sp_color_setting.getInt("user_color_b", 0); 
        Integer color_info = sp_color_setting.getInt("type_onoff", 99);
        Integer deleted = sp_color_setting.getInt("deleted", 999);

        
        if (start_hour > 12) {
            start_hour -= 12; start_ampm = "오후";
        } else if (start_hour <= 12) {
            start_ampm = "오전";
        }
        if (end_hour > 12) {
            end_hour -= 12; end_ampm = "오후";
        } else if (end_hour <= 12) {
            end_ampm = "오전";
        }

        
        int color_type = color_info & 0x0F;
        int color_onoff = color_info & 0x40;
        int color_value = 0xFFF2F2F2; 
        String[] color_data = null;

        switch (color_type){
            case 1:
                color_value = 0xFFF83434;
                color_data= getResources().getStringArray(R.array.color_red);
                break;
            case 2:
                color_value = 0xFFFF9800;
                color_data= getResources().getStringArray(R.array.color_orange);
                break;
            case 3:
                color_value = 0xFFFBE02D;
                color_data= getResources().getStringArray(R.array.color_yellow);
                break;
            case 4:
                color_value = 0xFF7CD138;
                color_data= getResources().getStringArray(R.array.color_green);
                break;
            case 5:
                color_value = 0xFF3881FB;
                color_data= getResources().getStringArray(R.array.color_blue);
                break;
            case 6:
                color_value = 0xFF800080;
                color_data= getResources().getStringArray(R.array.color_purple);
                break;
            case 7:
                color_value = 0xFFFFFFFF;
                color_data= getResources().getStringArray(R.array.color_white);
                break;
            case 8:
                int temp0 = 0xFF000000;
                int temp1 = (rgb_r & 0x000000FF) << 16;
                int temp2 = (rgb_g & 0x000000FF) << 8;
                int temp3 = (rgb_b & 0x000000FF) << 0;
                color_value = temp0 | temp1 | temp2 | temp3;
                color_data= getResources().getStringArray(R.array.color_custom);
                break;
            default:
                color_value = 0x00FFFFFF; 
                color_data= getResources().getStringArray(R.array.color_nothing);
                break;
        }

        
        LinearLayout color_alarm_desc = (LinearLayout) findViewById(R.id.color_alarm_desc);

        if(deleted == 0 && color_onoff == 0x40 ) { 
            TextView color_alarm_time_textview = (TextView) findViewById(R.id.color_alarm_time_textview);
            color_alarm_time_textview.setText(start_ampm + " " + String.format("%02d", start_hour) + ":" + String.format("%02d", start_minute) + " ~ " + end_ampm + " " + String.format("%02d", end_hour) + ":" + String.format("%02d", end_minute));
            View color_alarm_user_rgb = (View) findViewById(R.id.color_alarm_user_rgb);
            color_alarm_user_rgb.setBackgroundColor(color_value);
            color_alarm_time_textview.setTextColor(0xFFFFFFFF);
            TextView color_alarm_desc_textview = (TextView) findViewById(R.id.color_alarm_desc_textview);
            color_alarm_desc_textview.setText(color_data[2]); 
            ImageView color_alarm_lightbulb_imageview = (ImageView) findViewById(R.id.color_alarm_lightbulb_imageview);
            color_alarm_lightbulb_imageview.setImageResource(R.drawable.light_bulb_white);
            color_alarm_desc.setVisibility(View.VISIBLE);
        }
        else if(deleted == 1 || deleted == 999 || color_onoff == 0 || color_info == 99) { 
            TextView color_alarm_time_textview = (TextView) findViewById(R.id.color_alarm_time_textview);
            color_alarm_time_textview.setTextColor(0xFF9EBC72);
            color_alarm_time_textview.setText("알람을 설정해주세요.");
            ImageView color_alarm_lightbulb_imageview = (ImageView) findViewById(R.id.color_alarm_lightbulb_imageview);
            color_alarm_lightbulb_imageview.setImageResource(R.drawable.light_bulb_green);
            color_alarm_desc.setVisibility(View.INVISIBLE);
        }
    }

    public void permissionToDrawOverlays(){
        if(Build.VERSION.SDK_INT >= 23) {
            if(!Settings.canDrawOverlays(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, PERM_REQUEST_CODE_DRAW_OVERLAYS);
            }
        }
    }

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                newlistItems.add(device.getName() + "\n" + device.getAddress());
            } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
                if(newlistItems.size() == 0)
                {
                    newlistItems.add("아무것도 없습니다.");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                newlistItems.add("취소");
                final CharSequence[] items = newlistItems.toArray(new CharSequence[newlistItems.size()]);
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        if (item == newlistItems.size()-1) {
                            
                            Toast.makeText(getApplicationContext(), "장치를 선택하지 않으면 \n앱을 사용하실 수 없습니다.\n앱을 종료합니다.", Toast.LENGTH_LONG).show();
                            
                        } else {
                            
                            
                            pairedChk = false;
                            connectToSelectedDevices(items[item].toString());
                        }
                    }
                });
                builder.setCancelable(false);    
                AlertDialog alert = builder.create();
                alert.show();
            }
        }
    };

    void checkBlueTooth() {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            
            Toast.makeText(getApplicationContext(), "블루투스 기능을 지원하지 않는 기기입니다.", Toast.LENGTH_LONG).show();
        } else {
            
            if (!mBluetoothAdapter.isEnabled()) {
                
                Toast.makeText(getApplicationContext(), "블루투스가 꺼져있습니다.", Toast.LENGTH_LONG).show();
                
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            } else {
                
                Toast.makeText(getApplicationContext(), "블루투스가 켜져있습니다.", Toast.LENGTH_SHORT).show();
                
                selectDevice();
            }
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_ENABLE_BT:
                if (resultCode == RESULT_OK) {
                    
                    Toast.makeText(getApplicationContext(), "블루투스가 활성화되었습니다.", Toast.LENGTH_SHORT).show();
                    selectDevice();
                } else if (resultCode == RESULT_CANCELED) {
                    
                    Toast.makeText(getApplicationContext(), "블루투스 기능을 켜지 않으면\n앱을 사용하실 수 없습니다.\n앱을 종료합니다.", Toast.LENGTH_LONG).show();
                    finish();
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public final void selectDevice() {
        
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(this.checkCallingOrSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PERMISSION_REQUEST_COARSE_LOCATION);
            }
        }
        pairedDevices = mBluetoothAdapter.getBondedDevices();
        final int mPairedDeviceCount = pairedDevices.size();

        if (mBluetoothAdapter.isDiscovering()) {
            mBluetoothAdapter.cancelDiscovery();
        }
        
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        this.registerReceiver(mReceiver, filter);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("힐링타임 연결"); 

        
        List<String> listItems = new ArrayList<String>();
        for (BluetoothDevice device : pairedDevices) {
            listItems.add(device.getName().toString());
        }
        
        listItems.add("새로운 기기 찾기");    
        listItems.add("취소");

        final CharSequence[] items = listItems.toArray(new CharSequence[listItems.size()]);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                if (item == mPairedDeviceCount) {
                    boolean chkdic =  mBluetoothAdapter.startDiscovery();
                    
                    
                } else if (item == mPairedDeviceCount+1) {
                    
                } else {
                    
                    
                    connectToSelectedDevices(items[item].toString());
                }
            }
        });
        builder.setCancelable(false);    
        AlertDialog alert = builder.create();
        alert.show();
    }

    BluetoothDevice getDeviceFromBondedList(String name) {
        BluetoothDevice selectedDevice = null;
        for(BluetoothDevice device : pairedDevices) {
            if(name.equals(device.getName())) {
                selectedDevice = device;
                break;
            }
        }
        return selectedDevice;
    }

    void connectToSelectedDevices(String selectedDeviceName) {
        String[] DeviceName = {};
        if(selectedDeviceName.indexOf("\n") != 0){
            DeviceName = selectedDeviceName.split("\n");
        }
        BluetoothDevice mRemoteDevice = null;
        if(!pairedChk) {
            mRemoteDevice = mBluetoothAdapter.getRemoteDevice(DeviceName[1]);
        }else{
            mRemoteDevice = getDeviceFromBondedList(DeviceName[0]);
        }
        UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
        try {
            
            mSocket = mRemoteDevice.createInsecureRfcommSocketToServiceRecord(uuid);
            mSocket.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(), "블루투스 연결 성공", Toast.LENGTH_SHORT).show();

        try {
            
            mOutputStream = mSocket.getOutputStream();
            mInputStream = mSocket.getInputStream();
            sendPacketToDevice();  
            receivePacketFromDevice(this); 
        } catch (Exception e) { 
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "블루투스 연결 중 오류  발생. 다시 시도하세요!", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    void receivePacketFromDevice(final Context context)
    {
        
        Runnable mRunnable = new Runnable() {
            @Override
            public void run() {
                int cnt = 1;
                byte [] read_data = new byte[13*5];  
                recv_packet = new byte[4][13];

                try { Thread.sleep(1000); } catch (InterruptedException e) {e.printStackTrace(); }
                while(threadCheck) {


                    try {
                        while (mInputStream.available() > 0) {
                            
                            try { Thread.sleep(1000); } catch (InterruptedException e) {e.printStackTrace(); }
                            mInputStream.read(read_data);
                            
                            System.arraycopy(read_data, 0, recv_packet[0], 0, 13);
                            System.arraycopy(read_data, 13, recv_packet[1], 0, 13);
                            System.arraycopy(read_data, 26, recv_packet[2], 0, 13);
                            System.arraycopy(read_data, 39, recv_packet[3], 0, 13);

                            
                            if ((recv_packet[0][0] != 0x10) && (recv_packet[1][0] != 0x10) && (recv_packet[2][0] != 0x10) && (recv_packet[3][0] != 0x10)) {
                                break;
                            }
                            SharedPreferences sp_color_setting = null;
                            sp_color_setting = getApplicationContext().getSharedPreferences("ColorSettings1", Context.MODE_PRIVATE);
                            if (recv_packet[0][0] == 0x10){
                                SharedPreferences.Editor editor = sp_color_setting.edit(); 
                                editor.commit();
                            }
                            
                            saveReceivedData();
                            Log.v("receivePacketFromDevice", "Thread: receive true");
                            packetReceiveSuccess = true;
                            
                            
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try { Thread.sleep(2000); } catch (InterruptedException e) {e.printStackTrace(); }
                }
            }
        };
        thread1 = new Thread(mRunnable);
        thread1.start();
    }

    void saveReceivedData(){

        
        SharedPreferences sp_color_settings = getApplicationContext().getSharedPreferences("ColorSettings1", Context.MODE_PRIVATE); 
        SharedPreferences.Editor editor = sp_color_settings.edit(); 
        editor.putInt("start_hour", recv_packet[0][2]); 
        editor.putInt("start_minute", recv_packet[0][3]); 
        editor.putInt("end_hour", recv_packet[0][4]); 
        editor.putInt("end_minute", recv_packet[0][5]); 
        editor.putInt("week_sum", recv_packet[0][6]); 
        editor.putInt("bright", recv_packet[0][7]); 
        editor.putInt("user_color_r", recv_packet[0][8]); 
        editor.putInt("user_color_g", recv_packet[0][9]); 
        editor.putInt("user_color_b", recv_packet[0][10]); 
        editor.putInt("type_onoff", recv_packet[0][11]); 
        if(recv_packet[0][2] == 0 && recv_packet[0][3] == 0 && recv_packet[0][4] == 0 && recv_packet[0][5] == 0) {
            editor.putInt("deleted", 1); 
        }
        else {
            editor.putInt("deleted", 0); 
        }
        editor.commit();

        
        SharedPreferences sp_aroma_settings_a = getApplicationContext().getSharedPreferences("aromaSettingsA", Context.MODE_PRIVATE); 
        SharedPreferences.Editor editor_aroma_a = sp_aroma_settings_a.edit(); 
        editor_aroma_a.putInt("start_hour", recv_packet[1][2]); 
        editor_aroma_a.putInt("start_minute", recv_packet[1][3]); 
        editor_aroma_a.putInt("end_hour", recv_packet[1][4]); 
        editor_aroma_a.putInt("end_minute", recv_packet[1][5]); 
        editor_aroma_a.putInt("week_sum", recv_packet[1][6]); 
        editor_aroma_a.putInt("repeat_cycle", recv_packet[1][7]); 
        editor_aroma_a.putInt("type_onoff", recv_packet[1][8]); 
        editor_aroma_a.putInt("spray_count", recv_packet[1][9]); 
        editor_aroma_a.putInt("set_or_direct", recv_packet[1][10]); 
        editor_aroma_a.putInt("spray_exist", recv_packet[1][11]); 
        editor_aroma_a.commit();

        
        SharedPreferences sp_aroma_settings_b = getApplicationContext().getSharedPreferences("aromaSettingsB", Context.MODE_PRIVATE); 
        SharedPreferences.Editor editor_aroma_b = sp_aroma_settings_b.edit();
        editor_aroma_b.putInt("start_hour", recv_packet[2][2]);
        editor_aroma_b.putInt("start_minute", recv_packet[2][3]);
        editor_aroma_b.putInt("end_hour", recv_packet[2][4]);
        editor_aroma_b.putInt("end_minute", recv_packet[2][5]);
        editor_aroma_b.putInt("week_sum", recv_packet[2][6]);
        editor_aroma_b.putInt("repeat_cycle", recv_packet[2][7]);
        editor_aroma_b.putInt("type_onoff", recv_packet[2][8]);
        editor_aroma_b.putInt("spray_count", recv_packet[2][9]);
        editor_aroma_b.putInt("set_or_direct", recv_packet[2][10]); 
        editor_aroma_b.putInt("spray_exist", recv_packet[2][11]); 
        editor_aroma_b.commit();

        
        SharedPreferences sp_aroma_settings_c = getApplicationContext().getSharedPreferences("aromaSettingsC", Context.MODE_PRIVATE); 
        SharedPreferences.Editor editor_aroma_c = sp_aroma_settings_c.edit(); 
        editor_aroma_c.putInt("start_hour", recv_packet[3][2]); 
        editor_aroma_c.putInt("start_minute", recv_packet[3][3]); 
        editor_aroma_c.putInt("end_hour", recv_packet[3][4]); 
        editor_aroma_c.putInt("end_minute", recv_packet[3][5]); 
        editor_aroma_c.putInt("week_sum", recv_packet[3][6]); 
        editor_aroma_c.putInt("repeat_cycle", recv_packet[3][7]); 
        editor_aroma_c.putInt("type_onoff", recv_packet[3][8]); 
        editor_aroma_c.putInt("spray_count", recv_packet[3][9]); 
        editor_aroma_c.putInt("set_or_direct", recv_packet[3][10]); 
        editor_aroma_c.putInt("spray_exist", recv_packet[3][11]); 
        editor_aroma_c.commit();
    }

    
    void sendPacketToDevice()
    {
        Runnable mRunnable = new Runnable() {
            @Override
            public void run() {
                
                sendRepeatPacket();
                try {Thread.sleep(1000); } catch (InterruptedException e) {e.printStackTrace(); }
                sendCurrentTime();
                try {Thread.sleep(4000); } catch (InterruptedException e) {e.printStackTrace(); }
                sendRepeatPacket();
                while(threadCheck) {
                    if(thread2.isInterrupted()) { Log.v("thread2 is interrupted","aaaa"); break;}  
                    try {Thread.sleep(5000); } catch (InterruptedException e) {e.printStackTrace(); }
                    sendRepeatPacket();
                    
                }
            }
        };
        thread2 = new Thread(mRunnable);
        thread2.start();
    }

    
    void sendRepeatPacket(){
        int bt_connect_tmp = 0x10; byte bt_connect = (byte)bt_connect_tmp;
        int data1_tmp = 0xF1; byte data1 = (byte) data1_tmp;
        int trailer_tmp = 0xFE; byte trailer = (byte)trailer_tmp;
        byte [] packet = {0x10, bt_connect, data1, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, trailer};
        try {
            ((MainActivity) MainActivity.mContext).mOutputStream.write(packet);
            
        }catch(Exception  e){
            e.printStackTrace();
        }
    }

    void sendCurrentTime(){
        String hour_min_sec = null;
        Date date = Calendar.getInstance().getTime();
        Calendar cal= Calendar.getInstance ();
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("kk:mm:ss");
        hour_min_sec = format.format(date);
        int nWeek = cal.get(Calendar.DAY_OF_WEEK);
        byte week_bit = 0x00;
        switch (nWeek){
            case 1: 
                week_bit =  7;                break;
            case 2:
                week_bit =  1;                break;
            case 3:
                week_bit =  2;                break;
            case 4:
                week_bit =  3;                break;
            case 5:
                week_bit =  4;                break;
            case 6:
                week_bit =  5;                break;
            case 7:
                week_bit =  6;                break;
        }
        String[] split_time = hour_min_sec.split(":");
        byte[] Send_Time = {0x10, 0x15, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, (byte)0xFE};
        Send_Time[2] = Integer.valueOf(split_time[0]).byteValue();
        Send_Time[3] = Integer.valueOf(split_time[1]).byteValue();
        Send_Time[4] = Integer.valueOf(split_time[2]).byteValue();
        Send_Time[5] = (byte)week_bit;

        try {
            mOutputStream.write(Send_Time);
            
        }catch(java.io.IOException e){
            e.printStackTrace();
        }
    }

    
    void bluetoothDisconnect(){
        int bt_disconnect_tmp = 0x1F; byte bt_disconnect = (byte)bt_disconnect_tmp;
        int data1_tmp = 0xF1; byte data1 = (byte) data1_tmp;
        int trailer_tmp = 0xFE; byte trailer = (byte)trailer_tmp;
        byte [] packet = {0x10, bt_disconnect, data1, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, trailer};
        try {
            ((MainActivity) MainActivity.mContext).mOutputStream.write(packet);
            
        }catch(Exception  e){
            e.printStackTrace();
        }
    }

    class DrawAromaRemain extends View {
        float remain_percent;
        int  x, y;
        public DrawAromaRemain(Context context) {
            super(context);
        }

        public DrawAromaRemain(Context context, float remain_percent, int x, int  y) {
            super(context);
            this.remain_percent = remain_percent;
            this.x = x;
            this.y = y;
        }

        public void onDraw(Canvas canvas) {
            
            Paint pnt = new Paint();
            pnt.setAntiAlias(true);
            pnt.setStyle(Paint.Style.STROKE);

            pnt.setColor(0xFF9EBC72);
            pnt.setStrokeWidth(18);
            canvas.drawOval(new RectF(x, y, x + 340, y + 340), pnt);

            pnt.setColor(0xFFFFFFFF);
            RectF rect = new RectF();
            rect.set(x, y, x + 340, y + 340);
            pnt.setStrokeWidth(18);
            canvas.drawArc(rect, 270 , -((360F/100F)*remain_percent), false, pnt);
        }
    }
}
