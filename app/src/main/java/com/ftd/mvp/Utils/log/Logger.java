package com.ftd.mvp.Utils.log;

import android.util.Log;

public class Logger{

    private static final int VERBOSE = 0;
    private static final int DEBUG = 1;
    private static final int INFO = 2;
    private static final int WARN = 3;
    private static final int ERROR = 4;
    private static final int WTF = 5;
    private static final String TAG = "【 Saleen 139 】";
    private static final String FLAG_START = "[";
    private static final String FLAG_CENTER = "]---> {";
    private static final String FLAG_END = "} ";
    private static final String BLANK_LINE = " ------------------------------------------------------- ";
    private static final String BLANK = "                                                         ";


    private static int mLevel = DEBUG;

    public static void setLevel(int level) {
        mLevel = level;
    }

    public static void verbose(String className, String content) {
        if (mLevel <= VERBOSE) {
            Log.v(TAG, FLAG_START + className + FLAG_CENTER + content + FLAG_END);
        }
    }

    public static void debug(String className, String content) {
        if (mLevel <= DEBUG) {
            Log.d(TAG, FLAG_START + className + FLAG_CENTER + content + FLAG_END);
        }
    }

    public static void info(String className, String content, boolean... needBlank) {
        if (mLevel <= INFO) {
            if(needBlank != null && needBlank.length != 0){
                blankStart();
            }
            Log.i(TAG, FLAG_START + className + FLAG_CENTER + content + FLAG_END);
            if(needBlank != null && needBlank.length != 0){
                blankEnd();
            }
        }
    }

    public static void warn(String className, String content) {
        if (mLevel <= WARN) {
            Log.w(TAG, FLAG_START + className + FLAG_CENTER + content + FLAG_END);
        }
    }

    public static void error(String className, String content) {
        if (mLevel <= ERROR) {
            Log.e(TAG, FLAG_START + className + FLAG_CENTER + content + FLAG_END);
        }
    }

    public static void wtf(String className, String content) {
        if (mLevel <= WTF) {
            Log.wtf(TAG, FLAG_START + className + FLAG_CENTER + content + FLAG_END);
        }
    }

    public static void blankStart() {
        Log.i(TAG, BLANK);
        Log.i(TAG, BLANK_LINE);
    }

    public static void blankEnd() {
        Log.i(TAG, BLANK_LINE);
        Log.i(TAG, BLANK);
    }
}
