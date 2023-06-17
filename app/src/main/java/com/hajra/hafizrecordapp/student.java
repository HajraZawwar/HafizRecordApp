package com.hajra.hafizrecordapp;

public class student
{
    private String name;
    private int age;

    private int class1;
    private int sabaq;
    private int sabaqi;
    private int manzil;
    private boolean iscompleted;

    public student(String name, int age, int class1, int  sabaq, int sabaqi, int manzil, boolean iscompleted) {
        this.name = name;
        this.age = age;
        this.class1 = class1;
        this.sabaq = sabaq;
        this.sabaqi = sabaqi;
        this.manzil= manzil;
        this.iscompleted = iscompleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setage(int age) {
        this.age= age;
    }

    public int getage() {
        return age;
    }

    public void setsabaq(int sabaq) {
        this.sabaq= sabaq;
    }

    public int getSabaq() {
        return sabaq;
    }


    public void setSabaqi(int sabaqi) {
        this.sabaqi= sabaqi;
    }

    public int getSabaqi() {
        return sabaqi;
    }


    public void setManzil(int manzil) {
        this.manzil= manzil;
    }

    public int getManzil() {
        return manzil;
    }
    public void setClass1(int class1) {
        this.class1 = class1;
    }
    public int getClass1() {
        return class1;
    }
    public boolean isCompleted() {
        return isCompleted();
    }

    public void setcompleted(boolean completed) {
        iscompleted = completed;



  //  @Override
    //public String toString() {
    //    return "Student [name=" + name + ", age=" + age + ", isEnroll=" + isEnroll + "]";
   // }

}