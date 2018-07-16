package com.cfox.fxjbsdiff;


public class JBsdFiffTestMain {

	public static void main(String[] args) {
		int code = JBsdiff.diffFile("D:\\E_Work_Sp\\JNI\\app-releaseA.apk", 
				"D:\\E_Work_Sp\\JNI\\app-releaseB.apk", 
				"D:\\E_Work_Sp\\JNI\\apk.patch");
		System.out.println(code);
	}

}
