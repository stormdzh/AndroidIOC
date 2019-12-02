package com.stormful.android.androidioc;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.stormful.android.androidioc.annotate.ContentView;
import com.stormful.android.androidioc.annotate.OnClick;
import com.stormful.android.androidioc.annotate.ViewInject;
import com.stormful.android.androidioc.annotate.view.Views;

/**
 * @description 测试的Activity
 * @author: dzh
 * @CreateDate: ${DATE} ${TIME}
 */
@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewInject(R.id.tvTest)
    TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        Views.inject(this);
    }


    @OnClick(R.id.tvTest)
    public void showText(View v) {
        String text = tvTest.getText().toString();
        Toast.makeText(this, "获取到tvTest上的文本是：" + text, Toast.LENGTH_SHORT).show();
    }
}
