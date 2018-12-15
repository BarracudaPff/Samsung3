package com.samsung.barracudapff.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView view = findViewById(R.id.rec);
        view.setHasFixedSize(true);
        //линейная ориентация списка
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(new RecyclerView.Adapter<MyViewHolder>() {
            public int count = 0;

            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View view = LayoutInflater
                        .from(viewGroup.getContext())
                        .inflate(R.layout.item_note, viewGroup, false);
                return new MyViewHolder(view);
            }

            @Override
            public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {

            }

            @Override
            public int getItemCount() {
                return count;
            }
        });

        FloatingActionButton actionButton = findViewById(R.id.floatingActionButton);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.getAdapter().notifyItemInserted(
                        view.getAdapter().getItemCount()+1);
            }
        });

    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        CheckBox checkBox;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
            checkBox = itemView.findViewById(R.id.button);
        }
    }

}
