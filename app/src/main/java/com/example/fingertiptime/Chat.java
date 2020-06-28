package com.example.fingertiptime;

public class Chat {
    private String targetUser; // 对方的用户名
    private String content; // 聊天的内容

    public Chat(String targetUser, String content) {
        this.targetUser = targetUser;
        this.content = content;
    }

    public String getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(String targetUser) {
        this.targetUser = targetUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
