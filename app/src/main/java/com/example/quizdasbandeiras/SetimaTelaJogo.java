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

public class SetimaTelaJogo extends AppCompatActivity {

    private RadioGroup rbgRespostas7;  // Incremented from rbgRespostas6
    private RadioButton rbtResposta25; // Incremented from rbtResposta21
    private RadioButton rbtResposta26; // Incremented from rbtResposta22
    private RadioButton rbtResposta27; // Incremented from rbtResposta23
    private RadioButton rbtResposta28; // Incremented from rbtResposta24
    private Button btnResponder7;      // Incremented from btnResponder6
    private String userName;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_setima_tela_jogo); // Changed layout name to match new screen

        // Override the back press behavior
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        onBackPressedDispatcher.addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(SetimaTelaJogo.this, MainActivity.class);
                startActivity(intent);
            }
        });

        rbgRespostas7 = findViewById(R.id.rbgRespostas7);  // Updated ID
        rbtResposta25 = findViewById(R.id.rbtResposta25);  // Updated ID
        rbtResposta26 = findViewById(R.id.rbtResposta26);  // Updated ID
        rbtResposta27 = findViewById(R.id.rbtResposta27);  // Updated ID
        rbtResposta28 = findViewById(R.id.rbtResposta28);  // Updated ID
        btnResponder7 = findViewById(R.id.btnResponder7);  // Updated ID

        Intent intent = getIntent();
        userName = intent.getStringExtra("userName");
        score = intent.getIntExtra("score", 0);

        // Set an OnCheckedChangeListener on the RadioGroup
        rbgRespostas7.setOnCheckedChangeListener((group, checkedId) -> {
            // Check if any RadioButton is checked
            if (checkedId != -1) {
                // Enable the button if a RadioButton is selected
                btnResponder7.setEnabled(true);
            } else {
                // Disable the button if no RadioButton is selected
                btnResponder7.setEnabled(false);
            }
        });
    }

    public void testaResposta(View v) {
        if (rbtResposta25.isChecked()) {  // Assuming this RadioButton is the correct answer
            score++;
            Toast.makeText(this, userName + ", sua pontuação é: " + score, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(SetimaTelaJogo.this, OitavaTelaJogo.class);  // Navigate to next screen
            intent.putExtra("userName", userName);
            intent.putExtra("score", score);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Errou", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(SetimaTelaJogo.this, OitavaTelaJogo.class);  // Navigate to next screen
            intent.putExtra("userName", userName);
            intent.putExtra("score", score);
            startActivity(intent);
        }
    }
}
