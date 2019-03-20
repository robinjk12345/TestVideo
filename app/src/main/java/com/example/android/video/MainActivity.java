package com.example.android.video;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        File myFile = new File("/storage/emulated/0/DCIM/Camera/VID_20190320_225115.mp4");
        RequestParams params = new RequestParams();
        try {
            params.put("text", myFile);
        } catch (Exception e) {
        }

// send request
        String url = "https://webhook.site/edf17950-cd62-4c34-8286-3622a73014ea";
        AsyncHttpClient client = new AsyncHttpClient();
        client.setURLEncodingEnabled(false);
        client.post(url, params, new AsyncHttpResponseHandler() {

            //  @Override
            //     public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

            //    }
            //   @Override
            //  public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

            //   }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Context context = getApplicationContext();
                CharSequence text = "Forwarding call to server!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Context context = getApplicationContext();
                CharSequence text = "Connection failed!";

                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            }


        });


    }
}
