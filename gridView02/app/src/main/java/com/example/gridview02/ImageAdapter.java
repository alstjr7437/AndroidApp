package com.example.gridview02;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context context;

    ImageAdapter(Context c){
        context = c;
    }

    @Override
    public int getCount() {
        return imageId.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(250, 250));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,20,8,20);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(imageId[position]);
        return imageView;

    }

    //사진들 배열에 넣기
    int[] imageId = {R.drawable.movie1, R.drawable.movie2, R.drawable.movie3, R.drawable.movie4,
            R.drawable.movie1, R.drawable.movie2, R.drawable.movie3, R.drawable.movie4,
            R.drawable.movie1, R.drawable.movie2, R.drawable.movie3, R.drawable.movie4,
            R.drawable.movie1, R.drawable.movie2, R.drawable.movie3, R.drawable.movie4,
            R.drawable.movie1, R.drawable.movie2, R.drawable.movie3, R.drawable.movie4,
            R.drawable.movie1, R.drawable.movie2, R.drawable.movie3, R.drawable.movie4,
            R.drawable.movie1, R.drawable.movie2, R.drawable.movie3, R.drawable.movie4,
            R.drawable.movie1, R.drawable.movie2, R.drawable.movie3, R.drawable.movie4,
            R.drawable.movie1, R.drawable.movie2, R.drawable.movie3, R.drawable.movie4};
}
