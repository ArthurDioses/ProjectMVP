package com.example.adiosesr.appmvpexample.data.source.preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesManager {

    private static final String KEY_PREFERENCE = "AppMVPExample";
    private static final String KEY_USERNAME = "key_username";

    private SharedPreferences preferences;

    public PreferencesManager(Context context) {
        preferences = context.getSharedPreferences(KEY_PREFERENCE, Context.MODE_PRIVATE);
    }

    public void storeUserName(String username) {
        preferences.edit().putString(KEY_USERNAME, username).apply();
    }

    public String getUserName() {
        return preferences.getString(KEY_USERNAME, "");
    }

    public boolean hasUserName() {
        return preferences.contains(KEY_USERNAME);
    }

    public void deleteUserName() {
        preferences.edit().remove(KEY_USERNAME).apply();
    }
}