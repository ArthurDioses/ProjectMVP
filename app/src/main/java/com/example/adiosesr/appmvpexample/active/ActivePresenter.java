package com.example.adiosesr.appmvpexample.active;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.adiosesr.appmvpexample.data.source.local.AppDatabase;
import com.example.adiosesr.appmvpexample.model.Task;

import java.lang.ref.WeakReference;
import java.util.List;

public class ActivePresenter implements ActiveContract.Presenter {
    @NonNull
    public ActiveContract.View view;

    ActivePresenter(@NonNull ActiveContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {
        new GetTask(view).execute();
    }

    private static class GetTask extends AsyncTask<Void, Void, List<Task>> {

        private WeakReference<ActiveContract.View> weakReference;

        private GetTask(ActiveContract.View view) {
            this.weakReference = new WeakReference<>(view);
        }

        @Override
        protected List<Task> doInBackground(Void... voids) {
            return AppDatabase.getInstance(weakReference.get().context()).taskDAO().getTasks();
        }

        @Override
        protected void onPostExecute(List<Task> tasks) {
            super.onPostExecute(tasks);

            if (tasks != null && !tasks.isEmpty()) {
                weakReference.get().showList(tasks);
            } else {
                weakReference.get().emptyList();
            }
        }
    }
}