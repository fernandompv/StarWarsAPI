package com.project.StarWar.Contexts.Missions.Model.ValueObjects.converters;

import com.project.StarWar.Contexts.Missions.Model.ValueObjects.Crew;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.math.BigDecimal;

@Converter
public class CrewConverter implements AttributeConverter<Crew, String>{ // <2>

    @Override
    public String convertToDatabaseColumn(Crew crew) {
        return crew != null ? crew.getNumber().toString(): null;
    }

    @Override
    public Crew convertToEntityAttribute(String s) {
        return s.isEmpty() ? null : new Crew(BigDecimal.valueOf(Long.parseLong(s)));
    }
}
