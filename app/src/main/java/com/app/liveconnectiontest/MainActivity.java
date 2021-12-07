package com.app.liveconnectiontest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.app.liveconnectiontest.Adapter.GridviewListAdapter;
import com.app.liveconnectiontest.databinding.ActivityMainBinding;
import com.app.liveconnectiontest.models.MovieModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {

    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private String url = "https://api.themoviedb.org/3/movie/popular?api_key=434d1d4ec64f574aed3d6f31bc984c2f";

    ArrayList<MovieModel> movieList;

    ActivityMainBinding binding;
    GridviewListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        movieList=new ArrayList<>();

        getData();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
        finish();
    }


    public void getData(){


        mRequestQueue = Volley.newRequestQueue(this);

        mStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONObject jsonObject = new JSONObject(response);
                   // Toast.makeText(getApplicationContext(),"Response :" + jsonObject.toString(), Toast.LENGTH_LONG).show();

                    JSONArray jsonArray=jsonObject.getJSONArray("results");

                    for(int i=0;i<jsonArray.length();i++){
                         JSONObject object=jsonArray.getJSONObject(i);


                         String adult=object.getString("adult");
                         String backdrop_path=object.getString("backdrop_path");
                         String id=object.getString("id");
                         String lang=object.getString("original_language");
                         String title=object.getString("original_title");
                         String popularity=object.getString("popularity");

                        Log.d("id",id.toString());
                        Log.d("adult",adult.toString());
                        Log.d("backdrop_path",backdrop_path.toString());

                        MovieModel model=new MovieModel(id,adult,backdrop_path,lang,title,popularity);
                        movieList.add(model);
                    }

                    if (!movieList.isEmpty()){
                        binding.rvList.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
                        adapter = new GridviewListAdapter(MainActivity.this, movieList);
                        binding.rvList.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }

                }
                catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d("error",error.toString());
            }
        });

        mRequestQueue.add(mStringRequest);
    }


}