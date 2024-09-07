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

public class NonaTelaJogo extends AppCompatActivity {

    private RadioGroup rbgRespostas9;  // Incremented from rbgRespostas8
    private RadioButton rbtResposta33; // Incremented from rbtResposta29
    private RadioButton rbtResposta34; // Incremented from rbtResposta30
    private RadioButton rbtResposta35; // Incremented from rbtResposta31
    private RadioButton rbtResposta36; // Incremented from rbtResposta32
    private Button btnResponder9;      // Incremented from btnResponder8
    private String userName;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nona_tela_jogo); // Changed layout name to match new screen

        // Override the back press behavior
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        onBackPressedDispatcher.addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(NonaTelaJogo.this, MainActivity.class);
                startActivity(intent);
            }
        });

        rbgRespostas9 = findViewById(R.id.rbgRespostas9);  // Updated ID
        rbtResposta33 = findViewById(R.id.rbtResposta33);  // Updated ID
        rbtResposta34 = findViewById(R.id.rbtResposta34);  // Updated ID
        rbtResposta35 = findViewById(R.id.rbtResposta35);  // Updated ID
        rbtResposta36 = findViewById(R.id.rbtResposta36);  // Updated ID
        btnResponder9 = findViewById(R.id.btnResponder9);  // Updated ID

        Intent intent = getIntent();
        userName = intent.getStringExtra("userName");
        score = intent.getIntExtra("score", 0);

        // Set an OnCheckedChangeListener on the RadioGroup
        rbgRespostas9.setOnCheckedChangeListener((group, checkedId) -> {
            // Check if any RadioButton is checked
            if (checkedId != -1) {
                // Enable the button if a RadioButton is selected
                btnResponder9.setEnabled(true);
            } else {
                // Disable the button if no RadioButton is selected
                btnResponder9.setEnabled(false);
            }
        });
    }

    public void testaResposta(View v) {
        if (rbtResposta36.isChecked()) {  // Assuming this RadioButton is the correct answer
            score++;
            Toast.makeText(this, userName + ", sua pontuação é: " + score, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(NonaTelaJogo.this, DecimaTelaJogo.class);  // Navigate to next screen
            intent.putExtra("userName", userName);
            intent.putExtra("score", score);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Errou", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(NonaTelaJogo.this, DecimaTelaJogo.class);  // Navigate to next screen
            intent.putExtra("userName", userName);
            intent.putExtra("score", score);
            startActivity(intent);
        }
    }
}
