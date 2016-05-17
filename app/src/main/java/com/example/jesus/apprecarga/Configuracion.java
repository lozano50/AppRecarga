package com.example.jesus.apprecarga;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jesus.apprecarga.utils.Constantes;

/**
 * Created by jesus on 10/05/16.
 */
public class Configuracion extends AppCompatActivity implements View.OnClickListener{


    Button btnConfig;
    Button btnDonwloadConfig;
    Button btnUsuario;
    Button btnFormatear;
    private Button password;
    TextView et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configuracion);

        btnConfig         = (Button)findViewById(R.id.btnConfig);
        btnDonwloadConfig = (Button)findViewById(R.id.btnDonwloadConfig);
        btnUsuario        = (Button)findViewById(R.id.btnUsuario);
        btnFormatear      = (Button)findViewById(R.id.btnFormatear);

        btnConfig.setOnClickListener(this);
        btnDonwloadConfig.setOnClickListener(this);
        btnUsuario.setOnClickListener(this);
        btnFormatear.setOnClickListener(this);


    }


    /*public void validarUsuario(){

      View v = this.getLayoutInflater().inflate(R.layout.validar_usuario, null);

      etPassword = (EditText)findViewById(R.id.password);

      AlertDialog.Builder miDialogo = new AlertDialog.Builder(this);
      miDialogo.setMessage("Ingrese Codigo");

      miDialogo.setView(v);

        //establecemos la instrucción en caso afirmativo
        miDialogo.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String pass = etPassword.getText().toString();
                // Log.println(BIND_WAIVE_PRIORITY, et1.getText().toString(), et1.getText().toString());

                //  getTextViewResult().setText(nombre);

                if ( !pass.equals("123456") ) {
                    Toast.makeText(getApplicationContext(), " CLAVE INCORRECTA ", Toast.LENGTH_SHORT).show();
                    return;
                }


                Toast.makeText(getApplicationContext(), " CLAVE CORRECTA!!! ", Toast.LENGTH_SHORT).show();
                return;
               // Intent intentUno = new Intent("com.example.jesus.apprecarga.Configuracion");
                //Bundle bolsa = new Bundle();
                //bolsa.putString("nombreKey",nombre);
                //intentUno.putExtras(bolsa);
                //startActivity(intentUno);


            }
        });

        //se crea y luego se muestra...
        miDialogo.create();
        miDialogo.show();


    }*/



    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnConfig:
                ValidarUsuario_();
                break;
            case R.id.btnDonwloadConfig:
                break;
            case R.id.btnUsuario:
                break;
            case R.id.btnFormatear:
                break;


        }

    }


    public Button getPassword() {
        return password;
    }

    public void setPassword(Button password) {
        this.password = password;
    }

    public void ValidarUsuario_() {

        //capturamos el layout
        View capa = this.getLayoutInflater().inflate(R.layout.validar_usuario, null);

        //capturamos la imagen y el campo de texto desde nuestro layout personalizado.
        et1 = (EditText) capa.findViewById(R.id.password);

        AlertDialog.Builder miDialogo = new AlertDialog.Builder(this);
        miDialogo.setMessage("Ingresa Codigo");

        //asignamos la vista creada a nuestro diálogo.
        miDialogo.setView(capa);

        //establecemos la instrucción en caso afirmativo
        miDialogo.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nombre = et1.getText().toString();
                // Log.println(BIND_WAIVE_PRIORITY, et1.getText().toString(), et1.getText().toString());

                //  getTextViewResult().setText(nombre);
                if (nombre.length() > 0 ) {


                    if (!nombre.equals(Constantes.PASS_CONFIG)) {
                        Toast.makeText(getApplicationContext(), " CLAVE INCORRECTA ", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    Intent intentConfigTerminal = new Intent("com.example.jesus.apprecarga.ConfiguracionTerminal");
                    //Bundle bolsa = new Bundle();
                    //bolsa.putString("nombreKey",nombre);
                    //intentUno.putExtras(bolsa);
                    startActivity(intentConfigTerminal);
                    return;


                } else {
                    Toast.makeText(getApplicationContext(), " Ingrese el password ", Toast.LENGTH_SHORT).show();


                }


            }
        });

        //se crea y luego se muestra...
        miDialogo.create();
        miDialogo.show();

    }





}
