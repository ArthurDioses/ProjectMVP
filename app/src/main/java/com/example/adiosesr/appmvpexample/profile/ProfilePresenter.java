package com.example.adiosesr.appmvpexample.profile;

import android.support.annotation.NonNull;

import com.example.adiosesr.appmvpexample.data.source.preferences.PreferencesManager;

public class ProfilePresenter implements ProfileContract.Presenter {

    @NonNull
    private
    ProfileContract.View view;

    @NonNull
    private
    PreferencesManager preferencesManager;

    ProfilePresenter(@NonNull ProfileContract.View view) {
        this.view = view;
        view.setPresenter(this);
        preferencesManager = new PreferencesManager(view.context());
    }

    @Override
    public void start() {
        view.showUsername(preferencesManager.getUserName());
    }

    @Override
    public void closeSession() {
        preferencesManager.deleteUserName();
        view.goToSignup();
    }
}
