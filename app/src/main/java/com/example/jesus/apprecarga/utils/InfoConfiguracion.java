package com.example.jesus.apprecarga.utils;

import com.example.jesus.apprecarga.isolib.ISOMensaje;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

/**
 * Created by provar-3 on 29/06/16.
 */
public class InfoConfiguracion {

    private String strNombreEntidad;
    private String strNroIdentificacion;
    private String strDireccionEntidad;
    private String strTelefonoEntidad;
    private String strEncabezadoCierre1;
    private String strEncabezadoCierre2;
    private String strEncabezadoCierre3;
    private String strEncabezadoCierre4;
    private String strEncabezadoCierre5;
    private String strPieDePaginaCierre1;
    private String strPieDePaginaCierre2;
    private String strPieDePaginaCierre3;
    private String strPieDePaginaCierre4;
    private String strPieDePaginaCierre5;
    private String strGprsAPN;
    private String strGprsUsuario;
    private String strGprsPassword;
    private String strGprsPPPTimeout;
    private String strGprsRecibiendoTimeout;
    private String strGprsPPPPermanente;
    private String strGprsTCPPermanente;
    private String strGprsIPPrimaria;
    private String strGprsIPSecundaria;
    private String strGprsPuertoPrimario;
    private String strGprsPuertoSecundario;
    private String strGprsSSL;
    private String strDialupHostPrimario;
    private String strDialupHostSecundario;
    private String strDialupTimeoutRecarga;
    private String strDialupTimeoutCierre;
    private String strDialupTimeoutConsulta;
    private String strSimboloMoneda;
    private String strNumeroDecimales;
    private String strSimboloDecimal;
    private String strPassword;
    private String strFechaDLC;
    private String strVersionDLC;
    private String strEncabezadoActivacion1;
    private String strEncabezadoActivacion2;
    private String strEncabezadoActivacion3;
    private String strEncabezadoActivacion4;
    private String strEncabezadoActivacion5;
    private String strPiePaginaActivacion1;
    private String strPiePaginaActivacion2;
    private String strPiePaginaActivacion3;
    private String strPiePaginaActivacion4;
    private String strPiePaginaActivacion5;
    private String strEncabezadoSaldo1;
    private String strEncabezadoSaldo2;
    private String strEncabezadoSaldo3;
    private String strPiePaginaSaldo1;
    private String strPiePaginaSaldo2;
    private String strPiePaginaSaldo3;
    private int iNumOperadoras;
    private String strCertificadoSSL;


    public InfoConfiguracion()
    {
    }

    /**
     *
     * @param isoMsg1
     * @param isoMsg2
     * @param isoMsg3
     * @throws Exception
     */
    public InfoConfiguracion(ISOMensaje isoMsg1, ISOMensaje isoMsg2, ISOMensaje isoMsg3) throws Exception
    {
        generarDatosDesdeMensajeISO(isoMsg1, isoMsg2, isoMsg3);
    }

    /**
     *
     * @return
     */
    public int getiNumOperadoras()
    {
        return iNumOperadoras;
    }

    public void setiNumOperadoras(int iNumOperadoras)
    {
        this.iNumOperadoras = iNumOperadoras;
    }

    public String getStrCertificadoSSL()
    {
        return strCertificadoSSL;
    }

    public void setStrCertificadoSSL(String strCertificadoSSL)
    {
        this.strCertificadoSSL = strCertificadoSSL;
    }

    public String getStrDialupHostPrimario()
    {
        return strDialupHostPrimario;
    }

    public void setStrDialupHostPrimario(String strDialupHostPrimario)
    {
        this.strDialupHostPrimario = strDialupHostPrimario;
    }

    public String getStrDialupHostSecundario()
    {
        return strDialupHostSecundario;
    }

    public void setStrDialupHostSecundario(String strDialupHostSecundario)
    {
        this.strDialupHostSecundario = strDialupHostSecundario;
    }

    public String getStrDialupTimeoutCierre()
    {
        return strDialupTimeoutCierre;
    }

    public void setStrDialupTimeoutCierre(String strDialupTimeoutCierre)
    {
        this.strDialupTimeoutCierre = strDialupTimeoutCierre;
    }

    public String getStrDialupTimeoutConsulta()
    {
        return strDialupTimeoutConsulta;
    }

    public void setStrDialupTimeoutConsulta(String strDialupTimeoutConsulta)
    {
        this.strDialupTimeoutConsulta = strDialupTimeoutConsulta;
    }

    public String getStrDialupTimeoutRecarga()
    {
        return strDialupTimeoutRecarga;
    }

    public void setStrDialupTimeoutRecarga(String strDialupTimeoutRecarga)
    {
        this.strDialupTimeoutRecarga = strDialupTimeoutRecarga;
    }

    public String getStrDireccionEntidad()
    {
        return strDireccionEntidad;
    }

    public void setStrDireccionEntidad(String strDireccionEntidad)
    {
        this.strDireccionEntidad = strDireccionEntidad;
    }

    public String getStrEncabezadoCierre1()
    {
        return strEncabezadoCierre1;
    }

    public void setStrEncabezadoCierre1(String strEncabezadoCierre1)
    {
        this.strEncabezadoCierre1 = strEncabezadoCierre1;
    }

    public String getStrEncabezadoCierre2()
    {
        return strEncabezadoCierre2;
    }

    public void setStrEncabezadoCierre2(String strEncabezadoCierre2)
    {
        this.strEncabezadoCierre2 = strEncabezadoCierre2;
    }

    public String getStrEncabezadoCierre3()
    {
        return strEncabezadoCierre3;
    }

    public void setStrEncabezadoCierre3(String strEncabezadoCierre3)
    {
        this.strEncabezadoCierre3 = strEncabezadoCierre3;
    }

    public String getStrEncabezadoCierre4()
    {
        return strEncabezadoCierre4;
    }

    public void setStrEncabezadoCierre4(String strEncabezadoCierre4)
    {
        this.strEncabezadoCierre4 = strEncabezadoCierre4;
    }

    public String getStrEncabezadoCierre5()
    {
        return strEncabezadoCierre5;
    }

    public void setStrEncabezadoCierre5(String strEncabezadoCierre5)
    {
        this.strEncabezadoCierre5 = strEncabezadoCierre5;
    }

    public String getStrEncabezadoSaldo1()
    {
        return strEncabezadoSaldo1;
    }

    public void setStrEncabezadoSaldo1(String strEncabezadoSaldo1)
    {
        this.strEncabezadoSaldo1 = strEncabezadoSaldo1;
    }

    public String getStrEncabezadoSaldo2()
    {
        return strEncabezadoSaldo2;
    }

    public void setStrEncabezadoSaldo2(String strEncabezadoSaldo2)
    {
        this.strEncabezadoSaldo2 = strEncabezadoSaldo2;
    }

    public String getStrEncabezadoSaldo3()
    {
        return strEncabezadoSaldo3;
    }

    public void setStrEncabezadoSaldo3(String strEncabezadoSaldo3)
    {
        this.strEncabezadoSaldo3 = strEncabezadoSaldo3;
    }

    public String getStrFechaDLC()
    {
        return strFechaDLC;
    }

    public void setStrFechaDLC(String strFechaDLC)
    {
        this.strFechaDLC = strFechaDLC;
    }

    public String getStrGprsAPN()
    {
        return strGprsAPN;
    }

    public void setStrGprsAPN(String strGprsAPN)
    {
        this.strGprsAPN = strGprsAPN;
    }

    public String getStrGprsIPPrimaria()
    {
        return strGprsIPPrimaria;
    }

    public void setStrGprsIPPrimaria(String strGprsIPPrimaria)
    {
        this.strGprsIPPrimaria = strGprsIPPrimaria;
    }

    public String getStrGprsIPSecundaria()
    {
        return strGprsIPSecundaria;
    }

    public void setStrGprsIPSecundaria(String strGprsIPSecundaria)
    {
        this.strGprsIPSecundaria = strGprsIPSecundaria;
    }

    public String getStrGprsPPPPermanente()
    {
        return strGprsPPPPermanente;
    }

    public void setStrGprsPPPPermanente(String strGprsPPPPermanente)
    {
        this.strGprsPPPPermanente = strGprsPPPPermanente;
    }

    public String getStrGprsPPPTimeout()
    {
        return strGprsPPPTimeout;
    }

    public void setStrGprsPPPTimeout(String strGprsPPPTimeout)
    {
        this.strGprsPPPTimeout = strGprsPPPTimeout;
    }

    public String getStrGprsPassword()
    {
        return strGprsPassword;
    }

    public void setStrGprsPassword(String strGprsPassword)
    {
        this.strGprsPassword = strGprsPassword;
    }

    public String getStrGprsPuertoPrimario()
    {
        return strGprsPuertoPrimario;
    }

    public void setStrGprsPuertoPrimario(String strGprsPuertoPrimario)
    {
        this.strGprsPuertoPrimario = strGprsPuertoPrimario;
    }

    public String getStrGprsPuertoSecundario()
    {
        return strGprsPuertoSecundario;
    }

    public void setStrGprsPuertoSecundario(String strGprsPuertoSecundario)
    {
        this.strGprsPuertoSecundario = strGprsPuertoSecundario;
    }

    public String getStrGprsRecibiendoTimeout()
    {
        return strGprsRecibiendoTimeout;
    }

    public void setStrGprsRecibiendoTimeout(String strGprsRecibiendoTimeout)
    {
        this.strGprsRecibiendoTimeout = strGprsRecibiendoTimeout;
    }

    public String getStrGprsSSL()
    {
        return strGprsSSL;
    }

    public void setStrGprsSSL(String strGprsSSL)
    {
        this.strGprsSSL = strGprsSSL;
    }

    public String getStrGprsTCPPermanente()
    {
        return strGprsTCPPermanente;
    }

    public void setStrGprsTCPPermanente(String strGprsTCPPermanente)
    {
        this.strGprsTCPPermanente = strGprsTCPPermanente;
    }

    public String getStrGprsUsuario()
    {
        return strGprsUsuario;
    }

    public void setStrGprsUsuario(String strGprsUsuario)
    {
        this.strGprsUsuario = strGprsUsuario;
    }

    public String getStrNombreEntidad()
    {
        return strNombreEntidad;
    }

    public void setStrNombreEntidad(String strNombreEntidad)
    {
        this.strNombreEntidad = strNombreEntidad;
    }

    public String getStrNroIdentificacion()
    {
        return strNroIdentificacion;
    }

    public void setStrNroIdentificacion(String strNroIdentificacion)
    {
        this.strNroIdentificacion = strNroIdentificacion;
    }

    public String getStrNumeroDecimales()
    {
        return strNumeroDecimales;
    }

    public void setStrNumeroDecimales(String strNumeroDecimales)
    {
        this.strNumeroDecimales = strNumeroDecimales;
    }

    public String getStrPassword()
    {
        return strPassword;
    }

    public void setStrPassword(String strPassword)
    {
        this.strPassword = strPassword;
    }

    public String getStrPieDePaginaCierre1()
    {
        return strPieDePaginaCierre1;
    }

    public void setStrPieDePaginaCierre1(String strPieDePaginaCierre1)
    {
        this.strPieDePaginaCierre1 = strPieDePaginaCierre1;
    }

    public String getStrPieDePaginaCierre2()
    {
        return strPieDePaginaCierre2;
    }

    public void setStrPieDePaginaCierre2(String strPieDePaginaCierre2)
    {
        this.strPieDePaginaCierre2 = strPieDePaginaCierre2;
    }

    public String getStrPieDePaginaCierre3()
    {
        return strPieDePaginaCierre3;
    }

    public void setStrPieDePaginaCierre3(String strPieDePaginaCierre3)
    {
        this.strPieDePaginaCierre3 = strPieDePaginaCierre3;
    }

    public String getStrPieDePaginaCierre4()
    {
        return strPieDePaginaCierre4;
    }

    public void setStrPieDePaginaCierre4(String strPieDePaginaCierre4)
    {
        this.strPieDePaginaCierre4 = strPieDePaginaCierre4;
    }

    public String getStrPieDePaginaCierre5()
    {
        return strPieDePaginaCierre5;
    }

    public void setStrPieDePaginaCierre5(String strPieDePaginaCierre5)
    {
        this.strPieDePaginaCierre5 = strPieDePaginaCierre5;
    }

    public String getStrPiePaginaActivacion1()
    {
        return strPiePaginaActivacion1;
    }

    public void setStrPiePaginaActivacion1(String strPiePaginaActivacion1)
    {
        this.strPiePaginaActivacion1 = strPiePaginaActivacion1;
    }

    public String getStrPiePaginaActivacion2()
    {
        return strPiePaginaActivacion2;
    }

    public void setStrPiePaginaActivacion2(String strPiePaginaActivacion2)
    {
        this.strPiePaginaActivacion2 = strPiePaginaActivacion2;
    }

    public String getStrPiePaginaActivacion3()
    {
        return strPiePaginaActivacion3;
    }

    public void setStrPiePaginaActivacion3(String strPiePaginaActivacion3)
    {
        this.strPiePaginaActivacion3 = strPiePaginaActivacion3;
    }

    public String getStrPiePaginaActivacion4()
    {
        return strPiePaginaActivacion4;
    }

    public void setStrPiePaginaActivacion4(String strPiePaginaActivacion4)
    {
        this.strPiePaginaActivacion4 = strPiePaginaActivacion4;
    }

    public String getStrPiePaginaActivacion5()
    {
        return strPiePaginaActivacion5;
    }

    public void setStrPiePaginaActivacion5(String strPiePaginaActivacion5)
    {
        this.strPiePaginaActivacion5 = strPiePaginaActivacion5;
    }

    public String getStrPiePaginaSaldo1()
    {
        return strPiePaginaSaldo1;
    }

    public void setStrPiePaginaSaldo1(String strPiePaginaSaldo1)
    {
        this.strPiePaginaSaldo1 = strPiePaginaSaldo1;
    }

    public String getStrPiePaginaSaldo2()
    {
        return strPiePaginaSaldo2;
    }

    public void setStrPiePaginaSaldo2(String strPiePaginaSaldo2)
    {
        this.strPiePaginaSaldo2 = strPiePaginaSaldo2;
    }

    public String getStrPiePaginaSaldo3()
    {
        return strPiePaginaSaldo3;
    }

    public void setStrPiePaginaSaldo3(String strPiePaginaSaldo3)
    {
        this.strPiePaginaSaldo3 = strPiePaginaSaldo3;
    }

    public String getStrSimboloDecimal()
    {
        return strSimboloDecimal;
    }

    public void setStrSimboloDecimal(String strSimboloDecimal)
    {
        this.strSimboloDecimal = strSimboloDecimal;
    }

    public String getStrSimboloMoneda()
    {
        return strSimboloMoneda;
    }

    public void setStrSimboloMoneda(String strSimboloMoneda)
    {
        this.strSimboloMoneda = strSimboloMoneda;
    }

    public String getStrTelefonoEntidad()
    {
        return strTelefonoEntidad;
    }

    public void setStrTelefonoEntidad(String strTelefonoEntidad)
    {
        this.strTelefonoEntidad = strTelefonoEntidad;
    }

    public String getStrVersionDLC()
    {
        return strVersionDLC;
    }

    public void setStrVersionDLC(String strVersionDLC)
    {
        this.strVersionDLC = strVersionDLC;
    }

    public String getStrEncabezadoActivacion1()
    {
        return strEncabezadoActivacion1;
    }

    public void setStrEncabezadoActivacion1(String strEncabezadoActivacion1)
    {
        this.strEncabezadoActivacion1 = strEncabezadoActivacion1;
    }

    public String getStrEncabezadoActivacion2()
    {
        return strEncabezadoActivacion2;
    }

    public void setStrEncabezadoActivacion2(String strEncabezadoActivacion2)
    {
        this.strEncabezadoActivacion2 = strEncabezadoActivacion2;
    }

    public String getStrEncabezadoActivacion3()
    {
        return strEncabezadoActivacion3;
    }

    public void setStrEncabezadoActivacion3(String strEncabezadoActivacion3)
    {
        this.strEncabezadoActivacion3 = strEncabezadoActivacion3;
    }

    public String getStrEncabezadoActivacion4()
    {
        return strEncabezadoActivacion4;
    }

    public void setStrEncabezadoActivacion4(String strEncabezadoActivacion4)
    {
        this.strEncabezadoActivacion4 = strEncabezadoActivacion4;
    }

    public String getStrEncabezadoActivacion5()
    {
        return strEncabezadoActivacion5;
    }

    public void setStrEncabezadoActivacion5(String strEncabezadoActivacion5)
    {
        this.strEncabezadoActivacion5 = strEncabezadoActivacion5;
    }

    public void generarDatosDesdeMensajeISO(ISOMensaje isoMsg1, ISOMensaje isoMsg2, ISOMensaje isoMsg3) throws Exception
    {
        byte bCampoISO1[] = isoMsg1.getCampoISOenBytes(60);
        byte bufferLocal[] = new byte[1024];
        int iPos = 6;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 25);
        strNombreEntidad = new String(bufferLocal, 0, 25);
        iPos += 25;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 18);
        strNroIdentificacion = new String(bufferLocal, 0, 18);
        iPos += 18;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 40);
        System.out.println("bufferLocal :" + bufferLocal.toString());
        strDireccionEntidad = new String(bufferLocal, 0, 40);
        iPos += 40;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 20);
        strTelefonoEntidad = new String(bufferLocal, 0, 20);
        iPos += 24;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 50);
        strEncabezadoCierre1 = new String(bufferLocal, 0, 50);
        iPos += 50;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 50);
        strEncabezadoCierre2 = new String(bufferLocal, 0, 50);
        iPos += 50;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 50);
        strEncabezadoCierre3 = new String(bufferLocal, 0, 50);
        iPos += 50;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 50);
        strEncabezadoCierre4 = new String(bufferLocal, 0, 50);
        iPos += 50;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 50);
        strEncabezadoCierre5 = new String(bufferLocal, 0, 50);
        iPos += 50;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 50);
        strPieDePaginaCierre1 = new String(bufferLocal, 0, 50);
        iPos += 50;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 50);
        strPieDePaginaCierre2 = new String(bufferLocal, 0, 50);
        iPos += 50;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 50);
        strPieDePaginaCierre3 = new String(bufferLocal, 0, 50);
        iPos += 50;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 50);
        strPieDePaginaCierre4 = new String(bufferLocal, 0, 50);
        iPos += 50;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 50);
        strPieDePaginaCierre5 = new String(bufferLocal, 0, 50);
        iPos += 54;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 50);
        strGprsAPN = new String(bufferLocal, 0, 50);
        iPos += 50;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 50);
        strGprsUsuario = new String(bufferLocal, 0, 50);
        iPos += 50;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 50);
        strGprsPassword = new String(bufferLocal, 0, 50);
        iPos += 50;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 2);
        strGprsPPPTimeout = new String(bufferLocal, 0, 2);
        iPos += 2;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 2);
        strGprsRecibiendoTimeout = new String(bufferLocal, 0, 2);
        iPos += 2;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 1);
        strGprsPPPPermanente = new String(bufferLocal, 0, 1);
        iPos++;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 1);
        strGprsTCPPermanente = new String(bufferLocal, 0, 1);
        iPos++;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 15);
        strGprsIPPrimaria = new String(bufferLocal, 0, 15);
        iPos += 15;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 15);
        strGprsIPSecundaria = new String(bufferLocal, 0, 15);
        iPos += 15;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 5);
        strGprsPuertoPrimario = new String(bufferLocal, 0, 5);
        iPos += 5;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 5);
        strGprsPuertoSecundario = new String(bufferLocal, 0, 5);
        iPos += 5;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 1);
        strGprsSSL = new String(bufferLocal, 0, 1);
        iPos += 5;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 20);
        strDialupHostPrimario = new String(bufferLocal, 0, 20);
        iPos += 20;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 20);
        strDialupHostSecundario = new String(bufferLocal, 0, 20);
        iPos += 20;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 2);
        strDialupTimeoutRecarga = new String(bufferLocal, 0, 2);
        iPos += 2;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 2);
        strDialupTimeoutCierre = new String(bufferLocal, 0, 2);
        iPos += 2;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 2);
        strDialupTimeoutConsulta = new String(bufferLocal, 0, 2);
        iPos += 6;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 3);
        strSimboloMoneda = new String(bufferLocal, 0, 3);
        iPos += 3;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 1);
        strNumeroDecimales = new String(bufferLocal, 0, 1);
        iPos++;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 1);
        strSimboloDecimal = new String(bufferLocal, 0, 1);
        iPos++;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 6);
        strPassword = new String(bufferLocal, 0, 6);
        iPos += 6;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 14);
        strFechaDLC = new String(bufferLocal, 0, 14);
        iPos += 14;
        System.arraycopy(bCampoISO1, iPos, bufferLocal, 0, 6);
        strVersionDLC = new String(bufferLocal, 0, 6);
        iPos += 6;
        byte bCampoISO2[] = isoMsg2.getCampoISOenBytes(61);
        iPos = 6;
        System.arraycopy(bCampoISO2, iPos, bufferLocal, 0, 50);
        strEncabezadoActivacion1 = new String(bufferLocal, 0, 50);
        iPos += 50;
        System.arraycopy(bCampoISO2, iPos, bufferLocal, 0, 50);
        strEncabezadoActivacion2 = new String(bufferLocal, 0, 50);
        iPos += 50;
        System.arraycopy(bCampoISO2, iPos, bufferLocal, 0, 50);
        strEncabezadoActivacion3 = new String(bufferLocal, 0, 50);
        iPos += 50;
        System.arraycopy(bCampoISO2, iPos, bufferLocal, 0, 50);
        strEncabezadoActivacion4 = new String(bufferLocal, 0, 50);
        iPos += 50;
        System.arraycopy(bCampoISO2, iPos, bufferLocal, 0, 50);
        strEncabezadoActivacion5 = new String(bufferLocal, 0, 50);
        iPos += 50;
        System.arraycopy(bCampoISO2, iPos, bufferLocal, 0, 50);
        strPiePaginaActivacion1 = new String(bufferLocal, 0, 50);
        iPos += 50;
        System.arraycopy(bCampoISO2, iPos, bufferLocal, 0, 50);
        strPiePaginaActivacion2 = new String(bufferLocal, 0, 50);
        iPos += 50;
        System.arraycopy(bCampoISO2, iPos, bufferLocal, 0, 50);
        strPiePaginaActivacion3 = new String(bufferLocal, 0, 50);
        iPos += 50;
        System.arraycopy(bCampoISO2, iPos, bufferLocal, 0, 50);
        strPiePaginaActivacion4 = new String(bufferLocal, 0, 50);
        iPos += 50;
        System.arraycopy(bCampoISO2, iPos, bufferLocal, 0, 50);
        strPiePaginaActivacion5 = new String(bufferLocal, 0, 50);
        iPos += 54;
        System.arraycopy(bCampoISO2, iPos, bufferLocal, 0, 50);
        strEncabezadoSaldo1 = new String(bufferLocal, 0, 50);
        iPos += 50;
        System.arraycopy(bCampoISO2, iPos, bufferLocal, 0, 50);
        strEncabezadoSaldo2 = new String(bufferLocal, 0, 50);
        iPos += 50;
        System.arraycopy(bCampoISO2, iPos, bufferLocal, 0, 50);
        strEncabezadoSaldo3 = new String(bufferLocal, 0, 50);
        iPos += 50;
        System.arraycopy(bCampoISO2, iPos, bufferLocal, 0, 50);
        strPiePaginaSaldo1 = new String(bufferLocal, 0, 50);
        iPos += 50;
        System.arraycopy(bCampoISO2, iPos, bufferLocal, 0, 50);
        strPiePaginaSaldo2 = new String(bufferLocal, 0, 50);
        iPos += 50;
        System.arraycopy(bCampoISO2, iPos, bufferLocal, 0, 48);
        strPiePaginaSaldo3 = new String(bufferLocal, 0, 48);
        iPos += 48;
        byte bCampoISO3[] = isoMsg3.getCampoISOenBytes(62);
        iPos = 6;
        System.arraycopy(bCampoISO3, iPos, bufferLocal, 0, 2);
        iNumOperadoras = Integer.parseInt(new String(bufferLocal, 0, 2));
        System.out.println("************** -------------------- iNumOperadoras = " + iNumOperadoras);
        iPos += 2;
        if(strGprsSSL.equalsIgnoreCase("S"))
        {
            byte bCampoISO3_63[] = isoMsg3.getCampoISOenBytes(63);
            iPos = 6;
            System.arraycopy(bCampoISO3_63, iPos, bufferLocal, 0, 2);
            iNumOperadoras = Integer.parseInt(new String(bufferLocal, 0, 2));
            iPos += 2;
        }
    }

}
