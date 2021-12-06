package com.project.StarWar.Contexts.Missions.Model;

import com.project.StarWar.Contexts.Constants;
import com.project.StarWar.Contexts.connection.Swapiconnection;

import javax.persistence.*;
import java.io.IOException;

@Entity
@Table(name = "Planet")
public class Planet{

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn (name = "mission_id")
    private Mission mission;

    public Planet( ) {
        //El framework requiere un constructor sin parametros pero no lo considero una buen apractica por tanto no se debe usar
    }

    private boolean isCorrectPlanet() throws IOException {
        return Swapiconnection.search(Constants.SWAPI_SEARCH_PLANET,name) != null;
    }

    public Planet(Mission mission) {
        this.mission = mission;
    }

    public Mission getMission( ) {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    public String getName( ) {return name;}

    public void setName(String name) {this.name = name;}
}
