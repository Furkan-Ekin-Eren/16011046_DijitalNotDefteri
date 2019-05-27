package com.example.mobilproje;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.strictmode.SqliteObjectLeakedViolation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class VeriKaynagi {
    SQLiteDatabase db;
    sqlite_katmani bdb;

    public VeriKaynagi(Context c){
        bdb = new sqlite_katmani(c);
    }

    public void ac(){
        db = bdb.getWritableDatabase();
    }

    public void kapa(){
        bdb.close();
    }

    public void notOlustur(String title, String content, String date,int pri){
        Not not = new Not(title,content,date,pri);
        ContentValues val = new ContentValues();
        val.put("title",not.getTitle());
        val.put("content",not.getContent());
        val.put("date",not.getDate());
        val.put("pri",not.getPri());
        db.insert("notlar",null,val);
    }

    public ArrayList<Not> listele(){
        String kolonlar[]={"title","content","date","id","pri"};
        ArrayList<Not> liste = new ArrayList<Not>();
        Cursor cursor = db.query("notlar",kolonlar,null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String title = cursor.getString(0);
            String content = cursor.getString(1);
            String date = cursor.getString(2);
            int id = cursor.getInt(3);
            int pri=cursor.getInt(4);
            Not not = new Not(title,content,date,pri);
            not.setId(id);
            liste.add(not);
            cursor.moveToNext();
        }
        return liste;
    }

    public void notSil(Not not){
        int id = not.getId();
        db.delete("notlar","id="+id,null);
    }

    public void notSil_new(int id){
        db.delete("notlar","id="+id,null);
    }
}
