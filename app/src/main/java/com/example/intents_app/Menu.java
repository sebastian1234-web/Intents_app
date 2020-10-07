package com.example.intents_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Menu extends AppCompatActivity {
    private TextView text;
    private ProgressBar progress;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        text = (TextView)findViewById(R.id.tv);

        //recibo dato
        String dato = getIntent().getStringExtra("mensaje");

        text.setText(dato);

        progress = (ProgressBar)findViewById(R.id.pb);

        progress.setVisibility(View.INVISIBLE);

        btn = (Button)findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                new Task().execute();
            }

        });


    }
    public void Marcar(View v)
    {
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + "950221476"));
        startActivity(i);
    }
    public void Web(View v)
    {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://saludprev.com/reloj-tensiometro/"));
        startActivity(i);
    }
    class Task extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            for(int i = 1; i<10; i++)
            {
                try
                {
                    Thread.sleep(2000);
                }

                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }

            return null;
        }

        protected void onPreExecute(){

            progress.setVisibility(View.VISIBLE);
        }

        protected void onPostExecute(String s){
            Intent i = new Intent(getBaseContext(), Imagenes.class);
            startActivity(i);
        }

    }

}