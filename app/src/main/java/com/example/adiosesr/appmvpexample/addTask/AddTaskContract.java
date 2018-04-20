package com.example.adiosesr.appmvpexample.addTask;

import com.example.adiosesr.appmvpexample.BasePresenter;
import com.example.adiosesr.appmvpexample.BaseView;

public interface AddTaskContract {
    interface View extends BaseView<Presenter> {

        String getDescription();

        String getDateEnd();

        String getTimeEnd();

        String getTypeTask();

        String getPriority();

        String getStatus();

        String getTitleTask();


//        Task getTask();

        void closeActivity();

        void showMessageTitle(String message);

        void showMessageDescription(String message);

        void showMessageDateEnd(String message);

        void showMessageTimeEnd(String message);

        void showMessageTypeTask(String message);
        void showMessagePriority(String message);
        void showMessageStatus(String message);

        void hideMessageTitle();

        void hideMessageDescription();

        void hideMessageDateEnd();

        void hideMessageTimeEnd();

        void hideMessageTypeTask();
        void hideMessagePriority();
        void hideMessageStatus();
    }

    interface Presenter extends BasePresenter {
        boolean validateTitleTask();

        boolean validateDescription();

        boolean validateDateEnd();

        boolean validateTimeEnd();

        boolean validateTypeTask();

        boolean validatePriority();

        boolean validateStatus();

        void saveTask();
    }
}
