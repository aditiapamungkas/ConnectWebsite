package com.example.asus.newasyncinternet;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Asus on 21/10/2017.
 */

public class DownloadImageTask extends AsyncTask<String, Void,Bitmap> {

    @Override
    protected Bitmap doInBackground(String... strings) {
        Object s1 = strings[0];
        InputStream in;

        try {
            URL myUrl = new URL((String) s1);
            HttpURLConnection myConn = (HttpURLConnection) myUrl.openConnection();
            myConn.setReadTimeout(1000);
            myConn.setConnectTimeout(2000);
            myConn.setRequestMethod("GET");
            myConn.connect();

            in= myConn.getInputStream();

            Bitmap myMap = BitmapFactory.decodeStream(in);

            return myMap;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void OnPostExcecute(Bitmap bitmap){
        MainActivity.myImage.setImageBitmap(bitmap);
    }
}
