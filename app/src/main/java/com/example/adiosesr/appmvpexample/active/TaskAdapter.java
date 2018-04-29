package com.example.adiosesr.appmvpexample.active;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.adiosesr.appmvpexample.R;
import com.example.adiosesr.appmvpexample.TaskClickListener;
import com.example.adiosesr.appmvpexample.data.source.local.AppDatabase;
import com.example.adiosesr.appmvpexample.model.Task;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TaskAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Task> mTasks;
    TaskClickListener taskClickListener;

    //public TaskAdapter(List<Task> mTasks) {
      //  this.mTasks = mTasks;
    public TaskAdapter(TaskClickListener taskClickListener) {
        this.taskClickListener = taskClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        return new TaskViewHolder(LayoutInflater.from(context).inflate(R.layout.task_row, parent, false),this.taskClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TaskViewHolder) holder).bindView(mTasks.get(position));
    }

    @Override
    public int getItemCount() {
        return mTasks == null ? 0 : mTasks.size();
    }

    public void updateTask(List<Task> taskRows) {
        mTasks = taskRows;
        notifyDataSetChanged();
    }

    class TaskViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.tvDescription)
        TextView tvDescription;
        @BindView(R.id.tvDateEnd)
        TextView tvDateEnd;
        @BindView(R.id.tvTimeEnd)
        TextView tvTimeEnd;

        @BindView(R.id.btnComplete)
        Button btnComplete;

        TaskClickListener mClickListener;

        Task mTask;

        TaskViewHolder(View itemView,TaskClickListener taskClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            this.mClickListener = taskClickListener;
        }
        private void bindView(Task task) {
            mTask = task;
            tvTitle.setText(task.getTitle());
            tvDescription.setText(task.getDescTask());
            tvDateEnd.setText(String.valueOf(task.getDateEnd()));
            tvDateEnd.setText(task.getDateEnd().substring(0,(task.getDateEnd().length()-6)));
            tvTimeEnd.setText(task.getDateEnd().substring(task.getDateEnd().lastIndexOf("-")+1));
        }
        @OnClick(R.id.btnComplete)
        public void btnComplete()
        {
        }

        @Override
        public void onClick(View v) {
            mClickListener.onClick(mTask.getIdTask());
            Log.d("idTarea", "onClick: "+mTask.getIdTask());
        }
    }
}
