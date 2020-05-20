package com.zacklang.tanphoto.ui.guide;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.zacklang.tanphoto.R;

public class GuideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, GuideFragment.newInstance())
                .commitNow();
        }
    }
}
