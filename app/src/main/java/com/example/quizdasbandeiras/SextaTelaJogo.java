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

public class SextaTelaJogo extends AppCompatActivity {

    private RadioGroup rbgRespostas6;  // Incremented from rbgRespostas5
    private RadioButton rbtResposta21; // Incremented from rbtResposta17
    private RadioButton rbtResposta22; // Incremented from rbtResposta18
    private RadioButton rbtResposta23; // Incremented from rbtResposta19
    private RadioButton rbtResposta24; // Incremented from rbtResposta20
    private Button btnResponder6;      // Incremented from btnResponder5
    private String userName;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sexta_tela_jogo); // Changed layout name to match new screen

        // Override the back press behavior
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        onBackPressedDispatcher.addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(SextaTelaJogo.this, MainActivity.class);
                startActivity(intent);
            }
        });

        rbgRespostas6 = findViewById(R.id.rbgRespostas6);  // Updated ID
        rbtResposta21 = findViewById(R.id.rbtResposta21);  // Updated ID
        rbtResposta22 = findViewById(R.id.rbtResposta22);  // Updated ID
        rbtResposta23 = findViewById(R.id.rbtResposta23);  // Updated ID
        rbtResposta24 = findViewById(R.id.rbtResposta24);  // Updated ID
        btnResponder6 = findViewById(R.id.btnResponder6);  // Updated ID

        Intent intent = getIntent();
        userName = intent.getStringExtra("userName");
        score = intent.getIntExtra("score", 0);

        // Set an OnCheckedChangeListener on the RadioGroup
        rbgRespostas6.setOnCheckedChangeListener((group, checkedId) -> {
            // Check if any RadioButton is checked
            if (checkedId != -1) {
                // Enable the button if a RadioButton is selected
                btnResponder6.setEnabled(true);
            } else {
                // Disable the button if no RadioButton is selected
                btnResponder6.setEnabled(false);
            }
        });
    }

    public void testaResposta(View v) {
        if (rbtResposta21.isChecked()) {  // Assuming this RadioButton is the correct answer
            score++;
            Toast.makeText(this, userName + ", sua pontuação é: " + score, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(SextaTelaJogo.this, SetimaTelaJogo.class);  // Navigating to Placar after this screen
            intent.putExtra("userName", userName);
            intent.putExtra("score", score);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Errou", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(SextaTelaJogo.this, SetimaTelaJogo.class);  // Navigating to Placar after this screen
            intent.putExtra("userName", userName);
            intent.putExtra("score", score);
            startActivity(intent);
        }
    }
}
