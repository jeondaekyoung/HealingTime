package com.healingtime.healingtime_designrenew;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import static com.healingtime.healingtime_designrenew.MainActivity.mContext;

public class AromaSettingActivity extends AppCompatActivity {

    byte type_onoff;
    Integer start_hour =0, start_minute=0, end_hour=0, end_minute=0;
    Integer week_sum = 0;
    Integer repeat_cycle = 0;

    private Integer packet_type;
    private boolean aroma_alarm_mon_onoff = false, aroma_alarm_tue_onoff = false, aroma_alarm_wed_onoff = false, aroma_alarm_thu_onoff = false, aroma_alarm_fri_onoff = false, aroma_alarm_sat_onoff = false, aroma_alarm_sun_onoff = false;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aroma_setting_layout);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  
        getSupportActionBar().setTitle("작동시간 설정");    
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF83A54E));  

        
        
        TextView aroma_alarm_starttime = (TextView) findViewById(R.id.aroma_alarm_starttime);
        aroma_alarm_starttime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp_aroma_setting = null;
                String section = getIntent().getStringExtra("section");
                if(section.equals("A")){
                    sp_aroma_setting = getApplicationContext().getSharedPreferences("AromaSettingsA", Context.MODE_PRIVATE);
                }
                if(section.equals("B")){
                    sp_aroma_setting = getApplicationContext().getSharedPreferences("AromaSettingsB", Context.MODE_PRIVATE);
                }
                if(section.equals("C")){
                    sp_aroma_setting = getApplicationContext().getSharedPreferences("AromaSettingsC", Context.MODE_PRIVATE);
                }
                Integer start_hour = sp_aroma_setting.getInt("start_hour", 0);
                Integer start_minute = sp_aroma_setting.getInt("start_minute", 0);
                TimePickerDialog aroma_starttime_dialog = new TimePickerDialog(AromaSettingActivity.this, aroma_starttime_dialog_listener, start_hour, start_minute, false);
                aroma_starttime_dialog.show();
            }
        });

        
        TextView aroma_alarm_endtime = (TextView) findViewById(R.id.aroma_alarm_endtime);
        aroma_alarm_endtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp_aroma_setting = null;
                String section = getIntent().getStringExtra("section");
                if(section.equals("A")){
                    sp_aroma_setting = getApplicationContext().getSharedPreferences("AromaSettingsA", Context.MODE_PRIVATE);
                }
                if(section.equals("B")){
                    sp_aroma_setting = getApplicationContext().getSharedPreferences("AromaSettingsB", Context.MODE_PRIVATE);
                }
                if(section.equals("C")){
                    sp_aroma_setting = getApplicationContext().getSharedPreferences("AromaSettingsC", Context.MODE_PRIVATE);
                }
                Integer end_hour = sp_aroma_setting.getInt("end_hour", 0);
                Integer end_minute = sp_aroma_setting.getInt("end_minute", 0);
                TimePickerDialog aroma_endtime_dialog = new TimePickerDialog(AromaSettingActivity.this, aroma_endtime_dialog_listener, end_hour, end_minute, false);
                aroma_endtime_dialog.show();
            }
        });

        
        final TextView aroma_alarm_btn_mon = (TextView) findViewById(R.id.aroma_alarm_btn_mon);
        aroma_alarm_btn_mon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(aroma_alarm_mon_onoff == true){
                    aroma_alarm_mon_onoff = false;
                    aroma_alarm_btn_mon.setText("월");
                    aroma_alarm_btn_mon.setBackgroundResource(R.drawable.circle_btn_gray);
                } else if(aroma_alarm_mon_onoff == false){
                    aroma_alarm_mon_onoff = true;
                    aroma_alarm_btn_mon.setText("월");
                    aroma_alarm_btn_mon.setBackgroundResource(R.drawable.circle_btn_green);
                }
            }
        });
        final TextView aroma_alarm_btn_tue = (TextView) findViewById(R.id.aroma_alarm_btn_tue);
        aroma_alarm_btn_tue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(aroma_alarm_tue_onoff == true){
                    aroma_alarm_tue_onoff = false;
                    aroma_alarm_btn_tue.setText("화");
                    aroma_alarm_btn_tue.setBackgroundResource(R.drawable.circle_btn_gray);
                } else if(aroma_alarm_tue_onoff == false){
                    aroma_alarm_tue_onoff = true;
                    aroma_alarm_btn_tue.setText("화");
                    aroma_alarm_btn_tue.setBackgroundResource(R.drawable.circle_btn_green);
                }
            }
        });
        final TextView aroma_alarm_btn_wed = (TextView) findViewById(R.id.aroma_alarm_btn_wed);
        aroma_alarm_btn_wed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(aroma_alarm_wed_onoff == true){
                    aroma_alarm_wed_onoff = false;
                    aroma_alarm_btn_wed.setText("수");
                    aroma_alarm_btn_wed.setBackgroundResource(R.drawable.circle_btn_gray);
                } else if(aroma_alarm_wed_onoff == false){
                    aroma_alarm_wed_onoff = true;
                    aroma_alarm_btn_wed.setText("수");
                    aroma_alarm_btn_wed.setBackgroundResource(R.drawable.circle_btn_green);
                }
            }
        });
        final TextView aroma_alarm_btn_thu = (TextView) findViewById(R.id.aroma_alarm_btn_thu);
        aroma_alarm_btn_thu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(aroma_alarm_thu_onoff == true){
                    aroma_alarm_thu_onoff = false;
                    aroma_alarm_btn_thu.setText("목");
                    aroma_alarm_btn_thu.setBackgroundResource(R.drawable.circle_btn_gray);
                } else if(aroma_alarm_thu_onoff == false){
                    aroma_alarm_thu_onoff = true;
                    aroma_alarm_btn_thu.setText("목");
                    aroma_alarm_btn_thu.setBackgroundResource(R.drawable.circle_btn_green);
                }
            }
        });
        final TextView aroma_alarm_btn_fri = (TextView) findViewById(R.id.aroma_alarm_btn_fri);
        aroma_alarm_btn_fri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(aroma_alarm_fri_onoff == true){
                    aroma_alarm_fri_onoff = false;
                    aroma_alarm_btn_fri.setText("금");
                    aroma_alarm_btn_fri.setBackgroundResource(R.drawable.circle_btn_gray);
                } else if(aroma_alarm_fri_onoff == false){
                    aroma_alarm_fri_onoff = true;
                    aroma_alarm_btn_fri.setText("금");
                    aroma_alarm_btn_fri.setBackgroundResource(R.drawable.circle_btn_green);
                }
            }
        });
        final TextView aroma_alarm_btn_sat = (TextView) findViewById(R.id.aroma_alarm_btn_sat);
        aroma_alarm_btn_sat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(aroma_alarm_sat_onoff == true){
                    aroma_alarm_sat_onoff = false;
                    aroma_alarm_btn_sat.setText("토");
                    aroma_alarm_btn_sat.setBackgroundResource(R.drawable.circle_btn_gray);
                } else if(aroma_alarm_sat_onoff == false){
                    aroma_alarm_sat_onoff = true;
                    aroma_alarm_btn_sat.setText("토");
                    aroma_alarm_btn_sat.setBackgroundResource(R.drawable.circle_btn_green);
                }
            }
        });
        final TextView aroma_alarm_btn_sun = (TextView) findViewById(R.id.aroma_alarm_btn_sun);
        aroma_alarm_btn_sun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(aroma_alarm_sun_onoff == true){
                    aroma_alarm_sun_onoff = false;
                    aroma_alarm_btn_sun.setText("일");
                    aroma_alarm_btn_sun.setBackgroundResource(R.drawable.circle_btn_gray);
                } else if(aroma_alarm_sun_onoff == false){
                    aroma_alarm_sun_onoff = true;
                    aroma_alarm_btn_sun.setText("일");
                    aroma_alarm_btn_sun.setBackgroundResource(R.drawable.circle_btn_green);
                }
            }
        });

        
        Button aroma_alarm_cancel = (Button) findViewById(R.id.aroma_alarm_cancel);
        aroma_alarm_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        
        Button aroma_alarm_save = (Button) findViewById(R.id.aroma_alarm_save);
        aroma_alarm_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                if(aroma_alarm_sun_onoff == true) { week_sum += 0x40; }
                if(aroma_alarm_mon_onoff == true) { week_sum += 0x20; }
                if(aroma_alarm_tue_onoff == true) { week_sum += 0x10; }
                if(aroma_alarm_wed_onoff == true) { week_sum += 0x08; }
                if(aroma_alarm_thu_onoff == true) { week_sum += 0x04; }
                if(aroma_alarm_fri_onoff == true) { week_sum += 0x02; }
                if(aroma_alarm_sat_onoff == true) { week_sum += 0x01; }

                
                RadioButton aroma_spray_cycle_rb0 = (RadioButton) findViewById(R.id.aroma_spray_cycle_rb0);
                RadioButton aroma_spray_cycle_rb1 = (RadioButton) findViewById(R.id.aroma_spray_cycle_rb1);
                RadioButton aroma_spray_cycle_rb2 = (RadioButton) findViewById(R.id.aroma_spray_cycle_rb2);
                RadioButton aroma_spray_cycle_rb3 = (RadioButton) findViewById(R.id.aroma_spray_cycle_rb3);
                RadioButton aroma_spray_cycle_rb4 = (RadioButton) findViewById(R.id.aroma_spray_cycle_rb4);
                if(aroma_spray_cycle_rb1.isChecked()){ repeat_cycle = 5; }
                else if(aroma_spray_cycle_rb2.isChecked()){ repeat_cycle = 10; }
                else if(aroma_spray_cycle_rb3.isChecked()){ repeat_cycle = 30; }
                else if(aroma_spray_cycle_rb4.isChecked()){ repeat_cycle = 60; }
                else if(aroma_spray_cycle_rb0.isChecked()){ repeat_cycle = 1; }

                
                int spray_count = 0;
                String section = getIntent().getStringExtra("section");
                if(section.equals("A")){
                    type_onoff = (byte)0x81; packet_type = 0x12;
                    
                    SharedPreferences sp_aroma_settings = getApplicationContext().getSharedPreferences("aromaSettingsA", Context.MODE_PRIVATE); 
                    SharedPreferences.Editor editor = sp_aroma_settings.edit(); 
                    editor.putInt("start_hour",start_hour); 
                    editor.putInt("start_minute",start_minute); 
                    editor.putInt("end_hour",end_hour); 
                    editor.putInt("end_minute",end_minute); 
                    editor.putInt("week_sum",week_sum); 
                    editor.putInt("repeat_cycle", repeat_cycle);
                    editor.putInt("type_onoff",type_onoff);
                    editor.commit();
                    spray_count = sp_aroma_settings.getInt("spray_count",0);
                    sendAromaSettings("A", spray_count);
                }
                else if(section.equals("B")){
                    type_onoff = (byte)0x82; packet_type = 0x13;
                    
                    SharedPreferences sp_aroma_settings = getApplicationContext().getSharedPreferences("aromaSettingsB", Context.MODE_PRIVATE); 
                    SharedPreferences.Editor editor = sp_aroma_settings.edit(); 
                    editor.putInt("start_hour",start_hour); 
                    editor.putInt("start_minute",start_minute); 
                    editor.putInt("end_hour",end_hour); 
                    editor.putInt("end_minute",end_minute); 
                    editor.putInt("week_sum",week_sum); 
                    editor.putInt("repeat_cycle", repeat_cycle);
                    editor.putInt("type_onoff",type_onoff);
                    editor.commit();
                    spray_count = sp_aroma_settings.getInt("spray_count",0);
                    sendAromaSettings("B", spray_count);
                }
                else if(section.equals("C")){
                    type_onoff = (byte)0x83;  packet_type = 0x14;
                    
                    SharedPreferences sp_aroma_settings = getApplicationContext().getSharedPreferences("aromaSettingsC", Context.MODE_PRIVATE); 
                    SharedPreferences.Editor editor = sp_aroma_settings.edit(); 
                    editor.putInt("start_hour",start_hour); 
                    editor.putInt("start_minute",start_minute); 
                    editor.putInt("end_hour",end_hour); 
                    editor.putInt("end_minute",end_minute); 
                    editor.putInt("week_sum",week_sum); 
                    editor.putInt("repeat_cycle", repeat_cycle);
                    editor.putInt("type_onoff",type_onoff);
                    editor.commit();
                    spray_count = sp_aroma_settings.getInt("spray_count",0);
                    sendAromaSettings("C", spray_count);
                }
                onBackPressed();
             }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sp_aroma_settings = null;
        Integer repeat_cycle, type_onoff, aroma_file_name;
        String aroma_name;
        Integer start_hour =0, start_minute=0, end_hour=0, end_minute=0;
        Integer week_sum = 0;

        String section = getIntent().getStringExtra("section");
        if(section.equals("A")){
            sp_aroma_settings = getApplicationContext().getSharedPreferences("aromaSettingsA", Context.MODE_PRIVATE); 
        }
        if(section.equals("B")){
            sp_aroma_settings = getApplicationContext().getSharedPreferences("aromaSettingsB", Context.MODE_PRIVATE); 
        }
        if(section.equals("C")){
            sp_aroma_settings = getApplicationContext().getSharedPreferences("aromaSettingsC", Context.MODE_PRIVATE); 
        }
        start_hour = sp_aroma_settings.getInt("start_hour", 0);  
        start_minute = sp_aroma_settings.getInt("start_minute", 0); 
        end_hour = sp_aroma_settings.getInt("end_hour", 0); 
        end_minute = sp_aroma_settings.getInt("end_minute", 0); 
        week_sum = sp_aroma_settings.getInt("week_sum", 0); 
        repeat_cycle = sp_aroma_settings.getInt("repeat_cycle", 0); 
        type_onoff = sp_aroma_settings.getInt("type_onoff", 0);
        aroma_name = sp_aroma_settings.getString("aroma_name", "설정없음");
        aroma_file_name = sp_aroma_settings.getInt("aroma_file_name", R.drawable.spray_blank);

        
        final TextView aroma_alarm_section_textview = (TextView) findViewById(R.id.aroma_alarm_section_textview);
        aroma_alarm_section_textview.setText(section + " 구간");
        
        final ImageView aroma_alarm_image_imageview = (ImageView) findViewById(R.id.aroma_alarm_image_imageview);
        aroma_alarm_image_imageview.setImageResource(aroma_file_name);
        
        final TextView aroma_alarm_aromaname_textview = (TextView) findViewById(R.id.aroma_alarm_aromaname_textview);
        SharedPreferences sp_aroma_setting = mContext.getSharedPreferences("aromaNickName", Context.MODE_PRIVATE);
        String aroma_nickname = sp_aroma_setting.getString(aroma_name, "NA");
        if(!aroma_nickname.equals("NA")){ 
            aroma_alarm_aromaname_textview.setText(aroma_nickname);
        }
        else{
            aroma_alarm_aromaname_textview.setText(aroma_name);
        }
        
        String AM_PM ;
        this.start_hour = start_hour;
        this.start_minute = start_minute;
        int start_hour_12 = 0;
        if(start_hour < 12) { AM_PM = "오전"; start_hour_12 = start_hour; }
        else { AM_PM = "오후"; start_hour_12 = start_hour - 12;}
        final TextView aroma_starttime_textview = (TextView) findViewById(R.id.aroma_alarm_starttime);
        aroma_starttime_textview.setText(AM_PM + " " + String.format("%02d",start_hour_12) + "시 " + String.format("%02d",start_minute) + "분");

        
        int end_hour_12 = 0;
        this.end_hour = end_hour;
        this.end_minute = end_minute;
        if(end_hour < 12) { AM_PM = "오전"; end_hour_12 = end_hour; }
        else { AM_PM = "오후"; end_hour_12 = end_hour - 12;}
        TextView aroma_endtime_textview = (TextView) findViewById(R.id.aroma_alarm_endtime);
        aroma_endtime_textview.setText(AM_PM + " " + String.format("%02d",end_hour_12) + "시 " + String.format("%02d",end_minute) + "분");

        
        Button aroma_alarm_btn_sun = (Button) findViewById(R.id.aroma_alarm_btn_sun);
        Button aroma_alarm_btn_mon = (Button) findViewById(R.id.aroma_alarm_btn_mon);
        Button aroma_alarm_btn_tue = (Button) findViewById(R.id.aroma_alarm_btn_tue);
        Button aroma_alarm_btn_wed = (Button) findViewById(R.id.aroma_alarm_btn_wed);
        Button aroma_alarm_btn_thu = (Button) findViewById(R.id.aroma_alarm_btn_thu);
        Button aroma_alarm_btn_fri = (Button) findViewById(R.id.aroma_alarm_btn_fri);
        Button aroma_alarm_btn_sat = (Button) findViewById(R.id.aroma_alarm_btn_sat);
        byte sunday_bit = 0x40, monday_bit = 0x20, tuesday_bit = 0x10, wednesday_bit = 0x08, thursday_bit = 0x04, friday_bit = 0x02, saturday_bit = 0x01;
        if ((week_sum & sunday_bit) == sunday_bit) {
            aroma_alarm_btn_sun.setBackgroundResource(R.drawable.circle_btn_green);
            aroma_alarm_sun_onoff = true; }
        if ((week_sum & monday_bit) == monday_bit) {
            aroma_alarm_btn_mon.setBackgroundResource(R.drawable.circle_btn_green);
            aroma_alarm_mon_onoff = true; }
        if ((week_sum & tuesday_bit) == tuesday_bit) {
            aroma_alarm_btn_tue.setBackgroundResource(R.drawable.circle_btn_green);
            aroma_alarm_tue_onoff = true; }
        if ((week_sum & wednesday_bit) == wednesday_bit) {
            aroma_alarm_btn_wed.setBackgroundResource(R.drawable.circle_btn_green);
            aroma_alarm_wed_onoff = true; }
        if ((week_sum & thursday_bit) == thursday_bit) {
            aroma_alarm_btn_thu.setBackgroundResource(R.drawable.circle_btn_green);
            aroma_alarm_thu_onoff = true;}
        if ((week_sum & friday_bit) == friday_bit) {
            aroma_alarm_btn_fri.setBackgroundResource(R.drawable.circle_btn_green);
            aroma_alarm_fri_onoff = true;}
        if ((week_sum & saturday_bit) == saturday_bit) {
            aroma_alarm_btn_sat.setBackgroundResource(R.drawable.circle_btn_green);
            aroma_alarm_sat_onoff = true;}

        RadioGroup aroma_spray_cycle_rg1 = (RadioGroup) findViewById(R.id.aroma_spray_cycle_rg1);
        switch(repeat_cycle){
            case 1: 
                aroma_spray_cycle_rg1.check(R.id.aroma_spray_cycle_rb0);
                break;
            case 5:
                aroma_spray_cycle_rg1.check(R.id.aroma_spray_cycle_rb1);
                break;
            case 10:
                aroma_spray_cycle_rg1.check(R.id.aroma_spray_cycle_rb2);
                break;
            case 30:
                aroma_spray_cycle_rg1.check(R.id.aroma_spray_cycle_rb3);
                break;
            case 60:
                aroma_spray_cycle_rg1.check(R.id.aroma_spray_cycle_rb4);
                break;
        }

    }

    void sendAromaSettings(String selectABC, int spray_count){
        
        SharedPreferences sp_aroma_settings = null;
        int spray_exist = 0;
        switch (selectABC){
            case "A":
                sp_aroma_settings = getApplicationContext().getSharedPreferences("aromaSettingsA", Context.MODE_PRIVATE);
                spray_exist = sp_aroma_settings.getInt("spray_exist",0);
                break;
            case "B":
                sp_aroma_settings = getApplicationContext().getSharedPreferences("aromaSettingsB", Context.MODE_PRIVATE);
                spray_exist = sp_aroma_settings.getInt("spray_exist",0);
                break;
            case "C":
                sp_aroma_settings = getApplicationContext().getSharedPreferences("aromaSettingsC", Context.MODE_PRIVATE);
                spray_exist = sp_aroma_settings.getInt("spray_exist",0);
                break;
        }
        int finchk = 0xFE;
        int s_hour = start_hour, s_min=start_minute, e_hour = end_hour, e_min = end_minute, w_sum = week_sum, c_time = repeat_cycle;
        int pkt_type = packet_type, s_count = spray_count;

        byte start_frame = (byte) 0x10; 
        byte packet_type = (byte) pkt_type;
        byte start_hour = (byte) s_hour;
        byte start_min = (byte) s_min;
        byte end_hour = (byte) e_hour;
        byte end_min = (byte) e_min;
        byte week_sum = (byte) w_sum;
        byte cycle_time = (byte) c_time;
        byte type_onoff = (byte) 0x80;
        byte spray_count2 = (byte) s_count; 
        byte spray_now = (byte) 0x00;  
        byte spray_exist2 = (byte) spray_exist;
        byte fin_frame = (byte) finchk; 
        byte [] aroma_set = {start_frame, packet_type, start_hour, start_min, end_hour, end_min, week_sum, cycle_time, type_onoff, spray_count2, spray_now, spray_exist2, fin_frame};

        try {
            ((MainActivity) MainActivity.mContext).mOutputStream.write(aroma_set);
        }catch(Exception  e){
            e.printStackTrace();
        }
    }

    private TimePickerDialog.OnTimeSetListener aroma_starttime_dialog_listener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            start_hour = hourOfDay;
            start_minute = minute;

            
            String AM_PM;
            int start_hour_12 = 0;
            if(hourOfDay < 12) { AM_PM = "오전"; start_hour_12 = start_hour; }
            else { AM_PM = "오후"; start_hour_12 = start_hour - 12; }

            
            final TextView aroma_starttime_textview = (TextView) findViewById(R.id.aroma_alarm_starttime);
            aroma_starttime_textview.setText(AM_PM+" "+String.format("%02d", start_hour_12)+"시 "+String.format("%02d", start_minute)+"분");
        }
    };

    private TimePickerDialog.OnTimeSetListener aroma_endtime_dialog_listener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            end_hour = hourOfDay;
            end_minute = minute;

            
            String AM_PM ;
            int end_hour_12 = 0;
            if(hourOfDay < 12) { AM_PM = "오전"; end_hour_12 = end_hour;}
            else { AM_PM = "오후"; end_hour_12 = end_hour - 12; }

            
            final TextView aroma_endtime_textview = (TextView) findViewById(R.id.aroma_alarm_endtime);
            aroma_endtime_textview.setText(AM_PM+" "+String.format("%02d", end_hour_12)+"시 "+String.format("%02d", end_minute)+"분");
        }
    };
}
