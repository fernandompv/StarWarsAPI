package com.project.StarWar.Contexts.Missions.Model;

import com.project.StarWar.Contexts.Missions.Model.Mission;

import javax.persistence.*;

@Entity
@Table(name = "Captain")
public class Captain{

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "mission_id")
    private Mission mission;

    public Captain( ) {
        //El framework requiere un constructor sin parametros pero no lo considero una buen apractica por tanto no se debe usar
    }

    public Captain(String name, Mission mission) {
        this.name = name;
        this.mission = mission;
    }

    public void validateIfExist(){

    }

    public String getName( ) {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mission getMission( ) {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }
}
