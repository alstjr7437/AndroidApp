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
    //아이템을 저장할 배열 만들어주기
    private ArrayList<item> listViewItemList = new ArrayList<item>();
    @Override
    //아이템 카운트를 위해 size를 이용
    public int getCount() {
        return listViewItemList.size();
    }
    @Override
    //아이템을 가져오기 위해 get이용 
    public Object getItem(int i) {
        return listViewItemList.get(i);
    }
    @Override
    //아이디를 가져오기 위해 i를 반환
    public long getItemId(int i) {
        return i;
    }
    @Override
    //보여주기 위한 메소드
    public View getView(int i, View view, ViewGroup viewGroup) {
        //context 만들어주기
        final Context context = viewGroup.getContext();
        //화면이 없을시
        if(view == null) {
            //inflater를 이용하여 메모리에 기준을 잡아서 펼치기 위한 코드
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //listitem inflate해오기
            view = inflater.inflate(R.layout.listitem, viewGroup, false);
        }

        //listitem에서 화면들 받아오기
        ImageView iconImageView = (ImageView) view.findViewById(R.id.imageView) ;
        TextView titleTextView = (TextView) view.findViewById(R.id.textView) ;
        TextView descTextView = (TextView) view.findViewById(R.id.textView2) ;

        //아이템 > 뷰에 들어갈 정보
        item item = listViewItemList.get(i);

        //listitem에서 받아온거 set해주기
        iconImageView.setImageResource(item.getPic());
        titleTextView.setText(item.getTitle());
        descTextView.setText("총 "+item.getDesc()+"표");

        //화면으로 반환해주기
        return view;
    }

    //addItem를 이용하여 icon과 타이틀과 투표 결과를 set하기
    public void addItem(int icon, String title, int desc){
        item item = new item();
        item.setPic(icon);
        item.setTitle(title);
        item.setDesc(desc);
        listViewItemList.add(item);
    }
}
