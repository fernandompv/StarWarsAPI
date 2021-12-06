package com.project.StarWar.Contexts.Missions.Model;

import com.project.StarWar.Contexts.Constants;
import com.project.StarWar.Contexts.Missions.Model.ValueObjects.Crew;
import com.project.StarWar.Contexts.connection.Swapiconnection;

import java.io.IOException;

public class Starship{

    private Long id;

    private String name;

    private Crew crew;

    public Starship( ) {
        //El framework requiere un constructor sin parametros pero no lo considero una buen apractica por tanto no se debe usar
    }

    private boolean isCorrectStarship() throws IOException {
        return Swapiconnection.search(Constants.SWAPI_SEARCH_STARSHIP,name) != null;
    }

    public Starship(String name) {
        this.name = name;
    }

    public String getName( ) {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Crew getCrew( ) {return crew;}

    public void setCrew(Crew crew) {this.crew = crew;}
}
