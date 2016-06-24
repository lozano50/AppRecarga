package com.example.jesus.apprecarga;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by provar-3 on 24/06/16.
 */
public class Usuario extends AppCompatActivity {

    EditText etNombreUsuario;
    EditText etCodUsuario;
    EditText etTipoUsuario;
    Button   btnInsertUser;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usuario);
    }


}
