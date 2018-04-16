package com.example.adiosesr.appmvpexample.util;

import android.content.Intent;

import com.example.adiosesr.appmvpexample.BaseActivity;
import com.example.adiosesr.appmvpexample.home.HomeActivity;

public class Navigator {

    public static void navigateToHomeActivity(BaseActivity activity) {
        Intent intent = new Intent(activity, HomeActivity.class);
        activity.startActivity(intent);
    }
}
