package com.example.test01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class mAdapter extends BaseAdapter {
    private ArrayList<item> listitem = new ArrayList<>();
    @Override
    public int getCount() {
        return listitem.size();
    }

    @Override
    public Object getItem(int i) {
        return listitem.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final Context con = viewGroup.getContext();
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view =inflater.inflate(R.layout.listitem, viewGroup, false);
        }

        ImageView pic = (ImageView)view.findViewById(R.id.imageView10);
        TextView title = (TextView)view.findViewById(R.id.textView);
        TextView vote = (TextView)view.findViewById(R.id.textView2);

        item item = listitem.get(i);

        pic.setImageResource(item.getPic());
        title.setText(item.getTitle());
        vote.setText(item.getVote() +"표 받았습니다!");

        return view;
    }
    public void addItem(int pic, String title, int vote){
        item item = new item();
        item.setPic(pic);
        item.setTitle(title);
        item.setVote(vote);

        listitem.add(item);
    }
}
