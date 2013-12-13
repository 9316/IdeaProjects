package com.company;

public class Main {

    public static void main(String[] args) {

        int i = 1000000;
        String numbers = String.format(" My number is %,d", i);  //რიცხვებს ვაფორმატებთ , თი
        System.out.println(numbers);

        float f = 24.4545f;
        String number = String.format(" My Number is %.2f" , f);   //დაიბეჭდება . შემდეგ 2 ციფრი
        System.out.println(number);


        String number2 = String.format("My Number2 is %,d  My Number is %.1f", i,f);   //ჩვენ შეგვიძლია ასევე ერთდროულად დავაფორმატოთ int და float ცვლადები
        System.out.println(number2);

    }
}
