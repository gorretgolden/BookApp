package com.example.booklibraryapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private final Context context;
    private static  final  String DATABASE_NAME = "BookLibrary.db";
    private static  final  Integer DATABASE_VERSION = 1;
    private static  final  String TABLE_NAME = "my_library";
    private static  final  String COLUMN_ID = "id";
    private static  final  String COLUMN_TITLE = "book_title";
    private static  final  String COLUMN_AUTHOR = "book_author";
    private static  final  String COLUMN_PAGES = "book_pages";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null,  DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME +
                            "(" + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "  +
                             COLUMN_TITLE + "TEXT, " +
                              COLUMN_AUTHOR+ "TEXT, " +
                              COLUMN_PAGES + "INTEGER); ";

        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

//Adding a book into the database
   void addBook(String title, String author, int pages){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();

        contentvalues.put(COLUMN_TITLE,title);
        contentvalues.put(COLUMN_AUTHOR,author);
        contentvalues.put(COLUMN_PAGES,pages);

        //inserting data into the database and storing it
        long result = db.insert(TABLE_NAME, null,contentvalues);
       //failing to insert data
        if(result==-1){
            Toast.makeText(context," Failed to add a book!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context," Successfully added a book", Toast.LENGTH_SHORT).show();
        }
    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }
}

