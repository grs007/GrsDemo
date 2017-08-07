package com.grs.my.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.grs.my.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 */

public class ChartView extends View {
    public ChartView(Context context) {
        this(context, null);
    }

    public ChartView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.chartView);
        int count = ta.getIndexCount();
        for (int i = 0; i < count; i++) {
            int itemId = ta.getIndex(i);
            switch (itemId) {
                case R.styleable.chartView_itemheight:
                    itemHeight = AutoUtils.getPercentHeightSize(ta.getInteger(itemId, 100));
                    break;
            }
        }
        init();
    }


    private Paint percentagePaint; //百分比
    private Paint linePaint; //横线
    private Paint chartPaint1; //走势图1
    private Paint chartPaint2; //走势图2

    private int width; //控件宽
    private int height; //控件高
    private List<Double> percentages; //百分值
    private int itemHeight; //每行高度

    private int strWidth; // 百分比占的宽度
    private int strHeight; // 百分比字占的高度

    private void init() {
        percentages = new ArrayList<>();
        percentagePaint = new Paint();
        percentagePaint.setColor(0xff999999);
        percentagePaint.setStyle(Paint.Style.FILL);
        percentagePaint.setTextSize(AutoUtils.getPercentWidthSize(30));
        linePaint = new Paint();
        linePaint.setColor(0xffcccccc);
        linePaint.setStyle(Paint.Style.FILL);
        linePaint.setStrokeWidth(AutoUtils.getPercentWidthSize(1));
        chartPaint1 = new Paint();
        chartPaint1.setColor(0xff00ff00);
        chartPaint1.setStyle(Paint.Style.STROKE);
        chartPaint1.setStrokeWidth(AutoUtils.getPercentWidthSize(10));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (percentages != null && percentages.size() > 0) {
            Rect rect = new Rect();
            percentagePaint.getTextBounds(percentages.get(0) + "%", 0, (percentages.get(0) + "%").length(), rect);
            strWidth = rect.width() + AutoUtils.getPercentWidthSize(15);
            strHeight = rect.height();
            int height = itemHeight * (percentages.size() - 1) + strHeight + AutoUtils.getPercentWidthSize(16);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(height,
                    MeasureSpec.EXACTLY);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG)); //抗锯齿
        canvas.drawColor(0xffff0000);
        drawPercentage(canvas); //画百分比
        drawLine1(canvas);
    }

    private void drawPercentage(Canvas canvas) {
        if (percentages != null || percentages.size() > 0) {
            for (int i = 0; i < percentages.size(); i++) {
                canvas.drawText(percentages.get(i) + "%", 0, i * itemHeight + strHeight + AutoUtils.getPercentWidthSize(10), percentagePaint);
                canvas.drawLine(strWidth, i * itemHeight + strHeight / 2 + AutoUtils.getPercentWidthSize(10)
                        , width, i * itemHeight + strHeight / 2 + AutoUtils.getPercentWidthSize(10), linePaint);
            }
        }
    }

    private void drawLine1(Canvas canvas) {
        Calendar instance = Calendar.getInstance();
        int day = instance.get(Calendar.DAY_OF_MONTH);
        int dotWidth = width / 30;

        Path path = new Path();
        path.moveTo(0, Math.abs((float) Math.random() * 10 - 2));
        for (int i = 1; i < 30; i++) {
            path.lineTo(i * dotWidth, height - ((float) (Math.abs((float) Math.random() * 10 - 2) / percentages.get(0) * height)));
        }
        canvas.drawPath(path, chartPaint1);
    }

    public void setPercentages(List<Double> percentages) {
        this.percentages = percentages;
        invalidate();
    }
}
