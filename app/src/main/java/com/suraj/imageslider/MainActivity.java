package com.suraj.imageslider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnOpenDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {

        btnOpenDialog = findViewById(R.id.btnOpenDialog);
        btnOpenDialog.setOnClickListener(new onClick());

    }

    class onClick implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            ImageChangeingDialog imageChangeingDialog = new ImageChangeingDialog(MainActivity.this);

            imageChangeingDialog.show();

        }
    }
}