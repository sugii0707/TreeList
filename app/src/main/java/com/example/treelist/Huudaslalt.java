package com.example.treelist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.List;

public class Huudaslalt extends AppCompatActivity {

    private TextView Tulguur, Temdeglel;
    private ImageView Zurag;
    private String selectedTulguur, selectedZurag, selectedTemdeglel;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.huudas);

        Tulguur = findViewById(R.id.tulguur);
        Temdeglel = findViewById(R.id.temdeglel);
        Zurag = findViewById(R.id.zurag);

        Intent receive = getIntent();

        selectedTulguur = receive.getStringExtra("Tulguur");
        selectedZurag = receive.getStringExtra("Zurag");
        selectedTemdeglel = receive.getStringExtra("Temdeglel");


        Tulguur.setText(selectedTulguur);
        Temdeglel.setText(selectedTemdeglel);

        Glide.with(this).load(selectedZurag).into(Zurag);

    }

}
