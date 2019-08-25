package com.example.scsuweek;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class httphandler extends AsyncTask <String, Void,String> {
    static  String str;

    public httphandler() {
    }

    @Override
    protected String doInBackground(String... urls) {
        try {

            OkHttpClient client = new OkHttpClient();
            if(urls[2]=="post"){
                MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
                RequestBody body = RequestBody.create(mediaType, "id="+urls[1]);
                Request request = new Request.Builder()
                        .url(urls[0])
                        .post(body)
                        .addHeader("content-type", "application/x-www-form-urlencoded")
                        .addHeader("cache-control", "no-cache")
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
            }else if(urls[2] =="get"){
                MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
                Request request = new Request.Builder()
                        .url("http://us-central1-scweek62-7febd.cloudfunctions.net/api/getroom")
                        .get()
                        .addHeader("cache-control", "no-cache")
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
                        str = mMessage;
                        try {
                            int room1= ROOM1();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
                return request.toString();

            }

        } catch (Exception e) {
            return  e.getMessage();
        } finally {
            return "finally";
        }
    }
    protected void onPostExecute() {

    }
     static int ROOM1() throws JSONException {
        JSONObject Jobject = new JSONObject(str);
        JSONObject room1 = Jobject.getJSONObject("room1");
        int room1L =room1.length();
        return room1L;
    }
    static int ROOM2() throws JSONException {
        JSONObject Jobject = new JSONObject(str);
        JSONObject room2 = Jobject.getJSONObject("room2");
        int room2L =room2.length();
        return room2L;
    }
    static int ROOM3() throws JSONException {
        JSONObject Jobject = new JSONObject(str);
        JSONObject room3 = Jobject.getJSONObject("room3");
        int room3L =room3.length();
        return room3L;
    }
    static int ROOM4() throws JSONException {
        JSONObject Jobject = new JSONObject(str);
        JSONObject room4 = Jobject.getJSONObject("room4");
        int room4L =room4.length();
        return room4L;
    }


}
