package com.callo.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.util.Patterns;
import android.widget.EditText;

/**
 * Created by abhishesh.s on 5/8/16.
 */
public class Util {


    public static boolean hasInternetAccess(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public String getDeviceId(Context context){
        String model = android.os.Build.MODEL + "_";
        String android_id = Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID);
        return model + android_id;
    }

    public static Boolean isEditTextEmpty(EditText... editTexts) {
        for (EditText editText : editTexts) {
            String editTextValue = editText.getText().toString().trim();
            String hintString = "";
            if (editText.getHint() != null) {
                hintString = editText.getHint().toString();
            }
            if ((editTextValue == null || editTextValue.length() == 0 || (editTextValue.compareTo(hintString) == 0))) {
                return true;
            }
        }
        return false;
    }

    public final static boolean isValidName(String fullName) {
        return fullName.matches("[A-Za-z_\\s]+");
    }

    public static Boolean isValidEmail(String emailstring) {
        return Patterns.EMAIL_ADDRESS.matcher(emailstring).matches();//emailMatcher.matches();
    }

    public static Boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber.trim().length() != 10) {
            return false;
        } else if (Integer.parseInt(phoneNumber.substring(0, 1)) == 1) {
            return false;
        }
        return true;
    }
}
