package com.example.kingwen.baidumap.Application;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by kingwen on 2016/11/10.
 * 全局变量，用于整个程序的初始化工作和全局变量的使用情况
 */
public class BaiduApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        /**
         * 百度地图初始化
         */
        SDKInitializer.initialize(getApplicationContext());

    }
}
