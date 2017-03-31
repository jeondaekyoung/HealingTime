package com.healingtime.healingtime_designrenew;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class AromaEditSearchActivity extends AppCompatActivity {
    ListView list;
    AromaListViewAdapter adapter;
    Integer[] aroma_icon;
    ArrayList<DictionaryAromaDTO> arraylist = new ArrayList<DictionaryAromaDTO>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aroma_editsearch_layout);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); 
        getSupportActionBar().setTitle("향기 선택");  
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF83A54E)); 
    }

    @Override
    protected void onResume() {
        super.onResume();

        aroma_icon = new Integer[] {
            R.drawable.aroma_basil, R.drawable.aroma_bergamot_calabrian, R.drawable.aroma_cedarwood_atlas,
            R.drawable.aroma_citronella_ceylon, R.drawable.aroma_clary_sage, R.drawable.aroma_cypress_french,
            R.drawable.aroma_eucalyptus_blue_gum, R.drawable.aroma_fennel_sweet, R.drawable.aroma_frankincense,
            R.drawable.aroma_geranium_egypt, R.drawable.aroma_ginger, R.drawable.aroma_grapefruit_white,
            R.drawable.aroma_juniperberry, R.drawable.aroma_lavender, R.drawable.aroma_lavender,
            R.drawable.aroma_lavender, R.drawable.aroma_lavender, R.drawable.aroma_lavender, R.drawable.aroma_lavender,
            R.drawable.aroma_lemon, R.drawable.aroma_lemongrass_cochin, R.drawable.aroma_lime, R.drawable.aroma_litsea_cubeba,
            R.drawable.aroma_mandarin, R.drawable.aroma_marjoram, R.drawable.aroma_myrrh, R.drawable.aroma_orange_sweet,
            R.drawable.aroma_palmarosa, R.drawable.aroma_patchouli, R.drawable.aroma_pine, R.drawable.aroma_pine_scotch,
            R.drawable.aroma_peppermint, R.drawable.aroma_peppermint, R.drawable.aroma_rose_geranium,
            R.drawable.aroma_rosemary, R.drawable.aroma_rosewood, R.drawable.aroma_spearmint, R.drawable.aroma_tangerine,
            R.drawable.aroma_tea_tree, R.drawable.aroma_thyme, R.drawable.aroma_vetiver, R.drawable.aroma_ylang_ylang,
            R.drawable.aroma_ylang_ylang
        };

        
        String[] aroma_name= getResources().getStringArray(R.array.aroma_name);
        String[] aroma_sub_name= getResources().getStringArray(R.array.aroma_sub_name);
        
        String[] aroma_extract_part= getResources().getStringArray(R.array.aroma_extract_part);
        String[] aroma_extract_method= getResources().getStringArray(R.array.aroma_extract_method);
        String[] aroma_country_origin= getResources().getStringArray(R.array.aroma_country_origin);
        String[] aroma_detailed_instructions= getResources().getStringArray(R.array.aroma_detailed_instructions);
        String[] aroma_color= getResources().getStringArray(R.array.aroma_color);
        String[] aroma_blending_oil= getResources().getStringArray(R.array.aroma_blending_oil);
        String[] aroma_history= getResources().getStringArray(R.array.aroma_history);
        String[] aroma_caution= getResources().getStringArray(R.array.aroma_caution);
        
        String section = getIntent().getExtras().getString("section");

        arraylist.clear();
        list = (ListView) findViewById(R.id.aroma_listview);
        String aroma_name_nickname = null;
        for (int i = 0; i < aroma_name.length; i++)
        {
            
            SharedPreferences sp_aroma_setting = getApplicationContext().getSharedPreferences("aromaNickName", Context.MODE_PRIVATE);
            String aroma_nickname = sp_aroma_setting.getString(aroma_name[i], "NA");

            DictionaryAromaDTO wp = new DictionaryAromaDTO(section, aroma_icon[i], aroma_name[i], aroma_sub_name[i],aroma_nickname
                    , aroma_extract_part[i], aroma_extract_method[i], aroma_country_origin[i], aroma_detailed_instructions[i]
                    , aroma_color[i], aroma_blending_oil[i], aroma_history[i], aroma_caution[i]);
            arraylist.add(wp);
        }
        adapter = new AromaListViewAdapter(this, arraylist);
        list.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        getMenuInflater().inflate(R.menu.aroma_editsearch_actionbar, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.aroma_editsearch).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                adapter.filter(s);
                return false;
            }
        });
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
}
