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
        if (view.getPriority().isEmpty()) {
            view.showMessagePriority("Seleccione Prioridad");
            return false;
        }
        return true;
    }


    @Override
    public void saveTask() {
        if (validateTitleTask() &&
                validateDescription() &&
                validateDateEnd() &&
                validateTimeEnd() &&
                validateTypeTask() &&
                validatePriority()) {
            Task mTask = new Task();
            mTask.setTitle(view.getTitleTask());
            mTask.setDescTask(view.getDescription());
            mTask.setDateEnd(view.getDateEnd() + "-" + view.getTimeEnd());
            mTask.setTypeTask(view.getTypeTask());
            mTask.setPriority(view.getPriority());
            mTask.setStatus("Pendiente");

            new SaveTask(view).execute(mTask);
        }
    }

    @Override
    public void editTask() {
        if (validateTitleTask() &&
                validateDescription() &&
                validateDateEnd() &&
                validateTimeEnd() &&
                validateTypeTask() &&
                validatePriority()) {
            Task mTask = new Task();
            mTask.setIdTask(view.getIdTask());
            mTask.setTitle(view.getTitleTask());
            mTask.setDescTask(view.getDescription());
            mTask.setDateEnd(view.getDateEnd() + "-" + view.getTimeEnd());
            mTask.setTypeTask(view.getTypeTask());
            mTask.setPriority(view.getPriority());
            mTask.setStatus("Pendiente");

            new EditTask(view).execute(mTask);
        }
    }

    @Override
    public void listTaskById(int idTask) {
        new GetTaskSelected(view).execute(idTask);
    }

    @Override
    public void deleteTask() {
        new DeleteTask(view).execute(view.getIdTask());
    }

    private static class DeleteTask extends AsyncTask<Integer,Void,Void>{
        private WeakReference<AddTaskContract.View> weakReference;

        public DeleteTask(AddTaskContract.View view) {
            this.weakReference = new WeakReference<>(view);
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            AppDatabase.getInstance(weakReference.get().context()).taskDAO().deleteTask(integers[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            weakReference.get().closeActivity();
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
    private  static class EditTask extends AsyncTask<Task,Void,Void>{
        private WeakReference<AddTaskContract.View> weakReference;

        EditTask(AddTaskContract.View view){
            this.weakReference = new WeakReference<>(view);
        }

        @Override
        protected Void doInBackground(Task... tasks) {
            AppDatabase.getInstance(weakReference.get().context()).taskDAO().updateTask(tasks[0].getIdTask(),tasks[0].getTitle(),
                    tasks[0].getDescTask(),tasks[0].getDateEnd(),tasks[0].getTypeTask(),tasks[0].getPriority());
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            weakReference.get().closeActivity();
        }
    }

    private static class GetTaskSelected extends AsyncTask<Integer, Void, Task> {
        private WeakReference<AddTaskContract.View> weakReference;

        GetTaskSelected(AddTaskContract.View view) {
            this.weakReference = new WeakReference<>(view);
        }

        @Override
        protected Task doInBackground(Integer... integers) {
            return AppDatabase.getInstance(weakReference.get().context()).taskDAO().filterByidTask(integers[0]);
        }

        @Override
        protected void onPostExecute(Task task) {
            super.onPostExecute(task);
            if (task != null) {
                weakReference.get().showListaTaskSelected(task);
            }
        }
    }
}