package com.stormful.android.androidioc.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 点击事件
 * @Author: dzh
 * @CreateDate: 2019-12-02 14:00
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OnClick {

    int NONE = -1;

    int value();
}