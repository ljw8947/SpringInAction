package com.ljw.student.domain;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by jwlv on 2017/12/6.
 */
@Component
public class StudentInfo {

    private static long idCount;
    private long studentID;
    private String name;
    private Date birthday;
    private short gender;
    private Date createTime;
    private Date updateTime;

    public long getStudentID() {
        return studentID;
    }

    public StudentInfo setStudentID(long studentID) {
        this.studentID = studentID;
        return this;
    }

    public String getName() {
        return name;
    }

    public StudentInfo setName(String name) {
        this.name = name;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public StudentInfo setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public short getGender() {
        return gender;
    }

    public StudentInfo setGender(short gender) {
        this.gender = gender;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public StudentInfo setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public StudentInfo setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public StudentInfo(){

        //studentID= StudentInfo.idCount++;
        name=Long.toString(StudentInfo.idCount);
        gender=(short)(StudentInfo.idCount%2);
        birthday=new Date();
    }

    public StudentInfo(long studentID, String name, short gender, Date birthday, Date createTime, Date updateTime) {
        this.studentID = studentID;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
