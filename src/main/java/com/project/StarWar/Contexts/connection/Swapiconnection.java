package com.project.StarWar.Contexts.connection;

import org.springframework.boot.logging.log4j2.Log4J2LoggingSystem;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Swapiconnection{

    private URL urlConnection;
    private HttpURLConnection connection;

    public Swapiconnection(String url,String nameToSearch ) {
        try {
            urlConnection = new URL(url+nameToSearch);
            connection = (HttpURLConnection) urlConnection.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    public StringBuilder search() throws IOException {
        connection.setRequestMethod("GET");
        int status = connection.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        connection.disconnect();
        return content;
    }



}
