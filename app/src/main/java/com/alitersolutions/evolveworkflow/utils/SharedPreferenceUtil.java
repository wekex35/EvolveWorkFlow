package com.alitersolutions.evolveworkflow.utils;

import android.content.Context;
import android.content.SharedPreferences.Editor;

public class SharedPreferenceUtil {
    private static String MY_PREFS_NAME = Constants.TAG;

    public static void storeStringValue(Context context, String key, String value) {
        Editor editor = context.getSharedPreferences(MY_PREFS_NAME, 0).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static void storeBooleanValue(Context context, String key, boolean value) {
        Editor editor = context.getSharedPreferences(MY_PREFS_NAME, 0).edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static void storeIntValue(Context context, String key, int value) {
        Editor editor = context.getSharedPreferences(MY_PREFS_NAME, 0).edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static String getStringValue(Context context, String key) {
        return context.getSharedPreferences(MY_PREFS_NAME, 0).getString(key, "");
    }

    public static int getIntValue(Context context, String key) {
        return context.getSharedPreferences(MY_PREFS_NAME, 0).getInt(key, 0);
    }

    public static String getStringValue(Context context, String key, String defaultVal) {
        return context.getSharedPreferences(MY_PREFS_NAME, 0).getString(key, defaultVal);
    }

    public static boolean getBoolen(Context context, String key) {
        return context.getSharedPreferences(MY_PREFS_NAME, 0).getBoolean(key, false);
    }
}
