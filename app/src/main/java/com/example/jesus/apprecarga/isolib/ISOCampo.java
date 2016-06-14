package com.example.jesus.apprecarga.isolib;

/**
 * Created by provar-3 on 8/06/16.
 */
public class ISOCampo {

    private int Id;
    private String nombreCampo;
    private int largo;
    private int formato[][];
    private byte valor[];


    public ISOCampo()
    {
    }

    public ISOCampo(int Id, String nombreCampo, int largo, int formato[][], byte valor[])
    {
        this.Id = Id;
        this.nombreCampo = nombreCampo;
        this.largo = largo;
        this.formato = formato;
        this.valor = valor;
    }

    public int getId()
    {
        return Id;
    }

    public void setId(int Id)
    {
        this.Id = Id;
    }

    public int[][] getFormato()
    {
        return formato;
    }

    public void setFormato(int formato[][])
    {
        this.formato = formato;
    }

    public int getLargo()
    {
        return largo;
    }

    public void setLargo(int largo)
    {
        this.largo = largo;
    }

    public String getNombreCampo()
    {
        return nombreCampo;
    }

    public void setNombreCampo(String nombreCampo)
    {
        this.nombreCampo = nombreCampo;
    }

    public byte[] getValor()
    {
        return valor;
    }

    public void setValor(byte valor[])
    {
        this.valor = valor;
    }



}
