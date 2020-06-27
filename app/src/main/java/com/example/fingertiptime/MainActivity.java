package com.example.fingertiptime;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioButton homeRb, messageRb, personalRb, friendRb;
    private RadioGroup mRadioGroup;
    private HomeFragment mHomeFragment;
    private FriendFragment mFriendFragment;
    private PersonalFragment mPersonalFragment;
    private MessageFragment mMessageFragment;
    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mRadioGroup = findViewById(R.id.radio_group);
        mRadioGroup.setOnCheckedChangeListener(this);
        homeRb = findViewById(R.id.rd_home);
        messageRb = findViewById(R.id.rd_message);
        friendRb = findViewById(R.id.rd_friend);
        personalRb = findViewById(R.id.rd_personal);
        homeRb.setChecked(true);

        /**图片的优化，其他三个图片做类似处理
         * 底部导航的时候会发生图片的颜色变化，所以radiobutton中的照片不是一张，而是引用了自定义的选择器照片
         */
        Drawable home = ContextCompat.getDrawable(this, R.drawable.selector_home_drawable);
        /**
         *  当这个图片被绘制时，给他绑定一个矩形规定这个矩形
         *  参数前两个对应图片相对于左上角的新位置，后两个为图片的长宽
         */
        home.setBounds(0, 0, 80, 80);
        /**
         *   设置图片在文字的哪个方向,分别对应左，上，右，下
         */
        homeRb.setCompoundDrawables(null, home, null, null);

        Drawable message = ContextCompat.getDrawable(this, R.drawable.selector_message_drawable);
        message.setBounds(0, 0, 80, 80);
        messageRb.setCompoundDrawables(null, message, null, null);

        Drawable friend = ContextCompat.getDrawable(this, R.drawable.selector_friend_drawable);
        friend.setBounds(0, 0, 80, 80);
        friendRb.setCompoundDrawables(null, friend, null, null);

        Drawable personal = ContextCompat.getDrawable(this, R.drawable.selector_personal_drawable);
        personal.setBounds(0, 0, 80, 80);
        personalRb.setCompoundDrawables(null, personal, null, null);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        switch (checkedId) {
            case R.id.rd_home:
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                    transaction.add(R.id.fragment_container, mHomeFragment);
                } else {
                    transaction.show(mHomeFragment);
                }
                break;
            case R.id.rd_message:
                if (mMessageFragment == null) {
                    mMessageFragment = new MessageFragment();
                    transaction.add(R.id.fragment_container, mMessageFragment);
                } else {
                    transaction.show(mMessageFragment);
                }
                break;
            case R.id.rd_friend:
                if (mFriendFragment == null) {
                    mFriendFragment = new FriendFragment();
                    transaction.add(R.id.fragment_container, mFriendFragment);
                } else {
                    transaction.show(mFriendFragment);
                }
                break;
            case R.id.rd_personal:
                if (mPersonalFragment == null) {
                    mPersonalFragment = new PersonalFragment();
                    transaction.add(R.id.fragment_container, mPersonalFragment);
                } else {
                    transaction.show(mPersonalFragment);
                }
                break;
        }
        transaction.commit();
    }

    public void hideAllFragment(FragmentTransaction transaction) {
        if (mHomeFragment != null) {
            transaction.hide(mHomeFragment);
        }
        if (mMessageFragment != null) {
            transaction.hide(mMessageFragment);
        }
        if (mFriendFragment != null) {
            transaction.hide(mFriendFragment);
        }
        if (mPersonalFragment != null) {
            transaction.hide(mPersonalFragment);
        }
    }

    /**
     * 再按一次退出程序
     * 首页的5个Tab网页的返回键监听在TabFragment.java
     */
    @Override
    public void onBackPressed() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finishAffinity();
            System.exit(0);
        }
    }
}