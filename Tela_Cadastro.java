package com.brunomiller.handicraft;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Tela_Cadastro extends AppCompatActivity {

    private EditText edit_nome,edit_email,edit_senha;
    private Button btnConcluir;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        getSupportActionBar().hide();

        mAuth = FirebaseAuth.getInstance();
        edit_email = edit_email.findViewById(R.id.edit_email);
        edit_nome = edit_nome.findViewById(R.id.edit_nome);
        edit_senha = edit_senha.findViewById(R.id.edit_senha);
        btnConcluir = btnConcluir.findViewById(R.id.btnConcluir);


        btnConcluir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String nome = edit_nome.getText().toString();
                String email = edit_email.getText().toString();
                String senha = edit_senha.getText().toString();

                if(!TextUtils.isEmpty(nome) || !TextUtils.isEmpty(email) || !TextUtils.isEmpty(senha)){
                    mAuth.createUserWithEmailAndPassword(email,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                abrir_tela_principal();
                            }else{
                                String error = task.getException().getMessage();
                                Toast.makeText(getApplicationContext(), "Email ou senha incorreta", Toast.LENGTH_SHORT).show();

                            }

                        }
                    });
                }
            }
        });
    }

    private void abrir_tela_principal() {
        Intent i = new Intent(Tela_Cadastro.this,Tela_Principal.class);
        startActivity(i);
        finish();
    }

    private void CadastrarUsuario(View view){
        String nome = edit_nome.getText().toString();
        String email = edit_email.getText().toString();
        String senha = edit_senha.getText().toString();


    }

}