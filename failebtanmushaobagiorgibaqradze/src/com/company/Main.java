package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	File paili = new File("C:/Users/nika/Desktop/nika.txt");
        System.out.println(paili.getAbsolutePath()); //ეს გვაძლევს ფაილის სრულ მისამართს
        System.out.println(paili.isDirectory());   //ეს გვეუნება რომ არის თუ არა კონქრეტული ფაილი ფოლდერი
 //============================================================================================================
    File folder = new  File("C:/Users/nika/Desktop/gia folder");
        System.out.println("ეს არის ფოლდერი");
         if(folder.isDirectory()){
              String [] arr = folder.list();  //სტრინგების მასივი arr რომელიც ტოლია folder-ში არსებული ელემენტების
           for(String ni : arr) {   //იტერატურული ციკლი პირველ რიგში ვწერთ String(ტიპს)
            System.out.println(ni);
        }
        }
        else {
             System.out.println("ეს არის ფაილი");
         }


 //=============================================================================================================
        File folder1 = new File("C:/Users/nika/Desktop/nikusha");
        if(!folder1.exists()){   //თუ არ არსებობს ესეთი ფოლდერი
            folder1.mkdir(); //მეიქდირექტორი რომელიც ქმნის ფოლდერს
            System.out.println("ფოლდერი nikusha შეიქმნა");
        }
        else System.out.println("ფოლდერი nikusha არ შექმნილა");

 //=============================================================================================================
        File[] masivi = folder1.listFiles();  //file კლასისი masivi მოიცავს folder1-ში შემავალ ფაილებს

        for(int i=0; i<masivi.length; i++){      //მასივის ზომა
            if(masivi[i].isFile()){       //მასივში არის ფაილ ტიპის
                String name=masivi[i].getName();  //
                System.out.println(name);
               masivi[i].delete();
            }



        }
    }
}
