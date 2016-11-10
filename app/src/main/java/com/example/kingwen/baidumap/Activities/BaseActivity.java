package com.example.kingwen.baidumap.Activities;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by kingwen on 2016/11/10.
 */
public class BaseActivity extends AppCompatActivity {

    private Context mContext=null;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        mContext=getApplicationContext();

    }

    /**
     * 弹出框实习
     * @param tl 显示的时间的长短，1为long 0为short
     * @param tcontent
     */
    public  void  showToast(int tl,String tcontent){

        Toast.makeText(this.getApplicationContext(),tcontent,tl==1?Toast.LENGTH_LONG:Toast.LENGTH_SHORT).show();

    }
}
