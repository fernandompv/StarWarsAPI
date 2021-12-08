package com.project.StarWar.Model.ValueObjects;

import com.sun.beans.decoder.ValueObject;

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

    @Override
    public String toString( ) {
        return "Crew{" +
                "number=" + number +
                '}';
    }
}
