package com.project.starwars.StarWar.Model;

import javax.persistence.*;

@Entity
@Table(name = "Planet")
public class Planet{

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn (name = "mission_id")
    private Mission mission;


    public Mission getMission( ) {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }
}
