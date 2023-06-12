package com.javaunit3.springmvc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BestMovieService {


    private Movie movie = new SetMovie();

    @Qualifier
    private Movie movie1 = new TheTitanic();


    public Movie getBestMovie(){
        return movie1;
    }

//    public Movie getBestMovie(){
//        return movie;
//    }

//    @Autowired
//    public Movie setMovie(Movie movie){
//         return movie;
//    }
    public class SetMovie extends BatmanMovie{
        public Movie SetMovie(Movie movie){
            return movie;
        }
}

}
