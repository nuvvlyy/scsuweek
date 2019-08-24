package com.example.scsuweek;

import android.os.Build;
import android.support.annotation.RequiresApi;

import org.json.JSONException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class JsonSingleton {


//    private class HTTPAsyncTask extends AsyncTask<String, Void, String> {
//        @Override
//        protected String doInBackground(String... urls) {
//            // params comes from the execute() call: params[0] is the url.
//            try {
//                try {
//                    return HttpPost(urls[0]);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                    return "Error!";
//                }
//            } catch (IOException e) {
//                return "Unable to retrieve web page. URL may be invalid.";
//            }
//        }
//        // onPostExecute displays the results of the AsyncTask.
//        @Override
//        protected void onPostExecute(String result) {
////            tvResult.setText(result);
//        }
//    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    String HttpPost(String room, final String id) throws IOException, JSONException {

    String urlParameters = "id="+id;
        URL url;
        HttpURLConnection connection = null;
        try{
            //Create connection
            byte[] postData = urlParameters.getBytes( StandardCharsets.UTF_8 );
            int postDataLength = postData.length;
            String request = "http://us-central1-scweek62-7febd.cloudfunctions.net/api/checkin/" + room;
            URL Url = new URL( request );
            HttpURLConnection conn= (HttpURLConnection) Url.openConnection();
            conn.setDoOutput(true);
            conn.setInstanceFollowRedirects(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("charset", "utf-8");
            conn.setRequestProperty("Content-Length", Integer.toString(postDataLength ));
            conn.setUseCaches(false);
            return "byebye";
//            try(DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
//                wr.write( postData );
//                wr.flush();
//                wr.close();
//            }catch (IOException e){
//
//            }


        }
        catch (Exception e) {
            return "eieieiei";
        }

//        String result = "";




        // 1. create HttpURLConnection

//        conn.setRequestMethod("POST");
//        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//        conn.setRequestProperty("charset", "utf-8");
//
//         2. build JSON object
//        JSONObject jsonObject = buidJsonObject(id);
//
//         3. add JSON content to POST request body
//        setPostRequestContent(conn, jsonObject);
//
//         4. make POST request to the given URL
//        conn.connect();
//
//         5. return response message
//        return "eieieiei";

    }
//
//
//    private JSONObject buidJsonObject(String id) throws JSONException {
//
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.accumulate("id",id);
//
//        return jsonObject;
//    }
//    private void setPostRequestContent(HttpURLConnection conn,
//                                       JSONObject jsonObject) throws IOException {
//
//        OutputStream os = conn.getOutputStream();
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
//        writer.write(jsonObject.toString());
//        Log.i(MainActivity.class.toString(), jsonObject.toString());
//        writer.flush();
//        writer.close();
//        os.close();
//    }


}
