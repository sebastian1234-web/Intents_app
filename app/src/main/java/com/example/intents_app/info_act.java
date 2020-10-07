package com.example.intents_app;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class info_act extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_act);

        videoView = (VideoView)findViewById(R.id.vd);

        //pasar nuestro video a tarves de la ruta

        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;//Ruta del video

        Uri uri = Uri.parse(ruta);
        videoView. setVideoURI(uri);

        //cotroles de navegacion

        MediaController media = new MediaController(this);
        videoView.setMediaController(media);
    }



}