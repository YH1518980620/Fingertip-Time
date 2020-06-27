package com.example.fingertiptime;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class LoginActivity extends Activity {

    private EditText userName, password;
    private CheckBox auto_login;
    private Button btn_login, btn_forget_pass;
    private ImageButton btnQuit;
    private String userNameValue, passwordValue;
    private SharedPreferences sp;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 去除标题
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        // 获得实例对象
        sp = this.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        userName = (EditText) findViewById(R.id.et_zh);
        password = (EditText) findViewById(R.id.et_mima);
        btn_forget_pass = (Button) findViewById(R.id.btn_mima);
        auto_login = (CheckBox) findViewById(R.id.cb_auto);
        btn_login = (Button) findViewById(R.id.btn_login);
        btnQuit = (ImageButton) findViewById(R.id.img_btn);

        // 判断记住密码多选框的状态
        if (sp.getBoolean("ISCHECK", false)) {
            // 设置默认是记录密码状态
            userName.setText(sp.getString("USER_NAME", ""));
            password.setText(sp.getString("PASSWORD", ""));
            // 判断自动登陆多选框状态
            if (sp.getBoolean("AUTO_ISCHECK", false)) {
                // 跳转界面
                Intent intent = new Intent(LoginActivity.this,
                        JumpActivity.class);
                LoginActivity.this.startActivity(intent);
                LoginActivity.this.finish();
            }
        }

        // 登录监听事件
        // TODO 接入数据库判断用户名和密码
        btn_login.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                userNameValue = userName.getText().toString();
                passwordValue = password.getText().toString();
                if (userNameValue.equals("GnolizX") && passwordValue.equals("123456")) {
                    // 记住用户名、密码、
                    Editor editor = sp.edit();
                    // TODO 加密
                    editor.putString("USER_NAME", userNameValue);
                    editor.putString("PASSWORD", passwordValue);
                    editor.commit();
                    // 跳转界面
                    Intent intent = new Intent(LoginActivity.this,
                            JumpActivity.class);
                    LoginActivity.this.startActivity(intent);
                    LoginActivity.this.finish();

                } else {
                    Toast.makeText(LoginActivity.this, "用户名或密码错误，请重新登录",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

        // 监听记住密码多选框按钮事件
        auto_login.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                if (auto_login.isChecked()) {
                    sp.edit().putBoolean("ISCHECK", true).commit();
                } else {
                    sp.edit().putBoolean("ISCHECK", false).commit();
                }
            }
        });
        btnQuit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                LoginActivity.this.finish();
            }
        });

    }
}