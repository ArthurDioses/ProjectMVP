package com.example.adiosesr.appmvpexample.complete;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.adiosesr.appmvpexample.data.source.local.AppDatabase;
import com.example.adiosesr.appmvpexample.model.Task;

import java.lang.ref.WeakReference;
import java.util.List;

public class CompletePresenter implements CompleteContract.Presenter {

    @NonNull
    public CompleteContract.View view;

    public CompletePresenter(@NonNull CompleteContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {
        new GetTaskComplete(view).execute();
    }
    public static class GetTaskComplete extends AsyncTask<String,Void,List<Task>>
    {
        private WeakReference<CompleteContract.View> weakReference;

        public GetTaskComplete(CompleteContract.View view) {
            this.weakReference = new WeakReference<>(view);
        }

        @Override
        protected List<Task> doInBackground(String... strings)
        {
            return AppDatabase.getInstance(weakReference.get().context()).taskDAO().filterByStatus("Completado");
        }

        @Override
        protected void onPostExecute(List<Task> taskList) {
            super.onPostExecute(taskList);
            if(taskList!=null && !taskList.isEmpty())
            {
                weakReference.get().showListComplete(taskList);
            }
            else {
                weakReference.get().ListEmpty();
            }
        }
    }

}
