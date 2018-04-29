package com.example.adiosesr.appmvpexample.addTask;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.adiosesr.appmvpexample.BaseActivity;
import com.example.adiosesr.appmvpexample.R;
import com.example.adiosesr.appmvpexample.data.source.Extras;
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

    @BindView(R.id.ivNormal)
    ImageView ivNormal;
    @BindView(R.id.ivHigh)
    ImageView ivHight;
    @BindView(R.id.ivLow)
    ImageView ivLow;

    @BindView(R.id.btnSave)
    Button btnSave;
    @BindView(R.id.tvLow)
    TextView tvLow;
    @BindView(R.id.tvNormal)
    TextView tvNormal;
    @BindView(R.id.tvHigh)
    TextView tvHigh;

    @BindView(R.id.fabEdit)
    FloatingActionButton fabEdit;
    @BindView(R.id.fabDelete)
    FloatingActionButton fabDelete;

    AddTaskContract.Presenter presenter;
    private boolean isEdited;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        ButterKnife.bind(this);
        presenter = new AddTaskPresenter(this);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        validateExtra();
    }

    void validateExtra() {
        int idTask = getIntent().getIntExtra(Extras.EXTRAS_TASK.getExtra(), 0);

        if (idTask == 0) {
            isEdited = false;
        } else {
            isEdited = true;
            presenter.listTaskById(idTask);

        }
    }

    @OnClick(R.id.btnSave)
    public void btnSave() {
        //int id = getIntent().getIntExtra(Extras.EXTRAS_TASK.getExtra(),999);
        if (isEdited) {
            presenter.editTask();
        } else {
            presenter.saveTask();

        }
    }

    @OnClick(R.id.tietDateEnd)
    public void tietDateEnd() {
//        v.setClickable(false);
//        tietDateEnd.setClickable(true);
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

    @OnClick(R.id.ivNormal)
    public void ivNormal() {
        ivNormal.setSelected(true);
        ivNormal.setImageResource(R.drawable.ic_normal);
        ivNormal.animate().scaleX(1.5f).scaleY(1.5f).setDuration(200).start();
        ivHight.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).start();
        ivHight.setImageResource(R.drawable.ic_alta_gray);
        ivLow.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).start();
        ivLow.setImageResource(R.drawable.ic_baja_gray);
    }

    @OnClick(R.id.ivHigh)
    public void ivHigh() {
        ivHight.setSelected(true);
        ivHight.setImageResource(R.drawable.ic_alta);
        ivHight.animate().scaleX(1.5f).scaleY(1.5f).setDuration(200).start();
        ivNormal.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).start();
        ivNormal.setImageResource(R.drawable.ic_normal_gray);
        ivLow.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).start();
        ivLow.setImageResource(R.drawable.ic_baja_gray);
    }

    @OnClick(R.id.ivLow)
    public void ivLow() {
        ivLow.setSelected(true);
        ivLow.setImageResource(R.drawable.ic_baja);
        ivLow.animate().scaleX(1.5f).scaleY(1.5f).setDuration(200).start();
        ivNormal.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).start();
        ivNormal.setImageResource(R.drawable.ic_normal_gray);
        ivHight.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).start();
        ivHight.setImageResource(R.drawable.ic_alta_gray);
    }

    @OnClick(R.id.fabEdit)
    public void fabEdit() {
        fabDelete.setVisibility(View.INVISIBLE);
        tietTitle.setFocusableInTouchMode(true);
        tietTitle.setFocusable(true);
        tietDescription.setFocusableInTouchMode(true);
        tietDescription.setFocusable(true);

//        tietDateEnd.setClickable(true);
        //        tietDateEnd.setClickable(true);

//        tietDateEnd.setFocusableInTouchMode(true);
//        tietDateEnd.setFocusable(true);

//        tietTimeEnd.setFocusableInTouchMode(true);
//        tietTimeEnd.setFocusable(true);
//        tietTimeEnd.setClickable(true);

        tietTypeTask.setFocusableInTouchMode(true);
        tietTypeTask.setFocusable(true);
        ivLow.setVisibility(View.VISIBLE);
        tvLow.setVisibility(View.VISIBLE);
        ivNormal.setVisibility(View.VISIBLE);
        tvNormal.setVisibility(View.VISIBLE);
        ivHight.setVisibility(View.VISIBLE);
        tvHigh.setVisibility(View.VISIBLE);
        btnSave.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.fabDelete)
    public void fabDelete() {
        presenter.deleteTask();
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
        String priority = null;
        if (ivLow.isSelected()) {
            priority = "Baja";
        } else if (ivNormal.isSelected()) {
            priority = "Normal";
        } else if (ivHight.isSelected()) {
            priority = "Alta";
        }
        return priority;
    }

    @Override
    public String getTitleTask() {
        return tietTitle.getText().toString();
    }


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
    public void showListaTaskSelected(Task task) {
        fabEdit.setVisibility(View.VISIBLE);
        fabDelete.setVisibility(View.VISIBLE);
        tietTitle.setText(task.getTitle());
        tietTitle.setFocusable(false);
        tietDescription.setText(task.getDescTask());
        tietDescription.setFocusable(false);
        tietDateEnd.setText(task.getDateEnd().substring(0, (task.getDateEnd().length() - 6)));

//        tietDateEnd.setClickable(false);
        //tietDateEnd.setEnabled(false);
//        tietDateEnd.setClickable(false);
//        tietDateEnd.setFocusableInTouchMode(false);
//        tietDateEnd.setFocusable(false);
//        tietDateEnd.setOnClickListener(null);

        tietTimeEnd.setText(task.getDateEnd().substring(task.getDateEnd().lastIndexOf("-") + 1));
        tietTimeEnd.setFocusable(false);
//        tietTimeEnd.setClickable(false);
//        tietTimeEnd.setFocusableInTouchMode(false);


//        tietTimeEnd.setOnClickListener(null);
        tietTypeTask.setText(task.getTypeTask());
        tietTypeTask.setFocusable(false);
        validatePriority(task.getPriority());
        btnSave.setVisibility(View.INVISIBLE);
    }

    @Override
    public int getIdTask() {
        return getIntent().getIntExtra(Extras.EXTRAS_TASK.getExtra(), 999);
    }


    void validatePriority(String priority) {
        switch (priority) {
            case "Baja":
                ivLow();
                ivNormal.setVisibility(View.INVISIBLE);
                tvNormal.setVisibility(View.INVISIBLE);
                ivHight.setVisibility(View.INVISIBLE);
                tvHigh.setVisibility(View.INVISIBLE);

                break;
            case "Normal":
                ivNormal();
                ivLow.setVisibility(View.INVISIBLE);
                tvLow.setVisibility(View.INVISIBLE);
                ivHight.setVisibility(View.INVISIBLE);
                tvHigh.setVisibility(View.INVISIBLE);
                break;
            case "Alta":
                ivHigh();
                ivLow.setVisibility(View.INVISIBLE);
                tvLow.setVisibility(View.INVISIBLE);
                ivNormal.setVisibility(View.INVISIBLE);
                tvNormal.setVisibility(View.INVISIBLE);
                break;
        }
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
        tietTimeEnd.setText(String.format("%02d:%02d", hourOfDay, minute));
    }

}
