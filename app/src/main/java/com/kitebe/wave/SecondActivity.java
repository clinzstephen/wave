package com.kitebe.wave;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity {

    MediaPlayer mediaPlayer1,mediaPlayer2,mediaPlayer3,mediaPlayer4,mediaPlayer5;
    SeekBar volumeSeekBar1,volumeSeekBar2,volumeSeekBar3,volumeSeekBar4,volumeSeekBar5;
    float log1,log2,log3,log4,log5, newvolume,newvolume2,newvolume3,newvolume4,newvolume5;
    int progress1,progress2,progress3,progress4,progress5;
    //saveMusic button
    Button saveMusic1,saveMusic2,saveMusic3,saveMusic4,saveMusic5,playList1,playList2,playList3,saveAll;
    boolean saveOption = false,saveOption2 = false,saveOption3 = false,saveOption4 = false,saveOption5 = false, sharedPreferenceValueBoolean=false;
    float currentVolume,currentVolume2,currentVolume3,currentVolume4,currentVolume5;
    SharedPreferences sharedpreferences;
    int getSharedPreferenceValue,getSharedPreferenceValue2,getSharedPreferenceValue3,getSharedPreferenceValue4,getSharedPreferenceValue5;
    ImageView birdImage,thunderImage,rainImage,riverImage,leafImage;

    //    AudioManager audioManager1,audioManager2,audioManager3;
    int min1 = 0, max1 = 10, current1 = 5,
            min2 = 0, max2 = 10, current2 = 5,
            min3 = 0, max3 = 10, current3 = 5;

    public static final String MyPREFERENCES = "MyPrefs" ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mediaPlayer1 = MediaPlayer.create(this, R.raw.song1);

        mediaPlayer2 = MediaPlayer.create(this, R.raw.song2);
//        mediaPlayer2.start();
        mediaPlayer3 = MediaPlayer.create(this, R.raw.song3);
//        mediaPlayer3.start();
        mediaPlayer4 = MediaPlayer.create(this, R.raw.song4);
        mediaPlayer5 = MediaPlayer.create(this, R.raw.song5);


        volumeSeekBar1 = findViewById(R.id.volumSeekBar1);
//        mediaPlayer1.setVolume(3,3);
//        volumeSeekBar1.setProgress(5);

        volumeSeekBar2 = findViewById(R.id.volumSeekBar2);
//       volumeSeekBar2.setProgress(max2 - min2);
//       volumeSeekBar2.setProgress(current2 - min2);

        volumeSeekBar3 = findViewById(R.id.volumeSeekBar3);
//        volumeSeekBar3.setProgress(max3 - min3);
        volumeSeekBar4 = findViewById(R.id.volumeSeekBar4);
        volumeSeekBar5 = findViewById(R.id.volumeSeekBar5);



        //saveMusic button
        saveMusic1 = findViewById(R.id.saveMusic1);
        saveMusic2 = findViewById(R.id.saveMusic2);
        saveMusic3 = findViewById(R.id.saveMusic3);
        saveMusic4 = findViewById(R.id.saveMusic4);
        saveMusic5 = findViewById(R.id.saveMusic5);
        saveAll = findViewById(R.id.saveAll);

        //playlist
        playList1 = findViewById(R.id.playList1);
        playList2 = findViewById(R.id.playList2);
        playList3 = findViewById(R.id.playList3);


        //images
        birdImage = findViewById(R.id.birdImage);
        thunderImage = findViewById(R.id.thunderImage);
        rainImage = findViewById(R.id.rainImage);
        riverImage = findViewById(R.id.riverImage);
        leafImage = findViewById(R.id.leafImage);

        try {
            sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

            getSharedPreferenceValue = sharedpreferences.getInt("currentProgress", 10);

            Log.i("channel", String.valueOf(getSharedPreferenceValue));
        }catch (Exception e){
            Log.d("Error",e.toString());
        }
        try {

            getSharedPreferenceValue2 = sharedpreferences.getInt("currentProgress2", 10);

            Log.i("channel2", String.valueOf(getSharedPreferenceValue2));
        }catch (Exception e){
            Log.d("Error2",e.toString());
        }
        try {

            getSharedPreferenceValue3 = sharedpreferences.getInt("currentProgress3", 10);

            Log.i("channel3", String.valueOf(getSharedPreferenceValue3));
        }catch (Exception e){
            Log.d("Error3",e.toString());
        }
        try {

            getSharedPreferenceValue4 = sharedpreferences.getInt("currentProgress4", 10);

            Log.i("channel4", String.valueOf(getSharedPreferenceValue4));
        }catch (Exception e){
            Log.d("Error4",e.toString());
        }

        try {

            getSharedPreferenceValue5 = sharedpreferences.getInt("currentProgress5", 10);

            Log.i("channel5", String.valueOf(getSharedPreferenceValue5));
        }catch (Exception e){
            Log.d("Error5",e.toString());
        }


        if (getSharedPreferenceValue!=0) {
            mediaPlayer1.start();

            volumeSeekBar1.setProgress(getSharedPreferenceValue);
            newvolume = (float) (Math.log(100 - (getSharedPreferenceValue-1)) / Math.log(100));

            mediaPlayer1.setVolume(1-newvolume,1-newvolume);
            Log.i("sharedvalueinstarting",String.valueOf(newvolume));

        }

        if (getSharedPreferenceValue2!=0) {
            mediaPlayer2.start();
//                mediaPlayer1.setVolume(1 - getSharedPreferenceValue, 1 - getSharedPreferenceValue);

//               volumeSeekBar1.setProgress(Integer.parseInt(getSharedPreferenceValue.toString()));
            volumeSeekBar2.setProgress(getSharedPreferenceValue2);
            newvolume2 = (float) (Math.log(100 - (getSharedPreferenceValue2-1)) / Math.log(100));

            mediaPlayer2.setVolume(1-newvolume2,1-newvolume2);
            Log.i("sharedvalueinstarting2",String.valueOf(newvolume2));

        }
        if (getSharedPreferenceValue3!=0) {
            mediaPlayer3.start();
//                mediaPlayer1.setVolume(1 - getSharedPreferenceValue, 1 - getSharedPreferenceValue);

//               volumeSeekBar1.setProgress(Integer.parseInt(getSharedPreferenceValue.toString()));
            volumeSeekBar3.setProgress(getSharedPreferenceValue3);
            newvolume3 = (float) (Math.log(100 - (getSharedPreferenceValue3-1)) / Math.log(100));

            mediaPlayer3.setVolume(1-newvolume3,1-newvolume3);
            Log.i("sharedvalueinstarting3",String.valueOf(newvolume3));

        }
        if (getSharedPreferenceValue4!=0) {
            mediaPlayer4.start();
//                mediaPlayer1.setVolume(1 - getSharedPreferenceValue, 1 - getSharedPreferenceValue);

//               volumeSeekBar1.setProgress(Integer.parseInt(getSharedPreferenceValue.toString()));
            volumeSeekBar4.setProgress(getSharedPreferenceValue4);
            newvolume4 = (float) (Math.log(100 - (getSharedPreferenceValue4-1)) / Math.log(100));

            mediaPlayer4.setVolume(1-newvolume4,1-newvolume4);
            Log.i("sharedvalueinstarting4",String.valueOf(newvolume4));

        }
        if (getSharedPreferenceValue5!=0) {
            mediaPlayer5.start();
//                mediaPlayer1.setVolume(1 - getSharedPreferenceValue, 1 - getSharedPreferenceValue);

//               volumeSeekBar1.setProgress(Integer.parseInt(getSharedPreferenceValue.toString()));
            volumeSeekBar5.setProgress(getSharedPreferenceValue5);
            newvolume5 = (float) (Math.log(100 - (getSharedPreferenceValue5-1)) / Math.log(100));

            mediaPlayer5.setVolume(1-newvolume5,1-newvolume5);
            Log.i("sharedvalueinstarting5",String.valueOf(newvolume5));

        }

//        volumeSeekBar3.setProgress(current3 - min3);
//        audioManager1 = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
//        audioManager2 = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
//        audioManager3 = (AudioManager) getSystemService(Context.AUDIO_SERVICE);



        volumeSeekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar volumeSeekBar, final int progress, boolean fromUser) {

                if (saveOption) {
//                   final float log1 = (float) (Math.log(50-progress)/Math.log(50));

                    mediaPlayer1.start();
                    mediaPlayer1.setVolume(1-currentVolume,1-currentVolume);
                    mediaPlayer1.setLooping(true);
                    Log.i("volume", String.valueOf(currentVolume));
                    volumeSeekBar1.setProgress(progress1);


                }
                else {
                    progress1=progress;
                    Log.i("progress", String.valueOf(progress1));
                    log1 = (float) (Math.log(100 - (progress1-1)) / Math.log(100));
                    volumeSeekBar1.setProgress(progress1);
                    mediaPlayer1.start();
                    mediaPlayer1.setVolume(1 - log1, 1 - log1);
                    mediaPlayer1.setLooping(true);
                    Log.i("logvalue", String.valueOf(log1));
                    saveMusic1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(saveOption){
                                log1 = (float) (Math.log(100 - (progress1-1)) / Math.log(100));

                                currentVolume = log1;
                                mediaPlayer1.setLooping(true);
                                sharedPreferenceValueBoolean=true;
                                saveOption=false;

                            }
                            else {
                                log1 = (float) (Math.log(100 - (progress1-1)) / Math.log(100));

                                currentVolume = log1;
                                mediaPlayer1.start();
                                mediaPlayer1.setVolume(1 - currentVolume, 1 - currentVolume);
                                mediaPlayer1.setLooping(true);
                                saveOption=true;

                                SharedPreferences.Editor editor = sharedpreferences.edit();
                                editor.putInt("currentProgress", progress1);
                                editor.apply();

                                Log.i("editorValue", String.valueOf(sharedpreferences.getInt("currentProgress",10)));
                                Log.i("currentvolumetesting", String.valueOf(currentVolume));

                            }
                        }
                    });
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar volumeSeekBar1) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar volumeSeekBar1) {

            }
        });



        volumeSeekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar volumeSeekBar, final int progress, boolean fromUser) {
                if (saveOption2) {
//                   final float log1 = (float) (Math.log(50-progress)/Math.log(50));

                    mediaPlayer2.start();
                    mediaPlayer2.setVolume(1-currentVolume2,1-currentVolume2);
                    mediaPlayer2.setLooping(true);
                    Log.i("volume", String.valueOf(currentVolume2));
                    volumeSeekBar2.setProgress(progress2);


                }
                else {
                    progress2=progress;
                    Log.i("progress2", String.valueOf(progress2));
                    log2 = (float) (Math.log(100 - (progress2-1)) / Math.log(100));

                    mediaPlayer2.start();
                    mediaPlayer2.setVolume(1 - log2, 1 - log2);
                    mediaPlayer2.setLooping(true);
                    Log.i("logvalue2", String.valueOf(log2));
                    //saveButton
                    saveMusic2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(saveOption2){
                                log2 = (float) (Math.log(100 - (progress2-1)) / Math.log(100));
                                currentVolume2 = log2;
                                mediaPlayer2.setLooping(true);
                                saveOption2=false;

                            }
                            else {
                                log2 = (float) (Math.log(100 - (progress2-1)) / Math.log(100));

                                currentVolume2 = log2;
                                mediaPlayer2.start();
                                mediaPlayer2.setVolume(1 - currentVolume2, 1 - currentVolume2);
                                mediaPlayer2.setLooping(true);
                                saveOption2=true;

                                SharedPreferences.Editor editor = sharedpreferences.edit();
                                editor.putInt("currentProgress2", progress2);
                                editor.apply();

                                Log.i("editorValue2", String.valueOf(sharedpreferences.getInt("currentProgress2",10)));
                                Log.i("currentvolumetesting2", String.valueOf(currentVolume2));

                            }
                        }
                    });
                }


            }

            @Override
            public void onStartTrackingTouch(SeekBar volumeSeekBar2) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar volumeSeekBar2) {


            }
        });

        volumeSeekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar volumeSeekBar3, int progress, boolean fromUser) {
                if (saveOption3) {
//                   final float log1 = (float) (Math.log(50-progress)/Math.log(50));

                    mediaPlayer3.start();
                    mediaPlayer3.setVolume(1-currentVolume3,1-currentVolume3);
                    mediaPlayer3.setLooping(true);
                    Log.i("volume", String.valueOf(currentVolume3));
                    volumeSeekBar3.setProgress(progress3);




                }
                else {
                    progress3=progress;
                    Log.i("progress3", String.valueOf(progress3));
                    log3 = (float) (Math.log(100 - (progress3-1)) / Math.log(100));

                    mediaPlayer3.start();
                    mediaPlayer3.setVolume(1 - log3, 1 - log3);
                    mediaPlayer3.setLooping(true);
                    Log.i("logvalue3", String.valueOf(log3));
                    //saveButton
                    saveMusic3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(saveOption3){
                                log3 = (float) (Math.log(100 - (progress2-1)) / Math.log(100));
                                currentVolume3 = log3;
                                mediaPlayer3.setLooping(true);
                                saveOption3=false;

                            }
                            else {
                                log3 = (float) (Math.log(100 - (progress3-1)) / Math.log(100));

                                currentVolume3 = log3;
                                mediaPlayer3.start();
                                mediaPlayer3.setVolume(1 - currentVolume3, 1 - currentVolume3);
                                mediaPlayer3.setLooping(true);
                                saveOption3=true;

                                SharedPreferences.Editor editor = sharedpreferences.edit();
                                editor.putInt("currentProgress3", progress3);
                                editor.apply();

                                Log.i("editorValue3", String.valueOf(sharedpreferences.getInt("currentProgress3",10)));
                                Log.i("currentvolumetesting3", String.valueOf(currentVolume3));

                            }
                        }
                    });
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar volumeSeekBar3) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar volumeSeekBar3) {

            }
        });

        volumeSeekBar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar volumeSeekBar, final int progress, boolean fromUser) {
                if (saveOption4) {
//                   final float log1 = (float) (Math.log(50-progress)/Math.log(50));

                    mediaPlayer4.start();
                    mediaPlayer4.setVolume(1-currentVolume4,1-currentVolume4);
                    mediaPlayer4.setLooping(true);
                    Log.i("volume", String.valueOf(currentVolume4));
                    volumeSeekBar4.setProgress(progress4);


                }
                else {
                    progress4=progress;
                    Log.i("progress4", String.valueOf(progress4));
                    log4 = (float) (Math.log(100 - (progress4-1)) / Math.log(100));

                    mediaPlayer4.start();
                    mediaPlayer4.setVolume(1 - log4, 1 - log4);
                    mediaPlayer4.setLooping(true);
                    Log.i("logvalue4", String.valueOf(log4));
                    //saveButton
                    saveMusic4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(saveOption4){
                                log4 = (float) (Math.log(100 - (progress4-1)) / Math.log(100));
                                currentVolume4 = log4;
                                mediaPlayer4.setLooping(true);
                                saveOption4=false;

                            }
                            else {
                                log4 = (float) (Math.log(100 - (progress4-1)) / Math.log(100));

                                currentVolume4 = log4;
                                mediaPlayer4.start();
                                mediaPlayer4.setVolume(1 - currentVolume4, 1 - currentVolume4);
                                mediaPlayer4.setLooping(true);
                                saveOption4=true;

                                SharedPreferences.Editor editor = sharedpreferences.edit();
                                editor.putInt("currentProgress4", progress4);
                                editor.apply();

                                Log.i("editorValue4", String.valueOf(sharedpreferences.getInt("currentProgress4",10)));
                                Log.i("currentvolumetesting4", String.valueOf(currentVolume4));

                            }
                        }
                    });
                }


            }

            @Override
            public void onStartTrackingTouch(SeekBar volumeSeekBar2) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar volumeSeekBar2) {


            }
        });

        volumeSeekBar5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar volumeSeekBar, final int progress, boolean fromUser) {
                if (saveOption5) {
//                   final float log1 = (float) (Math.log(50-progress)/Math.log(50));

                    mediaPlayer5.start();
                    mediaPlayer5.setVolume(1-currentVolume5,1-currentVolume5);
                    mediaPlayer5.setLooping(true);
                    Log.i("volume5", String.valueOf(currentVolume5));
                    volumeSeekBar5.setProgress(progress5);


                }
                else {
                    progress5=progress;
                    Log.i("progress5", String.valueOf(progress5));
                    log5 = (float) (Math.log(100 - (progress5-1)) / Math.log(100));

                    mediaPlayer5.start();
                    mediaPlayer5.setVolume(1 - log5, 1 - log5);
                    mediaPlayer5.setLooping(true);
                    Log.i("logvalue5", String.valueOf(log5));
                    //saveButton
                    saveMusic5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(saveOption5){
                                log5 = (float) (Math.log(100 - (progress5-1)) / Math.log(100));
                                currentVolume5 = log5;
                                mediaPlayer5.setLooping(true);
                                saveOption5=false;

                            }
                            else {
                                log5 = (float) (Math.log(100 - (progress5-1)) / Math.log(100));

                                currentVolume5 = log5;
                                mediaPlayer5.start();
                                mediaPlayer5.setVolume(1 - currentVolume5, 1 - currentVolume5);
                                mediaPlayer5.setLooping(true);
                                saveOption5=true;

                                SharedPreferences.Editor editor = sharedpreferences.edit();
                                editor.putInt("currentProgress5", progress5);
                                editor.apply();

                                Log.i("editorValue5", String.valueOf(sharedpreferences.getInt("currentProgress5",10)));
                                Log.i("currentvolumetesting5", String.valueOf(currentVolume5));

                            }
                        }
                    });
                }


            }

            @Override
            public void onStartTrackingTouch(SeekBar volumeSeekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar volumeSeekBar) {


            }
        });

        saveAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putInt("currentProgress", progress1);
                editor.putInt("currentProgress2", progress2);
                editor.putInt("currentProgress3", progress3);
                editor.putInt("currentProgress4", progress4);
                editor.putInt("currentProgress5", progress5);
                editor.apply();

            }
        });

        playList1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volumeSeekBar1.setProgress(80);
                volumeSeekBar2.setProgress(50);
                volumeSeekBar3.setProgress(60);
                volumeSeekBar4.setProgress(40);
                volumeSeekBar5.setProgress(75);

            }
        });

        playList2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volumeSeekBar1.setProgress(40);
                volumeSeekBar2.setProgress(80);
                volumeSeekBar3.setProgress(20);
                volumeSeekBar4.setProgress(80);
                volumeSeekBar5.setProgress(45);

            }
        });

        playList3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volumeSeekBar1.setProgress(60);
                volumeSeekBar2.setProgress(30);
                volumeSeekBar3.setProgress(50);
                volumeSeekBar4.setProgress(75);
                volumeSeekBar5.setProgress(85);

            }
        });

    }


    public void onBackPressed() {
        super.onBackPressed();
        mediaPlayer1.stop();
        mediaPlayer2.stop();
        mediaPlayer3.stop();
        mediaPlayer4.stop();
        mediaPlayer5.stop();
    }
    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer1.stop();
        mediaPlayer2.stop();
        mediaPlayer3.stop();
        mediaPlayer4.stop();
        mediaPlayer5.stop();
    }
}
