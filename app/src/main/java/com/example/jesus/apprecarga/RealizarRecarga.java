package com.example.jesus.apprecarga;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by provar-3 on 18/07/16.
 */
public class RealizarRecarga extends AppCompatActivity implements View.OnClickListener{

    Button btnEnviarRecarga;
    EditText etIngNum;
    EditText etIngValor;
    int provee;
    int prod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.realizar_recarga);

        btnEnviarRecarga = (Button) findViewById(R.id.btnEnviarRecarga);
        etIngNum = (EditText) findViewById(R.id.etIngNum);
        etIngValor = (EditText) findViewById(R.id.etIngValor);

        provee = getIntent().getIntExtra("proveedor",0);
        prod = getIntent().getIntExtra("producto",0);

        btnEnviarRecarga.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        System.out.println(" codigo proveedor  = " + provee);
        System.out.println(" codigo producto   = " + prod);
        System.out.println(" numero de celular = " + etIngNum.getText().toString());
        System.out.println(" monto de recarga  = " + etIngValor.getText().toString());


        Intent transactionTcp = new Intent(RealizarRecarga.this, TransactionTCP.class);
        transactionTcp.setData(Uri.parse("2|90909090|101010"+"|"+etIngNum.getText().toString()+"|"+etIngValor.getText().toString()));
        startService(transactionTcp);




    }

}
