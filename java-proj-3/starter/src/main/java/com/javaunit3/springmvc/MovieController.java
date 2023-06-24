package com.javaunit3.springmvc;

import com.javaunit3.springmvc.model.MovieEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class MovieController {


    @Autowired
    public SessionFactory sessionFactory;

    @RequestMapping("/")
     public String getIndexPage(){
        return "index";
    }

    @RequestMapping("/bestMovie")
    public String getBestMoviePage(Model model){
        model.addAttribute("BestMovie", BestMovieService.getBestMovie().getTitle());
        return "bestMovie";
    }

    @RequestMapping("/voteForBestMovieForm")
    public String bestMovieForm(){
        return "voteForBestMovie";
    }

    @RequestMapping("/voteForBestMovie")
    public String voteForBestMovie(HttpServletRequest request, Model model){
        String movieTitle = request.getParameter("movieTitle");
        model.addAttribute("BestMovieVote", movieTitle);
        return "voteForBestMovie";
    }



    @RequestMapping("/addMovieForm")
    public String addMovieForm(HttpServletRequest request){
        String movieTitle = request.getParameter("movieTitle");
        String rating = request.getParameter("movieRating");
        String genre = request.getParameter("movieGenre");
        MovieEntity movie = new MovieEntity();
        movie.setTitle(movieTitle);
        movie.setGenre(genre);
        movie.setMaturityRating(rating);
        sessionFactory.getCurrentSession().beginTransaction().begin();
        sessionFactory.getCurrentSession().save(movie);
        sessionFactory.getCurrentSession().beginTransaction().commit();
        return "addMovie";
    }

    @RequestMapping("/addMovie")
    public String addMovie(){
        return "addMovie";
    }


}
