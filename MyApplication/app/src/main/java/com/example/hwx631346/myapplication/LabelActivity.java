package com.example.hwx631346.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.widget.TextView;

public class LabelActivity extends Activity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_label);
        textView = findViewById(R.id.text);
        String[] tags = {"小视频"};
        SpannableStringBuilder stringBuilder = new SpannableStringBuilder();
        for (String tag : tags) {
            String thisTag = " " + tag + " ";
            stringBuilder.append(thisTag);
            stringBuilder.setSpan(new AbsoluteSizeSpan(sp2px(getApplicationContext(),12)), 0, thisTag.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            RoundedBackgroundSpan span;
            if("活动".equals(tag)){
                span= new RoundedBackgroundSpan(ContextCompat.getColor(this,R.color.colorPrimary), ContextCompat.getColor(this,R.color.white_alpha_70),getApplicationContext());
            }else if ("推荐".equals(tag)){
                span= new RoundedBackgroundSpan(ContextCompat.getColor(this,R.color.colorPrimaryDark), ContextCompat.getColor(this,R.color.white_alpha_70),getApplicationContext());
            }else{
                span= new RoundedBackgroundSpan(ContextCompat.getColor(this,R.color.colorAccent), ContextCompat.getColor(this,R.color.white_alpha_70),getApplicationContext());
            }
            stringBuilder.setSpan(span, stringBuilder.length() - thisTag.length(), stringBuilder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            stringBuilder.append("  ");
        }
        stringBuilder.append("王宝强凌晨宣布离婚，妻子劈腿经纪人。");
        textView.setText(stringBuilder);
    }


    /**
     * 将sp值转换为px值，保证文字大小不变
     * @param spValue
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}