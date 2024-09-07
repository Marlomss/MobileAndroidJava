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

public class QuartaTelaJogo extends AppCompatActivity {

    private RadioGroup rbgRespostas4;
    private RadioButton rbtResposta13;
    private RadioButton rbtResposta14;
    private RadioButton rbtResposta15;
    private RadioButton rbtResposta16;
    private Button btnResponder4;
    private String userName;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quarta_tela_jogo);
        // Override the back press behavior
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        onBackPressedDispatcher.addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(QuartaTelaJogo.this, MainActivity.class);
                startActivity(intent);
            }
        });

        rbgRespostas4 = findViewById(R.id.rbgRespostas4);
        rbtResposta13 = findViewById(R.id.rbtResposta13);
        rbtResposta14 = findViewById(R.id.rbtResposta14);
        rbtResposta15 = findViewById(R.id.rbtResposta15);
        rbtResposta16 = findViewById(R.id.rbtResposta16);
        btnResponder4 = findViewById(R.id.btnResponder4);

        Intent intent = getIntent();
        userName =  intent.getStringExtra("userName");
        score = intent.getIntExtra("score",0);

        // Set an OnCheckedChangeListener on the RadioGroup
        rbgRespostas4.setOnCheckedChangeListener((group, checkedId) -> {
            // Check if any RadioButton is checked
            if (checkedId != -1) {
                // Enable the button if a RadioButton is selected
                btnResponder4.setEnabled(true);
            } else {
                // Disable the button if no RadioButton is selected
                btnResponder4.setEnabled(false);
            }
        });
    }



    public void testaResposta(View v) {
        if (rbtResposta14.isChecked()) {
            score++;
            Toast.makeText(this, userName+", sua pontuação é: "+score, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(QuartaTelaJogo.this, QuintaTelaJogo.class);
            intent.putExtra("userName", userName);
            intent.putExtra("score",score);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Errou", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(QuartaTelaJogo.this, QuintaTelaJogo.class);
            intent.putExtra("userName", userName);
            intent.putExtra("score",score);
            startActivity(intent);
        }

    }
}