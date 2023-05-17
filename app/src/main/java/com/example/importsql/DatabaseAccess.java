package com.example.importsql;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAccess  {
    private  SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open() {
        this.db = openHelper.getWritableDatabase();
    }

    public void close() {
        if (db != null) {
            this.db.close();
        }
    }
//After select enter column to be searched and after table's name  enter column name do be displayed
    public String getAdress(String name) {
        c = db.rawQuery("select Data from word_entries where issues ='" + name + "'", new String[]{});

        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()) {
            String adress = c.getString(0);
            buffer.append("" + adress);

        }
        return buffer.toString();
    }
}
