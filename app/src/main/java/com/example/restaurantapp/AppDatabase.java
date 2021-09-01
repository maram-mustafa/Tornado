package com.example.restaurantapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

// create database
@Database(entities = {Dish.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DishDao dishDao();
}
