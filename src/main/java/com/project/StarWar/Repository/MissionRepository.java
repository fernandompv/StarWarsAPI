package com.project.StarWar.Repository;

import com.project.StarWar.Model.Mission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepository extends CrudRepository<Mission,Long>{
}
