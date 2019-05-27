package com.example.mobilproje;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sqlite_katmani extends SQLiteOpenHelper {

    public sqlite_katmani(Context context) {
        super(context,"VeriTabanim", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql ="create table notlar (id integer primary key autoincrement,title text,content text,date text,pri integer)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists  notlar");

    }
}
