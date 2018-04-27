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

    private static class GetTask extends AsyncTask<String, Void, List<Task>> {

        private WeakReference<ActiveContract.View> weakReference;

        private GetTask(ActiveContract.View view) {
            this.weakReference = new WeakReference<>(view);
        }

        @Override
        protected List<Task> doInBackground(String... strings) {
            return AppDatabase.getInstance(weakReference.get().context()).taskDAO().filterByStatus("Pendiente");
        }

        @Override
        protected void onPostExecute(List<Task> taskList) {
            super.onPostExecute(taskList);
            if(taskList!=null && !taskList.isEmpty())
            {
                weakReference.get().showList(taskList);
            }
            else
            {
                weakReference.get().emptyList();
            }
        }
    }
}