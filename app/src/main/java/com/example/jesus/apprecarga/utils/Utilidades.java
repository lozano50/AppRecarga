package com.example.jesus.apprecarga.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * Created by jose on 26/07/14.
 */
public class Utilidades extends Activity {

    static EditText et1;

  /*  public static String ValidarUsuario(Activity_main activity_) {

        //capturamos el layout
        View capa = activity_.getLayoutInflater().inflate(R.layout.validar_usuario, null);

        //capturamos la imagen y el campo de texto desde nuestro layout personalizado.
        et1 = (EditText) capa.findViewById(R.id.password);

        AlertDialog.Builder miDialogo = new AlertDialog.Builder(activity_);
        miDialogo.setMessage("Ingresa Codigo");

        //asignamos la vista creada a nuestro diálogo.
        miDialogo.setView(capa);

        //establecemos la instrucción en caso afirmativo
        miDialogo.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nombre = et1.getText().toString();
                Log.println(BIND_WAIVE_PRIORITY, et1.getText().toString(), et1.getText().toString());
                //tv1.setText(nombre);

            }
        });

        //se crea y luego se muestra...
        miDialogo.create();
        miDialogo.show();


        return et1.getText().toString();
    }*/
}
