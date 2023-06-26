package com.javaunit3.springmvc.model;

import javax.persistence.*;

@Entity
@Table(name = "votes")
public class VoteEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "voter_name")
    private String voterName;

    public Integer getId() {
        return id;
    }

    public String getVoterName() {
        return voterName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }
}
