package com.project.StarWar.Contexts.Missions.Model.ValueObjects;

import java.math.BigDecimal;

public class Crew{

    private BigDecimal numberOfCrew;

    public Crew( ) {
    }

    public Crew(BigDecimal numberOfCrew) {
        this.numberOfCrew = numberOfCrew;
    }

    private boolean isValidCrew(){
        return numberOfCrew.compareTo(BigDecimal.ZERO) >= 0;
    }

    public BigDecimal getNumberOfCrew( ) {
        return numberOfCrew;
    }

    public void setNumberOfCrew(BigDecimal numberOfCrew) {
        this.numberOfCrew = numberOfCrew;
    }
}
