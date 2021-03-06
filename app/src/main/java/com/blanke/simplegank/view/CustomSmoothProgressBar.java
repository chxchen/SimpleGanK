package com.blanke.simplegank.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import fr.castorflex.android.smoothprogressbar.SmoothProgressDrawable;

/**
 * Created by Blanke on 16-1-22.
 */
public class CustomSmoothProgressBar extends SmoothProgressBar {

    public abstract class CustomCallBack implements SmoothProgressDrawable.Callbacks {
        @Override
        public void onStop() {
            if (isFinishing()) {
//                setVisibility(View.GONE);
                animStop();
            }
        }

        public abstract void animStop();

        @Override
        public void onStart() {
        }
    }


    private boolean isShow = false;

    public CustomSmoothProgressBar(Context context) {
        this(context, null);
    }

    public CustomSmoothProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, fr.castorflex.android.smoothprogressbar.R.attr.spbStyle);
    }

    public CustomSmoothProgressBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
//        setVisibility(View.GONE);
        progressiveStop();
//        checkIndeterminateDrawable().stop();
    }


    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
//        KLog.d("show =" + show + ", isShow=" + isShow);
        if (show == true && isShow == false) {
            progressiveStart();
//            setVisibility(View.VISIBLE);
        } else if (show == false && isShow) {
            progressiveStop();
        }
        isShow = show;
    }

    public boolean isRunning() {
        return checkIndeterminateDrawable().isRunning();
    }

    public boolean isFinishing() {
        return checkIndeterminateDrawable().isFinishing();
    }


    private SmoothProgressDrawable checkIndeterminateDrawable() {
        Drawable ret = getIndeterminateDrawable();
        if (ret == null || !(ret instanceof SmoothProgressDrawable))
            throw new RuntimeException("The drawable is not a SmoothProgressDrawable");
        return (SmoothProgressDrawable) ret;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

    }

    @Override
    protected void onDetachedFromWindow() {
//        super.onDetachedFromWindow();
    }
}
