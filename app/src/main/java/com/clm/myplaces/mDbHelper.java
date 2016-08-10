package com.clm.myplaces;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by CLM on 09/08/2016.
 */
public class mDbHelper extends SQLiteOpenHelper {
    Context c;

    public mDbHelper(Context context) {
        super(context, mConstants.DB_FILE, null, mConstants.DB_VERSION);
        c=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createQuery=String.format("CREATE TABLE %s ( %s INTEGER PRIMARY KEY, %s TEXT, %s TEXT,",
                mPlacesContract.Place.TABLE,
                mConstants.DB_ID,
                mConstants.DB_QUERY,
                mPlacesContract.Place.NAME,
                mPlacesContract.Place.ADDRESS,
                mPlacesContract.Place.IMAGE);
        db.execSQL(createQuery);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
