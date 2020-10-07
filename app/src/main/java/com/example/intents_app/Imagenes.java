package com.example.intents_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class Imagenes extends AppCompatActivity {
    private ViewFlipper vf;
    private int[] images = {R.drawable.a, R.drawable.b, R.drawable.c};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagenes);
        vf = (ViewFlipper)findViewById(R.id.slider);

        for(int i = 0; i< images.length; i++)
        {
            flip_image(images[i]);
        }
    }

    public void flip_image(int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        vf.addView(view);
        vf.setFlipInterval(2200);
        vf.setAutoStart(true);

        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);


    }

    public void Maps(View v)
    {
        Intent i = new Intent (this, Maps.class);
        startActivity(i);
    }
    public void info(View v)
    {
        Intent i = new Intent (this, info_act.class);
        startActivity(i);
    }
    public void Usuario(View v)
    {
        ArrayList<String> listaClientes = new ArrayList<String>();
        ArrayList<String> listaPlanes = new ArrayList<String>();

        listaClientes.add("Roberto");
        listaClientes.add("Sebastian");

        listaPlanes.add("Normal");
        listaPlanes.add("Premium");

        Intent i = new Intent (this, Clientes.class);
        i.putExtra("listaClientes", listaClientes);
        i.putExtra("listaPlanes", listaPlanes);

        startActivity(i);
    }
}