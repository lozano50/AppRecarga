package com.example.jesus.apprecarga;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * Created by provar-3 on 23/05/16.
 */
public class DownloadConfig extends AppCompatActivity implements View.OnClickListener{

    String Terminal;
    String Idcomercio;
    String Ip;
    String Puerto;

    TextView tvTerminal;
    TextView tvIdcomer;
    TextView tvIp;
    TextView tvPuerto;

    public static final String SERVERIP = "181.143.155.250"; //your computer IP address
    public static final int SERVERPORT = 8088;

    BufferedReader in;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.download_config);

        tvTerminal = (TextView) findViewById(R.id.tvTerminal);
        tvIdcomer  = (TextView) findViewById(R.id.tvIdcomer);
        tvIp       = (TextView) findViewById(R.id.tvIp);
        tvPuerto   = (TextView) findViewById(R.id.tvPuerto);


        SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        Terminal = prefs.getString("TERMINAL","");
        Idcomercio = prefs.getString("IDCOMERCIO","");
        Ip = prefs.getString("IP","");
        Puerto = prefs.getString("PUERTO","");

        /*tvTerminal.setText(Terminal);
        tvIdcomer.setText(Idcomercio);
        tvIp.setText(Ip);
        tvPuerto.setText(Puerto);*/


    }


    @Override
    public void onClick(View v) {

    }
}
