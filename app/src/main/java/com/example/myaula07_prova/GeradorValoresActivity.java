package com.example.myaula07_prova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class GeradorValoresActivity extends AppCompatActivity {

    private EditText editTextValorMinimo;
    private EditText editTextValorMaximo;
    private TextView textViewValorGerado;
    private Button buttonGerarNumero;
    private Button buttonVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerador_valores);

        editTextValorMinimo = findViewById(R.id.editTextValorMinimo);
        editTextValorMaximo = findViewById(R.id.editTextValorMaximo);
        textViewValorGerado = findViewById(R.id.textViewValorGerado);
        buttonGerarNumero = findViewById(R.id.buttonGerarNumero);
        buttonVoltar = findViewById(R.id.buttonVoltar);

        buttonGerarNumero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gerarNumeroAleatorio();
            }
        });

        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voltarParaProximaTela();
            }
        });
    }

    private void gerarNumeroAleatorio() {
        String valorMinimoStr = editTextValorMinimo.getText().toString();
        String valorMaximoStr = editTextValorMaximo.getText().toString();

        if (!valorMinimoStr.isEmpty() && !valorMaximoStr.isEmpty()) {
            int valorMinimo = Integer.parseInt(valorMinimoStr);
            int valorMaximo = Integer.parseInt(valorMaximoStr);

            if (valorMinimo < valorMaximo) {
                Random random = new Random();
                int numeroAleatorio = random.nextInt(valorMaximo - valorMinimo + 1) + valorMinimo;
                textViewValorGerado.setText("Valor Gerado: " + numeroAleatorio);
            } else {
                Toast.makeText(GeradorValoresActivity.this, "O valor máximo deve ser maior que o valor mínimo", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(GeradorValoresActivity.this, "Por favor, insira um valor mínimo e máximo", Toast.LENGTH_SHORT).show();
        }
    }

    private void voltarParaProximaTela() {
        finish();
    }
}
