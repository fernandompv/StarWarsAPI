package com.project.starwars.StarWar.Repository;

import com.project.starwars.StarWar.Model.Captain;
import com.project.starwars.StarWar.Model.Mission;
import org.springframework.data.repository.CrudRepository;

public interface CaptainRepository extends CrudRepository<Captain,Long>{
}
