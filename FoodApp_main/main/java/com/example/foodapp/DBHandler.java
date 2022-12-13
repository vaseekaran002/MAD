package com.example.foodapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHandler extends SQLiteOpenHelper {

    private final static String DB_NAME = "food";
    private final static int DB_VERSION = 1;
    private final static String TABLE_NAME = "RECIPES";
    private final static String ID_COL = "ID";
    private final static String RECIPE_NAME_COL = "RECIPE_NAME";
    private final static String RECIPE_DESC_COL = "RECIPE_DESC";
    private final static String CATEGORY = "CATEGORY";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("checkone", "hello");
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + RECIPE_NAME_COL + " TEXT UNIQUE, "
                + RECIPE_DESC_COL + " TEXT, "
                + CATEGORY + " TEXT)";

        db.execSQL(query);
    }

    public void populateTable() {
        insert("idly", "abcd", "BREAKFAST");
        insert("dosa", "abcd", "BREAKFAST");
        insert("poori", "abcd", "BREAKFAST");
        insert("Sambar Rice", "abcd", "LUNCH");
    }

    public void insert(String name, String desc, String category) {
        SQLiteDatabase db = this.getWritableDatabase();
        Log.i("check", "hello");
        ContentValues values = new ContentValues();

        values.put(RECIPE_NAME_COL, name);
        values.put(RECIPE_DESC_COL, desc);
        values.put(CATEGORY, category);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String getRecipes(String category) {
        String s = "";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE CATEGORY = '" + category + "'", null);

        if(cursor.moveToFirst()) {
            do {
                s += "\n**************************************\n" + cursor.getInt(0) + ". Recipe Name: " + cursor.getString(1) + "\nProcedure: \n" + cursor.getString(2) + "\n**************************************\n";
            } while(cursor.moveToNext());
        }
        cursor.close();
        return s;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
