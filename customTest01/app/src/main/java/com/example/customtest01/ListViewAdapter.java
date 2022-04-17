package com.example.customtest01;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    private ArrayList<ListViewItem> listViewItemList = new ArrayList();
    public ListViewAdapter() {}

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
        final int pos = i;
        final Context context = viewGroup.getContext();

        if(view == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view =inflater.inflate(R.layout.listitem, viewGroup, false);
        }
        ImageView icon = (ImageView) view.findViewById(R.id.imageView);
        TextView title = (TextView) view.findViewById(R.id.textView);
        TextView desc = (TextView) view.findViewById(R.id.textView2);

        ListViewItem listViewItem =listViewItemList.get(i);

        icon.setImageDrawable(listViewItem.getDrawableIcon());
        title.setText(listViewItem.getTitle());
        desc.setText(listViewItem.getDescription());

        return view;
    }

    public void addItem(Drawable icon, String title, String desc){
        ListViewItem item = new ListViewItem();
        item.setDrawableIcon(icon);
        item.setTitle(title);
        item.setDescription(desc);
        listViewItemList.add(item);
    }

}
