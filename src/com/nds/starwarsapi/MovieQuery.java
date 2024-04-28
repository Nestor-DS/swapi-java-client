package com.nds.starwarsapi;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MovieQuery {

    public Movie searchMovie(int movieNum) {

        URI uri = URI.create("https://swapi.py4e.com/api/films/" + movieNum +"/");
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();


        try {
            HttpResponse<String> response;
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Check the response status code
            int statusCode = response.statusCode();
            if (statusCode == 200) {
                System.out.println("Connection to API successful");
            } else {
                System.out.println("Error connecting to API. Status code: " + statusCode);
            }
            return new Gson().fromJson(response.body(), Movie.class);
        } catch (Exception e) {
            throw new RuntimeException("Movie not found: " + e);
        }
    }
}
