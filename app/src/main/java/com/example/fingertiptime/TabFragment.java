package com.example.fingertiptime;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class TabFragment extends Fragment {
    SwipeRefreshLayout mySwipeRefreshLayout;
    private WebView webView;
    private String mTitle;

    // 便于各个Tab同时调用一个fragment
    public TabFragment(String title) {
        mTitle = title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        String url = "";
        mySwipeRefreshLayout = view.findViewById(R.id.swipeContainer);
        webView = view.findViewById(R.id.tabWebview);
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        switch (mTitle) {
            case "推荐":
                url = "https://baike.baidu.com/";
                break;
            case "新闻":
                url = "http://www.bjnews.com.cn/realtime";
                break;
            case "漫画":
                url = "https://manga.bilibili.com/";
                break;
            case "段子":
                url = "https://www.qiushibaike.com/";
                break;
            case "搜索":
                url = "https://www.sogou.com/";
                break;
        }
        webView.loadUrl(url);

        // 监听返回键
        webView.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
                        webView.goBack();
                        return true;
                    }
                }
                return false;
            }
        });

        // 监听下拉刷新
        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        webView.reload();
                    }
                }
        );

        // 下拉刷新完毕
        webView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                mySwipeRefreshLayout.setRefreshing(false);
            }
        });

        return view;
    }
}