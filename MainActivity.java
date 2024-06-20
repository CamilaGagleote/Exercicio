package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumber;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber = findViewById(R.id.Numero);
        textViewResult = findViewById(R.id.tentativa);
        Button btEnvia = (Button) findViewById(R.id.btEnvia);
        btEnvia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recebe(editTextNumber);
            }
        });


    }

    public void recebe( EditText editTextNumber) {
        textViewResult.setText("Insira um número.");
        int vet[] = new int [20];
        for(int i = 0; i<20; i++){
            String inputText = editTextNumber.getText().toString().trim();
            int n = Integer.parseInt(inputText);
            vet[i] = n;
            editTextNumber.getText().clear();
            vet[i] = n;
            if(n < 0){
                textViewResult.setText("O número deve ser positivo");
            }
        }
        int aux = 0;
        for(int i = 0; i<20; i++) {
            for (int j = i + 1; j < 20; j++) {
                if (vet[i] > vet[j]) {
                    aux = vet[j];
                    vet[j] = vet[i];
                    vet[i] = aux;
                }
            }
        }
        for(int i = 0; i<20; i++) {
            textViewResult.setText("menor: "+ vet[0] + " e maior:  "+ vet[20] );

        }

    }
}









