package com.example.jesus.apprecarga;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by provar-3 on 23/05/16.
 */
public class DownloadConfig extends AppCompatActivity {

    String Terminal;
    String Idcomercio;
    String Ip;
    String Puerto;

    TextView tvTerminal;
    TextView tvIdcomer;
    TextView tvIp;
    TextView tvPuerto;


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


        tvTerminal.setText(Terminal);
        tvIdcomer.setText(Idcomercio);
        tvIp.setText(Ip);
        tvPuerto.setText(Puerto);

    }

}
