package com.example.adiosesr.appmvpexample.profile;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.adiosesr.appmvpexample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileFragment extends Fragment implements ProfileContract.View {

    ProfileContract.Presenter presenter;
    @BindView(R.id.tvUsername)
    TextView tvUsername;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        presenter = new ProfilePresenter(this);
        presenter.start();
    }

    @Override
    public void setPresenter(ProfileContract.Presenter presenter) {
        //default Implementation
    }

    @Override
    public Context context() {
        return getActivity();
    }

    @Override
    public void showUsername(String username) {
        tvUsername.setText(username);
    }
}
