package com.ljw.student.dao;

import com.ljw.student.domain.StudentInfo;

import java.util.List;

/**
 * Created by jwlv on 2017/12/7.
 */
public interface StudentRepository {
    StudentInfo findByID(long id);

    StudentInfo findByName(String name);

    List<StudentInfo> findAll();

    StudentInfo save(StudentInfo studentInfo);
}
