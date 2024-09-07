package com.example.quizdasbandeiras;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private Button btnIniciaQuiz;
    private Button btnSair;
    private EditText edtNome;
    private String userName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        onBackPressedDispatcher.addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //conectando o java à classe R através do XML
        btnIniciaQuiz = findViewById(R.id.btnIniciaQuiz);
        btnSair = findViewById(R.id.btnSair);
        edtNome = findViewById(R.id.edtNome);

        // Create a TextWatcher to monitor changes in the EditText
        edtNome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                // No action needed here
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                // Enable the button if there is text; otherwise, disable it
                btnIniciaQuiz.setEnabled(charSequence.length() > 0);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // No action needed here
            }
        });
    }

            public void fechar(View v) {
        finishAffinity();
    }


            public void iniciaQuiz(View v){

                userName = edtNome.getText().toString();

                Intent intent = new Intent(MainActivity.this, PrimeiraTelaJogo.class);
                intent.putExtra("userName", userName);
                startActivity(intent);

        }
    }






