package com.example.user;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

class NoInternetPopUp implements Animation.AnimationListener {
    Context context;

    private Animation popupShow;
    private Animation popupHide;
    private LinearLayout linearLayoutPopup;
    private RelativeLayout touchRelative;

    NoInternetPopUp(Context ctx, LinearLayout llp, RelativeLayout rl)
    {
        context = ctx;
        linearLayoutPopup = llp;
        touchRelative = rl;
    }

    public void noInternet() {
        popupShow = AnimationUtils.loadAnimation(context, R.anim.popup_show);
        popupShow.setAnimationListener(this);
        popupHide = AnimationUtils.loadAnimation(context, R.anim.popup_hide);
        popupHide.setAnimationListener(this);

        if (linearLayoutPopup.getVisibility() == View.GONE) {
            linearLayoutPopup.startAnimation(popupShow);
        } else {
            linearLayoutPopup.startAnimation(popupHide);
        }
    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onAnimationStart(Animation animation) {
        if (animation.equals(popupShow)) {
            linearLayoutPopup.setVisibility(View.VISIBLE);
            touchRelative.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    linearLayoutPopup.startAnimation(popupHide);
                    return true;
                }
            });
        } else if (animation.equals(popupHide)) {
            linearLayoutPopup.setVisibility(View.GONE);
        }
    }
}

