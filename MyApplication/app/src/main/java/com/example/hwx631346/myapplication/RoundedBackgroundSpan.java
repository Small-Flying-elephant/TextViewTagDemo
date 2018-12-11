package com.example.hwx631346.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import android.util.Log;

public class RoundedBackgroundSpan extends ReplacementSpan {
    private static int CORNER_RADIUS = 8;
    private int backgroundColor = 0;
    private int textColor = 0;
    private Context context;

    public RoundedBackgroundSpan(int backgroundColor, int textColor, Context context) {
        super();
        this.context = context;
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Paint.FontMetrics fm = paint.getFontMetrics();
//        RectF rect = new RectF(x, top, x + measureText(paint, text, start, end), bottom);
        // fm.bottom - fm.top 解决设置行距（android:lineSpacingMultiplier="1.2"）时背景色高度问题
        RectF rect = new RectF(x, y - (fm.descent - fm.ascent) , x + measureText(paint, text, start, end) + LabelActivity.sp2px(context,4), y );
        paint.setColor(backgroundColor);
        canvas.drawRoundRect(rect, CORNER_RADIUS, CORNER_RADIUS, paint);
        paint.setColor(textColor);
        canvas.drawText(text, start , end ,x + LabelActivity.sp2px(context,2) , (fm.bottom - fm.top) + (y - (fm.bottom - fm.top))/2 , paint);
    }

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm){
        return Math.round(paint.measureText(text, start, end));
    }

    private float measureText(Paint paint, CharSequence text, int start, int end) {
        return paint.measureText(text, start, end);
    }
}






//    Paint.FontMetrics fm = paint.getFontMetrics();
//    //        RectF rect = new RectF(x, top, x + measureText(paint, text, start, end), bottom);
//    // fm.bottom - fm.top 解决设置行距（android:lineSpacingMultiplier="1.2"）时背景色高度问题
//    RectF rect = new RectF(x, y - (fm.descent - fm.ascent) , x + measureText(paint, text, start, end) + LabelActivity.sp2px(context,4), y );
//    paint.setColor(backgroundColor);
//    canvas.drawRoundRect(rect, CORNER_RADIUS, CORNER_RADIUS, paint);
//    paint.setColor(textColor);
//    canvas.drawText(text, start , end ,x + LabelActivity.sp2px(context,2) , (fm.bottom - fm.top) + (y - (fm.bottom - fm.top))/2 , paint);