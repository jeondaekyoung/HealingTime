package com.healingtime.healingtime_designrenew;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class AromaRemainActivity extends AppCompatActivity {
    Integer remain_amount = 50;
    int spray_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aroma_remain_layout);

        
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        getSupportActionBar().setTitle("잔여량 설정");
        
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF83A54E));

        
        Button aroma_remain_modify_a = (Button) findViewById(R.id.aroma_remain_modify_a);
        aroma_remain_modify_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View innerView = getLayoutInflater().inflate(R.layout.aroma_remain_modify_dialog, null);

                int spray_count = 0;
                SharedPreferences sp_aroma_settings = null;
                byte remain = 0;
                int spray_count_temp = 0;
                float used_percent = 0, remain_percent = 0;
                int temp = 0;
                TextView aroma_remaining_percent = null;
                sp_aroma_settings = getApplicationContext().getSharedPreferences("aromaSettingsA", Context.MODE_PRIVATE); 
                spray_count = sp_aroma_settings.getInt("spray_count", 0); 
                remain = (byte) spray_count;
                spray_count_temp = (int)remain & 0xFF; 
                
                used_percent = (float)spray_count_temp * (float)10 / (float)24; 
                remain_percent = 100F - used_percent; 
                
                aroma_remaining_percent = (TextView) findViewById(R.id.aroma_remaining_percent_a);
                temp = (int)remain_percent;
                aroma_remaining_percent.setText(String.valueOf(temp) + "%");
                final SeekBar aroma_remaining_seekbar_a = (SeekBar) innerView.findViewById(R.id.aroma_remain_seekbar);
                final TextView aroma_remain_textview_a = (TextView) innerView.findViewById(R.id.aroma_remain_textview);
                aroma_remaining_seekbar_a.setProgress(remain_amount);
                aroma_remain_textview_a.setText(remain_amount.toString() + "%");

                AlertDialog.Builder adialog = new AlertDialog.Builder(AromaRemainActivity.this);
                adialog.setView(innerView);
                adialog.setPositiveButton("적용", new DialogInterface.OnClickListener() { public void onClick(
                        DialogInterface dialog, int id) {
                    remainChangeSave_A();   
                } });
                adialog.setNegativeButton("취소", new DialogInterface.OnClickListener() { public void onClick(
                        DialogInterface dialog, int id) {
                    dialog.cancel();
                } });

                
                aroma_remaining_seekbar_a.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    public void onProgressChanged(SeekBar seekBar, int remain, boolean fromUser) {
                        remain_amount = remain;
                        if (remain_amount < 1) {
                            remain_amount = 1;
                            aroma_remaining_seekbar_a.setProgress(remain_amount);
                        }
                        aroma_remain_textview_a.setText(remain_amount.toString() + "%");
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) { }
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) { }
                });
                AlertDialog alert = adialog.create();
                alert.setTitle("잔여량 설정");
                alert.show();
            }
        });

        
        Button aroma_remain_modify_b = (Button) findViewById(R.id.aroma_remain_modify_b);
        aroma_remain_modify_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View innerView = getLayoutInflater().inflate(R.layout.aroma_remain_modify_dialog, null);

                int spray_count = 0;
                SharedPreferences sp_aroma_settings = null;
                byte remain = 0;
                int spray_count_temp = 0;
                float used_percent = 0, remain_percent = 0;
                int temp = 0;
                TextView aroma_remaining_percent = null;
                sp_aroma_settings = getApplicationContext().getSharedPreferences("aromaSettingsB", Context.MODE_PRIVATE); 
                spray_count = sp_aroma_settings.getInt("spray_count", 0); 
                remain = (byte) spray_count;
                spray_count_temp = (int)remain & 0xFF; 
                
                used_percent = (float)spray_count_temp * (float)10 / (float)24; 
                remain_percent = 100F - used_percent; 
                
                aroma_remaining_percent = (TextView) findViewById(R.id.aroma_remaining_percent_b);
                temp = (int)remain_percent;
                aroma_remaining_percent.setText(String.valueOf(temp) + "%");
                final SeekBar aroma_remaining_seekbar_b = (SeekBar) innerView.findViewById(R.id.aroma_remain_seekbar);
                final TextView aroma_remain_textview_b = (TextView) innerView.findViewById(R.id.aroma_remain_textview);
                aroma_remaining_seekbar_b.setProgress(remain_amount);
                aroma_remain_textview_b.setText(remain_amount.toString() + "%");

                AlertDialog.Builder adialog = new AlertDialog.Builder(AromaRemainActivity.this);
                adialog.setView(innerView);
                adialog.setPositiveButton("적용", new DialogInterface.OnClickListener() { public void onClick(
                        DialogInterface dialog, int id) {
                    remainChangeSave_B();   
                } });
                adialog.setNegativeButton("취소", new DialogInterface.OnClickListener() { public void onClick(
                        DialogInterface dialog, int id) {
                    dialog.cancel();
                } });

                
                aroma_remaining_seekbar_b.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    public void onProgressChanged(SeekBar seekBar, int remain, boolean fromUser) {
                        remain_amount = remain;
                        if (remain_amount < 1) {
                            remain_amount = 1;
                            aroma_remaining_seekbar_b.setProgress(remain_amount);
                        }
                        aroma_remain_textview_b.setText(remain_amount.toString() + "%");
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) { }
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) { }
                });
                AlertDialog alert = adialog.create();
                alert.setTitle("잔여량 설정");
                alert.show();
            }
        });

        
        Button aroma_remain_modify_c = (Button) findViewById(R.id.aroma_remain_modify_c);
        aroma_remain_modify_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View innerView = getLayoutInflater().inflate(R.layout.aroma_remain_modify_dialog, null);

                int spray_count = 0;
                SharedPreferences sp_aroma_settings = null;
                byte remain = 0;
                int spray_count_temp = 0;
                float used_percent = 0, remain_percent = 0;
                int temp = 0;
                TextView aroma_remaining_percent = null;
                sp_aroma_settings = getApplicationContext().getSharedPreferences("aromaSettingC", Context.MODE_PRIVATE); 
                spray_count = sp_aroma_settings.getInt("spray_count", 0); 
                remain = (byte) spray_count;
                spray_count_temp = (int)remain & 0xFF; 
                
                used_percent = (float)spray_count_temp * (float)10 / (float)24; 
                remain_percent = 100F - used_percent; 
                
                aroma_remaining_percent = (TextView) findViewById(R.id.aroma_remaining_percent_c);
                temp = (int)remain_percent;
                aroma_remaining_percent.setText(String.valueOf(temp) + "%");
                final SeekBar aroma_remaining_seekbar_c = (SeekBar) innerView.findViewById(R.id.aroma_remain_seekbar);
                final TextView aroma_remain_textview_c = (TextView) innerView.findViewById(R.id.aroma_remain_textview);
                aroma_remaining_seekbar_c.setProgress(remain_amount);
                aroma_remain_textview_c.setText(remain_amount.toString() + "%");

                AlertDialog.Builder adialog = new AlertDialog.Builder(AromaRemainActivity.this);
                adialog.setView(innerView);
                adialog.setPositiveButton("적용", new DialogInterface.OnClickListener() { public void onClick(
                        DialogInterface dialog, int id) {
                    remainChangeSave_C();   
                } });
                adialog.setNegativeButton("취소", new DialogInterface.OnClickListener() { public void onClick(
                        DialogInterface dialog, int id) {
                    dialog.cancel();
                } });

                
                aroma_remaining_seekbar_c.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    public void onProgressChanged(SeekBar seekBar, int remain, boolean fromUser) {
                        remain_amount = remain;
                        if (remain_amount < 1) {
                            remain_amount = 1;
                            aroma_remaining_seekbar_c.setProgress(remain_amount);
                        }
                        aroma_remain_textview_c.setText(remain_amount.toString() + "%");
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) { }
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) { }
                });
                AlertDialog alert = adialog.create();
                alert.setTitle("잔여량 설정");
                alert.show();
            }
        });

        Button aroma_remain_cancel = (Button) findViewById(R.id.aroma_remain_cancel);
        aroma_remain_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        
        
        SharedPreferences sp_aroma_settings = getApplicationContext().getSharedPreferences("aromaSettingsA", Context.MODE_PRIVATE); 
        spray_count = sp_aroma_settings.getInt("spray_count", 0); 
        byte remain = (byte) spray_count;
        int spray_count_temp = (int)remain & 0xFF; 
        
        float used_percent = (float)spray_count_temp * (float)10 / (float)24; 
        float remain_percent = 100F - used_percent; 
        
        View aroma_remain_view_a = (View) findViewById(R.id.aroma_remain_view_a);
        ViewGroup.LayoutParams params = aroma_remain_view_a.getLayoutParams();
        float scale = getResources().getDisplayMetrics().density;
        params.height = (int) (remain_percent * 2 * scale) ; 
        aroma_remain_view_a.setLayoutParams(params);
        
        TextView aroma_remaining_percent = (TextView) findViewById(R.id.aroma_remaining_percent_a);
        int temp = (int)remain_percent;
        aroma_remaining_percent.setText(String.valueOf(temp) + "%");
        
        TextView aroma_remaining_ml = (TextView) findViewById(R.id.aroma_remaining_ml_a);
        temp = 240 - (int)spray_count_temp;
        aroma_remaining_ml.setText(String.valueOf(temp) + "ml");

        
        
        sp_aroma_settings = getApplicationContext().getSharedPreferences("aromaSettingsB", Context.MODE_PRIVATE); 
        spray_count = sp_aroma_settings.getInt("spray_count", 7); 
        remain = (byte) spray_count;
        spray_count_temp = (int)remain & 0xFF; 
        
        used_percent = (float)spray_count_temp * (float)10 / (float)24; 
        remain_percent = 100F - used_percent; 
        
        aroma_remain_view_a = (View) findViewById(R.id.aroma_remain_view_b);
        params = aroma_remain_view_a.getLayoutParams();
        scale = getResources().getDisplayMetrics().density;
        
        params.height = (int) (remain_percent * 2 * scale) ; 
        aroma_remain_view_a.setLayoutParams(params);
        
        aroma_remaining_percent = (TextView) findViewById(R.id.aroma_remaining_percent_b);
        temp = (int)remain_percent;
        aroma_remaining_percent.setText(String.valueOf(temp) + "%");
        
        aroma_remaining_ml = (TextView) findViewById(R.id.aroma_remaining_ml_b);
        temp = 240 - (int)spray_count_temp;
        aroma_remaining_ml.setText(String.valueOf(temp) + "ml");

        
        
        sp_aroma_settings = getApplicationContext().getSharedPreferences("aromaSettingsC", Context.MODE_PRIVATE); 
        spray_count = sp_aroma_settings.getInt("spray_count", 7); 
        remain = (byte) spray_count;
        spray_count_temp = (int)remain & 0xFF; 
        
        used_percent = (float)spray_count_temp * (float)10 / (float)24; 
        remain_percent = 100F - used_percent; 
        
        aroma_remain_view_a = (View) findViewById(R.id.aroma_remain_view_c);
        params = aroma_remain_view_a.getLayoutParams();
        scale = getResources().getDisplayMetrics().density;
        
        params.height = (int) (remain_percent * 2 * scale) ; 
        aroma_remain_view_a.setLayoutParams(params);
        
        aroma_remaining_percent = (TextView) findViewById(R.id.aroma_remaining_percent_c);
        temp = (int)remain_percent;
        aroma_remaining_percent.setText(String.valueOf(temp) + "%");
        
        aroma_remaining_ml = (TextView) findViewById(R.id.aroma_remaining_ml_c);
        temp = 240 - (int)spray_count_temp;
        aroma_remaining_ml.setText(String.valueOf(temp) + "ml");
    }

    void remainChangeSave_A(){
        
        
        float spray_count_temp = 240F - (240F * (float)((float)remain_amount / 100F)); 
        int spray_count = (int)spray_count_temp;
        SharedPreferences sp_aroma_settings_a = getApplicationContext().getSharedPreferences("aromaSettingsA", Context.MODE_PRIVATE); 
        SharedPreferences.Editor editor = sp_aroma_settings_a.edit();
        editor.putInt("spray_count",spray_count);
        editor.commit();
        onResume();

        
        
        Integer start_hour = sp_aroma_settings_a.getInt("start_hour", 1);  
        Integer start_minute = sp_aroma_settings_a.getInt("start_minute", 2); 
        Integer end_hour = sp_aroma_settings_a.getInt("end_hour", 3); 
        Integer end_minute = sp_aroma_settings_a.getInt("end_minute", 4); 
        Integer week_sum = sp_aroma_settings_a.getInt("week_sum", 5); 
        Integer repeat_cycle = sp_aroma_settings_a.getInt("repeat_cycle", 6); 
        int spray_exist = sp_aroma_settings_a.getInt("spray_exist",0);
        
        int finchk = 254;
        int s_hour = start_hour, s_min=start_minute, e_hour = end_hour, e_min = end_minute, w_sum = week_sum, r_cycle = repeat_cycle;
        int a_type = 0;
        int pkt_type = 0x12;  

        byte start_frame2 = (byte) 0x10; 
        byte packet_type2 = (byte) pkt_type;
        byte start_hour2 = (byte) s_hour;
        byte start_min2 = (byte) s_min;
        byte end_hour2 = (byte) e_hour;
        byte end_min2 = (byte) e_min;
        byte week_sum2 = (byte) w_sum;
        byte r_cycle2 = (byte) r_cycle;
        byte type_onoff2 = (byte) a_type;  
        byte spray_count2 = (byte) spray_count; 
        byte spray_now2 = (byte) 0x00;  
        byte spray_exist2 = (byte) spray_exist;
        byte fin_frame = (byte) finchk; 
        byte [] aroma_set = {start_frame2, packet_type2, start_hour2, start_min2, end_hour2, end_min2, week_sum2, r_cycle2, type_onoff2, spray_count2, spray_now2, spray_exist2, fin_frame};

        try {
            ((MainActivity) MainActivity.mContext).mOutputStream.write(aroma_set);
        }catch(Exception  e){
            e.printStackTrace();
        }
    }

    void remainChangeSave_B(){
        
        
        float spray_count_temp = 240F - (240F * (float)((float)remain_amount / 100F)); 
        int spray_count = (int)spray_count_temp;
        SharedPreferences sp_aroma_settings_b = getApplicationContext().getSharedPreferences("aromaSettingsB", Context.MODE_PRIVATE); 
        SharedPreferences.Editor editor = sp_aroma_settings_b.edit();
        editor.putInt("spray_count",spray_count);
        editor.commit();
        onResume();
        
        
        Integer start_hour = sp_aroma_settings_b.getInt("start_hour", 1);  
        Integer start_minute = sp_aroma_settings_b.getInt("start_minute", 2); 
        Integer end_hour = sp_aroma_settings_b.getInt("end_hour", 3); 
        Integer end_minute = sp_aroma_settings_b.getInt("end_minute", 4); 
        Integer week_sum = sp_aroma_settings_b.getInt("week_sum", 5); 
        Integer repeat_cycle = sp_aroma_settings_b.getInt("repeat_cycle", 6); 
        int spray_exist = sp_aroma_settings_b.getInt("spray_exist",0);
        
        int finchk = 254;
        int s_hour = start_hour, s_min=start_minute, e_hour = end_hour, e_min = end_minute, w_sum = week_sum, r_cycle = repeat_cycle;
        int a_type = 0;
        int pkt_type = 0x13;  
        byte start_frame2 = (byte) 0x10; 
        byte packet_type2 = (byte) pkt_type;
        byte start_hour2 = (byte) s_hour;
        byte start_min2 = (byte) s_min;
        byte end_hour2 = (byte) e_hour;
        byte end_min2 = (byte) e_min;
        byte week_sum2 = (byte) w_sum;
        byte r_cycle2 = (byte) r_cycle;
        byte type_onoff2 = (byte) a_type;  
        byte aroma_remain2 = (byte) spray_count; 
        byte spray_now2 = (byte) 0x00;  
        byte spray_exist2 = (byte) spray_exist;
        byte fin_frame = (byte) finchk; 
        byte [] aroma_set = {start_frame2, packet_type2, start_hour2, start_min2, end_hour2, end_min2, week_sum2, r_cycle2, type_onoff2, aroma_remain2, spray_now2, spray_exist2, fin_frame};

        try {
            ((MainActivity) MainActivity.mContext).mOutputStream.write(aroma_set);
        }catch(Exception  e){
            e.printStackTrace();
        }
    }

    void remainChangeSave_C() {
        
        
        float spray_count_temp = 240F - (240F * (float) ((float) remain_amount / 100F)); 
        int spray_count = (int) spray_count_temp;
        SharedPreferences sp_aroma_settings_c = getApplicationContext().getSharedPreferences("aromaSettingsC", Context.MODE_PRIVATE); 
        SharedPreferences.Editor editor = sp_aroma_settings_c.edit();
        editor.putInt("spray_count", spray_count);
        editor.commit();
        onResume();
        
        
        Integer start_hour = sp_aroma_settings_c.getInt("start_hour", 1);  
        Integer start_minute = sp_aroma_settings_c.getInt("start_minute", 2); 
        Integer end_hour = sp_aroma_settings_c.getInt("end_hour", 3); 
        Integer end_minute = sp_aroma_settings_c.getInt("end_minute", 4); 
        Integer week_sum = sp_aroma_settings_c.getInt("week_sum", 5); 
        Integer repeat_cycle = sp_aroma_settings_c.getInt("repeat_cycle", 6); 
        int spray_exist = sp_aroma_settings_c.getInt("spray_exist",0);
        
        int finchk = 254;
        int s_hour = start_hour, s_min = start_minute, e_hour = end_hour, e_min = end_minute, w_sum = week_sum, r_cycle = repeat_cycle;
        int a_type = 0;
        int pkt_type = 0x14;  
        byte start_frame2 = (byte) 0x10; 
        byte packet_type2 = (byte) pkt_type;
        byte start_hour2 = (byte) s_hour;
        byte start_min2 = (byte) s_min;
        byte end_hour2 = (byte) e_hour;
        byte end_min2 = (byte) e_min;
        byte week_sum2 = (byte) w_sum;
        byte r_cycle2 = (byte) r_cycle;
        byte type_onoff2 = (byte) a_type;  
        byte spray_count2 = (byte) spray_count; 
        byte spray_now2 = (byte) 0x00;  
        byte spray_exist2 = (byte) spray_exist;
        byte fin_frame = (byte) finchk; 
        byte[] aroma_set = {start_frame2, packet_type2, start_hour2, start_min2, end_hour2, end_min2, week_sum2, r_cycle2, type_onoff2, spray_count2, spray_now2, spray_exist2, fin_frame};

        try {
            ((MainActivity) MainActivity.mContext).mOutputStream.write(aroma_set);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}