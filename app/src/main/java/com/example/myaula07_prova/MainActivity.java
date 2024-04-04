package com.example.myaula07_prova;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vinculando elementos do layout
        TextView textName = findViewById(R.id.editTextName);
        TextView textRegistration = findViewById(R.id.editTextRegistration);
        TextView textCourse = findViewById(R.id.editTextCourse);
        Button buttonNext = findViewById(R.id.buttonNext);

        // Definindo os valores iniciais dos TextViews (substitua pelos seus próprios dados)
        textName.setText("");
        textRegistration.setText("");
        textCourse.setText("");

        // Configurando o listener de clique para o botão
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir a próxima tela (você precisará criar a próxima Activity)
                Intent intent = new Intent(MainActivity.this, ProximaTelaActivity.class);
                startActivity(intent);
            }
        });
    }
}
