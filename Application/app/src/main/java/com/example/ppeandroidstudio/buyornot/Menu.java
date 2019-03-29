package com.example.ppeandroidstudio.buyornot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void ListerProduits(View view){
        Intent intent = new Intent(this, ListerProduits.class);
        startActivity(intent);
    }

    public void AjouterProduits(View view){
        Intent intent = new Intent(this, AjouterProduits.class);
        startActivity(intent);
    }
}
