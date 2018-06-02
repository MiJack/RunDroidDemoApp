package com.mijack;

import android.util.Log;

import java.io.File;

import me.pqpo.librarylog4a.Log4a;
import me.pqpo.librarylog4a.appender.FileAppender;
import me.pqpo.librarylog4a.formatter.Formatter;
import me.pqpo.librarylog4a.logger.AppenderLogger;

/**
 * The log file writer
 *
 * @author Mi&Jack
 */
public class LogWriter {
    public static final int BUFFER_SIZE = 1024 * 400; //400k

    private static final String TAG = "XLog";

    static {
        Log.d("Demo", "test");
        String processName = XlogUtils.getProcessName();
        if (processName.contains(":")) {
            processName = processName.substring(0, processName.indexOf(":"));
        }
        int processId = XlogUtils.getProcessId();
        File log = new File("/data/data/" + processName + "/files/");
        if (log.exists() || log.mkdirs()) {
            File cacheFile = new File(log, processName + "_" + processId + ".logCache");
            File logFile = new File(log, processName + "_" + processId + ".log");
            cacheFile.delete();
            logFile.delete();
            FileAppender.Builder fileBuild = new FileAppender.Builder(null)
                    .setLogFilePath(logFile.getAbsolutePath())
                    .setBufferSize(BUFFER_SIZE)
                    .setFormatter(new Formatter() {
                        public String format(int logLevel, String tag, String msg) {
                            return msg;
                        }
                    })
                    .setBufferFilePath(cacheFile.getAbsolutePath());
            fileBuild.create();
            AppenderLogger logger = new AppenderLogger.Builder().create();
            Log4a.setLogger(logger);
        }
    }

    public static synchronized void d(int hookId, int pid, int threadId, String msg) {
        Log4a.d(TAG,msg);
    }
}
