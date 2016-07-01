package com.example.jesus.apprecarga;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jesus.apprecarga.bd.MyBDSqlite;

import org.w3c.dom.Text;

/**
 * Created by provar-3 on 24/06/16.
 */
public class Usuario extends AppCompatActivity implements View.OnClickListener{

    EditText etNombreUsuario;
    EditText etCodUsuario;
    EditText etTipoUsuario;
    Button   btnInsertUser;
    Button   btnActUsuario;
    private SQLiteDatabase db;
    MyBDSqlite usdbh;
    TextView tvMsgUsuario;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usuario);

        etNombreUsuario = (EditText) findViewById(R.id.etNombreUsuario);
        etCodUsuario = (EditText) findViewById(R.id.etCodUsuario);
        etTipoUsuario = (EditText) findViewById(R.id.etTipoUsuario);
        btnInsertUser = (Button) findViewById(R.id.btnInsertUser);
        btnActUsuario = (Button) findViewById(R.id.btnActUsuario);
        tvMsgUsuario = (TextView) findViewById(R.id.tvMsgUsuario);

        btnInsertUser.setOnClickListener(this);
        btnActUsuario.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.btnInsertUser:

                usdbh = new MyBDSqlite(this, "DbRecarga.db", null, 4);
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

            case R.id.btnActUsuario:

                usdbh = new MyBDSqlite(this, "DbRecarga.db", null, 4);
                db = usdbh.getWritableDatabase();

                //Alternativa 1: metodo sqlExec()
                /*String sql = "DELETE FROM usuarios";
                db.execSQL(sql);*/

                //Alternativa 1: método rawQuery()
                Cursor c = db.rawQuery("SELECT cod_usuario, nombre FROM usuarios", null);

                //Alternativa 2: método delete()
                //String[] campos = new String[] {"codigo", "nombre"};
                //Cursor c = db.query("Usuarios", campos, null, null, null, null, null);

                //Recorremos los resultados para mostrarlos en pantalla
                tvMsgUsuario.setText("");
                if (c.moveToFirst()) {
                    //Recorremos el cursor hasta que no haya más registros
                    do{

                        tvMsgUsuario.append(" " + c.getString(0) + " - " + c.getString(1) + "\n");

                    } while(c.moveToNext());

                }else{
                    tvMsgUsuario.setText("no hay Registros!!!");
                }

                db.close();

                break;

        }
    }
}
