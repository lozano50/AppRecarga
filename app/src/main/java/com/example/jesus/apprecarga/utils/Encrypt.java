package com.example.jesus.apprecarga.utils;

/**
 * Created by provar-3 on 8/06/16.
 */
public class Encrypt {

    /*
    *   constructor de la clase Encript
    *
    *
    * */
    public Encrypt(){}


    /*
    *
    * funcion que permite encriptar la trama.
    *
    * @params
    * byte
    * byte
    * byte
    *
    * */
    public static void RC4(byte source[], byte destination[], byte key[]){

        int j = 0;
        byte temp[] = new byte[128];
        int s[] = new int[256];
        int k[] = new int[256];
        for(int tmp = 0; tmp < 256; tmp++)
        {
            s[tmp] = tmp;
            k[tmp] = key[(tmp % key.length)];
        }

        int i;
        for(i = 0; i < 256; i++)
        {
            j = (j + s[i] + k[i]) % 256;
            int tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }

        i = 0;
        j = 0;
        for(int tmp = 0; tmp < source.length; tmp++)
        {
            i = (i + 1) % 256;
            j = (j + s[i]) % 256;
            int tmp2 = s[i];
            s[i] = s[j];
            s[j] = tmp2;
            int t = (s[i] + s[j]) % 256;

            temp[tmp] = (byte)(s[t] ^ source[tmp]); // XOR
        }

        System.arraycopy(temp, 0, destination, 0, source.length);

    }


    /*
    *
    * metodo put_rc4_authorkey que contiene la key
    *
    * @params
    *
    * String
    * String
    * String
    *
    * */
    public static byte[] put_rc4_authorkey(String TerminalId, String SystemTraceNo, String TimeLocalTrans){

        byte authorkey[] = new byte[40];
        byte message[] = new byte[20];
        byte encrypted[] = new byte[20];
        byte pwd[] = new byte[18];
        pwd = ("IBIG" + SystemTraceNo + TerminalId).getBytes();
        message = (TimeLocalTrans + TerminalId + "567890").getBytes();
        RC4(message, encrypted, pwd);
        authorkey = ISOUtil.hexString(encrypted, 0, encrypted.length).getBytes();
        return authorkey;

    }


    public static byte[] put_rc4_msgSale(String TerminalId, String SystemTraceNo, String modo_Recarga, String operador_pos, String cod_prov, String cod_area, String celular, String cod_servicio,
                                         String valor, int idProducto)
    {
        byte msgSale[] = new byte[46];
        byte message[] = new byte[23];
        byte encrypted[] = new byte[23];
        byte pwd[] = new byte[27];

        cod_servicio = "00";
        pwd = ("ALFAOMEGA" + SystemTraceNo + "IBIG" + TerminalId).getBytes();
        int indice = 0;
        System.arraycopy("02".getBytes(), 0, message, indice, "02".length());
        indice += 2;
        System.arraycopy(modo_Recarga.getBytes(), 0, message, indice, modo_Recarga.length());
        indice++;
        System.arraycopy("01".getBytes(), 0, message, indice, "01".length());
        indice += 2;
        System.arraycopy(cod_prov.getBytes(), 0, message, indice, cod_prov.length());
        indice += 2;
        //System.arraycopy((ISOUtil.padright(cod_area, 5, ' ')).getBytes(), 0, message, indice, 5);
        //indice += 5;
        System.arraycopy((ISOUtil.padright(celular, 13, ' ')).getBytes(), 0, message, indice, 13);
        indice += 13;
        System.arraycopy((ISOUtil.padleft(Integer.toString(idProducto), 2, '0')).getBytes(), 0, message, indice, 2);
        indice += 2;
        message[indice] = 70;
        indice++;
        RC4(message, encrypted, pwd);
        msgSale = (ISOUtil.hexString(encrypted, 0, encrypted.length)).getBytes();

        return msgSale;

    }



}
