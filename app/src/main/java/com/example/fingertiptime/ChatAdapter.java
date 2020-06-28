package com.example.fingertiptime;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    private List<Chat> chatList;

    public ChatAdapter(List<Chat> chatList) {
        this.chatList = chatList;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Chat chat = chatList.get(i);
        viewHolder.chatText.setText(chat.getContent());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(viewHolder.chatText.getLayoutParams());

        // 判断谁在对谁说话
        // TODO 改成登入的用户名
        if (chat.getTargetUser().equals("GnolizX")) {
            params.gravity = Gravity.LEFT;
        } else {
            params.gravity = Gravity.RIGHT;
        }
        viewHolder.chatText.setLayoutParams(params);
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView chatText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            chatText = itemView.findViewById(R.id.chatText);
        }
    }
}