package com.example.jesus.apprecarga.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by provar-3 on 14/06/16.
 */
public class MyBDSqlite extends SQLiteOpenHelper{

    private static final String nameBD = "DbRecarga";
    private static final String tabla_Trama_resp_1 = "tablaTramaResp1";
    private static final String tabla_Trama_resp_2 = "tablaTramaResp2";

    String sqlTramaResp1 = "CREATE TABLE "+ tabla_Trama_resp_1 +" (id INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1, idpos INTEGER, idcomercio TEXT, msg TEXT, nombre_cliente TEXT, entidad TEXT, direccion TEXT," +
            " telefono TEXT, cabecera1 TEXT, cabecera2 TEXT, cabecera3 TEXT, cabecera4 TEXT, cabecera5 TEXT, footer1 TEXT, footer2 TEXT, footer3 TEXT, footer4 TEXT, footer5 TEXT, apn TEXT, usuario TEXT," +
            " clave TEXT, timeout1 TEXT, timeout2 TEXT, ip1 TEXT, ip2 TEXT, port1 INTEGER, port2 INTEGER, pass INTEGER, fecha TEXT, version TEXT)";

    String sqlTramaResp2 = "CREATE TABLE "+ tabla_Trama_resp_2 +" (id INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1, idpos INTEGER, idcomercio TEXT, msg TEXT, encabezado_activo1 TEXT, encabezado_activo2 TEXT, encabezado_activo3 TEXT," +
            " encabezado_activo4 TEXT, encabezado_activo5 TEXT, pagina_activo1 TEXT, pagina_activo2 TEXT, pagina_activo3 TEXT, pagina_activo4 TEXT, pagina_activo5 TEXT, encabezado_saldo1 TEXT, encabezado_saldo2 TEXT, encabezado_saldo3 TEXT, pagina_saldo1 TEXT, pagina_saldo2 TEXT, pagina_saldo3 TEXT)";


    public MyBDSqlite(Context context,
                      String name,
                      SQLiteDatabase.CursorFactory factory,
                      int version) {

        super(context, nameBD, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sqlTramaResp1);
        db.execSQL(sqlTramaResp2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + tabla_Trama_resp_1);
        db.execSQL("DROP TABLE IF EXISTS " + tabla_Trama_resp_2);

        db.execSQL(sqlTramaResp1);
        db.execSQL(sqlTramaResp2);

    }
}
