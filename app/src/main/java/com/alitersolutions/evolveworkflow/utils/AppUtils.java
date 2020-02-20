package com.alitersolutions.evolveworkflow.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class AppUtils {
    public static String BASE_SITE = null;
    public static String BASE_URL = null;
    private static final String EMPTY_STRING = "";
    public static String HASHKEY;
    private static String TAG = "AppUtils";
    public static String deviceIMEI;

/*    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager.isActive() && activity.getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }*/

    public static String getDay(String day) {
        return new SimpleDateFormat("EEEE").format(getDate(day));
    }

    private static Date getDate(String day) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(day);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getParsedDate(String day) {
        return new SimpleDateFormat("dd-MM-yyyy").format(getDate(day));
    }

    public static String longToDate(String val, String pattern, int multiplier) {
        String str = "";
        if (val != null) {
            try {
                if (!val.isEmpty()) {
                    return new SimpleDateFormat(pattern).format(new Date(Long.parseLong(val) * ((long) multiplier)));
                }
            } catch (Exception e) {
                e.printStackTrace();
                return str;
            }
        }
        return str;
    }

/*    public static String getHashKey(Context pContext) {
        String str = "printHashKey()";
        try {
            Signature[] signatureArr = pContext.getPackageManager().getPackageInfo(pContext.getPackageName(), 64).signatures;
            if (signatureArr.length > 0) {
                Signature signature = signatureArr[0];
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                HASHKEY = new String(Base64.encode(md.digest(), 0));
                return HASHKEY.trim().trim();
            }
        } catch (NoSuchAlgorithmException e) {
            Log.e(TAG, str, e);
        } catch (Exception e2) {
            Log.e(TAG, str, e2);
        }
        return null;
    }*/

    public static boolean isServerAvailable(String base_url) {
        try {
            InetAddress.getByName(base_url).isReachable(2000);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String getDurationFromSeconds(int totalSecs) {
        return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf(totalSecs / 3600), Integer.valueOf((totalSecs % 3600) / 60), Integer.valueOf(totalSecs % 60)});
    }

    public static String inputStreamToString(InputStream inputStream) {
        try {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, bytes.length);
            return new String(bytes);
        } catch (IOException e) {
            return null;
        }
    }

    public static String getCurrentTimeStamp() {
        try {
            return new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int intJsonreader(JSONObject jsonObject, String what) {
        try {
            return ((Integer) jsonObject.get(what)).intValue();
        } catch (JSONException e) {
            e.printStackTrace();
            return Integer.parseInt("0");
        }
    }
}
