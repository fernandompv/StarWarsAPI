package com.project.StarWar.Contexts.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Swapiconnection{


    public List<StringBuilder> search(String url, List<String> nameToSearch) {
        List<StringBuilder> listNames = new ArrayList<>();
        nameToSearch.forEach(name -> {
            try {
                URL urlConnection = new URL(url + nameToSearch);
                HttpURLConnection connection = (HttpURLConnection) urlConnection.openConnection();
                connection.setRequestMethod("GET");
                int status = connection.getResponseCode();
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                connection.disconnect();
                listNames.add(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return listNames;
    }


}
