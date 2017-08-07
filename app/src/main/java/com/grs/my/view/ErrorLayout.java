package com.grs.my.view;

import android.content.Context;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.grs.my.R;
import com.grs.my.utils.NetUtil;

import java.util.Calendar;

/**
 * Created by turbo on 2015/12/14.
 */
public class ErrorLayout extends FrameLayout {

    private final Context context;
    private LinearLayout errorLinearLayout; // 网络错误
    private ImageView iconImageView;
    private TextView tipsTextView1;
    private TextView tipsTextView2;
    private RefreshListerner refreshListerner;
    private long lastClickTime;
    private Throwable throwable;

    public Throwable getException() {
        return throwable;
    }

    public void setException(Throwable throwable) {
        this.throwable = throwable;
    }

    public ErrorLayout(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public ErrorLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        init();
    }

    public ErrorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    /**
     * 设置刷新回调
     *
     * @param refreshListerner
     */
    public void setRefreshListerner(RefreshListerner refreshListerner) {
        this.refreshListerner = refreshListerner;
    }

    private void init() {
        View view = View.inflate(context, R.layout.layout_error, null);
        errorLinearLayout = (LinearLayout) view.findViewById(R.id.linear_error);
        iconImageView = (ImageView) view.findViewById(R.id.iv_error);
        tipsTextView1 = (TextView) view.findViewById(R.id.tv1_error);
        tipsTextView2 = (TextView) view.findViewById(R.id.tv2_error);
        addView(view);
        errorLinearLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                long currentTime = Calendar.getInstance().getTimeInMillis();
                if (currentTime - lastClickTime < 1000) {
                    return;
                }
                lastClickTime = currentTime;
                if (NetUtil.checkNetworkState(context) && refreshListerner != null) {
//                    errorLinearLayout.setVisibility(View.GONE);
                    refreshListerner.refreshData();
                }
            }
        });
    }

    /**
     * 显示网络异常布局
     */
    public void showError(String errorMsg) {
        changeTipsIcon(R.mipmap.network_error);
        changeTipsTextView(errorMsg, getResources().getString(R.string.network_error_refresh));
    }

    /**
     * 显示空布局
     */
    public void showEmpty(String emptyStr) {
        changeTipsIcon(R.mipmap.empty_content);
        changeTipsTextView(emptyStr, "");
    }

    /**
     * 修改提示文字
     *
     * @param text1
     * @param text2
     */
    public void changeTipsTextView(Spanned text1, Spanned text2) {
        //因为修改提示文字即需要显示结果为空的布局
        this.setVisibility(View.VISIBLE);
        if ("".equals(text1) && text1 != null) {
            tipsTextView1.setVisibility(View.GONE);
        } else {
            tipsTextView1.setText(text1);
        }
        if ("".equals(text2) && text2 != null) {
            tipsTextView2.setVisibility(View.GONE);

        } else {
            tipsTextView2.setText(text2);
        }
    }

    /**
     * 修改提示文字
     *
     * @param text1
     * @param text2
     */
    public void changeTipsTextView(String text1, String text2) {
        //因为修改提示文字即需要显示结果为空的布局
        this.setVisibility(View.VISIBLE);
        if ("".equals(text1) && text1 != null) {
            tipsTextView1.setVisibility(View.GONE);
        } else {
            tipsTextView1.setText(text1);
        }
        if ("".equals(text2) && text2 != null) {
            tipsTextView2.setVisibility(View.GONE);

        } else {
            tipsTextView2.setText(text2);
        }
    }

    /**
     * 修改图标
     *
     * @param id
     */
    public void changeTipsIcon(int id) {
        iconImageView.setImageResource(id);
    }

    /**
     * 点击刷新接口，无网络状态下会显示网络异常布局，点击界面重新请求数据
     */
    public interface RefreshListerner {
        void refreshData();
    }
}
