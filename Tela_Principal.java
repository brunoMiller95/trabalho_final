package com.brunomiller.handicraft;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class Tela_Principal extends AppCompatActivity {
    private EditText edit_1,edit_2,edit_3,edit_4,comp_1,comp_2,comp_3,comp_4;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        getSupportActionBar().hide();

        edit_1=edit_1.findViewById(R.id.edit_1);
        edit_2=edit_2.findViewById(R.id.edit_2);
        edit_3=edit_3.findViewById(R.id.edit_3);
        edit_1=edit_4.findViewById(R.id.edit_4);
        comp_1=comp_1.findViewById(R.id.comp_1);
        comp_2=comp_2.findViewById(R.id.comp_2);
        comp_3=comp_3.findViewById(R.id.comp_3);
        comp_4=comp_4.findViewById(R.id.comp_4);
        mAuth=FirebaseAuth.getInstance();

    }
}