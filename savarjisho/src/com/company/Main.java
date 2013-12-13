package com.company;

public class Main {
         static int number;
    public static void main(String[] args) {
       person per=new person();
      per.name();
        per.lastname();
      per.univesity();
        per.location();
        System.out.println(per.addres());

         number = (int) (23156 *Math.random()); //შე,თხვევითი რიცხვები
        System.out.println(number);

    }
}
