package com.example.fingertiptime;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button regBtn = (Button) findViewById(R.id.regConfBtn);
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nameEditText = (EditText)findViewById(R.id.editTextTextPersonName);
                EditText pwdEditText = (EditText)findViewById(R.id.editTextTextPassword);

                String username = nameEditText.getText().toString();
                String password = pwdEditText.getText().toString();

                // TODO 写入数据库

                /*
                 * 注册成功后返回
                 */
                finish();
            }
        });
    }
}