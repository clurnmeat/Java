package com.javaunit3.springmvc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
@SpringBootApplication
public class MovieApp {
    public static void main(String[]args){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MovieApp.class);
        BestMovieService bestMovieService = applicationContext.getBean("bestMovieService", BestMovieService.class);
        Movie bestMovie = bestMovieService.getBestMovie();
        System.out.println(bestMovie.getTitle());
        System.out.println(bestMovie.getMaturityRating());
        System.out.println(bestMovie.getGenre());

    }
}
