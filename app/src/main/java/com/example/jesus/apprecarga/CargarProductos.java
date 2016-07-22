package com.example.jesus.apprecarga;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.jesus.apprecarga.bd.MyBDSqlite;

import java.util.ArrayList;

/**
 * Created by jesus on 17/07/16.
 */
public class CargarProductos  extends AppCompatActivity {

    LinearLayout contenedor;
    int i = 0;
    /*variables para insertar en la base de datos de sqlite*/
    private SQLiteDatabase db;
    MyBDSqlite usdbh;
    Button cb2;
    ArrayList<check> lista2 = new ArrayList<check>();
    ArrayList<check> lista = new ArrayList<check>();

    /*variables de pruebas*/
    int proveedor = 0;
    int producto = 0;
    /*variables de pruebas*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cargar_productos);

        contenedor = (LinearLayout)findViewById(R.id.contenedor);

        usdbh = new MyBDSqlite(this, "DbRecarga.db", null, 6);
        db = usdbh.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM tabla_producto_aux", null);

        if (c.moveToFirst()) {

           do {

               String cod = c.getString(1);
               String nom = c.getString(14);
               lista.add(new check(Integer.parseInt(cod),nom ));

            }while(c.moveToNext());
        }

        db.close();

         for(check ch: lista){

            Button cb = new Button(getApplicationContext());
            //Button cb = new Button(getApplicationContext());
            cb.setText(ch.nombre);
            cb.setId(ch.cod);

            cb.setTextColor(Color.BLACK);
            cb.getBackground().clearColorFilter();
            cb.getBackground().setColorFilter(new LightingColorFilter(0xFF222222, 0xFFBBBBBB));

            contenedor.addView(cb);

            cb.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    contenedor.removeAllViews();
                    proveedor = v.getId();
                    Toast.makeText(getApplicationContext(), "Java Clicked " + v.getId(), Toast.LENGTH_SHORT).show();

                            db = usdbh.getWritableDatabase();
                            Cursor c2 = db.rawQuery("SELECT * FROM tabla_producto where num_producto = " +  v.getId(), null);

                            if (c2.moveToFirst()) {

                                do {

                                    String cod = c2.getString(3);
                                    String nom = c2.getString(4);
                                    lista2.add(new check(Integer.parseInt(cod), nom));

                                }while(c2.moveToNext());
                            }

                                 for(check ch: lista2){

                                     Button cb2 = new Button(getApplicationContext());
                                     //Button cb = new Button(getApplicationContext());
                                     cb2.setText(ch.nombre);
                                     cb2.setId(ch.cod);

                                     cb2.setTextColor(Color.BLACK);
                                     cb2.getBackground().clearColorFilter();
                                     cb2.getBackground().setColorFilter(new LightingColorFilter(0xFF222222, 0xFFBBBBBB));
                                     contenedor.addView(cb2);

                                     cb2.setOnClickListener(new View.OnClickListener() {

                                         @Override
                                         public void onClick(View v) {

                                            producto = v.getId();
                                            //Toast.makeText(getApplicationContext(), "Java Clicked " + v.getId(), Toast.LENGTH_SHORT).show();
                                             System.out.println("linea 124 de proveedor y producto " + proveedor + " -- " + producto);
                                             Intent IRealizarRecarga = new Intent(CargarProductos.this, RealizarRecarga.class);
                                             IRealizarRecarga.putExtra("proveedor",proveedor);
                                             IRealizarRecarga.putExtra("producto",producto);
                                             startActivity(IRealizarRecarga);
                                             finish();

                                         }

                                     });



                                 }


                            db.close();


                }
            });
        }



    }



    class check{

        public int cod;
        public String nombre;

        public check(){

        }

        public check(int cod, String nombre) {
            this.cod = cod;
            this.nombre = nombre;
        }

    }


}
