package com.healingtime.healingtime_designrenew;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AromaListViewAdapter extends BaseAdapter {

    
    Context mContext;
    LayoutInflater inflater;
    private List<DictionaryAromaDTO> dictionary_aroma_list = null;
    private ArrayList<DictionaryAromaDTO> arraylist;

    public AromaListViewAdapter(Context context, List<DictionaryAromaDTO> dictionary_aroma_list) {
        mContext = context;
        this.dictionary_aroma_list = dictionary_aroma_list;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<DictionaryAromaDTO>();
        this.arraylist.addAll(dictionary_aroma_list);
    }

    public class ViewHolder {
        TextView aroma_name;
        TextView aroma_sub_name;
        ImageView icon;
    }

    @Override
    public int getCount() {
        return dictionary_aroma_list.size();
    }

    @Override
    public DictionaryAromaDTO getItem(int position) {
        return dictionary_aroma_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);
            
            holder.aroma_name = (TextView) view.findViewById(R.id.aroma_item_name);
            holder.aroma_sub_name = (TextView) view.findViewById(R.id.aroma_item_subname);
            holder.icon = (ImageView) view.findViewById(R.id.aroma_item_icon);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        SharedPreferences sp_aroma_setting = mContext.getSharedPreferences("aromaNickName", Context.MODE_PRIVATE);
        String aroma_nickname = sp_aroma_setting.getString(dictionary_aroma_list.get(position).getAroma_name(), "NA");
        if(aroma_nickname.equals("NA")){ 
            holder.aroma_name.setText(dictionary_aroma_list.get(position).getAroma_name());
        }
        else{
            holder.aroma_name.setText(dictionary_aroma_list.get(position).getAroma_nickname());
        }

        holder.aroma_name.setTextSize(18);
        holder.aroma_sub_name.setText(dictionary_aroma_list.get(position).getAroma_sub_name());
        holder.aroma_sub_name.setTextSize(15);
        holder.icon.setImageResource(dictionary_aroma_list.get(position).getIcon());

        
        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(mContext, AromaEditSettingActivity.class);
                intent.putExtra("section", (dictionary_aroma_list.get(position).getSection()));
                intent.putExtra("aroma_name",(dictionary_aroma_list.get(position).getAroma_name()));
                intent.putExtra("aroma_nickname",(dictionary_aroma_list.get(position).getAroma_nickname()));
                intent.putExtra("aroma_sub_name",(dictionary_aroma_list.get(position).getAroma_sub_name()));
                intent.putExtra("icon",(dictionary_aroma_list.get(position).getIcon()));
                intent.putExtra("aroma_extract_part", (dictionary_aroma_list.get(position).getAroma_extract_part()));
                intent.putExtra("aroma_extract_method", (dictionary_aroma_list.get(position).getAroma_extract_method()));
                intent.putExtra("aroma_country_origin", (dictionary_aroma_list.get(position).getAroma_country_origin()));
                intent.putExtra("aroma_detailed_instructions", (dictionary_aroma_list.get(position).getAroma_detailed_instructions()));
                intent.putExtra("aroma_color", (dictionary_aroma_list.get(position).getAroma_color()));
                intent.putExtra("aroma_blending_oil", (dictionary_aroma_list.get(position).getAroma_blending_oil()));
                intent.putExtra("aroma_history", (dictionary_aroma_list.get(position).getAroma_history()));
                intent.putExtra("aroma_caution", (dictionary_aroma_list.get(position).getAroma_caution()));
                mContext.startActivity(intent);
            }
        });
        return view;
    }

    
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        dictionary_aroma_list.clear();
        if (charText.length() == 0) {
            dictionary_aroma_list.addAll(arraylist);
        }
        else
        {
            for (DictionaryAromaDTO wp : arraylist)
            {
                if (wp.getAroma_name().toLowerCase(Locale.getDefault()).contains(charText))
                {
                    dictionary_aroma_list.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}