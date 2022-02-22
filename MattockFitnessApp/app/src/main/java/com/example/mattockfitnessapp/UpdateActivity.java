package com.example.mattockfitnessapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText client_name, client_age, client_tel, client_date, client_height, client_weight, client_bmi, client_bodyfat, client_arms, client_chest, client_waist, client_hip, client_thigh, client_calves, client_visceralfat, client_bodyage, client_bloodpressure, client_pulse, client_muscle, client_rm;
    Button update_button, delete_button;

    String id, name, date, age, telephone, height, weight, bmi, bodyfat, chest, arms, waist, hip, thigh, calves, visceralfat, bodyage, bloodpressure, pulse, muscle, rm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        client_name = findViewById(R.id.client_name2);
        client_age = findViewById(R.id.client_age2);
        client_tel = findViewById(R.id.client_tel2);
        client_date = findViewById(R.id.client_date2);
        client_height = findViewById(R.id.client_height2);
        client_weight = findViewById(R.id.client_weight2);
        client_bmi = findViewById(R.id.client_bmi2);
        client_bodyfat = findViewById(R.id.client_bodyfat2);
        client_arms = findViewById(R.id.client_arms2);
        client_chest = findViewById(R.id.client_chest2);
        client_waist = findViewById(R.id.client_waist2);
        client_hip = findViewById(R.id.client_hip2);
        client_thigh = findViewById(R.id.client_thigh2);
        client_calves = findViewById(R.id.client_calves2);
        client_visceralfat = findViewById(R.id.client_visceralfat2);
        client_bodyage = findViewById(R.id.client_bodyage2);
        client_bloodpressure = findViewById(R.id.client_bloodpressure2);
        client_pulse = findViewById(R.id.client_pulse2);
        client_muscle = findViewById(R.id.client_muscle2);
        client_rm = findViewById(R.id.client_rm2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);


        getAndSetIntentData();

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(name);
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                name = client_name.getText().toString().trim();
                age = client_age.getText().toString().trim();
                telephone = client_tel.getText().toString().trim();
                date = client_date.getText().toString().trim();
                height = client_height.getText().toString().trim();
                weight = client_weight.getText().toString().trim();
                bmi = client_bmi.getText().toString().trim();
                bodyfat = client_bodyfat.getText().toString().trim();
                chest = client_chest.getText().toString().trim();
                arms = client_arms.getText().toString().trim();
                waist = client_waist.getText().toString().trim();
                hip = client_hip.getText().toString().trim();
                thigh = client_thigh.getText().toString().trim();
                calves = client_calves.getText().toString().trim();
                visceralfat = client_visceralfat.getText().toString().trim();
                bodyage = client_bodyage.getText().toString().trim();
                bloodpressure = client_bloodpressure.getText().toString().trim();
                pulse = client_pulse.getText().toString().trim();
                muscle = client_muscle.getText().toString().trim();
                rm = client_rm.getText().toString().trim();

                myDB.updateData(id, name, date, age, telephone, height, weight, bmi, bodyfat, chest, arms, waist, hip, thigh, calves, visceralfat, bodyage, bloodpressure, pulse, muscle, rm);


            }
        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();
            }
        });

    }

    void getAndSetIntentData() {
        if(getIntent().hasExtra("id") && getIntent().hasExtra("name") && getIntent().hasExtra("age") &&
                getIntent().hasExtra("telephone") && getIntent().hasExtra("date of registration") && getIntent().hasExtra("height") &&
                getIntent().hasExtra("weight") && getIntent().hasExtra("bmi") &&
                getIntent().hasExtra("body fat") && getIntent().hasExtra("chest") &&
                getIntent().hasExtra("arms") && getIntent().hasExtra("waist") &&
                getIntent().hasExtra("hip") && getIntent().hasExtra("thigh") &&
                getIntent().hasExtra("calves") && getIntent().hasExtra("visceral fat") &&
                getIntent().hasExtra("body age") && getIntent().hasExtra("blood pressure") &&
                getIntent().hasExtra("pulse") && getIntent().hasExtra("muscle") && getIntent().hasExtra("rm")){

            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            age = getIntent().getStringExtra("age");
            telephone = getIntent().getStringExtra("telephone");
            date = getIntent().getStringExtra("date of registration");
            height = getIntent().getStringExtra("height");
            weight = getIntent().getStringExtra("weight");
            bmi = getIntent().getStringExtra("bmi");
            bodyfat = getIntent().getStringExtra("body fat");
            chest = getIntent().getStringExtra("chest");
            arms = getIntent().getStringExtra("arms");
            waist = getIntent().getStringExtra("waist");
            hip = getIntent().getStringExtra("hip");
            thigh = getIntent().getStringExtra("thigh");
            calves = getIntent().getStringExtra("calves");
            visceralfat = getIntent().getStringExtra("visceral fat");
            bodyage = getIntent().getStringExtra("body age");
            bloodpressure = getIntent().getStringExtra("blood pressure");
            pulse = getIntent().getStringExtra("pulse");
            muscle = getIntent().getStringExtra("muscle");
            rm = getIntent().getStringExtra("rm");

            client_name.setText(name);
            client_date.setText(date);
            client_age.setText(age);
            client_tel.setText(telephone);
            client_height.setText(height);
            client_weight.setText(weight);
            client_bmi.setText(bmi);
            client_bodyfat.setText(bodyfat);
            client_chest.setText(chest);
            client_arms.setText(arms);
            client_waist.setText(waist);
            client_hip.setText(hip);
            client_thigh.setText(thigh);
            client_calves.setText(calves);
            client_visceralfat.setText(visceralfat);
            client_bodyage.setText(bodyage);
            client_bloodpressure.setText(bloodpressure);
            client_pulse.setText(pulse);
            client_muscle.setText(muscle);
            client_rm.setText(rm);

        }else{
            Toast.makeText(this, "No data. ", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + name + " ?");
        builder.setMessage("Are you sure you want to delete " + name + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.deleteOneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }

}