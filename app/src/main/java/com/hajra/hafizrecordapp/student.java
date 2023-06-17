package com.hajra.hafizrecordapp;

public class student
{
    private String name;
    private int age;

    private int class1;
    private boolean completed;
    private boolean missed;

    public student(String name, String rollNo, boolean isEnroll) {
        this.name = name;
        this.age = age;
        this.isEnroll = isEnroll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public boolean isEnroll() {
        return isEnroll;
    }

    public void setEnroll(boolean enroll) {
        isEnroll = enroll;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", rollNo=" + rollNo + ", isEnroll=" + isEnroll + "]";
    }

}