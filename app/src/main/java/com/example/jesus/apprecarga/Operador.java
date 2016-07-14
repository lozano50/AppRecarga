package com.example.jesus.apprecarga;

import com.example.jesus.apprecarga.isolib.ISOMensaje;

import java.util.Vector;

/**
 * Created by provar-3 on 1/07/16.
 */
public class Operador {

    private int iNumOperadora;
    private String strEncabezadoRecarga1;
    private String strEncabezadoRecarga2;
    private String strEncabezadoRecarga3;
    private String strEncabezadoRecarga4;
    private String strEncabezadoRecarga5;
    private String strPiePaginaRecarga1;
    private String strPiePaginaRecarga2;
    private String strPiePaginaRecarga3;
    private String strPiePaginaRecarga4;
    private String strPiePaginaRecarga5;
    private String strIdLogo;
    private String strIdOperadora;
    private String strNombreOperadora;
    private String strTipoProtocolo;
    private String strPrefijo;
    private int iLargoMinTelefono;
    private int iLargoMaxTelefono;
    private String strModoRecarga;
    private int iTotalProductos;
    private Vector vProductos;
    private int iMontoMinimo;
    private int iMontoMaximo;
    private int iMultiplicadorRecarga;

    public Operador()
    {
    }

    public Operador(ISOMensaje isoMensaje)
    {   System.out.println("****** Constructor OPerador ************ ");
        generarDatosDesdeMensajeISO(isoMensaje);
    }

    public void generarDatosDesdeMensajeISO(ISOMensaje isoMensaje)
    { System.out.println("****** generarDatosDesdeMensajeISO de OPerador ************ ");
        System.out.println("Tamano de isoMensaje.getCampoISOenBytes(60) = " + isoMensaje.getCampoISOenBytes(60).length);
        //AppUtil.dumpMemory(isoMensaje.getCampoISOenBytes(60), isoMensaje.getCampoISOenBytes(60).length);  //BORRAR
        System.out.println("Antes de generarDatosDesdeMensajeISO Antes de isoMensaje.getCampoISOenBytes(60)");
        byte bCampoISO[] = isoMensaje.getCampoISOenBytes(60); System.out.println("generarDatosDesdeMensajeISO despues de isoMensaje.getCampoISOenBytes(60)");
        byte bufferLocal[] = new byte[1024];
        System.arraycopy(bCampoISO, 6, bufferLocal, 0, 2);
        iNumOperadora = Integer.parseInt(new String(bufferLocal, 0, 2)); System.out.println("iNumOperadora = " + iNumOperadora);
        System.arraycopy(bCampoISO, 12, bufferLocal, 0, 50);
        strEncabezadoRecarga1 = new String(bufferLocal, 0, 50); System.out.println("strEncabezadoRecarga1 = " + strEncabezadoRecarga1);
        System.arraycopy(bCampoISO, 62, bufferLocal, 0, 50);
        strEncabezadoRecarga2 = new String(bufferLocal, 0, 50); System.out.println("strEncabezadoRecarga2 = " + strEncabezadoRecarga2);
        System.arraycopy(bCampoISO, 112, bufferLocal, 0, 50);
        strEncabezadoRecarga3 = new String(bufferLocal, 0, 50); System.out.println("strEncabezadoRecarga3 = " + strEncabezadoRecarga3);
        System.arraycopy(bCampoISO, 162, bufferLocal, 0, 50);
        strEncabezadoRecarga4 = new String(bufferLocal, 0, 50); System.out.println("strEncabezadoRecarga4 = " + strEncabezadoRecarga4);
        System.arraycopy(bCampoISO, 212, bufferLocal, 0, 50);
        strEncabezadoRecarga5 = new String(bufferLocal, 0, 50); System.out.println("strEncabezadoRecarga5 = " + strEncabezadoRecarga5);
        System.arraycopy(bCampoISO, 262, bufferLocal, 0, 50);
        strPiePaginaRecarga1 = new String(bufferLocal, 0, 50);  System.out.println("strPiePaginaRecarga1 = " + strPiePaginaRecarga1);
        System.arraycopy(bCampoISO, 312, bufferLocal, 0, 50);
        strPiePaginaRecarga2 = new String(bufferLocal, 0, 50);  System.out.println("strPiePaginaRecarga2 = " + strPiePaginaRecarga2);
        System.arraycopy(bCampoISO, 362, bufferLocal, 0, 50);
        strPiePaginaRecarga3 = new String(bufferLocal, 0, 50); System.out.println("strPiePaginaRecarga3 = " + strPiePaginaRecarga3);
        System.arraycopy(bCampoISO, 412, bufferLocal, 0, 50);
        strPiePaginaRecarga4 = new String(bufferLocal, 0, 50); System.out.println("strPiePaginaRecarga4 = " + strPiePaginaRecarga4);
        System.arraycopy(bCampoISO, 462, bufferLocal, 0, 50);
        strPiePaginaRecarga5 = new String(bufferLocal, 0, 50); System.out.println("strPiePaginaRecarga5 = " + strPiePaginaRecarga5);
        System.arraycopy(bCampoISO, 516, bufferLocal, 0, 2);
        strIdLogo = new String(bufferLocal, 0, 2);             System.out.println("strIdLogo = " + strIdLogo);
        System.arraycopy(bCampoISO, 518, bufferLocal, 0, 2);
        System.out.println("strIdOperadora = " + strIdOperadora);
        strIdOperadora = new String(bufferLocal, 0, 2);
        System.arraycopy(bCampoISO, 520, bufferLocal, 0, 15);
        strNombreOperadora = new String(bufferLocal, 0, 15);
        System.out.println("Clase Operador setear el nombre operadora " + strNombreOperadora);
        System.arraycopy(bCampoISO, 535, bufferLocal, 0, 2);
        strTipoProtocolo = new String(bufferLocal, 0, 2);
        System.out.println("Tipo Protocolo: " + strTipoProtocolo);
        System.arraycopy(bCampoISO, 537, bufferLocal, 0, 5);
        strPrefijo = new String(bufferLocal, 0, 5);
        System.out.println("Prefijo: " + strPrefijo);
        System.arraycopy(bCampoISO, 542, bufferLocal, 0, 2);
        iLargoMinTelefono = Integer.parseInt(new String(bufferLocal, 0, 2));
        System.out.println("Largo Min Telefono: " + iLargoMinTelefono);
        System.arraycopy(bCampoISO, 544, bufferLocal, 0, 2);
        iLargoMaxTelefono = Integer.parseInt(new String(bufferLocal, 0, 2));
        System.out.println("Largo max Telefono: " + iLargoMaxTelefono);
        System.arraycopy(bCampoISO, 546, bufferLocal, 0, 1);
        strModoRecarga = new String(bufferLocal, 0, 1);
        System.out.println("Clase Operador setear el Modo recarga " + strModoRecarga);
        System.arraycopy(bCampoISO, 547, bufferLocal, 0, 2);
        iTotalProductos = Integer.parseInt(new String(bufferLocal, 0, 2));
        System.out.println("Clase Operador setear el total de Productos " + iTotalProductos);
        //******nuevo
        System.arraycopy(bCampoISO, 549, bufferLocal, 0, 24 * iTotalProductos);
        String xxProductos = new String(bufferLocal, 0, 24 * iTotalProductos);
        System.out.println("Productos " + xxProductos);
        //**************************************************************************
        int iDesplazamiento = 0;
        //if(strModoRecarga.equals("D"))
        //{
        System.out.println("------------------------------------------------------------------------");
        vProductos = new Vector();
        for(int i = 0; i < iTotalProductos; i++)
        {
            System.arraycopy(bCampoISO, 549 + iDesplazamiento, bufferLocal, 0, 1);
            String tipoProd = new String(bufferLocal, 0, 1);
            System.arraycopy(bCampoISO, 550 + iDesplazamiento, bufferLocal, 0, 2);
            int idProd = Integer.parseInt(new String(bufferLocal, 0, 2));
            System.arraycopy(bCampoISO, 552 + iDesplazamiento, bufferLocal, 0, 15);
            String nomProd = new String(bufferLocal, 0, 15);
            System.arraycopy(bCampoISO, 567 + iDesplazamiento, bufferLocal, 0, 6);
            int montoProd = Integer.parseInt(new String(bufferLocal, 0, 6));
            vProductos.addElement(new Producto(tipoProd, idProd, nomProd, montoProd));
            System.out.println("Tipo Producto --> " + i + ": " + ((Producto)vProductos.elementAt(i)).getNombreProducto());
//                System.out.println("Id Producto " + i + ": " +  idProd);
//                System.out.println("Nombre Producto " + i + ": " +  nomProd);
//                System.out.println("Monto Producto " + i + ": " +  montoProd);
            iDesplazamiento += 24;
        }
        System.out.println("------------------------------------------------------------------------");
        for(int i = 1; i < vProductos.size(); i++)
        {
            Producto prodAux = (Producto)vProductos.elementAt(i);
            int j;
            for(j = i - 1; j >= 0 && ((Producto)vProductos.elementAt(j)).getMonto() > prodAux.getMonto(); j--)
                vProductos.setElementAt(vProductos.elementAt(j), j + 1);

            vProductos.setElementAt(prodAux, j + 1);
        }

        iDesplazamiento += 4;
        //}


        //int iPos = 553 + iDesplazamiento;
        int iPos = 549 + iDesplazamiento;
        if(strModoRecarga.equals("R"))  //dejaremos igual a como estaba pero este tipo de producto
        //se deberia manejar en cada producto y no en el operador
        {
            System.arraycopy(bCampoISO, iPos, bufferLocal, 0, 7);
            iMontoMinimo = Integer.parseInt(new String(bufferLocal, 0, 7));
            iPos += 7;
            System.arraycopy(bCampoISO, iPos, bufferLocal, 0, 7);
            iMontoMaximo = Integer.parseInt(new String(bufferLocal, 0, 7));
            iPos += 7;
            System.arraycopy(bCampoISO, iPos, bufferLocal, 0, 7);
            iMultiplicadorRecarga = Integer.parseInt(new String(bufferLocal, 0, 7));
        }
        System.out.println("monto minimo " + iMontoMinimo);
        System.out.println("monto maximo " + iMontoMaximo);
        System.out.println("Multiplicador " + iMultiplicadorRecarga);
    }


    public int getiLargoMaxTelefono()
    {
        return iLargoMaxTelefono;
    }

    public void setiLargoMaxTelefono(int iLargoMaxTelefono)
    {
        this.iLargoMaxTelefono = iLargoMaxTelefono;
    }

    public int getiLargoMinTelefono()
    {
        return iLargoMinTelefono;
    }

    public void setiLargoMinTelefono(int iLargoMinTelefono)
    {
        this.iLargoMinTelefono = iLargoMinTelefono;
    }

    public int getiMontoMaximo()
    {
        return iMontoMaximo;
    }

    public void setiMontoMaximo(int iMontoMaximo)
    {
        this.iMontoMaximo = iMontoMaximo;
    }

    public int getiMontoMinimo()
    {
        return iMontoMinimo;
    }

    public void setiMontoMinimo(int iMontoMinimo)
    {
        this.iMontoMinimo = iMontoMinimo;
    }

    public int getiMultiplicadorRecarga()
    {
        return iMultiplicadorRecarga;
    }

    public void setiMultiplicadorRecarga(int iMultiplicadorRecarga)
    {
        this.iMultiplicadorRecarga = iMultiplicadorRecarga;
    }

    public int getiNumOperadora()
    {
        return iNumOperadora;
    }

    public void setiNumOperadora(int iNumOperadora)
    {
        this.iNumOperadora = iNumOperadora;
    }

    public int getiTotalProductos()
    {
        return iTotalProductos;
    }

    public void setiTotalProductos(int iTotalProductos)
    {
        this.iTotalProductos = iTotalProductos;
    }

    public String getStrEncabezadoRecarga1()
    {
        return strEncabezadoRecarga1;
    }

    public void setStrEncabezadoRecarga1(String strEncabezadoRecarga1)
    {
        this.strEncabezadoRecarga1 = strEncabezadoRecarga1;
    }

    public String getStrEncabezadoRecarga2()
    {
        return strEncabezadoRecarga2;
    }

    public void setStrEncabezadoRecarga2(String strEncabezadoRecarga2)
    {
        this.strEncabezadoRecarga2 = strEncabezadoRecarga2;
    }

    public String getStrEncabezadoRecarga3()
    {
        return strEncabezadoRecarga3;
    }

    public void setStrEncabezadoRecarga3(String strEncabezadoRecarga3)
    {
        this.strEncabezadoRecarga3 = strEncabezadoRecarga3;
    }

    public String getStrEncabezadoRecarga4()
    {
        return strEncabezadoRecarga4;
    }

    public void setStrEncabezadoRecarga4(String strEncabezadoRecarga4)
    {
        this.strEncabezadoRecarga4 = strEncabezadoRecarga4;
    }

    public String getStrEncabezadoRecarga5()
    {
        return strEncabezadoRecarga5;
    }

    public void setStrEncabezadoRecarga5(String strEncabezadoRecarga5)
    {
        this.strEncabezadoRecarga5 = strEncabezadoRecarga5;
    }

    public String getStrIdLogo()
    {
        return strIdLogo;
    }

    public void setStrIdLogo(String strIdLogo)
    {
        this.strIdLogo = strIdLogo;
    }

    public String getStrIdOperadora()
    {
        return strIdOperadora;
    }

    public void setStrIdOperadora(String strIdOperadora)
    {
        this.strIdOperadora = strIdOperadora;
    }

    public String getStrModoRecarga()
    {
        return strModoRecarga;
    }

    public void setStrModoRecarga(String strModoRecarga)
    {
        this.strModoRecarga = strModoRecarga;
    }

    public String getStrNombreOperadora()
    {
        return strNombreOperadora;
    }

    public void setStrNombreOperadora(String strNombreOperadora)
    {
        this.strNombreOperadora = strNombreOperadora;
    }

    public String getStrPiePaginaRecarga1()
    {
        return strPiePaginaRecarga1;
    }

    public void setStrPiePaginaRecarga1(String strPiePaginaRecarga1)
    {
        this.strPiePaginaRecarga1 = strPiePaginaRecarga1;
    }

    public String getStrPiePaginaRecarga2()
    {
        return strPiePaginaRecarga2;
    }

    public void setStrPiePaginaRecarga2(String strPiePaginaRecarga2)
    {
        this.strPiePaginaRecarga2 = strPiePaginaRecarga2;
    }

    public String getStrPiePaginaRecarga3()
    {
        return strPiePaginaRecarga3;
    }

    public void setStrPiePaginaRecarga3(String strPiePaginaRecarga3)
    {
        this.strPiePaginaRecarga3 = strPiePaginaRecarga3;
    }

    public String getStrPiePaginaRecarga4()
    {
        return strPiePaginaRecarga4;
    }

    public void setStrPiePaginaRecarga4(String strPiePaginaRecarga4)
    {
        this.strPiePaginaRecarga4 = strPiePaginaRecarga4;
    }

    public String getStrPiePaginaRecarga5()
    {
        return strPiePaginaRecarga5;
    }

    public void setStrPiePaginaRecarga5(String strPiePaginaRecarga5)
    {
        this.strPiePaginaRecarga5 = strPiePaginaRecarga5;
    }

    public String getStrPrefijo()
    {
        return strPrefijo;
    }

    public void setStrPrefijo(String strPrefijo)
    {
        this.strPrefijo = strPrefijo;
    }

    public String getStrTipoProtocolo()
    {
        return strTipoProtocolo;
    }

    public void setStrTipoProtocolo(String strTipoProtocolo)
    {
        this.strTipoProtocolo = strTipoProtocolo;
    }

    public Vector getvProductos()
    {
        return vProductos;
    }

    public void setvProductos(Vector vProductos)
    {
        this.vProductos = vProductos;
    }




}
