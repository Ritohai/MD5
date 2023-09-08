package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.model.User;
import ra.service.IUserService;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping(value = {"/", "/user"})
    public ModelAndView listUser(@PageableDefault(sort = "firstName",size = 3) Pageable pageable){
        Page<User> UserPage = userService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("pageuser",UserPage);
        return modelAndView;
    }
    @GetMapping("/create/user")
    public ModelAndView showFormCreateUser(){
        ModelAndView modelAndView = new ModelAndView("/add");
        modelAndView.addObject("createUserForm",new User());
        return modelAndView;
    }
    @PostMapping("/create/user")
    public String createUser(@Validated @ModelAttribute("createUserForm") User User, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "/add";
        }
        userService.save(User);
        return "redirect:/user";
    }
    @GetMapping("/search")
    public ModelAndView searchUser(@RequestParam("search") String search, Pageable pageable){
        Page<User> UserPage;
        if(!search.trim().equals("")){
            UserPage = userService.findByFirstName(search,pageable);
        } else {
            UserPage = userService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("",UserPage);
        return modelAndView;
    }
}

