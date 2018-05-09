package com.superrookie.relaxcar;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * NoticeFragment
 */
public class NoticeFragment extends android.support.v4.app.Fragment {
    private static final String KEY_MESSAGE = "msg";

    public NoticeFragment() {
    }

    public static NoticeFragment createInstance(String message) {
        NoticeFragment fragment = new NoticeFragment();
        Bundle args = new Bundle();
        args.putString(KEY_MESSAGE, message);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RelativeLayout layout = (RelativeLayout) inflater.inflate(
                R.layout.fragment_notice, container, false);
        TextView textView = layout.findViewById(R.id.message);
        if (textView != null) textView.setText(getArguments().getString(KEY_MESSAGE));
        return layout;
    }
}
