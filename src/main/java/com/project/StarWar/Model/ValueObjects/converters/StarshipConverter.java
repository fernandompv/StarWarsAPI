package com.project.StarWar.Model.ValueObjects.converters;

import com.project.StarWar.Model.Starship;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

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
