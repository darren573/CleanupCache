package com.example.ewan.cleanupcache;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ewan.cleanupcache.activity.BaseActivity;
import com.example.ewan.cleanupcache.utils.CleanupCache;

import java.io.File;

public class MainActivity extends BaseActivity {
    private TextView tv_size;
    private RelativeLayout rl_Cache;
    private String dataSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_size = (TextView) findViewById(R.id.tv_size);
        rl_Cache = (RelativeLayout) findViewById(R.id.rl_Cache);
        //获取缓存大小
        dataSize = getDataSize();
        tv_size.setText("缓存大小为：" + dataSize);
        rl_Cache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("提示");
                builder.setMessage("是否清空缓存");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        CleanupCache.cleanApplicationDataNoSP(MainActivity.this);
                        dataSize = getDataSize();//获取缓存大小
                        tv_size.setText("缓存大小为：" + dataSize);
                    }
                });
                builder.show();
            }
        });
    }

    private String getDataSize() {
        long fileSize = 0;
        File fileDir = getFilesDir();
        File cacheDir = getCacheDir();
        fileSize += CleanupCache.getDirSize(fileDir);
        fileSize += CleanupCache.getDirSize(cacheDir);
        String formatSize = CleanupCache.getFormatSize(fileSize);
        return formatSize;
    }
}
