package com.example.adiosesr.appmvpexample.addTask;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TimePicker;

import com.example.adiosesr.appmvpexample.BaseActivity;
import com.example.adiosesr.appmvpexample.R;
import com.example.adiosesr.appmvpexample.model.Task;
import com.example.adiosesr.appmvpexample.util.Navigator;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class AddTaskActivity extends BaseActivity implements AddTaskContract.View, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    @BindView(R.id.tilTitle)
    TextInputLayout tilTitle;
    @BindView(R.id.tilDescription)
    TextInputLayout tilDescription;
    @BindView(R.id.tilDateEnd)
    TextInputLayout tilDateEnd;
    @BindView(R.id.tilTimeEnd)
    TextInputLayout tilTimeEnd;
    @BindView(R.id.tilTypeTask)
    TextInputLayout tilTypeTask;

    @BindView(R.id.tietTitle)
    TextInputEditText tietTitle;
    @BindView(R.id.tietDescription)
    TextInputEditText tietDescription;
    @BindView(R.id.tietDateEnd)
    TextInputEditText tietDateEnd;
    @BindView(R.id.tietTimeEnd)
    TextInputEditText tietTimeEnd;
    @BindView(R.id.tietTypeTask)
    TextInputEditText tietTypeTask;

    @BindView(R.id.spPriority)
    Spinner spPriority;
    @BindView(R.id.spStatus)
    Spinner spStatus;

    AddTaskContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        ButterKnife.bind(this);
        presenter = new AddTaskPresenter(this);
    }

    @OnClick(R.id.btnSave)
    public void btnSave() {
        presenter.saveTask();
    }

    @OnClick(R.id.tietDateEnd)
    public void tietDateEnd() {
        showCalendar();
    }

    @OnClick(R.id.tietTimeEnd)
    public void tietTimeEnd() {
        showClock();
    }

    @OnTextChanged(value = {R.id.tietTitle, R.id.tietDescription, R.id.tietDateEnd, R.id.tietTypeTask},
            callback = OnTextChanged.Callback.TEXT_CHANGED)
    void textChanged() {
        hideMessageTitle();
        hideMessageDescription();
        hideMessageDateEnd();
        hideMessageTimeEnd();
        hideMessageTypeTask();

    }

    @Override
    public void setPresenter(AddTaskContract.Presenter presenter) {
        //default implementation
    }

    @Override
    public Context context() {
        return this;
    }


    @Override
    public String getDescription() {
        return tietDescription.getText().toString();
    }

    @Override
    public String getDateEnd() {
        return tietDateEnd.getText().toString();
    }

    @Override
    public String getTimeEnd() {
        return tietTimeEnd.getText().toString();
    }

    @Override
    public String getTypeTask() {
        return tietTypeTask.getText().toString();
    }

    @Override
    public String getPriority() {
        return spPriority.getSelectedItem().toString();
    }

    @Override
    public String getStatus() {
        return spStatus.getSelectedItem().toString();
    }

    @Override
    public String getTitleTask() {
        return tietTitle.getText().toString();
    }

//    @Override
//    public Task getTask() {
//        Task task = new Task();
//        task.setTitle(tietTitle.getText().toString());
//        task.setDescTask(tietDescription.getText().toString());
//        task.setDateEnd(tietDateEnd.getText().toString() + tietTimeEnd.getText());
//        task.setTypeTask(tietTypeTask.getText().toString());
//        task.setPriority(spPriority.getSelectedItem().toString());
//        task.setStatus(spStatus.getSelectedItem().toString());
//        return task;
//    }

    @Override
    public void closeActivity() {
        Navigator.returnToActiveFragment(this);
    }

    @Override
    public void showMessageTitle(String message) {
        tilTitle.setErrorEnabled(true);
        tilTitle.setError(message);
    }

    @Override
    public void showMessageDescription(String message) {
        tilDescription.setErrorEnabled(true);
        tilDescription.setError(message);
    }

    @Override
    public void showMessageDateEnd(String message) {
        tilDateEnd.setErrorEnabled(true);
        tilDateEnd.setError(message);
    }

    @Override
    public void showMessageTimeEnd(String message) {
        tilTimeEnd.setErrorEnabled(true);
        tilTimeEnd.setError(message);
    }

    @Override
    public void showMessageTypeTask(String message) {
        tilTypeTask.setErrorEnabled(true);
        tilTypeTask.setError(message);
    }

    @Override
    public void showMessagePriority(String message) {

    }

    @Override
    public void showMessageStatus(String message) {

    }

    @Override
    public void hideMessageTitle() {
        if (tilTitle.isErrorEnabled()) {
            tilTitle.setErrorEnabled(false);
            tilTitle.setError("");
        }
    }

    @Override
    public void hideMessageDescription() {
        if (tilDescription.isErrorEnabled()) {
            tilDescription.setErrorEnabled(false);
            tilDescription.setError("");
        }
    }

    @Override
    public void hideMessageDateEnd() {
        if (tilDateEnd.isErrorEnabled()) {
            tilDateEnd.setErrorEnabled(false);
            tilDateEnd.setError("");
        }
    }

    @Override
    public void hideMessageTimeEnd() {
        if (tilTimeEnd.isErrorEnabled()) {
            tilTimeEnd.setErrorEnabled(false);
            tilTimeEnd.setError("");
        }
    }

    @Override
    public void hideMessageTypeTask() {
        if (tilTypeTask.isErrorEnabled()) {
            tilTypeTask.setErrorEnabled(false);
            tilTypeTask.setError("");
        }
    }

    @Override
    public void hideMessagePriority() {

    }

    @Override
    public void hideMessageStatus() {

    }

    void showCalendar() {

        Calendar mCurrentDate = Calendar.getInstance();

        int day = mCurrentDate.get(Calendar.DATE);
        int month = mCurrentDate.get(Calendar.MONTH);
        int year = mCurrentDate.get(Calendar.YEAR);

        DatePickerDialog mDatePicker;
        mDatePicker = new DatePickerDialog(AddTaskActivity.this, this, year, month, day);
        mDatePicker.show();
    }

    void showClock() {
        Calendar mCurrentTime = Calendar.getInstance();

        int hour = mCurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mCurrentTime.get(Calendar.MINUTE);

        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(AddTaskActivity.this, this, hour, minute, false);
        mTimePicker.show();

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        Calendar currentDate = Calendar.getInstance();
        currentDate.set(year, month, dayOfMonth);

        Date date = currentDate.getTime();

        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("dd 'de' MMMM 'del' yyyy");

        tietDateEnd.setText(sdf.format(date));
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        tietTimeEnd.setText(hourOfDay + ":" + minute);
    }
}
