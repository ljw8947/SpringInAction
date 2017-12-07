package com.ljw.student.dao;

import com.ljw.student.domain.StudentInfo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jwlv on 2017/12/7.
 */
public class JdbcStudentRepository  implements StudentRepository{

    private JdbcTemplate jdbcTemplate;

    public JdbcStudentRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public StudentInfo findByID(long id) {
        return jdbcTemplate.queryForObject(
                SELECT_STUDENT+" where studentid=? ",new StudentRowMapper(),id);
    }

    public StudentInfo findByName(String name) {
        return jdbcTemplate.queryForObject(
                SELECT_STUDENT+" where name=? ",new StudentRowMapper(),name);
    }

    public List<StudentInfo> findAll() {
        return jdbcTemplate.query(SELECT_STUDENT,new StudentRowMapper());
    }

    public StudentInfo save(StudentInfo studentInfo) {
        long id=this.insertStudentAndReturnID(studentInfo);
        studentInfo.setStudentID(id);
        return studentInfo;
    }

    private static final class StudentRowMapper implements RowMapper<StudentInfo>{

        public StudentInfo mapRow(ResultSet resultSet, int i) throws SQLException {
            StudentInfo studentInfo =new StudentInfo(
                    resultSet.getLong("studentID"),
                    resultSet.getString("name"),
                    resultSet.getShort("gender"),
                    resultSet.getDate("birthday"),
                    resultSet.getDate("createtime"),
                    resultSet.getDate("updatetime")
            );
            return studentInfo;


        }
    }

    private long insertStudentAndReturnID(StudentInfo studentInfo){
        SimpleJdbcInsert jdbcInsert=new SimpleJdbcInsert(jdbcTemplate).withTableName("studentinfo");
        jdbcInsert.setGeneratedKeyName("studentID");
        Map<String,Object> args=new HashMap<String, Object>();
        args.put("name", studentInfo.getName());
        args.put("gender", studentInfo.getGender());
        args.put("birthday", studentInfo.getBirthday());
        args.put("createTime", new Date());
        args.put("updateTime", new Date());
        long id=jdbcInsert.executeAndReturnKey(args).longValue();
        return id;
    }


    private static final String SELECT_STUDENT="SELECT StudentID,`Name`,Birthday,Gender,CreateTime,UpdateTime FROM studentinfo";


}
