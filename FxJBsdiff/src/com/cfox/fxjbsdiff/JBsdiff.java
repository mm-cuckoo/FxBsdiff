package com.cfox.fxjbsdiff;

public class JBsdiff {
	public native static int diffFile(String oldFilePath, 
			String newFilePath, 
			String patchFilePath);
	
	static {
		System.loadLibrary("libBsdiffLib");
	}
}
