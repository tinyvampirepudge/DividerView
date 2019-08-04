package com.tinytongtong.dividerviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
/**
 * @Description: 隐式Intent调用——调起DividerDemo应用的D页面，singleTop启动模式
 *
 * @Author wangjianzhou@qding.me
 * @Date 2019-08-04 20:36
 * @Version TODO
 */
public class DActivity extends AppCompatActivity {
    public static final String TAG = DActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);

        String dataString = getIntent().getDataString();
        Log.e(TAG, dataString);

        findViewById(R.id.btn_to_main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.actionStart(DActivity.this);
            }
        });
    }

    /**
     * 隐式Intent启动调用代码
     */
    public void onBtnIntentTest9Clicked() {
        Intent intent = new Intent();
        //action
        intent.setAction("com.tinytongtong.dividerviewdemo.action.d");
        //Category可以不设置，因为一般在AndroidManifest.xml会设置Default，startActivity方法中也会默认添加Default。
        intent.addCategory("com.tinytongtong.dividerviewdemo.category.d");
        //Data在AndroidManifest.xml中可不添加，相应的，在隐式调用时也不用添加。
        intent.setDataAndType(Uri.parse("http://www.tiny.com:8080/猫了个咪"), "text/plain");
        if (intent.resolveActivity(getPackageManager()) != null) {
            Log.e(TAG, "match success");
            startActivity(intent);
        } else {
            Log.e(TAG, "match failure");
        }
    }
}
