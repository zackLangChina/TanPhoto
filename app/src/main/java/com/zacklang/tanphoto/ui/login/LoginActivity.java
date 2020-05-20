package com.zacklang.tanphoto.ui.login;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.zacklang.tanphoto.R;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_activity);
        /*
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, LoginFragment.newInstance())
                    .commitNow();
        }
        */
    }
}
