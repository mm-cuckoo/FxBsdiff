package com.cfox.fxbspandroidapp;

import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.cfox.fxbspatchlib.ApkUtils;
import com.cfox.fxbspatchlib.FxBspatch;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    String basePath = Environment.getExternalStorageDirectory().getPath();
    String patchPath = basePath + "/Apatch/app.patch";
    String apkPath = basePath + "/Apatch/newApp.app";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startBspatch(View view) {
        new ApkUpdateTask().execute();
    }


    class ApkUpdateTask extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {
            try {
                final FxBspatch fxBspatch = new FxBspatch();
                Log.d(TAG, "run: start ......" + patchPath);
                int result = fxBspatch.bspatchFile(MainActivity.this, apkPath,patchPath);
                Log.d(TAG, "run: end ......" + result);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }

            return true;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);

        }
    }
}
