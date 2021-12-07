package com.project.StarWar.Contexts.connection;

import java.sql.*;
import java.util.List;

public class H2DatabaseConnection{

    private Connection connection;

    public H2DatabaseConnection( ) {
        try {
            Class.forName("org.h2.Driver");
            this.connection = DriverManager.getConnection("jdbc:h2:mem:StarwarsDB", "sa", "sa");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }


    public ResultSet execQuery(PreparedStatement statement){
        PreparedStatement statement;
        ResultSet rs;
        try {
            statement = connection.prepareStatement(query);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return null;
    }

    public PreparedStatement createStatementForQuery(String query, List<String> parameters){
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            for(int i = 0; i < parameters.size(); i++){
                statement.setString(i,parameters.get(1));
            }
            return statement;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return null;
    }

    public Connection getConnection( ) {
        return connection;
    }
}
