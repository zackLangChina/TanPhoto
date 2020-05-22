package com.zacklang.tanphoto.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.ViewModelProvider;

import com.zacklang.tanphoto.R;
import com.zacklang.tanphoto.databinding.LoginActivityBinding;
import com.zacklang.tanphoto.ui.browse.BrowseActivity;
import com.zacklang.tanphoto.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {
    private LoginActivityBinding databinding;
    private LoginViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databinding = DataBindingUtil.setContentView(this,R.layout.login_activity);
        vm = new ViewModelProvider(this).get(LoginViewModel.class);
        databinding.setVariable(BR.vm_login,vm);
    }

    public void login(View view) {
        if (TextUtils.isEmpty(vm.name.getValue()) || TextUtils.isEmpty(vm.password.getValue())) {
            Toast.makeText(this, "用户名或密码不完整", Toast.LENGTH_SHORT).show();
            return;
        }
        jumToBrowse();
    }

    private void jumToBrowse() {
        Intent intent = new Intent(this, BrowseActivity.class);
        startActivity(intent);
        finish();
    }
}
