package com.healingtime.healingtime_designrenew;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.melnykov.fab.FloatingActionButton;

import static com.healingtime.healingtime_designrenew.MainActivity.mContext;

public class AromaMainActivity extends AppCompatActivity {
    private Integer start_hour = 0, start_minute = 0, end_hour = 0, end_minute = 0, spray_count = 0;
    Context context = this;
    boolean alarmOnOff_resume;
    private FloatingActionButton aroma_alarm_fab;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aroma_main_layout);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("향기 테라피");

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF83A54E));


        ImageButton aroma_directspray_a_btn = (ImageButton) findViewById(R.id.aroma_directspray_a_btn);
        aroma_directspray_a_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "분사버튼 터치됨!", Toast.LENGTH_SHORT).show();

                SharedPreferences sp_aroma_settings_a = getApplicationContext().getSharedPreferences("aromaSettingsA", Context.MODE_PRIVATE);
                spray_count = sp_aroma_settings_a.getInt("spray_count", 0);
                SharedPreferences.Editor editor = sp_aroma_settings_a.edit();
                editor.putInt("spray_count",spray_count + 1);
                editor.commit();

                int finchk = 254;
                int p_type = 0x12;
                int s_hour = start_hour, s_min=start_minute, e_hour = end_hour, e_min = end_minute, w_sum = 0x2A, c_time = 0x00;
                int s_count = spray_count + 1;
                byte start_frame = (byte) 0x10;
                byte packet_type = (byte) p_type;
                byte start_hour = (byte) s_hour;
                byte start_min = (byte) s_min;
                byte end_hour = (byte) e_hour;
                byte end_min = (byte) e_min;
                byte week_sum = (byte) w_sum;
                byte cycle_min = (byte) c_time;
                byte type_onoff = (byte) 0x80;
                byte spray_count = (byte) s_count ;
                byte spray_now = (byte) 0x01;
                byte padding = (byte) 0x00;
                byte fin_frame = (byte) finchk;
                byte [] aroma_set = {start_frame, packet_type, start_hour, start_min, end_hour, end_min, week_sum, cycle_min, type_onoff, spray_count, spray_now, padding, fin_frame};
                try {
                    ((MainActivity) MainActivity.mContext).mOutputStream.write(aroma_set);
                }catch(Exception  e){
                    e.printStackTrace();
                }
            }
        });

        ImageButton aroma_directspray_b_btn = (ImageButton) findViewById(R.id.aroma_directspray_b_btn);
        aroma_directspray_b_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "분사버튼 터치됨!", Toast.LENGTH_SHORT).show();

                SharedPreferences sp_aroma_settings_b = getApplicationContext().getSharedPreferences("aromaSettingsB", Context.MODE_PRIVATE);
                spray_count = sp_aroma_settings_b.getInt("spray_count", 0);
                SharedPreferences.Editor editor = sp_aroma_settings_b.edit();
                editor.putInt("spray_count",spray_count + 1);
                editor.commit();

                int finchk = 254;
                int p_type = 0x13;
                int s_hour = start_hour, s_min=start_minute, e_hour = end_hour, e_min = end_minute, w_sum = 0x2A, c_time = 0x00;
                byte start_frame = (byte) 0x10;
                byte packet_type = (byte) p_type;
                byte start_hour = (byte) s_hour;
                byte start_min = (byte) s_min;
                byte end_hour = (byte) e_hour;
                byte end_min = (byte) e_min;
                byte week_sum = (byte) w_sum;
                byte cycle_min = (byte) c_time;
                byte type_onoff = (byte) 0x80;
                byte spray_count = (byte) 0xF0;
                byte spray_now = (byte) 0x01;
                byte padding = (byte) 0x00;
                byte fin_frame = (byte) finchk;
                byte [] aroma_set = {start_frame, packet_type, start_hour, start_min, end_hour, end_min, week_sum, cycle_min, type_onoff, spray_count, spray_now, padding, fin_frame};
                try {
                    ((MainActivity) MainActivity.mContext).mOutputStream.write(aroma_set);
                }catch(Exception  e){
                    e.printStackTrace();
                }
            }
        });

        ImageButton aroma_directspray_c_btn = (ImageButton) findViewById(R.id.aroma_directspray_c_btn);
        aroma_directspray_c_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "분사버튼 터치됨!", Toast.LENGTH_SHORT).show();

                SharedPreferences sp_aroma_settings_c = getApplicationContext().getSharedPreferences("aromaSettingsC", Context.MODE_PRIVATE);
                spray_count = sp_aroma_settings_c.getInt("spray_count", 0);
                SharedPreferences.Editor editor = sp_aroma_settings_c.edit();
                editor.putInt("spray_count",spray_count + 1);
                editor.commit();
                int finchk = 254;
                int p_type = 0x14;
                int s_hour = start_hour, s_min=start_minute, e_hour = end_hour, e_min = end_minute, w_sum = 0x2A, c_time = 0x00;
                byte start_frame = (byte) 0x10;
                byte packet_type = (byte) p_type;
                byte start_hour = (byte) s_hour;
                byte start_min = (byte) s_min;
                byte end_hour = (byte) e_hour;
                byte end_min = (byte) e_min;
                byte week_sum = (byte) w_sum;
                byte cycle_min = (byte) c_time;
                byte type_onoff = (byte) 0x80;
                byte spray_count = (byte) 0xF0;
                byte spray_now = (byte) 0x01;
                byte padding = (byte) 0x00;
                byte fin_frame = (byte) finchk;
                byte [] aroma_set = {start_frame, packet_type, start_hour, start_min, end_hour, end_min, week_sum, cycle_min, type_onoff, spray_count, spray_now, padding, fin_frame};
                try {
                    ((MainActivity) MainActivity.mContext).mOutputStream.write(aroma_set);
                }catch(Exception  e){
                    e.printStackTrace();
                }
            }
        });



        TextView aroma_directspray_name_textview_a = (TextView) findViewById(R.id.aroma_directspray_name_textview_a);
        aroma_directspray_name_textview_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AromaEditSearchActivity.class);
                intent.putExtra("section", "A");
                startActivity(intent);
            }
        });

        TextView aroma_directspray_name_textview_b = (TextView) findViewById(R.id.aroma_directspray_name_textview_b);
        aroma_directspray_name_textview_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AromaEditSearchActivity.class);
                intent.putExtra("section", "B");
                startActivity(intent);
            }
        });

        TextView aroma_directspray_name_textview_c = (TextView) findViewById(R.id.aroma_directspray_name_textview_c);
        aroma_directspray_name_textview_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AromaEditSearchActivity.class);
                intent.putExtra("section", "C");
                startActivity(intent);
            }
        });


        TextView aroma_directspray_remain_textview_a = (TextView) findViewById(R.id.aroma_directspray_remain_textview_a);
        aroma_directspray_remain_textview_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AromaRemainActivity.class);
                startActivity(intent);
            }
        });

        TextView aroma_directspray_remain_textview_b = (TextView) findViewById(R.id.aroma_directspray_remain_textview_b);
        aroma_directspray_remain_textview_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AromaRemainActivity.class);
                startActivity(intent);
            }
        });

        TextView aroma_directspray_remain_textview_c = (TextView) findViewById(R.id.aroma_directspray_remain_textview_c);
        aroma_directspray_remain_textview_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AromaRemainActivity.class);
                startActivity(intent);
            }
        });



        final LinearLayout aroma_alarm_layout_a = (LinearLayout) findViewById(R.id.aroma_alarm_layout_a);
        SwitchCompat switchCompat = (SwitchCompat) findViewById(R.id.aroma_alarm_switch_a);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked && !alarmOnOff_resume) {
                    aromaAlarmOnOff("A", true);
                    aroma_alarm_layout_a.setBackgroundColor(0xFFFFFFFF);
                } else if(!isChecked && !alarmOnOff_resume) {
                    aromaAlarmOnOff("A", false);
                    aroma_alarm_layout_a.setBackgroundColor(0xFFF2F2F2);
                }
            }
        });

        final LinearLayout aroma_alarm_layout_b = (LinearLayout) findViewById(R.id.aroma_alarm_layout_b);
        switchCompat = (SwitchCompat) findViewById(R.id.aroma_alarm_switch_b);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked && !alarmOnOff_resume) {
                    aromaAlarmOnOff("B", true);
                    aroma_alarm_layout_b.setBackgroundColor(0xFFFFFFFF);
                } else if(!isChecked && !alarmOnOff_resume) {
                    aromaAlarmOnOff("B", false);
                    aroma_alarm_layout_b.setBackgroundColor(0xFFF2F2F2);
                }
            }
        });

        final LinearLayout aroma_alarm_layout_c = (LinearLayout) findViewById(R.id.aroma_alarm_layout_c);
        switchCompat = (SwitchCompat) findViewById(R.id.aroma_alarm_switch_c);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked && !alarmOnOff_resume) {
                    aromaAlarmOnOff("C", true);
                    aroma_alarm_layout_c.setBackgroundColor(0xFFFFFFFF);
                } else if(!isChecked && !alarmOnOff_resume) {
                    aromaAlarmOnOff("C", false);
                    aroma_alarm_layout_c.setBackgroundColor(0xFFF2F2F2);
                }
            }
        });


        aroma_alarm_layout_a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AromaSettingActivity.class);
                intent.putExtra("section","A");
                startActivity(intent);
            }
        });

        aroma_alarm_layout_b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AromaSettingActivity.class);
                intent.putExtra("section","B");
                startActivity(intent);
            }
        });

        aroma_alarm_layout_c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AromaSettingActivity.class);
                intent.putExtra("section","C");
                startActivity(intent);
            }
        });


        LinearLayout link_color_therapy = (LinearLayout) findViewById(R.id.link_color_therapy);
        link_color_therapy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ColorMainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        LinearLayout link_aroma_therapy = (LinearLayout) findViewById(R.id.link_aroma_therapy);
        link_aroma_therapy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        LinearLayout link_dictionary = (LinearLayout) findViewById(R.id.link_dictionary);
        link_dictionary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DictionaryAromaActivity.class);
                startActivity(intent);
                finish();
            }
        });
        LinearLayout link_settings = (LinearLayout) findViewById(R.id.link_market);
        link_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "준비중입니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onResume() {
        super.onResume();
        alarmOnOff_resume = true;
        String start_ampm = "오전", end_ampm ="오후";
        TextView repeat_cycle_textview;

        SharedPreferences sp_aroma_settings;
        Integer start_hour, start_minute, end_hour, end_minute, week_sum, repeat_cycle, type_onoff;
        String aroma_name;
        Integer aroma_file_name, spray_exist;
        byte montosun_bit = 0x7F, montosatur_bit = 0x3F, montofri_bit = 0x3E, sunday_bit = 0x40, monday_bit = 0x20, tuesday_bit = 0x10, wednesday_bit = 0x08, thursday_bit = 0x04, friday_bit = 0x02, saturday_bit = 0x01;
        String week_sum_string = "반복: ";
        SharedPreferences sp_aroma_setting = null;
        String aroma_nickname =null;



        sp_aroma_settings = getApplicationContext().getSharedPreferences("aromaSettingsA", Context.MODE_PRIVATE);
        start_hour = sp_aroma_settings.getInt("start_hour", 0);
        start_minute = sp_aroma_settings.getInt("start_minute", 0);
        end_hour = sp_aroma_settings.getInt("end_hour", 0);
        end_minute = sp_aroma_settings.getInt("end_minute", 0);
        week_sum = sp_aroma_settings.getInt("week_sum", 0);
        repeat_cycle = sp_aroma_settings.getInt("repeat_cycle", 0);
        type_onoff = sp_aroma_settings.getInt("type_onoff", 0);
        spray_count = sp_aroma_settings.getInt("spray_count", 0);
        aroma_name = sp_aroma_settings.getString("aroma_name", "이름없음");
        aroma_file_name = sp_aroma_settings.getInt("aroma_file_name", 0);
        spray_exist = sp_aroma_settings.getInt("spray_exist", 999);


        if(start_hour > 12) {start_hour -= 12; start_ampm = "오후"; }
        else if(start_hour <= 12)  {start_ampm = "오전"; }
        if(end_hour > 12) {end_hour -= 12; end_ampm = "오후"; }
        else if(end_hour <= 12)  {end_ampm = "오전"; }


        week_sum_string = "반복: ";
        if ((week_sum & monday_bit) == 0x20) { week_sum_string += "월."; }
        if ((week_sum & tuesday_bit) == 0x10) { week_sum_string += "화."; }
        if ((week_sum & wednesday_bit) == 0x08) { week_sum_string += "수."; }
        if ((week_sum & thursday_bit) == 0x04) { week_sum_string += "목."; }
        if ((week_sum & friday_bit) == 0x02) { week_sum_string += "금."; }
        if ((week_sum & saturday_bit) == 0x01) { week_sum_string += "토."; }
        if ((week_sum & sunday_bit) == 0x40) { week_sum_string += "일."; }
        week_sum_string += "요일";
        if ((week_sum & montosun_bit) == 0x7F) {
            week_sum_string = "반복: 월 ~ 일요일"; }
        if ((week_sum & montosatur_bit) == 0x3F) {
            week_sum_string = "반복: 월 ~ 토요일"; }
        if ((week_sum & montofri_bit) == 0x3E) {
            week_sum_string = "반복: 월 ~ 금요일"; }



        TextView aroma_alarm_time_textview_a = (TextView)findViewById(R.id.aroma_alarm_time_textview_a);
        aroma_alarm_time_textview_a.setText(start_ampm+" "+String.format("%02d", start_hour)+":"+String.format("%02d", start_minute)+" ~ "+end_ampm+" "+String.format("%02d", end_hour)+":"+String.format("%02d", end_minute));
        TextView aroma_alarm_week_sum_textview = (TextView)findViewById(R.id.aroma_alarm_week_sum_textview_a);
        aroma_alarm_week_sum_textview.setText(week_sum_string);
        repeat_cycle_textview = (TextView)findViewById(R.id.aroma_alarm_repeatcycle_textview_a);
        repeat_cycle_textview.setText(String.format("%2d", repeat_cycle)+"분 간격");


        final LinearLayout aroma_alarm_layout_a = (LinearLayout) findViewById(R.id.aroma_alarm_layout_a);
        SwitchCompat aroma_alarm_switch_a = (SwitchCompat)findViewById(R.id.aroma_alarm_switch_a);
        if( (type_onoff & 0x80) == 0x80 ){
            aroma_alarm_switch_a.setChecked(true);
            aroma_alarm_layout_a.setBackgroundColor(0xFFFFFFFF);
        }
        else {
            aroma_alarm_switch_a.setChecked(false);
            aroma_alarm_layout_a.setBackgroundColor(0xFFF2F2F2);
        }


        ImageButton aroma_directspray_a_btn = (ImageButton)findViewById(R.id.aroma_directspray_a_btn);
        if(aroma_file_name == 0 && spray_exist == 1){
            aroma_directspray_a_btn.setImageResource(R.drawable.aroma_name_not_set);
        }
        else if(aroma_file_name != 0 && spray_exist == 1){
            aroma_directspray_a_btn.setImageResource(aroma_file_name);
        }
        else if(spray_exist == 0){
            aroma_directspray_a_btn.setImageResource(R.drawable.spray_blank);
        }


        TextView aroma_directspray_name_textview_a = (TextView)findViewById(R.id.aroma_directspray_name_textview_a);
        sp_aroma_setting = mContext.getSharedPreferences("aromaNickName", Context.MODE_PRIVATE);
        aroma_nickname = sp_aroma_setting.getString(aroma_name, "NA");
        if(aroma_nickname.equals("NA")){
            aroma_directspray_name_textview_a.setText(aroma_name);
        }
        else{
            aroma_directspray_name_textview_a.setText(aroma_nickname);
        }


        TextView aroma_directspray_remain_textview_a = (TextView)findViewById(R.id.aroma_directspray_remain_textview_a);
        spray_count = sp_aroma_settings.getInt("spray_count", 999);
        if(spray_count != 999 && spray_exist == 1 ) {
            int spray_count_temp = spray_count;
            byte remain = (byte) spray_count_temp;
            int spray_count_temp2 = (int) remain & 0xFF;

            float used_percent = (float) spray_count_temp2 * (float) 10 / (float) 24;
            float remain_percent = 100F - used_percent;
            int remain_percent_int = (int) remain_percent;
            if(remain_percent_int <= 10) {
                aroma_directspray_remain_textview_a.setTextColor(0xFFFF0000);
            }
            aroma_directspray_remain_textview_a.setText(String.valueOf(remain_percent_int) + "%");
        }
        else if(spray_count == 999 || spray_exist == 0){
            aroma_directspray_remain_textview_a.setText("용기없음");
        }




        sp_aroma_settings = getApplicationContext().getSharedPreferences("aromaSettingsB", Context.MODE_PRIVATE);
        start_hour = sp_aroma_settings.getInt("start_hour", 0);
        start_minute = sp_aroma_settings.getInt("start_minute", 0);
        end_hour = sp_aroma_settings.getInt("end_hour", 0);
        end_minute = sp_aroma_settings.getInt("end_minute", 0);
        week_sum = sp_aroma_settings.getInt("week_sum", 0);
        repeat_cycle = sp_aroma_settings.getInt("repeat_cycle", 0);
        type_onoff = sp_aroma_settings.getInt("type_onoff", 0);
        spray_count = sp_aroma_settings.getInt("spray_count", 0);
        aroma_name = sp_aroma_settings.getString("aroma_name", "이름없음");
        aroma_file_name = sp_aroma_settings.getInt("aroma_file_name", 0);
        spray_exist = sp_aroma_settings.getInt("spray_exist", 0);


        if(start_hour > 12) {start_hour -= 12; start_ampm = "오후"; }
        else if(start_hour <= 12)  {start_ampm = "오전"; }
        if(end_hour > 12) {end_hour -= 12; end_ampm = "오후"; }
        else if(end_hour <= 12)  {end_ampm = "오전"; }


        week_sum_string = "반복: ";
        if ((week_sum & sunday_bit) == 0x40) { week_sum_string += "일."; }
        if ((week_sum & monday_bit) == 0x20) { week_sum_string += "월."; }
        if ((week_sum & tuesday_bit) == 0x10) { week_sum_string += "화."; }
        if ((week_sum & wednesday_bit) == 0x08) { week_sum_string += "수."; }
        if ((week_sum & thursday_bit) == 0x04) { week_sum_string += "목."; }
        if ((week_sum & friday_bit) == 0x02) { week_sum_string += "금."; }
        if ((week_sum & saturday_bit) == 0x01) { week_sum_string += "토."; }
        week_sum_string += "요일";
        if ((week_sum & montosun_bit) == 0x7F) { week_sum_string = "반복: 월 ~ 일요일"; }
        if ((week_sum & montosatur_bit) == 0x3F) { week_sum_string = "반복: 월 ~ 토요일"; }
        if ((week_sum & montofri_bit) == 0x3E) { week_sum_string = "반복: 월 ~ 금요일"; }



        TextView aroma_alarm_time_textview_b = (TextView)findViewById(R.id.aroma_alarm_time_textview_b);
        aroma_alarm_time_textview_b.setText(start_ampm+" "+String.format("%02d", start_hour)+":"+String.format("%02d", start_minute)+" ~ "+end_ampm+" "+String.format("%02d", end_hour)+":"+String.format("%02d", end_minute));

        TextView aroma_alarm_week_sum_textview_b = (TextView)findViewById(R.id.aroma_alarm_week_sum_textview_b);
        aroma_alarm_week_sum_textview_b.setText(week_sum_string);

        TextView aroma_alarm_repeatcycle_textview_b = (TextView)findViewById(R.id.aroma_alarm_repeatcycle_textview_b);
        aroma_alarm_repeatcycle_textview_b.setText(String.format("%2d", repeat_cycle)+"분 간격");


        final LinearLayout aroma_alarm_layout_b = (LinearLayout) findViewById(R.id.aroma_alarm_layout_b);
        SwitchCompat aroma_alarm_switch_b = (SwitchCompat)findViewById(R.id.aroma_alarm_switch_b);
        if( (type_onoff & 0x80) == 0x80 ){
            aroma_alarm_switch_b.setChecked(true);
            aroma_alarm_layout_b.setBackgroundColor(0xFFFFFFFF);
        }
        else {
            aroma_alarm_switch_b.setChecked(false);
            aroma_alarm_layout_b.setBackgroundColor(0xFFF2F2F2);
        }


        ImageButton aroma_directspray_b_btn = (ImageButton)findViewById(R.id.aroma_directspray_b_btn);
        if(aroma_file_name == 0 && spray_exist == 1){
            aroma_directspray_b_btn.setImageResource(R.drawable.aroma_name_not_set);
        }
        else if(aroma_file_name != 0 && spray_exist == 1){
            aroma_directspray_b_btn.setImageResource(aroma_file_name);
        }
        else if(spray_exist == 0){
            aroma_directspray_b_btn.setImageResource(R.drawable.spray_blank);
        }

        TextView aroma_directspray_name_textview_b = (TextView)findViewById(R.id.aroma_directspray_name_textview_b);
        sp_aroma_setting = mContext.getSharedPreferences("aromaNickName", Context.MODE_PRIVATE);
        aroma_nickname = sp_aroma_setting.getString(aroma_name, "NA");
        if(aroma_nickname.equals("NA")){
            aroma_directspray_name_textview_b.setText(aroma_name);
        }
        else{
            aroma_directspray_name_textview_b.setText(aroma_nickname);
        }


        TextView aroma_directspray_remain_textview_b = (TextView)findViewById(R.id.aroma_directspray_remain_textview_b);
        spray_count = sp_aroma_settings.getInt("spray_count", 999);
        if(spray_count != 999 && spray_exist == 1) {
            int spray_count_temp = spray_count;
            byte remain = (byte) spray_count_temp;
            int spray_count_temp2 = (int) remain & 0xFF;

            float used_percent = (float) spray_count_temp2 * (float) 10 / (float) 24;
            float remain_percent = 100F - used_percent;
            int remain_percent_int = (int) remain_percent;
            if(remain_percent_int <= 10) {
                aroma_directspray_remain_textview_b.setTextColor(0xFFFF0000);
            }
            aroma_directspray_remain_textview_b.setText(String.valueOf(remain_percent_int) + "%");
        }
        else if(spray_count == 999 || spray_exist == 0){
            aroma_directspray_remain_textview_b.setText("용기없음");
        }



        sp_aroma_settings = getApplicationContext().getSharedPreferences("aromaSettingsC", Context.MODE_PRIVATE);
        start_hour = sp_aroma_settings.getInt("start_hour", 0);
        start_minute = sp_aroma_settings.getInt("start_minute", 0);
        end_hour = sp_aroma_settings.getInt("end_hour", 0);
        end_minute = sp_aroma_settings.getInt("end_minute", 0);
        week_sum = sp_aroma_settings.getInt("week_sum", 0);
        repeat_cycle = sp_aroma_settings.getInt("repeat_cycle", 0);
        type_onoff = sp_aroma_settings.getInt("type_onoff", 0);
        spray_count = sp_aroma_settings.getInt("spray_count", 0);
        aroma_name = sp_aroma_settings.getString("aroma_name", "이름없음");
        aroma_file_name = sp_aroma_settings.getInt("aroma_file_name", 0);
        spray_exist = sp_aroma_settings.getInt("spray_exist", 0);


        if(start_hour > 12) {start_hour -= 12; start_ampm = "오후"; }
        else if(start_hour <= 12)  {start_ampm = "오전"; }
        if(end_hour > 12) {end_hour -= 12; end_ampm = "오후"; }
        else if(end_hour <= 12)  {end_ampm = "오전"; }


        week_sum_string = "반복: ";
        if ((week_sum & sunday_bit) == 0x40) { week_sum_string += "일."; }
        if ((week_sum & monday_bit) == 0x20) { week_sum_string += "월."; }
        if ((week_sum & tuesday_bit) == 0x10) { week_sum_string += "화."; }
        if ((week_sum & wednesday_bit) == 0x08) { week_sum_string += "수."; }
        if ((week_sum & thursday_bit) == 0x04) { week_sum_string += "목."; }
        if ((week_sum & friday_bit) == 0x02) { week_sum_string += "금."; }
        if ((week_sum & saturday_bit) == 0x01) { week_sum_string += "토."; }
        week_sum_string += "요일";
        if ((week_sum & montosun_bit) == 0x7F) { week_sum_string = "반복: 월 ~ 일요일"; }
        if ((week_sum & montosatur_bit) == 0x3F) { week_sum_string = "반복: 월 ~ 토요일"; }
        if ((week_sum & montofri_bit) == 0x3E) { week_sum_string = "반복: 월 ~ 금요일"; }




        TextView aroma_alarm_time_textview_c = (TextView)findViewById(R.id.aroma_alarm_time_textview_c);
        aroma_alarm_time_textview_c.setText(start_ampm+" "+String.format("%02d", start_hour)+":"+String.format("%02d", start_minute)+" ~ "+end_ampm+" "+String.format("%02d", end_hour)+":"+String.format("%02d", end_minute));

        TextView aroma_alarm_week_sum_textview_c = (TextView)findViewById(R.id.aroma_alarm_week_sum_textview_c);
        aroma_alarm_week_sum_textview_c.setText(week_sum_string);

        TextView aroma_alarm_repeatcycle_textview_c = (TextView)findViewById(R.id.aroma_alarm_repeatcycle_textview_c);
        aroma_alarm_repeatcycle_textview_c.setText(String.format("%2d", repeat_cycle)+"분 간격");

        final LinearLayout aroma_alarm_layout_c = (LinearLayout) findViewById(R.id.aroma_alarm_layout_c);
        SwitchCompat aroma_alarm_switch_c = (SwitchCompat)findViewById(R.id.aroma_alarm_switch_c);
        if( (type_onoff & 0x80) == 0x80 ){
            aroma_alarm_switch_c.setChecked(true);
            aroma_alarm_layout_c.setBackgroundColor(0xFFFFFFFF);
        }
        else {
            aroma_alarm_switch_c.setChecked(false);
            aroma_alarm_layout_c.setBackgroundColor(0xFFF2F2F2);
        }


        ImageButton aroma_directspray_c_btn = (ImageButton)findViewById(R.id.aroma_directspray_c_btn);
        if(aroma_file_name == 0 && spray_exist == 1){
            aroma_directspray_c_btn.setImageResource(R.drawable.aroma_name_not_set);
        }
        else if(aroma_file_name != 0 && spray_exist == 1){
            aroma_directspray_c_btn.setImageResource(aroma_file_name);
        }
        else if(spray_exist == 0){
            aroma_directspray_c_btn.setImageResource(R.drawable.spray_blank);
        }


        TextView aroma_directspray_name_textview_c = (TextView)findViewById(R.id.aroma_directspray_name_textview_c);
        sp_aroma_setting = mContext.getSharedPreferences("aromaNickName", Context.MODE_PRIVATE);
        aroma_nickname = sp_aroma_setting.getString(aroma_name, "NA");
        if(!aroma_nickname.equals("NA")){
            aroma_directspray_name_textview_c.setText(aroma_nickname);
        }
        else{
            aroma_directspray_name_textview_c.setText(aroma_name);
        }


        TextView aroma_directspray_remain_textview_c = (TextView)findViewById(R.id.aroma_directspray_remain_textview_c);
        spray_count = sp_aroma_settings.getInt("spray_count", 999);
        if(spray_count != 999 && spray_exist == 1) {
            int spray_count_temp = spray_count;
            byte remain = (byte) spray_count_temp;
            int spray_count_temp2 = (int) remain & 0xFF;

            float used_percent = (float) spray_count_temp2 * (float) 10 / (float) 24;
            float remain_percent = 100F - used_percent;
            int remain_percent_int = (int) remain_percent;
            if(remain_percent_int <= 10) {
                aroma_directspray_remain_textview_c.setTextColor(0xFFFF0000);
            }
            aroma_directspray_remain_textview_c.setText(String.valueOf(remain_percent_int) + "%");
        }
        else if(spray_count == 999 || spray_exist == 0){
            aroma_directspray_remain_textview_c.setText("용기없음");
        }


        alarmOnOff_resume = false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.color_main_actionbar, menu);
        return true;
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

    void aromaAlarmOnOff(String abc_select, boolean onoff) {
        SharedPreferences sp_aroma_setting = null;
        int packet_type = 0;
        int spray_exist =0;
        SharedPreferences.Editor editor = null;
        switch(abc_select){
            case "A":
                sp_aroma_setting = context.getSharedPreferences("aromaSettingsA", Context.MODE_PRIVATE);
                editor = sp_aroma_setting.edit();
                editor.putInt("type_onoff", (onoff==true)?0x81:0x01  );
                editor.commit();
                spray_exist = sp_aroma_setting.getInt("spray_exist",999);
                packet_type = 0x12;
                break;
            case "B":
                sp_aroma_setting = context.getSharedPreferences("aromaSettingsB", Context.MODE_PRIVATE);
                editor = sp_aroma_setting.edit();
                editor.putInt("type_onoff", (onoff==true)?0x82:0x02  );
                editor.commit();
                spray_exist = sp_aroma_setting.getInt("spray_exist",999);
                packet_type = 0x13;
                break;
            case "C":
                sp_aroma_setting = context.getSharedPreferences("aromaSettingsC", Context.MODE_PRIVATE);
                editor = sp_aroma_setting.edit();
                editor.putInt("type_onoff", (onoff==true)?0x83:0x03  );
                editor.commit();
                spray_exist = sp_aroma_setting.getInt("spray_exist",999);
                packet_type = 0x14;
                break;
            default:
                break;
        }


        Integer type_onoff = sp_aroma_setting.getInt("type_onoff", 0);
        Integer start_hour = sp_aroma_setting.getInt("start_hour", 1);
        Integer start_minute = sp_aroma_setting.getInt("start_minute", 2);
        Integer end_hour = sp_aroma_setting.getInt("end_hour", 3);
        Integer end_minute = sp_aroma_setting.getInt("end_minute", 4);
        Integer week_sum = sp_aroma_setting.getInt("week_sum", 5);
        Integer repeat_cycle = sp_aroma_setting.getInt("repeat_cycle", 6);
        Integer spray_count = sp_aroma_setting.getInt("spray_count", 7);


        if(onoff == true){ type_onoff = type_onoff | 0x80; }
        else if(onoff == false){ type_onoff = type_onoff & 0x0F; }


        int s_hour = start_hour, s_min=start_minute, e_hour = end_hour, e_min = end_minute, w_sum = week_sum, c_time = repeat_cycle;
        int a_type = type_onoff, pkt_type = packet_type, s_count = spray_count;
        int finchk = 0xFE;
        byte start_frame = (byte) 0x10;
        byte b_packet_type = (byte) pkt_type;
        byte b_start_hour = (byte) s_hour;
        byte b_start_min = (byte) s_min;
        byte b_end_hour = (byte) e_hour;
        byte b_end_min = (byte) e_min;
        byte b_week_sum = (byte) w_sum;
        byte b_cycle_time = (byte) c_time;
        byte b_type_onoff = (byte) a_type;
        byte b_spray_count = (byte) s_count;
        byte spray_now = (byte) 0x00;
        byte spray_exist2 = (byte) spray_exist;
        byte fin_frame = (byte) finchk;
        byte [] aroma_set = {start_frame, b_packet_type, b_start_hour, b_start_min, b_end_hour, b_end_min, b_week_sum, b_cycle_time, b_type_onoff, b_spray_count, spray_now, spray_exist2, fin_frame};

        try {
            ((MainActivity) MainActivity.mContext).mOutputStream.write(aroma_set);
        }catch(Exception  e){
            e.printStackTrace();
        }
    }
}
