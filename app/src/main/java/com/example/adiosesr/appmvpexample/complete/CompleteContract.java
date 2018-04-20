package com.example.adiosesr.appmvpexample.complete;


import com.example.adiosesr.appmvpexample.BasePresenter;
import com.example.adiosesr.appmvpexample.BaseView;
import com.example.adiosesr.appmvpexample.model.Task;

import java.util.List;

public interface CompleteContract {

    interface View extends BaseView<Presenter>{
        void showListComplete(List<Task> taskComplete);
        void ListEmpty();
    }
    interface Presenter extends BasePresenter{

    }
}
