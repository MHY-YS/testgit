package com.example.testgithublib;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
public class ProgressBarView extends View {

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

    // 动画相关
    private ValueAnimator animator;
    private float animatedValue = 0;
    private long animationDuration = 2000;

    // 构造方法
    public ProgressBarView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // 设置进度条画笔属性
        progressPaint.setStyle(Paint.Style.STROKE);
        progressPaint.setStrokeCap(Paint.Cap.ROUND);

        // 设置背景画笔属性
        bgPaint.setStyle(Paint.Style.STROKE);
        bgPaint.setStrokeCap(Paint.Cap.ROUND);

        // 初始化动画对象
        animator = ValueAnimator.ofFloat(0, 1);
        animator.setDuration(animationDuration);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                animatedValue = (float) animation.getAnimatedValue();
                invalidate();
            }
        });
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 获取View宽高
        int width = getWidth();
        int height = getHeight();

        // 计算圆心坐标和半径
        // 需要减去画笔宽度的一半，以避免画笔超出View边界的问题
        int centerX = width / 2;
        int centerY = height / 2;
        int radius = (int) (Math.min(width, height) / 2 - progressPaint.getStrokeWidth() / 2);

        // 绘制背景
        bgPaint.setColor(bgColor);
        bgPaint.setStrokeWidth(progressPaint.getStrokeWidth());  // 与进度条画笔宽度相同
        float startAngle = arcAngle + (360 - arcAngle) / 2;  // 背景圆弧的起始角度需要调整
        canvas.drawArc(centerX - radius, centerY - radius, centerX + radius, centerY + radius, startAngle, arcAngle, false, bgPaint);

        // 绘制进度条
        progressPaint.setColor(progressColor);
        progressPaint.setStrokeWidth(bgPaint.getStrokeWidth());  // 与背景画笔宽度相同
        float sweepAngle = ((float) progress / maxValue) * arcAngle;
        canvas.drawArc(centerX - radius, centerY - radius, centerX + radius, centerY + radius, startAngle, animatedValue * sweepAngle, false, progressPaint);

        // 开始动画
        if (animatedValue < 1) {
            animator.start();
        }
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