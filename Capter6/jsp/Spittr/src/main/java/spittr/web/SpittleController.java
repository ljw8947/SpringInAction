package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spittr.Spittle;
import spittr.data.SpittleRepository;

import java.util.List;
import java.util.Map;

/**
 * Created by jwlv on 2017/11/2.
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private SpittleRepository spittleRepository;
    private static final String MAX_LONG_AS_STRING=Long.toString(Long.MAX_VALUE);

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    //调用addAttribute()方法并且不指定key的时候，key会根据值的对象类型判断,
    //此处因为是一个List<Spittle>,故键将会推断为spittleList
    /*@RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model){
        model.addAttribute(
                spittleRepository.findSpittles(Long.MAX_VALUE,20));
        return "spittles";
    }*/

    //显示指定key
    /*@RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model){
        model.addAttribute("spittleList",
                spittleRepository.findSpittles(Long.MAX_VALUE,20));
        return "spittles";
    }*/

    //使用Map作为入参
    /*@RequestMapping(method = RequestMethod.GET)
    public String spittles(Map model) {
        model.put("spittleList",
                spittleRepository.findSpittles(Long.MAX_VALUE,20));
        return "spittles";
    }*/

    //当处理器方法返回对象或集合时，这个值会放到模型中，模型的key会根据其类型推断得出。此处为spittleList
    //逻辑视图的名称将会根据请求路径推断得出。因为这个方法处理针对“/spittles”的GET请求，
    //因此视图的名称将会是spittles（去掉开头的斜线）
    /*@RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(Model model) {
        return spittleRepository.findSpittles(Long.MAX_VALUE,20);
    }*/

    //通过查询参数传入
    @RequestMapping(method=RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value="max",defaultValue = "9999") long max,
            @RequestParam(value="count",defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max,count);
    }

    //通过路径参数传入
    @RequestMapping(value="/{spittleId}",method=RequestMethod.GET)
    public String findOne(
            @PathVariable("spittleId") long spittleId,
            Model model){
        model.addAttribute("spittle",spittleRepository.findOne(spittleId));
        return "spittle";
    }

}
