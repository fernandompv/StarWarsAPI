package com.project.StarWar.DTO;

import com.google.gson.Gson;
import com.project.StarWar.Constants;
import com.project.StarWar.Model.Captain;
import com.project.StarWar.Model.Mission;
import com.project.StarWar.Model.Planet;
import com.project.StarWar.Model.Starship;
import com.project.StarWar.connection.Swapiconnection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class CastMissionDtoToMission{

    public Mission cast(MissionDTO dto){
        Swapiconnection swapiconnection = new Swapiconnection();
        swapiconnection.search(Constants.SWAPI_SEARCH_PLANET,dto.getPlanet());
        List<Planet> planets = castPlanetsFromJson(castStringJsonToObject(swapiconnection.search(Constants.SWAPI_SEARCH_PLANET,dto.getPlanet())));
        List<Captain> captains = castCaptainsFromJson(castStringJsonToObject(swapiconnection.search(Constants.SWAPI_SEARCH_PEOPLE,dto.getCaptain())));
        List<Starship> starships = castStarshipsFromJson(castStringJsonToObject(swapiconnection.search(Constants.SWAPI_SEARCH_STARSHIP, Collections.singletonList(dto.getStarship()))));
        return new Mission(dto.getStartDate(),starships.get(0),new HashSet<>(captains),new HashSet<>(planets));
    }

    public List<Object> castStringJsonToObject(List<StringBuilder> multipleJson){
        Gson g = new Gson();
        List<Object> list = new ArrayList<>();
        multipleJson.forEach(stringBuilder -> {
            list.add(g.fromJson(String.valueOf(stringBuilder), Object.class));
        });
        return list;
    }

    public List<Planet> castPlanetsFromJson(List<Object> objectList){
        List<Planet> planets = new ArrayList<>();
        objectList.forEach(o -> {
            planets.add((Planet) o);
        });
        return planets;
    }

    public List<Captain> castCaptainsFromJson(List<Object> objectList){
        List<Captain> captainList = new ArrayList<>();
        objectList.forEach(o -> {
            captainList.add((Captain) o);
        });
        return captainList;
    }

    public List<Starship> castStarshipsFromJson(List<Object> objectList){
        List<Starship> starshipList = new ArrayList<>();
        objectList.forEach(o -> {
            starshipList.add((Starship) o);
        });
        return starshipList;
    }
}
