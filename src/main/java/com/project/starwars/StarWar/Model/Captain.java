package com.project.starwars.StarWar.Model;

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
