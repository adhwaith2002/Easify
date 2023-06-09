package com.example.easify;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {


    public static final String DBNAME="easify.db";
    public DBHelper(Context context) {
        super(context,"easify.db",null,1);
    }

    @Override
    public void onCreate (SQLiteDatabase db){
        db.execSQL("create table users(username TEXT,email TEXT primary key,password TEXT,mobile TEXT,address TEXT,city TEXT)");
        db.execSQL("create table plumber(plumber_name TEXT,plumber_email TEXT primary key,plumber_password TEXT,plumber_mobile TEXT,plumber_address TEXT,plumber_city TEXT,plumber_status INTEGER)");
        db.execSQL("create table painter(painter_name TEXT,painter_email TEXT primary key,painter_password TEXT,painter_mobile TEXT,painter_address TEXT,painter_city TEXT,painter_status INTEGER)");
        db.execSQL("create table carmechanic(carmechanic_name TEXT,carmechanic_email TEXT primary key,carmechanic_password TEXT,carmechanic_mobile TEXT,carmechanic_address TEXT,carmechanic_city TEXT,carmechanic_status INTEGER)");
        db.execSQL("create table electrician(electrician_name TEXT,electrician_email TEXT primary key,electrician_password TEXT,electrician_mobile TEXT,electrician_address TEXT,electrician_city TEXT,electrician_status INTEGER)");
        db.execSQL("create table housecleaner(cleaner_name TEXT,cleaner_email TEXT primary key,cleaner_password TEXT,cleaner_mobile TEXT,cleaner_address TEXT,cleaner_city TEXT,cleaner_status INTEGER)");
        db.execSQL("create table appliancerepair(appliancerepair_name TEXT,appliancerepair_email TEXT primary key,appliancerepair_password TEXT,appliancerepair_mobile TEXT,appliancerepair_address TEXT,appliancerepair_city TEXT,appliancerepair_status INTEGER)");
        db.execSQL("create table treecutter(treecutter_name TEXT,treecutter_email TEXT primary key,treecutter_password TEXT,treecutter_mobile TEXT,treecutter_address TEXT,treecutter_city TEXT,treecutter_status INTEGER)");
        db.execSQL("create table gardener(gardener_name TEXT,gardener_email TEXT primary key,gardener_password TEXT,gardener_mobile TEXT,gardener_address TEXT,gardener_city TEXT,gardener_status INTEGER)");
        db.execSQL("create table cook(cook_name TEXT,cook_email TEXT primary key,cook_password TEXT,cook_mobile TEXT,cook_address TEXT,cook_city TEXT,cook_status INTEGER)");
        db.execSQL("create table driver(driver_name TEXT,driver_email TEXT primary key,driver_password TEXT,driver_mobile TEXT,driver_address TEXT,driver_city TEXT,driver_status INTEGER)");
        db.execSQL("create table admin(admin_name TEXT,admin_email TEXT primary key,admin_password TEXT,admin_mobile TEXT,admin_address TEXT,admin_city TEXT)");
        db.execSQL("create table user_plumber(user_email TEXT,plumber_email TEXT,work_status INTEGER)");
        db.execSQL("create table user_painter(user_email TEXT,painter_email TEXT,work_status INTEGER)");
        db.execSQL("create table user_carmechanic(user_email TEXT,carmechanic_email TEXT,work_status INTEGER)");
        db.execSQL("create table user_electrician(user_email TEXT,electrician_email TEXT,work_status INTEGER)");
        db.execSQL("create table user_housecleaner(user_email TEXT,cleaner_email TEXT,work_status INTEGER)");
        db.execSQL("create table user_appliancerepair(user_email TEXT,appliancerepair_email TEXT,work_status INTEGER)");
        db.execSQL("create table user_treecutter(user_email TEXT,treecutter_email TEXT,work_status INTEGER)");
        db.execSQL("create table user_gardener(user_email TEXT,gardener_email TEXT,work_status INTEGER)");
        db.execSQL("create table user_cook(user_email TEXT,cook_email TEXT,work_status INTEGER)");
        db.execSQL("create table user_driver(user_email TEXT,driver_email TEXT,work_status INTEGER)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db , int oldversion , int newversion){
      db.execSQL("drop table if exists users");
      db.execSQL("drop table if exists plumber");
      db.execSQL("drop table if exists painter");
      db.execSQL("drop table if exists carmechanic");
      db.execSQL("drop table if exists electrician");
      db.execSQL("drop table if exists housecleaner");
      db.execSQL("drop table if exists appliancerepair");
      db.execSQL("drop table if exists treecutter");
      db.execSQL("drop table if exists gardener");
      db.execSQL("drop table if exists cook");
      db.execSQL("drop table if exists driver");
      db.execSQL("drop table if exists admin");
      db.execSQL("drop table if exists user_plumber");
      db.execSQL("drop table if exists user_painter");
      db.execSQL("drop table if exists user_carmechanic");
      db.execSQL("drop table if exists user_electrician");
      db.execSQL("drop table if exists user_housecleaner");
      db.execSQL("drop table if exists user_appliancerepair");
      db.execSQL("drop table if exists user_treecutter");
      db.execSQL("drop table if exists user_gardener");
      db.execSQL("drop table if exists user_cook");
      db.execSQL("drop table if exists user_driver");
    }

    public Boolean insertData(String username,String email, String password,String mobile,String address,String city) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values1 = new ContentValues();


        values1.put("username", username);
        values1.put("email", email);
        values1.put("password", password);
        values1.put("mobile", mobile);
        values1.put("address", address);
        values1.put("city", city);

        long result1 = db.insert("users", null, values1);
        return result1 != -1;
    }
    public Boolean insertAdminData(String username,String email, String password,String mobile,String address,String city) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("admin_name", username);
        values.put("admin_email", email);
        values.put("admin_password", password);
        values.put("admin_mobile", mobile);
        values.put("admin_address", address);
        values.put("admin_city", city);

        long result1 = db.insert("admin", null, values);
        return result1 != -1;
    }
    public Boolean insertPlumberData(String username, String email, String password, String mobile, String address, String city){
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues values2 = new ContentValues();
        values2.put("plumber_name",username);
        values2.put("plumber_email",email);
        values2.put("plumber_password",password);
        values2.put("plumber_mobile",mobile);
        values2.put("plumber_address",address);
        values2.put("plumber_city",city);
        values2.put("plumber_status",0);


        long result2 = db.insert("plumber",null,values2);
        return result2 != -1;
    }

    public Boolean insertPainterData(String username, String email, String password, String mobile, String address, String city){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values3 = new ContentValues();
        values3.put("painter_name",username);
        values3.put("painter_email",email);
        values3.put("painter_password",password);
        values3.put("painter_mobile",mobile);
        values3.put("painter_address",address);
        values3.put("painter_city",city);
        values3.put("painter_status",0);


        long result3 = db.insert("painter",null,values3);
        return result3 != -1;
    }

    public Boolean insertCarmechanicData(String username, String email, String password, String mobile, String address, String city){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values4 = new ContentValues();
        values4.put("carmechanic_name",username);
        values4.put("carmechanic_email",email);
        values4.put("carmechanic_password",password);
        values4.put("carmechanic_mobile",mobile);
        values4.put("carmechanic_address",address);
        values4.put("carmechanic_city",city);
        values4.put("carmechanic_status",0);


        long result4 = db.insert("carmechanic",null,values4);
        return result4 != -1;
    }
    public Boolean insertElectricianData(String username, String email, String password, String mobile, String address, String city){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values5 = new ContentValues();
        values5.put("electrician_name",username);
        values5.put("electrician_email",email);
        values5.put("electrician_password",password);
        values5.put("electrician_mobile",mobile);
        values5.put("electrician_address",address);
        values5.put("electrician_city",city);
        values5.put("electrician_status",0);


        long result5 = db.insert("electrician",null,values5);
        return result5 != -1;
    }
    public Boolean insertHousecleaningData(String username, String email, String password, String mobile, String address, String city){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values6 = new ContentValues();
        values6.put("cleaner_name",username);
        values6.put("cleaner_email",email);
        values6.put("cleaner_password",password);
        values6.put("cleaner_mobile",mobile);
        values6.put("cleaner_address",address);
        values6.put("cleaner_city",city);
        values6.put("cleaner_status",0);


        long result6 = db.insert("housecleaner",null,values6);
        return result6 != -1;
    }

    public Boolean insertAppliancerepairData(String username, String email, String password, String mobile, String address, String city){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values7 = new ContentValues();
        values7.put("appliancerepair_name",username);
        values7.put("appliancerepair_email",email);
        values7.put("appliancerepair_password",password);
        values7.put("appliancerepair_mobile",mobile);
        values7.put("appliancerepair_address",address);
        values7.put("appliancerepair_city",city);
        values7.put("appliancerepair_status",0);


        long result7 = db.insert("appliancerepair",null,values7);
        return result7 != -1;
    }
    public Boolean insertTreecutterData(String username, String email, String password, String mobile, String address, String city){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values8 = new ContentValues();
        values8.put("treecutter_name",username);
        values8.put("treecutter_email",email);
        values8.put("treecutter_password",password);
        values8.put("treecutter_mobile",mobile);
        values8.put("treecutter_address",address);
        values8.put("treecutter_city",city);
        values8.put("treecutter_status",0);


        long result8 = db.insert("treecutter",null,values8);
        return result8 != -1;
    }
    public Boolean insertGardeningData(String username, String email, String password, String mobile, String address, String city){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values9 = new ContentValues();
        values9.put("gardener_name",username);
        values9.put("gardener_email",email);
        values9.put("gardener_password",password);
        values9.put("gardener_mobile",mobile);
        values9.put("gardener_address",address);
        values9.put("gardener_city",city);
        values9.put("gardener_status",0);


        long result9 = db.insert("gardener",null,values9);
        return result9 != -1;
    }
    public Boolean insertCookData(String username, String email, String password, String mobile, String address, String city){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values10 = new ContentValues();
        values10.put("cook_name",username);
        values10.put("cook_email",email);
        values10.put("cook_password",password);
        values10.put("cook_mobile",mobile);
        values10.put("cook_address",address);
        values10.put("cook_city",city);
        values10.put("cook_status",0);


        long result10 = db.insert("cook",null,values10);
        return result10 != -1;
    }
    public Boolean insertDriverData(String username, String email, String password, String mobile, String address, String city){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values11 = new ContentValues();
        values11.put("driver_name",username);
        values11.put("driver_email",email);
        values11.put("driver_password",password);
        values11.put("driver_mobile",mobile);
        values11.put("driver_address",address);
        values11.put("driver_city",city);
        values11.put("driver_status",0);


        long result11 = db.insert("driver",null,values11);
        return result11 != -1;
    }

    public Boolean checkemail(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=?",new String[]{email} );
        Cursor cursor1 = db.rawQuery("select * from plumber where plumber_email=?",new String[]{email} );
        Cursor cursor2 = db.rawQuery("select * from painter where painter_email=?",new String[]{email} );
        Cursor cursor3 = db.rawQuery("select * from carmechanic where carmechanic_email=?",new String[]{email} );
        Cursor cursor4 = db.rawQuery("select * from electrician where electrician_email=?",new String[]{email} );
        Cursor cursor5 = db.rawQuery("select * from housecleaner where cleaner_email=?",new String[]{email} );
        Cursor cursor6 = db.rawQuery("select * from appliancerepair where appliancerepair_email=?",new String[]{email} );
        Cursor cursor7 = db.rawQuery("select * from treecutter where treecutter_email=?",new String[]{email} );
        Cursor cursor8 = db.rawQuery("select * from gardener where gardener_email=?",new String[]{email} );
        Cursor cursor9 = db.rawQuery("select * from cook where cook_email=?",new String[]{email} );
        Cursor cursor10 = db.rawQuery("select * from driver where driver_email=?",new String[]{email} );
        if(cursor.getCount()>0 || cursor1.getCount()>0 || cursor2.getCount()>0 || cursor3.getCount()>0 || cursor4.getCount()>0 || cursor5.getCount()>0 || cursor6.getCount()>0 || cursor7.getCount()>0 || cursor8.getCount()>0 || cursor9.getCount()>0 || cursor10.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkplumberemail(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=?",new String[]{email} );
        Cursor cursor1 = db.rawQuery("select * from plumber where plumber_email=?",new String[]{email} );
        Cursor cursor2 = db.rawQuery("select * from painter where painter_email=?",new String[]{email} );
        Cursor cursor3 = db.rawQuery("select * from carmechanic where carmechanic_email=?",new String[]{email} );
        Cursor cursor4 = db.rawQuery("select * from electrician where electrician_email=?",new String[]{email} );
        Cursor cursor5 = db.rawQuery("select * from housecleaner where cleaner_email=?",new String[]{email} );
        Cursor cursor6 = db.rawQuery("select * from appliancerepair where appliancerepair_email=?",new String[]{email} );
        Cursor cursor7 = db.rawQuery("select * from treecutter where treecutter_email=?",new String[]{email} );
        Cursor cursor8 = db.rawQuery("select * from gardener where gardener_email=?",new String[]{email} );
        Cursor cursor9 = db.rawQuery("select * from cook where cook_email=?",new String[]{email} );
        Cursor cursor10 = db.rawQuery("select * from driver where driver_email=?",new String[]{email} );
        if(cursor.getCount()>0 || cursor1.getCount()>0 || cursor2.getCount()>0 || cursor3.getCount()>0 || cursor4.getCount()>0 || cursor5.getCount()>0 || cursor6.getCount()>0 || cursor7.getCount()>0 || cursor8.getCount()>0 || cursor9.getCount()>0 || cursor10.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkpainteremail(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=?",new String[]{email} );
        Cursor cursor1 = db.rawQuery("select * from plumber where plumber_email=?",new String[]{email} );
        Cursor cursor2 = db.rawQuery("select * from painter where painter_email=?",new String[]{email} );
        Cursor cursor3 = db.rawQuery("select * from carmechanic where carmechanic_email=?",new String[]{email} );
        Cursor cursor4 = db.rawQuery("select * from electrician where electrician_email=?",new String[]{email} );
        Cursor cursor5 = db.rawQuery("select * from housecleaner where cleaner_email=?",new String[]{email} );
        Cursor cursor6 = db.rawQuery("select * from appliancerepair where appliancerepair_email=?",new String[]{email} );
        Cursor cursor7 = db.rawQuery("select * from treecutter where treecutter_email=?",new String[]{email} );
        Cursor cursor8 = db.rawQuery("select * from gardener where gardener_email=?",new String[]{email} );
        Cursor cursor9 = db.rawQuery("select * from cook where cook_email=?",new String[]{email} );
        Cursor cursor10 = db.rawQuery("select * from driver where driver_email=?",new String[]{email} );
        if(cursor.getCount()>0 || cursor1.getCount()>0 || cursor2.getCount()>0 || cursor3.getCount()>0 || cursor4.getCount()>0 || cursor5.getCount()>0 || cursor6.getCount()>0 || cursor7.getCount()>0 || cursor8.getCount()>0 || cursor9.getCount()>0 || cursor10.getCount()>0)
            return true;
        else
            return false;
    }


    public Boolean checkcarmechanicemail(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=?",new String[]{email} );
        Cursor cursor1 = db.rawQuery("select * from plumber where plumber_email=?",new String[]{email} );
        Cursor cursor2 = db.rawQuery("select * from painter where painter_email=?",new String[]{email} );
        Cursor cursor3 = db.rawQuery("select * from carmechanic where carmechanic_email=?",new String[]{email} );
        Cursor cursor4 = db.rawQuery("select * from electrician where electrician_email=?",new String[]{email} );
        Cursor cursor5 = db.rawQuery("select * from housecleaner where cleaner_email=?",new String[]{email} );
        Cursor cursor6 = db.rawQuery("select * from appliancerepair where appliancerepair_email=?",new String[]{email} );
        Cursor cursor7 = db.rawQuery("select * from treecutter where treecutter_email=?",new String[]{email} );
        Cursor cursor8 = db.rawQuery("select * from gardener where gardener_email=?",new String[]{email} );
        Cursor cursor9 = db.rawQuery("select * from cook where cook_email=?",new String[]{email} );
        Cursor cursor10 = db.rawQuery("select * from driver where driver_email=?",new String[]{email} );
        if(cursor.getCount()>0 || cursor1.getCount()>0 || cursor2.getCount()>0 || cursor3.getCount()>0 || cursor4.getCount()>0 || cursor5.getCount()>0 || cursor6.getCount()>0 || cursor7.getCount()>0 || cursor8.getCount()>0 || cursor9.getCount()>0 || cursor10.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkelectricianmail(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=?",new String[]{email} );
        Cursor cursor1 = db.rawQuery("select * from plumber where plumber_email=?",new String[]{email} );
        Cursor cursor2 = db.rawQuery("select * from painter where painter_email=?",new String[]{email} );
        Cursor cursor3 = db.rawQuery("select * from carmechanic where carmechanic_email=?",new String[]{email} );
        Cursor cursor4 = db.rawQuery("select * from electrician where electrician_email=?",new String[]{email} );
        Cursor cursor5 = db.rawQuery("select * from housecleaner where cleaner_email=?",new String[]{email} );
        Cursor cursor6 = db.rawQuery("select * from appliancerepair where appliancerepair_email=?",new String[]{email} );
        Cursor cursor7 = db.rawQuery("select * from treecutter where treecutter_email=?",new String[]{email} );
        Cursor cursor8 = db.rawQuery("select * from gardener where gardener_email=?",new String[]{email} );
        Cursor cursor9 = db.rawQuery("select * from cook where cook_email=?",new String[]{email} );
        Cursor cursor10 = db.rawQuery("select * from driver where driver_email=?",new String[]{email} );
        if(cursor.getCount()>0 || cursor1.getCount()>0 || cursor2.getCount()>0 || cursor3.getCount()>0 || cursor4.getCount()>0 || cursor5.getCount()>0 || cursor6.getCount()>0 || cursor7.getCount()>0 || cursor8.getCount()>0 || cursor9.getCount()>0 || cursor10.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkcleanermail(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=?",new String[]{email} );
        Cursor cursor1 = db.rawQuery("select * from plumber where plumber_email=?",new String[]{email} );
        Cursor cursor2 = db.rawQuery("select * from painter where painter_email=?",new String[]{email} );
        Cursor cursor3 = db.rawQuery("select * from carmechanic where carmechanic_email=?",new String[]{email} );
        Cursor cursor4 = db.rawQuery("select * from electrician where electrician_email=?",new String[]{email} );
        Cursor cursor5 = db.rawQuery("select * from housecleaner where cleaner_email=?",new String[]{email} );
        Cursor cursor6 = db.rawQuery("select * from appliancerepair where appliancerepair_email=?",new String[]{email} );
        Cursor cursor7 = db.rawQuery("select * from treecutter where treecutter_email=?",new String[]{email} );
        Cursor cursor8 = db.rawQuery("select * from gardener where gardener_email=?",new String[]{email} );
        Cursor cursor9 = db.rawQuery("select * from cook where cook_email=?",new String[]{email} );
        Cursor cursor10 = db.rawQuery("select * from driver where driver_email=?",new String[]{email} );
        if(cursor.getCount()>0 || cursor1.getCount()>0 || cursor2.getCount()>0 || cursor3.getCount()>0 || cursor4.getCount()>0 || cursor5.getCount()>0 || cursor6.getCount()>0 || cursor7.getCount()>0 || cursor8.getCount()>0 || cursor9.getCount()>0 || cursor10.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkappliancerepairmail(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=?",new String[]{email} );
        Cursor cursor1 = db.rawQuery("select * from plumber where plumber_email=?",new String[]{email} );
        Cursor cursor2 = db.rawQuery("select * from painter where painter_email=?",new String[]{email} );
        Cursor cursor3 = db.rawQuery("select * from carmechanic where carmechanic_email=?",new String[]{email} );
        Cursor cursor4 = db.rawQuery("select * from electrician where electrician_email=?",new String[]{email} );
        Cursor cursor5 = db.rawQuery("select * from housecleaner where cleaner_email=?",new String[]{email} );
        Cursor cursor6 = db.rawQuery("select * from appliancerepair where appliancerepair_email=?",new String[]{email} );
        Cursor cursor7 = db.rawQuery("select * from treecutter where treecutter_email=?",new String[]{email} );
        Cursor cursor8 = db.rawQuery("select * from gardener where gardener_email=?",new String[]{email} );
        Cursor cursor9 = db.rawQuery("select * from cook where cook_email=?",new String[]{email} );
        Cursor cursor10 = db.rawQuery("select * from driver where driver_email=?",new String[]{email} );
        if(cursor.getCount()>0 || cursor1.getCount()>0 || cursor2.getCount()>0 || cursor3.getCount()>0 || cursor4.getCount()>0 || cursor5.getCount()>0 || cursor6.getCount()>0 || cursor7.getCount()>0 || cursor8.getCount()>0 || cursor9.getCount()>0 || cursor10.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checktreecuttermail(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=?",new String[]{email} );
        Cursor cursor1 = db.rawQuery("select * from plumber where plumber_email=?",new String[]{email} );
        Cursor cursor2 = db.rawQuery("select * from painter where painter_email=?",new String[]{email} );
        Cursor cursor3 = db.rawQuery("select * from carmechanic where carmechanic_email=?",new String[]{email} );
        Cursor cursor4 = db.rawQuery("select * from electrician where electrician_email=?",new String[]{email} );
        Cursor cursor5 = db.rawQuery("select * from housecleaner where cleaner_email=?",new String[]{email} );
        Cursor cursor6 = db.rawQuery("select * from appliancerepair where appliancerepair_email=?",new String[]{email} );
        Cursor cursor7 = db.rawQuery("select * from treecutter where treecutter_email=?",new String[]{email} );
        Cursor cursor8 = db.rawQuery("select * from gardener where gardener_email=?",new String[]{email} );
        Cursor cursor9 = db.rawQuery("select * from cook where cook_email=?",new String[]{email} );
        Cursor cursor10 = db.rawQuery("select * from driver where driver_email=?",new String[]{email} );
        if(cursor.getCount()>0 || cursor1.getCount()>0 || cursor2.getCount()>0 || cursor3.getCount()>0 || cursor4.getCount()>0 || cursor5.getCount()>0 || cursor6.getCount()>0 || cursor7.getCount()>0 || cursor8.getCount()>0 || cursor9.getCount()>0 || cursor10.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkgardenermail(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=?",new String[]{email} );
        Cursor cursor1 = db.rawQuery("select * from plumber where plumber_email=?",new String[]{email} );
        Cursor cursor2 = db.rawQuery("select * from painter where painter_email=?",new String[]{email} );
        Cursor cursor3 = db.rawQuery("select * from carmechanic where carmechanic_email=?",new String[]{email} );
        Cursor cursor4 = db.rawQuery("select * from electrician where electrician_email=?",new String[]{email} );
        Cursor cursor5 = db.rawQuery("select * from housecleaner where cleaner_email=?",new String[]{email} );
        Cursor cursor6 = db.rawQuery("select * from appliancerepair where appliancerepair_email=?",new String[]{email} );
        Cursor cursor7 = db.rawQuery("select * from treecutter where treecutter_email=?",new String[]{email} );
        Cursor cursor8 = db.rawQuery("select * from gardener where gardener_email=?",new String[]{email} );
        Cursor cursor9 = db.rawQuery("select * from cook where cook_email=?",new String[]{email} );
        Cursor cursor10 = db.rawQuery("select * from driver where driver_email=?",new String[]{email} );
        if(cursor.getCount()>0 || cursor1.getCount()>0 || cursor2.getCount()>0 || cursor3.getCount()>0 || cursor4.getCount()>0 || cursor5.getCount()>0 || cursor6.getCount()>0 || cursor7.getCount()>0 || cursor8.getCount()>0 || cursor9.getCount()>0 || cursor10.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkcookmail(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=?",new String[]{email} );
        Cursor cursor1 = db.rawQuery("select * from plumber where plumber_email=?",new String[]{email} );
        Cursor cursor2 = db.rawQuery("select * from painter where painter_email=?",new String[]{email} );
        Cursor cursor3 = db.rawQuery("select * from carmechanic where carmechanic_email=?",new String[]{email} );
        Cursor cursor4 = db.rawQuery("select * from electrician where electrician_email=?",new String[]{email} );
        Cursor cursor5 = db.rawQuery("select * from housecleaner where cleaner_email=?",new String[]{email} );
        Cursor cursor6 = db.rawQuery("select * from appliancerepair where appliancerepair_email=?",new String[]{email} );
        Cursor cursor7 = db.rawQuery("select * from treecutter where treecutter_email=?",new String[]{email} );
        Cursor cursor8 = db.rawQuery("select * from gardener where gardener_email=?",new String[]{email} );
        Cursor cursor9 = db.rawQuery("select * from cook where cook_email=?",new String[]{email} );
        Cursor cursor10 = db.rawQuery("select * from driver where driver_email=?",new String[]{email} );
        if(cursor.getCount()>0 || cursor1.getCount()>0 || cursor2.getCount()>0 || cursor3.getCount()>0 || cursor4.getCount()>0 || cursor5.getCount()>0 || cursor6.getCount()>0 || cursor7.getCount()>0 || cursor8.getCount()>0 || cursor9.getCount()>0 || cursor10.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkdrivermail(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=?",new String[]{email} );
        Cursor cursor1 = db.rawQuery("select * from plumber where plumber_email=?",new String[]{email} );
        Cursor cursor2 = db.rawQuery("select * from painter where painter_email=?",new String[]{email} );
        Cursor cursor3 = db.rawQuery("select * from carmechanic where carmechanic_email=?",new String[]{email} );
        Cursor cursor4 = db.rawQuery("select * from electrician where electrician_email=?",new String[]{email} );
        Cursor cursor5 = db.rawQuery("select * from housecleaner where cleaner_email=?",new String[]{email} );
        Cursor cursor6 = db.rawQuery("select * from appliancerepair where appliancerepair_email=?",new String[]{email} );
        Cursor cursor7 = db.rawQuery("select * from treecutter where treecutter_email=?",new String[]{email} );
        Cursor cursor8 = db.rawQuery("select * from gardener where gardener_email=?",new String[]{email} );
        Cursor cursor9 = db.rawQuery("select * from cook where cook_email=?",new String[]{email} );
        Cursor cursor10 = db.rawQuery("select * from driver where driver_email=?",new String[]{email} );
        if(cursor.getCount()>0 || cursor1.getCount()>0 || cursor2.getCount()>0 || cursor3.getCount()>0 || cursor4.getCount()>0 || cursor5.getCount()>0 || cursor6.getCount()>0 || cursor7.getCount()>0 || cursor8.getCount()>0 || cursor9.getCount()>0 || cursor10.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkemailpassword1(String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=? and password=?",new String[]{email,password} );
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkemailpassword2(String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from plumber where plumber_email=? and plumber_password=?",new String[]{email,password} );
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkemailpassword3(String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from painter where painter_email=? and painter_password=?",new String[]{email,password} );
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkemailpassword4(String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from carmechanic where carmechanic_email=? and carmechanic_password=?",new String[]{email,password} );
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkemailpassword5(String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from electrician where electrician_email=? and electrician_password=?",new String[]{email,password} );
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkemailpassword6(String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from housecleaner where cleaner_email=? and cleaner_password=?",new String[]{email,password} );
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkemailpassword7(String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from appliancerepair where appliancerepair_email=? and appliancerepair_password=?",new String[]{email,password} );
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkemailpassword8(String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from treecutter where treecutter_email=? and treecutter_password=?",new String[]{email,password} );
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkemailpassword9(String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from gardener where gardener_email=? and gardener_password=?",new String[]{email,password} );
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkemailpassword10(String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from cook where cook_email=? and cook_password=?",new String[]{email,password} );
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkemailpassword11(String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from driver where driver_email=? and driver_password=?",new String[]{email,password} );
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkemailpassword12(String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from admin where admin_email=? and admin_password=?",new String[]{email,password} );
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public ArrayList<UserModel> fetchUser(String email){
      SQLiteDatabase db = this.getReadableDatabase();
      Cursor cursor = db.rawQuery("select * from users where email=?",new String[]{email});
      ArrayList<UserModel> arrUser = new ArrayList<>();
      while(cursor.moveToNext()){
       UserModel model = new UserModel();
       model.username = cursor.getString(0);
       model.email = cursor.getString(1);
       model.password = cursor.getString(2);
       model.mobile = cursor.getString(3);
       model.address = cursor.getString(4);
       model.city = cursor.getString(5);
       arrUser.add(model);
      }
      cursor.close();
      return arrUser;
    }
    public ArrayList<AdminModel> fetchAdmin(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from admin where admin_email=?",new String[]{email});
        ArrayList<AdminModel> arrUser = new ArrayList<>();
        while(cursor.moveToNext()){
            AdminModel model = new AdminModel();
            model.username = cursor.getString(0);
            model.email = cursor.getString(1);
            model.password = cursor.getString(2);
            model.mobile = cursor.getString(3);
            model.address = cursor.getString(4);
            model.city = cursor.getString(5);
            arrUser.add(model);
        }
        cursor.close();
        return arrUser;
    }
    public ArrayList<UserModel>collectUserPlumber(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user_plumber where plumber_email=?",new String[]{email});
        ArrayList<UserModel> arrUser = new ArrayList<>();
        while(cursor.moveToNext()) {
            UserModel model = new UserModel();
            model.email = cursor.getString(0);
            arrUser.add(model);
        }
        cursor.close();
        return arrUser;
    }

    public ArrayList<UserModel>collectUserPainter(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user_painter where painter_email=?",new String[]{email});
        ArrayList<UserModel> arrUser = new ArrayList<>();
        while(cursor.moveToNext()) {
            UserModel model = new UserModel();
            model.email = cursor.getString(0);
            arrUser.add(model);
        }
        cursor.close();
        return arrUser;
    }
    public ArrayList<UserModel>collectUserCarmechanic(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user_carmechanic where carmechanic_email=?",new String[]{email});
        ArrayList<UserModel> arrUser = new ArrayList<>();
        while(cursor.moveToNext()) {
            UserModel model = new UserModel();
            model.email = cursor.getString(0);
            arrUser.add(model);
        }
        cursor.close();
        return arrUser;
    }
    public ArrayList<UserModel>collectUserElectrician(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user_electrician where electrician_email=?",new String[]{email});
        ArrayList<UserModel> arrUser = new ArrayList<>();
        while(cursor.moveToNext()) {
            UserModel model = new UserModel();
            model.email = cursor.getString(0);
            arrUser.add(model);
        }
        cursor.close();
        return arrUser;
    }
    public ArrayList<UserModel>collectUserCleanner(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user_housecleaner where cleaner_email=?",new String[]{email});
        ArrayList<UserModel> arrUser = new ArrayList<>();
        while(cursor.moveToNext()) {
            UserModel model = new UserModel();
            model.email = cursor.getString(0);
            arrUser.add(model);
        }
        cursor.close();
        return arrUser;
    }
    public ArrayList<UserModel>collectUserAppliancerepair(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user_appliancerepair where appliancerepair_email=?",new String[]{email});
        ArrayList<UserModel> arrUser = new ArrayList<>();
        while(cursor.moveToNext()) {
            UserModel model = new UserModel();
            model.email = cursor.getString(0);
            arrUser.add(model);
        }
        cursor.close();
        return arrUser;
    }
    public ArrayList<UserModel>collectUserTreecutter(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user_treecutter where treecutter_email=?",new String[]{email});
        ArrayList<UserModel> arrUser = new ArrayList<>();
        while(cursor.moveToNext()) {
            UserModel model = new UserModel();
            model.email = cursor.getString(0);
            arrUser.add(model);
        }
        cursor.close();
        return arrUser;
    }
    public ArrayList<UserModel>collectUserGardener(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user_gardener where gardener_email=?",new String[]{email});
        ArrayList<UserModel> arrUser = new ArrayList<>();
        while(cursor.moveToNext()) {
            UserModel model = new UserModel();
            model.email = cursor.getString(0);
            arrUser.add(model);
        }
        cursor.close();
        return arrUser;
    }
    public ArrayList<UserModel>collectUserCook(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user_cook where cook_email=?",new String[]{email});
        ArrayList<UserModel> arrUser = new ArrayList<>();
        while(cursor.moveToNext()) {
            UserModel model = new UserModel();
            model.email = cursor.getString(0);
            arrUser.add(model);
        }
        cursor.close();
        return arrUser;
    }
    public ArrayList<UserModel>collectUserDriver(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user_driver where driver_email=?",new String[]{email});
        ArrayList<UserModel> arrUser = new ArrayList<>();
        while(cursor.moveToNext()) {
            UserModel model = new UserModel();
            model.email = cursor.getString(0);
            arrUser.add(model);
        }
        cursor.close();
        return arrUser;
    }

    public ArrayList<ServiceModel> collectPlumber(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from plumber where plumber_email=?",new String[]{email});
        ArrayList<ServiceModel> arrService = new ArrayList<>();
        while(cursor.moveToNext()){
            ServiceModel model = new ServiceModel();
            model.username = cursor.getString(0);
            model.email = cursor.getString(1);
            model.password = cursor.getString(2);
            model.mobile = cursor.getString(3);
            model.address = cursor.getString(4);
            model.city = cursor.getString(5);
            model.status=cursor.getInt(6);
            arrService.add(model);
        }
        cursor.close();
        return arrService;
    }
    public ArrayList<ServiceModel> collectPainter(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from painter where painter_email=?",new String[]{email});
        ArrayList<ServiceModel> arrService = new ArrayList<>();
        while(cursor.moveToNext()){
            ServiceModel model = new ServiceModel();
            model.username = cursor.getString(0);
            model.email = cursor.getString(1);
            model.password = cursor.getString(2);
            model.mobile = cursor.getString(3);
            model.address = cursor.getString(4);
            model.city = cursor.getString(5);
            model.status=cursor.getInt(6);
            arrService.add(model);
        }
        cursor.close();
        return arrService;
    }
    public ArrayList<ServiceModel> collectCarmechanic(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from carmechanic where carmechanic_email=?",new String[]{email});
        ArrayList<ServiceModel> arrService = new ArrayList<>();
        while(cursor.moveToNext()){
            ServiceModel model = new ServiceModel();
            model.username = cursor.getString(0);
            model.email = cursor.getString(1);
            model.password = cursor.getString(2);
            model.mobile = cursor.getString(3);
            model.address = cursor.getString(4);
            model.city = cursor.getString(5);
            model.status=cursor.getInt(6);
            arrService.add(model);
        }
        cursor.close();
        return arrService;
    }
    public ArrayList<ServiceModel> collectElectrician(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from electrician where electrician_email=?",new String[]{email});
        ArrayList<ServiceModel> arrService = new ArrayList<>();
        while(cursor.moveToNext()){
            ServiceModel model = new ServiceModel();
            model.username = cursor.getString(0);
            model.email = cursor.getString(1);
            model.password = cursor.getString(2);
            model.mobile = cursor.getString(3);
            model.address = cursor.getString(4);
            model.city = cursor.getString(5);
            model.status=cursor.getInt(6);
            arrService.add(model);
        }
        cursor.close();
        return arrService;
    }
    public ArrayList<ServiceModel> collectHousecleaner(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from housecleaner where cleaner_email=?",new String[]{email});
        ArrayList<ServiceModel> arrService = new ArrayList<>();
        while(cursor.moveToNext()){
            ServiceModel model = new ServiceModel();
            model.username = cursor.getString(0);
            model.email = cursor.getString(1);
            model.password = cursor.getString(2);
            model.mobile = cursor.getString(3);
            model.address = cursor.getString(4);
            model.city = cursor.getString(5);
            model.status=cursor.getInt(6);
            arrService.add(model);
        }
        cursor.close();
        return arrService;
    }
    public ArrayList<ServiceModel> collectAppliancerepair(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from appliancerepair where appliancerepair_email=?",new String[]{email});
        ArrayList<ServiceModel> arrService = new ArrayList<>();
        while(cursor.moveToNext()){
            ServiceModel model = new ServiceModel();
            model.username = cursor.getString(0);
            model.email = cursor.getString(1);
            model.password = cursor.getString(2);
            model.mobile = cursor.getString(3);
            model.address = cursor.getString(4);
            model.city = cursor.getString(5);
            model.status=cursor.getInt(6);
            arrService.add(model);
        }
        cursor.close();
        return arrService;
    }
    public ArrayList<ServiceModel> collectTreecutter(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from treecutter where treecutter_email=?",new String[]{email});
        ArrayList<ServiceModel> arrService = new ArrayList<>();
        while(cursor.moveToNext()){
            ServiceModel model = new ServiceModel();
            model.username = cursor.getString(0);
            model.email = cursor.getString(1);
            model.password = cursor.getString(2);
            model.mobile = cursor.getString(3);
            model.address = cursor.getString(4);
            model.city = cursor.getString(5);
            model.status=cursor.getInt(6);
            arrService.add(model);
        }
        cursor.close();
        return arrService;
    }
    public ArrayList<ServiceModel> collectGardener(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from gardener where gardener_email=?",new String[]{email});
        ArrayList<ServiceModel> arrService = new ArrayList<>();
        while(cursor.moveToNext()){
            ServiceModel model = new ServiceModel();
            model.username = cursor.getString(0);
            model.email = cursor.getString(1);
            model.password = cursor.getString(2);
            model.mobile = cursor.getString(3);
            model.address = cursor.getString(4);
            model.city = cursor.getString(5);
            model.status=cursor.getInt(6);
            arrService.add(model);
        }
        cursor.close();
        return arrService;
    }
    public ArrayList<ServiceModel> collectCook(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from cook where cook_email=?",new String[]{email});
        ArrayList<ServiceModel> arrService = new ArrayList<>();
        while(cursor.moveToNext()){
            ServiceModel model = new ServiceModel();
            model.username = cursor.getString(0);
            model.email = cursor.getString(1);
            model.password = cursor.getString(2);
            model.mobile = cursor.getString(3);
            model.address = cursor.getString(4);
            model.city = cursor.getString(5);
            model.status=cursor.getInt(6);
            arrService.add(model);
        }
        cursor.close();
        return arrService;
    }
    public ArrayList<ServiceModel> collectDriver(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from driver where driver_email=?",new String[]{email});
        ArrayList<ServiceModel> arrService = new ArrayList<>();
        while(cursor.moveToNext()){
            ServiceModel model = new ServiceModel();
            model.username = cursor.getString(0);
            model.email = cursor.getString(1);
            model.password = cursor.getString(2);
            model.mobile = cursor.getString(3);
            model.address = cursor.getString(4);
            model.city = cursor.getString(5);
            model.status=cursor.getInt(6);
            arrService.add(model);
        }
        cursor.close();
        return arrService;
    }

    public Cursor fetchPlumber(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from plumber where plumber_status = 1",null);
        return cursor;

    }
    public Cursor fetchPlumber1(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from plumber",null);
        return cursor;

    }
    public Cursor fetchPainter(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from painter where painter_status = 1",null);
        return cursor;

    }
    public Cursor fetchPainter1(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from painter",null);
        return cursor;

    }
    public Cursor fetchCarmechanic(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from carmechanic where carmechanic_status = 1",null);
        return cursor;

    }
    public Cursor fetchCarmechanic1(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from carmechanic",null);
        return cursor;

    }
    public Cursor fetchElectrician(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from electrician where electrician_status = 1",null);
        return cursor;

    }
    public Cursor fetchElectrician1(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from electrician",null);
        return cursor;

    }
    public Cursor fetchHousecleaning(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from housecleaner where cleaner_status = 1",null);
        return cursor;

    }
    public Cursor fetchHousecleaning1(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from housecleaner",null);
        return cursor;

    }

    public Cursor fetchAppliance(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from appliancerepair where appliancerepair_status = 1",null);
        return cursor;

    }
    public Cursor fetchAppliance1(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from appliancerepair",null);
        return cursor;

    }
    public Cursor fetchTreecutting(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from treecutter where treecutter_status = 1",null);
        return cursor;

    }
    public Cursor fetchTreecutting1(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from treecutter",null);
        return cursor;

    }
    public Cursor fetchGardening(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from gardener where gardener_status = 1",null);
        return cursor;

    }
    public Cursor fetchGardening1(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from gardener",null);
        return cursor;

    }
    public Cursor fetchCook(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from cook where cook_status = 1",null);
        return cursor;

    }
    public Cursor fetchCook1(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from cook",null);
        return cursor;

    }
    public Cursor fetchDriver(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from driver where driver_status = 1",null);
        return cursor;

    }
    public Cursor fetchDriver1(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from driver",null);
        return cursor;

    }
    public Cursor fetchuserlist(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from users where email = ?", new String[]{email});
        return cursor;

    }


    public boolean edituser(String username,String newemail,String mobile,String address,String city,String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",username);
        values.put("email",newemail);
        values.put("mobile",mobile);
        values.put("address",address);
        values.put("city",city);
        int rowsAffected = db.update("users", values, "email=?", new String[]{email});
        db.close();
        return rowsAffected > 0;
    }
    public boolean changeuserpassword(String password,String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("password",password);
        int rowsAffected = db.update("users", values, "email=?", new String[]{email});
        db.close();
        return rowsAffected > 0;
    }
    public boolean editadmin(String username,String newemail,String mobile,String address,String city,String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("admin_name",username);
        values.put("admin_email",newemail);
        values.put("admin_mobile",mobile);
        values.put("admin_address",address);
        values.put("admin_city",city);
        int rowsAffected = db.update("admin", values, "admin_email=?", new String[]{email});
        db.close();
        return rowsAffected > 0;
    }
    public boolean editplumber(String username,String newemail,String mobile,String address,String city,String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("plumber_name",username);
        values.put("plumber_email",newemail);
        values.put("plumber_mobile",mobile);
        values.put("plumber_address",address);
        values.put("plumber_city",city);
        int rowsAffected = db.update("plumber", values, "plumber_email=?", new String[]{email});
        db.close();
        return rowsAffected > 0;
    }
    public boolean editpainter(String username,String newemail,String mobile,String address,String city,String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("painter_name",username);
        values.put("painter_email",newemail);
        values.put("painter_mobile",mobile);
        values.put("painter_address",address);
        values.put("painter_city",city);
        int rowsAffected = db.update("painter", values, "painter_email=?", new String[]{email});
        db.close();
        return rowsAffected > 0;
    }
    public boolean editcarmechanic(String username,String newemail,String mobile,String address,String city,String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("carmechanic_name",username);
        values.put("carmechanic_email",newemail);
        values.put("carmechanic_mobile",mobile);
        values.put("carmechanic_address",address);
        values.put("carmechanic_city",city);
        int rowsAffected = db.update("carmechanic", values, "carmechanic_email=?", new String[]{email});
        db.close();
        return rowsAffected > 0;
    }
    public boolean editelectrician(String username,String newemail,String mobile,String address,String city,String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("electrician_name",username);
        values.put("electrician_email",newemail);
        values.put("electrician_mobile",mobile);
        values.put("electrician_address",address);
        values.put("electrician_city",city);
        int rowsAffected = db.update("electrician", values, "electrician_email=?", new String[]{email});
        db.close();
        return rowsAffected > 0;
    }
    public boolean edithousecleaner(String username,String newemail,String mobile,String address,String city,String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("cleaner_name",username);
        values.put("cleaner_email",newemail);
        values.put("cleaner_mobile",mobile);
        values.put("cleaner_address",address);
        values.put("cleaner_city",city);
        int rowsAffected = db.update("housecleaner", values, "cleaner_email=?", new String[]{email});
        db.close();
        return rowsAffected > 0;
    }
    public boolean editappliancerepair(String username,String newemail,String mobile,String address,String city,String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("appliancerepair_name",username);
        values.put("appliancerepair_email",newemail);
        values.put("appliancerepair_mobile",mobile);
        values.put("appliancerepair_address",address);
        values.put("appliancerepair_city",city);
        int rowsAffected = db.update("appliancerepair", values, "appliancerepair_email=?", new String[]{email});
        db.close();
        return rowsAffected > 0;
    }
    public boolean edittreecutter(String username,String newemail,String mobile,String address,String city,String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("treecutter_name",username);
        values.put("treecutter_email",newemail);
        values.put("treecutter_mobile",mobile);
        values.put("treecutter_address",address);
        values.put("treecutter_city",city);
        int rowsAffected = db.update("treecutter", values, "treecutter_email=?", new String[]{email});
        db.close();
        return rowsAffected > 0;
    }
    public boolean editgardener(String username,String newemail,String mobile,String address,String city,String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("gardener_name",username);
        values.put("gardener_email",newemail);
        values.put("gardener_mobile",mobile);
        values.put("gardener_address",address);
        values.put("gardener_city",city);
        int rowsAffected = db.update("gardener", values, "gardener_email=?", new String[]{email});
        db.close();
        return rowsAffected > 0;
    }
    public boolean editcook(String username,String newemail,String mobile,String address,String city,String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("cook_name",username);
        values.put("cook_email",newemail);
        values.put("cook_mobile",mobile);
        values.put("cook_address",address);
        values.put("cook_city",city);
        int rowsAffected = db.update("cook", values, "cook_email=?", new String[]{email});
        db.close();
        return rowsAffected > 0;
    }
    public boolean editdriver(String username,String newemail,String mobile,String address,String city,String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("driver_name",username);
        values.put("driver_email",newemail);
        values.put("driver_mobile",mobile);
        values.put("driver_address",address);
        values.put("driver_city",city);
        int rowsAffected = db.update("driver", values, "driver_email=?", new String[]{email});
        db.close();
        return rowsAffected > 0;
    }
     public boolean plumberstatus(String email,int status)
     {
         int rowsAffected=0;
         SQLiteDatabase db = this.getWritableDatabase();
         ContentValues values = new ContentValues();
         if(status == 0)
         {

             values.put("plumber_status","1");
              rowsAffected = db.update("plumber", values, "plumber_email=?", new String[]{email});
             db.close();
         }
         else if(status == 1){

             values.put("plumber_status","0");
              rowsAffected = db.update("plumber", values, "plumber_email=?", new String[]{email});
             db.close();
         }
         return rowsAffected > 0;
     }
    public boolean painterstatus(String email,int status)
    {
        int rowsAffected=0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        if(status == 0)
        {

            values.put("painter_status","1");
            rowsAffected = db.update("painter", values, "painter_email=?", new String[]{email});
            db.close();
        }
        else if(status == 1){

            values.put("painter_status","0");
            rowsAffected = db.update("painter", values, "painter_email=?", new String[]{email});
            db.close();
        }
        return rowsAffected > 0;
    }
    public boolean carmechanicstatus(String email,int status)
    {
        int rowsAffected=0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        if(status == 0)
        {

            values.put("carmechanic_status","1");
            rowsAffected = db.update("carmechanic", values, "carmechanic_email=?", new String[]{email});
            db.close();
        }
        else if(status == 1){

            values.put("carmechanic_status","0");
            rowsAffected = db.update("carmechanic", values, "carmechanic_email=?", new String[]{email});
            db.close();
        }
        return rowsAffected > 0;
    }
    public boolean electricianstatus(String email,int status)
    {
        int rowsAffected=0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        if(status == 0)
        {

            values.put("electrician_status","1");
            rowsAffected = db.update("electrician", values, "electrician_email=?", new String[]{email});
            db.close();
        }
        else if(status == 1){

            values.put("electrician_status","0");
            rowsAffected = db.update("electrician", values, "electrician_email=?", new String[]{email});
            db.close();
        }
        return rowsAffected > 0;
    }
    public boolean housecleanerstatus(String email,int status)
    {
        int rowsAffected=0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        if(status == 0)
        {

            values.put("cleaner_status","1");
            rowsAffected = db.update("housecleaner", values, "cleaner_email=?", new String[]{email});
            db.close();
        }
        else if(status == 1){

            values.put("cleaner_status","0");
            rowsAffected = db.update("housecleaner", values, "cleaner_email=?", new String[]{email});
            db.close();
        }
        return rowsAffected > 0;
    }
    public boolean appliancerepairstatus(String email,int status)
    {
        int rowsAffected=0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        if(status == 0)
        {

            values.put("appliancerepair_status","1");
            rowsAffected = db.update("appliancerepair", values, "appliancerepair_email=?", new String[]{email});
            db.close();
        }
        else if(status == 1){

            values.put("appliancerepair_status","0");
            rowsAffected = db.update("appliancerepair", values, "appliancerepair_email=?", new String[]{email});
            db.close();
        }
        return rowsAffected > 0;
    }
    public boolean treecutterstatus(String email,int status)
    {
        int rowsAffected=0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        if(status == 0)
        {

            values.put("treecutter_status","1");
            rowsAffected = db.update("treecutter", values, "treecutter_email=?", new String[]{email});
            db.close();
        }
        else if(status == 1){

            values.put("treecutter_status","0");
            rowsAffected = db.update("treecutter", values, "treecutter_email=?", new String[]{email});
            db.close();
        }
        return rowsAffected > 0;
    }
    public boolean gardenerstatus(String email,int status)
    {
        int rowsAffected=0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        if(status == 0)
        {

            values.put("gardener_status","1");
            rowsAffected = db.update("gardener", values, "gardener_email=?", new String[]{email});
            db.close();
        }
        else if(status == 1){

            values.put("gardener_status","0");
            rowsAffected = db.update("gardener", values, "gardener_email=?", new String[]{email});
            db.close();
        }
        return rowsAffected > 0;
    }
    public boolean cookstatus(String email,int status)
    {
        int rowsAffected=0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        if(status == 0)
        {

            values.put("cook_status","1");
            rowsAffected = db.update("cook", values, "cook_email=?", new String[]{email});
            db.close();
        }
        else if(status == 1){

            values.put("cook_status","0");
            rowsAffected = db.update("cook", values, "cook_email=?", new String[]{email});
            db.close();
        }
        return rowsAffected > 0;
    }
    public boolean driverstatus(String email,int status)
    {
        int rowsAffected=0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        if(status == 0)
        {

            values.put("driver_status","1");
            rowsAffected = db.update("driver", values, "driver_email=?", new String[]{email});
            db.close();
        }
        else if(status == 1){

            values.put("driver_status","0");
            rowsAffected = db.update("driver", values, "driver_email=?", new String[]{email});
            db.close();
        }
        return rowsAffected > 0;
    }
    public  boolean deletePlumber(String email){
        int rowsDeleted=0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        rowsDeleted = db.delete("plumber","plumber_email=?",new String[]{email});
        return rowsDeleted>0;
    }
    public  boolean deletePainter(String email){
        int rowsDeleted=0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        rowsDeleted = db.delete("painter","painter_email=?",new String[]{email});
        return rowsDeleted>0;
    }
    public  boolean deleteCarmechanic(String email){
        int rowsDeleted=0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        rowsDeleted = db.delete("carmechanic","carmechanic_email=?",new String[]{email});
        return rowsDeleted>0;
    }
    public  boolean deleteElectrician(String email){
        int rowsDeleted=0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        rowsDeleted = db.delete("electrician","electrician_email=?",new String[]{email});
        return rowsDeleted>0;
    }
    public  boolean deleteHousecleaning(String email){
        int rowsDeleted=0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        rowsDeleted = db.delete("housecleaner","cleaner_email=?",new String[]{email});
        return rowsDeleted>0;
    }
    public  boolean deleteAppliance(String email){
        int rowsDeleted=0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        rowsDeleted = db.delete("appliancerepair","appliancerepair_email=?",new String[]{email});
        return rowsDeleted>0;
    }
    public  boolean deleteTreecutting(String email){
        int rowsDeleted=0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        rowsDeleted = db.delete("treecutter","treecutter_email=?",new String[]{email});
        return rowsDeleted>0;
    }
    public  boolean deleteGardening(String email){
        int rowsDeleted=0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        rowsDeleted = db.delete("gardener","gardener_email=?",new String[]{email});
        return rowsDeleted>0;
    }
    public  boolean deleteCook(String email){
        int rowsDeleted=0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        rowsDeleted = db.delete("cook","cook_email=?",new String[]{email});
        return rowsDeleted>0;
    }
    public  boolean deleteDriver(String email){
        int rowsDeleted=0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        rowsDeleted = db.delete("driver","driver_email=?",new String[]{email});
        return rowsDeleted>0;
    }
    public boolean deleteRowsByEmail1(String email,String serviceprovider_email){
        int rowsDeleted=0;
      SQLiteDatabase db = this.getWritableDatabase();
      ContentValues values = new ContentValues();
      rowsDeleted = db.delete("user_plumber","user_email=? and plumber_email=?",new String[]{email,serviceprovider_email});
      return rowsDeleted>0;
    }
    public boolean deleteRowsByEmail2(String email,String serviceprovider_email){
        int rowsDeleted=0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        rowsDeleted = db.delete("user_painter","user_email=? and painter_email=?",new String[]{email,serviceprovider_email});
        return rowsDeleted>0;
    }
    public boolean deleteRowsByEmail3(String email,String serviceprovider_email){
        int rowsDeleted=0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        rowsDeleted = db.delete("user_carmechanic","user_email=? and carmechanic_email=?",new String[]{email,serviceprovider_email});
        return rowsDeleted>0;
    }
    public boolean deleteRowsByEmail4(String email,String serviceprovider_email){
        int rowsDeleted=0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        rowsDeleted = db.delete("user_electrician","user_email=? and electrician_email=?",new String[]{email,serviceprovider_email});
        return rowsDeleted>0;
    }
    public boolean deleteRowsByEmail5(String email,String serviceprovider_email){
        int rowsDeleted=0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        rowsDeleted = db.delete("user_housecleaner","user_email=? and cleaner_email=?",new String[]{email,serviceprovider_email});
        return rowsDeleted>0;
    }
    public boolean deleteRowsByEmail6(String email,String serviceprovider_email){
        int rowsDeleted=0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        rowsDeleted = db.delete("user_appliancerepair","user_email=? and appliancerepair_email=?",new String[]{email,serviceprovider_email});
        return rowsDeleted>0;
    }
    public boolean deleteRowsByEmail7(String email,String serviceprovider_email){
        int rowsDeleted=0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        rowsDeleted = db.delete("user_treecutter","user_email=? and treecutter_email=?",new String[]{email,serviceprovider_email});
        return rowsDeleted>0;
    }
    public boolean deleteRowsByEmail8(String email,String serviceprovider_email){
        int rowsDeleted=0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        rowsDeleted = db.delete("user_gardener","user_email=? and gardener_email=?",new String[]{email,serviceprovider_email});
        return rowsDeleted>0;
    }
    public boolean deleteRowsByEmail9(String email,String serviceprovider_email){
        int rowsDeleted=0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        rowsDeleted = db.delete("user_cook","user_email=? and cook_email=?",new String[]{email,serviceprovider_email});
        return rowsDeleted>0;
    }
    public boolean deleteRowsByEmail10(String email,String serviceprovider_email){
        int rowsDeleted=0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        rowsDeleted = db.delete("user_driver","user_email=? and driver_email=?",new String[]{email,serviceprovider_email});
        return rowsDeleted>0;
    }
        public boolean updatePlumberStatus(String useremail, String plumberemail) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("user_email",useremail);
            values.put("plumber_email",plumberemail);
            values.put("work_status","0");
            long result1 = db.insert("user_plumber", null, values);
            return result1 != -1;
        }
        public boolean updatePainterStatus(String useremail, String painteremail) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("user_email",useremail);
            values.put("painter_email",painteremail);
            values.put("work_status","0");
            long result1 = db.insert("user_painter", null, values);
            return result1 != -1;
    }
        public boolean updateCarmechanicStatus(String useremail, String carmechanicemail) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
            values.put("user_email",useremail);
            values.put("carmechanic_email",carmechanicemail);
            values.put("work_status","0");
            long result1 = db.insert("user_carmechanic", null, values);
            return result1 != -1;
    }
        public boolean updateElectricianStatus(String useremail, String electricianemail) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
            values.put("user_email",useremail);
            values.put("electrician_email",electricianemail);
            values.put("work_status","0");
            long result1 = db.insert("user_electrician", null, values);
            return result1 != -1;
    }
        public boolean updateHousecleaningStatus(String useremail, String cleaneremail) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
            values.put("user_email",useremail);
            values.put("cleaner_email",cleaneremail);
            values.put("work_status","0");
            long result1 = db.insert("user_housecleaner", null, values);
            return result1 != -1;
    }
        public boolean updateApplianceStatus(String useremail, String appliancerepairemail) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
            values.put("user_email",useremail);
            values.put("appliancerepair_email",appliancerepairemail);
            values.put("work_status","0");
            long result1 = db.insert("user_appliancerepair", null, values);
            return result1 != -1;
    }
        public boolean updateTreecuttingStatus(String useremail, String treecutteremail) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
            values.put("user_email",useremail);
            values.put("treecutter_email",treecutteremail);
            values.put("work_status","0");
            long result1 = db.insert("user_treecutter", null, values);
            return result1 != -1;
    }
        public boolean updateGardeningStatus(String useremail, String gardeneremail) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
            values.put("user_email",useremail);
            values.put("gardener_email",gardeneremail);
            values.put("work_status","0");
            long result1 = db.insert("user_gardener", null, values);
            return result1 != -1;
    }

       public boolean updateCookStatus(String useremail, String cookemail) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
           values.put("user_email",useremail);
           values.put("cook_email",cookemail);
           values.put("work_status","0");
           long result1 = db.insert("user_cook", null, values);
           return result1 != -1;
    }
        public boolean updateDriverStatus(String useremail, String driveremail) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
            values.put("user_email",useremail);
            values.put("driver_email",driveremail);
            values.put("work_status","0");
            long result1 = db.insert("user_driver", null, values);
            return result1 != -1;
    }


}



