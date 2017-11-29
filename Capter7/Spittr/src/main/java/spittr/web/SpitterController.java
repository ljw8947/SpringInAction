package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spittr.Spitter;
import spittr.data.SpitterRepository;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;


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

    //将异常映射为特定的状态码
    @RequestMapping(value="/errorone",method = GET)
    public  String errorone(Model model) throws ErrorOneException{
       throw new ErrorOneException();
    }

    //编写处理异常的方法
    @RequestMapping(value="/errortwo",method = GET)
    public  String errortwo(Model model){
       int a=1/0;
       return "test";
    }

    //编写处理异常的方法
    @ExceptionHandler(ArithmeticException.class)
    public String handleErrorTwo(){
        return "error";
    }

    @RequestMapping(value="/errorthree",method = GET)
    public  String errorThree(Model model) throws   ErrorThreeException{
        throw new ErrorThreeException();
    }

    @RequestMapping(value="/register",method = POST)
    public String processRegistration(
            @RequestPart("profilePicture") MultipartFile profilePicture,
            @Valid Spitter spitter,
            Errors errors, RedirectAttributes model) throws IOException{
        if(errors.hasErrors()){
            return "registerForm";
        }
        spitterRepository.save(spitter);
        //如果有上传文件，则保存到指定位置
        if(!profilePicture.isEmpty()) {
            profilePicture.transferTo(new File(profilePicture.getOriginalFilename()));
        }
        model.addFlashAttribute("spitter",spitter);
        return "redirect:/spitter/"+ spitterRepository.findByUsername("").getUsername();
    }

    @RequestMapping(value="/flash",method = GET)
    public  String showFlash(Model model){
        model.addAttribute(new Spitter());
        return "test";
    }

    //使用flash存储模型数据
    @RequestMapping(value="/flash",method = POST)
    public String processFlash(Spitter spitter,
           RedirectAttributes model) {
        model.addFlashAttribute("spitter",spitter);
        return "redirect:/spitter/test";
    }

    //读取flash中的模型数据
    @RequestMapping(value = "/{username}",method = GET)
    public String showSpitterProfile(
            @PathVariable String username,Model model){
        if(!model.containsAttribute("spitter")) {
            Spitter spitter = spitterRepository.findByUsername(username);
            model.addAttribute(spitter);
        }
        return "profile";
    }
}
