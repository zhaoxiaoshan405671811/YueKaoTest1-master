package com.zyy.yuekaotest1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.widget.TextView;



public class DetailActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.detail);
        TextView tv = (TextView) findViewById(R.id.detatil_content);
        Intent intent = getIntent();
        String content = intent.getStringExtra("content");
        tv.setText(content);
    }
}
