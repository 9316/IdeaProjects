package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: nikusha
 * Date: 10/17/13
 * Ame: 9:52 PM
 * To change this template use File | Settings | File Templates.
 */public class person extends student{
    @Override
    public void location() {
        System.out.println("Tbilisi");
    }

    @Override
    public void name() {
        System.out.println("giorgi");
    }

    @Override
    public void lastname() {
        System.out.println("arveladze");
    }

    @Override
    public void univesity() {
        System.out.println("TSu"); //To change body of implemented methods use File | Settings | File Templates.
    }


}
