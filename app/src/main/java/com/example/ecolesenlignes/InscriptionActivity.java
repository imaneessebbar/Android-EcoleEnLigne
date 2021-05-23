package com.example.ecolesenlignes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.card.MaterialCardView;

public class InscriptionActivity extends AppCompatActivity {
    MaterialCardView parent,enfant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        parent=findViewById(R.id.ParentCard);
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), InscriptionParentActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
        enfant=findViewById(R.id.StudentCard);
        enfant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent=new Intent(getApplicationContext(), InscriptionEnfantActivity.class);
            startActivity(intent);
            }
        });
    }



}
