package com.zacklang.tanphoto.ui.browse;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zacklang.tanphoto.R;

public class BrowseActivity extends AppCompatActivity {
    private final String TAG = "BrowseActivity";
    private BrowseFragment mBrowseFragment;
    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_activity);

        if (savedInstanceState == null) {
            mBrowseFragment = new BrowseFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fl_container, mBrowseFragment, BrowseFragment.TAG).commit();
        }else {
            mBrowseFragment = (BrowseFragment) getSupportFragmentManager().findFragmentByTag(BrowseFragment.TAG);
        }
        mGestureDetector = new GestureDetector(this, new GestureDetector.OnGestureListener() {

            @Override
            public boolean onDown(MotionEvent e) {
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                Log.d(TAG, "velocityX:" + velocityX + " ,velocityY:" + velocityY);
                if(velocityX > 3000) {
                    //右滑不喜欢
                    dislikeClick();
                }else if(velocityX < -3000) {
                    //左滑喜欢
                    favoriteClick();
                }
                return true;
            }
        });
    }

    public void favoriteClick(View view) {
        favoriteClick();
    }

    public void dislikeClick(View view) {
        dislikeClick();
    }


    public void favoriteClick() {
        mBrowseFragment.requestPhoto();
        Animation scaleAnimation;
        scaleAnimation = AnimationUtils.loadAnimation(BrowseActivity.this,R.anim.scale);
        findViewById(R.id.favorite).startAnimation(scaleAnimation);
    }

    public void dislikeClick() {
        mBrowseFragment.requestPhoto();
        Animation scaleAnimation;
        scaleAnimation = AnimationUtils.loadAnimation(BrowseActivity.this,R.anim.scale);
        findViewById(R.id.dislike).startAnimation(scaleAnimation);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent home = new Intent(Intent.ACTION_MAIN);
            home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            home.addCategory(Intent.CATEGORY_HOME);
            startActivity(home);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mGestureDetector.onTouchEvent(event);
        return true;
    }
}
