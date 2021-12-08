package com.project.StarWar.Contexts.Missions.Model;

import com.project.StarWar.Contexts.Missions.Model.ValueObjects.converters.AdditionalCrewConverter;
import com.project.StarWar.Contexts.Missions.Model.ValueObjects.converters.StarshipConverter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Mission")
public class Mission{

    @Id
    @GeneratedValue
    private Long id;
    private String startDate;

    @Convert(converter = StarshipConverter.class)
    private Starship starship;

    @OneToMany(
            mappedBy = "mission",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Captain> captains = new HashSet<>();

    @OneToMany(
            mappedBy = "mission",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Planet> planets = new HashSet<>();

    private String active;

    public Mission( ) {
        //El framework requiere un constructor sin parametros pero no lo considero una buen apractica por tanto no se debe usar
    }

    public Mission(String startDate, Starship starship, Set<Captain> captains, Set<Planet> planets) {
        this.startDate = startDate;
        this.starship = starship;
        this.captains = captains;
        this.planets = planets;
    }

    public boolean validateIfStartDateExist(){
        return !this.startDate.isEmpty();
    }

    public boolean validateIfTheCaptainAddinToAditionalCrewAreHiguerOrEqualsThanRequiredCrew(){
        return starship.getAditionalCrew().getNumberOfAditionalCrew().add(BigDecimal.valueOf(captains.size())).compareTo(starship.getCrew().getNumber()) >= 0;
    }

    public boolean validateIfTheCaptainAddinToAditionalCrewAreAreLessOrEqualsThanTheAddinOfPassengerWithTheCrew(){
        return starship.getAditionalCrew().getNumberOfAditionalCrew().add(BigDecimal.valueOf(captains.size())).compareTo(starship.getCrew().getNumber().add(starship.getPassengers())) <= 0;
    }

    public String getStartDate( ) {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Starship getStarship( ) {
        return starship;
    }

    public void setStarship(Starship starship) {
        this.starship = starship;
    }

    public Set<Captain> getCaptains( ) {
        return captains;
    }

    public void setCaptains(Set<Captain> captains) {
        this.captains = captains;
    }

    public Set<Planet> getPlanets( ) {
        return planets;
    }

    public void setPlanets(Set<Planet> planets) {
        this.planets = planets;
    }

    public String getActive( ) {return active;}

    public void setActive(String active) {this.active = active;}
}
