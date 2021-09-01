package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get two buttons
        Button addDishButton = findViewById(R.id.addDishButton);
        Button menuButton = findViewById(R.id.menuButton);

        // add click listener for each button
        addDishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToAddDish= new Intent(MainActivity.this,AddDish.class);
                startActivity(goToAddDish);
            }
        });

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToMenu = new Intent(MainActivity.this,Menu.class);
                startActivity(goToMenu);
            }
        });



    }
}