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

public class SegundaTelaJogo extends AppCompatActivity {

    private RadioGroup rbgRespostas2;
    private RadioButton rbtResposta5;
    private RadioButton rbtResposta6;
    private RadioButton rbtResposta7;
    private RadioButton rbtResposta8;
    private Button btnResponder2;
    private String userName;
    private int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segunda_tela_jogo);

        // Override the back press behavior
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        onBackPressedDispatcher.addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(SegundaTelaJogo.this, MainActivity.class);
                startActivity(intent);
            }
        });

        rbgRespostas2 = findViewById(R.id.rbgRespostas2);
        rbtResposta5 = findViewById(R.id.rbtResposta5);
        rbtResposta6 = findViewById(R.id.rbtResposta6);
        rbtResposta7 = findViewById(R.id.rbtResposta7);
        rbtResposta8 = findViewById(R.id.rbtResposta8);
        btnResponder2 = findViewById(R.id.btnResponder2);

        Intent intent = getIntent();
        userName =  intent.getStringExtra("userName");
        score = intent.getIntExtra("score",0);

        // Set an OnCheckedChangeListener on the RadioGroup
        rbgRespostas2.setOnCheckedChangeListener((group, checkedId) -> {
            // Check if any RadioButton is checked
            if (checkedId != -1) {
                // Enable the button if a RadioButton is selected
                btnResponder2.setEnabled(true);
            } else {
                // Disable the button if no RadioButton is selected
                btnResponder2.setEnabled(false);
            }
        });
    }


    public void testaResposta(View v){

        if (rbtResposta6.isChecked()) {
            score++;
            Toast.makeText(this, userName+", sua pontuação é: "+score, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(SegundaTelaJogo.this, TerceiraTelaJogo.class);
            intent.putExtra("userName", userName);
            intent.putExtra("score",score);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Errou", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(SegundaTelaJogo.this, TerceiraTelaJogo.class);
            intent.putExtra("userName", userName);
            intent.putExtra("score",score);
            startActivity(intent);
        }
    }
}