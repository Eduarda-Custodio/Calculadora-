package com.example.prjcalculadora;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class historico extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        Button btnVoltar = (Button) findViewById(R.id.btnVoltar);
        Button btnLimparHistorico = (Button) findViewById(R.id.btnLimparHistorico);
        Button btnSalvar = (Button) findViewById(R.id.btnSalvar);
        ArrayList<String> historico = getIntent().getStringArrayListExtra("historico");
        TextView txvResultadoMostrar = (TextView) findViewById(R.id.txtMostrarHistorico);
        TextView txtMostrarHistorico = (TextView) findViewById(R.id.txtMostrarHistorico);



        for (String item : historico) {
            txvResultadoMostrar.append(item + "\n");
        }

        btnLimparHistorico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtMostrarHistorico.setText("");
            }
        });


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        try {
            TextView txvResultadoMostrar = findViewById(R.id.txtMostrarHistorico);
            String historico = txvResultadoMostrar.getText().toString();
            String fileName = "historico.txt";
            File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File file = new File(dir, fileName);
            FileWriter writer = new FileWriter(file);
            writer.append(historico);
            writer.flush();
            writer.close();

            Toast.makeText(getApplicationContext(), "Histórico salvo com sucesso", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {

            Toast.makeText(getApplicationContext(), "Erro ao salvar histórico", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
}
});

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent in = new Intent(historico.this, MainActivity.class);
                startActivity(in);
            }
        });

    }
}