package com.project.StarWar.Controller;

import com.project.StarWar.Constants;
import com.project.StarWar.DTO.CastMissionDtoToMission;
import com.project.StarWar.DTO.MissionDTO;
import com.project.StarWar.Model.Mission;
import com.project.StarWar.Repository.MissionRepository;
import com.project.StarWar.Response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MissionController{

    @Autowired
    private MissionRepository missionRepository;


    @RequestMapping( method = RequestMethod.POST, value = Constants.MISSIONS)
    public ResponseEntity<GenericResponse> getDailyMarketAlgorithms(@RequestBody MissionDTO dtoMission){
        CastMissionDtoToMission cating = new CastMissionDtoToMission();
        String result = attemptedSavePetition(cating.cast(dtoMission));
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
