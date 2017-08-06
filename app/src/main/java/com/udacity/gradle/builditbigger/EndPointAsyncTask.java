package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.util.Log;
import android.widget.Toast;

import com.example.androidlib.JokeActivity;
import com.example.biro.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by Biro on 8/1/2017.
 */

public class EndPointAsyncTask  extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    private ProgressDialog progressDialog;

    public void setResponseCallBack(ResponseCallBack responseCallBack) {
        this.responseCallBack = responseCallBack;
    }

    public EndPointAsyncTask() {

    }

    private ResponseCallBack responseCallBack;

    public EndPointAsyncTask(Context context) {
        this.context = context;
        progressDialog = new ProgressDialog(context);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        if(progressDialog != null){
            progressDialog.setMessage("loading...");
            progressDialog.show();
        }
    }

    @SafeVarargs
    @Override
    protected final String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/");
            // end options for devappserver
            myApiService = builder.build();

        }



        try {
            return myApiService.pullJokes().execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if(responseCallBack!=null)
            responseCallBack.onSuccess(result);
        else {
            context.startActivity(new Intent(context, JokeActivity.class).putExtra("joke", result));
            progressDialog.dismiss();
        }
    }
    public interface ResponseCallBack{
        void onSuccess(String reuslt);
    }
}