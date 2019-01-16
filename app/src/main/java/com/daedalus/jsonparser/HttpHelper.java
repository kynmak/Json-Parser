package com.daedalus.jsonparser;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Daedalus on 1/15/19.
 */

public class HttpHelper {
    //receive data from url
    public HttpHelper(){
    }
    public String makeConnection (String input_url){
        String response = null;
        try{
            URL url = new URL(input_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            response = parseStream(inputStream);
            //print out data received from URL
            System.out.println(response);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
    private String parseStream(InputStream inputStream){
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder data = new StringBuilder();
        String line;
        try{
            while((line = reader.readLine()) != null)
                data.append(line).append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try{
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data.toString();
    }
}
