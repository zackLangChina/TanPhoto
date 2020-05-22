package com.zacklang.tanphoto.ui.browse;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zacklang.tanphoto.R;

public class BrowseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_activity);

        BrowseFragment browseFragment = new BrowseFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fl_container, browseFragment, BrowseFragment.TAG).commit();
    }

    public void favoriteClick(View view) {
    }

    public void dislikeClick(View view) {
    }
}
