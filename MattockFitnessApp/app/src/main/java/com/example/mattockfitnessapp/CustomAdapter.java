package com.example.mattockfitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{

    private Context context;
    Activity activity;
    private ArrayList client_id, client_name, client_age, client_tel, client_date, client_height, client_weight, client_bmi, client_bodyfat, client_chest, client_arms, client_waist, client_hip, client_thigh, client_calves, client_visceralfat, client_bodyage, client_bloodpressure, client_pulse, client_muscle, client_rm;

    Animation translate_anim;

    CustomAdapter(Activity activity, Context context, ArrayList client_id,
                  ArrayList client_name,
                  ArrayList client_age,
                  ArrayList client_tel,
                  ArrayList client_date,
                  ArrayList client_height,
                  ArrayList client_weight,
                  ArrayList client_bmi,
                  ArrayList client_bodyfat,
                  ArrayList client_chest,
                  ArrayList client_arms,
                  ArrayList client_waist,
                  ArrayList client_hip,
                  ArrayList client_thigh,
                  ArrayList client_calves,
                  ArrayList client_visceralfat,
                  ArrayList client_bodyage,
                  ArrayList client_bloodpressure,
                  ArrayList client_pulse,
                  ArrayList client_muscle,
                  ArrayList client_rm) {
        this.activity = activity;
        this.context = context;
        this.client_id = client_id;
        this.client_name = client_name;
        this.client_age = client_age;
        this.client_tel = client_tel;
        this.client_date = client_date;
        this.client_height = client_height;
        this.client_weight = client_weight;
        this.client_bmi = client_bmi;
        this.client_bodyfat = client_bodyfat;
        this.client_chest = client_chest;
        this.client_arms = client_arms;
        this.client_waist = client_waist;
        this.client_hip = client_hip;
        this.client_thigh = client_thigh;
        this.client_calves = client_calves;
        this.client_visceralfat = client_visceralfat;
        this.client_bodyage = client_bodyage;
        this.client_bloodpressure = client_bloodpressure;
        this.client_pulse = client_pulse;
        this.client_muscle = client_muscle;
        this.client_rm = client_rm;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.client_id_txt.setText(String.valueOf(client_id.get(position)));
        holder.client_name_txt.setText(String.valueOf(client_name.get(position)));
        holder.client_date_txt.setText(String.valueOf(client_date.get(position)));
        holder.client_age_txt.setText(String.valueOf(client_age.get(position)));
        holder.mainLayout.setOnClickListener(v -> {
            Intent intent = new Intent(context, UpdateActivity.class);
            intent.putExtra("id", String.valueOf(client_id.get(position)));
            intent.putExtra("name", String.valueOf(client_name.get(position)));
            intent.putExtra("date of registration", String.valueOf(client_date.get(position)));
            intent.putExtra("age", String.valueOf(client_age.get(position)));
            intent.putExtra("telephone", String.valueOf(client_tel.get(position)));
            intent.putExtra("height", String.valueOf(client_height.get(position)));
            intent.putExtra("weight", String.valueOf(client_weight.get(position)));
            intent.putExtra("bmi", String.valueOf(client_bmi.get(position)));
            intent.putExtra("body fat", String.valueOf(client_bodyfat.get(position)));
            intent.putExtra("chest", String.valueOf(client_chest.get(position)));
            intent.putExtra("arms", String.valueOf(client_arms.get(position)));
            intent.putExtra("waist", String.valueOf(client_waist.get(position)));
            intent.putExtra("hip", String.valueOf(client_hip.get(position)));
            intent.putExtra("thigh", String.valueOf(client_thigh.get(position)));
            intent.putExtra("calves", String.valueOf(client_calves.get(position)));
            intent.putExtra("visceral fat", String.valueOf(client_visceralfat.get(position)));
            intent.putExtra("body age", String.valueOf(client_bodyage.get(position)));
            intent.putExtra("blood pressure", String.valueOf(client_bloodpressure.get(position)));
            intent.putExtra("pulse", String.valueOf(client_pulse.get(position)));
            intent.putExtra("muscle", String.valueOf(client_muscle.get(position)));
            intent.putExtra("rm", String.valueOf(client_rm.get(position)));
            activity.startActivityForResult(intent, 1);

        });
    }

    @Override
    public int getItemCount() {
        return client_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView client_id_txt, client_name_txt, client_date_txt, client_age_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            client_id_txt = itemView.findViewById(R.id.client_id_txt);
            client_name_txt = itemView.findViewById(R.id.client_name_txt);
            client_date_txt = itemView.findViewById(R.id.client_date_txt);
            client_age_txt = itemView.findViewById(R.id.client_age_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);

            translate_anim = AnimationUtils.loadAnimation(context,R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }
    }
}