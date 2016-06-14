package com.example.jesus.apprecarga.isolib;

import com.example.jesus.apprecarga.utils.Constantes;

import java.io.ByteArrayOutputStream;
import java.util.Vector;

/**
 * Created by provar-3 on 8/06/16.
 */
public class ISOMensaje {

    private String encabezado;
    private String tipoMensaje;
    private Vector campos;

    public ISOMensaje()
    {
        encabezado = "";
        tipoMensaje = "";
        campos = new Vector();
    }

    public ISOMensaje(byte bCadBytes[])
    {
        byte bufferLocal[] = new byte[1024];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int iNumCampo = 0;
        encabezado = "";
        tipoMensaje = "";
        campos = new Vector();
        System.arraycopy(bCadBytes, 2, bufferLocal, 0, 5);
        encabezado = hexString(bufferLocal, 0, 5);
        System.arraycopy(bCadBytes, 7, bufferLocal, 0, 2);
        tipoMensaje = hexString(bufferLocal, 0, 2);
        System.arraycopy(bCadBytes, 9, bufferLocal, 0, 8);
        int iByteOffset = 0;
        //System.out.println("Encabezado: " + encabezado);
        //System.out.println("Tipo de mensaje: " + tipoMensaje);
        for(byte i = 0; i < 8; i++)
        {
            for(byte j = 1; j <= 8; j++)
            {
                byte bDesplazamiento = (byte)(1 << 8 - j);
                byte bCampo = (byte)(bufferLocal[i] & bDesplazamiento);
                if(bCampo == 0)
                    continue;
                iNumCampo = j + i * 8;
                //System.out.println("Campos recibidos: " + iNumCampo);
                if(iNumCampo != 60 && iNumCampo != 61 && iNumCampo != 62 && iNumCampo != 63 && iNumCampo != 64)
                {
                    byte bCampoISO[] = new byte[Constantes.DEF_FORMATO[iNumCampo][0]];
                    System.arraycopy(bCadBytes, 17 + iByteOffset, bCampoISO, 0, Constantes.DEF_FORMATO[iNumCampo][0]);
                    setCampoISO(iNumCampo, Constantes.DEF_CAMPOS[iNumCampo], Constantes.DEF_FORMATO[iNumCampo][0], new int[][] {
                            new int[] {
                                    Constantes.DEF_FORMATO[iNumCampo][0], Constantes.DEF_FORMATO[iNumCampo][1]
                            }
                    }, bCampoISO);
                    iByteOffset += Constantes.DEF_FORMATO[iNumCampo][0];
                } else
                {
                    byte bLargoCampoISO[] = new byte[2];
                    System.arraycopy(bCadBytes, 17 + iByteOffset, bLargoCampoISO, 0, 2);
                    int iLargocampo = convertirByteAEntero(bLargoCampoISO);
                    byte bCampoISO[] = new byte[iLargocampo + 2];
                    System.arraycopy(bCadBytes, 17 + iByteOffset, bCampoISO, 0, iLargocampo + 2);
                    //System.out.println("Contenido campo: " + iNumCampo + " Longitud del campo: " + bCampoISO.length);
                    //if(bCampoISO.length >0) AppUtil.dumpMemory(bCampoISO, bCampoISO.length);
                    setCampoISO(iNumCampo, Constantes.DEF_CAMPOS[iNumCampo], bCampoISO.length, new int[][] {
                            new int[] {
                                    bCampoISO.length, Constantes.DEF_FORMATO[iNumCampo][1]
                            }
                    }, bCampoISO);
                    iByteOffset += iLargocampo + 2;
                }
            }

        }

    }

    public void setEncabezado(String encabezado)
    {
        this.encabezado = encabezado;
    }

    public void setTipoMensaje(String tipoMensaje)
    {
        this.tipoMensaje = tipoMensaje;
    }


    /**
     *
     *
     * @param Id
     * @param nombreCampo
     * @param largo
     * @param formato
     * @param valor
     */
    public void setCampoISO(int Id, String nombreCampo, int largo, int formato[][], String valor)
    {
        ISOCampo elem1 = new ISOCampo();
        ISOCampo elem2 = new ISOCampo();
        ISOCampo temp = new ISOCampo();

        borrarCampoISO(Id);

        byte bValor[] = convertirStringAByte(valor, formato);
        campos.addElement(new ISOCampo(Id, nombreCampo, largo, formato, bValor));

        for(int i = 0; i < campos.size(); i++)
        {
            for(int j = 0; j < campos.size() - 1; j++)
            {
                elem1 = (ISOCampo)campos.elementAt(j);
                elem2 = (ISOCampo)campos.elementAt(j + 1);

                if(elem1.getId() > elem2.getId())
                {
                    temp = elem2;
                    campos.setElementAt(elem1, j + 1);
                    campos.setElementAt(temp, j);
                }
            }

        }

    }

    public void setCampoISO(int Id, String nombreCampo, int largo, int formato[][], byte bValor[])
    {
        ISOCampo elem1 = new ISOCampo();
        ISOCampo elem2 = new ISOCampo();
        ISOCampo temp = new ISOCampo();
        borrarCampoISO(Id);
        campos.addElement(new ISOCampo(Id, nombreCampo, largo, formato, bValor));
        for(int i = 0; i < campos.size(); i++)
        {
            for(int j = 0; j < campos.size() - 1; j++)
            {
                elem1 = (ISOCampo)campos.elementAt(j);
                elem2 = (ISOCampo)campos.elementAt(j + 1);
                if(elem1.getId() > elem2.getId())
                {
                    temp = elem2;
                    campos.setElementAt(elem1, j + 1);
                    campos.setElementAt(temp, j);
                }
            }

        }

    }

    public void borrarCampoISO(int Id)
    {
        ISOCampo elem = new ISOCampo();
        int i = 0;
        do
        {
            if(i >= campos.size())
                break;
            elem = (ISOCampo)campos.elementAt(i);
            if(elem.getId() == Id)
            {
                campos.removeElementAt(i);
                break;
            }
            i++;
        } while(true);
    }

    public byte[] getCampoISOenBytes(int Id)
    {
        ISOCampo elem = new ISOCampo();
        boolean bExistecampo = false;
        int i = 0;
        do
        {
            if(i >= campos.size())
                break;
            elem = (ISOCampo)campos.elementAt(i);
            if(elem.getId() == Id)
            {
                bExistecampo = true;
                break;
            }
            i++;
        } while(true);
        return !bExistecampo ? null : elem.getValor();
    }

    public byte[] getEncabezadoEnBCD()
    {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        for(int i = 0; i < encabezado.length(); i += 2)
        {
            String cad = encabezado.substring(i, i + 2);
            int iByte = Integer.parseInt(cad, 16);
            bos.write(iByte);
        }

        return bos.toByteArray();
    }

    public byte[] getTipoMensajeEnBCD()
    {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        for(int i = 0; i < tipoMensaje.length(); i += 2)
        {
            String cad = tipoMensaje.substring(i, i + 2);
            int iByte = Integer.parseInt(cad, 16);
            bos.write(iByte);
        }

        return bos.toByteArray();
    }

    public byte[] getCamposenBytes()
    {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ISOCampo campo = new ISOCampo();
        if(!campos.isEmpty())
        {
            for(int i = 0; i < campos.size(); i++)
            {
                campo = (ISOCampo)campos.elementAt(i);
                byte bCampo[] = getCampoISOenBytes(campo.getId());
                bos.write(bCampo, 0, bCampo.length);
            }

        }
        return bos.toByteArray();
    }

    public byte[] getBitMap()
    {
        byte bBitMap[] = {
                0, 0, 0, 0, 0, 0, 0, 0
        };
        ISOCampo elem = new ISOCampo();
        for(int i = 0; i < campos.size(); i++)
        {
            elem = (ISOCampo)campos.elementAt(i);
            int Id = elem.getId();
            byte iModulo = (byte)(Id % 8);
            byte iParteEntera = (byte)(Id / 8);
            if(iModulo == 0)
            {
                iParteEntera--;
                iModulo = 8;
            }
            bBitMap[iParteEntera] |= 1 << 8 - iModulo;
        }

        return bBitMap;
    }

    public byte[] getMensajeISOEnBytes()
    {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int iLargo = getEncabezadoEnBCD().length + getTipoMensajeEnBCD().length + getBitMap().length + getCamposenBytes().length;
        bos.write(iLargo / 256);
        bos.write(iLargo % 256);
        bos.write(getEncabezadoEnBCD(), 0, getEncabezadoEnBCD().length);
        bos.write(getTipoMensajeEnBCD(), 0, getTipoMensajeEnBCD().length);
        bos.write(getBitMap(), 0, getBitMap().length);
        bos.write(getCamposenBytes(), 0, getCamposenBytes().length);
        return bos.toByteArray();
    }

    private byte[] convertirStringAByte(String valor, int formato[][])
    {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int incr = 0;
        int iPos = 0;
        for(int i = 0; i < formato.length; i++)
        {
            switch(formato[i][1])
            {
                case 1: // '\001'
                    incr = 2;
                    for(int j = iPos; j < iPos + formato[i][0] * incr; j += incr)
                    {
                        String cad = valor.substring(j, j + incr);
                        int iByte = Integer.parseInt(cad, 16);
                        bos.write(iByte);
                    }

                    break;

                case 2: // '\002'
                    incr = 1;
                    for(int j = iPos; j < iPos + formato[i][0] * incr; j += incr)
                    {
                        String cad = valor.substring(j, j + incr);
                        byte bByte[] = cad.getBytes();
                        bos.write(bByte, 0, bByte.length);
                    }

                    break;

                default:
                    incr = 2;
                    for(int j = iPos; j < iPos + formato[i][0] * incr; j += incr)
                    {
                        String cad = valor.substring(j, j + incr);
                        int iByte = Integer.parseInt(cad, 16);
                        bos.write(iByte);
                    }

                    break;
            }
            iPos += formato[i][0] * incr;
        }

        return bos.toByteArray();
    }

    private String hexString(byte buffer[], int offset, int length)
    {
        String AsciiHexa = "";
        for(int i = offset; i < length + offset; i++)
            AsciiHexa = AsciiHexa + hexString(buffer[i]);

        return AsciiHexa;
    }

    private String hexString(byte b)
    {
        int c = b;
        if(c < 0)
            c -= -256;
        String AsciiHexa = padleft(Integer.toHexString(c), 2, '0').toUpperCase();
        return AsciiHexa;
    }

    private String padleft(String s, int len, char c)
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

    private int convertirByteAEntero(byte bCadBytes[])
    {
        String strBytesBCD = null;
        int iRet = 0;
        strBytesBCD = hexString(bCadBytes, 0, bCadBytes.length);
        iRet = Integer.parseInt(strBytesBCD);
        return iRet;
    }

    public static void main(String args[])
    {
        ISOMensaje iso = new ISOMensaje();
        iso.setEncabezado("6000010002");
        iso.setTipoMensaje("0800");
        iso.setCampoISO(41, "ID del Terminal", 8, new int[][] {
                new int[] {
                        8, 2
                }
        }, "05050058");
        iso.setCampoISO(3, "Codigo del Proceso", 3, new int[][] {
                new int[] {
                        3, 1
                }
        }, "000101");
        iso.setCampoISO(11, "STAN", 3, new int[][] {
                new int[] {
                        3, 1
                }
        }, "000434");
        iso.setCampoISO(12, "Hora transaccion", 3, new int[][] {
                new int[] {
                        3, 1
                }
        }, "120714");
        iso.setCampoISO(13, "Fecha transaccion", 2, new int[][] {
                new int[] {
                        2, 1
                }
        }, "1010");
        iso.setCampoISO(22, "Tipo entrada al POS", 2, new int[][] {
                new int[] {
                        2, 1
                }
        }, "0010");
        iso.setCampoISO(24, "NII", 2, new int[][] {
                new int[] {
                        2, 1
                }
        }, "0000");
        iso.setCampoISO(25, "Codigo de condicion POS", 1, new int[][] {
                new int[] {
                        1, 1
                }
        }, "00");
        iso.setCampoISO(42, "ID de la entidad", 15, new int[][] {
                new int[] {
                        15, 2
                }
        }, "000010101000001");
        iso.setCampoISO(63, "Operadora", 8, new int[][] {
                new int[] {
                        2, 1
                }, new int[] {
                2, 1
        }, new int[] {
                2, 2
        }, new int[] {
                2, 2
        }
        }, "000600041001");
        byte a[] = iso.getMensajeISOEnBytes();
        System.out.println("Mensaje:" + a + ", largo:" + a.length);
        byte b[] = iso.getCampoISOenBytes(41);
        System.out.println(a);
        ISOMensaje iso2 = new ISOMensaje(a);
        byte c[] = iso2.getMensajeISOEnBytes();
        System.out.println("Mensaje:" + c + ", largo:" + c.length);
        if(a == c)
            System.out.println("Las cadenas de bytes son iguales");
    }



}
