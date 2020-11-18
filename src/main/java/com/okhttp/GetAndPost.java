package com.okhttp;

import okhttp3.*;

import java.io.IOException;

/**
 * TODO
 *
 * @author ahao 2020-10-05
 */
public class GetAndPost {
    public static void main(String[] args) {
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody build = new FormBody.Builder()
                .add("template_id","3458")
                .add("mobile", "1879638883")
                .add("vars", "123199")
                .build();
        Request request = new Request.Builder()
                .url("https://sms-api.upyun.com/api/messages")
                .post(build)
                .header("Connection", "Keep-Alive")
                .header("Authorization", "Sh344J0A4xlJSQV72iceCQLl9w65dn")
                .header("Content-type", "application/json")
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            System.out.println(response.code());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
