package com.example.intents_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txt, txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (EditText)findViewById(R.id.txt);
        txt2 = (EditText)findViewById(R.id.txt2);
    }

    public void Iniciar(View v)
    {
        String nombre = txt.getText().toString();
        String contraseña = txt2.getText().toString();

        if(nombre.equalsIgnoreCase("android") && contraseña.equalsIgnoreCase("123"))
        {
            Intent i = new Intent(this, Menu.class);

            String user = txt.getText().toString();
            //envio dato
            i.putExtra("mensaje","Bienvenido estimado: " + user);
            startActivity(i);
            finish();
        }else if(nombre.equalsIgnoreCase("Android") && contraseña.equalsIgnoreCase("123"))
        {
            Intent i = new Intent(this, Menu.class);

            String user = txt.getText().toString();
            //envio dato
            i.putExtra("mensaje","Bienvenido estimado: " + user);
            startActivity(i);
            finish();
        }else{

            Toast.makeText(this, "Login incorrecto", Toast.LENGTH_SHORT).show();
        }


    }
}