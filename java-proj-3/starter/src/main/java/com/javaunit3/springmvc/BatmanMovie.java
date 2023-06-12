package com.javaunit3.springmvc;

import org.springframework.stereotype.Component;

@Component
public class BatmanMovie implements Movie{
    public String getTitle() {
        return "Batman: The Dark Knight";
    }

    public String getGenre(){
        return "Action";
    }

    public String getMaturityRating(){
        return "PG-13";
    }



}
