package com.example.fingertiptime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;

public class JumpActivity extends Activity {
    private ProgressBar progressBar;
    private Button backButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 去除标题
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_jump);

        progressBar = (ProgressBar) findViewById(R.id.pgBar);

        backButton = (Button) findViewById(R.id.btn_back);

        startActivity();
        backButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                JumpActivity.this.finish();
            }
        });

    }

    private void startActivity() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(JumpActivity.this,
                        MainActivity.class);
                JumpActivity.this.startActivity(intent);
                JumpActivity.this.finish();
            }
        }, 2000);// 设置执行时间1秒
    }

}
