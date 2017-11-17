package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import spittr.Spitter;
import spittr.data.SpitterRepository;

import javax.validation.Valid;


/**
 * Created by jwlv on 2017/11/7.
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    @Autowired
    public  SpitterController(SpitterRepository spitterRepository){
        this.spitterRepository=spitterRepository;
    }

    public  SpitterController(){

    }


    @RequestMapping(value="/register",method = GET)
    public  String showRegistrationForm(Model model){
        model.addAttribute(new Spitter());
        return "test";
    }

    @RequestMapping(value="/register",method = POST)
    public String processRegistration(
            @Valid Spitter spitter,
            Errors errors){
        if(errors.hasErrors()){
            return "registerForm";
        }
        spitterRepository.save(spitter);
        //return "redirect:/spitter/"+ spitter.getUsername();
        return "redirect:/spitter/"+ spitterRepository.findByUsername("").getUsername();
    }


    @RequestMapping(value = "/{username}",method = GET)
    public String showSpitterProfile(
            @PathVariable String username,Model model){
        Spitter spitter=spitterRepository.findByUsername(username);
        model.addAttribute(spitter);
        return "profile";
    }
}
