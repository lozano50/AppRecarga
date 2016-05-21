package com.example.jesus.apprecarga;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

    btnOk.setOnClickListener(this);
    btnCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnOk:
                break;
            case R.id.btnCancel:
               System.exit(1);
               // Intent intentCancel = new Intent(this,Configuracion.class);
                //startActivity(intentCancel);
                break;

        }
    }
}
