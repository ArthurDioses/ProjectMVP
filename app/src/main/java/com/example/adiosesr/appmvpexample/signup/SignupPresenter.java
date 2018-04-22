package com.example.adiosesr.appmvpexample.signup;

import android.support.annotation.NonNull;

import com.example.adiosesr.appmvpexample.data.source.preferences.PreferencesManager;

public class SignupPresenter implements SignupContract.Presenter {
    @NonNull
    private final SignupContract.View view;

    @NonNull
    private final PreferencesManager preferencesManager;

    SignupPresenter(@NonNull SignupContract.View view) {
        this.view = view;
        view.setPresenter(this);
        preferencesManager = new PreferencesManager(view.context());
    }

    @Override
    public void start() {
        if (preferencesManager.hasUserName()) {
            view.goToHome();
        }
    }

    @Override
    public void validateField() {
        String value = view.getName().trim();
        if (value.isEmpty()) {
            view.showMessage("Valor requerido");
        } else if (value.length() > 10) {
            view.showMessage("El valor debe ser menor a 10 caracteres");
        } else {
            preferencesManager.storeUserName(value);
            view.goToHome();
        }
    }
}