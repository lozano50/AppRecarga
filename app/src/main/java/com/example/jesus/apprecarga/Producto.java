package com.example.jesus.apprecarga;

/**
 * Created by provar-3 on 1/07/16.
 */
public class Producto {

    public Producto()
    {
        tipoProducto = "";      //se agrego este nuevo atributo
        idProducto = 0;
        nombreProducto = "";
        monto = 0;
    }

    public Producto(String tipoProd, int idProducto, String nombreProducto, int monto)
    {
        tipoProducto = tipoProd;    //se agrego este nuevo atributo
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.monto = monto;
    }

    public void setIdProducto(int idProducto)
    {
        this.idProducto = idProducto;
    }

    public void setNombreProducto(String nombreProducto)
    {
        this.nombreProducto = nombreProducto;
    }

    public void setMonto(int Monto)
    {
        monto = monto;
    }
    public String getTipoProducto()
    {
        return tipoProducto;
    }
    public int getIdProducto()
    {
        return idProducto;
    }

    public String getNombreProducto()
    {
        return nombreProducto;
    }

    public int getMonto()
    {
        return monto;
    }
    private String tipoProducto;  //se agrego este nuevo atributo
    private int idProducto;
    private String nombreProducto;
    private int monto;

}
