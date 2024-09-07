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

public class TerceiraTelaJogo extends AppCompatActivity {

    private RadioGroup rbgRespostas3;
    private RadioButton rbtResposta9;
    private RadioButton rbtResposta10;
    private RadioButton rbtResposta11;
    private RadioButton rbtResposta12;
    private Button btnResponder3;
    private String userName;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_terceira_tela_jogo);
        // Override the back press behavior
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        onBackPressedDispatcher.addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(TerceiraTelaJogo.this, MainActivity.class);
                startActivity(intent);
            }
        });

        rbgRespostas3 = findViewById(R.id.rbgRespostas3);
        rbtResposta9 = findViewById(R.id.rbtResposta9);
        rbtResposta10 = findViewById(R.id.rbtResposta10);
        rbtResposta11 = findViewById(R.id.rbtResposta11);
        rbtResposta12 = findViewById(R.id.rbtResposta12);
        btnResponder3 = findViewById(R.id.btnResponder3);

        Intent intent = getIntent();
        userName =  intent.getStringExtra("userName");
        score = intent.getIntExtra("score",0);

        // Set an OnCheckedChangeListener on the RadioGroup
        rbgRespostas3.setOnCheckedChangeListener((group, checkedId) -> {
            // Check if any RadioButton is checked
            if (checkedId != -1) {
                // Enable the button if a RadioButton is selected
                btnResponder3.setEnabled(true);
            } else {
                // Disable the button if no RadioButton is selected
                btnResponder3.setEnabled(false);
            }
        });

    }

    public void testaResposta(View v) {
        if (rbtResposta12.isChecked()) {
            score++;
            Toast.makeText(this, userName+", sua pontuação é: "+score, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(TerceiraTelaJogo.this, QuartaTelaJogo.class);
            intent.putExtra("userName", userName);
            intent.putExtra("score",score);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Errou", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(TerceiraTelaJogo.this, QuartaTelaJogo.class);
            intent.putExtra("userName", userName);
            intent.putExtra("score",score);
            startActivity(intent);
        }

    }
}