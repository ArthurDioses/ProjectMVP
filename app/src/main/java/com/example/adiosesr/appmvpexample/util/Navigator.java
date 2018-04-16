package com.example.adiosesr.appmvpexample.util;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;

import com.example.adiosesr.appmvpexample.BaseActivity;
import com.example.adiosesr.appmvpexample.home.HomeActivity;
import com.example.adiosesr.appmvpexample.signup.SignupActivity;

public class Navigator {

    public static void navigateToHomeActivity(BaseActivity activity) {
        Intent intent = new Intent(activity, HomeActivity.class);
        activity.startActivity(intent);
    }

    public static void navigateFragmentToSignupActivity(FragmentActivity fragment) {
        Intent intent = new Intent(fragment, SignupActivity.class);
        fragment.startActivity(intent);
    }
}
