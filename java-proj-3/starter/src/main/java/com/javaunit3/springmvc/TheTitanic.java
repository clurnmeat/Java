package com.javaunit3.springmvc;

import org.springframework.stereotype.Component;

@Component
public class TheTitanic implements Movie{
    public String getTitle(){return "The Titanic";}
    public String getGenre(){return "Romance";}
    public String getMaturityRating(){return "PG-13";}

}
