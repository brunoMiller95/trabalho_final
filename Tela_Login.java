package com.brunomiller.handicraft;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Tela_Login extends AppCompatActivity {
    private TextView txtCadastrar;
    private EditText edit_email, edit_senha;
    private Button btnEntrar;
    private ProgressBar progress;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        getSupportActionBar().hide();
        mAuth = FirebaseAuth.getInstance();
        edit_email = findViewById(R.id.edit_email);
        edit_senha = findViewById(R.id.edit_senha);
        btnEntrar = findViewById(R.id.btnEntrar);
        progress = findViewById(R.id.progress);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edit_email.getText().toString();
                String senha = edit_senha.getText().toString();
                if(!TextUtils.isEmpty(email) || !TextUtils.isEmpty(senha)){
                    progress.setVisibility(View.VISIBLE);
                    mAuth.signInWithEmailAndPassword(email,senha)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        abrir_Tela_Principal();
                                    }else{
                                        String error = task.getException().getMessage();
                                        Toast.makeText(Tela_Login.this,""+error,Toast.LENGTH_SHORT).show();
                                        progress.setVisibility(View.INVISIBLE);
                                    }

                                }
                            });
                }
            }
        });

    }

    private void abrir_Tela_Principal() {
        Intent i = new Intent(Tela_Login.this,Tela_Principal.class);
        startActivity(i);
        finish();
    }
}