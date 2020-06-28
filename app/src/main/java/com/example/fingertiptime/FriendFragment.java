package com.example.fingertiptime;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FriendFragment extends Fragment {
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_friend, container, false);
        ListView myListView = view.findViewById(R.id.myListView);

        // TODO 从数据库读取 (新建一个user类？)
        String[] names = {"岛市老八", "冬泳怪鸽"};
        String[] sents = {"虽然不是同一时间，但是同一间厕所", "我们遇到什么困难也不要怕，微笑着面对它"};

        ItemAdapter itemAdapter = new ItemAdapter(getContext(), names, sents);

        myListView.setAdapter(itemAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent chatActivity = new Intent(getContext(), ChatActivity.class);
                startActivity(chatActivity);
            }
        });

        /*Button chatBtn = (Button)myListView.findViewById(R.id.chatButton);
        chatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chatActivity = new Intent(getContext(), ChatActivity.class);
                startActivity(chatActivity);
            }
        });*/

        return view;
    }
}