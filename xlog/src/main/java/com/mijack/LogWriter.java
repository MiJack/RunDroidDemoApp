package com.mijack;

import android.util.Log;

/**
 * The log file writer
 *
 * @author Mi&Jack
 */
public class LogWriter {

    private static final String TAG = "XLog";

    public static void d(int hookId, int pid, int threadId, String msg) {
        Log.d(TAG, msg);
    }
}
