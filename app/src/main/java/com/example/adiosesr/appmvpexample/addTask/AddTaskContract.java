package com.example.adiosesr.appmvpexample.addTask;

import com.example.adiosesr.appmvpexample.BasePresenter;
import com.example.adiosesr.appmvpexample.BaseView;
import com.example.adiosesr.appmvpexample.model.Task;

public interface AddTaskContract {
    interface View extends BaseView<Presenter> {
        Task getTask();

        void closeActivity();

        void showMessageTitle(String message);

        void showMessageDescription(String message);

        void showMessageDateEnd(String message);

        void showMessageTypeTask(String message);

        void hideMessageTitle();

        void hideMessageDescription();

        void hideMessageDateEnd();

        void hideMessageTypeTask();


    }

    interface Presenter extends BasePresenter {
        boolean validateTitle();

        boolean validateDescription();

        boolean validateDateEnd();

        boolean validateTypeTask();

        void saveTask();
    }
}
