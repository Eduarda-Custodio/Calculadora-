package com.example.prjcalculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    float vlValor1, vlValor2, vlResultado = 0;
    double memoria = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnHistorico = (Button)findViewById(R.id.btnHistorico);
        Button btnFinalizar = (Button)findViewById(R.id.btnFinalizar);
        Button btnLimpar = (Button)findViewById(R.id.btnLimpar);
        ImageButton btnSomar = (ImageButton)findViewById(R.id.btnSomar);
        ImageButton btnSubtrair = (ImageButton)findViewById(R.id.btnSubtrair);
        ImageButton btnMultiplicar = (ImageButton)findViewById(R.id.btnMultiplicar);
        ImageButton btnDividir = (ImageButton)findViewById(R.id.btnDividir);
        EditText edtValor1 = (EditText)findViewById(R.id.edtValor1);
        EditText edtValor2 = (EditText)findViewById(R.id.edtValor2);
        TextView txvResultadoMostrar = (TextView)findViewById(R.id.txvResultadoMostrar);
        Button btnCE = (Button) findViewById(R.id.btnCE);
        Button btnMC = (Button) findViewById(R.id.btnMC);
        Button btnMR = (Button) findViewById(R.id.btnMR);
        Button btnMmais = (Button) findViewById(R.id.btnMmais);
        Button btnMmenos = (Button) findViewById(R.id.btnMmenos);
        Button btnC = (Button) findViewById(R.id.btnC);


        ArrayList<String> historico = new ArrayList<>();



        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtValor1.setText("");
                edtValor2.setText("");
                txvResultadoMostrar.setText("");}
        });

        btnSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vlValor1 = Float.valueOf(edtValor1.getText().toString());
                vlValor2 = Float.valueOf(edtValor2.getText().toString());
                vlResultado = vlValor1 + vlValor2;
                historico.add(vlValor1 + " + " + vlValor2 + " = " + vlResultado);
                historico.add("________________________________\n");
                txvResultadoMostrar.setText(String.valueOf(vlResultado));
            }
        });

        btnSubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vlValor1 = Float.valueOf(edtValor1.getText().toString());
                vlValor2 = Float.valueOf(edtValor2.getText().toString());
                vlResultado = vlValor1 - vlValor2;
                historico.add(vlValor1 + " - " + vlValor2 + " = " + vlResultado);
                historico.add("________________________________\n");
                txvResultadoMostrar.setText(String.valueOf(vlResultado));
            }
        });

        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vlValor1 = Float.valueOf(edtValor1.getText().toString());
                vlValor2 = Float.valueOf(edtValor2.getText().toString());
                vlResultado = vlValor1 * vlValor2;
                historico.add(vlValor1 + " x " + vlValor2 + " = " + vlResultado);
                historico.add("________________________________\n");
                txvResultadoMostrar.setText(String.valueOf(vlResultado));
            }
        });

        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vlValor1 = Float.valueOf(edtValor1.getText().toString());
                vlValor2 = Float.valueOf(edtValor2.getText().toString());
                if(vlValor2 == 0){

                    txvResultadoMostrar.setText("Impossível dividir por 0");

                }else{
                    vlResultado = vlValor1 / vlValor2;

                    txvResultadoMostrar.setText(String.valueOf(vlResultado));
                }
                historico.add(vlValor1 + " / " + vlValor2 + " = " + vlResultado);
                historico.add("________________________________\n");


            }

        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtValor1.setText("");
                edtValor2.setText("");
                txvResultadoMostrar.setText("");
            }
        });

        btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtValor2.hasFocus()) {
                    edtValor2.setText("");
                }
                if (edtValor1.hasFocus()) {
                    edtValor1.setText("");
                }

                txvResultadoMostrar.setText("");

            }
        });

        btnMmais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                vlResultado = Float.valueOf(txvResultadoMostrar.getText().toString());
                memoria += vlResultado;

            }
        });

        btnMmenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vlResultado = Float.valueOf(txvResultadoMostrar.getText().toString());
                memoria -= vlResultado;

            }
        });

        btnMR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txvResultadoMostrar.setText(String.valueOf(memoria));
            }
        });

        btnMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                memoria = 0;
                txvResultadoMostrar.setText(String.valueOf(memoria));
            }
        });

        btnHistorico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
            Intent in = new Intent(MainActivity.this, historico.class);
            in.putStringArrayListExtra("historico", historico);
            startActivity(in);
        }
        });

    }
}
