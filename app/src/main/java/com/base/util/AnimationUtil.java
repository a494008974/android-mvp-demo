package com.base.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;

public class AnimationUtil {
    private static final int duration1 = 300;
    private static final int duration2 = 5;
    private static final float scalefrom = 1f;
    private static final float scaleto = 1.12f;

    private static final float alphafrom = 0.8f;
    private static final float alphato = 1f;

    private static final int focuseW = 50;
    private static final int focuseH = 50;


    public static void setAnimationListener(Animation aninm, final AnimListener listener) {
        aninm.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                listener.onAnimFinish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


    public interface AnimListener {
        void onAnimFinish();
    }

    public static void cancleFocus(View v, boolean type){
        if(type){
            ObjectAnimator scaleAX = ObjectAnimator.ofFloat(v, View.SCALE_X, scaleto, scalefrom);
            ObjectAnimator scaleAY = ObjectAnimator.ofFloat(v, View.SCALE_Y, scaleto, scalefrom);
            AnimatorSet animSetXY = new AnimatorSet();
            animSetXY.setDuration(duration1);
            animSetXY.playTogether(scaleAX, scaleAY);
            animSetXY.start();
        }else{
            ObjectAnimator scaleAX = ObjectAnimator.ofFloat(v, View.SCALE_X, scaleto, scalefrom);
            ObjectAnimator scaleAY = ObjectAnimator.ofFloat(v, View.SCALE_Y, scaleto, scalefrom);
            AnimatorSet animSetXY = new AnimatorSet();
            animSetXY.setDuration(duration2);
            animSetXY.setInterpolator(new AccelerateInterpolator());
            animSetXY.playTogether(scaleAX, scaleAY);
            animSetXY.start();
        }

    }

    public static void moveFocus(View v, final View cover, boolean type) {
        if (type){
            ViewGroup.LayoutParams params = cover.getLayoutParams();
            params.width = cover.getWidth();
            params.height = cover.getHeight();
            cover.setLayoutParams(params);
            int scaleX = (int) (v.getWidth() * (scaleto - 1));
            int scaleY = (int) (v.getHeight() * (scaleto - 1));
            int vWidth = v.getWidth() + focuseW + scaleX;
            int vHeight = v.getHeight() + focuseH + scaleY;
            float x = v.getX() - focuseW/2 - scaleX/2;
            float y = v.getY() - focuseH/2 - scaleY/2;

            Size s1 = new Size(cover.getWidth(), cover.getHeight());
            Size s2 = new Size(vWidth, vHeight);

            ValueAnimator animWH = ValueAnimator.ofObject(new SizeEvaluator(cover), s1, s2);
            ObjectAnimator animX = ObjectAnimator.ofFloat(cover, View.X, cover.getX(),x );
            ObjectAnimator animY = ObjectAnimator.ofFloat(cover, View.Y, cover.getY(),y);
            ObjectAnimator animA = ObjectAnimator.ofFloat(cover, View.ALPHA, alphafrom, alphato);

            ObjectAnimator scaleAX = ObjectAnimator.ofFloat(v, View.SCALE_X, scalefrom, scaleto);
            ObjectAnimator scaleAY = ObjectAnimator.ofFloat(v, View.SCALE_Y, scalefrom, scaleto);

            AnimatorSet animSetXY = new AnimatorSet();
            animSetXY.setDuration(duration1);
            animSetXY.setInterpolator(new AccelerateInterpolator());
            animSetXY.playTogether(animWH, animA, animX, animY, scaleAX, scaleAY);
            animSetXY.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                }

                @Override
                public void onAnimationStart(Animator animation) {
                    super.onAnimationStart(animation);
                }
            });
            animSetXY.start();
        }else{
            int scaleX = (int) (v.getWidth() * (scaleto - 1));
            int scaleY = (int) (v.getHeight() * (scaleto - 1));
            int vWidth = v.getWidth() + focuseW + scaleX;
            int vHeight = v.getHeight() + focuseH + scaleY;
            float x = v.getX() - focuseW/2 - scaleX/2;
            float y = v.getY() - focuseH/2 - scaleY/2;

            ViewGroup.LayoutParams params = cover.getLayoutParams();
            params.width = vWidth;
            params.height = vHeight;
            cover.setX(x);
            cover.setY(y);
            cover.setLayoutParams(params);

            ObjectAnimator scaleAX = ObjectAnimator.ofFloat(v, View.SCALE_X, scalefrom, scaleto);
            ObjectAnimator scaleAY = ObjectAnimator.ofFloat(v, View.SCALE_Y, scalefrom, scaleto);
            AnimatorSet animSetXY = new AnimatorSet();
            animSetXY.setDuration(duration2);
            animSetXY.setInterpolator(new AccelerateInterpolator());
            animSetXY.playTogether(scaleAX, scaleAY);
            animSetXY.start();
        }
    }

    public static class Size{
        private int width;
        private int height;
        public Size(float width, float height) {
            this.width = (int)width;
            this.height = (int)height;
        }
        public Size(int width, int height) {
            this.width = width;
            this.height = height;
        }
        public int getWidth() {
            return width;
        }
        public void setWidth(int width) {
            this.width = width;
        }
        public int getHeight() {
            return height;
        }
        public void setHeight(int height) {
            this.height = height;
        }
    }

    public static class SizeEvaluator implements TypeEvaluator<Size> {
        private View v;
        public SizeEvaluator(View v) {
            this.v = v;
        }
        @Override
        public Size evaluate(float fraction, Size startValue, Size endValue) {
            Size startSize = (Size) startValue;
            Size endSize = (Size) endValue;
            float width = startSize.getWidth() + fraction
                    * (endSize.getWidth() - startSize.getWidth());
            float height = startSize.getHeight() + fraction
                    * (endSize.getHeight() - startSize.getHeight());
            ViewGroup.LayoutParams params = v.getLayoutParams();
            params.width = (int) width;
            params.height = (int) height;
            v.setLayoutParams(params);
            Size size = new Size(width, height);
            return size;
        }
    }
}
