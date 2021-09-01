package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;

import java.util.List;

public class Menu extends AppCompatActivity {
    AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // CREATE INSTANCE FROM DATABASE
        appDatabase  =  Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "Dishdatabase").allowMainThreadQueries().build();
        // CREATE INSTANCE FROM DAO
        DishDao dishDao = appDatabase.dishDao();
        List<Dish> dishes = dishDao.getAll();

        // LET RECYCLERVIEW REPRESENT DATA FROM FROM
        RecyclerView alldishesRecyclerView = findViewById(R.id.dishRecyclerView);
        alldishesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        alldishesRecyclerView.setAdapter(new DishAdapter(dishes));
    }
}