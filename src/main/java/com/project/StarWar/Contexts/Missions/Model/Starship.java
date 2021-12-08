package com.project.StarWar.Contexts.Missions.Model;

import com.project.StarWar.Contexts.Missions.Model.ValueObjects.AditionalCrew;
import com.project.StarWar.Contexts.Missions.Model.ValueObjects.Crew;
import com.project.StarWar.Contexts.Missions.Model.ValueObjects.converters.AdditionalCrewConverter;
import com.project.StarWar.Contexts.Missions.Model.ValueObjects.converters.CrewConverter;

import javax.persistence.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table (name = "Starship")
public class Starship{

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private BigDecimal passengers;

    @ElementCollection
    private Set<String> pilots;

    @Convert (converter = CrewConverter.class)
    private Crew crew;

    @Convert(converter = AdditionalCrewConverter.class)
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
