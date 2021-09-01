package com.example.restaurantapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Dish {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name = "dishName")
    public String dishName ;
    @ColumnInfo(name = "dishPrice")
    public String dishPrice;
    @ColumnInfo(name = "dishIngredients")
    public String dishIngredients;

    public Dish(String dishName, String dishPrice, String dishIngredients) {
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.dishIngredients = dishIngredients;
    }
}
