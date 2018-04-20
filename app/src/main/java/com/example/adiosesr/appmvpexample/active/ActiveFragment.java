package com.example.adiosesr.appmvpexample.active;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adiosesr.appmvpexample.R;
import com.example.adiosesr.appmvpexample.model.Task;
import com.example.adiosesr.appmvpexample.util.Navigator;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActiveFragment extends Fragment implements ActiveContract.View {

    @BindView(R.id.rvListTask)
    RecyclerView rvListTask;

    ActiveContract.Presenter presenter;

    TaskAdapter adapter;

    public ActiveFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_active, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvListTask.setLayoutManager(layoutManager);

        presenter = new ActivePresenter(this);
        adapter = new TaskAdapter(null);
        rvListTask.setAdapter(adapter);
        presenter.start();

    }

    @OnClick(R.id.btnNewTask)
    public void btnNewTask() {
        Navigator.navigateToAddTaskActivity(getActivity());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            presenter.start();
        }
    }

    @Override
    public void setPresenter(ActiveContract.Presenter presenter) {
        //default Implementation
    }

    @Override
    public Context context() {
        return getActivity();
    }

    @Override
    public void showList(List<Task> mTasks) {

        adapter.updateTask(mTasks);
    }

    @Override
    public void emptyList() {

    }
}
