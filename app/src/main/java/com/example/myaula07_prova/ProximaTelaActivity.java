package com.example.myaula07_prova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ProximaTelaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxima_tela);

        // Vinculando os botões do layout
        Button buttonGeradorValores = findViewById(R.id.buttonGeradorValores);
        Button buttonCalculadoraNotas = findViewById(R.id.buttonCalculadoraNotas);
        Button buttonInversorPalavras = findViewById(R.id.buttonInversorPalavras);
        Button buttonRegistroEvento = findViewById(R.id.buttonRegistroEvento);
        Button buttonBack = findViewById(R.id.buttonBack); // Botão de voltar

        // Configurando os listeners de clique para os botões
        buttonGeradorValores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir a tela do gerador de valores
                Intent intent = new Intent(ProximaTelaActivity.this, GeradorValoresActivity.class);
                startActivity(intent);
            }
        });

        buttonCalculadoraNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir a tela da calculadora de notas
                Intent intent = new Intent(ProximaTelaActivity.this, CalculadoraNotasActivity.class);
                startActivity(intent);
            }
        });

        buttonInversorPalavras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir a tela do inversor de palavras
                Intent intent = new Intent(ProximaTelaActivity.this, InversorPalavrasActivity.class);
                startActivity(intent);
            }
        });

        buttonRegistroEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir a tela do registro de evento
                Intent intent = new Intent(ProximaTelaActivity.this, RegistroEventoActivity.class);
                startActivity(intent);
            }
        });

        // Configurando o listener de clique para o botão de voltar
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Voltar para a tela MainActivity
                Intent intent = new Intent(ProximaTelaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
