package com.example.mattockfitnessapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton add_button;

    MyDatabaseHelper myDB;
    ArrayList<String> client_id, client_name, client_age, client_tel, client_date, client_height, client_weight, client_bmi, client_bodyfat, client_chest, client_arms, client_waist, client_hip, client_thigh, client_calves, client_visceralfat, client_bodyage, client_bloodpressure, client_pulse, client_muscle, client_rm;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        myDB = new MyDatabaseHelper(MainActivity.this);
        client_id = new ArrayList<>();
        client_name = new ArrayList<>();
        client_age = new ArrayList<>();
        client_tel = new ArrayList<>();
        client_date = new ArrayList<>();
        client_height = new ArrayList<>();
        client_weight = new ArrayList<>();
        client_bmi = new ArrayList<>();
        client_bodyfat = new ArrayList<>();
        client_chest = new ArrayList<>();
        client_arms = new ArrayList<>();
        client_waist = new ArrayList<>();
        client_hip =  new ArrayList<>();
        client_thigh = new ArrayList<>();
        client_calves = new ArrayList<>();
        client_visceralfat = new ArrayList<>();
        client_bodyage = new ArrayList<>();
        client_bloodpressure = new ArrayList<>();
        client_pulse = new ArrayList<>();
        client_muscle = new ArrayList<>();
        client_rm = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomAdapter(MainActivity.this, this, client_id, client_name, client_age, client_tel, client_date, client_height, client_weight, client_bmi, client_bodyfat, client_chest, client_arms, client_waist, client_hip, client_thigh, client_calves, client_visceralfat, client_bodyage, client_bloodpressure, client_pulse, client_muscle, client_rm);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            recreate();
        }
    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()) {
                client_id.add(cursor.getString(0));
                client_name.add(cursor.getString(1));
                client_age.add(cursor.getString(2));
                client_tel.add(cursor.getString(3));
                client_date.add(cursor.getString(4));
                client_height.add(cursor.getString(5));
                client_weight.add(cursor.getString(6));
                client_bmi.add(cursor.getString(7));
                client_bodyfat.add(cursor.getString(8));
                client_chest.add(cursor.getString(9));
                client_arms.add(cursor.getString(10));
                client_waist.add(cursor.getString(11));
                client_hip.add(cursor.getString(12));
                client_thigh.add(cursor.getString(13));
                client_calves.add(cursor.getString(14));
                client_visceralfat.add(cursor.getString(15));
                client_bodyage.add(cursor.getString(16));
                client_bloodpressure.add(cursor.getString(17));
                client_pulse.add(cursor.getString(18));
                client_muscle.add(cursor.getString(19));
                client_rm.add(cursor.getString(20));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.delete_all){
            confirmDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete All ?");
        builder.setMessage("Are you sure you want to delete all data?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(MainActivity.this);
                myDB.deleteAllData();
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
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