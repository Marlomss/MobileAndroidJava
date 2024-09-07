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

public class OitavaTelaJogo extends AppCompatActivity {

    private RadioGroup rbgRespostas8;  // Incremented from rbgRespostas7
    private RadioButton rbtResposta29; // Incremented from rbtResposta25
    private RadioButton rbtResposta30; // Incremented from rbtResposta26
    private RadioButton rbtResposta31; // Incremented from rbtResposta27
    private RadioButton rbtResposta32; // Incremented from rbtResposta28
    private Button btnResponder8;      // Incremented from btnResponder7
    private String userName;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_oitava_tela_jogo); // Changed layout name to match new screen

        // Override the back press behavior
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        onBackPressedDispatcher.addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(OitavaTelaJogo.this, MainActivity.class);
                startActivity(intent);
            }
        });

        rbgRespostas8 = findViewById(R.id.rbgRespostas8);  // Updated ID
        rbtResposta29 = findViewById(R.id.rbtResposta29);  // Updated ID
        rbtResposta30 = findViewById(R.id.rbtResposta30);  // Updated ID
        rbtResposta31 = findViewById(R.id.rbtResposta31);  // Updated ID
        rbtResposta32 = findViewById(R.id.rbtResposta32);  // Updated ID
        btnResponder8 = findViewById(R.id.btnResponder8);  // Updated ID

        Intent intent = getIntent();
        userName = intent.getStringExtra("userName");
        score = intent.getIntExtra("score", 0);

        // Set an OnCheckedChangeListener on the RadioGroup
        rbgRespostas8.setOnCheckedChangeListener((group, checkedId) -> {
            // Check if any RadioButton is checked
            if (checkedId != -1) {
                // Enable the button if a RadioButton is selected
                btnResponder8.setEnabled(true);
            } else {
                // Disable the button if no RadioButton is selected
                btnResponder8.setEnabled(false);
            }
        });
    }

    public void testaResposta(View v) {
        if (rbtResposta29.isChecked()) {  // Assuming this RadioButton is the correct answer
            score++;
            Toast.makeText(this, userName + ", sua pontuação é: " + score, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(OitavaTelaJogo.this, NonaTelaJogo.class);  // Navigate to next screen
            intent.putExtra("userName", userName);
            intent.putExtra("score", score);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Errou", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(OitavaTelaJogo.this, NonaTelaJogo.class);  // Navigate to next screen
            intent.putExtra("userName", userName);
            intent.putExtra("score", score);
            startActivity(intent);
        }
    }
}
