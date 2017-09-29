package com.example.ittalents.cinegrand.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;
import android.widget.Toast;

import com.example.ittalents.cinegrand.models.Cinema;
import com.example.ittalents.cinegrand.models.User;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {

    private static DatabaseManager instance;

    private static final String DATABASE_NAME = "CineGrand.db";
    private static int DATABASE_VERSION = 1;
//    Table name
    private static final String TABLE_USERS = "Users_Table";
//    Users Table
    private static final String KEY_EMAIL = "Email";
    private static final String KEY_PASSWORD = "Password";

    private static final String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS +
            "( " + KEY_EMAIL + " TEXT PRIMARY KEY, " + KEY_PASSWORD + " TEXT)";

    private DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized DatabaseManager getDBManager(Context context){
        if (instance == null) {
            instance = new DatabaseManager(context);
            instance.createDatabase();
        }
        return instance;
    }

    public void createDatabase(){
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        DATABASE_VERSION++;
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    @Override
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
    }

    public boolean addUser(User user) {
        if (user != null) {
            SQLiteDatabase db = this.getWritableDatabase();
            String myRawQuery = "select * from " + TABLE_USERS + " where " + KEY_EMAIL +
                    " = \"" + user.getEmail() + "\";";
            if (db.rawQuery(myRawQuery, null).getCount() != 0) {
                return false;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(KEY_EMAIL, user.getEmail());
            contentValues.put(KEY_PASSWORD, user.getPass());
            long result = db.insert(TABLE_USERS, null, contentValues);
            if (result == -1) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

//    public Cursor getUser(String email) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        String myRawQuery = "select * from " + TABLE_USERS + " where " + KEY_EMAIL +
//                " = \"" + email + "\";";
//        return db.rawQuery(myRawQuery, null);
//    }

    public boolean checkEmailPass(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String myRawQuery = "select " + KEY_PASSWORD  + " from " + TABLE_USERS + " where " + KEY_EMAIL + " = \"" + email + "\";";
        Cursor c = db.rawQuery(myRawQuery, null);
        if(c.getCount() == 0) {
            return false;
        }
        c.moveToNext();
        String pass = c.getString(0);
        if(password.equals(pass)) {
            return true;
        }
        return false;
    }
}