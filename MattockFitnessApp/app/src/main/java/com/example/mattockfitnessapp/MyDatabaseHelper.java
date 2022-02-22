package com.example.mattockfitnessapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "CLibrary.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my_library";
    private static final String COLUMN_ID = "client_id";
    private static final String COLUMN_NAME = "client_name";
    private static final String COLUMN_AGE = "client_age";
    private static final String COLUMN_TEL = "client_tel";
    private static final String COLUMN_DATE = "client_date";
    private static final String COLUMN_HEIGHT = "client_height";
    private static final String COLUMN_WEIGHT = "client_weight";
    private static final String COLUMN_BMI = "client_bmi";
    private static final String COLUMN_BODYFAT = "client_bodyfat";
    private static final String COLUMN_CHEST = "client_chest";
    private static final String COLUMN_ARMS = "client_arms";
    private static final String COLUMN_WAIST = "client_waist";
    private static final String COLUMN_HIP = "client_hip";
    private static final String COLUMN_THIGH = "client_thigh";
    private static final String COLUMN_CALVES = "client_calves";
    private static final String COLUMN_VISCERALFAT = "client_visfat";
    private static final String COLUMN_BODYAGE = "client_bodyage";
    private static final String COLUMN_BLOODPRESSURE = "client_bloodpressure";
    private static final String COLUMN_PULSERATE = "client_pulse";
    private static final String COLUMN_MUSCLE = "client_muscle";
    private static final String COLUMN_RM = "client_rm";

    MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NAME + " TEXT, " +
                        COLUMN_AGE + " INTEGER, " +
                        COLUMN_TEL + " INTEGER, " +
                        COLUMN_DATE + " INTEGER, " +
                        COLUMN_HEIGHT + " INTEGER, " +
                        COLUMN_WEIGHT + " INTEGER, " +
                        COLUMN_BMI + " INTEGER, " +
                        COLUMN_BODYFAT + " INTEGER, " +
                        COLUMN_CHEST + " INTEGER, " +
                        COLUMN_ARMS + " INTEGER, " +
                        COLUMN_WAIST + " INTEGER, " +
                        COLUMN_HIP + " INTEGER, " +
                        COLUMN_THIGH + " INTEGER, " +
                        COLUMN_CALVES + " INTEGER, " +
                        COLUMN_VISCERALFAT + " INTEGER, " +
                        COLUMN_BODYAGE + " INTEGER, " +
                        COLUMN_BLOODPRESSURE + " INTEGER, " +
                        COLUMN_PULSERATE + " INTEGER, " +
                        COLUMN_MUSCLE + " INTEGER, " +
                        COLUMN_RM + " INTEGER);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    void addClient(String name, int age, int tel, int date, int height, int weight, int bmi, int bodyfat, int chest, int arms, int waist, int hip, int thigh, int calves, int visceralfat, int bodyage, int bloodpres, int pulse, int muscle, int rm){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_AGE, age);
        cv.put(COLUMN_TEL, tel);
        cv.put(COLUMN_DATE, date);
        cv.put(COLUMN_HEIGHT, height);
        cv.put(COLUMN_WEIGHT, weight);
        cv.put(COLUMN_BMI, bmi);
        cv.put(COLUMN_BODYFAT, bodyfat);
        cv.put(COLUMN_CHEST, chest);
        cv.put(COLUMN_ARMS, arms);
        cv.put(COLUMN_WAIST, waist);
        cv.put(COLUMN_HIP, hip);
        cv.put(COLUMN_THIGH, thigh);
        cv.put(COLUMN_CALVES, calves);
        cv.put(COLUMN_VISCERALFAT, visceralfat);
        cv.put(COLUMN_BODYAGE, bodyage);
        cv.put(COLUMN_BLOODPRESSURE, bloodpres);
        cv.put(COLUMN_PULSERATE, pulse);
        cv.put(COLUMN_MUSCLE, muscle);
        cv.put(COLUMN_RM, rm);
        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1){
            Toast.makeText(context, "Failed!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added successfully!", Toast.LENGTH_SHORT).show();
        }

    }

    Cursor readAllData() {
        String query = " SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateData(String row_id, String name, String date, String age, String tel, String height, String weight, String bmi, String bodyfat, String chest, String arms, String waist, String hip, String thigh, String calves, String visceralfat, String bodyage, String bloodpressure, String pulse, String muscle, String rm){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_AGE, age);
        cv.put(COLUMN_TEL, tel);
        cv.put(COLUMN_DATE, date);
        cv.put(COLUMN_HEIGHT, height);
        cv.put(COLUMN_WEIGHT, weight);
        cv.put(COLUMN_BMI, bmi);
        cv.put(COLUMN_BODYFAT, bodyfat);
        cv.put(COLUMN_CHEST, chest);
        cv.put(COLUMN_ARMS, arms);
        cv.put(COLUMN_WAIST, waist);
        cv.put(COLUMN_HIP, hip);
        cv.put(COLUMN_THIGH, thigh);
        cv.put(COLUMN_CALVES, calves);
        cv.put(COLUMN_VISCERALFAT, visceralfat);
        cv.put(COLUMN_BODYAGE, bodyage);
        cv.put(COLUMN_BLOODPRESSURE, bloodpressure);
        cv.put(COLUMN_PULSERATE, pulse);
        cv.put(COLUMN_MUSCLE, muscle);
        cv.put(COLUMN_RM, rm);

        long result = db.update(TABLE_NAME, cv, "client_id=?", new String[]{row_id});
        if (result == -1){
            Toast.makeText(context, "Failed to Update", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Succesfully Updated", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "client_id=?", new String[]{row_id});
        if (result == -1){
            Toast.makeText(context, "Failed to Delete", Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(context, "Successfully Deleted", Toast.LENGTH_SHORT).show();
    }

    void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }
}
