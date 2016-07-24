package com.gudong.client;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.gudong.client.androidx.annotation.ViewFinder;
import com.gudong.client.androidx.ui.XActivity;

public class MainActivity extends XActivity {

    @ViewFinder(id = R.id.hello)
    private TextView hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (hello != null) {
            hello.setText("abc");
        } else {
            Toast.makeText(this, "empty", Toast.LENGTH_LONG);
        }
    }
}
