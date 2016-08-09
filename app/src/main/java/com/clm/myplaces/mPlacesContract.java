package com.clm.myplaces;

import android.net.Uri;

/**
 * Created by CLM on 09/08/2016.
 */
public class mPlacesContract {

    public static class Place
    {
        public static final String TABLE="places";
        public static final String AUTHORITY="com.clm.myplaces";
        public static final Uri CONTENT_URI = Uri.parse("content://"+AUTHORITY+'/'+TABLE);
        public static final String NAME="name";
        public static final String ADDRESS="address";



    }
}
