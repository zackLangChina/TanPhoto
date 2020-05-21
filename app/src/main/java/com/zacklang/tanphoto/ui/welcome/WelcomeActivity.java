package com.zacklang.tanphoto.ui.welcome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zacklang.tanphoto.R;
import com.zacklang.tanphoto.ui.guide.GuideActivity;
import com.zacklang.tanphoto.ui.login.LoginActivity;

public class WelcomeActivity extends AppCompatActivity {
    private final int JUMP_TO_MAIN = 1;
    private final int JUMP_TO_LOGIN = 10;
    private final int JUMP_TO_GUIDE = 20;
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
        handler.removeMessages(JUMP_TO_MAIN);
    }

    private void delayToJunp(int delay_to_jump) {
        Message msg = new Message();
        msg.what = JUMP_TO_MAIN;
        //跳到哪个页面
        msg.arg1 = JUMP_TO_GUIDE;
        handler.sendMessageDelayed(msg,DELAY_TO_JUMP);
    }

    private void jumpToMain(int activityID) {
        if(activityID==JUMP_TO_GUIDE) {
            Intent intent = new Intent(this,GuideActivity.class);
            startActivity(intent);
        }else if(activityID==JUMP_TO_LOGIN) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

        //跳转后避免通过back再进入欢迎页
        finish();
    }

    public void skip(View view) {
        handler.removeMessages(JUMP_TO_MAIN);
        jumpToMain(JUMP_TO_GUIDE);
    }

    class DelayHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            jumpToMain(msg.arg1);
        }
    }
}
