package com.view.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/**
 * Created by Administrator on 2017/9/11.
 */
public class CustomScroller extends HorizontalScrollView {
    public final static int SCROLL_DEFAULT = 50;
    public CustomScroller(Context context) {
        this(context, null);
    }

    public CustomScroller(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomScroller(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        rect.left = -SCROLL_DEFAULT + rect.left;
        rect.right = SCROLL_DEFAULT + rect.right;
        return super.computeScrollDeltaToGetChildRectOnScreen(rect);
    }

}
