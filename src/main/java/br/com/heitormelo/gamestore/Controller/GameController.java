package br.com.heitormelo.gamestore.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.heitormelo.gamestore.Model.Game;
import br.com.heitormelo.gamestore.Repository.GameRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class GameController {
    
    @Autowired
    GameRepository gr;

    @GetMapping("/list")
    public ModelAndView getListGame() {
       ModelAndView mv = new ModelAndView("list");
    //Todos os meus dados estao sendo armazenados aqui 
       mv.addObject("games", gr.findAll()); 
       return mv;
    }
    @GetMapping("/add")
    public String getAddGame() {
        return "game_add.html";
    }


    @PostMapping("/addgame")
    public String postMethodName(Game game) {
        gr.save(game);

        return "redirect:/list";
    }
    
    
}
