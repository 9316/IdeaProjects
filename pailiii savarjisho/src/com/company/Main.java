package com.company;

        import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.IOException;
        import java.util.Formatter;
        import java.util.Scanner;


public class Main {


            public static void main(String[] args) {

                File paili = new File("C:/Users/nikusha/Desktop/paili.txt");
                    try {
                        Formatter format = new Formatter(paili);
                        format.format(123+ " გამარჯობა იაშა");
                        format.close();

                  Scanner scan = new Scanner(paili);
                        while(scan.hasNext()){
                            System.out.println(scan.nextLine());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                System.out.println(paili.getAbsolutePath());
                System.out.println(  paili.isFile());

}
}






