package com.example.applist;

import android.graphics.drawable.Drawable;

public class AppInfo {
    private String name;
    private String packageName;
    private Drawable icon;
    private String version;

    private String size;

    public AppInfo(String name, String packageName, Drawable icon, String version, String size) {
        this.name = name;
        this.packageName = packageName;
        this.icon = icon;
        this.version = version;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public String getPackageName() {
        return packageName;
    }

    public Drawable getIcon() {
        return icon;
    }

    public String getVersion() {
        return version;
    }

    public String getSize() {
        return size;
    }
}
