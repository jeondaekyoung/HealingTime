package com.healingtime.healingtime_designrenew;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by test on 2017-02-10.
 */

public class DrawingView extends View {

    private float mCenterX; 
    private float mCenterY; 
    private float mRadius= 0.0f; 
    private Paint mCirclePaint;
    float circle_angle1;

    public float getCircle_angle1() {
        return circle_angle1;
    }

    public void setCircle_angle1(float circle_angle1) {
        this.circle_angle1 = circle_angle1;
    }

    public DrawingView(Context context) {
        super(context);
        initPaint();
    }

    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public DrawingView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initPaint();
    }

    private void initPaint(){








    }

    @Override
    protected void onDraw(Canvas canvas) {

        
        Paint pnt = new Paint();
        pnt.setAntiAlias(true);
        pnt.setStyle(Paint.Style.STROKE);

        float den = getResources().getDisplayMetrics().density;

        pnt.setColor(0xFF9BBA6D);
        pnt.setStrokeWidth(4*den);
        canvas.drawOval(new RectF(2*den, 2*den, 88*den, 88*den), pnt);






    }

    void drawCircle(Canvas canvas){
        
        Paint pnt = new Paint();
        pnt.setAntiAlias(true);
        pnt.setStyle(Paint.Style.STROKE);

        float den = getResources().getDisplayMetrics().density;

        pnt.setColor(0xFF9BBA6D);
        pnt.setStrokeWidth(4*den);
        canvas.drawOval(new RectF(2*den, 2*den, 88*den, 88*den), pnt);

        pnt.setColor(0xFFFFFFFF);
        RectF rect = new RectF();
        rect.set(2*den, 2*den, 88*den, 88*den);
        pnt.setStrokeWidth(4*den);
        canvas.drawArc(rect, 270 , -((360F/100F)*circle_angle1), false, pnt);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
/*        mCenterX = (float)w*0.5f;
        mCenterY = (float)h*0.5f;
        mRadius = (w < h ? (w*0.25f): (h*0.25f));

        int left = this.getPaddingLeft();
        int top = this.getPaddingTop();
        int right = this.getPaddingRight();
        int bottom = this.getPaddingBottom();

        if(mCenterX < mCenterY){
            mRadius = mCenterX - left - right;
        }
        else{
            mRadius = mCenterY - top - bottom;
        }*/
    }
}