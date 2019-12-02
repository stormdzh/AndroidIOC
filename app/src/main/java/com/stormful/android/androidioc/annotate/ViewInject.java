package com.stormful.android.androidioc.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 控件注入
 * @Author: dzh
 * @CreateDate: 2019-12-02 14:00
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewInject {

    int NONE = -1;

    int value() default NONE;
}
