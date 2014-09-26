package com.coderchef.userinfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.sql.SQLException;

/**
 * Created by riajur on 8/31/2014.
 */
public class UserInfo {
    public static final String KEY_ID="_id";
    public static final String KEY_EMAIL="email";
    public static final String KEY_USERNAME="username";
    public static final String KEY_PASSWORD="password";

    private  static final String DATABASE_NAME="db_userinfo";
    private  static final String TABLE_NAME="table_userinfo";
    private  static final int DATABASE_VERSION = 1;

    private DbHelper ourHelper;
    private final Context ourContext;
    private SQLiteDatabase myDatabase;

    public UserInfo(Context c) {
        this.ourContext = c;
    }

    public long insertData(String userMail, String userID, String userPass) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_EMAIL,userMail);
        contentValues.put(KEY_USERNAME,userID);
        contentValues.put(KEY_PASSWORD,userPass);
        return myDatabase.insert(TABLE_NAME,null,contentValues);
    }

    public boolean loginInfo(String userDetails, String userPasswords) {
        String [] columns = new String[]{KEY_ID,KEY_EMAIL,KEY_USERNAME,KEY_PASSWORD};
        String rawQuery="SELECT * FROM "+ TABLE_NAME + " WHERE "+ KEY_USERNAME + " = ? AND " + KEY_PASSWORD + " = ?";
        Cursor cursor = myDatabase.rawQuery(rawQuery,new String[]{userDetails,userPasswords});
        if(cursor!=null)
            return true;
      //  Cursor cursor = myDatabase.query(TABLE_NAME,columns,null,null,null,null,null);
      /*  int iId=cursor.getColumnIndex(KEY_ID);
        int iEmail=cursor.getColumnIndex(KEY_EMAIL);
        int iUsername=cursor.getColumnIndex(KEY_USERNAME);
        int iPassword=cursor.getColumnIndex(KEY_PASSWORD);
        for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
            String res="";
            res=cursor.getString(iId)+ "----" + cursor.getString(iEmail) + "----" + cursor.getString(iUsername) + "----" + cursor.getString(iPassword);

        }*/
        return false;
    }

    private static class DbHelper extends SQLiteOpenHelper{

        public DbHelper(Context context) {
            super(context,DATABASE_NAME,null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String sqlQuery="CREATE TABLE "+TABLE_NAME+" (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_EMAIL + " TEXT NOT NULL, " + KEY_USERNAME +
                    " TEXT NOT NULL, " + KEY_PASSWORD + " TEXT NOT NULL);";
            db.execSQL(sqlQuery);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }

    public UserInfo open()throws SQLException{
        ourHelper = new DbHelper(ourContext);
        myDatabase=ourHelper.getWritableDatabase();
        return this;
    }
    public void close(){
        ourHelper.close();
    }
}

