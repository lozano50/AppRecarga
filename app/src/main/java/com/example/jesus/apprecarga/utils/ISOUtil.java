package com.example.jesus.apprecarga.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by provar-3 on 8/06/16.
 */
public class ISOUtil {

    public ISOUtil(){

    }

    /*
    *
    * metodo que retorna la hora actual del servidor
    *
    *
    * */
    @SuppressWarnings("WrongConstant")
    public static String getTimeAsString2(){

        Calendar cal = Calendar.getInstance();
        Date date = new Date();
        cal.setTime(date);

        String hour = String.valueOf(cal.get(11));
        String minute = String.valueOf(cal.get(12));
        String second = String.valueOf(cal.get(13));

        if(cal.get(11) < 10)
            hour = "0" + hour;
        if(cal.get(12) < 10)
            minute = "0" + minute;
        if(cal.get(13) < 10)
            second = "0" + second;
        String time = hour + minute + second;

        return time;

    }

    /*
    *
    *   metodo para obtener la fecha y pasarla a string
    */
    public static String getFechaAsString2(){

        Calendar cal = Calendar.getInstance();
        Date date = new Date();
        cal.setTime(date);

        String anio = String.valueOf(cal.get(Calendar.YEAR));
        String mes = String.valueOf(cal.get(Calendar.MONTH)+1);
        String dia = String.valueOf(cal.get(Calendar.DAY_OF_MONTH)) ;

        if(mes.length() < 2 )
            mes = "0" + mes;
        if(dia.length() < 2 )
            dia = "0" + dia;
        String fecha = mes.concat(dia);

        return fecha;
    }


    @SuppressWarnings("WrongConstant")
    public static byte[] getTime()
    {
        TimeZone tz = TimeZone.getTimeZone("GMT-5");
        Calendar actualDateTime = Calendar.getInstance(tz);
        String hour = String.valueOf(actualDateTime.get(11));
        String minute = String.valueOf(actualDateTime.get(12));
        String second = String.valueOf(actualDateTime.get(13));
        if(actualDateTime.get(11) < 10)
            hour = "0" + hour;
        if(actualDateTime.get(12) < 10)
            minute = "0" + minute;
        if(actualDateTime.get(13) < 10)
            second = "0" + second;
        String time = hour + minute + second;
        return str2bcd(time, true);
    }

    @SuppressWarnings("WrongConstant")
    public static String getTimeAsString()
    {
        TimeZone tz = TimeZone.getTimeZone("GMT-5");
        Calendar actualDateTime = Calendar.getInstance(tz);
        String hour = String.valueOf(actualDateTime.get(11));
        String minute = String.valueOf(actualDateTime.get(12));
        String second = String.valueOf(actualDateTime.get(13));
        if(actualDateTime.get(11) < 10)
            hour = "0" + hour;
        if(actualDateTime.get(12) < 10)
            minute = "0" + minute;
        if(actualDateTime.get(13) < 10)
            second = "0" + second;
        String time = hour + minute + second;
        return time;
    }

    @SuppressWarnings("WrongConstant")
    public static byte[] getDate()
    {
        TimeZone tz = TimeZone.getTimeZone("GMT-5");
        Calendar actualDateTime = Calendar.getInstance(tz);
        String month = String.valueOf(actualDateTime.get(2) + 1);
        String day = String.valueOf(actualDateTime.get(5));
        if(actualDateTime.get(2) + 1 < 10)
            month = "0" + month;
        if(actualDateTime.get(5) < 10)
            day = "0" + day;
        String date = month + day;
        return str2bcd(date, true);
    }


    @SuppressWarnings("WrongConstant")
    public static String getDateAsString()
    {
        TimeZone tz = TimeZone.getTimeZone("GMT-5");
        Calendar actualDateTime = Calendar.getInstance(tz);
        String month = String.valueOf(actualDateTime.get(2) + 1);
        String day = String.valueOf(actualDateTime.get(5));
        if(actualDateTime.get(2) + 1 < 10)
            month = "0" + month;
        if(actualDateTime.get(5) < 10)
            day = "0" + day;
        String date = month + day;
        return date;
    }

    public static byte[] str2bcd(String s, boolean padLeft, byte d[], int offset)
    {
        int len = s.length();
        int start = (len & 1) != 1 || !padLeft ? 0 : 1;
        for(int i = start; i < len + start; i++)
            d[offset + (i >> 1)] |= s.charAt(i - start) - 48 << ((i & 1) != 1 ? 4 : 0);

        return d;
    }

    public static byte[] str2bcd(String s, boolean padLeft)
    {
        int len = s.length();
        byte d[] = new byte[len + 1 >> 1];
        return str2bcd(s, padLeft, d, 0);
    }


    public static String bcd2str(byte source[], int offset, int length)
    {
        char ret[] = new char[length * 2];
        int indexString = 0;
        for(int counter = offset; counter < length + offset; counter++)
        {
            byte car = (byte)((source[counter] & 0xf0) >> 4);
            ret[indexString] = (char)(car + (car >= 10 ? 55 : 48));
            indexString++;
            car = (byte)(source[counter] & 0xf);
            ret[indexString] = (char)(car + (car >= 10 ? 55 : 48));
            indexString++;
        }

        return new String(ret);
    }


    public static String padleft(String s, int len, char c)
    {
        s = s.trim();
        if(s.length() <= len)
        {
            StringBuffer d = new StringBuffer(len);
            for(int fill = len - s.length(); fill-- > 0;)
                d.append(c);

            d.append(s);
            return d.toString();
        } else
        {
            return s;
        }
    }


    public static String padright(String s, int len, char c)
    {
        s = s.trim();
        if(s.length() <= len)
        {
            StringBuffer d = new StringBuffer(len);
            int fill = len - s.length();
            d.append(s);
            while(fill-- > 0)
                d.append(c);
            return d.toString();
        } else
        {
            return s;
        }
    }

    public static String unPadLeft(String s, char c)
    {
        if(s.trim().length() == 0 && c == ' ')
            return (new Character(c)).toString();
        if(s.trim().length() == 0)
            return s;
        s = s.trim();
        int fill = 0;
        int end;
        for(end = s.length(); fill < end && s.charAt(fill) == c; fill++);
        return fill >= end ? s.substring(fill - 1, end) : s.substring(fill, end);
    }

    public static String hexString(byte buffer[], int offset, int length)
    {
        String AsciiHexa = "";
        for(int i = offset; i < length + offset; i++)
            AsciiHexa = AsciiHexa + hexString(buffer[i]);

        return AsciiHexa;
    }

    public static String hexString(byte b)
    {
        int c = b;
        if(c < 0)
            c -= -256;    //   c = c - 0xFFFFFF00;    //
        String AsciiHexa = padleft(Integer.toHexString(c), 2, '0').toUpperCase();
        return AsciiHexa;
    }

    public static int convertirByteAEntero(byte bCadBytes[])
    {
        String strBytesBCD = null;
        int iRet = 0;
        strBytesBCD = hexString(bCadBytes, 0, bCadBytes.length);
        iRet = Integer.parseInt(strBytesBCD);
        return iRet;
    }



}
