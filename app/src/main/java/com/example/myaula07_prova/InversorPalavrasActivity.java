package com.example.myaula07_prova;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class InversorPalavrasActivity extends AppCompatActivity {

    private EditText editTextTexto;
    private Button buttonInverterTexto;
    private TextView textViewTextoInvertido;
    private Button buttonVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inversor_palavras);

        editTextTexto = findViewById(R.id.editTextTexto);
        buttonInverterTexto = findViewById(R.id.buttonInverterTexto);
        textViewTextoInvertido = findViewById(R.id.textViewTextoInvertido);
        buttonVoltar = findViewById(R.id.buttonVoltar);

        buttonInverterTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inverterTexto();
            }
        });

        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voltarParaProximaTela();
            }
        });
    }

    private void inverterTexto() {
        String texto = editTextTexto.getText().toString();
        StringBuilder textoInvertido = new StringBuilder();

        for (int i = texto.length() - 1; i >= 0; i--) {
            textoInvertido.append(texto.charAt(i));
        }

        textViewTextoInvertido.setText("Texto Invertido: " + textoInvertido.toString());
    }

    private void voltarParaProximaTela() {
        finish();
    }
}
