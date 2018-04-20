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
    public boolean validateTitleTask() {
        if (view.getTitleTask().isEmpty()) {
            view.showMessageTitle("Titulo requerido");
            return false;
        }
        return true;
    }

    @Override
    public boolean validateDescription() {
        if (view.getDescription().isEmpty()) {
            view.showMessageDescription("Descripción requerida");
            return false;
        }
        return true;
    }

    @Override
    public boolean validateDateEnd() {
        if (view.getDateEnd().isEmpty()) {
            view.showMessageDateEnd("Fecha requerida");
            return false;
        }
        return true;
    }

    @Override
    public boolean validateTimeEnd() {
        if (view.getTimeEnd().isEmpty()) {
            view.showMessageTimeEnd("Hora requerida");
            return false;
        }
        return true;
    }

    @Override
    public boolean validateTypeTask() {
        if (view.getTypeTask().isEmpty()) {
            view.showMessageTypeTask("Tipo de tarea requerdida");
            return false;
        }
        return true;
    }

    @Override
    public boolean validatePriority() {
        if(view.getPriority().isEmpty())
        {
            view.showMessagePriority("Seleccione Prioridad");
            return false;
        }
        return true;
    }

    @Override
    public boolean validateStatus() {
        if (view.getStatus().isEmpty())
        {
            view.showMessageStatus("Seleccione Estado");
            return false;
        }
        return true;
    }

    @Override
    public void saveTask() {
        if (validateTitleTask() && validateDescription() && validateDateEnd() && validateTimeEnd() && validateTypeTask() && validatePriority() && validateStatus()) {
            Task mTask = new Task();
            mTask.setTitle(view.getTitleTask());
            mTask.setDescTask(view.getDescription());
            mTask.setDateEnd(view.getDateEnd()+"-"+view.getTimeEnd());
            mTask.setTypeTask(view.getTypeTask());
            mTask.setPriority(view.getPriority());
            mTask.setStatus(view.getStatus());

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

