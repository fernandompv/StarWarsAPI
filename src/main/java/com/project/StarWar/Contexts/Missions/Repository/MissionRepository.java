package com.project.StarWar.Contexts.Missions.Repository;

import com.project.StarWar.Contexts.Missions.Model.Mission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepository extends CrudRepository<Mission,Long>{
}
