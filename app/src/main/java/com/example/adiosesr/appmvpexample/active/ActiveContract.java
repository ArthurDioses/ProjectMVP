package com.example.adiosesr.appmvpexample.active;

import com.example.adiosesr.appmvpexample.BasePresenter;
import com.example.adiosesr.appmvpexample.BaseView;
import com.example.adiosesr.appmvpexample.model.Task;

import java.util.List;


public interface ActiveContract {

    interface View extends BaseView<Presenter> {

        void showList(List<Task> mTasks);
        void emptyList();

    }
    interface Presenter extends BasePresenter {

    }
}
