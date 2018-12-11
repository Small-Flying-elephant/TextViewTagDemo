package com.example.hwx631346.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

public class PopWindowActivity extends Activity implements View.OnClickListener {

    private TextView textView;
    private View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.title);
        view = findViewById(R.id.view);
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        initPopuWindow1(v);
    }
    private PopupWindow popuWindow1;
    private View contentView1;
    private void initPopuWindow1(View parent) {
        if (popuWindow1 == null) {
            LayoutInflater mLayoutInflater = LayoutInflater.from(this);
            contentView1 = mLayoutInflater.inflate(R.layout.new_delete_dialog, null);
            popuWindow1 = new PopupWindow(contentView1,ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        }

//        ColorDrawable cd = new ColorDrawable(0x032200);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            popuWindow1.setBackgroundDrawable(getDrawable(R.drawable.btn_transparent));
        }
        //产生背景变暗效果
        WindowManager.LayoutParams lp=getWindow().getAttributes();
        lp.alpha = 0.4f;
        getWindow().setAttributes(lp);
        view.setVisibility(View.VISIBLE);
        popuWindow1.setOutsideTouchable(true);
        popuWindow1.setFocusable(true);
        popuWindow1.showAtLocation((View)parent.getParent(), Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);

        popuWindow1.update();
        popuWindow1.setOnDismissListener(new PopupWindow.OnDismissListener(){

            //在dismiss中恢复透明度
            public void onDismiss(){
                WindowManager.LayoutParams lp=getWindow().getAttributes();
                lp.alpha = 1f;
                getWindow().setAttributes(lp);
            }
        });
    }




}
