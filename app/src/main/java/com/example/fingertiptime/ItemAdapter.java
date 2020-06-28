package com.example.fingertiptime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {
    LayoutInflater mInflater;
    String[] names;
    String[] sents;

    public ItemAdapter(Context c, String[] n, String[] s) {
        names = n;
        sents = s;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return names[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = mInflater.inflate(R.layout.friend_listview_detail, null);
        TextView nameTextView = (TextView) v.findViewById(R.id.nameTextView);
        TextView sentTextView = (TextView) v.findViewById(R.id.sentTextView);

        String name = names[i];
        String sent = sents[i];

        nameTextView.setText(name);
        sentTextView.setText(sent);

        return v;
    }
}
