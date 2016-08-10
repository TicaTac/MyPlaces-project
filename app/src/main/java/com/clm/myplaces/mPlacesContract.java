package com.clm.myplaces;

import android.net.Uri;

/**
 * Created by CLM on 09/08/2016.
 */
public class mPlacesContract {

    public static class Place
    {
        public static  String TABLE="places";
        public static  String AUTHORITY="com.clm.myplaces";
        public static  Uri CONTENT_URI = Uri.parse("content://"+AUTHORITY+'/'+TABLE);
        public static  String NAME="name";
        public static  String ADDRESS="address";
        public static  String IMAGE="image";



    }
}
