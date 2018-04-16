package com.example.adiosesr.appmvpexample;

import android.content.Context;

public interface BaseView<T> {
    void setPresenter(T presenter);

    Context context();
}
