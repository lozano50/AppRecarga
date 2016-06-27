package com.example.jesus.apprecarga;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jesus.apprecarga.bd.MyBDSqlite;

/**
 * Created by provar-3 on 24/06/16.
 */
public class Usuario extends AppCompatActivity implements View.OnClickListener{

    EditText etNombreUsuario;
    EditText etCodUsuario;
    EditText etTipoUsuario;
    Button   btnInsertUser;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usuario);

        etNombreUsuario = (EditText) findViewById(R.id.etNombreUsuario);
        etCodUsuario = (EditText) findViewById(R.id.etCodUsuario);
        etTipoUsuario = (EditText) findViewById(R.id.etTipoUsuario);
        btnInsertUser = (Button) findViewById(R.id.btnInsertUser);

        btnInsertUser.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.btnInsertUser:

                MyBDSqlite usdbh = new MyBDSqlite(this, "DbRecarga.db", null, 1);
                db = usdbh.getWritableDatabase();

                String nombre = etNombreUsuario.getText().toString();
                int codUsuario = Integer.parseInt(etCodUsuario.getText().toString());
                int tipoUser   = Integer.parseInt(etTipoUsuario.getText().toString());

                //Alternativa 1: método sqlExec()
                //String sql = "INSERT INTO usuarios (nombre,cod_usuario,tipo_usuario) VALUES ('" + nombre + "','" + nom + "') ";
                //db.execSQL(sql);


                //Alternativa 2: método insert()
                ContentValues nuevoRegistro = new ContentValues();
                nuevoRegistro.put("nombre", nombre);
                nuevoRegistro.put("cod_usuario", codUsuario);
                nuevoRegistro.put("tipo_usuario", tipoUser);
                db.insert("usuarios", null, nuevoRegistro);
                db.close();

                break;
        }

    }
}
