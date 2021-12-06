package com.project.starwars.StarWar.Repository;

import com.project.starwars.StarWar.Model.Mission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepository extends CrudRepository<Mission,Long>{
}
