package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.model.entity.Song;
import ra.model.service.ISongService;

import javax.validation.Valid;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;
    @GetMapping("/")
    public ModelAndView findAll(){
        return new ModelAndView("/list","songs",songService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView addSong(){
        return new ModelAndView("/create","song",new Song());
    }

    @PostMapping("/create")
    public String createSong(@Valid  @ModelAttribute Song song, BindingResult bindingResult ){
        if(bindingResult.hasErrors()){
            return "/create";
        }
        songService.save(song);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editSong(@PathVariable Long id){
        return new ModelAndView("/edit","song",songService.findById(id));
    }
    @PostMapping("/edit")
    public String updateSong(@Valid @ModelAttribute Song song,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/edit";
        }
        songService.save(song);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable Long id){
        songService.delete(id);
        return "redirect:/";
    }

}
