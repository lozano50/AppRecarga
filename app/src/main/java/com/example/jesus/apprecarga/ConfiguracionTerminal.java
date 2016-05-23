package com.example.jesus.apprecarga;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by jesus on 14/05/16.
 */
public class ConfiguracionTerminal extends AppCompatActivity implements View.OnClickListener{

    EditText etTerminal;
    EditText etIdcomercio;
    EditText etIp;
    EditText etPuerto;
    Button btnOk;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configuracion_terminal);

    etTerminal = (EditText)findViewById(R.id.etTerminal);
    etIdcomercio = (EditText)findViewById(R.id.etIdcomercio);
    etIp = (EditText)findViewById(R.id.etIp);
    etPuerto = (EditText)findViewById(R.id.etPuerto);
    btnOk = (Button)findViewById(R.id.btnOk);
    btnCancel = (Button)findViewById(R.id.btnCancel);

    SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
    etTerminal.setText(prefs.getString("TERMINAL",""));
    etIdcomercio.setText(prefs.getString("IDCOMERCIO",""));
    etIp.setText(prefs.getString("IP",""));
    etPuerto.setText(prefs.getString("PUERTO",""));



    btnOk.setOnClickListener(this);
    btnCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnOk:
                guardarConfiguracion();
                Toast.makeText(getApplicationContext(), " Registro guardado con exito  ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnCancel:
               System.exit(1);
               // Intent intentCancel = new Intent(this,Configuracion.class);
                //startActivity(intentCancel);
                break;

        }
    }


    public void guardarConfiguracion(){

        SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor Editor = prefs.edit();

        Editor.putString("TERMINAL",etTerminal.getText().toString());
        Editor.putString("IDCOMERCIO",etIdcomercio.getText().toString());
        Editor.putString("IP",etIp.getText().toString());
        Editor.putString("PUERTO", etPuerto.getText().toString());

        Editor.commit();

    }

    public void RecuperarConfiguracion(){

        SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

    }

}
