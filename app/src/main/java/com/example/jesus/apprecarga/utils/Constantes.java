package com.example.jesus.apprecarga.utils;

/**
 * Created by jose on 2/08/14.
 */
public class Constantes {


    /*
     *Constante que asigna el pass de configuracion por defecto
     */
    public final static String PASS_CONFIG = "000000";

    public final static String PREFERENCIA_APP = "datos_provar";
    public final static String COD_TERMINAL    = "codTerminal";
    public final static String COD_ENTIDAD     = "codEntidad";

    public Constantes()
    {
    }

    public static final byte BCD = 1;
    public static final byte ASCII = 2;
    public static final byte BYTE = 3;
    public static String DEF_CAMPOS[] = {
            "", "", "", "Codigo de Proceso", "Monto", "", "", "", "", "",
            "", "STAN", "Hora transaccion", "Fecha transaccion", "", "", "", "", "", "",
            "", "", "Tipo entrada POS", "", "NII", "Codigo condicion POS", "", "", "", "",
            "", "", "", "", "", "", "", "", "Codigo de autorizacion", "Codigo respuesta",
            "", "ID terminal", "ID entidad", "", "Informacion adicional", "", "", "", "", "",
            "", "", "", "", "", "", "", "", "", "",
            "60:Reservado", "61:Reservado", "62:Reservado", "63:Reservado", "64:Reservado"
    };

    public static int DEF_FORMATO[][] = {
            {
                    0, 0
            }, {
            0, 0
    }, {
            0, 0
    }, {
            3, 1
    }, {
            6, 1
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            3, 1
    }, {
            3, 1
    }, {
            2, 1
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            2, 1
    }, {
            0, 0
    }, {
            2, 1
    }, {
            1, 1
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            6, 1
    }, {
            2, 2
    }, {
            0, 0
    }, {
            8, 2
    }, {
            15, 2
    }, {
            0, 0
    }, {
            25, 2
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 0
    }, {
            0, 3
    }, {
            0, 3
    }, {
            0, 3
    }, {
            0, 3
    }, {
            0, 3
    }
    };




}
