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

public class DecimaTelaJogo extends AppCompatActivity {

    private RadioGroup rbgRespostas10;  // Incremented from rbgRespostas9
    private RadioButton rbtResposta37;  // Incremented from rbtResposta33
    private RadioButton rbtResposta38;  // Incremented from rbtResposta34
    private RadioButton rbtResposta39;  // Incremented from rbtResposta35
    private RadioButton rbtResposta40;  // Incremented from rbtResposta36
    private Button btnResponder10;      // Incremented from btnResponder9
    private String userName;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_decima_tela_jogo); // Changed layout name to match new screen

        // Override the back press behavior
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        onBackPressedDispatcher.addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(DecimaTelaJogo.this, MainActivity.class);
                startActivity(intent);
            }
        });

        rbgRespostas10 = findViewById(R.id.rbgRespostas10);  // Updated ID
        rbtResposta37 = findViewById(R.id.rbtResposta37);  // Updated ID
        rbtResposta38 = findViewById(R.id.rbtResposta38);  // Updated ID
        rbtResposta39 = findViewById(R.id.rbtResposta39);  // Updated ID
        rbtResposta40 = findViewById(R.id.rbtResposta40);  // Updated ID
        btnResponder10 = findViewById(R.id.btnResponder10);  // Updated ID

        Intent intent = getIntent();
        userName = intent.getStringExtra("userName");
        score = intent.getIntExtra("score", 0);

        // Set an OnCheckedChangeListener on the RadioGroup
        rbgRespostas10.setOnCheckedChangeListener((group, checkedId) -> {
            // Check if any RadioButton is checked
            if (checkedId != -1) {
                // Enable the button if a RadioButton is selected
                btnResponder10.setEnabled(true);
            } else {
                // Disable the button if no RadioButton is selected
                btnResponder10.setEnabled(false);
            }
        });
    }

    public void testaResposta(View v) {
        if (rbtResposta40.isChecked()) {  // Assuming this RadioButton is the correct answer
            score++;
            Toast.makeText(this, userName + ", sua pontuação é: " + score, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(DecimaTelaJogo.this, Placar.class);  // Navigate to final score screen
            intent.putExtra("userName", userName);
            intent.putExtra("score", score);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Errou", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(DecimaTelaJogo.this, Placar.class);  // Navigate to final score screen
            intent.putExtra("userName", userName);
            intent.putExtra("score", score);
            startActivity(intent);
        }
    }
}
