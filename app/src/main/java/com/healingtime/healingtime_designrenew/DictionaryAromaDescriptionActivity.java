package com.healingtime.healingtime_designrenew;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.healingtime.healingtime_designrenew.MainActivity.mContext;

public class DictionaryAromaDescriptionActivity extends AppCompatActivity {
    
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
    String aroma_name;
    String aroma_sub_name;
    String aroma_nickname;
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
        setContentView(R.layout.dictionary_aroma_desc_layout);

        
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        getSupportActionBar().setTitle("아로마 상세보기");
        
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF83A54E));

        Intent i = getIntent();
        aroma_name = i.getStringExtra("aroma_name");
        SharedPreferences sp_aroma_setting = mContext.getSharedPreferences("aromaNickName", Context.MODE_PRIVATE);
        aroma_nickname = sp_aroma_setting.getString(aroma_name, "NA");
        aroma_sub_name = i.getStringExtra("aroma_sub_name");
        icon_adr = i.getIntExtra("icon", -1);
        aroma_extract_part = i.getStringExtra("aroma_extract_part");
        aroma_extract_method = i.getStringExtra("aroma_extract_method");
        aroma_country_origin = i.getStringExtra("aroma_country_origin");
        aroma_detailed_instructions = i.getStringExtra("aroma_detailed_instructions");
        aroma_color = i.getStringExtra("aroma_color");
        aroma_blending_oil = i.getStringExtra("aroma_blending_oil");
        aroma_history = i.getStringExtra("aroma_history");
        aroma_caution = i.getStringExtra("aroma_caution");

        
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

        
        Button buy_btn = (Button) findViewById(R.id.buy_btn);
        buy_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "준비중입니다.", Toast.LENGTH_LONG).show();
            }
        });
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
}
