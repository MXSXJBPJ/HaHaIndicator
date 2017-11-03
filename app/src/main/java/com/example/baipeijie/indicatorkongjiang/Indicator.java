package com.example.baipeijie.indicatorkongjiang;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 梦想实现家BAIPEIJIE on 2017/10/12.
 */

public class Indicator extends View{

   private Paint mForePaint;//前景色的圆
   private Paint mBgPaint;//背景色的圆

    private int mNumber = 4;//Indicator数量
    private int mRadius = 10;//半径
    private int mBgColor = Color.BLUE;//背景色画笔颜色
    private int mForeColor = Color.GREEN;//前景色画笔颜色
    /****
     * 设置偏移量的方法
     * */
    public void setOffset(int position,float positionOffset) {
        position %= mNumber;
        mOffset = position*3*mRadius+positionOffset*3*mRadius;
        //重绘
        invalidate();

    }

    private float mOffset;//移动偏移量
    public Indicator(Context context) {

        super(context);
    }

    public Indicator(Context context,  AttributeSet attrs) {
        super(context, attrs);
        initPaint();

     TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.Indicator);
        mNumber =  typedArray.getInteger(R.styleable.Indicator_Indicator_number,mNumber);
    }

    private void initPaint(){//画笔方法
        mForePaint = new Paint();//画笔对象
        mForePaint.setAntiAlias(true);//消除锯齿
        mForePaint.setStyle(Paint.Style.FILL);//实心
        mForePaint.setColor(mForeColor);//画笔颜色
        mForePaint.setStrokeWidth(2);//笔尖粗度


        mBgPaint = new Paint();//画笔对象
        mBgPaint.setAntiAlias(true);//消除锯齿
        mBgPaint.setStyle(Paint.Style.STROKE);//实心
        mBgPaint.setColor(mBgColor);//画笔颜色
        mBgPaint.setStrokeWidth(2);//笔尖粗度


    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < mNumber; i++) {
            canvas.drawCircle(60+i*mRadius*3, 60, mRadius, mBgPaint);//（？？？？）
        }
        canvas.drawCircle(60+mOffset, 60, mRadius, mForePaint);
    }
}
