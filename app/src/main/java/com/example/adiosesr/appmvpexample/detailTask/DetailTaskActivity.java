package com.example.adiosesr.appmvpexample.detailTask;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.adiosesr.appmvpexample.R;

public class DetailTaskActivity extends AppCompatActivity implements DetailTaskContract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_task);
    }

    @Override
    public void setPresenter(DetailTaskContract.Presenter presenter) {

    }

    @Override
    public Context context() {
        return null;
    }
}
