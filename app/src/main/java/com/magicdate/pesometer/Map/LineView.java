package com.magicdate.pesometer.Map;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class LineView extends View {

    private Paint paint = new Paint();
    PointF pointA , pointB ;
    private ArrayList<Line> lines  = new ArrayList<>() ;
    ;

    public LineView(Context context) {
        super(context);
    }

    public LineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(15);
        for (int i = 0 ; i < lines.size() ; i++)
        {
            PointF pointA = new PointF();

            PointF pointB = new PointF();

            pointA.x = lines.get(i).pointA.x ;
            pointA.y = lines.get(i).pointA.y ;
            pointB.x = lines.get(i).pointB.x ;
            pointB.y = lines.get(i).pointB.y ;

            canvas.drawLine(pointA.x , pointA.y , pointB.x , pointB.y , paint );

        }



        super.onDraw(canvas);
    }


    public void setPointA(PointF pointA)
    {
        this.pointA = pointA ;
    }

    public void setPointB (PointF pointB)
    {
        this.pointB = pointB ;
    }

    public void addNewLine(Line line) // Add new line to the array list
    {
        lines.add(line) ;
    }

    public void draw()
    {
        invalidate();
        requestLayout();
    }
}

