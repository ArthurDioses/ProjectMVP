package com.example.adiosesr.appmvpexample.home;

import android.support.v4.view.ViewPager;

import com.example.adiosesr.appmvpexample.BasePresenter;
import com.example.adiosesr.appmvpexample.BaseView;

public interface HomeContract {

    interface View extends BaseView<Presenter> {
    }
    interface Presenter extends BasePresenter {
    }
}
