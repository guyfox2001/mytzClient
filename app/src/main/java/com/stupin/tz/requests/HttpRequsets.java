package com.stupin.tz.requests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequsets {
    final private URL url;
    final private HttpURLConnection connection;

    public HttpRequsets(URL url, HttpURLConnection connection) {
        this.url = url;
        this.connection = connection;
    }
    public void onConnect(){
        try {
            connection.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void offConnect(){
        connection.disconnect();
    }

}
