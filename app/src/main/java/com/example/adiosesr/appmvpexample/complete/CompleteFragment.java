package com.example.adiosesr.appmvpexample.complete;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adiosesr.appmvpexample.R;
import com.example.adiosesr.appmvpexample.active.TaskAdapter;
import com.example.adiosesr.appmvpexample.model.Task;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CompleteFragment extends Fragment implements CompleteContract.View {

    @BindView(R.id.rvListComplete)
    RecyclerView rvListComplete;

    CompleteContract.Presenter presenter;
    TaskAdapter adapter;

    public CompleteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvListComplete.setLayoutManager(layoutManager);

        presenter = new CompletePresenter(this);
        adapter = new TaskAdapter(null);
        rvListComplete.setAdapter(adapter);
        presenter.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_complete, container, false);
    }

    @Override
    public void setPresenter(CompleteContract.Presenter presenter) {

    }

    @Override
    public Context context() {
        return getActivity();
    }

    @Override
    public void showListComplete(List<Task> taskComplete) { adapter.updateTask(taskComplete);
    }

    @Override
    public void ListEmpty() {

    }
}
