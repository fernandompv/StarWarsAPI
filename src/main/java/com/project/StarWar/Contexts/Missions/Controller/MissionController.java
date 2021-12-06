package com.project.StarWar.Contexts.Missions.Controller;

import com.project.StarWar.Contexts.Constants;
import com.project.StarWar.Contexts.Missions.Model.Mission;
import com.project.StarWar.Contexts.Missions.Repository.MissionRepository;
import com.project.StarWar.Contexts.Response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
public class MissionController{

    @Autowired
    private MissionRepository missionRepository;

    @Autowired
    RestTemplate restTemplate;


    @RequestMapping( method = RequestMethod.POST, value = Constants.MISSIONS)
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
