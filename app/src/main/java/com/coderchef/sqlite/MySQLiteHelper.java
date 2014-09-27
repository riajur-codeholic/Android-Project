package com.coderchef.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.coderchef.userinfo.LoanHolderInfo;
import com.coderchef.userinfo.UserData;

/**
 * Created by riajur on 9/6/2014.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "userdata_db";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE userdata_table ( " +
                "email TEXT, " +
                "username TEXT, "+
                "password TEXT )";

        // create books table
        db.execSQL(CREATE_USER_TABLE);

        String LOAN_MANAGER_TABLE = "CREATE TABLE loan_info ( " +
                "name TEXT " +
                "phone TEXT " +
                "amount TEXT " +
                "address TEXT " +
                "start_date TEXT " +
                "end_date TEXT " +
                "loan_status TEXT )";
        db.execSQL(LOAN_MANAGER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i2) {
        db.execSQL("DROP TABLE IF EXISTS userdata_table");
        db.execSQL("DROP TABLE IF EXISTS loan_info");
        this.onCreate(db);
    }


    private static final String TABLE_USER = "userdata_table";

    private static final String KEY_EMAIL = "email";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    private static final String[] COLUMNS = {KEY_EMAIL,KEY_USERNAME,KEY_PASSWORD};

    public long insertUser(UserData userData){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_EMAIL,userData.getEmail());
        contentValues.put(KEY_USERNAME,userData.getUsername());
        contentValues.put(KEY_PASSWORD,userData.getPassword());
        return  db.insert(TABLE_USER, null ,contentValues);
    }

    public boolean doLogin(String user,String pass){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USER, COLUMNS, "username = ? AND password = ?", new String[]{user,pass},null,null,null,null);
        if(cursor!=null){
            return true;
        }
        return false;
    }

    private static final String LOAN_TABLE = "loan_info";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_AMOUNT = "amount";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_START_DATE = "start_date";
    private static final String KEY_END_DATE = "end_date";
    private static final String KEY_LOAN_STATUS = "loan_status";

    private static final String [] LOAN_COLUMNS = {KEY_NAME,KEY_PHONE,KEY_AMOUNT,KEY_ADDRESS,KEY_START_DATE,KEY_END_DATE,KEY_LOAN_STATUS};

    public long insertLoanEntry(LoanHolderInfo loanHolderInfo){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME,loanHolderInfo.getName());
        contentValues.put(KEY_PHONE,loanHolderInfo.getPhone());
        contentValues.put(KEY_AMOUNT,loanHolderInfo.getAmount());
        contentValues.put(KEY_ADDRESS,loanHolderInfo.getAddress());
        contentValues.put(KEY_START_DATE,loanHolderInfo.getStart_date());
        contentValues.put(KEY_END_DATE,loanHolderInfo.getEnd_date());
        contentValues.put(KEY_LOAN_STATUS,loanHolderInfo.getLoan_status());
        return db.insert(LOAN_TABLE,null,contentValues);
    }

}
