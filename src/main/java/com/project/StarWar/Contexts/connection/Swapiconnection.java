package com.project.StarWar.Contexts.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Swapiconnection{

    public static StringBuilder search(String url,String nameToSearch) throws IOException {
        URL urlConnection = new URL(url+nameToSearch);
        HttpURLConnection con = (HttpURLConnection) urlConnection.openConnection();
        con.setRequestMethod("GET");
        int status = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();
        return content;
    }



}
