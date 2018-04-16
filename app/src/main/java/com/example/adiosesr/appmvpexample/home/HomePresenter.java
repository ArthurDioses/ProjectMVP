package com.example.adiosesr.appmvpexample.home;

import android.support.annotation.NonNull;

import com.example.adiosesr.appmvpexample.data.source.preferences.PreferencesManager;

public class HomePresenter implements HomeContract.Presenter {

    @NonNull
    private final HomeContract.View view;

    @NonNull
    private final PreferencesManager preferencesManager;

    HomePresenter(@NonNull HomeContract.View view) {
        this.view = view;
        view.setPresenter(this);
        preferencesManager = new PreferencesManager(view.context());
    }

    @Override
    public void start() {
    }
}
