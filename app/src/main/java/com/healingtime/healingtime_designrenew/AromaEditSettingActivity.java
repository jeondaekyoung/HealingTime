package com.healingtime.healingtime_designrenew;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import static com.healingtime.healingtime_designrenew.MainActivity.mContext;

public class AromaEditSettingActivity extends AppCompatActivity {
    TextView txtname;
    TextView txtsub_name;
    TextView txtextract_part;
    TextView txtextract_method;
    TextView txtcountry_origin;
    TextView txtdetailed_instructions;
    TextView txtcolor;
    TextView txtblending_oil;
    TextView txthistory;
    TextView txtcaution;
    ImageView icon;
    String section;
    String aroma_nickname;
    String aroma_name;
    String aroma_sub_name;
    String aroma_extract_part;
    String aroma_extract_method;
    String aroma_country_origin;
    String aroma_detailed_instructions;
    String aroma_color;
    String aroma_blending_oil;
    String aroma_history;
    String aroma_caution;
    int icon_adr;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aroma_editsetting_layout);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);        
        getSupportActionBar().setTitle("향기 설정");        
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF83A54E));        

        Button aroma_name_edit_btn = (Button) findViewById(R.id.aroma_name_edit_btn);
        aroma_name_edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View innerView = getLayoutInflater().inflate(R.layout.aroma_editname_dialog, null);
                AlertDialog.Builder adialog = new AlertDialog.Builder(AromaEditSettingActivity.this);
                adialog.setView(innerView);
                adialog.setPositiveButton("변경", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if(section.equals("A")){
                            EditText aroma_nickname_edittext = (EditText) innerView.findViewById(R.id.aroma_nickname_edittext);
                            aroma_nickname = aroma_nickname_edittext.getText().toString();
                            saveNickName("A");   
                        }
                        if(section.equals("B")){
                            EditText aroma_nickname_edittext = (EditText) innerView.findViewById(R.id.aroma_nickname_edittext);
                            aroma_nickname = aroma_nickname_edittext.getText().toString();
                            saveNickName("B");   
                        }
                        if(section.equals("C")){
                            EditText aroma_nickname_edittext = (EditText) innerView.findViewById(R.id.aroma_nickname_edittext);
                            aroma_nickname = aroma_nickname_edittext.getText().toString();
                            saveNickName("C");   
                        }
                } });
                adialog.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                } });
                adialog.setTitle("별칭 설정");
                adialog.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.aroma_editsetting_actionbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:   
                finish();
                
                return true;
            case R.id.aroma_editsetting_confirm:
                saveAromaNameofSection();
                Intent intent = new Intent(getApplicationContext(), AromaMainActivity.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();
        section = intent.getStringExtra("section");
        aroma_name = intent.getStringExtra("aroma_name");
        SharedPreferences sp_aroma_setting = mContext.getSharedPreferences("aromaNickName", Context.MODE_PRIVATE);
        aroma_nickname = sp_aroma_setting.getString(aroma_name, "NA");
        aroma_sub_name = intent.getStringExtra("aroma_sub_name");
        icon_adr = intent.getIntExtra("icon", -1);
        aroma_extract_part = intent.getStringExtra("aroma_extract_part");
        aroma_extract_method = intent.getStringExtra("aroma_extract_method");
        aroma_country_origin = intent.getStringExtra("aroma_country_origin");
        aroma_detailed_instructions = intent.getStringExtra("aroma_detailed_instructions");
        aroma_color = intent.getStringExtra("aroma_color");
        aroma_blending_oil = intent.getStringExtra("aroma_blending_oil");
        aroma_history = intent.getStringExtra("aroma_history");
        aroma_caution = intent.getStringExtra("aroma_caution");
        
        txtname = (TextView) findViewById(R.id.top_aroma_name);
        txtsub_name = (TextView) findViewById(R.id.top_aroma_sub_name);
        icon = (ImageView) findViewById(R.id.single_aroma_icon);
        txtextract_part = (TextView)findViewById(R.id.single_aroma_extract_part);
        txtextract_method = (TextView)findViewById(R.id.single_aroma_extract_method);
        txtcountry_origin = (TextView)findViewById(R.id.single_aroma_country_origin);
        txtdetailed_instructions = (TextView)findViewById(R.id.single_aroma_detailed_instructions);
        txtcolor = (TextView)findViewById(R.id.single_aroma_color);
        txtblending_oil = (TextView)findViewById(R.id.single_aroma_blending_oil);
        txthistory = (TextView)findViewById(R.id.single_aroma_history);
        txtcaution = (TextView)findViewById(R.id.single_aroma_caution);

        if(!aroma_nickname.equals("NA")){ 
            txtname.setText(aroma_nickname);
        }
        else{
            txtname.setText(aroma_name);
        }
        txtsub_name.setText(aroma_sub_name);
        icon.setImageResource(icon_adr);
        txtextract_part.setText(aroma_extract_part);
        txtextract_method.setText(aroma_extract_method);
        txtcountry_origin.setText(aroma_country_origin);
        txtdetailed_instructions.setText(aroma_detailed_instructions);
        txtcolor.setText(aroma_color);
        txtblending_oil.setText(aroma_blending_oil);
        txthistory.setText(aroma_history);
        txtcaution.setText(aroma_caution);
    }

    void saveNickName(String section){
        SharedPreferences sp_aroma_setting = null;
        SharedPreferences.Editor editor = null;
        sp_aroma_setting = getApplicationContext().getSharedPreferences("aromaNickName", Context.MODE_PRIVATE);
        if(!aroma_nickname.equals("")) {
            switch (section) {
                case "A":
                    editor = sp_aroma_setting.edit(); 
                    editor.putString(aroma_name, aroma_nickname); 
                    editor.commit();
                    onResume();
                    break;
                case "B":
                    editor = sp_aroma_setting.edit(); 
                    editor.putString(aroma_name, aroma_nickname); 
                    editor.commit();
                    onResume();
                    break;
                case "C":
                    editor = sp_aroma_setting.edit(); 
                    editor.putString(aroma_name, aroma_nickname); 
                    editor.commit();
                    onResume();
                    break;
            }
        }
        else if(aroma_nickname.equals("")){
            sp_aroma_setting = mContext.getSharedPreferences("aromaNickName", Context.MODE_PRIVATE);
            editor = sp_aroma_setting.edit(); 
            editor.putString(aroma_name, "NA"); 
            editor.commit();
            onResume();
        }
    }

    void saveAromaNameofSection(){
        SharedPreferences sp_aroma_setting = null;
        SharedPreferences.Editor editor = null;
        Intent intent = getIntent();
        section = intent.getStringExtra("section");
        aroma_name = intent.getStringExtra("aroma_name");
        if(section.equals("A")){
            sp_aroma_setting = getApplicationContext().getSharedPreferences("aromaSettingsA", Context.MODE_PRIVATE);
            editor = sp_aroma_setting.edit(); 
            editor.putString("aroma_name", aroma_name);
            editor.putInt("aroma_file_name", icon_adr);
            editor.commit();
        }
        if(section.equals("B")){
            sp_aroma_setting = getApplicationContext().getSharedPreferences("aromaSettingsB", Context.MODE_PRIVATE);
            editor = sp_aroma_setting.edit(); 
            editor.putString("aroma_name", aroma_name);
            editor.putInt("aroma_file_name", icon_adr);
            editor.commit();
        }
        if(section.equals("C")){
            sp_aroma_setting = getApplicationContext().getSharedPreferences("aromaSettingsC", Context.MODE_PRIVATE);
            editor = sp_aroma_setting.edit(); 
            editor.putString("aroma_name", aroma_name);
            editor.putInt("aroma_file_name", icon_adr);
            editor.commit();
        }
    }
}
