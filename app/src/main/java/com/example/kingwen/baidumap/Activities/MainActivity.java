package com.example.kingwen.baidumap.Activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.example.kingwen.baidumap.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends BaseActivity {


    private MapView mapView = null;

    private BaiduMap baiduMap=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initViews();

        LocationPoint();


        initListener() ;


    }

    /**
     *  设置监听器
     */
    private void initListener() {
       baiduMap.setOnMapClickListener(new BaiduMap.OnMapClickListener() {
           @Override
           public void onMapClick(LatLng latLng) {

               showToast(0,latLng.toString());

               //根据坐标点判断相册,然后将相册的地址
               Intent intent=new Intent(MainActivity.this,TestActivity.class);
               startActivity(intent);

           }

           @Override
           public boolean onMapPoiClick(MapPoi mapPoi) {
               return false;
           }
       });
    }

    /**
     * 定位功能，给对应的位置添加相应的覆盖物
     */
    private void LocationPoint() {

        //定义Maker坐标点
        LatLng point = new LatLng(39.963175, 116.400244);
        //构建Marker图标
        BitmapDescriptor bitmap = BitmapDescriptorFactory
                .fromResource(R.drawable.baidu_location);
       //构建MarkerOption，用于在地图上添加Marker
        OverlayOptions option = new MarkerOptions()
                .position(point)
                .icon(bitmap);
        //在地图上添加Marker，并显示
        baiduMap.addOverlay(option);

    }


    /**
     * 初始化view
     */
    private void initViews() {

        mapView = (MapView) findViewById(R.id.bmapView);

        baiduMap=mapView.getMap();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();


    }
}
