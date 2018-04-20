package com.example.adiosesr.appmvpexample.active;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.adiosesr.appmvpexample.R;
import com.example.adiosesr.appmvpexample.model.Task;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TaskAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Task> mTasks;

    public TaskAdapter(List<Task> mTasks) {
        this.mTasks = mTasks;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        return new TaskViewHolder(LayoutInflater.from(context).inflate(R.layout.task_row, parent, false));
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

    class TaskViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.tvDescription)
        TextView tvDescription;
        @BindView(R.id.tvDateEnd)
        TextView tvDateEnd;
        @BindView(R.id.tvTimeEnd)
        TextView tvTimeEnd;

        Task mTask;

        TaskViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void bindView(Task task) {
            mTask = task;
            tvTitle.setText(task.getTitle());
            tvDescription.setText(task.getDescTask());
            tvDateEnd.setText(String.valueOf(task.getDateEnd()));
            tvDateEnd.setText(task.getDateEnd());
            tvTimeEnd.setText(task.getDateEnd());
        }
    }
}
