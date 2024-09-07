package com.example.quizdasbandeiras;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AppCompatActivity;

public class PrimeiraTelaJogo extends AppCompatActivity {

    private RadioGroup rbgRespostas1;
    private RadioButton rbtResposta1;
    private RadioButton rbtResposta2;
    private RadioButton rbtResposta3;
    private RadioButton rbtResposta4;
    private Button btnResponder1;
    private String userName;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_primeira_tela_jogo);

        // Override the back press behavior
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        onBackPressedDispatcher.addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(PrimeiraTelaJogo.this, MainActivity.class);
                startActivity(intent);
            }
        });


        rbgRespostas1 = findViewById(R.id.rbgRespostas1);
        rbtResposta1 = findViewById(R.id.rbtResposta1);
        rbtResposta2 = findViewById(R.id.rbtResposta2);
        rbtResposta3 = findViewById(R.id.rbtResposta3);
        rbtResposta4 = findViewById(R.id.rbtResposta4);
        btnResponder1 = findViewById(R.id.btnResponder1);

        Intent intent = getIntent();
        userName =  intent.getStringExtra("userName");


// Set an OnCheckedChangeListener on the RadioGroup
        rbgRespostas1.setOnCheckedChangeListener((group, checkedId) -> {
            // Check if any RadioButton is checked
            if (checkedId != -1) {
                // Enable the button if a RadioButton is selected
                btnResponder1.setEnabled(true);
            } else {
                // Disable the button if no RadioButton is selected
                btnResponder1.setEnabled(false);
            }
        });
    }



    public void testaResposta(View v) {
            if (rbtResposta4.isChecked()) {
                score++;
                Toast.makeText(this, userName+", sua pontuação é: "+score, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(PrimeiraTelaJogo.this, SegundaTelaJogo.class);
                intent.putExtra("userName", userName);
                intent.putExtra("score",score);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Errou", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(PrimeiraTelaJogo.this, SegundaTelaJogo.class);
                intent.putExtra("userName", userName);
                intent.putExtra("score",score);
                startActivity(intent);
            }

        }
    }
