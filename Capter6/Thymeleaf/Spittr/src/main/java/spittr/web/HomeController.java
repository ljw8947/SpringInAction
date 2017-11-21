package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by jwlv on 2017/10/27.
 */
@Controller
@RequestMapping({"/","/home","/testhome"})
public class HomeController {
    @RequestMapping(method=GET)
    public  String home(){
        return "home";
    }

    @RequestMapping(value="/homepage", method=GET)
    public  String home2(){
        return "home";
    }

}
