package com.example.adiosesr.appmvpexample.addTask;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.adiosesr.appmvpexample.data.source.local.AppDatabase;
import com.example.adiosesr.appmvpexample.model.Task;

import java.lang.ref.WeakReference;


public class AddTaskPresenter implements AddTaskContract.Presenter {

    @NonNull
    private final AddTaskContract.View view;

    AddTaskPresenter(@NonNull AddTaskContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        //method empty
    }

    @Override
    public boolean validateTitle() {
        if (view.getTask().getTitle().isEmpty()) {
            view.showMessageTitle("Titulo requerido");
            return false;
        }
        return true;
    }

    @Override
    public boolean validateDescription() {
        if (view.getTask().getDescTask().isEmpty()) {
            view.showMessageDescription("Descripción requerida");
            return false;
        }
        return true;
    }

    @Override
    public boolean validateDateEnd() {
        if (view.getTask().getDateEnd().isEmpty()) {
            view.showMessageDateEnd("Fecha requerida");
            return false;
        }
        return true;
    }

    @Override
    public boolean validateTypeTask() {
        if (view.getTask().getTypeTask().isEmpty()) {
            view.showMessageTypeTask("Tipo de tarea requerdida");
            return false;
        }
        return true;
    }

    @Override
    public void saveTask() {
        if (validateTitle() && validateDescription() && validateDateEnd() && validateTypeTask()) {
            Task mTask = view.getTask();
            new SaveTask(view).execute(mTask);
        }
    }

    private static class SaveTask extends AsyncTask<Task, Void, Void> {
        private WeakReference<AddTaskContract.View> weakReference;

        SaveTask(AddTaskContract.View view) {
            this.weakReference = new WeakReference<>(view);
        }

        @Override
        protected Void doInBackground(Task... tasks) {
            AppDatabase.getInstance(weakReference.get().context()).taskDAO().insertTask(tasks[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            weakReference.get().closeActivity();
        }
    }
}

