package com.example.jesus.apprecarga;

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


    /*variables de pruebas*/
    int countProd = 0;


    /*variables de pruebas*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cargar_productos);

        contenedor = (LinearLayout)findViewById(R.id.contenedor);

        usdbh = new MyBDSqlite(this, "DbRecarga.db", null, 6);
        db = usdbh.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM tabla_producto_aux", null);
        countProd = c.getCount();


                /*

                        //Alternativa 1: método rawQuery()
                        Cursor c = db.rawQuery("SELECT codigo, nombre FROM Usuarios2", null);

                        //Recorremos los resultados para mostrarlos en pantalla
                        txtResultado.setText("");
                        if (c.moveToFirst()) {
                            //Recorremos el cursor hasta que no haya más registros
                            do {

                                String cod = c.getString(0);
                                String nom = c.getString(1);

                                txtResultado.append(" " + cod + " - " + nom + "\n");
                            } while(c.moveToNext());
                        }
                    }
            */

       ArrayList<check> lista = new ArrayList<check>();

        if (c.moveToFirst()) {

           do {

               String cod = c.getString(1);
               String nom = c.getString(14);

               System.out.println("ch  ::::::::::::::: " + cod);
               System.out.println("ch  ::::::::::::::: " + nom);


                lista.add(new check(Integer.parseInt(cod),nom ));

            }while(c.moveToNext());
        }

        db.close();

         for(check ch: lista){

            Button cb = new Button(getBaseContext());
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

                    Toast.makeText(getBaseContext(), "Java Clicked " + v.getId(), Toast.LENGTH_SHORT).show();

                            db = usdbh.getWritableDatabase();
                            ArrayList<check> lista2 = new ArrayList<check>();
                            Cursor c = db.rawQuery("SELECT * FROM tabla_producto where num_producto = " +  v.getId(), null);
                            countProd = c.getCount();
                            System.out.println("countProd  ::::::::::::::: " + countProd);

                            contenedor.removeAllViews();
                            if (c.moveToFirst()) {

                                do {

                                    String cod = c.getString(1);
                                    String nom = c.getString(4);

                                    System.out.println("ch  ::::::::::::::: " + cod);
                                    System.out.println("ch  ::::::::::::::: " + nom);


                                    lista2.add(new check(Integer.parseInt(cod), nom));



                                }while(c.moveToNext());
                            }

                                 for(check ch: lista2){

                                        Button cb = new Button(getBaseContext());
                                        //Button cb = new Button(getApplicationContext());
                                     cb.setText(ch.nombre);
                                     cb.setId(ch.cod);

                                     cb.setTextColor(Color.BLACK);
                                        cb.getBackground().clearColorFilter();
                                        cb.getBackground().setColorFilter(new LightingColorFilter(0xFF222222, 0xFFBBBBBB));


                                     contenedor.addView(cb);
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
