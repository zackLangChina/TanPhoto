package com.zacklang.tanphoto.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    //在layoyt中直接靠databinding与UI绑定了，就不需要手动写livedata.observe去绑定UI和数据源了
    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();

    public LoginViewModel() {
        //todo 这里可以获取之前登陆过的用户名密码
        name.postValue("zhangsan");
        password.postValue("123");
    }
}
