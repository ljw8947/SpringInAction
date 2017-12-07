package com.ljw.student.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by jwlv on 2017/12/7.
 */
@Configuration
public class JdbcConfig {
    /*@Bean
    public DataSource dataSource(){
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/test");
        ds.setUsername("root");
        ds.setPassword("8947");
        return ds;
    }*/

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSorce){
        return new JdbcTemplate(dataSorce);
    }

    @Bean
    public StudentRepository studentRepository(JdbcTemplate jdbcTemplate){
        return new JdbcStudentRepository(jdbcTemplate);
    }

}
