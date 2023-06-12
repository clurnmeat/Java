package com.javaunit3.springmvc;

import org.springframework.stereotype.Component;

@Component
public interface Movie {

   public String getTitle();
   public String getMaturityRating();
   public String getGenre();



}