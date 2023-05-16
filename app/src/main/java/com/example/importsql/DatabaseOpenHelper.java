package com.example.importsql;

import android.content.Context;

//to be able to import SQLiteAssetHelper you must add this line " implementation 'com.readystatesoftware.sqliteasset:sqliteassethelper:+'"
// in build.gradle file
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseOpenHelper extends SQLiteAssetHelper {
    private  static final String DATABASE_NAME = "externaldb.db";
    private  static  final int DATABASE_VERSION = 1;
    public DatabaseOpenHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
}
