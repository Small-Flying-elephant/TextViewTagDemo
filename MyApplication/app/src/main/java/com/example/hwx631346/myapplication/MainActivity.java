package com.example.hwx631346.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.title);
        textView.setText("a哈哈哈哈哈哈哈哈哈哈哈hdflkjahsdfljkahdflkjahsdflkjashflkjashfljashdflaskjfhlaskjhfd");
        try {
            textView.setText(subStr(textView.getText().toString(), 16));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public  String subStr(String str, int subSLength)
               throws UnsupportedEncodingException {
            if (str == null) {
                return "";
            }
            else{
                int tempSubLength = subSLength;//截取字节数
                String subStr = str.substring(0, str.length()<subSLength ? str.length() : subSLength);//截取的子串
                int subStrByetsL = subStr.getBytes("GBK").length;//截取子串的字节长度
                while (subStrByetsL > tempSubLength){
                    int subSLengthTemp = --subSLength;
                    subStr = str.substring(0, subSLengthTemp>str.length() ? str.length() : subSLengthTemp);
                    subStrByetsL = subStr.getBytes("GBK").length;
                }
                return subStr;
            }
        }

//        button = findViewById(R.id.bt);
//        view = findViewById(R.id.content);
//        notchAdaptedWithActionbar(this,view);
//        setStatusBarVisibility();
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                PackageManager packageManager = getPackageManager();
//                Intent intent=new Intent();
//                intent =packageManager.getLaunchIntentForPackage("cn.wps.moffice_eng");
//                if(intent==null){
//                    Toast.makeText(MainActivity.this, "未安装", Toast.LENGTH_LONG).show();
//                }else{
//                    startActivity(intent);
//                }
//            }
//        });
//    }


    public void notchAdaptedWithActionbar(Activity activity, View contentView) {
        Window window = activity.getWindow();
        if (window == null) {
            return;
        }
        if (window == null) {
            return;
        }
        View decorView = window.getDecorView();
        if (decorView != null) {
            int option = decorView.getSystemUiVisibility();
            option |= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            decorView.setSystemUiVisibility(option);
        }
    }

    protected void setStatusBarVisibility() {
        showNormalStatusBar(this);
    }
    public  void showNormalStatusBar(Activity activity) {
        if (activity == null) {
            return;
        }

        Window window = activity.getWindow();
        if (window == null) {
            return;
        }

        // for emui theme
        window.addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        View decorView = window.getDecorView();
        showStatusBar(decorView);
    }

    public  void showStatusBar(View view) {
        if (view == null) {
            return;
        }
        int systemUiVisibility = view.getSystemUiVisibility();
        systemUiVisibility &= ~View.SYSTEM_UI_FLAG_FULLSCREEN;
        view.setSystemUiVisibility(systemUiVisibility);
    }


    @Override
    protected void onResume() {
        super.onResume();

        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
    }
}
