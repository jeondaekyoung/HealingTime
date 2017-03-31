package com.healingtime.healingtime_designrenew;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorChangedListener;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

public class ColorSettingsActivity extends AppCompatActivity {
    boolean user_color_select_status = false;
    private Integer user_color_rgb = 0;
    private Integer color_bright = 0;
    private Integer start_hour = 0, start_minute = 0, end_hour = 0, end_minute = 0;
    private Integer type_onoff = 0; 
    private Integer week_sum = 0;
    private boolean color_alarm_mon_onoff = false, color_alarm_tue_onoff = false, color_alarm_wed_onoff = false, color_alarm_thu_onoff = false, color_alarm_fri_onoff = false, color_alarm_sat_onoff = false, color_alarm_sun_onoff = false;
    SharedPreferences sp_color_setting;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_setting_layout);

        
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        getSupportActionBar().setTitle("작동시간 설정");
        
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF83A54E));

        final ToggleButton color_red_toggle = (ToggleButton) findViewById(R.id.color_red_toggle);
        final ToggleButton color_orange_toggle = (ToggleButton) findViewById(R.id.color_orange_toggle);
        final ToggleButton color_yellow_toggle = (ToggleButton) findViewById(R.id.color_yellow_toggle);
        final ToggleButton color_green_toggle = (ToggleButton) findViewById(R.id.color_green_toggle);
        final ToggleButton color_blue_toggle = (ToggleButton) findViewById(R.id.color_blue_toggle);
        final ToggleButton color_purple_toggle = (ToggleButton) findViewById(R.id.color_purple_toggle);
        final ToggleButton color_white_toggle = (ToggleButton) findViewById(R.id.color_white_toggle);
        final ToggleButton color_custom_toggle = (ToggleButton) findViewById(R.id.color_custom_toggle);
        final TextView color_alarm_desc = (TextView) findViewById(R.id.color_alarm_desc);

        color_red_toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (color_red_toggle.isChecked()) {
                    color_red_toggle.setChecked(true);
                    color_orange_toggle.setChecked(false);
                    color_yellow_toggle.setChecked(false);
                    color_green_toggle.setChecked(false);
                    color_blue_toggle.setChecked(false);
                    color_purple_toggle.setChecked(false);
                    color_white_toggle.setChecked(false);
                    color_custom_toggle.setChecked(false);
                    String[] color_data= getResources().getStringArray(R.array.color_red);
                    color_alarm_desc.setText(color_data[2]);
                } else {
                }
            }
        });
        color_orange_toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (color_orange_toggle.isChecked()) {
                    color_red_toggle.setChecked(false);
                    color_orange_toggle.setChecked(true);
                    color_yellow_toggle.setChecked(false);
                    color_green_toggle.setChecked(false);
                    color_blue_toggle.setChecked(false);
                    color_purple_toggle.setChecked(false);
                    color_white_toggle.setChecked(false);
                    color_custom_toggle.setChecked(false);
                    String[] color_data= getResources().getStringArray(R.array.color_orange);
                    color_alarm_desc.setText(color_data[2]);
                } else {
                }
            }
        });
        color_yellow_toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (color_yellow_toggle.isChecked()) {
                    color_red_toggle.setChecked(false);
                    color_orange_toggle.setChecked(false);
                    color_yellow_toggle.setChecked(true);
                    color_green_toggle.setChecked(false);
                    color_blue_toggle.setChecked(false);
                    color_purple_toggle.setChecked(false);
                    color_white_toggle.setChecked(false);
                    color_custom_toggle.setChecked(false);
                    String[] color_data= getResources().getStringArray(R.array.color_yellow);
                    color_alarm_desc.setText(color_data[2]);
                } else {
                }
            }
        });
        color_green_toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (color_green_toggle.isChecked()) {
                    color_red_toggle.setChecked(false);
                    color_orange_toggle.setChecked(false);
                    color_yellow_toggle.setChecked(false);
                    color_green_toggle.setChecked(true);
                    color_blue_toggle.setChecked(false);
                    color_purple_toggle.setChecked(false);
                    color_white_toggle.setChecked(false);
                    color_custom_toggle.setChecked(false);
                    String[] color_data= getResources().getStringArray(R.array.color_green);
                    color_alarm_desc.setText(color_data[2]);
                } else {
                }
            }
        });
        color_blue_toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (color_blue_toggle.isChecked()) {
                    color_red_toggle.setChecked(false);
                    color_orange_toggle.setChecked(false);
                    color_yellow_toggle.setChecked(false);
                    color_green_toggle.setChecked(false);
                    color_blue_toggle.setChecked(true);
                    color_purple_toggle.setChecked(false);
                    color_white_toggle.setChecked(false);
                    color_custom_toggle.setChecked(false);
                    String[] color_data= getResources().getStringArray(R.array.color_blue);
                    color_alarm_desc.setText(color_data[2]);
                } else {
                }
            }
        });
        color_purple_toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (color_purple_toggle.isChecked()) {
                    color_red_toggle.setChecked(false);
                    color_orange_toggle.setChecked(false);
                    color_yellow_toggle.setChecked(false);
                    color_green_toggle.setChecked(false);
                    color_blue_toggle.setChecked(false);
                    color_purple_toggle.setChecked(true);
                    color_white_toggle.setChecked(false);
                    color_custom_toggle.setChecked(false);
                    String[] color_data= getResources().getStringArray(R.array.color_purple);
                    color_alarm_desc.setText(color_data[2]);
                } else {
                }
            }
        });
        color_white_toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (color_white_toggle.isChecked()) {
                    color_red_toggle.setChecked(false);
                    color_orange_toggle.setChecked(false);
                    color_yellow_toggle.setChecked(false);
                    color_green_toggle.setChecked(false);
                    color_blue_toggle.setChecked(false);
                    color_purple_toggle.setChecked(false);
                    color_white_toggle.setChecked(true);
                    color_custom_toggle.setChecked(false);
                    String[] color_data= getResources().getStringArray(R.array.color_white);
                    color_alarm_desc.setText(color_data[2]);
                } else {
                }
            }
        });
        color_custom_toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (color_custom_toggle.isChecked()) {
                    color_red_toggle.setChecked(false);
                    color_orange_toggle.setChecked(false);
                    color_yellow_toggle.setChecked(false);
                    color_green_toggle.setChecked(false);
                    color_blue_toggle.setChecked(false);
                    color_purple_toggle.setChecked(false);
                    color_white_toggle.setChecked(false);
                    color_custom_toggle.setChecked(true);
                    color_alarm_desc.setText("사용자 설정");
                    final Context context = ColorSettingsActivity.this;
                    ColorPickerDialogBuilder
                        .with(context)
                        .setTitle("Choose Color")
                        .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                        .density(12)
                        .setOnColorChangedListener(new OnColorChangedListener() {
                            @Override
                            public void onColorChanged(int selectedColor) {
                                
                                Log.d("ColorPicker", "onColorChanged: 0x" + Integer.toHexString(selectedColor));
                            }
                        })
                        .setOnColorSelectedListener(new OnColorSelectedListener() {
                            @Override
                            public void onColorSelected(int selectedColor) {
                                Toast.makeText(getApplicationContext(), "onColorSelected: 0x" + Integer.toHexString(selectedColor), Toast.LENGTH_LONG).show();
                            }
                        })
                        .setPositiveButton("ok", new ColorPickerClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {
                                user_color_select_status = true;
                                user_color_rgb = selectedColor;
                                View color_user_rgb = (View) findViewById(R.id.color_user_rgb);
                                color_user_rgb.setBackgroundColor(user_color_rgb);
                                if (allColors != null) {
                                    StringBuilder sb = null;
                                    for (Integer color : allColors) {
                                        if (color == null)
                                            continue;
                                        if (sb == null)
                                            sb = new StringBuilder("Color List:");
                                        sb.append("\r\n#" + Integer.toHexString(color).toUpperCase());
                                    }
                                    if (sb != null)
                                        Toast.makeText(getApplicationContext(), sb.toString(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .showColorEdit(true)
                        .setColorEditTextColor(ContextCompat.getColor(ColorSettingsActivity.this, android.R.color.holo_blue_bright))
                        .build()
                        .show();
                } else {
                }
            }
        });

        
        final SeekBar color_alarm_bright_seekbar = (SeekBar) findViewById(R.id.color_alarm_bright_seekbar);
        color_alarm_bright_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            public void onProgressChanged(SeekBar seekBar, int bright, boolean fromUser){
                color_bright = bright;

                if (color_bright < 1) {
                    color_bright = 1;
                    color_alarm_bright_seekbar.setProgress(color_bright);
                }
                Integer bright_percent = color_bright * 10;
                TextView color_alarm_bright_value = (TextView) findViewById(R.id.color_alarm_bright_value);
                color_alarm_bright_value.setText(bright_percent.toString());
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        
        TextView color_alarm_starttime = (TextView) findViewById(R.id.color_alarm_starttime);
        color_alarm_starttime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp_color_setting = getApplicationContext().getSharedPreferences("ColorSettings1", Context.MODE_PRIVATE);
                Integer start_hour = sp_color_setting.getInt("start_hour", 0);  
                Integer start_minute = sp_color_setting.getInt("start_minute", 0); 
                TimePickerDialog color_starttime_dialog = new TimePickerDialog(ColorSettingsActivity.this, color_starttime_dialog_listener, start_hour, start_minute, true);
                color_starttime_dialog.show();
            }
        });

        
        TextView color_alarm_endtime = (TextView) findViewById(R.id.color_alarm_endtime);
        color_alarm_endtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp_color_setting = getApplicationContext().getSharedPreferences("ColorSettings1", Context.MODE_PRIVATE);
                Integer end_hour = sp_color_setting.getInt("end_hour", 0);  
                Integer end_minute = sp_color_setting.getInt("end_minute", 0); 
                TimePickerDialog color_endtime_dialog = new TimePickerDialog(ColorSettingsActivity.this, color_endtime_dialog_listener, end_hour, end_minute, true);
                color_endtime_dialog.show();
            }
        });

        
        final TextView color_alarm_btn_mon = (TextView) findViewById(R.id.color_alarm_btn_mon);
        color_alarm_btn_mon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(color_alarm_mon_onoff == true){
                    color_alarm_mon_onoff = false;
                    color_alarm_btn_mon.setText("월");
                    color_alarm_btn_mon.setBackgroundResource(R.drawable.circle_btn_gray);
                } else if(color_alarm_mon_onoff == false){
                    color_alarm_mon_onoff = true;
                    color_alarm_btn_mon.setText("월");
                    color_alarm_btn_mon.setBackgroundResource(R.drawable.circle_btn_green);
                }
            }
        });
        final TextView color_alarm_btn_tue = (TextView) findViewById(R.id.color_alarm_btn_tue);
        color_alarm_btn_tue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(color_alarm_tue_onoff == true){
                    color_alarm_tue_onoff = false;
                    color_alarm_btn_tue.setText("화");
                    color_alarm_btn_tue.setBackgroundResource(R.drawable.circle_btn_gray);
                } else if(color_alarm_tue_onoff == false){
                    color_alarm_tue_onoff = true;
                    color_alarm_btn_tue.setText("화");
                    color_alarm_btn_tue.setBackgroundResource(R.drawable.circle_btn_green);
                }
            }
        });
        final TextView color_alarm_btn_wed = (TextView) findViewById(R.id.color_alarm_btn_wed);
        color_alarm_btn_wed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(color_alarm_wed_onoff == true){
                    color_alarm_wed_onoff = false;
                    color_alarm_btn_wed.setText("수");
                    color_alarm_btn_wed.setBackgroundResource(R.drawable.circle_btn_gray);
                } else if(color_alarm_wed_onoff == false){
                    color_alarm_wed_onoff = true;
                    color_alarm_btn_wed.setText("수");
                    color_alarm_btn_wed.setBackgroundResource(R.drawable.circle_btn_green);
                }
            }
        });
        final TextView color_alarm_btn_thu = (TextView) findViewById(R.id.color_alarm_btn_thu);
        color_alarm_btn_thu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(color_alarm_thu_onoff == true){
                    color_alarm_thu_onoff = false;
                    color_alarm_btn_thu.setText("목");
                    color_alarm_btn_thu.setBackgroundResource(R.drawable.circle_btn_gray);
                } else if(color_alarm_thu_onoff == false){
                    color_alarm_thu_onoff = true;
                    color_alarm_btn_thu.setText("목");
                    color_alarm_btn_thu.setBackgroundResource(R.drawable.circle_btn_green);
                }
            }
        });
        final TextView color_alarm_btn_fri = (TextView) findViewById(R.id.color_alarm_btn_fri);
        color_alarm_btn_fri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(color_alarm_fri_onoff == true){
                    color_alarm_fri_onoff = false;
                    color_alarm_btn_fri.setText("금");
                    color_alarm_btn_fri.setBackgroundResource(R.drawable.circle_btn_gray);
                } else if(color_alarm_fri_onoff == false){
                    color_alarm_fri_onoff = true;
                    color_alarm_btn_fri.setText("금");
                    color_alarm_btn_fri.setBackgroundResource(R.drawable.circle_btn_green);
                }
            }
        });
        final TextView color_alarm_btn_sat = (TextView) findViewById(R.id.color_alarm_btn_sat);
        color_alarm_btn_sat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(color_alarm_sat_onoff == true){
                    color_alarm_sat_onoff = false;
                    color_alarm_btn_sat.setText("토");
                    color_alarm_btn_sat.setBackgroundResource(R.drawable.circle_btn_gray);
                } else if(color_alarm_sat_onoff == false){
                    color_alarm_sat_onoff = true;
                    color_alarm_btn_sat.setText("토");
                    color_alarm_btn_sat.setBackgroundResource(R.drawable.circle_btn_green);
                }
            }
        });
        final TextView color_alarm_btn_sun = (TextView) findViewById(R.id.color_alarm_btn_sun);
        color_alarm_btn_sun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(color_alarm_sun_onoff == true){
                    color_alarm_sun_onoff = false;
                    color_alarm_btn_sun.setText("일");
                    color_alarm_btn_sun.setBackgroundResource(R.drawable.circle_btn_gray);
                } else if(color_alarm_sun_onoff == false){
                    color_alarm_sun_onoff = true;
                    color_alarm_btn_sun.setText("일");
                    color_alarm_btn_sun.setBackgroundResource(R.drawable.circle_btn_green);
                }
            }
        });

        
        Button color_therapy_time_settings_cancel = (Button) findViewById(R.id.color_alarm_cancel);
        color_therapy_time_settings_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                onBackPressed();
            }
        });

        
        Button color_alarm_save = (Button) findViewById(R.id.color_alarm_save);
        color_alarm_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                if(color_red_toggle.isChecked()){ type_onoff = 1;}  
                else if(color_orange_toggle.isChecked()){ type_onoff = 2;}  
                else if(color_yellow_toggle.isChecked()){ type_onoff = 3; }  
                else if(color_green_toggle.isChecked()){ type_onoff = 4;}  
                else if(color_blue_toggle.isChecked()){ type_onoff = 5;}  
                else if(color_purple_toggle.isChecked()){ type_onoff = 6;}  
                else if(color_white_toggle.isChecked()){ type_onoff = 7;}  
                else if(color_custom_toggle.isChecked()){ type_onoff = 8;} 
                type_onoff = type_onoff | 0x40 ; 

                
                if(color_alarm_sun_onoff == true) { week_sum += 0x40; }
                if(color_alarm_mon_onoff == true) { week_sum += 0x20; }
                if(color_alarm_tue_onoff == true) { week_sum += 0x10; }
                if(color_alarm_wed_onoff == true) { week_sum += 0x08; }
                if(color_alarm_thu_onoff == true) { week_sum += 0x04; }
                if(color_alarm_fri_onoff == true) { week_sum += 0x02; }
                if(color_alarm_sat_onoff == true) { week_sum += 0x01; }


                
                byte[] rgbArray = new byte[4];
                rgbArray[2] = (byte)(user_color_rgb >> 16); 
                rgbArray[1] = (byte)(user_color_rgb >> 8);
                rgbArray[0] = (byte)(user_color_rgb >> 0); 
                if((rgbArray[2] & 0xF0) == 0xF0) { rgbArray[2] = (byte)0xF0;} 
                if((rgbArray[1] & 0xF0) == 0xF0) { rgbArray[1] = (byte)0xF0;} 
                if((rgbArray[0] & 0xF0) == 0xF0) { rgbArray[0] = (byte)0xF0;} 

                
                if(color_custom_toggle.isChecked() && !user_color_select_status){
                    Toast.makeText(getApplicationContext(), "색상을 선택해주세요.", Toast.LENGTH_LONG).show();
                    SharedPreferences sp_color_setting = getApplicationContext().getSharedPreferences("ColorSettings1", Context.MODE_PRIVATE);
                    Integer color_info = sp_color_setting.getInt("type_onoff", 0); 
                    int type_onoff = color_info & 0x0F; 

                    
                    switch(type_onoff){
                        case 1:
                            color_red_toggle.setChecked(true);
                            break;
                        case 2:
                            color_orange_toggle.setChecked(true);
                            break;
                        case 3:
                            color_yellow_toggle.setChecked(true);
                            break;
                        case 4:
                            color_green_toggle.setChecked(true);
                            break;
                        case 5:
                            color_blue_toggle.setChecked(true);
                            break;
                        case 6:
                            color_purple_toggle.setChecked(true);
                            break;
                        case 7:
                            color_white_toggle.setChecked(true);
                            break;
                        case 8:
                            color_custom_toggle.setChecked(true);
                            break;
                    }
                    return;
                }

                SharedPreferences sp_color_setting = null;
                Integer alarm_no = getIntent().getExtras().getInt("alarm_no");
                switch (alarm_no){
                    case 1:
                        sp_color_setting = getApplicationContext().getSharedPreferences("ColorSettings1", Context.MODE_PRIVATE); 
                        break;
                    case 2:
                        sp_color_setting = getApplicationContext().getSharedPreferences("ColorSettings2", Context.MODE_PRIVATE); 
                        break;
                    case 3:
                        sp_color_setting = getApplicationContext().getSharedPreferences("ColorSettings3", Context.MODE_PRIVATE); 
                        break;
                }

                SharedPreferences.Editor editor = sp_color_setting.edit(); 
                editor.putInt("start_hour",start_hour); 
                editor.putInt("start_minute",start_minute); 
                editor.putInt("end_hour",end_hour); 
                editor.putInt("end_minute",end_minute); 
                editor.putInt("week_sum",week_sum); 
                editor.putInt("bright", color_bright); 
                editor.putInt("user_color_r", rgbArray[2]); 
                editor.putInt("user_color_g", rgbArray[1]); 
                editor.putInt("user_color_b", rgbArray[0]); 
                editor.putInt("type_onoff", type_onoff); 
                editor.putInt("deleted", 0); 
                editor.commit();

                
                int finchk = 254;
                int s_hour = start_hour, s_min=start_minute, e_hour = end_hour, e_min = end_minute, w_sum = week_sum;
                int c_bright = color_bright, c_type = type_onoff; c_type = c_type | 0x40 ; 

                
                byte start_frame = (byte) 0x10; 
                byte type_frame = (byte) 0x11;
                byte start_hour = (byte) s_hour;
                byte start_min = (byte) s_min;
                byte end_hour = (byte) e_hour;
                byte end_min = (byte) e_min;
                byte week_sum = (byte) w_sum;
                byte color_bright = (byte) c_bright;
                byte rgb_r = rgbArray[2];
                byte rgb_g = rgbArray[1];
                byte rgb_b = rgbArray[0];
                byte type_onoff = (byte) c_type;
                byte fin_frame = (byte) finchk;
                byte [] color_set = {start_frame, type_frame, start_hour, start_min, end_hour, end_min, week_sum, color_bright, rgb_r, rgb_g, rgb_b, type_onoff, fin_frame};

                try {
                    ((MainActivity) MainActivity.mContext).mOutputStream.write(color_set);
                }catch(Exception  e){
                    e.printStackTrace();
                }
                
                onBackPressed();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        Integer alarm_no = getIntent().getExtras().getInt("alarm_no");
        switch (alarm_no){
            case 0:
                Toast.makeText(getApplicationContext(), "예약정보가 없습니다.", Toast.LENGTH_LONG).show();
                finish();
                break;
            case 1:
                sp_color_setting = getApplicationContext().getSharedPreferences("ColorSettings1", Context.MODE_PRIVATE); 
                break;
            case 2:
                sp_color_setting = getApplicationContext().getSharedPreferences("ColorSettings2", Context.MODE_PRIVATE); 
                break;
            case 3:
                sp_color_setting = getApplicationContext().getSharedPreferences("ColorSettings3", Context.MODE_PRIVATE); 
                break;
        }

        Integer start_hour = sp_color_setting.getInt("start_hour", 0);  
        Integer start_minute = sp_color_setting.getInt("start_minute", 0); 
        Integer end_hour = sp_color_setting.getInt("end_hour", 0); 
        Integer end_minute = sp_color_setting.getInt("end_minute", 0); 
        Integer week_sum = sp_color_setting.getInt("week_sum", 0); 
        Integer color_bright = sp_color_setting.getInt("bright", 10); 
        Integer rgb_r = sp_color_setting.getInt("user_color_r", 0); 
        Integer rgb_g = sp_color_setting.getInt("user_color_g", 0); 
        Integer rgb_b = sp_color_setting.getInt("user_color_b", 0); 
        Integer color_info = sp_color_setting.getInt("type_onoff", 0); 

        int type_onoff = color_info & 0x0F; 

        
        ToggleButton color_red_toggle = (ToggleButton) findViewById(R.id.color_red_toggle);
        ToggleButton color_orange_toggle = (ToggleButton) findViewById(R.id.color_orange_toggle);
        ToggleButton color_yellow_toggle = (ToggleButton) findViewById(R.id.color_yellow_toggle);
        ToggleButton color_green_toggle = (ToggleButton) findViewById(R.id.color_green_toggle);
        ToggleButton color_blue_toggle = (ToggleButton) findViewById(R.id.color_blue_toggle);
        ToggleButton color_purple_toggle = (ToggleButton) findViewById(R.id.color_purple_toggle);
        ToggleButton color_white_toggle = (ToggleButton) findViewById(R.id.color_white_toggle);
        ToggleButton color_custom_toggle = (ToggleButton) findViewById(R.id.color_custom_toggle);
        switch(type_onoff){
            case 1:
                color_red_toggle.setChecked(true);
                break;
            case 2:
                color_orange_toggle.setChecked(true);
                break;
            case 3:
                color_yellow_toggle.setChecked(true);
                break;
            case 4:
                color_green_toggle.setChecked(true);
                break;
            case 5:
                color_blue_toggle.setChecked(true);
                break;
            case 6:
                color_purple_toggle.setChecked(true);
                break;
            case 7:
                color_white_toggle.setChecked(true);
                break;
            case 8:
                color_custom_toggle.setChecked(true);
                View color_user_rgb = (View) findViewById(R.id.color_user_rgb);
                int temp0 = 0xFF000000;
                int temp1 = (rgb_r & 0x000000FF) << 16;
                int temp2 = (rgb_g & 0x000000FF) << 8;
                int temp3 = (rgb_b & 0x000000FF) << 0;
                int user_color = temp0 | temp1 | temp2 | temp3;
                color_user_rgb.setBackgroundColor(user_color);
                break;
        }

        
        final SeekBar color_alarm_bright_seekbar = (SeekBar) findViewById(R.id.color_alarm_bright_seekbar);
        color_alarm_bright_seekbar.setProgress(color_bright);
        Integer bright_percent = color_bright * 10;
        TextView color_alarm_bright_value = (TextView) findViewById(R.id.color_alarm_bright_value);
        color_alarm_bright_value.setText(bright_percent.toString());

        
        String AM_PM ;
        this.start_hour = start_hour;
        this.start_minute = start_minute;
        int start_hour_12 = 0;
        if(start_hour < 12) { AM_PM = "오전"; start_hour_12 = start_hour; }
        else { AM_PM = "오후"; start_hour_12 = start_hour - 12;}
        final TextView color_starttime_textview = (TextView) findViewById(R.id.color_alarm_starttime);
        color_starttime_textview.setText(AM_PM + " " + String.format("%02d",start_hour_12) + "시 " + String.format("%02d",start_minute) + "분");

        
        int end_hour_12 = 0;
        this.end_hour = end_hour;
        this.end_minute = end_minute;
        if(end_hour < 12) { AM_PM = "오전"; end_hour_12 = end_hour; }
        else { AM_PM = "오후"; end_hour_12 = end_hour - 12;}
        TextView color_endtime_textview = (TextView) findViewById(R.id.color_alarm_endtime);
        color_endtime_textview.setText(AM_PM + " " + String.format("%02d",end_hour_12) + "시 " + String.format("%02d",end_minute) + "분");

        
        Button color_alarm_btn_sun = (Button) findViewById(R.id.color_alarm_btn_sun);
        Button color_alarm_btn_mon = (Button) findViewById(R.id.color_alarm_btn_mon);
        Button color_alarm_btn_tue = (Button) findViewById(R.id.color_alarm_btn_tue);
        Button color_alarm_btn_wed = (Button) findViewById(R.id.color_alarm_btn_wed);
        Button color_alarm_btn_thu = (Button) findViewById(R.id.color_alarm_btn_thu);
        Button color_alarm_btn_fri = (Button) findViewById(R.id.color_alarm_btn_fri);
        Button color_alarm_btn_sat = (Button) findViewById(R.id.color_alarm_btn_sat);
        byte sunday_bit = 0x40, monday_bit = 0x20, tuesday_bit = 0x10, wednesday_bit = 0x08, thursday_bit = 0x04, friday_bit = 0x02, saturday_bit = 0x01;
        if ((week_sum & sunday_bit) == sunday_bit) {
            color_alarm_btn_sun.setBackgroundResource(R.drawable.circle_btn_green);
            color_alarm_sun_onoff = true; }
        if ((week_sum & monday_bit) == monday_bit) {
            color_alarm_btn_mon.setBackgroundResource(R.drawable.circle_btn_green);
            color_alarm_mon_onoff = true; }
        if ((week_sum & tuesday_bit) == tuesday_bit) {
            color_alarm_btn_tue.setBackgroundResource(R.drawable.circle_btn_green);
            color_alarm_tue_onoff = true; }
        if ((week_sum & wednesday_bit) == wednesday_bit) {
            color_alarm_btn_wed.setBackgroundResource(R.drawable.circle_btn_green);
            color_alarm_wed_onoff = true; }
        if ((week_sum & thursday_bit) == thursday_bit) {
            color_alarm_btn_thu.setBackgroundResource(R.drawable.circle_btn_green);
            color_alarm_thu_onoff = true; }
        if ((week_sum & friday_bit) == friday_bit) {
            color_alarm_btn_fri.setBackgroundResource(R.drawable.circle_btn_green);
            color_alarm_fri_onoff = true; }
        if ((week_sum & saturday_bit) == saturday_bit) {
            color_alarm_btn_sat.setBackgroundResource(R.drawable.circle_btn_green);
            color_alarm_sat_onoff = true; }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:   
                
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private TimePickerDialog.OnTimeSetListener color_starttime_dialog_listener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) { 
            start_hour = hourOfDay;
            start_minute = minute;

            
            String AM_PM ;
            int start_hour_12 = 0;
            if(hourOfDay < 12) { AM_PM = "오전"; start_hour_12 = start_hour;  }
            else if(hourOfDay == 12 ){AM_PM = "오후"; start_hour_12 = start_hour;}
            else { AM_PM = "오후"; start_hour_12 = start_hour - 12; }

            
            final TextView color_starttime_textview = (TextView) findViewById(R.id.color_alarm_starttime);
            color_starttime_textview.setText(AM_PM + " " + String.format("%02d",start_hour_12) + "시 " + String.format("%02d", start_minute) + "분");
        }
    };

    private TimePickerDialog.OnTimeSetListener color_endtime_dialog_listener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) { 
            end_hour = hourOfDay;
            end_minute = minute;

            
            String AM_PM ;
            int end_hour_12 = 0;
            if(hourOfDay < 12) { AM_PM = "오전"; end_hour_12 = end_hour;  }
            else if(hourOfDay == 12 ){AM_PM = "오후"; end_hour_12 = end_hour;}
            else { AM_PM = "오후"; end_hour_12 = end_hour - 12; }

            
            final TextView color_endtime_textview = (TextView) findViewById(R.id.color_alarm_endtime);
            color_endtime_textview.setText(AM_PM + " " + String.format("%02d",end_hour_12) + "시 " + String.format("%02d", end_minute) + "분");
        }
    };
}
