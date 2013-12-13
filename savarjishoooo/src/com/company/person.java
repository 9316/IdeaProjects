package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: nikusha
 * Date: 10/22/13
 * Time: 12:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class person implements interfacee {
       String name="nikusha";
        int age=20;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void dojob() {
        return;//To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void name() {
        return;//To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void printinfo() {
        return;
    }

    @Override
    public String toString() {
       return name + age;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
