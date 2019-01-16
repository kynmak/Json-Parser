package com.daedalus.jsonparser;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();
    private RecyclerView list;
    private RecyclerView.Adapter m_adapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<Destination> destinations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        destinations = new ArrayList<Destination>();
        new receiveData().execute();

        list = (RecyclerView) findViewById(R.id.location_list);
        list.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);
        //add dividers like in listView
        list.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
    }

    private class receiveData extends AsyncTask<Void,Void, Void>{
        @Override
        protected  void onPreExecute(){
            super.onPreExecute();
            //let user know data is incoming/loading
            Toast.makeText(MainActivity.this, "Receiving Json Data", Toast.LENGTH_SHORT).show();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            HttpHelper helper = new HttpHelper();
            String url  = "https://guidebook.com/service/v2/upcomingGuides/";
            String jsonString = helper.makeConnection(url);
            if(jsonString != null){
                try{
                    JSONObject jsonObj = new JSONObject(jsonString);
                    JSONArray jsonArr = jsonObj.getJSONArray("data");
                    for(int i = 0; i < jsonArr.length(); i++){
                        JSONObject o = jsonArr.getJSONObject(i);

                        //city and state attributes are in object venue
                        JSONObject insideObj = o.getJSONObject("venue");
                        String tempCity = "city";
                        String tempState = "state";
                        //check if values <city, state> exist as they are currently missing
                        if(insideObj.has("city"))
                            tempCity = insideObj.getString("city");
                        if(insideObj.has("state"))
                            tempState = insideObj.getString("state");

                        //create temp destination to add to the list with values from json object
                        Destination tempDestination = new Destination(o.getString("startDate"), o.getString("endDate"),
                                o.getString("name"), o.getString("url"),tempCity,tempState, o.getString("icon"));
                        destinations.add(tempDestination);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }else{
                Log.e(TAG, "Could not connect to server");
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void v){
            super.onPostExecute(v);
            //set adapter after parsing data
            m_adapter = new ListAdapter(MainActivity.this, destinations);
            list.setAdapter(m_adapter);
        }


    }
}
