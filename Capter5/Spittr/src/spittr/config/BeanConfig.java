package spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spittr.data.SpittleRepository;
import spittr.data.SpittleRepositoryImpl;

/**
 * Created by jwlv on 2017/11/2.
 */
//@Configuration
//@ComponentScan
public class BeanConfig {
    @Bean
    public SpittleRepository spittleRepository()
    {
        return new SpittleRepositoryImpl();
    }
}
