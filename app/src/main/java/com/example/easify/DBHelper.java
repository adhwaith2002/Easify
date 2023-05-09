package com.example.easify;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME="easify.db";
    public DBHelper(Context context) {
        super(context,"easify.db",null,1);
    }

    @Override
    public void onCreate (SQLiteDatabase db){
        db.execSQL("create table users(username TEXT,email TEXT primary key,password TEXT,mobile TEXT,address TEXT,city TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db , int oldversion , int newversion){
      db.execSQL("drop table if exists users");
    }

    public Boolean insertData(String username,String email, String password,String mobile,String address,String city){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("username",username);
        values.put("email",email);
        values.put("password",password);
        values.put("mobile",mobile);
        values.put("address",address);
        values.put("city",city);

        long result = db.insert("users",null,values);
        if(result == -1) return false;
        else
            return true;
    }
    public Boolean checkemail(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=?",new String[]{email} );
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkemailpassword(String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=? and password=?",new String[]{email,password} );
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
