package com.example.quizdasbandeiras;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Placar extends AppCompatActivity {

    private Button btnTelaPrincipal;
    private Button btnTentarNovamente;
    private TextView txvAcertos;
    private TextView txvMensagem;
    private String userName;
    private int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_placar);

        // Override the back press behavior
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        onBackPressedDispatcher.addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(Placar.this, MainActivity.class);
                startActivity(intent);
            }
        });

        txvAcertos = findViewById(R.id.txvAcertos);
        txvMensagem = findViewById(R.id.txvMensagem);
        btnTelaPrincipal = findViewById(R.id.btnTelaPrincipal);
        btnTentarNovamente = findViewById(R.id.btnTentarNovamente);

        Intent intent = getIntent();
        userName =  intent.getStringExtra("userName");
        score = intent.getIntExtra("score",0);
        String points = String.valueOf(score);


        txvAcertos.setText(points+"/10");
        if(score<=5){
            txvMensagem.setTextColor(ContextCompat.getColor(this, R.color.primary_color));
            // Or set the text color using a hex color code
            txvMensagem.setText("Mais sorte na próxima "+userName+" \uD83D\uDE14");
        }else{
            txvMensagem.setText("Parabéns "+userName+" \uD83D\uDE03");
        }
    }

    public void telaPrincipal(View view){
        Intent intent = new Intent(Placar.this, MainActivity.class);
        startActivity(intent);
    }

    public void responderNovamente(View view){
        Intent intent = new Intent(Placar.this, PrimeiraTelaJogo.class);
        intent.putExtra("userName", userName);
        startActivity(intent);
    }

}