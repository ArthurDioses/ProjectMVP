package com.example.adiosesr.appmvpexample.profile;

import com.example.adiosesr.appmvpexample.BasePresenter;
import com.example.adiosesr.appmvpexample.BaseView;

public interface ProfileContract {
    interface View extends BaseView<Presenter> {
        void showUsername(String username);
        void goToSignup();
    }

    interface Presenter extends BasePresenter {
        void closeSession();
    }
}
