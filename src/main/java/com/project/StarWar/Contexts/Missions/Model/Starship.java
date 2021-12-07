package com.project.StarWar.Contexts.Missions.Model;

import com.project.StarWar.Contexts.Missions.Model.ValueObjects.AditionalCrew;
import com.project.StarWar.Contexts.Missions.Model.ValueObjects.Crew;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Set;

public class Starship{

    private Long id;

    private String name;

    private BigDecimal passengers;

    private Set<String> pilots;

    private Crew crew;

    private AditionalCrew aditionalCrew;

    public Starship( ) {
        //El framework requiere un constructor sin parametros pero no lo considero una buen apractica por tanto no se debe usar
    }

    private boolean isCorrectStarship() throws IOException {
        return !name.isEmpty();
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

    public BigDecimal getPassengers( ) {
        return passengers;
    }

    public void setPassengers(BigDecimal passengers) {
        this.passengers = passengers;
    }

    public Set<String> getPilots( ) {
        return pilots;
    }

    public void setPilots(Set<String> pilots) {
        this.pilots = pilots;
    }

    public Crew getCrew( ) {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    public AditionalCrew getAditionalCrew( ) {
        return aditionalCrew;
    }

    public void setAditionalCrew(AditionalCrew aditionalCrew) {
        this.aditionalCrew = aditionalCrew;
    }
}
