package com.project.StarWar.DTO;

import java.util.List;

public class MissionDTO{
    private String starship;
    private List<String> Captain;
    private List<String> planet;
    private String startDate;

    public String getStarship( ) {
        return starship;
    }

    public void setStarship(String starship) {
        this.starship = starship;
    }

    public List<String> getCaptain( ) {
        return Captain;
    }

    public void setCaptain(List<String> captain) {
        Captain = captain;
    }

    public List<String> getPlanet( ) {
        return planet;
    }

    public void setPlanet(List<String> planet) {
        this.planet = planet;
    }

    public String getStartDate( ) {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
