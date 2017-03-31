package com.healingtime.healingtime_designrenew;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorChangedListener;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;
import com.melnykov.fab.FloatingActionButton;

public class ColorMainActivity extends AppCompatActivity {
    private Integer bright = 5; 
    private FloatingActionButton color_alarm_fab;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_main_layout);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  
        getSupportActionBar().setTitle("컬러 테라피");    
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
                    lightOnOff(1, (byte) 0x30, bright, 0);
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
                    lightOnOff(1, (byte) 0x20, bright, 0);
                }
            }
        });
        color_orange_toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (color_orange_toggle.isChecked()) {
                    lightOnOff(2, (byte) 0x30, bright, 0);
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
                    lightOnOff(2, (byte) 0x20, bright, 0);
                }
            }
        });
        color_yellow_toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (color_yellow_toggle.isChecked()) {
                    lightOnOff(3, (byte) 0x30, bright, 0);
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
                    lightOnOff(3, (byte) 0x20, bright, 0);
                }
            }
        });
        color_green_toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (color_green_toggle.isChecked()) {
                    lightOnOff(4, (byte) 0x30, bright, 0);
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
                    lightOnOff(4, (byte) 0x20, bright, 0);
                }
            }
        });
        color_blue_toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (color_blue_toggle.isChecked()) {
                    lightOnOff(5, (byte) 0x30, bright, 0);
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
                    lightOnOff(5, (byte) 0x20, bright, 0);
                }
            }
        });
        color_purple_toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (color_purple_toggle.isChecked()) {
                    lightOnOff(6, (byte) 0x30, bright, 0);
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
                    lightOnOff(6, (byte) 0x20, bright, 0);
                }
            }
        });
        color_white_toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (color_white_toggle.isChecked()) {
                    lightOnOff(7, (byte) 0x30, bright, 0);
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
                    lightOnOff(7, (byte) 0x20, bright, 0);
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
                    final Context context = ColorMainActivity.this;
                    ColorPickerDialogBuilder
                        .with(context)
                        .setTitle("Choose Color")
                        .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                        .density(12)
                        .setOnColorChangedListener(new OnColorChangedListener() {
                            @Override public void onColorChanged(int selectedColor) {
                                
                                Log.d("ColorPicker", "onColorChanged: 0x" + Integer.toHexString(selectedColor));
                                lightOnOff(8, (byte) 0x30, bright, selectedColor);
                            }
                        })
                        .setOnColorSelectedListener(new OnColorSelectedListener() {
                            @Override
                            public void onColorSelected(int selectedColor) {
                                Toast.makeText(getApplicationContext(), "onColorSelected: 0x" + Integer.toHexString(selectedColor), Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .showColorEdit(true)
                        .setColorEditTextColor(ContextCompat.getColor(ColorMainActivity.this, android.R.color.holo_blue_bright))
                        .build()
                        .show();
                } else {
                    lightOnOff(6, (byte) 0x20, bright, 0);
                }
            }
        });

        
        final SeekBar color_direct_bright_seekbar = (SeekBar) findViewById(R.id.color_direct_bright_seekbar);
        color_direct_bright_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int bright, boolean fromUser) {
                bright = bright;

                if (bright < 1) {
                    bright = 1;
                    color_direct_bright_seekbar.setProgress(bright);
                }
                Integer bright_percent = bright * 10;
                TextView color_direct_bright_value = (TextView) findViewById(R.id.color_direct_bright_value);
                color_direct_bright_value.setText(bright_percent.toString());

                if (color_red_toggle.isChecked()) {
                    lightOnOff(1, (byte) 0x30, bright, 0);
                }
                if (color_orange_toggle.isChecked()) {
                    lightOnOff(2, (byte) 0x30, bright, 0);
                }
                if (color_yellow_toggle.isChecked()) {
                    lightOnOff(3, (byte) 0x30, bright, 0);
                }
                if (color_green_toggle.isChecked()) {
                    lightOnOff(4, (byte) 0x30, bright, 0);
                }
                if (color_blue_toggle.isChecked()) {
                    lightOnOff(5, (byte) 0x30, bright, 0);
                }
                if (color_purple_toggle.isChecked()) {
                    lightOnOff(6, (byte) 0x30, bright, 0);
                }
                if (color_white_toggle.isChecked()) {
                    lightOnOff(7, (byte) 0x30, bright, 0);
                }
                if (color_custom_toggle.isChecked()) {
                    lightOnOff(8, (byte) 0x30, bright, 0);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        
        final ImageButton color_alarm_add_btn = (ImageButton) findViewById(R.id.color_alarm_add_btn);
        color_alarm_add_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ColorSettingsActivity.class);
                SharedPreferences sp_color_setting1 = getApplicationContext().getSharedPreferences("ColorSettings1", Context.MODE_PRIVATE);
                Integer deleted1 = sp_color_setting1.getInt("deleted", 999);
                SharedPreferences sp_color_setting2 = getApplicationContext().getSharedPreferences("ColorSettings2", Context.MODE_PRIVATE);
                Integer deleted2 = sp_color_setting2.getInt("deleted", 999);
                SharedPreferences sp_color_setting3 = getApplicationContext().getSharedPreferences("ColorSettings3", Context.MODE_PRIVATE);
                Integer deleted3 = sp_color_setting3.getInt("deleted", 999);
                if(deleted1 == 1 || deleted1 == 999){
                    intent.putExtra("alarm_no", 1);
                    startActivity(intent);
                }
                else if(deleted2 == 1 || deleted2 == 999){
                    intent.putExtra("alarm_no", 2);
                    startActivity(intent);
                }
                else if(deleted3 == 1 || deleted3 == 999){
                    intent.putExtra("alarm_no", 3);
                    startActivity(intent);
                }
            }
        });

        
        final LinearLayout color_alarm_layout_1 = (LinearLayout) findViewById(R.id.color_alarm_layout_1);
        color_alarm_layout_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ColorSettingsActivity.class);
                intent.putExtra("alarm_no", 1);
                startActivity(intent);
            }
        });
        final LinearLayout color_alarm_layout_2 = (LinearLayout) findViewById(R.id.color_alarm_layout_2);
        color_alarm_layout_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ColorSettingsActivity.class);
                intent.putExtra("alarm_no", 2);
                startActivity(intent);
            }
        });
        final LinearLayout color_alarm_layout_3 = (LinearLayout) findViewById(R.id.color_alarm_layout_3);
        color_alarm_layout_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ColorSettingsActivity.class);
                intent.putExtra("alarm_no", 3);
                startActivity(intent);
            }
        });

        
        
        final ImageButton color_more_btn_1 = (ImageButton) findViewById(R.id.color_alarm_delete_btn_1);
        color_more_btn_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences sp_color_setting = getApplicationContext().getSharedPreferences("ColorSettings1", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp_color_setting.edit();
                editor.putInt("deleted", 1);
                editor.commit();
                color_alarm_layout_1.setVisibility(View.GONE);
                color_alarm_add_btn.setVisibility(View.VISIBLE);
                
                sendColorAlarmDeletePacket();
            }
        });
        final ImageButton color_more_btn_2 = (ImageButton) findViewById(R.id.color_alarm_delete_btn_2);
        color_more_btn_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences sp_color_setting = getApplicationContext().getSharedPreferences("ColorSettings2", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp_color_setting.edit();
                editor.putInt("deleted", 1);
                editor.commit();
                color_alarm_layout_2.setVisibility(View.GONE);
                color_alarm_add_btn.setVisibility(View.VISIBLE);
                
            }
        });
        final ImageButton color_more_btn_3 = (ImageButton) findViewById(R.id.color_alarm_delete_btn_3);
        color_more_btn_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences sp_color_setting = getApplicationContext().getSharedPreferences("ColorSettings3", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp_color_setting.edit();
                editor.putInt("deleted", 1);
                editor.commit();
                color_alarm_layout_3.setVisibility(View.GONE);
                color_alarm_add_btn.setVisibility(View.VISIBLE);
                
            }
        });

        
        final SwitchCompat color_alarm_switch_1 = (SwitchCompat) findViewById(R.id.color_alarm_switch_1);
        color_alarm_switch_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    colorAlarmOnOff(true);
                    color_alarm_layout_1.setBackgroundColor(0xFFFFFFFF);
                } else {
                    colorAlarmOnOff(false);
                    color_alarm_layout_1.setBackgroundColor(0xFFF2F2F2);
                }
            }
        });
        final SwitchCompat color_alarm_switch_2 = (SwitchCompat) findViewById(R.id.color_alarm_switch_2);
        color_alarm_switch_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    colorAlarmOnOff(true);
                    color_alarm_layout_2.setBackgroundColor(0xFFFFFFFF);
                } else {
                    colorAlarmOnOff(false);
                    color_alarm_layout_2.setBackgroundColor(0xFFF2F2F2);
                }
            }
        });
        final SwitchCompat color_alarm_switch_3 = (SwitchCompat) findViewById(R.id.color_alarm_switch_3);
        color_alarm_switch_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    colorAlarmOnOff(true);
                    color_alarm_layout_3.setBackgroundColor(0xFFFFFFFF);
                } else {
                    colorAlarmOnOff(false);
                    color_alarm_layout_3.setBackgroundColor(0xFFF2F2F2);
                }
            }
        });

        
        LinearLayout link_color_therapy = (LinearLayout) findViewById(R.id.link_color_therapy);
        link_color_therapy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        LinearLayout link_aroma_therapy = (LinearLayout) findViewById(R.id.link_aroma_therapy);
        link_aroma_therapy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AromaMainActivity.class);
                startActivity(intent);
                finish();
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

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sp_color_setting1 = getApplicationContext().getSharedPreferences("ColorSettings1", Context.MODE_PRIVATE);
        Integer alarm_deleted1 = sp_color_setting1.getInt("deleted", 999);
        SharedPreferences sp_color_setting2 = getApplicationContext().getSharedPreferences("ColorSettings2", Context.MODE_PRIVATE);
        Integer alarm_deleted2 = sp_color_setting2.getInt("deleted", 999);
        SharedPreferences sp_color_setting3 = getApplicationContext().getSharedPreferences("ColorSettings3", Context.MODE_PRIVATE);
        Integer alarm_deleted3 = sp_color_setting3.getInt("deleted", 999);
        if(alarm_deleted1 == 0){
            colorAlarmDisplay1();
        }
        if(alarm_deleted2 == 0){
            colorAlarmDisplay2();
        }
        if(alarm_deleted3 == 0){
            colorAlarmDisplay3();
        }
        if(alarm_deleted1 == 0 && alarm_deleted2 == 0 && alarm_deleted3 == 0){
            final ImageButton color_alarm_add_btn = (ImageButton) findViewById(R.id.color_alarm_add_btn);
            color_alarm_add_btn.setVisibility(View.INVISIBLE);
        }
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

    public void sendColorAlarmDeletePacket(){
        
        int finchk = 254;
        byte start_frame = (byte) 0x10; 
        byte type_frame = (byte) 0x11;
        byte start_hour = 0x00;
        byte start_min = 0x00;
        byte end_hour = 0x00;
        byte end_min = 0x00;
        byte week_sum = 0x00;
        byte color_bright = 0x00;
        byte rgb_r = 0x00;
        byte rgb_g = 0x00;
        byte rgb_b = 0x00;
        byte type_onoff = 0x00;
        byte fin_frame = (byte) finchk;
        byte [] color_set = {start_frame, type_frame, start_hour, start_min, end_hour, end_min, week_sum, color_bright, rgb_r, rgb_g, rgb_b, type_onoff, fin_frame};

        try {
            ((MainActivity) MainActivity.mContext).mOutputStream.write(color_set);
        }catch(Exception  e){
            e.printStackTrace();
        }
    }

    void colorAlarmDisplay1(){
        final LinearLayout color_alarm_layout_1 = (LinearLayout) findViewById(R.id.color_alarm_layout_1);
        color_alarm_layout_1.setVisibility(View.VISIBLE);

        String start_ampm = "오전", end_ampm = "오후";
        SharedPreferences sp_color_setting = getApplicationContext().getSharedPreferences("ColorSettings1", Context.MODE_PRIVATE);
        Integer start_hour = sp_color_setting.getInt("start_hour", 0);  
        Integer start_minute = sp_color_setting.getInt("start_minute", 0); 
        Integer end_hour = sp_color_setting.getInt("end_hour", 0); 
        Integer end_minute = sp_color_setting.getInt("end_minute", 0); 
        Integer week_sum = sp_color_setting.getInt("week_sum", 0); 
        Integer bright = sp_color_setting.getInt("bright", 0); 
        Integer rgb_r = sp_color_setting.getInt("user_color_r", 0); 
        Integer rgb_g = sp_color_setting.getInt("user_color_g", 0); 
        Integer rgb_b = sp_color_setting.getInt("user_color_b", 0); 
        Integer color_info = sp_color_setting.getInt("type_onoff", 0); 

        
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

        
        byte montosun_bit = 0x7F; 
        byte montosatur_bit = 0x3F; 
        byte montofri_bit = 0x3E; 
        byte sunday_bit = 0x40, monday_bit = 0x20, tuesday_bit = 0x10, wednesday_bit = 0x08, thursday_bit = 0x04, friday_bit = 0x02, saturday_bit = 0x01;
        String week_sum_string = "반복: ";
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

        
        int type_onoff = color_info & 0x0F;
        int color_value = 0xFFF2F2F2; 
        switch (type_onoff){
            case 1:
                color_value = 0xFFF83434;
                break;
            case 2:
                color_value = 0xFFFF9800;
                break;
            case 3:
                color_value = 0xFFFBE02D;
                break;
            case 4:
                color_value = 0xFF7CD138;
                break;
            case 5:
                color_value = 0xFF3881FB;
                break;
            case 6:
                color_value = 0xFF800080;
                break;
            case 7:
                color_value = 0xFFFFFFFF;
                break;
            case 8:
                int temp0 = 0xFF000000;
                int temp1 = (rgb_r & 0x000000FF) << 16;
                int temp2 = (rgb_g & 0x000000FF) << 8;
                int temp3 = (rgb_b & 0x000000FF) << 0;
                color_value = temp0 | temp1 | temp2 | temp3;
                break;

        }
        
        int color_alarm_onoff = color_info & 0x40; 

        
        View color_alarm_colortype = (View) findViewById(R.id.color_alarm_colortype_1);
        TextView color_alarm_time_textview = (TextView) findViewById(R.id.color_alarm_time_textview_1);
        TextView color_alarm_week_sum = (TextView) findViewById(R.id.color_alarm_week_sum_1);
        TextView color_alarm_bright = (TextView) findViewById(R.id.color_alarm_bright_1);
        final SwitchCompat color_alarm_switch_1 = (SwitchCompat) findViewById(R.id.color_alarm_switch_1);
        color_alarm_colortype.setBackgroundColor(color_value);
        color_alarm_time_textview.setText(start_ampm+" "+String.format("%02d", start_hour)+":"+String.format("%02d", start_minute)+" ~ "+end_ampm+" "+String.format("%02d", end_hour)+":"+String.format("%02d", end_minute));
        color_alarm_bright.setText("밝기: "+String.format("%3d", bright * 10)+"%");
        color_alarm_week_sum.setText(week_sum_string);
        if(color_alarm_onoff == 0x40) {
            color_alarm_switch_1.setChecked(true);
            color_alarm_layout_1.setBackgroundColor(0xFFFFFFFF);
        }
        else if(color_alarm_onoff == 0x00){
            color_alarm_switch_1.setChecked(false);
            color_alarm_layout_1.setBackgroundColor(0xFFF2F2F2);
        }
    }
    void colorAlarmDisplay2(){
        final LinearLayout color_alarm_layout_2 = (LinearLayout) findViewById(R.id.color_alarm_layout_2);
        color_alarm_layout_2.setVisibility(View.VISIBLE);

        String start_ampm = "오전", end_ampm = "오후";
        SharedPreferences sp_color_setting = getApplicationContext().getSharedPreferences("ColorSettings2", Context.MODE_PRIVATE);
        Integer start_hour = sp_color_setting.getInt("start_hour", 0);  
        Integer start_minute = sp_color_setting.getInt("start_minute", 0); 
        Integer end_hour = sp_color_setting.getInt("end_hour", 0); 
        Integer end_minute = sp_color_setting.getInt("end_minute", 0); 
        Integer week_sum = sp_color_setting.getInt("week_sum", 0); 
        Integer bright = sp_color_setting.getInt("bright", 0); 
        Integer rgb_r = sp_color_setting.getInt("user_color_r", 0); 
        Integer rgb_g = sp_color_setting.getInt("user_color_g", 0); 
        Integer rgb_b = sp_color_setting.getInt("user_color_b", 0); 
        Integer color_info = sp_color_setting.getInt("type_onoff", 0); 

        
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

        
        byte montosun_bit = 0x7F; 
        byte montosatur_bit = 0x3F; 
        byte montofri_bit = 0x3E; 
        byte sunday_bit = 0x40, monday_bit = 0x20, tuesday_bit = 0x10, wednesday_bit = 0x08, thursday_bit = 0x04, friday_bit = 0x02, saturday_bit = 0x01;
        String week_sum_string = "반복: ";
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

        
        int type_onoff = color_info & 0x0F;
        int color_value = 0xFFF2F2F2; 
        switch (type_onoff){
            case 1:
                color_value = 0xFFF83434;
                break;
            case 2:
                color_value = 0xFFFF9800;
                break;
            case 3:
                color_value = 0xFFFBE02D;
                break;
            case 4:
                color_value = 0xFF7CD138;
                break;
            case 5:
                color_value = 0xFF3881FB;
                break;
            case 8:
                int temp0 = 0xFF000000;
                int temp1 = (rgb_r & 0x000000FF) << 16;
                int temp2 = (rgb_g & 0x000000FF) << 8;
                int temp3 = (rgb_b & 0x000000FF) << 0;
                color_value = temp0 | temp1 | temp2 | temp3;
                break;

        }
        
        int color_alarm_onoff = color_info & 0x40; 

        
        View color_alarm_colortype = (View) findViewById(R.id.color_alarm_colortype_2);
        TextView color_alarm_time_textview = (TextView) findViewById(R.id.color_alarm_time_textview_2);
        TextView color_alarm_week_sum = (TextView) findViewById(R.id.color_alarm_week_sum_2);
        TextView color_alarm_bright = (TextView) findViewById(R.id.color_alarm_bright_2);
        final SwitchCompat color_alarm_switch_2 = (SwitchCompat) findViewById(R.id.color_alarm_switch_2);
        color_alarm_colortype.setBackgroundColor(color_value);
        color_alarm_time_textview.setText(start_ampm+" "+String.format("%02d", start_hour)+":"+String.format("%02d", start_minute)+" ~ "+end_ampm+" "+String.format("%02d", end_hour)+":"+String.format("%02d", end_minute));
        color_alarm_bright.setText("밝기: "+String.format("%3d", bright*10)+"%");
        color_alarm_week_sum.setText(week_sum_string);
        if(color_alarm_onoff == 0x40) {
            color_alarm_switch_2.setChecked(true);
            color_alarm_layout_2.setBackgroundColor(0xFFFFFFFF);
        }
        else if(color_alarm_onoff == 0x00) {
            color_alarm_switch_2.setChecked(false);
            color_alarm_layout_2.setBackgroundColor(0xFFF2F2F2);
        }
    }
    void colorAlarmDisplay3(){
        final LinearLayout color_alarm_layout_3 = (LinearLayout) findViewById(R.id.color_alarm_layout_3);
        color_alarm_layout_3.setVisibility(View.VISIBLE);

        String start_ampm = "오전", end_ampm = "오후";
        SharedPreferences sp_color_setting = getApplicationContext().getSharedPreferences("ColorSettings3", Context.MODE_PRIVATE);
        Integer start_hour = sp_color_setting.getInt("start_hour", 0);  
        Integer start_minute = sp_color_setting.getInt("start_minute", 0); 
        Integer end_hour = sp_color_setting.getInt("end_hour", 0); 
        Integer end_minute = sp_color_setting.getInt("end_minute", 0); 
        Integer week_sum = sp_color_setting.getInt("week_sum", 0); 
        Integer bright = sp_color_setting.getInt("bright", 0); 
        Integer rgb_r = sp_color_setting.getInt("user_color_r", 0); 
        Integer rgb_g = sp_color_setting.getInt("user_color_g", 0); 
        Integer rgb_b = sp_color_setting.getInt("user_color_b", 0); 
        Integer color_info = sp_color_setting.getInt("type_onoff", 0); 

        
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

        
        byte montosun_bit = 0x7F; 
        byte montosatur_bit = 0x3F; 
        byte montofri_bit = 0x3E; 
        byte sunday_bit = 0x40, monday_bit = 0x20, tuesday_bit = 0x10, wednesday_bit = 0x08, thursday_bit = 0x04, friday_bit = 0x02, saturday_bit = 0x01;
        String week_sum_string = "반복: ";
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

        
        int type_onoff = color_info & 0x0F;
        int color_value = 0xFFF2F2F2; 
        switch (type_onoff){
            case 1:
                color_value = 0xFFF83434;
                break;
            case 2:
                color_value = 0xFFFF9800;
                break;
            case 3:
                color_value = 0xFFFBE02D;
                break;
            case 4:
                color_value = 0xFF7CD138;
                break;
            case 5:
                color_value = 0xFF3881FB;
                break;
            case 8:
                int temp0 = 0xFF000000;
                int temp1 = (rgb_r & 0x000000FF) << 16;
                int temp2 = (rgb_g & 0x000000FF) << 8;
                int temp3 = (rgb_b & 0x000000FF) << 0;
                color_value = temp0 | temp1 | temp2 | temp3;
                break;

        }
        
        int color_alarm_onoff = color_info & 0x40; 

        
        View color_alarm_colortype = (View) findViewById(R.id.color_alarm_colortype_3);
        TextView color_alarm_time_textview = (TextView) findViewById(R.id.color_alarm_time_textview_3);
        TextView color_alarm_week_sum = (TextView) findViewById(R.id.color_alarm_week_sum_3);
        TextView color_alarm_bright = (TextView) findViewById(R.id.color_alarm_bright_3);
        final SwitchCompat color_alarm_switch_3 = (SwitchCompat) findViewById(R.id.color_alarm_switch_3);
        color_alarm_colortype.setBackgroundColor(color_value);
        color_alarm_time_textview.setText(start_ampm+" "+String.format("%02d", start_hour)+":"+String.format("%02d", start_minute)+" ~ "+end_ampm+" "+String.format("%02d", end_hour)+":"+String.format("%02d", end_minute));
        color_alarm_bright.setText("밝기: " + String.format("%3d", bright * 10)+"%");
        color_alarm_week_sum.setText(week_sum_string);
        if(color_alarm_onoff == 0x40) {
            color_alarm_switch_3.setChecked(true);
            color_alarm_layout_3.setBackgroundColor(0xFFFFFFFF);
        }
        else if(color_alarm_onoff == 0x00) {
            color_alarm_switch_3.setChecked(false);
            color_alarm_layout_3.setBackgroundColor(0xFFF2F2F2);
        }
    }

    
    void lightOnOff(int color, byte onoff, int bright, int selectedColor ){
        int week_sum_temp = 0x2A;
        byte week_sum = (byte)week_sum_temp;
        int bright_now_temp = bright;
        byte bright_now = (byte) bright_now_temp;
        byte[] rgbArray = new byte[4];
        
        rgbArray[2] = (byte)(selectedColor >> 16); 
        rgbArray[1] = (byte)(selectedColor >> 8);
        rgbArray[0] = (byte)(selectedColor >> 0);
        byte light_onoff = onoff;
        int lighton_now_temp = (light_onoff | color);
        byte lighton_now = (byte) lighton_now_temp;
        int trailer_temp = 0xFE;   byte trailer = (byte)trailer_temp;
        byte [] lighton_pkt = {0x10, 0x11, 0x00, 0x00, 0x00, 0x00, week_sum, bright_now, rgbArray[2], rgbArray[1], rgbArray[0], lighton_now, trailer};
        try {
            ((MainActivity) MainActivity.mContext).mOutputStream.write(lighton_pkt);
        }catch(Exception  e){
            e.printStackTrace();
        }
    }

    void colorAlarmOnOff(boolean onoff) { 
        SharedPreferences sp_color_setting = getApplicationContext().getSharedPreferences("ColorSettings1", Context.MODE_PRIVATE);
        Integer start_hour = sp_color_setting.getInt("start_hour", 0);  
        Integer start_minute = sp_color_setting.getInt("start_minute", 0); 
        Integer end_hour = sp_color_setting.getInt("end_hour", 0); 
        Integer end_minute = sp_color_setting.getInt("end_minute", 0); 
        Integer week_sum = sp_color_setting.getInt("week_sum", 0); 
        Integer bright = sp_color_setting.getInt("bright", 0); 
        Integer rgb_r = sp_color_setting.getInt("user_color_r", 0); 
        Integer rgb_g = sp_color_setting.getInt("user_color_g", 0); 
        Integer rgb_b = sp_color_setting.getInt("user_color_b", 0); 
        Integer type_onoff = sp_color_setting.getInt("type_onoff", 0); 
        if(onoff == true) { 
            type_onoff = (int)type_onoff | 0x40 ;
            SharedPreferences sp_color_settings = getApplicationContext().getSharedPreferences("ColorSettings1", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp_color_settings.edit();
            editor.putInt("type_onoff", type_onoff);
            editor.commit();
        }
        else if(onoff ==false){
            
            
            type_onoff = (int)type_onoff & 0x0F ;
            SharedPreferences sp_color_settings = getApplicationContext().getSharedPreferences("ColorSettings1", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp_color_settings.edit();
            editor.putInt("type_onoff", type_onoff);
            editor.commit();
        }

        
        int finchk = 0xFE;
        int s_hour = start_hour, s_min=start_minute, e_hour = end_hour, e_min = end_minute, w_sum = week_sum;
        int bright2 = bright, c_rgb_r= rgb_r, c_rgb_g= rgb_g, c_rgb_b= rgb_b, c_type = type_onoff;
        
        byte start_frame = (byte) 0x10; 
        byte type_frame = (byte) 0x11;
        byte start_hour2 = (byte) s_hour;
        byte start_min2 = (byte) s_min;
        byte end_hour2 = (byte) e_hour;
        byte end_min2 = (byte) e_min;
        byte week_sum2 = (byte) w_sum;
        byte bright3 = (byte) bright2;
        byte user_color_r = (byte) c_rgb_r;
        byte user_color_g = (byte) c_rgb_g;
        byte user_color_b = (byte) c_rgb_b;
        byte type_onoff2 = (byte) c_type;
        byte fin_frame = (byte) finchk;
        byte [] color_set = {start_frame, type_frame, start_hour2, start_min2, end_hour2, end_min2, week_sum2, bright3, user_color_r, user_color_g, user_color_b, type_onoff2, fin_frame};

        try {
            ((MainActivity) MainActivity.mContext).mOutputStream.write(color_set);
        }catch(Exception  e){
            e.printStackTrace();
        }
    }
}
