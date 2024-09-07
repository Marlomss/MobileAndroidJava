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
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuintaTelaJogo extends AppCompatActivity {

    private RadioGroup rbgRespostas5;
    private RadioButton rbtResposta17;
    private RadioButton rbtResposta18;
    private RadioButton rbtResposta19;
    private RadioButton rbtResposta20;
    private Button btnResponder5;
    private String userName;
    private int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quinta_tela_jogo);

        // Override the back press behavior
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        onBackPressedDispatcher.addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(QuintaTelaJogo.this, MainActivity.class);
                startActivity(intent);
            }
        });

        rbgRespostas5 = findViewById(R.id.rbgRespostas5);
        rbtResposta17 = findViewById(R.id.rbtResposta17);
        rbtResposta18 = findViewById(R.id.rbtResposta18);
        rbtResposta19 = findViewById(R.id.rbtResposta19);
        rbtResposta20 = findViewById(R.id.rbtResposta20);
        btnResponder5 = findViewById(R.id.btnResponder5);

        Intent intent = getIntent();
        userName =  intent.getStringExtra("userName");
        score = intent.getIntExtra("score",0);

        // Set an OnCheckedChangeListener on the RadioGroup
        rbgRespostas5.setOnCheckedChangeListener((group, checkedId) -> {
            // Check if any RadioButton is checked
            if (checkedId != -1) {
                // Enable the button if a RadioButton is selected
                btnResponder5.setEnabled(true);
            } else {
                // Disable the button if no RadioButton is selected
                btnResponder5.setEnabled(false);
            }
        });
    }



    public void testaResposta(View v) {
        if (rbtResposta19.isChecked()) {
            score++;
            Toast.makeText(this, userName+", sua pontuação é: "+score, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(QuintaTelaJogo.this, SextaTelaJogo.class);
            intent.putExtra("userName", userName);
            intent.putExtra("score",score);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Errou", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(QuintaTelaJogo.this, SextaTelaJogo.class);
            intent.putExtra("userName", userName);
            intent.putExtra("score",score);
            startActivity(intent);
        }

    }
}