package com.company;

import java.util.Calendar;

public class Main {

    public static void main(String[] args) {

        Calendar c = Calendar.getInstance(); //calendar -არის აბსტრაქტული კლასი getInstance გვიბრუნებს ობიექტზე მიმთითებელს
        c.set(2009 ,3,7, 15,45); //წელი თვე რიცხვი საათი და წუთი
        System.out.println(c.getTime());

        c.set(c.DATE, 20);  // რიცხვის შეცვლა გახდა 20 აპრილი
        System.out.println(c.getTime());

       c.add(c.DATE, 30); //ამ შემთხვევაში 20 რიცხვს მიემატა 30 და გახდება მაისის 20 რიცხვი
        System.out.println(c.getTime());

        long i = c.getTimeInMillis();
        i+= 1000*60*60;
        System.out.println(i);
    }
}
