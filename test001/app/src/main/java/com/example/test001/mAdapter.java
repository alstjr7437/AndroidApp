package com.example.test001;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class mAdapter extends BaseAdapter {
    private ArrayList<item> listViewItemList = new ArrayList<item>();
    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int i) {
        return listViewItemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final Context context = viewGroup.getContext();
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listitem, viewGroup, false);
        }

        ImageView iconImageView = (ImageView) view.findViewById(R.id.imageView) ;
        TextView titleTextView = (TextView) view.findViewById(R.id.textView) ;
        TextView descTextView = (TextView) view.findViewById(R.id.textView2) ;

        //아이템 > 뷰에 들어갈 정보
        item item = listViewItemList.get(i);

        iconImageView.setImageResource(item.getPic());
        titleTextView.setText(item.getTitle());
        descTextView.setText(item.getDesc()+"횟수");

        return view;
    }

    public void addItem(int icon, String title, int desc){
        item item = new item();
        item.setPic(icon);
        item.setTitle(title);
        item.setDesc(desc);
        listViewItemList.add(item);
    }
}
