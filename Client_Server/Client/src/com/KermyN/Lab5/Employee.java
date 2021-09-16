package com.KermyN.Lab5;

import java.io.Serializable;

public class Employee implements Serializable {
    public String Name;
    public int Age;
    public Employee(String nm,int age){
        Name = nm;
        Age = age;
    }
    @Override
    public  String toString(){
        return "Name "+ Name +"\nAge : "+Age;
    }
}
