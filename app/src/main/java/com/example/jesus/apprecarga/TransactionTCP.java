package com.example.jesus.apprecarga;

import android.app.IntentService;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.example.jesus.apprecarga.bd.MyBDSqlite;
import com.example.jesus.apprecarga.isolib.ISOMensaje;
import com.example.jesus.apprecarga.utils.AppUtil;
import com.example.jesus.apprecarga.utils.ISOUtil;
import com.example.jesus.apprecarga.utils.InfoConfiguracion;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.UTF_16;

/**
 * Created by provar-3 on 9/06/16.
 */
public class TransactionTCP extends IntentService {

    /********************************************************************/
    private       boolean fallo;
    private final int     MAX_TRANS      = 100;
    private final String  MODO_RECARGA   = "2";
    private final String  Oper_Pos_Admin = "01";
    private final String  Oper_Pos_User  = "02";
    private final int     TIME_OUT_READ  = 30;

    private String IpDLC_default         = "190.144.110.99";
    private int PortDLC_default          = 8088;
    private String primaryIP_default     = "190.144.110.99";
    private int    primaryPort_default   = 8088;
    private String idEntidad_default     = "000010101101010";
    private String location_id_default   = "168";
    private String terminal_id_default   = "90909090";
    private String num_lote_default      = "000001";
    private String password_default      = "000000";
    private int num_trans_default        = 0;
    private int logo_default             = 1;
    private int longCel_default          = 7;

    private String user_default             = "000000";
    private String pass_default             = "123456";
    private String operador_POS_G_default   = "01";


    private int PortDLC;
    private int num_trans;
    private int primaryPort;
    private String primaryIP;
    private String location_id;
    private String terminal_id;
    private String password;
    private String stan;
    private String rrn;
    private String fecha_ultima_venta;
    private String fecha_ultimo_cierre;
    private String saldo;
    private String stan_default = "1";
    private String rrn_default;
    private String IpDLC;
    private String num_lote;
    private String fec_venc;
    private String idEntidad;
    private String id_cliente;
    private String nom_entidad;
    private String RIF_cliente;
    private String tel_principal;
    private String tel_secundario;
    private String simbol_money;
    private String simbol_dec;
    private String fecha_server;
    private String configVersion;
    private String fecha_trans;
    private String clave;
    private String cod_prod;
    private String cod_prov;
    private String nom_prod;
    private int time_out2;
    private int num_servicios;
    private boolean config_Version = false;
    private boolean DLC;
    private int logo;
    int longCel;
    private int monto_prod;
    private String tipo_prod;
    private String nom_prov;
    private int numProductos;
    private String celular;
    private String valor;
    private String num_Aprov;
    private String trans;
    private String Ref_Last;
    private String Fecha_Hora_Last;
    private String cod_servi;
    private String operador;
    private String monto;
    private String cod_area;
    private String mod_recarga;
    private String errorCode;
    private boolean Decimal;
    private int Mon_Min;
    private int Mon_Max;
    private int m_idProducto;
    private int iLargoMinCel;
    private int iLargoMaxCel;
    private int Num_Prov;
    private int Pos_User;
    private String operador_POS_G;
    private String operador_POS;
    private String fecha_cierre;
    private String fecha_ventas;
    private int num_ventas;
    private int pos_tabla;
    private boolean cierre_OK;
    private boolean confirCierre_OK;
    private String saldo_aux;
    private String msn;
    private String user;
    private String pass;
    /*byte[] outputBuffer;
    byte[] inputBuffer = new byte[3024];
    int lenInput;*/
    int lenOutput;
    int actualTransaction;
    String[][] Ventas_Operador = new String[500][3];
    String[] dat_num_v = new String[2];
    int iOpcionMenu;
    ISOMensaje isoMsgUltRecarga;
    boolean bExisteRecarga;
    private int m_iCantRecargasCierre;
    private String m_strMontoRecargasCierre;
    private byte[] amount;
    private int tipo_alert;
    private int switche = 0;
    private int numRecargas; // utilizado para la opcion de las 5 ultimas recargas
    //**** Atributos para recibir ultimas Recargas **////
    private String numCelUR[];
    private String mesDiaHoraUR[];
    private String horaUR[];
    private String montoUR[];
    private String numAprobUR[];
    private String saldoUR[];
    private String strUltsRecs;
    private String strCampo63UR;
    /********************************************************************/


    Socket socket = null;
    ISOMensaje iso;
    byte[] outputBuffer;
    int time_out1;
    int lenInput;
    char[] inputBuffer = new char[3024];
    OutputStream salida;
    BufferedReader entrada;
    Configuracion config;
    int transaccionActual;


    /*variables para insertar en la base de datos de sqlite*/
    private SQLiteDatabase db;
    MyBDSqlite usdbh;




    public TransactionTCP(){
        super("IntentServiceOperacion");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        ISOMensaje isoRespDLC[] = new ISOMensaje[3];
        ISOMensaje isoOperDLC[] = new ISOMensaje[10];
        boolean isOk = true;

        try{

            BufferedReader entrada;
            System.out.println("Conectar por puerto:"  );
            socket = new Socket("190.144.110.99" , 8088 );

            socket.setSoTimeout(10000);
            String prueba = intent.getData().toString();
            System.out.println(":::::::::::::::::::: " + socket.isConnected());
            String campos[] = prueba.split("\\|");
            transaccionActual = Integer.parseInt(campos[0]);


            if(socket.isConnected()){

              switch(transaccionActual){
                  case 1:
                      hacerDlc();
                      break;
                  case 2:
                      //otrofuncion1();
                      break;
                  case 3:
                      //otrafuncion2();
                      break;
                  case 4:
                      //otrafuncion3();
                      break;
                  case 5:
                      //otrafuncion4();
                      break;
              }

             /*   transactionSaldo();
                iso.borrarCampoISO(12);
                iso.setCampoISO(12, "Hora de la transaccion", 3, new int[][]{new int[]{3, 1}}, ISOUtil.getTimeAsString());
                consultaSaldo();*/

            }

        } catch (Exception ex) {

            System.out.println("Error al conectar cliente" + ex.toString());

        }finally{

            if(socket!=null){

                try {

                    socket.close();

                } catch (Exception ex) {
                    System.out.println("Error al cerrar el socket");
                }

            }

        }

    }


    private void transactionInit() {

        iso = TransMessages.packMsgInit( "000001", "90909090", "01", "90901A", "000010101101010", false);

    }

    private void transactionSaldo() {

        iso = TransMessages.packMsgSaldo( "000001", "90909090", "000010101101010");

    }

    public void consultaSaldo(){

        try{

            if(socket.isConnected()){

                outputBuffer = iso.getMensajeISOEnBytes();

                OutputStream mensaje = new DataOutputStream(socket.getOutputStream());
                mensaje.write(outputBuffer, 0, outputBuffer.length);
                mensaje.flush();

                /*entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                byte[] data = new byte[3024];

                int leninput;
                leninput = entrada.;*/

                InputStream stream = socket.getInputStream();
                byte[] data = new byte[3024];
                int count = stream.read(data);

                System.out.println("data.length :::::::::: " + count);

                AppUtil.dumpMemory(data, count);

            }

            socket.close();

        } catch (Exception ex) {

            System.out.println("Error al conectar cliente" + ex.toString());

        }finally{

            if(socket!=null){

                try {

                    socket.close();

                } catch (Exception ex) {
                    System.out.println("Error al cerrar el socket");
                }

            }

        }



    }



    public void hacerDlc() {

        int i = 0;
        int len = 0;
        boolean isOk = true;
        OutputStream salida = null;
        InputStream entrada = null;
        ISOMensaje isoRespDLC[] = new ISOMensaje[3];
        ISOMensaje isoOperDLC[] = new ISOMensaje[10];

        try {

            iso = TransMessages.packMsgInit("000001", "90909090", "01", "90901A", "000010101101010", false);

            for (i = 0; i < 3; i++) {

                iso.borrarCampoISO(12);
                iso.setCampoISO(12, "Hora de la transaccion", 3, new int[][]{new int[]{3, 1}}, ISOUtil.getTimeAsString());

                outputBuffer = iso.getMensajeISOEnBytes();

                System.out.println("ENVIANDO PAQUETE DLC " + (i + 1) + "...");
                salida = new DataOutputStream(socket.getOutputStream());
                salida.write(outputBuffer, 0, outputBuffer.length);
                salida.flush();

                System.out.println("RECIBIENDO PAQUETE DLC " + (i + 1) + "...");

                long t0 = System.currentTimeMillis() + (long) (90 * 1000);

                do {

                    if (System.currentTimeMillis() >= t0) {

                        isOk = false;
                        break;
                    }

                    entrada = socket.getInputStream();
                    byte[] data = new byte[3024];
                    int count = entrada.read(data);

                    isoRespDLC[i] = new ISOMensaje(data);
                    AppUtil.dumpMemory(data, count);
                    System.out.println("\nSe recibieron los datos del paquete " + (i + 1) + "...");

                    break;
                }while (true);

            }

            if(isOk == true){
                byte bNumOper[] = new byte[2];

                System.out.println("Antes de System.arraycopy");
                System.arraycopy(isoRespDLC[2].getCampoISOenBytes(62), isoRespDLC[2].getCampoISOenBytes(62).length - 2, bNumOper, 0, 2);
                System.out.println("Despues de System.arraycopy");

                int iNumOper = Integer.parseInt(new String(bNumOper));
                i = 0;
                System.out.println("contador de paquetes recibidos :::::::::: " + iNumOper);

                do { //ciclo segun el numero de operadores

                    if (i >= iNumOper) {
                        break;
                    }

                    String strCampoOperadora = "";

                    strCampoOperadora = "00060004100" + (i + 1);
                    iso.borrarCampoISO(12);
                    iso.setCampoISO(12, "Hora de la transaccion", 3, new int[][]{new int[]{3, 1}}, ISOUtil.getTimeAsString());
                    iso.borrarCampoISO(63);
                    iso.setCampoISO(63, "Operadora", 8, new int[][]{new int[]{2, 1}, new int[]{2, 1}, new int[]{2, 2}, new int[]{2, 2}}, strCampoOperadora);
                    outputBuffer = iso.getMensajeISOEnBytes();

                    salida = new DataOutputStream(socket.getOutputStream());
                    salida.write(outputBuffer, 0, outputBuffer.length);
                    System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: ");
                    AppUtil.dumpMemory(outputBuffer, outputBuffer.length);
                    System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: ");
                    salida.flush();


                    long t0 = System.currentTimeMillis() + (long) (90 * 1000);

                    do { // ciclo de espera de llegada de datos despues de enviado outputBuffer

                        if (System.currentTimeMillis() >= t0) {
                            isOk = false;
                            break;
                        }

                        entrada = socket.getInputStream();
                        byte[] data = new byte[3024];
                        int count = entrada.read(data);
                        //AppUtil.delay(500L);
                        isoOperDLC[i] = new ISOMensaje(data);
                        System.out.println("Recibiendo Operador " + i + "...");
                        AppUtil.dumpMemory(data, count);

                        break;

                    } while (true);

                    if (!isOk) {
                        break;
                    }
                    i++;

                } while (true);

            }

            entrada.close();
            salida.close();
            socket.close();

            if (!isOk) {

                salida  = null;
                entrada = null;
                socket  = null;
                //alerta  = InfoMessages.screen_message(19);
                //getDisplay().setCurrent(alerta, get_lstMenuConfig());  //MenuPrincipal()

            } else {

                if (desarmarDConfig(isoRespDLC, isoOperDLC)) {

                    //alerta = InfoMessages.screen_message(45);//DLC hecho con exito
                    //alerta.setTimeout(Alert.FOREVER);
                    //getDisplay().setCurrent(alerta, get_lstMenuPrincipal());

                } else {

                    salida  = null;
                    entrada = null;
                    socket  = null;
                    //alerta = new Alert("Error", msn, null, AlertType.ERROR);
                    //alerta.setTimeout(Alert.FOREVER);
                    //getDisplay().setCurrent(alerta, get_lstMenuConfig());
                }
            }



        } catch (Exception ex) {

            System.out.println("Error al conectar cliente" + ex.toString());

        } finally {

            if (socket != null) {

                try {

                    socket.close();

                } catch (Exception ex) {
                    System.out.println("Error al cerrar el socket");
                }

            }
        }
    }

    public boolean desarmarDConfig(ISOMensaje isoRespDLC[], ISOMensaje isoOper[]) throws Exception {

        int ilargoOper     = isoOper.length;
        InfoConfiguracion conf = null;

        conf = new InfoConfiguracion(isoRespDLC[0], isoRespDLC[1], isoRespDLC[2]);

        String strCodRespDLC = new String(isoRespDLC[0].getCampoISOenBytes(39));

        if (!strCodRespDLC.equalsIgnoreCase("00")) {
            System.out.println("Codigo de respuesta distinto de \"00\"");
            return false;
        }

        configVersion = conf.getStrVersionDLC();
        id_cliente    = conf.getStrNroIdentificacion();
        nom_entidad   = conf.getStrNombreEntidad();
        tel_principal = conf.getStrTelefonoEntidad();
        simbol_money  = conf.getStrSimboloMoneda();
        simbol_dec    = conf.getStrSimboloDecimal();
        password      = conf.getStrPassword();

        System.out.println("Password -------------------------------- : " + password);

        fecha_server = conf.getStrFechaDLC();
        System.out.println("conf.getStrGprsRecibiendoTimeout(): " + conf.getStrGprsRecibiendoTimeout());

        time_out1     = Integer.parseInt(conf.getStrGprsRecibiendoTimeout());
        num_servicios = conf.getiNumOperadoras();
        System.out.println("num_servicios :::::::::: "  + num_servicios);
        IpDLC         = conf.getStrGprsIPPrimaria().trim();
        System.out.println("IpDLC " + IpDLC);

        PortDLC       = Integer.parseInt(conf.getStrGprsPuertoPrimario());
        System.out.println("PortDLC " + PortDLC);

        primaryIP     = conf.getStrGprsIPSecundaria().trim();
        System.out.println("primaryIP " + primaryIP);
        primaryPort   = Integer.parseInt(conf.getStrGprsPuertoSecundario());
        System.out.println("primaryPort" + primaryPort);

        /*codigo para insertar en las bases de datos de trama1, trama2, trama3, */

        usdbh = new MyBDSqlite(this, "DbRecarga.db", null, 1);
        db = usdbh.getWritableDatabase();

        /*codigo para insertar en la primera tabla llamada tabla_Trama_resp_1*/
        /*ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("nombre", nombre);
        nuevoRegistro.put("cod_usuario", codUsuario);
        nuevoRegistro.put("tipo_usuario", tipoUser);
        db.insert("usuarios", null, nuevoRegistro);*/

      /*strNombreEntidad
        strNroIdentificacion
        strDireccionEntidad
        strTelefonoEntidad
        strEncabezadoCierre1
        strEncabezadoCierre2
        strEncabezadoCierre3
        strEncabezadoCierre4
        strEncabezadoCierre5
        strPieDePaginaCierre1
        strPieDePaginaCierre2
        strPieDePaginaCierre3
        strPieDePaginaCierre4
        strPieDePaginaCierre5
        strGprsAPN
        strGprsUsuario
        strGprsPassword
        strGprsPPPTimeout
        strGprsRecibiendoTimeout
        strGprsPPPPermanente
        strGprsTCPPermanente
        strGprsIPPrimaria
        strGprsIPSecundaria
        strGprsPuertoPrimario
        strGprsPuertoSecundario
        strGprsSSL
        strDialupHostPrimario
        strDialupHostSecundario
        strDialupTimeoutRecarga
        strDialupTimeoutCierre
        strDialupTimeoutConsulta
        strSimboloMoneda
        strNumeroDecimales
        strSimboloDecimal
        strPassword
        strFechaDLC
        strVersionDLC*/
        System.out.println("primaryPort " + new String(isoRespDLC[0].getCampoISOenBytes(41)));
        System.out.println("primaryPort " + new String(isoRespDLC[0].getCampoISOenBytes(42)));
        System.out.println("primaryPort " + new String(isoRespDLC[0].getCampoISOenBytes(44)));
        System.out.println("primaryPort " + conf.getStrNombreEntidad());
        System.out.println("primaryPort " + conf.getStrNroIdentificacion());
        System.out.println("primaryPort " + conf.getStrDireccionEntidad());
        System.out.println("primaryPort " + conf.getStrTelefonoEntidad());
        System.out.println("primaryPort " + conf.getStrEncabezadoCierre1());
        System.out.println("primaryPort " + conf.getStrEncabezadoCierre2());
        System.out.println("primaryPort " + conf.getStrEncabezadoCierre3());
        System.out.println("primaryPort " + conf.getStrEncabezadoCierre4());
        System.out.println("primaryPort " + conf.getStrEncabezadoCierre5());
        System.out.println("primaryPort " + conf.getStrPieDePaginaCierre1());
        System.out.println("primaryPort " + conf.getStrPieDePaginaCierre2());
        System.out.println("primaryPort " + conf.getStrPieDePaginaCierre3());
        System.out.println("primaryPort " + conf.getStrPieDePaginaCierre4());
        System.out.println("primaryPort " + conf.getStrPieDePaginaCierre5());
        System.out.println("primaryPort " + conf.getStrGprsAPN());
        System.out.println("primaryPort " + conf.getStrGprsUsuario());
        System.out.println("primaryPort " + conf.getStrGprsPassword());
        System.out.println("primaryPort " + conf.getStrGprsPPPTimeout());
        System.out.println("primaryPort " + conf.getStrGprsRecibiendoTimeout());
        System.out.println("primaryPort " + conf.getStrGprsPPPPermanente());
        System.out.println("primaryPort " + conf.getStrGprsTCPPermanente());
        System.out.println("primaryPort " + conf.getStrGprsIPPrimaria());
        System.out.println("primaryPort " + conf.getStrGprsIPSecundaria());
        System.out.println("primaryPort " + conf.getStrGprsPuertoPrimario());
        System.out.println("primaryPort " + conf.getStrGprsPuertoSecundario());
        System.out.println("primaryPort " + conf.getStrGprsSSL());
        System.out.println("primaryPort " + conf.getStrDialupHostPrimario());
        System.out.println("primaryPort " + conf.getStrDialupHostSecundario());
        System.out.println("primaryPort " + conf.getStrDialupTimeoutRecarga());
        System.out.println("primaryPort " + conf.getStrDialupTimeoutCierre());
        System.out.println("primaryPort " + conf.getStrDialupTimeoutConsulta());
        System.out.println("primaryPort " + conf.getStrSimboloMoneda());
        System.out.println("primaryPort " + conf.getStrNumeroDecimales());
        System.out.println("primaryPort " + conf.getStrSimboloDecimal());
        System.out.println("primaryPort " + conf.getStrPassword());
        System.out.println("primaryPort " + conf.getStrFechaDLC());
        System.out.println("primaryPort " + conf.getStrVersionDLC());


        /************************************************************************/
        /*strEncabezadoActivacion1
        strEncabezadoActivacion2
        strEncabezadoActivacion3
        strEncabezadoActivacion4
        strEncabezadoActivacion5
        strPiePaginaActivacion1
        strPiePaginaActivacion2
        strPiePaginaActivacion3
        strPiePaginaActivacion4
        strPiePaginaActivacion5
        strEncabezadoSaldo1
        strEncabezadoSaldo2
        strEncabezadoSaldo3
        strPiePaginaSaldo1
        strPiePaginaSaldo2
        strPiePaginaSaldo3*/
        System.out.println("primaryPort " + new String(isoRespDLC[0].getCampoISOenBytes(41)));
        System.out.println("primaryPort " + new String(isoRespDLC[0].getCampoISOenBytes(42)));
        System.out.println("primaryPort " + new String(isoRespDLC[0].getCampoISOenBytes(44)));

        System.out.println("primaryPort " + conf.getStrEncabezadoActivacion1());
        System.out.println("primaryPort " + conf.getStrEncabezadoActivacion2());
        System.out.println("primaryPort " + conf.getStrEncabezadoActivacion3());
        System.out.println("primaryPort " + conf.getStrEncabezadoActivacion4());
        System.out.println("primaryPort " + conf.getStrEncabezadoActivacion5());
        System.out.println("primaryPort " + conf.getStrPiePaginaActivacion1());
        System.out.println("primaryPort " + conf.getStrPiePaginaActivacion2());
        System.out.println("primaryPort " + conf.getStrPiePaginaActivacion3());
        System.out.println("primaryPort " + conf.getStrPiePaginaActivacion4());
        System.out.println("primaryPort " + conf.getStrPiePaginaActivacion5());
        System.out.println("primaryPort " + conf.getStrEncabezadoSaldo1());
        System.out.println("primaryPort " + conf.getStrEncabezadoSaldo2());
        System.out.println("primaryPort " + conf.getStrEncabezadoSaldo3());
        System.out.println("primaryPort " + conf.getStrPiePaginaSaldo1());
        System.out.println("primaryPort " + conf.getStrPiePaginaSaldo2());
        System.out.println("primaryPort " + conf.getStrPiePaginaSaldo3());
        /************************************************************************/




        /************************************************************************/



        return true;
    }




}




