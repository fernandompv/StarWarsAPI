package com.project.starwars.StarWar.Model;

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
    private String starship;

    @OneToMany(
            mappedBy = "mission",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Captain> captains = new HashSet<>();
    private BigDecimal crew;

    @OneToMany(
            mappedBy = "mission",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Planet> planets = new HashSet<>();

    public String getStartDate( ) {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStarship( ) {
        return starship;
    }

    public void setStarship(String starship) {
        this.starship = starship;
    }

    public Set<Captain> getCaptains( ) {
        return captains;
    }

    public void setCaptains(Set<Captain> captains) {
        this.captains = captains;
    }

    public BigDecimal getCrew( ) {
        return crew;
    }

    public void setCrew(BigDecimal crew) {
        this.crew = crew;
    }

    public Set<Planet> getPlanets( ) {
        return planets;
    }

    public void setPlanets(Set<Planet> planets) {
        this.planets = planets;
    }
}
