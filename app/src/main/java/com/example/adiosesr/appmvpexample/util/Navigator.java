package com.example.adiosesr.appmvpexample.util;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

import com.example.adiosesr.appmvpexample.BaseActivity;
import com.example.adiosesr.appmvpexample.addTask.AddTaskActivity;
import com.example.adiosesr.appmvpexample.home.HomeActivity;
import com.example.adiosesr.appmvpexample.signup.SignupActivity;

public class Navigator {

    public static void navigateToHomeActivity(BaseActivity activity) {
        Intent intent = new Intent(activity, HomeActivity.class);
        activity.startActivity(intent);
    }

    public static void navigateToSignupActivity(BaseActivity activity) {
        Intent intent = new Intent(activity, SignupActivity.class);
        activity.startActivity(intent);
    }
    public static void navigateToAddTaskActivity(FragmentActivity fragmentActivity)
    {
        Intent intent =  new Intent(fragmentActivity, AddTaskActivity.class);
        fragmentActivity.startActivityForResult(intent,1);
    }
    public static void returnToActiveFragment(BaseActivity activity)
    {
        Intent intent = new Intent();
        activity.setResult(Activity.RESULT_OK,intent);
        activity.finish();
    }
}
