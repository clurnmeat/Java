package com.javaunit3.springmvc;

import com.javaunit3.springmvc.model.MovieEntity;
import com.javaunit3.springmvc.model.VoteEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Controller
public class MovieController {



    private SessionFactory sessionFactory;

    @RequestMapping("/")
     public String getIndexPage(){
        return "index";
    }

    @RequestMapping("/bestMovie")
    public String getBestMoviePage(Model model){
        model.addAttribute("BestMovie", BestMovieService.getBestMovie().getTitle());
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        List<MovieEntity> movieEntities = session.createQuery("from MovieEntity").list();
        movieEntities.sort(Comparator.comparing(MovieEntity -> MovieEntity.getVote().getId()));
        MovieEntity movieWithMostVotes = movieEntities.get(movieEntities.size() - 1);
        List<String> voterNames = new ArrayList<>();

        for (VoteEntity vote: movieWithMostVotes.getVotes())
        {
            voterNames.add(vote.getVoterName());
        }

        String voterNamesList = String.join(",", voterNames);

        model.addAttribute("bestMovie", movieWithMostVotes.getTitle());
        model.addAttribute("bestMovieVoters", voterNamesList);

        session.getTransaction().commit();

        return "bestMovie";
    }

    @RequestMapping("/voteForBestMovieForm")
    public String bestMovieFormPage(Model model){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<MovieEntity> movies = session.createQuery("from MovieEntity").list();
        session.getTransaction().commit();
        model.addAttribute("movies", movies);
        return "voteForBestMovie";
    }

    @RequestMapping("/voteForBestMovie")
    public String voteForBestMovie(HttpServletRequest request, Model model){
        String movieTitle = request.getParameter("movieTitle");
        model.addAttribute("BestMovieVote", movieTitle);
        String movieId = request.getParameter("movieId");
        String voterName = request.getParameter("voterName");
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        MovieEntity movieEntity = (MovieEntity) session.get(MovieEntity.class, Integer.parseInt(movieId));
        VoteEntity newVote = new VoteEntity();
        newVote.setVoterName(voterName);
        movieEntity.addVote(newVote);
        session.update(movieEntity);
        session.getTransaction().commit();
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
