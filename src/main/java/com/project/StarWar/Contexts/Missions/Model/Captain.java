package com.project.StarWar.Contexts.Missions.Model;

import com.project.StarWar.Contexts.Missions.Model.Mission;
import com.project.StarWar.Contexts.connection.H2DatabaseConnection;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Captain")
public class Captain{

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "mission_id")
    private Mission mission;

    public Captain( ) {
        //El framework requiere un constructor sin parametros pero no lo considero una buen apractica por tanto no se debe usar
    }

    public Captain(String name, Mission mission) {
        this.name = name;
        this.mission = mission;
    }

    public boolean isActiveMissionForthisCaptain(){
        H2DatabaseConnection db = new H2DatabaseConnection();
        List<String> parameters = new ArrayList<>();
        parameters.add(name);
        try {
            return !db.execQuery(db.createStatementForQuery("SELECT * FROM MISSION WHERE Captain = ?",parameters)).getString("active").isEmpty();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void validateIfExist(){

    }

    public String getName( ) {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mission getMission( ) {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }
}
