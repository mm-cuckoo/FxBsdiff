package com.cfox.fxbspatchlib;


public class FxBspatchNative {

    static {
        System.loadLibrary("fxbspatch-lib");
    }

    public native static int bspatchFile(String oldFilePath, String newFilePath, String patchFilePath);
}
