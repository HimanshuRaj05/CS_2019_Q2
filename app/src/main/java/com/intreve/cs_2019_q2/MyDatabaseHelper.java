package com.intreve.cs_2019_q2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;




//(i) Create Database:
//Answer to this includes MyDatabaseHelperClass, its variables, and constructor
public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="MyLibrary.db";
    private static final int DATABASE_VERSION=1;

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    //(ii) Create Table:
    //Includes the onCreate and onUpgrade method
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS my_library (_id INTEGER PRIMARY KEY, book_title VARCHAR, book_author TEXT, book_pages INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS my_library");
        onCreate(db);
    }


    //(iii) Insert multiple records:
    //Includes the insertMultipleRecords method
    public void insertMultipleRecords(){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        String[] titles = {"Title1", "Title2", "Title3"};
        String[] authors = {"Author1", "Author2", "Author3"};
        int[] pages = {100, 150, 200};

        for(int i=0; i<titles.length; i++){
            contentValues.put("book_title",titles[i]);
            contentValues.put("book_author", authors[i]);
            contentValues.put("book_pages", pages[i]);


            db.insert("my_library", null, contentValues);
            contentValues.clear();
        }

    }


    //(iv) Update table entries
    //Includes the updateTableEntries method
    public void updateTableEntries(String oldTitle, String newTitle){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("book_title", newTitle);

        db.update("my_library",contentValues,"book_title=?", new String[]{oldTitle});
    }

}
