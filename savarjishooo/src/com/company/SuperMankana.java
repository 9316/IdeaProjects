package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: nikusha
 * Date: 11/4/13
 * Time: 1:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class SuperMankana extends  Mankana {
    public String model;

    public SuperMankana(String n, int s, String m){
        name=n;
        speed=s;
        model=m;
    }

    public  SuperMankana(){


    }

    @Override
    public String toString() {
       return name+ speed+model;
    }
}
