package com.example.applist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AppListActivity extends AppCompatActivity {
    private ListView appListView;
    private AppListAdapter appListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applist);

        appListView = findViewById(R.id.app_list_view);

        List<AppInfo> appList = new ArrayList<>();
        PackageManager packageManager = getPackageManager();

        List<PackageInfo> packages = packageManager.getInstalledPackages(0);
        for (PackageInfo packageInfo : packages) {
            String appName = packageInfo.applicationInfo.loadLabel(packageManager).toString();
            String packageName = packageInfo.packageName;
            Drawable appIcon = packageInfo.applicationInfo.loadIcon(packageManager);
            String version = packageInfo.versionName;
            String size = String.valueOf(packageInfo.applicationInfo.dataDir.length());
            appList.add(new AppInfo(appName, packageName, appIcon, version, size));
        }

        appListAdapter = new AppListAdapter(this, appList);
        appListView.setAdapter(appListAdapter);
    }
}