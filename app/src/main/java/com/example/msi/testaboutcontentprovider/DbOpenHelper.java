package com.example.msi.testaboutcontentprovider;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbOpenHelper extends SQLiteOpenHelper {

    private static final String DATA_BASE_NAME = "book.db";

    private static final int DATA_BASE_VASION = 1;
    //表名
    public static final String BOOK_TABLE_NAME = "book";

    public static final String USER_TABLE_NAME = "user";
    //创建表
    private final String CREATE_BOOK_TABLE = "create table " + BOOK_TABLE_NAME +
            "(_id integer primary key autoincrement ,bookName text)";

    private final String CREATE_USER_TABLE = "create table " + USER_TABLE_NAME +
            "(_id integer primary key autoincrement ,userName  text, sex text)";


    public DbOpenHelper(Context context) {
        super(context, DATA_BASE_NAME, null, DATA_BASE_VASION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK_TABLE);
        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
