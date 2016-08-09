package com.clm.myplaces;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by CLM on 09/08/2016.
 */
public class mDbHelper extends SQLiteOpenHelper {
    Context c;

    public mDbHelper(Context context) {
        super(context, mConstants.DB_FILE, null, mConstants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
