package com.project.StarWar.Contexts.Missions.Model.ValueObjects.converters;

import com.project.StarWar.Contexts.Missions.Model.Starship;
import com.project.StarWar.Contexts.Missions.Model.ValueObjects.Crew;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.math.BigDecimal;

@Converter
public class StarshipConverter implements AttributeConverter<Starship, String>{

    @Override
    public String convertToDatabaseColumn(Starship starship) {
        return starship != null ? starship.getName() : null;
    }

    @Override
    public Starship convertToEntityAttribute(String s) {
        return s.isEmpty() ? null : new Starship(s);
    }
}
