package com.example.msi.testaboutcontentprovider;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri bookUri = Uri.parse("content://com.example.msi.testaboutcontentprovider.MyContentProvider/book");
        ContentValues contentValues = new ContentValues();
        contentValues.put("bookName","数据库从删库到跑路");
        getContentResolver().insert(bookUri,contentValues);
        Cursor cursor = getContentResolver().query(bookUri,new String[]{"_id","bookName"},null,null,null);
        if(cursor!=null){
            while (cursor.moveToNext()){
                Log.e(TAG,"ID:"+cursor.getInt(cursor.getColumnIndex("_id"))+
                "bookName"+cursor.getString(cursor.getColumnIndex("bookName")));
            }
            cursor.close();
        }


        Uri userUri = Uri.parse("content://com.example.msi.testaboutcontentprovider.MyContentProvider/user");
        Cursor cursor1 = getContentResolver().query(userUri,new String[]{"_id","userName","sex"},null,null,null);
        if(cursor1!=null){
            while (cursor1.moveToNext()){
                Log.e(TAG,"ID:"+cursor1.getInt(cursor1.getColumnIndex("_id"))+
                "userName"+cursor1.getString(cursor1.getColumnIndex("userName"))+"sex:"+cursor1.getString(cursor1.getColumnIndex("sex")));
            }
        }
    }
}
