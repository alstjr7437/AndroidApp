package com.example.customtest01;

import android.graphics.drawable.Drawable;

public class ListViewItem {
    private Drawable icon;
    private String title;
    private String description;

    public Drawable getDrawableIcon() {
        return icon;
    }

    public void setDrawableIcon(Drawable drawableIcon) {
        this.icon = drawableIcon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
