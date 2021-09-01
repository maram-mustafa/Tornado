package com.example.restaurantapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DishAdapter extends RecyclerView.Adapter<DishAdapter.DishViewHolder> {
    // step 1
    List<Dish> dishes = new ArrayList<Dish>();

    public DishAdapter(List<Dish> dishes) {
        this.dishes = dishes;
    }

    // step 2
    public static class DishViewHolder extends RecyclerView.ViewHolder {
        // step 3
        public Dish dish;
        // step 4
        View itemView;

        public DishViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView; // set View to the one will pass

            ///////////////////////  open details
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent goToDetailsPage = new Intent(view.getContext(), Detail.class);
                    goToDetailsPage.putExtra("dish", dish.dishIngredients);
                    view.getContext().startActivity(goToDetailsPage);
                }
            });

        }
    }

    @NonNull
    @Override  // create a view that will present task in UI
    public DishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create new view out of fragment
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_dish_item, parent, false);
        // create viewHolder thats wrap that view
        DishViewHolder dishViewHolder = new DishViewHolder(view);
        return dishViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DishViewHolder holder, int position) {
        // to bind the data that i have in that position inside list that the holder passing
        holder.dish=dishes.get(position);


        TextView dishName = holder.itemView.findViewById(R.id.dishNameInFragment);
        TextView dishPrice = holder.itemView.findViewById(R.id.dishPriceInFragment);

        dishName.setText(holder.dish.dishName);
        dishPrice.setText(holder.dish.dishPrice);

    }

    @Override
    public int getItemCount() {
        return dishes.size();
    }


}

//////////// NOTES:
// 1. create class
//2.  every adapter should have a list of data that will be use to bind with viewHolder
// 3.  create the viewHodler class -> inner class that (static -> create viewHolder without create instance of taskAdapter )
// 4. model object
//5. view object
// - @nonNull -> it can't be a null
//6. extend RecyclerVBiew.Adapter
//7. Oncreate-> when ever create a new viewHolder then this viewHolder wraps view
// so 1) create view thats wrap to have ui element
// fragment is responseple of creating the views