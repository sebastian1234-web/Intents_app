package com.example.intents_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;

import Clases.Planes;

public class Clientes extends AppCompatActivity {

        private Spinner spin1, spin2;
        private TextView text;
        private EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);
        spin1= (Spinner)findViewById(R.id.spinClientes);
        spin2= (Spinner)findViewById(R.id.spinPlanes);
        text= (TextView)findViewById(R.id.tv);
        edit= (EditText)findViewById(R.id.et1);

        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaClientes");
        ArrayList<String> listaPlanes = (ArrayList<String>) getIntent().getSerializableExtra("listaPlanes");

        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listaClientes);
        ArrayAdapter<String> adapt1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listaPlanes);

        spin1.setAdapter(adapt);
        spin2.setAdapter(adapt1);
    }

    public void Calcular(View v)
    {
        Planes pl = new Planes();
        String cliente = spin1.getSelectedItem().toString();
        String plan = spin2.getSelectedItem().toString();

        int saldo = Integer.parseInt(edit.getText().toString());

        int resultNormal = saldo - pl.getNormal();
        int resultPremium = saldo - pl.getPremium();



        if(cliente.equals("Roberto") && plan.equals("Normal"))
        {
            text.setText("El valor Normal: " + resultNormal);
        }
        if(cliente.equals("Roberto") && plan.equals("Premium"))
        {
            text.setText("El valor Normal: " + resultPremium);
        }
    }
}