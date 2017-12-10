package com.example.easywallet.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by RTA on 12/10/2017.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "money.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "one";
    public static final String COLL_ID = "_id";
    public static final String COLL_PICTURE = "picture";
    public static final String COLL_DETAILS = "detail";
    public static final String COLL_MONEY = "income";

    private static final String SQL_CREATE_TABLE = "CREATE TABLE" + TABLE_NAME + "("
            + COLL_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLL_PICTURE + " TEXT, "
            + COLL_DETAILS + " TEXT, "
            + COLL_MONEY + " INTEGER, "
            + ")";

    private Context mContext;
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE);
        insertInitialData(sqLiteDatabase);
    }

    private void insertInitialData(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(COLL_PICTURE, "ic_income.png");
        cv.put(COLL_DETAILS, "คุณพ่อให้เงิน");
        cv.put(COLL_MONEY, "8000");
        db.insert(TABLE_NAME,null,cv);

        cv = new ContentValues();
        cv.put(COLL_PICTURE, "ic_expend.png");
        cv.put(COLL_DETAILS, "จ่ายค่าหอ");
        cv.put(COLL_MONEY, "2500");
        db.insert(TABLE_NAME,null,cv);

        cv = new ContentValues();
        cv.put(COLL_PICTURE, "ic_expend.png");
        cv.put(COLL_DETAILS, "ซื้อล็อตเตอรี่ 1 ชุด");
        cv.put(COLL_MONEY, "700");
        db.insert(TABLE_NAME,null,cv);

        cv = new ContentValues();
        cv.put(COLL_PICTURE, "ic_income.png");
        cv.put(COLL_DETAILS, "ถูกล็อตเตอรี่รางวัลที่ 1");
        cv.put(COLL_MONEY, "30000000");
        db.insert(TABLE_NAME,null,cv);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
