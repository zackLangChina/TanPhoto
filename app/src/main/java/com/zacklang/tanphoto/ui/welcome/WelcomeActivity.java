package com.zacklang.tanphoto.ui.welcome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zacklang.tanphoto.R;
import com.zacklang.tanphoto.ui.guide.GuideActivity;

public class WelcomeActivity extends AppCompatActivity {
    private final int JUMP_TO_LOGIN = 1;
    private final int JUMP_TO_GUIDE = 2;
    //延时3秒跳转
    private final int DELAY_TO_JUMP = 3000;
    private DelayHandler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);

        handler = new DelayHandler();
        delayToJunp(DELAY_TO_JUMP);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //防止内存泄漏
        handler.removeMessages(DELAY_TO_JUMP);
    }

    private void delayToJunp(int delay_to_jump) {
        handler.sendEmptyMessageDelayed(JUMP_TO_GUIDE,DELAY_TO_JUMP);
    }

    private void jumpToMain() {
        Intent intent = new Intent(this,GuideActivity.class);
        startActivity(intent);
    }

    class DelayHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            jumpToMain();
        }
    }
}
