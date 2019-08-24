package com.example.scsuweek;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class httphandler extends AsyncTask <String, Void,String> {
    @Override
    protected String doInBackground(String... urls) {
        try {
            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
            RequestBody body = RequestBody.create(mediaType, "id="+urls[1]);
            Request request = new Request.Builder()
                    .url(urls[0])
                    .post(body)
                    .addHeader("content-type", "application/x-www-form-urlencoded")
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "418788d6-a783-d3e8-1c52-5cef9a9d14f5")
                    .build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    String mMessage = e.getMessage().toString();
                    Log.w("failure Response", mMessage);
                    //call.cancel();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String mMessage = response.body().string();
                }
            });
            return  "success";
        } catch (Exception e) {
            return  "exception";
        } finally {
            return "finally";
        }
    }
    protected void onPostExecute() {

    }
}
