package com.project.starwars.StarWar.Repository;

import com.project.starwars.StarWar.Model.Planet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends CrudRepository<Planet,Long>{
}
