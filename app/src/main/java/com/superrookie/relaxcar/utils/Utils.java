package com.superrookie.relaxcar.utils;

import android.os.Build;

/**
 * Created by Hyunsun on 2018. 5. 28..
 */

public class Utils {

    public static boolean isOOS() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.O;
    }
}
