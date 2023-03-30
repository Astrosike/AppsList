package com.example.applist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AppListAdapter extends BaseAdapter {
    private List<AppInfo> appList;
    private Context context;

    public AppListAdapter(Context context, List<AppInfo> appList) {
        this.context = context;
        this.appList = appList;
    }

    @Override
    public int getCount() {
        return appList.size();
    }

    @Override
    public Object getItem(int position) {
        return appList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.app_list_item, parent, false);
        }

        AppInfo appInfo = appList.get(position);

        TextView appNameView = convertView.findViewById(R.id.app_name);
        appNameView.setText(appInfo.getName());

        ImageView appIconView = convertView.findViewById(R.id.app_icon);
        appIconView.setImageDrawable(appInfo.getIcon());

        TextView appVersionView = convertView.findViewById(R.id.app_version);
        appVersionView.setText("Version: " + appInfo.getVersion());

        TextView appSizeView = convertView.findViewById(R.id.app_size);
        appSizeView.setText("Size: " + appInfo.getSize());

        return convertView;
    }
}
