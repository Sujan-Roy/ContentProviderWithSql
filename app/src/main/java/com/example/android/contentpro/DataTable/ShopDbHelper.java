package com.example.android.contentpro.DataTable;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Android on 2/21/2017.
 */

public class ShopDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "personalEvents.db";


    private static final int DATABASE_VERSION = 1;
    public ShopDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_EVENTS_TABLE =  "CREATE TABLE " + ShopTable.EventEntry.TABLE_NAME + " ("
                + ShopTable.EventEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ShopTable.EventEntry.COLUMN_BOOK + " TEXT NOT NULL, "
                + ShopTable.EventEntry.COLUMN_STORE + " TEXT NOT NULL );";

        db.execSQL(SQL_CREATE_EVENTS_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
