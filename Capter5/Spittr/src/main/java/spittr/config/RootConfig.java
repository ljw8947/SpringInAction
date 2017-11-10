package spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;
import java.io.File;

/**
 * Created by jwlv on 2017/10/27.
 */
@Configuration
@ComponentScan(basePackages ={"spittr"},
    excludeFilters ={
        @ComponentScan.Filter(type= FilterType.ANNOTATION,value= EnableWebMvc.class)
    } )
public class RootConfig {
}
