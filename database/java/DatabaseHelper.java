package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public  static  final String DB_NAME = "employee";
    public  static  final int DB_VERSION = 1;

    public DatabaseHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS EMPLOYEES (" +
                   "EMP_ID TEXT PRIMARY KEY ," +
                   "NAME TEXT ," +
                   "GENDER TEXT," +
                   "DEPARTMENT TEXT," +
                   "SALARY NUMERIC ); ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS EMPLOYEES;");
        onCreate(db);
    }

    public void addRecord(String emp_id,String name,String gender,String dpt,double salary){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues record = new ContentValues();

        record.put("EMP_ID",emp_id);
        record.put("NAME",name);
        record.put("GENDER",gender);
        record.put("DEPARTMENT",dpt);
        record.put("SALARY",salary);

        db.insertOrThrow("EMPLOYEES",null,record);
        db.close();
    }

    public  String[] retrieveRecord(String empid){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("EMPLOYEES",new  String[] {"EMP_ID","NAME","GENDER","DEPARTMENT","SALARY"}, "EMP_ID = ?",
                                   new String[] {empid},null,null,null);
        String results[] = new String[4];
        if(cursor.moveToNext()){
            results[0] = cursor.getString(0);
            results[1] = cursor.getString(1);
            results[2] = cursor.getString(2);
            results[3] = Double.toString(cursor.getDouble(3));

            return  results;
        }else {
            return null;
        }

    }
}
