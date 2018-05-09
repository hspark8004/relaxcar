package com.superrookie.relaxcar;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class NoticeTextView extends android.support.v7.widget.AppCompatTextView {
    public NoticeTextView(Context context) {
        super(context);
        setType(context);
    }

    public NoticeTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setType(context);
    }

    public NoticeTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setType(context);
    }

    private void setType(Context context) {
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),
                "fonts/ya_Regular.otf"));
    }
}
