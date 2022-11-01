package guru.springframework.spring5jokesappv2.controllers;

import guru.springframework.spring5jokesappv2.services.JokeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {

    private final JokeService jokeService;

    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/", ""})  // when a request come, it will go to the root of the context that is running the application context
    public String showJoke(Model model) {
        model.addAttribute("joke", jokeService.getJoke()); // add to map sequence "model" key "joke" and String value, this String value will be inserted in index.html by "joke" key by Thymeleaf

        return "index";     // return index.html under "templates" dir to the client
    }
}
