package com.stormful.android.androidioc.annotate.view;

import android.app.Activity;
import android.view.View;

import com.stormful.android.androidioc.annotate.ContentView;
import com.stormful.android.androidioc.annotate.OnClick;
import com.stormful.android.androidioc.annotate.ViewInject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Description: 注解解析类
 * @Author: dzh
 * @CreateDate: 2019-12-02 14:03
 */
public class Views {

    public static void inject(final Activity activity) {
        injectContentView(activity);
        injectViews(activity);
        injectOnClickListener(activity);
    }

    /**
     * 解析视图
     *
     * @param activity activity
     */
    private static void injectContentView(Activity activity) {
        Class<? extends Activity> activityClass = activity.getClass();
        ContentView contentViewAnnotation = activityClass.getAnnotation(ContentView.class);
        if (contentViewAnnotation == null) {
            return;
        }
        int layoutResId = contentViewAnnotation.value();
        if (layoutResId == ContentView.NONE) {
            return;
        }
        activity.setContentView(layoutResId);
    }

    /**
     * 解析控件
     *
     * @param activity activity
     */
    private static void injectViews(Activity activity) {
        Class<? extends Activity> activityClass = activity.getClass();
        Field[] fields = activityClass.getDeclaredFields();
        for (Field field : fields) {
            ViewInject viewInjectAnnotation = field.getAnnotation(ViewInject.class);
            if (viewInjectAnnotation == null) {
                continue;
            }
            int viewResId = viewInjectAnnotation.value();
            if (viewResId != ViewInject.NONE) {
                try {
                    View view = activity.findViewById(viewResId);
                    field.setAccessible(true);
                    field.set(activity, view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 解析点击事件
     *
     * @param activity activity
     */
    private static void injectOnClickListener(final Activity activity) {
        Class<? extends Activity> activityClass = activity.getClass();
        Method[] methods = activityClass.getDeclaredMethods();
        for (final Method method : methods) {
            OnClick onClickAnnotation = method.getAnnotation(OnClick.class);
            if (onClickAnnotation == null) {
                continue;
            }
            int viewResId = onClickAnnotation.value();
            if (viewResId == OnClick.NONE) {
                continue;
            }
            try {
                final View view = activity.findViewById(viewResId);
                if (view != null) {
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                method.invoke(activity, view);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
