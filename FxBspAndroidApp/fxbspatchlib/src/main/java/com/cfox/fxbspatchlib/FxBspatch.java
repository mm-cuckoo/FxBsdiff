package com.cfox.fxbspatchlib;

import android.content.Context;
import android.util.Log;

import java.io.File;


public class FxBspatch {

    private static final String TAG = "FxBspatch";
    public static final int BSPATCH_FAIL            = 0;
    public static final int BSPATCH_SUCCESS         = 1;
    public static final int FILE_PATH_ERROR         = 2;


    public int bspatchFile(Context context, String newApkFilePath, String apkPatchFilePath) {
        String oldApkFilePath = ApkUtils.getSourceApkPath(context.getApplicationContext());
        return bspatchFile(oldApkFilePath,newApkFilePath ,apkPatchFilePath);
    }

    public int bspatchFile(Context context, String packageName, String newApkFilePath, String apkPatchFilePath) {
        String oldApkFilePath = ApkUtils.getSourceApkPath(context.getApplicationContext(), packageName);
        return bspatchFile(oldApkFilePath,newApkFilePath ,apkPatchFilePath);
    }

    private int bspatchFile(String oldApkFilePath, String newApkFilePath, String apkPatchFilePath) {
        if (oldApkFilePath == null || newApkFilePath == null || apkPatchFilePath == null) {
            return BSPATCH_FAIL;
        }

        if (!isFile(apkPatchFilePath)) {
            Log.e(TAG, " patch file  error , don`t find patch file , patch file path :" + apkPatchFilePath);
            return FILE_PATH_ERROR;
        }
        return FxBspatchNative.bspatchFile(oldApkFilePath,newApkFilePath, apkPatchFilePath);
    }

    private boolean isFile(String path) {
        File file = new File(path);
        return file.exists();
    }
}
