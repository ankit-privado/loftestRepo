package com.example.controllers;

import okhttp3.*;

public class OkHttpExample {

    static OkHttpClient client = new OkHttpClient();
    static MediaType JSON = MediaType.get("application/json");
    static String BASE = "https://jsonplaceholder.typicode.com";

    public static void main(String[] args) throws Exception {

        // GET
        Request get = new Request.Builder()
                .url(BASE + "/posts/1")
                .build();
        Response getResp = client.newCall(get).execute();
        System.out.println(getResp.body().string());

        // POST
        String body = "{\"title\":\"foo\",\"body\":\"bar\",\"userId\":1}";
        Request post = new Request.Builder()
                .url(BASE + "/posts")
                .post(RequestBody.create(body, JSON))
                .build();
        Response postResp = client.newCall(post).execute();
        System.out.println(postResp.body().string());

        // PUT
        Request put = new Request.Builder()
                .url(BASE + "/posts/1")
                .put(RequestBody.create(body, JSON))
                .build();
        Response putResp = client.newCall(put).execute();
        System.out.println(putResp.body().string());

        // DELETE
        Request delete = new Request.Builder()
                .url(BASE + "/posts/1")
                .delete()
                .build();
        Response deleteResp = client.newCall(delete).execute();
        System.out.println(deleteResp.code());
    }
}
