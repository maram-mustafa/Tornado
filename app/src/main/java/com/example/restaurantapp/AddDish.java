package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddDish extends AppCompatActivity {

    AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dish);

        Button addTaskButton= findViewById(R.id.submitDishButton);
        EditText dishName = findViewById(R.id.editTextDishName);
        EditText dishPrice =findViewById(R.id.editTextDishPrice);
        EditText dishIngredients = findViewById(R.id.editTextDishIngredients);


        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dish newDish = new Dish(dishName.getText().toString(), dishPrice.getText().toString(),dishIngredients.getText().toString());

                appDatabase  =  Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "Dishdatabase").allowMainThreadQueries().build();

                DishDao taskDao = appDatabase.dishDao();
                taskDao.insertAll(newDish);

                Toast.makeText(getApplicationContext(), "submitted!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


// Notes :
// 1) need to gte buuton (submit) and EditText for three input
//2) need to add listener
//     - need to create new instance from model (Dish) add pass the value from editText
//     - create instance from dataBase
//     - create instance from Doa