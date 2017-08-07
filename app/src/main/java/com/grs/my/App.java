package com.grs.my;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import com.zhy.autolayout.config.AutoLayoutConifg;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/1.
 */
public class App extends Application {

    private static Context mContext;
    //运用list来保存们每一个activity是关键
    private List<Activity> mList = new LinkedList<Activity>();
    //为了实现每次使用该类时不创建新的对象而创建的静态对象
    private static App instance;

    public App() {
    }

    public synchronized static App getInstance() {
        if (null == instance) {
            instance = new App();
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        AutoLayoutConifg.getInstance().useDeviceSize(); // 让AutoLayout 获取物理高度
        registerActivityLifecycleCallbacks(new ActivitiesLife()); //判断是否是前台
    }



    // 获得全局上下文
    public static Context getContext() {
        return mContext;
    }

    //添加要退出的Activity
    public void addActivity(Activity activity) {
        mList.add(activity);
    }

    public void removeActivity(Activity activity) {
        if (activity != null) {
            if (!activity.isFinishing())
                activity.finish();
            mList.remove(activity);
        }
    }

    public int getActivityCount() {
        return mList.size();
    }

    //关闭每一个list内的activity
    public void exit() {
        try {
            for (Activity activity : mList) {
                if (activity != null)
                    activity.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

    //杀进程
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }

    public static class ActivitiesLife implements ActivityLifecycleCallbacks {
        private static int resumed;
        private static int paused;

        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        }

        @Override
        public void onActivityStarted(Activity activity) {
        }

        @Override
        public void onActivityResumed(Activity activity) {
            ++resumed;
        }

        @Override
        public void onActivityPaused(Activity activity) {
            ++paused;
        }

        @Override
        public void onActivityStopped(Activity activity) {
        }

        @Override
        public void onActivityDestroyed(Activity activity) {
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        /**
         * 判断应用是否在前台
         *
         * @return
         */
        public static boolean isAppForeground() {
            return resumed > paused;
        }
    }
}

