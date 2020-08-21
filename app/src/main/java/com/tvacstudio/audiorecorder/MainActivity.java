package com.tvacstudio.audiorecorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.internal.ContextUtils;
import com.yashwanth.audiorecorder.R;

import java.io.File;
import java.security.AccessController;
import static com.google.android.material.internal.ContextUtils.*;
import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {
    private String authorities ="com.tvacstudio.audiorecorder.fileprovider";
    public File[] allFiles1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
