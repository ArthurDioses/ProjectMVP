package com.example.adiosesr.appmvpexample.addTask;

import com.example.adiosesr.appmvpexample.BasePresenter;
import com.example.adiosesr.appmvpexample.BaseView;
import com.example.adiosesr.appmvpexample.model.Task;


public interface AddTaskContract {
    interface View extends BaseView<Presenter> {

        String getDescription();

        String getDateEnd();

        String getTimeEnd();

        String getTypeTask();

        String getPriority();

        String getTitleTask();

        void closeActivity();

        void showMessageTitle(String message);

        void showMessageDescription(String message);

        void showMessageDateEnd(String message);

        void showMessageTimeEnd(String message);

        void showMessageTypeTask(String message);

        void showMessagePriority(String message);

        void hideMessageTitle();

        void hideMessageDescription();

        void hideMessageDateEnd();

        void hideMessageTimeEnd();

        void hideMessageTypeTask();


        void showListaTaskSelected(Task task);

        int getIdTask();
    }

    interface Presenter extends BasePresenter {

        boolean validateTitleTask();

        boolean validateDescription();

        boolean validateDateEnd();

        boolean validateTimeEnd();

        boolean validateTypeTask();

        boolean validatePriority();

        void saveTask();

        void editTask();

        void listTaskById(int idTask);

        void deleteTask();
    }
}
