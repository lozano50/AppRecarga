package com.example.jesus.apprecarga.utils;

import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;

/**
 * Created by provar-3 on 8/06/16.
 */
public class AppUtil {

    public AppUtil()
    {
    }

    public static void delay(long milisecs)
    {
        for(long t0 = System.currentTimeMillis() + milisecs; System.currentTimeMillis() < t0;);
    }

    public static String uninterpret_ASCII(byte rawData[], int offset, int length)
    {
        char ret[] = new char[length];
        for(int i = 0; i < length; i++)
            ret[i] = (char)rawData[offset + i];

        return new String(ret);
    }

    public static String[] tokenizer(byte array[], int offset, int length, byte separator, int numTokens)
    {
        String tokens[] = new String[numTokens];
        int j = 0;
        label0:
        do
        {
            if(j < numTokens)
            {
                int len_tok = 0;
                int i = offset;
                do
                {
                    if(i >= length)
                        continue label0;
                    if(array[i] == separator)
                    {
                        tokens[j] = uninterpret_ASCII(array, offset, len_tok);
                        offset += len_tok + 1;
                        j++;
                        continue label0;
                    }
                    len_tok++;
                    i++;
                } while(true);
            }
            return tokens;
        } while(true);
    }

    public static String[] tokenizer(byte array[], int offset, int numTokens)
    {
        String tokens[] = new String[numTokens];
        for(int i = 0; i < numTokens; i++)
        {
            tokens[i] = uninterpret_ASCII(array, offset + 1, array[offset]);
            offset += array[offset] + 1;
        }

        return tokens;
    }

    public static String[] tokenizer(byte buff[], int tam[], int numTokens)
    {
        int indice = 0;
        String tokens[] = new String[numTokens];
        for(int i = 0; i < numTokens; i++)
        {
            indice += tam[i];
            tokens[i] = uninterpret_ASCII(buff, indice, tam[i + 1]);
        }

        return tokens;
    }

    @SuppressWarnings("WrongConstant")
    public static String getDateTime(int type)
    {
        String dateTime = "0";
        TimeZone tz = TimeZone.getTimeZone("GMT-5");
        Calendar actualDateTime = Calendar.getInstance(tz);
        Calendar _tmp = actualDateTime;
        String year = String.valueOf(actualDateTime.get(1));
        Calendar _tmp1 = actualDateTime;
        String month = String.valueOf(actualDateTime.get(2) + 1);
        Calendar _tmp2 = actualDateTime;
        String day = String.valueOf(actualDateTime.get(5));
        Calendar _tmp3 = actualDateTime;
        String hour = String.valueOf(actualDateTime.get(11));
        Calendar _tmp4 = actualDateTime;
        String minute = String.valueOf(actualDateTime.get(12));
        Calendar _tmp5 = actualDateTime;
        String second = String.valueOf(actualDateTime.get(13));
        Calendar _tmp6 = actualDateTime;
        if(actualDateTime.get(2) + 1 < 10)
            month = "0" + month;
        Calendar _tmp7 = actualDateTime;
        if(actualDateTime.get(5) < 10)
            day = "0" + day;
        Calendar _tmp8 = actualDateTime;
        if(actualDateTime.get(11) < 10)
            hour = "0" + hour;
        Calendar _tmp9 = actualDateTime;
        if(actualDateTime.get(12) < 10)
            minute = "0" + minute;
        Calendar _tmp10 = actualDateTime;
        if(actualDateTime.get(13) < 10)
            second = "0" + second;
        switch(type)
        {
            case 1: // '\001'
                dateTime = year + month + day;
                break;

            case 2: // '\002'
                dateTime = month + day;
                break;

            case 3: // '\003'
                dateTime = day + "/" + month + "/" + year;
                break;

            case 4: // '\004'
                dateTime = year + month + day + hour + minute + second;
                break;
        }
        return dateTime;
    }

    public static int getRandomInt(int desde, int hasta)
    {
        Random azar = new Random(System.currentTimeMillis());
        return desde + Math.abs(azar.nextInt()) % ((hasta - desde) + 1);
    }

    public static long getRandomLong(long desde, long hasta)
    {
        Random azar = new Random(System.currentTimeMillis());
        return desde + Math.abs(azar.nextLong()) % ((hasta - desde) + 1L);
    }

    public static void dumpMemory(byte Buffer[], int tam)
    {
        byte BufferDisplay[] = new byte[tam];
        for(int i = 0; i < tam; i++)
            if(Buffer[i] >= 32 && Buffer[i] <= 126)
                BufferDisplay[i] = Buffer[i];
            else
                BufferDisplay[i] = 46;

        System.out.println("\n\n\n");
        for(int i = 0; i < tam; i++)
        {
            System.out.print(ISOUtil.hexString(Buffer[i]) + " ");
            if((i + 1) % 16 == 0)
            {
                System.out.print("   " + uninterpret_ASCII(BufferDisplay, i - 15, 16));
                System.out.println();
                continue;
            }
            if(i + 1 == tam)
            {
                System.out.print(ISOUtil.padleft("   ", 3 * (16 - tam % 16), ' '));
                System.out.print("   " + uninterpret_ASCII(BufferDisplay, (i - tam % 16) + 1, tam % 16));
                System.out.println();
            }
        }

        System.out.println();
    }

    public static void memSet(byte Buffer[], byte caracter, int size)
    {
        for(int i = 0; i < size; i++)
            Buffer[i] = caracter;

    }

    public static String formatearCadena(String cadena, int tam, String caracter, int justificacion)
    {
        String cadena2 = cadena;
        for(int i = cadena.length(); i < tam; i++)
        {
            if(justificacion == 1)
                cadena = cadena + caracter;
            else
            if(justificacion == 2)
                cadena = caracter + cadena;
            System.out.println("cadena=" + cadena);
        }

        return cadena;
    }

    public static int strLen(byte Buffer[])
    {
        int i;
        for(i = 0; i < Buffer.length && Buffer[i] != 0; i++);
        return i;
    }

    public static String formatMiles(String cadena)
    {
        int k = 0;
        int j = 0;
        int tam = cadena.length();
        byte cadena_orig[] = cadena.getBytes();
        byte cad_destino[] = new byte[50];
        int i = tam / 3;
        if(i * 3 == tam)
            i--;
        k = 0;
        for(j = tam - 1; j >= 0; j--)
        {
            cad_destino[j + i] = cadena_orig[j];
            if((++k / 3) * 3 != k)
                continue;
            i--;
            if(j + i > 0)
                cad_destino[j + i] = 46;
        }

        return uninterpret_ASCII(cad_destino, 0, strLen(cad_destino));
    }

    public static boolean bEsNumerico(String cadena)
    {
        try
        {
            Long.parseLong(cadena);
            return true;
        } catch (NumberFormatException nfe) {
        }
        return false;

    }

    public static final int iLST_MENU_RECARGAS = 1;
    public static final int iLST_MENU_INFORMES = 2;
    public static final int iLST_MENU_USUARIOS = 3;

}
