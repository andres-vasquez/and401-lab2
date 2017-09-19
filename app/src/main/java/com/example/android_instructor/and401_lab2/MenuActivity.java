package com.example.android_instructor.and401_lab2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    private Context context;

    private String usuario;
    private String password;

    private TextView lblBienvenida;
    private LinearLayout lyCuenta;
    private LinearLayout lyExtracto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        context = this;

        Intent intent = getIntent();
        usuario = intent.getStringExtra("usuario");
        password = intent.getStringExtra("password");

        lblBienvenida = (TextView)findViewById(R.id.lblBienvenida);
        lyCuenta = (LinearLayout)findViewById(R.id.lyCuenta);
        lyExtracto = (LinearLayout)findViewById(R.id.lyExtracto);

        //Rellenar el labl bienvenida
        lblBienvenida.setText("Bienvenido: "+usuario);

        lyCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cuentaIntent = new Intent(context,CuentasActivity.class);
                cuentaIntent.putExtra("titulo","Cuentas");
                startActivity(cuentaIntent);
            }
        });

        lyExtracto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent extractoIntent = new Intent(context,ExtractoActivity.class);
                extractoIntent.putExtra("titulo","Extracto");
                startActivity(extractoIntent);
            }
        });
    }
}
