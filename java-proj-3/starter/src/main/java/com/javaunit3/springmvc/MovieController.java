package com.javaunit3.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MovieController {

    @RequestMapping("/")
     public String getIndexPage(){
        return "index";
    }

    @RequestMapping("/bestMovie")
    public String getBestMoviePage(Model model){
        model.addAttribute("BestMovie", BestMovieService.getBestMovie().getTitle());
        return "bestMovie";
    }
}
