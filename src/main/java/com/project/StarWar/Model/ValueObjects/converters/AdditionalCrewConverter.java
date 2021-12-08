package com.project.StarWar.Model.ValueObjects.converters;

import com.project.StarWar.Model.ValueObjects.AditionalCrew;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.math.BigDecimal;

@Converter
public class AdditionalCrewConverter implements AttributeConverter<AditionalCrew, String>{ // <2>

    @Override
    public String convertToDatabaseColumn(AditionalCrew aditionalCrew) {
        return aditionalCrew != null ? aditionalCrew.getNumberOfAditionalCrew().toString(): null;
    }

    @Override
    public AditionalCrew convertToEntityAttribute(String s) {
        return s.isEmpty() ? null : new AditionalCrew(BigDecimal.valueOf(Long.parseLong(s)));
    }
}
