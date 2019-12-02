package com.stormful.android.androidioc.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 绑定布局
 * @Author: dzh
 * @CreateDate: 2019-12-02 13:59
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ContentView {

    int NONE = -1;

    int value() default NONE;
}