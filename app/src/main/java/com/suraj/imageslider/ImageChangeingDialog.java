package com.suraj.imageslider;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

public class ImageChangeingDialog extends Dialog {

    int[] imageIdList = new int[10];
    ImageView imgClose, imgChangingImage;
    TimerThread timerThread;

    public ImageChangeingDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.image_changing_dialog);

        initView();
        init();
        setonClick();
        timerThread = new TimerThread();
        timerThread.execute();

    }


    private void initView() {

        imgClose = findViewById(R.id.img_close);
        imgChangingImage = findViewById(R.id.img_Change);

    }

    private void init() {
        imageIdList[0] = R.drawable.img1;
        imageIdList[1] = R.drawable.img2;
        imageIdList[2] = R.drawable.img3;
        imageIdList[3] = R.drawable.img4;
        imageIdList[4] = R.drawable.img5;
        imageIdList[5] = R.drawable.img1;
        imageIdList[6] = R.drawable.img2;
        imageIdList[7] = R.drawable.img3;
        imageIdList[8] = R.drawable.img4;
        imageIdList[9] = R.drawable.img5;
    }

    private void setonClick() {

        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                cancel();
                timerThread.cancel(true);
            }
        });

    }

    class TimerThread extends AsyncTask<Integer, Integer, Integer> {

        int[] arr = new int[1];

        @Override
        protected Integer doInBackground(Integer... integers) {

            runLoop();
            dismiss();

            return null;
        }

        private void runLoop() {
            Log.e("loopRun", "Loop Running");
            for (int i = 0; i < imageIdList.length; i++) {
                try {
                    Thread.sleep(1000);
                    arr[0] = i;
                }
                catch (InterruptedException e) {

                    Log.e("loopRun", "Loop Running " + e);
                    throw new RuntimeException(e);

                }

                publishProgress(i);

            }
            timerThread.cancel(true);
            runLoop();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            imgChangingImage.setImageResource(imageIdList[values[0]]);
        }
    }
}
