# Media Player

> Design basic music player application to demonstrate services in android.

- Create a new project in **Android Studio** named **Media Player** (name should me absolute because in `MainActivity.java` the imported package name is **mediaplayer**)
- Add the below `XML` code in `activity_main.xml` of your project.

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <!-- ImageView to display a thumbnail image -->
    <ImageView
        android:id="@+id/thumbnail"
        android:layout_width="354dp"
        android:layout_height="193dp"
        android:layout_marginTop="124dp"
        app:layout_constraintBottom_toBottomOf="@+id/seekBar"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.491"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        android:src="@drawable/music" />

    <!-- SeekBar to control the progress -->
    <SeekBar
        android:id="@+id/seekBar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="16dp"
        android:max="100"
        android:progress="0"
        app:layout_constraintBottom_toTopOf="@+id/playButton"
        tools:layout_editor_absoluteX="16dp" />

    <!-- Button to play the music -->
    <Button
        android:id="@+id/playButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="288dp"
        android:text="Play"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.498"
        app:layout_constraintStart_toStartOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>

```

- Now add the below `Java` code in `MainActivity.java` of your project.

```java
package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_PERMISSION_READ_EXTERNAL_STORAGE = 1;
    private Button playButton;
    private SeekBar seekBar;
    private MediaPlayer mediaPlayer;

    private boolean isPlaying = false;
    private Handler mHandler;
    private Runnable mUpdateSeekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Check for permission to read external storage
        if (
                ContextCompat.checkSelfPermission(
                        this,
                        android.Manifest.permission.READ_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},
                    REQUEST_PERMISSION_READ_EXTERNAL_STORAGE
            );
        }

        // Construct the path to your music file
        File downloadsFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        String musicFileName = "UndergroundAcademy.mp3";
        File musicFile = new File(downloadsFolder, musicFileName);

        //Create media player
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(musicFile.getAbsolutePath());
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Handle seekbar progress
        seekBar = findViewById(R.id.seekBar);
        mHandler = new Handler();
        mUpdateSeekbar = new Runnable() {
            @Override
            public void run() {
                if(mediaPlayer != null){
                    int currentPosition = mediaPlayer.getCurrentPosition();
                    int totalDuration = mediaPlayer.getDuration();
                    seekBar.setProgress(currentPosition * 100 / totalDuration);
                    mHandler.postDelayed(this, 1000);
                }
            }
        };

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    int newPosition = mediaPlayer.getDuration() * progress / 100;
                    mediaPlayer.seekTo(newPosition);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Pause the audio when user starts seeking
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Resume audio playback when user stops seeking
                mediaPlayer.start();
            }
        });


        //Setup playback button
        playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPlaying){
                    mediaPlayer.pause();
                    playButton.setText("Play");
                    //remove the callbacks to the Runnable when the MediaPlayer stops
                    mHandler.removeCallbacks(mUpdateSeekbar);
                }else{
                    mediaPlayer.start();
                    playButton.setText("Pause");
                    //start the Runnable when the MediaPlayer starts playing
                    mHandler.postDelayed(mUpdateSeekbar, 1000);
                }
                isPlaying = !isPlaying;
            }
        });

    }
    //Release the MediaPlayer resources when the activity is destroyed
    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            mHandler.removeCallbacks(mUpdateSeekbar);
        }
    }
}

```

That's it now save the both files and run the app!

> **Note** :make sure to check the package name in java file `package com.example.mediaplayer;` if you got another name other than `mediaplayer` make sure to replace the first line of the code with yours.

---
