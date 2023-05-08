package com.example.testgithublib;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
/**
 * @description我们定义了一个ProgressBarView类，继承自View类。在构造方法中，
 * 我们初始化了两个画笔对象：progressPaint用于绘制进度条，bgPaint用于绘制背景。
 * 在onDraw()方法中，我们根据当前的进度值和最大进度值计算出圆弧的角度，
 * 并分别使用画笔对象绘制进度条和背景。
 * setProgress()、setMaxValue()、setProgressColor()、setBgColor()和setArcAngle()
 * 方法分别用于设置进度、最大进度值、进度条颜色、背景颜色和弧度。
 * @param
 * @return
 * @author YS
 * @time 2023/4/12 7:19
 */
public class ProgressBarView0 extends View {

    // 用于绘制进度条的画笔
    private Paint progressPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    // 背景画笔
    private Paint bgPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    // 当前进度
    private int progress = 0;

    // 最大进度值
    private int maxValue = 100;

    // 进度条颜色
    private int progressColor = Color.BLUE;

    // 背景颜色
    private int bgColor = Color.LTGRAY;

    // 弧度
    private float arcAngle = 180f;

    // 构造方法
    public ProgressBarView0(Context context, AttributeSet attrs) {
        super(context, attrs);
        
        // 设置进度条画笔属性
        progressPaint.setStyle(Paint.Style.STROKE);
        progressPaint.setStrokeCap(Paint.Cap.ROUND);

        // 设置背景画笔属性
        bgPaint.setStyle(Paint.Style.STROKE);
        bgPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 获取View宽高
        int width = getWidth();
        int height = getHeight();

        // 计算圆心坐标和半径
        int centerX = width / 2;
        int centerY = height / 2;
        int radius = Math.min(width, height) / 2 - 10;

        // 绘制背景
        bgPaint.setColor(bgColor);
        bgPaint.setStrokeWidth(20);
        canvas.drawArc(centerX - radius, centerY - radius, centerX + radius, centerY + radius, arcAngle, arcAngle, false, bgPaint);

        // 绘制进度条
        progressPaint.setColor(progressColor);
        progressPaint.setStrokeWidth(20);
        canvas.drawArc(centerX - radius, centerY - radius, centerX + radius, centerY + radius, arcAngle, ((float)progress / maxValue) * arcAngle, false, progressPaint);
    }

    // 设置进度
    public void setProgress(int progress) {
        this.progress = progress;
        invalidate();  // 提醒View重绘
    }

    // 设置最大进度值
    public void setMaxValue(int value) {
        this.maxValue = value;
        invalidate();
    }

    // 设置进度条颜色
    public void setProgressColor(int color) {
        this.progressColor = color;
        invalidate();
    }

    // 设置背景颜色
    public void setBgColor(int color) {
        this.bgColor = color;
        invalidate();
    }

    // 设置弧度
    public void setArcAngle(float angle) {
        this.arcAngle = angle;
        invalidate();
    }
}