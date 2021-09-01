package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String dish= intent.getExtras().getString("dish");
        TextView newDish= findViewById(R.id.ingredirents);
        newDish.setText(dish);

        Button backMenuButton= findViewById(R.id.backToMenuBtn);

        backMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToMenuPage= new Intent(Detail.this,Menu.class);
                startActivity(goToMenuPage);
            }
        });

    }
}