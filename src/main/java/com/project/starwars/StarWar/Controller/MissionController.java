package com.project.starwars.StarWar.Controller;

import com.project.starwars.StarWar.Model.Mission;
import com.project.starwars.StarWar.Repository.MissionRepository;
import com.project.starwars.StarWar.Response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Executable;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping
public class MissionController{

    private final String MISSIONS = "/missions";

    @Autowired
    private MissionRepository missionRepository;


    @RequestMapping( method = RequestMethod.POST, value = MISSIONS)
    public ResponseEntity<GenericResponse> getDailyMarketAlgorithms(@RequestBody Mission mission){
        String result = attemptedSavePetition(mission);
        GenericResponse response = new GenericResponse(GenericResponse.SuccessMessage, null);;

        if(!result.equals("OK"))
            response = new GenericResponse(GenericResponse.SuccessMessage, new Exception(result));

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    private String attemptedSavePetition(Mission mission){
        try {
            missionRepository.save(mission);
        }catch (Exception e){
            return e.getMessage();
        }

        return "OK";
    }
}
