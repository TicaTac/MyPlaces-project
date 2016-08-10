package com.clm.myplaces;

import android.graphics.Bitmap;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by CLM on 7/27/2016.
 */
public class mGetJsonHelper {

    public String getJsonQuery(String uri)
    {
        BufferedReader input = null;
        StringBuilder response = new StringBuilder();
        HttpURLConnection connection = null;
        URL url;
        int lineCount = 0;
        try {
            url = new URL(uri);

            connection = (HttpURLConnection) url.openConnection();
            if (connection.getResponseCode() == HttpsURLConnection.HTTP_OK) {
              //  connection.getResponseCode();
                input = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                //go over the input, line by line
                String line = "";
                while ((line = input.readLine()) != null) {
                    //append it to a StringBuilder to hold the
                    //resulting string
                    response.append(line + "\n");
                    //   lineCount++;
                }
            } else {
                // See documentation for more info on response handling
            }
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (input != null) {
                try {
                    //must close the reader
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                //must disconnect the connection
                connection.disconnect();
            }

        }

        return String.valueOf(response);
    }

    ///////////////////////////////////////////// PARSE SearchResult JSON /////////////////////////////////////////////////////
  /*
    protected ArrayList<mPlacesContract.Place> parseJsonForMovieQuery(String result) {
        ArrayList<myMovieQuery> queryList=new ArrayList<>();

        try {

            //the main JSON object - initialize with string
            JSONObject jsonResult = new JSONObject(result);
            if (jsonResult.getBoolean("Response")==true) {
                //extract data with getString, getInt getJsonObject - for inner objects or JSONArray- for inner arrays

                Log.d("ParseJson","Loading Results! ");
                searchMessageTV.setText("Loading Results..");

                JSONArray myArray = jsonResult.getJSONArray("Search");

                for (int i = 0; i < myArray.length(); i++) {
                    //get temp inner object [i] inside the array
                    JSONObject tempObj = myArray.getJSONObject(i);
                    // parse the inside of the object to a new myMovieQuery
                    // todo create movie
                    imageHelper = new myGetImageHelper();
                    imageHelper.execute(tempObj.getString("Poster"));
                    // TODO: 7/27/2016  if poster is null
                    Bitmap bmp = imageHelper.get();
                    // Log.d("ParseJson","imageHelper.get :"+bmp.toString());
                    myMovieQuery movie = new myMovieQuery(
                            tempObj.getString("Title"),
                            tempObj.getString("Year"),
                            tempObj.getString("imdbID"),
                            tempObj.getString("Type"),
                            tempObj.getString("Poster"),
                            bmp);
                    Log.d("ParseJson", "imageHelper.get :" + imageHelper.toString());
                    queryList.add(movie);
                }
                Log.d("ParseJson","Results "+queryList.size());

            } else
            {
                String errorMessage=jsonResult.getString("Error");
                Log.d("ParseJson","Error: "+errorMessage);
                searchMessageTV.setText(errorMessage);
            }





        } catch (JSONException e) {
            e.printStackTrace();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //  debugTV.setText(result);
        return queryList;
    }
    */
}



