package com.example.fingertiptime;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PersonalFragment extends Fragment {
    int fragment;
    Button loginBtn;
    Button registerBtn;
    Button logOutBtn;
    SharedPreferences prefs;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        prefs = getContext().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        // 判断是否登录
        // TODO 与数据库对接
        String loginID = prefs.getString("USER_NAME", "");
        String loginPWD = prefs.getString("PASSWORD", "");

        if (loginID.length() > 0 && loginPWD.length() > 0) { // 已登录
            fragment = R.layout.fragment_personal;
        } else { // 未登录
            fragment = R.layout.fragment_visitor;
        }
        View view = inflater.inflate(fragment, container, false);

        if (fragment == R.layout.fragment_visitor) {
            loginBtn = (Button) view.findViewById(R.id.loginButton);
            loginBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent login = new Intent(getContext(), LoginActivity.class);
                    startActivity(login);
                }
            });

            registerBtn = (Button) view.findViewById(R.id.registerButton);
            registerBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent register = new Intent(getContext(), RegisterActivity.class);
                    startActivity(register);
                }
            });
        }

        if (fragment == R.layout.fragment_personal) {
            logOutBtn = (Button) view.findViewById(R.id.logOutButton);
            logOutBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // 本地移除用户数据
                    prefs.edit().clear().commit();

                    // TODO 登出
                    Intent main = new Intent(getContext(), MainActivity.class);
                    startActivity(main);
                }
            });
        }

        return view;
    }
}

