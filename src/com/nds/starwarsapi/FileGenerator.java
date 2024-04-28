package com.nds.starwarsapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator {
    public void saveJson(Movie movie) throws IOException {
        // Create Gson instance with pretty printing enabled
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Create FileWriter to write JSON to a file named after the movie title
        FileWriter writer = new FileWriter(movie.title() + ".json");

        // Write JSON representation of the movie object to the file
        writer.write(gson.toJson(movie));

        // Close the FileWriter
        writer.close();
    }
}
