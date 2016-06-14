package com.example.jesus.apprecarga;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by provar-3 on 10/06/16.
 */
public class ActInforme extends AppCompatActivity implements View.OnClickListener{

    Button btnUltRecarga;
    Button btnConSaldo;
    Button btnCerrarSesion;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_informe);

        btnUltRecarga   = (Button)findViewById(R.id.btnUltRecarga);
        btnConSaldo     = (Button)findViewById(R.id.btnConSaldo);
        btnCerrarSesion = (Button)findViewById(R.id.btnCerrarSesion);

        btnConSaldo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnUltRecarga:
                break;
            case R.id.btnConSaldo:

                Intent transactionTcp = new Intent(ActInforme.this,TransactionTCP.class);
                startService(transactionTcp);

                break;
            case R.id.btnCerrarSesion:
                break;

        }

    }
}
