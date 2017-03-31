package com.healingtime.healingtime_designrenew;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by scr44 on 2017-01-10.
 */

public class DictionaryColorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dictionary_color_layout);

        
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        getSupportActionBar().setTitle("컬러 사전");
        
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF83A54E));

        
        RelativeLayout therapy_dictionary_aroma = (RelativeLayout)findViewById(R.id.therapy_dictionary_aroma2);
        therapy_dictionary_aroma.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                
                Intent intent = new Intent(getApplicationContext(), DictionaryAromaActivity.class);
                startActivity(intent);
                finish();
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
                Intent intent = new Intent(getApplicationContext(), AromaMainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        LinearLayout link_dictionary = (LinearLayout) findViewById(R.id.link_dictionary);
        link_dictionary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



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
        dictionaryColorDisplay();
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

    void dictionaryColorDisplay(){

        
        String[] color_red= getResources().getStringArray(R.array.color_red);
        SpannableStringBuilder ss_red_contents = new SpannableStringBuilder(color_red[1]);
        TextView t_red_contents = (TextView)findViewById(R.id.color_dictionary_red_contents);
        t_red_contents.setText(ss_red_contents);

        
        String[] color_orange= getResources().getStringArray(R.array.color_orange);
        SpannableStringBuilder ss_orange_contents = new SpannableStringBuilder(color_orange[1]);
        TextView t_orange_contents = (TextView)findViewById(R.id.color_dictionary_orange_contents);
        t_orange_contents.setText(ss_orange_contents);

        
        String[] color_yellow= getResources().getStringArray(R.array.color_yellow);
        SpannableStringBuilder ss_yellow_contents = new SpannableStringBuilder(color_yellow[1]);
        TextView t_yellow_contents = (TextView)findViewById(R.id.color_dictionary_yellow_contents);
        t_yellow_contents.setText(ss_yellow_contents);

        
        String[] color_green= getResources().getStringArray(R.array.color_green);
        SpannableStringBuilder ss_green_contents = new SpannableStringBuilder(color_green[1]);
        TextView t_green_contents = (TextView)findViewById(R.id.color_dictionary_green_contents);
        t_green_contents.setText(ss_green_contents);

        
        String[] color_blue= getResources().getStringArray(R.array.color_blue);
        SpannableStringBuilder ss_blue_contents = new SpannableStringBuilder(color_blue[1]);
        TextView t_blue_contents = (TextView)findViewById(R.id.color_dictionary_blue_contents);
        t_blue_contents.setText(ss_blue_contents);

        
        String[] color_purple= getResources().getStringArray(R.array.color_purple);
        SpannableStringBuilder ss_purple_contents = new SpannableStringBuilder(color_purple[1]);
        TextView t_purple_contents = (TextView)findViewById(R.id.color_dictionary_purple_contents);
        t_purple_contents.setText(ss_purple_contents);

        
        String[] color_white= getResources().getStringArray(R.array.color_white);
        SpannableStringBuilder ss_white_contents = new SpannableStringBuilder(color_white[1]);
        TextView t_white_contents = (TextView)findViewById(R.id.color_dictionary_white_contents);
        t_white_contents.setText(ss_white_contents);

        
        String[] color_black= getResources().getStringArray(R.array.color_black);
        SpannableStringBuilder ss_black_contents = new SpannableStringBuilder(color_black[1]);
        TextView t_black_contents = (TextView)findViewById(R.id.color_dictionary_black_contents);
        t_black_contents.setText(ss_orange_contents);
    }
}
