package com.project.StarWar.Contexts.Missions.Model.ValueObjects;

import java.math.BigDecimal;

public class Crew{

    private BigDecimal number;


    public Crew( ) {
    }

    public Crew(BigDecimal number) {
        this.number = number;
    }

    private boolean isValidCrew(){
        return number.compareTo(BigDecimal.ZERO) >= 0;
    }

    public BigDecimal getNumber( ) {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }
}
