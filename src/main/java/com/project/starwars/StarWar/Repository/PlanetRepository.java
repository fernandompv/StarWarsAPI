package com.project.starwars.StarWar.Repository;

import com.project.starwars.StarWar.Model.Mission;
import com.project.starwars.StarWar.Model.Planet;
import org.springframework.data.repository.CrudRepository;

public interface PlanetRepository extends CrudRepository<Planet,Long>{
}
