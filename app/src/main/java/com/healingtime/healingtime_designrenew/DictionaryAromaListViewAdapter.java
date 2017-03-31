package com.healingtime.healingtime_designrenew;

import android.content.Context;
import android.content.Intent;
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

public class DictionaryAromaListViewAdapter extends BaseAdapter {

    
    Context mContext;
    LayoutInflater inflater;
    private List<DictionaryAromaDTO> DictionaryAromaDTOlist = null;
    private ArrayList<DictionaryAromaDTO> arraylist;

    public DictionaryAromaListViewAdapter(Context context, List<DictionaryAromaDTO> DictionaryAromaDTOlist) {
        mContext = context;
        this.DictionaryAromaDTOlist = DictionaryAromaDTOlist;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<DictionaryAromaDTO>();
        this.arraylist.addAll(DictionaryAromaDTOlist);
    }

    public class ViewHolder {
        TextView aroma_name;
        TextView aroma_sub_name;
        ImageView icon;
    }

    @Override
    public int getCount() {
        return DictionaryAromaDTOlist.size();
    }

    @Override
    public DictionaryAromaDTO getItem(int position) {
        return DictionaryAromaDTOlist.get(position);
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
        
        holder.aroma_name.setText(DictionaryAromaDTOlist.get(position).getAroma_name());
        holder.aroma_name.setTextSize(18);
        holder.aroma_sub_name.setText(DictionaryAromaDTOlist.get(position).getAroma_sub_name());
        holder.aroma_sub_name.setTextSize(15);
        holder.icon.setImageResource(DictionaryAromaDTOlist.get(position).getIcon());

        
        view.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(mContext, DictionaryAromaDescriptionActivity.class);
                intent.putExtra("aroma_name",(DictionaryAromaDTOlist.get(position).getAroma_name()));
                intent.putExtra("aroma_sub_name",(DictionaryAromaDTOlist.get(position).getAroma_sub_name()));
                intent.putExtra("icon",(DictionaryAromaDTOlist.get(position).getIcon()));
                intent.putExtra("aroma_extract_part", (DictionaryAromaDTOlist.get(position).getAroma_extract_part()));
                intent.putExtra("aroma_extract_method", (DictionaryAromaDTOlist.get(position).getAroma_extract_method()));
                intent.putExtra("aroma_country_origin", (DictionaryAromaDTOlist.get(position).getAroma_country_origin()));
                intent.putExtra("aroma_detailed_instructions", (DictionaryAromaDTOlist.get(position).getAroma_detailed_instructions()));
                intent.putExtra("aroma_color", (DictionaryAromaDTOlist.get(position).getAroma_color()));
                intent.putExtra("aroma_blending_oil", (DictionaryAromaDTOlist.get(position).getAroma_blending_oil()));
                intent.putExtra("aroma_history", (DictionaryAromaDTOlist.get(position).getAroma_history()));
                intent.putExtra("aroma_caution", (DictionaryAromaDTOlist.get(position).getAroma_caution()));
                mContext.startActivity(intent);
            }
        });
        return view;
    }

    
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        DictionaryAromaDTOlist.clear();
        if (charText.length() == 0) {
            DictionaryAromaDTOlist.addAll(arraylist);
        }
        else
        {
            for (DictionaryAromaDTO wp : arraylist)
            {
                if (wp.getAroma_name().toLowerCase(Locale.getDefault()).contains(charText))
                {
                    DictionaryAromaDTOlist.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}