package com.example.controllers;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {

    private static final HttpClient client = HttpClient.newHttpClient();
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    // GET request — fetch a user by ID
    public static void getUser(int userId) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/users/" + userId))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("GET user status: " + response.statusCode());
        System.out.println("Body: " + response.body());
    }

    // POST request — create a new post
    public static void createPost(String jsonBody) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/posts"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("POST status: " + response.statusCode());
        System.out.println("Body: " + response.body());
    }

    // PUT request — update a post
    public static void updatePost(int postId, String jsonBody) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/posts/" + postId))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("PUT status: " + response.statusCode());
        System.out.println("Body: " + response.body());
    }

    // DELETE request — delete a post
    public static void deletePost(int postId) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/posts/" + postId))
                .DELETE()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("DELETE status: " + response.statusCode());
    }

    public static void main(String[] args) throws Exception {
        getUser(1);

        createPost("{\"title\": \"Hello\", \"body\": \"World\", \"userId\": 1}");

        updatePost(1, "{\"id\": 1, \"title\": \"Updated\", \"body\": \"Content\", \"userId\": 1}");

        deletePost(1);
    }
}
