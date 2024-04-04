package com.example.myaula07_prova;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class RegistroEventoActivity extends AppCompatActivity {

    private EditText editTextEvento;
    private DatePicker datePicker;
    private Button buttonRegistrarEvento;
    private ListView listViewEventos;
    private Button buttonVoltar;
    private ArrayList<String> eventosList;
    private ArrayAdapter<String> eventosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_evento);

        editTextEvento = findViewById(R.id.editTextEvento);
        datePicker = findViewById(R.id.datePicker);
        buttonRegistrarEvento = findViewById(R.id.buttonRegistrarEvento);
        listViewEventos = findViewById(R.id.listViewEventos);
        buttonVoltar = findViewById(R.id.buttonVoltar);

        eventosList = new ArrayList<>();
        eventosAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, eventosList);
        listViewEventos.setAdapter(eventosAdapter);

        buttonRegistrarEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarEvento();
            }
        });

        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voltarParaProximaTela();
            }
        });
    }

    private void registrarEvento() {
        String evento = editTextEvento.getText().toString();
        Calendar calendar = Calendar.getInstance();
        calendar.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
        Date dataEvento = calendar.getTime();
        String dataFormatada = android.text.format.DateFormat.format("dd/MM/yyyy", dataEvento).toString();

        String eventoRegistrado = eventosList.size() + 1 + ". " + dataFormatada + " - " + evento;
        eventosList.add(eventoRegistrado);
        eventosAdapter.notifyDataSetChanged();

        // Limpar campos após o registro do evento
        editTextEvento.setText("");
        datePicker.updateDate(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
    }

    private void voltarParaProximaTela() {
        finish(); // Finaliza esta atividade e volta para a atividade anterior
    }
}
