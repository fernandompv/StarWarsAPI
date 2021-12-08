package com.project.StarWar.Model.ValueObjects;

import java.math.BigDecimal;

public class AditionalCrew{

    private BigDecimal numberOfAditionalCrew;

    public AditionalCrew( ) {
    }

    public AditionalCrew(BigDecimal numberOfCrew) {
        this.numberOfAditionalCrew = numberOfCrew;
    }

    private boolean isValidCrew(){
        return numberOfAditionalCrew.compareTo(BigDecimal.ZERO) >= 0;
    }

    public BigDecimal getNumberOfAditionalCrew( ) {
        return numberOfAditionalCrew;
    }

    public void setNumberOfAditionalCrew(BigDecimal numberOfAditionalCrew) {
        this.numberOfAditionalCrew = numberOfAditionalCrew;
    }

    @Override
    public String toString( ) {
        return "AditionalCrew{" +
                "numberOfAditionalCrew=" + numberOfAditionalCrew +
                '}';
    }
}
