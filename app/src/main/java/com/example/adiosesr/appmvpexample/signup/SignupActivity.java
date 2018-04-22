package com.example.adiosesr.appmvpexample.signup;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;

import com.example.adiosesr.appmvpexample.BaseActivity;
import com.example.adiosesr.appmvpexample.R;
import com.example.adiosesr.appmvpexample.util.Navigator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignupActivity extends BaseActivity implements SignupContract.View {

    private SignupPresenter presenter;

    @BindView(R.id.etInput)
    TextInputEditText etInput;
    @BindView(R.id.tilInput)
    TextInputLayout tilInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

        presenter = new SignupPresenter(this);
        presenter.start();

    }

    @OnClick(R.id.btnEnter)
    public void onBtnValidate() {
        presenter.validateField();
    }

    @Override
    public void setPresenter(SignupContract.Presenter presenter) {
        //default Implementation
    }

    @Override
    public Context context() {
        return this;
    }

    @Override
    public String getName() {
        return etInput.getText().toString();
    }

    @Override
    public void showMessage(String message) {
        tilInput.setError(message);
    }

    @Override
    public void goToHome() {
        Navigator.navigateToHomeActivity(this);
    }
}
