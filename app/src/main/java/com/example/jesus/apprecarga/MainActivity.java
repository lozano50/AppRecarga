package com.example.jesus.apprecarga;

import android.app.AlertDialog;
import android.app.IntentService;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.jesus.apprecarga.bd.MyBDSqlite;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnRecarga;
    private Button btnInforme;
    private Button btnAdministrador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRecarga=(Button)findViewById(R.id.btnRecarga);
        btnInforme=(Button)findViewById(R.id.btnInforme);
        btnAdministrador=(Button)findViewById(R.id.btnAdministrador);

        btnRecarga.setOnClickListener(this);
        btnInforme.setOnClickListener(this);
        btnAdministrador.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnRecarga:

                Intent intCargaProd = new Intent(MainActivity.this,CargarProductos.class);
                startActivity(intCargaProd);

              //  Toast t = Toast.makeText(this,"PRIMERO REALIZE DLC.", Toast.LENGTH_LONG);
                //t.show();
                break;
            case R.id.btnInforme:

                Intent intInfo = new Intent(MainActivity.this,ActInforme.class);
                startActivity(intInfo);
                //this.finish();
                //Toast t2 = Toast.makeText(this,"NO HAY TRANSACCIONES REALIZADAS", Toast.LENGTH_LONG);
                //t2.show();
                break;
            case R.id.btnAdministrador:

                Intent intAdmin = new Intent(MainActivity.this,Configuracion.class);
                startActivity(intAdmin);
                //this.finish();
                break;

        }

    }



    public Button getBtnRecarga() {
        return btnRecarga;
    }

    public void setBtnRecarga(Button btnRecarga) {
        this.btnRecarga = btnRecarga;
    }

    public Button getBtnAdministrador() {
        return btnAdministrador;
    }

    public void setBtnAdministrador(Button btnAdministrador) {
        this.btnAdministrador = btnAdministrador;
    }

    public Button getBtnInforme() {
        return btnInforme;
    }

    public void setBtnInforme(Button btnInforme) {
        this.btnInforme = btnInforme;
    }




}
