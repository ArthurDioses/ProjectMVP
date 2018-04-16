package com.example.adiosesr.appmvpexample.signup;

import com.example.adiosesr.appmvpexample.BasePresenter;
import com.example.adiosesr.appmvpexample.BaseView;

public interface SignupContract {

    interface View extends BaseView<Presenter> {
        String getName();

        void showMessage(String message);

        void goToHome();
    }

    interface Presenter extends BasePresenter {
        void validateField();
    }
}