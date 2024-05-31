package com.fraga.a03projetoconsumocombustivel;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText inputConsumo, inputLitros;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputConsumo = findViewById(R.id.inputConsumo);
        inputLitros = findViewById(R.id.inputLitros);
        result = findViewById(R.id.result);
        Button calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(v -> {calculate();});
    }

    private void calculate() {
        String consumoStr = inputConsumo.getText().toString();
        String litrosStr = inputLitros.getText().toString();

        if (consumoStr.isEmpty() || litrosStr.isEmpty()) {
            result.setText("Preencha os campos!");
            return;
        }

        double consumo = Double.parseDouble(consumoStr);
        double litros = Double.parseDouble(litrosStr);

        double autonomiaKm = consumo * litros;
        double autonomiaMetros = autonomiaKm * 1000;

        result.setText("Autonomia: " + autonomiaMetros + " metros");
    }
}