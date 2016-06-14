package com.example.jesus.apprecarga;

import android.app.IntentService;
import android.content.Intent;

import com.example.jesus.apprecarga.isolib.ISOMensaje;
import com.example.jesus.apprecarga.utils.AppUtil;
import com.example.jesus.apprecarga.utils.ISOUtil;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by provar-3 on 9/06/16.
 */
public class TransactionTCP extends IntentService {

    Socket socket = null;
    ISOMensaje iso;
    byte[] outputBuffer;
    int time_out1;
    int lenInput;
    char[] inputBuffer = new char[3024];
    OutputStream salida;
    BufferedReader entrada;

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
            socket = new Socket("181.143.155.250" , 8088 );

            socket.setSoTimeout(10000);

            System.out.println(":::::::::::::::::::: " + socket.isConnected());

            if(socket.isConnected()){

                //transactionInit();
                transactionSaldo();
                iso.borrarCampoISO(12);
                iso.setCampoISO(12, "Hora de la transaccion", 3, new int[][]{new int[]{3, 1}}, ISOUtil.getTimeAsString());

                /*outputBuffer = iso.getMensajeISOEnBytes();

                OutputStream mensaje = new DataOutputStream(socket.getOutputStream());
                mensaje.write(outputBuffer, 0, outputBuffer.length);
                mensaje.flush();*/
                consultaSaldo();

            }

            //socket.close();

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

        iso = TransMessages.packMsgInit(outputBuffer, "000001", "90909090", "01", "90901A", "000010101101010", false);

    }

    private void transactionSaldo() {

        iso = TransMessages.packMsgSaldo(outputBuffer, "000001", "90909090", "01", "000001", "90901A", "000010101101010");

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

                AppUtil.dumpMemory(data,87);


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




    /*
public class Cliente extends IntentService {

    Socket sc;

    public Cliente(){
        super("IntentServiceOperacion");
    }

    protected void onHandleIntent(Intent intent){

        try {
            BufferedReader entrada;
            System.out.println("Conectar por puerto:"  );

            //En esta parte entra en CMD y escribe ipconfig para encontrar la ip de tú PC
            //la ip siempre deberá de ser STRING

            sc = new Socket("181.143.155.250" , 8088 );

            sc.setSoTimeout(10000);

            if(sc.isConnected()){
                System.out.println("Confirmando conexion al server....");
                DataOutputStream mensaje = new DataOutputStream(sc.getOutputStream());
                mensaje.writeUTF("ID : 1 | android\n");

                entrada = new BufferedReader(new InputStreamReader(sc.getInputStream()));

                String mensajeRecibido = entrada.readLine();
                System.out.println(mensajeRecibido);


                System.out.println("fin conexion al server....");
                sc.close();

            }

        } catch (Exception ex) {
            System.out.println("Error al conectar cliente" + ex.toString());
        }finally{
            if(sc!=null){
                try {
                    sc.close();
                } catch (Exception ex) {
                    System.out.println("Error al cerrar el socket");
                }
            }
        }
    }

}*/






}



