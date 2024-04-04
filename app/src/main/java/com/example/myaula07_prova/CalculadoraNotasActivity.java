package com.example.myaula07_prova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CalculadoraNotasActivity extends AppCompatActivity {

    private EditText editTextNota1;
    private EditText editTextNota2;
    private EditText editTextPeso1;
    private EditText editTextPeso2;
    private Button buttonCalcularMediaPonderada;
    private Button buttonCalcularMediaSimples;
    private Button buttonVoltar; // Adicionando o botão de voltar
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_notas);

        editTextNota1 = findViewById(R.id.editTextNota1);
        editTextNota2 = findViewById(R.id.editTextNota2);
        editTextPeso1 = findViewById(R.id.editTextPeso1);
        editTextPeso2 = findViewById(R.id.editTextPeso2);
        buttonCalcularMediaPonderada = findViewById(R.id.buttonCalcularMediaPonderada);
        buttonCalcularMediaSimples = findViewById(R.id.buttonCalcularMediaSimples);
        buttonVoltar = findViewById(R.id.buttonVoltar); // Inicializando o botão de voltar
        textViewResultado = findViewById(R.id.textViewResultado);

        buttonCalcularMediaPonderada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularMediaPonderada();
            }
        });

        buttonCalcularMediaSimples.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularMediaSimples();
            }
        });

        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voltarParaProximaTela();
            }
        });
    }

    private void calcularMediaPonderada() {
        String nota1Str = editTextNota1.getText().toString();
        String nota2Str = editTextNota2.getText().toString();
        String peso1Str = editTextPeso1.getText().toString();
        String peso2Str = editTextPeso2.getText().toString();

        if (!nota1Str.isEmpty() && !nota2Str.isEmpty()) {
            double nota1 = Double.parseDouble(nota1Str);
            double nota2 = Double.parseDouble(nota2Str);
            double peso1 = peso1Str.isEmpty() ? 1 : Double.parseDouble(peso1Str);
            double peso2 = peso2Str.isEmpty() ? 1 : Double.parseDouble(peso2Str);

            double mediaPonderada = (nota1 * peso1 + nota2 * peso2) / (peso1 + peso2);
            textViewResultado.setText("Média Ponderada: " + mediaPonderada);
        } else {
            textViewResultado.setText("Por favor, insira as duas notas.");
        }
    }

    private void calcularMediaSimples() {
        String nota1Str = editTextNota1.getText().toString();
        String nota2Str = editTextNota2.getText().toString();

        if (!nota1Str.isEmpty() && !nota2Str.isEmpty()) {
            double nota1 = Double.parseDouble(nota1Str);
            double nota2 = Double.parseDouble(nota2Str);

            double mediaSimples = (nota1 + nota2) / 2;
            textViewResultado.setText("Média Simples: " + mediaSimples);
        } else {
            textViewResultado.setText("Por favor, insira as duas notas.");
        }
    }

    private void voltarParaProximaTela() {
        Intent intent = new Intent(this, ProximaTelaActivity.class);
        startActivity(intent);
    }
}
