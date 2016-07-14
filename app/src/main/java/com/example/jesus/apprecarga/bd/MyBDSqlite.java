package com.example.jesus.apprecarga.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by provar-3 on 14/06/16.
 */
public class MyBDSqlite extends SQLiteOpenHelper{

    private static final String nameBD = "DbRecarga.db";
    private static final String tabla_Trama_resp_1 = "tablatramaresp1";
    private static final String tabla_Trama_resp_2 = "tablatramaresp2";
    private static final String tabla_Trama_resp_3 = "tablatramaresp3";
    private static final String tabla_Usuario      = "usuarios";
    private static final String tabla_producto_aux = "tabla_producto_aux";
    private static final String tabla_producto     = "tabla_producto";
    private static final String tabla_registros    = "tabla_registros";


    String sqlTramaResp1 = "CREATE TABLE "+ tabla_Trama_resp_1 +" (id INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1," +
            " idpos text, idcomercio TEXT, msg TEXT, nombre_cli TEXT, nro_identificacion TEXT, direccion_ent TEXT," +
            " telefono TEXT, encabezado_cierre_1 TEXT, encabezado_cierre_2 TEXT, encabezado_cierre_3 TEXT, encabezado_cierre_4 TEXT," +
            " encabezado_cierre_5 TEXT, pie_cierre_1 TEXT, pie_cierre_2 TEXT, pie_cierre_3 TEXT, pie_cierre_4 TEXT, pie_cierre_5 TEXT," +
            " gprs_apn TEXT, gprs_usuario TEXT," + " gprs_password TEXT, gprs_timeout TEXT, gprs_Recib_Timeout TEXT, gprs_ppp TEXT," +
            " Gprs_TCP_Perm TEXT, ip_primaria TEXT, ip_secundaria TEXT, puerto_Primario TEXT, puerto_secundario TEXT, gprs_ssl TEXT," +
            " dialup_primario TEXT, dialup_secundario TEXT, Dialup_Timeout TEXT," + " Dp_timeout_Cierre TEXT, DialupTimeoutConsulta TEXT," +
            " SimboloMoneda TEXT, NumeroDecimales TEXT, SimboloDecimal TEXT, Password TEXT, FechaDLC TEXT, VersionDLC TEXT)";

    String sqlTramaResp2 = "CREATE TABLE "+ tabla_Trama_resp_2 +" (id INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1, idpos TEXT, idcomercio TEXT," +
            " msg TEXT, encabezado_activo1 TEXT, encabezado_activo2 TEXT, encabezado_activo3 TEXT," +
            " encabezado_activo4 TEXT, encabezado_activo5 TEXT, pagina_activo1 TEXT, pagina_activo2 TEXT," +
            " pagina_activo3 TEXT, pagina_activo4 TEXT, pagina_activo5 TEXT, encabezado_saldo1 TEXT, encabezado_saldo2 TEXT," +
            " encabezado_saldo3 TEXT, pagina_saldo1 TEXT, pagina_saldo2 TEXT, pagina_saldo3 TEXT)";

    String sqlTramaResp3 = "CREATE TABLE "+ tabla_Trama_resp_3 +" (id_num INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1," +
            " idpos TEXT, idcomercio TEXT, cant_producto TEXT)";

    String sqlTableUsuario = "CREATE TABLE "+ tabla_Usuario +" (id_num INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1," +
            " nombre TEXT, cod_usuario INTEGER, tipo_usuario INTEGER, pass INTEGER)";

    String sqlTableProductoAux = "CREATE TABLE "+ tabla_producto_aux +" (id_num INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1," +
            " num_producto TEXT, encabezado_recarga_1 TEXT, encabezado_recarga_2 TEXT, encabezado_recarga_3 TEXT, encabezado_recarga_4 TEXT," +
            " encabezado_recarga_5 TEXT, pie_recarga_1 TEXT, pie_recarga_2 TEXT, pie_recarga_3 TEXT, pie_recarga_4 TEXT, pie_recarga_5 TEXT," +
            " cod_logo TEXT, cod_prov TEXT, nombre_operadora TEXT, tipo_protocolo TEXT, prefijo_operadora TEXT, largo_minimo TEXT," +
            " largo_maximo TEXT, modo_recarga TEXT, total_productos TEXT, monto_minimo TEXT, monto_maximo TEXT, multiplicador TEXT  )";

    String sqlTableProducto = "CREATE TABLE "+ tabla_producto +" (id_num INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1," +
            " num_producto INTEGER, modo_recarga TEXT, codigo_producto INTEGER, nombre_producto TEXT, valor_producto INTEGER)";

    String sqlTablaRegRecargas = "";

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
        db.execSQL(sqlTramaResp3);
        db.execSQL(sqlTableUsuario);
        db.execSQL(sqlTableProductoAux);
        db.execSQL(sqlTableProducto);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + tabla_Trama_resp_1);
        db.execSQL("DROP TABLE IF EXISTS " + tabla_Trama_resp_2);
        db.execSQL("DROP TABLE IF EXISTS " + tabla_Trama_resp_3);
        db.execSQL("DROP TABLE IF EXISTS " + tabla_Usuario);
        db.execSQL("DROP TABLE IF EXISTS " + tabla_producto_aux);
        db.execSQL("DROP TABLE IF EXISTS " + tabla_producto);

        db.execSQL(sqlTramaResp1);
        db.execSQL(sqlTramaResp2);
        db.execSQL(sqlTramaResp3);
        db.execSQL(sqlTableUsuario);
        db.execSQL(sqlTableProductoAux);
        db.execSQL(sqlTableProducto);

    }
}
