package com.example.jesus.apprecarga;

import com.example.jesus.apprecarga.isolib.ISOMensaje;
import com.example.jesus.apprecarga.utils.AppUtil;
import com.example.jesus.apprecarga.utils.Encrypt;
import com.example.jesus.apprecarga.utils.ISOUtil;

/**
 * Created by provar-3 on 8/06/16.
 */
public class TransMessages {

    public TransMessages()
    {
    }

    public static void packMsgLen(byte outputBuffer[], int indice)
    {
        outputBuffer[0] = (byte)((indice - 2) / 256);
        outputBuffer[1] = (byte)((indice - 2) % 256);
    }

    public static int packMsgHeader(int type, byte outputBuffer[], String stan, String terminal_id, String merchant_id, String configVer)
    {
        int indice = 2;

        switch(type)
        {
            case 1: // '\001'
                System.arraycopy(messageTypeInit, 0, outputBuffer, indice, messageTypeInit.length);
                indice += messageTypeInit.length;
                break;

            case 2: // '\002'
                System.arraycopy(messageTypeSale, 0, outputBuffer, indice, messageTypeSale.length);
                indice += messageTypeSale.length;
                break;

            case 3: // '\003'
                System.arraycopy(messageTypeSaldo, 0, outputBuffer, indice, messageTypeSaldo.length);
                indice += messageTypeSaldo.length;
                break;

            case 4: // '\004'
                System.arraycopy(messageTypeCierre, 0, outputBuffer, indice, messageTypeCierre.length);
                indice += messageTypeCierre.length;
                break;

            case 5: // '\005'
                System.arraycopy(messageTypeConfCierre, 0, outputBuffer, indice, messageTypeConfCierre.length);
                indice += messageTypeConfCierre.length;
                break;

            case 6: // '\006'
                System.arraycopy(messageTypeUltimaRecarga, 0, outputBuffer, indice, messageTypeUltimaRecarga.length);
                indice += messageTypeUltimaRecarga.length;
                break;

            case 7: // '\007'
                System.arraycopy(messageTypeInitAuto, 0, outputBuffer, indice, messageTypeUltimaRecarga.length);
                indice += messageTypeUltimaRecarga.length;
                break;
        }
        System.arraycopy(bitMap, 0, outputBuffer, indice, bitMap.length);
        indice += bitMap.length;
        switch(type)
        {
            case 3: // '\003'
                System.arraycopy(processCodeSaldo, 0, outputBuffer, indice, processCodeSaldo.length);
                indice += processCodeSaldo.length;
                break;

            default:
                System.arraycopy(processCodeGeneral, 0, outputBuffer, indice, processCodeGeneral.length);
                indice += processCodeGeneral.length;
                break;
        }
        byte stanBCD[] = ISOUtil.str2bcd(stan, true);
        System.arraycopy(stanBCD, 0, outputBuffer, indice, stanBCD.length);
        indice += stanBCD.length;
        time = ISOUtil.getTime();
        System.arraycopy(time, 0, outputBuffer, indice, time.length);
        indice += time.length;
        byte date[] = ISOUtil.getDate();
        System.arraycopy(date, 0, outputBuffer, indice, date.length);
        indice += date.length;
        configVersion = configVer.getBytes();
        System.arraycopy(configVersion, 0, outputBuffer, indice, configVersion.length);
        indice += configVersion.length;
        System.arraycopy(softVersion.getBytes(), 0, outputBuffer, indice, softVersion.length());
        indice += softVersion.length();
        terminal_id_format = ISOUtil.padleft(terminal_id, 8, '0');
        System.arraycopy(terminal_id_format.getBytes(), 0, outputBuffer, indice, terminal_id_format.length());
        indice += terminal_id_format.length();
        String merchant_id_format = ISOUtil.padleft(merchant_id, 15, ' ');
        System.arraycopy(merchant_id_format.getBytes(), 0, outputBuffer, indice, merchant_id_format.length());
        indice += merchant_id_format.length();

        return indice;
    }

    /**
     *
     * @param outputBuffer
     * @param stan
     * @param terminal_id
     * @param merchant_id
     * @param configVersion
     * @param idEntidad
     * @param DLC_Auto
     * @return
     */
    public static ISOMensaje packMsgInit(byte outputBuffer[], String stan, String terminal_id, String merchant_id, String configVersion, String idEntidad, boolean DLC_Auto)
    {

        ISOMensaje iso = new ISOMensaje();
        iso.setEncabezado("6000010002");
        iso.setTipoMensaje("0800");
        //iso.setCampoISO(3, "Codigo del Proceso", 3, new int[][] {new int[] {3, 1}}, "930001");
        iso.setCampoISO(3, "Codigo del Proceso", 3, new int[][] {new int[] {3, 1}}, "930003");
        iso.setCampoISO(11, "STAN", 3, new int[][] {new int[] { 3, 1}}, stan);
        iso.setCampoISO(13, "Fecha de la transaccion", 2, new int[][]{new int[] {2, 1}
        }, ISOUtil.getDateAsString());
        iso.setCampoISO(22, "Tipo de entarda al POS", 2, new int[][] {new int[] {2, 1}}, "0010");
        iso.setCampoISO(24, "NII", 2, new int[][] {new int[] {2, 1}}, "0000");
        iso.setCampoISO(25, "Codigo de condicion POS", 1, new int[][] {new int[] {1, 1}}, "00");
        iso.setCampoISO(41, "ID del Terminal", 8, new int[][]{new int[] {8, 2}}, terminal_id);
        iso.setCampoISO(42, "ID de la entidad", 15, new int[][] {new int[] {15, 2}}, idEntidad);

        return iso;
    }


    public static ISOMensaje packMsgSale(byte outputBuffer[], String stan, String terminal_id, String merchant_id, String modo_Recarga, String operador_pos, String cod_prov, String cod_area,
                                         String celular, String cod_servicio, String valor, String configVersion, String idEntidad, int idProducto)
    {
        ISOMensaje iso = new ISOMensaje();
        String strMonto = AppUtil.formatearCadena(valor, 10, "0", 2) + "00";
        iso.setEncabezado("6000010002");
        iso.setTipoMensaje("0200");
        iso.setCampoISO(3, "Codigo del Proceso", 3, new int[][] {new int[] {3, 1}}, "000101");
        iso.setCampoISO(4, "Monto de la transaccion", 6, new int[][] {new int[] {6, 1}}, strMonto);
        iso.setCampoISO(11, "STAN", 3, new int[][] {new int[] {3, 1}}, stan);
        iso.setCampoISO(12, "Hora de la transaccion", 3, new int[][] {new int[] {3, 1}}, ISOUtil.getTimeAsString());     //*** LINEA ORIGINAL
        iso.setCampoISO(13, "Fecha de la transaccion", 2, new int[][] {new int[] {2, 1}}, ISOUtil.getDateAsString());     //*** LINEA ORIGINAL
        //iso.setCampoISO(12, "Hora de la transaccion", 3, new int[][] {new int[] {3, 1}}, ISOUtil.getTimeAsString2());
        //iso.setCampoISO(13, "Fecha de la transaccion", 2, new int[][] {new int[] {2, 1}}, ISOUtil.getFechaAsString2());

        iso.setCampoISO(22, "Tipo de entarda al POS", 2, new int[][] {new int[] {2, 1}}, "0010");
        iso.setCampoISO(24, "NII", 2, new int[][] {new int[] {2, 1}}, "0000");
        iso.setCampoISO(25, "Codigo de condicion POS", 1, new int[][] {new int[] {1, 1}}, "00");
        iso.setCampoISO(41, "ID del Terminal", 8, new int[][] {new int[] {8, 2}}, terminal_id);
        iso.setCampoISO(42, "ID de la entidad", 15, new int[][] {new int[] {15, 2}}, idEntidad);
        String strCadCampo63 = new String();
        strCadCampo63 = "0067001410" + configVersion + softVersion + "002220";

        byte authorkey[] = Encrypt.put_rc4_authorkey(ISOUtil.padleft(terminal_id, 8, '0'), stan, ISOUtil.getTimeAsString());
        //byte authorkey[] = Encrypt.put_rc4_authorkey(ISOUtil.padleft(terminal_id, 8, '0'), stan, "105450");
        System.out.println("Hora metodo actual: " + ISOUtil.getTimeAsString());
        System.out.println("Hora metodo nuevo: " + ISOUtil.getTimeAsString2());
        String strCadAuthorKey = new String(authorkey);


        strCadCampo63 = strCadCampo63 + strCadAuthorKey + "002530";
        byte msgSale[] = Encrypt.put_rc4_msgSale(terminal_id, stan, modo_Recarga, operador_pos, cod_prov, cod_area, celular, cod_servicio, valor, idProducto);
        String strMsgSale = new String(msgSale);
        strCadCampo63 = strCadCampo63 + strMsgSale;
        //iso.setCampoISO(63, "Reservado: Recarga", 69, new int[][] {
        iso.setCampoISO(63, "Reservado: Recarga", strCadCampo63.length(), new int[][] {
                new int[] {2, 1}, new int[] {2, 1}, new int[] {2, 2}, new int[] {6, 2}, new int[] {6, 2}, new int[] {2, 1}, new int[] {2, 2},
                new int[] {20, 1}, new int[] {2, 1}, new int[] {2, 2}, new int[] {23, 1}}, strCadCampo63);
        return iso;
    }


    //public static ISOMensaje packMsgLastSale(ISOMensaje isoMsgUltRecarga)
    public static ISOMensaje packMsgLastSaleOne(String terminal_id, String idEntidad)  //ISOMensaje isoMsgUltRecarga,
    {//*** solo la ultima
        ISOMensaje isoMsgUltRecarga = new ISOMensaje();
        isoMsgUltRecarga.setEncabezado("6000010002");
        isoMsgUltRecarga.setTipoMensaje("0100");
        isoMsgUltRecarga.setCampoISO(3, "Codigo del Proceso", 3, new int[][] {new int[] {3, 1}}, "000202");
        //isoMsgUltRecarga.setCampoISO(3, "Codigo del Proceso", 3, new int[][] {new int[] {3, 1}}, "000201");
        isoMsgUltRecarga.setCampoISO(12, "Hora de la transaccion", 3, new int[][] {new int[] {3, 1}}, ISOUtil.getTimeAsString2());     //*** LINEA ORIGINAL
        isoMsgUltRecarga.setCampoISO(13, "Fecha de la transaccion", 2, new int[][] {new int[] {2, 1}}, ISOUtil.getFechaAsString2());     //*** LINEA ORIGINAL
        isoMsgUltRecarga.setCampoISO(41, "ID del Terminal", 8, new int[][] {new int[] {8, 2}}, terminal_id);
        isoMsgUltRecarga.setCampoISO(42, "ID de la entidad", 15, new int[][] {new int[] {15, 2}}, idEntidad);

        return isoMsgUltRecarga;
    }


    public static ISOMensaje packMsgLastSaleFive( String terminal_id, String idEntidad)
    { //**** cinco ultimas
        ISOMensaje isoMsgUltRecarga = new ISOMensaje();
        isoMsgUltRecarga.setEncabezado("6000010002");
        isoMsgUltRecarga.setTipoMensaje("0100");
        isoMsgUltRecarga.setCampoISO(3, "Codigo del Proceso", 3, new int[][] {new int[] {3, 1}}, "000203");
        isoMsgUltRecarga.setCampoISO(12, "Hora de la transaccion", 3, new int[][] {new int[] {3, 1}}, ISOUtil.getTimeAsString2());     //*** LINEA ORIGINAL
        isoMsgUltRecarga.setCampoISO(13, "Fecha de la transaccion", 2, new int[][] {new int[] {2, 1}}, ISOUtil.getFechaAsString2());     //*** LINEA ORIGINAL
        isoMsgUltRecarga.setCampoISO(41, "ID del Terminal", 8, new int[][] {new int[] {8, 2}}, terminal_id);
        isoMsgUltRecarga.setCampoISO(42, "ID de la entidad", 15, new int[][] {new int[] {15, 2}}, idEntidad);

        return isoMsgUltRecarga;
    }


    public static ISOMensaje packMsgSaldo(byte outputBuffer[], String stan, String terminal_id, String merchant_id, String NumLote, String configVersion, String idEntidad)
    {
        ISOMensaje iso = new ISOMensaje();
        iso.setEncabezado("6000010002");
        iso.setTipoMensaje("0100");
        iso.setCampoISO(3, "Codigo del Proceso", 3, new int[][] {
                new int[] {
                        3, 1
                }
        }, "000101");
        iso.setCampoISO(11, "STAN", 3, new int[][] {
                new int[] {
                        3, 1
                }
        }, stan);
        iso.setCampoISO(12, "Hora de la transaccion", 3, new int[][] {
                new int[] {
                        3, 1
                }
        }, ISOUtil.getTimeAsString());
        iso.setCampoISO(13, "Fecha de la transaccion", 2, new int[][] {
                new int[] {
                        2, 1
                }
        }, ISOUtil.getDateAsString());
        iso.setCampoISO(22, "Tipo de entarda al POS", 2, new int[][] {
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
        iso.setCampoISO(41, "ID del Terminal", 8, new int[][] {
                new int[] {
                        8, 2
                }
        }, terminal_id);
        iso.setCampoISO(42, "ID de la entidad", 15, new int[][] {
                new int[] {
                        15, 2
                }
        }, idEntidad);
        return iso;
    }


    public static ISOMensaje packMsgCierre(int type, byte outputBuffer[], String stan, String terminal_id, String merchant_id, String NumLote, String configVersion, String idEntidad,
                                           int iCantRecargas, String strMontoTrans)
    {
        ISOMensaje iso = new ISOMensaje();
        String strNumLoteFormat = ISOUtil.padleft(NumLote, 6, '0');
        String strCantRecargas = ISOUtil.padleft(Integer.toString(iCantRecargas), 6, '0');
        String strMontoTotal = AppUtil.formatearCadena(strMontoTrans, 10, "0", 2) + "00";
        iso.setEncabezado("6000010002");
        iso.setTipoMensaje("0500");
        iso.setCampoISO(3, "Codigo del Proceso", 3, new int[][] {
                new int[] {
                        3, 1
                }
        }, "920001");
        iso.setCampoISO(11, "STAN", 3, new int[][] {
                new int[] {
                        3, 1
                }
        }, stan);
        iso.setCampoISO(12, "Hora de la transaccion", 3, new int[][] {
                new int[] {
                        3, 1
                }
        }, ISOUtil.getTimeAsString());
        iso.setCampoISO(13, "Fecha de la transaccion", 2, new int[][] {
                new int[] {
                        2, 1
                }
        }, ISOUtil.getDateAsString());
        iso.setCampoISO(22, "Tipo de entarda al POS", 2, new int[][] {
                new int[] {
                        2, 1
                }
        }, "0010");
        iso.setCampoISO(24, "NII", 2, new int[][] {
                new int[] {
                        2, 1
                }
        }, "0000");
        iso.setCampoISO(41, "ID del Terminal", 8, new int[][] {
                new int[] {
                        8, 2
                }
        }, terminal_id);
        iso.setCampoISO(42, "ID de la entidad", 15, new int[][] {
                new int[] {
                        15, 2
                }
        }, idEntidad);
        String strcampoISO = "0023000810" + strNumLoteFormat + "001120" + strCantRecargas + strMontoTotal;
        iso.setCampoISO(63, "Reservado cierre", 25, new int[][] {
                new int[] {
                        2, 1
                }, new int[] {
                2, 1
        }, new int[] {
                2, 2
        }, new int[] {
                6, 2
        }, new int[] {
                2, 1
        }, new int[] {
                2, 2
        }, new int[] {
                3, 1
        }, new int[] {
                6, 1
        }
        }, strcampoISO);
        return iso;
    }




    static byte messageTypeInit[] = {9, 6};
    static byte messageTypeInitAuto[] = {9, 17};
    static byte messageTypeSale[] = {2, 0};
    static byte messageTypeSaldo[] = {1, 0};
    static byte messageTypeCierre[] = {5, 0};
    static byte messageTypeConfCierre[] = {5, 32};
    static byte messageTypeUltimaRecarga[] = {9, 80};
    static byte bitMap[] = {32, 56, 1, -128, 0, -62, 0, 0};
    static byte processCodeGeneral[] = {0, 0, 1};
    static byte processCodeSaldo[] = {49, 0, 0};
    //static String softVersion = "V2.1.6";
    static String softVersion = "V4.1.1";
    static String terminal_id_format;
    static byte time[];
    static byte configVersion[];



}
