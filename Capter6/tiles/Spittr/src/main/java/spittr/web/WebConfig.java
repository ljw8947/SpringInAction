package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * Created by jwlv on 2017/10/27.
 */
@Configuration
@EnableWebMvc
@ComponentScan("spittr.web")
public class WebConfig extends WebMvcConfigurerAdapter{

    @Bean
    public ViewResolver viewResolver(){
        TilesViewResolver resolver =new TilesViewResolver();
        return resolver;
    }

    @Bean
    public TilesConfigurer tilesConfigurer(){
        TilesConfigurer tiles=new TilesConfigurer();
        tiles.setDefinitions(new String[]{
                "/WEB-INF/**/tiles.xml"
        });
        tiles.setCheckRefresh(true);
        return tiles;
    }

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // TODO Auto-generated method stub
        super.addResourceHandlers(registry);
    }



    @Bean
    public MessageSource messageSource(){
        //使用ResourceBundleMessageSource加载properties
        ResourceBundleMessageSource messageSource=
                new ResourceBundleMessageSource();
        messageSource.setBasename("messages");

        //使用ReloadableResourceBundleMessageSource加载properties
        /*ReloadableResourceBundleMessageSource messageSource=
                new ReloadableResourceBundleMessageSource();
        //messageSource.setBasename("classpath:messages");
        //messageSource.setBasename("file:G:/github/resource/messages");
        messageSource.setBasename("WEB-INF/messages");
        messageSource.setCacheSeconds(60);*/

        return  messageSource;
    }
}
