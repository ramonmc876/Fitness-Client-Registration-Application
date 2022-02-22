package com.example.mattockfitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText client_name, client_age, client_tel, client_date, client_height, client_weight, client_bmi, client_bodyfat, client_chest, client_arms, client_waist, client_hip, client_thigh, client_calves, client_visceralfat, client_bodyage, client_bloodpressure, client_pulse, client_muscle, client_rm;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        client_name = findViewById(R.id.client_name);
        client_age = findViewById(R.id.client_age);
        client_tel = findViewById(R.id.client_tel);
        client_date = findViewById(R.id.client_date);
        client_height = findViewById(R.id.client_height);
        client_weight = findViewById(R.id.client_weight);
        client_bmi = findViewById(R.id.client_bmi);
        client_bodyfat = findViewById(R.id.client_bodyfat);
        client_chest = findViewById(R.id.client_chest);
        client_arms = findViewById(R.id.client_arms);
        client_waist = findViewById(R.id.client_waist);
        client_hip = findViewById(R.id.client_hip);
        client_thigh = findViewById(R.id.client_thigh);
        client_calves = findViewById(R.id.client_calves);
        client_visceralfat = findViewById(R.id.client_visceralfat);
        client_bodyage = findViewById(R.id.client_bodyage);
        client_bloodpressure = findViewById(R.id.client_bloodpressure);
        client_pulse = findViewById(R.id.client_pulse);
        client_muscle = findViewById(R.id.client_muscle);
        client_rm = findViewById(R.id.client_rm);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addClient(client_name.getText().toString().trim(),
                        Integer.valueOf(client_age.getText().toString().trim()),
                        Integer.valueOf(client_tel.getText().toString().trim()),
                        Integer.valueOf(client_date.getText().toString().trim()),
                        Integer.valueOf(client_height.getText().toString().trim()),
                        Integer.valueOf(client_weight.getText().toString().trim()),
                        Integer.valueOf(client_bmi.getText().toString().trim()),
                        Integer.valueOf(client_bodyfat.getText().toString().trim()),
                        Integer.valueOf(client_chest.getText().toString().trim()),
                        Integer.valueOf(client_arms.getText().toString().trim()),
                        Integer.valueOf(client_waist.getText().toString().trim()),
                        Integer.valueOf(client_hip.getText().toString().trim()),
                        Integer.valueOf(client_thigh.getText().toString().trim()),
                        Integer.valueOf(client_calves.getText().toString().trim()),
                        Integer.valueOf(client_visceralfat.getText().toString().trim()),
                        Integer.valueOf(client_bodyage.getText().toString().trim()),
                        Integer.valueOf(client_bloodpressure.getText().toString().trim()),
                        Integer.valueOf(client_pulse.getText().toString().trim()),
                        Integer.valueOf(client_muscle.getText().toString().trim()),
                        Integer.valueOf(client_rm.getText().toString().trim()));
            }
        });
    }
}