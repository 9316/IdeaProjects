package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Main {
   static JLabel label4 = new JLabel("სხვაობა");
   static JLabel label5 = new JLabel("ნამრავლი");
   static JLabel label6 = new JLabel("ჯამი");

    public static void main(String[] args) {

         JFrame frame = new JFrame("კალკულატორი");  //მთავარი ფანჯარა
         JLabel label1 = new JLabel("შეიყვანეთ რიცხვი 1");    //ლეიბელი
       final JTextField filed = new JTextField();          //ლაინედითი
        filed.setPreferredSize(new Dimension(40,20));     //ლაინეთიდის ზომა
        JLabel label2 = new JLabel("შეიყვანეთ რიცხვი 2"); // ლეიბელი2
         final JLabel label3 = new JLabel();                 //ლეიბელი3
        final JTextField filed2 = new JTextField();            //ლაინედითი2
        filed2.setPreferredSize(new Dimension(40,20));
        JButton button =new JButton("ok");

        button.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {  //ინტერფრეისი გადასატვირთი მეთოდი ActionListeneri
              double a= Double.parseDouble(filed.getText()); //get text არის სტრინგი და გადაგვყავს დობლში
              double b= Double.parseDouble(filed2.getText());
                 double ans = a+b;
                 double ans2 = a-b;
                 double ans3= a*b;
                 double ans4 = a/b;

                 label3.setText(Double.toString(ans)); //ლეიბელ3 ზე ტექსტის დაყენება
                 label4.setText(Double.toString(ans2));
                 label5.setText(Double.toString(ans3));
                 label6.setText(Double.toString(ans4));


            }
           }
         );
       // frame.setLayout(new FlowLayout());     //მარტივი ლეიაუთი
        frame.setLayout(new GridLayout(7,2));
        frame.add(label1);            //frame მთავარ ფანჯარაზე ლეიბელ1 დამატება
        frame.add(filed);
        frame.add(label2);
        frame.add(filed2);


        frame.add(label3);
        frame.add(label4);
        frame.add(label5);
        frame.add(label6);



        frame.setResizable(false);     // უნდა იყოს თუ არა ფანჯარა მზარდი
        frame.add(button);
        GridLayout grid = new GridLayout(2,2);
        JPanel panel2 = new JPanel();
        panel2.setLayout(grid);
        frame.add(panel2);
        panel2.add(new JTextField());
        panel2.add(new JTextArea());
        ActionListener k = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               JOptionPane.showConfirmDialog(null,"Hi");
            }
        };
        JButton b = new JButton("Click");
        b.addActionListener(k);
        panel2.add(b);
        panel2.add(new JLabel("Hello"));



        frame.setSize(500,300);         //მთავარი ფანჯარის ზომა
        frame.setLocationRelativeTo(null);   // აპლიკაციის ცენტრში მოთავსება
        frame.setVisible(true);               //  მთავარი ფანჯარის გამოჩენა
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //გათიშვის ბრძანება

    }
}

