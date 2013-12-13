package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
        static JFrame frame = new JFrame("კალკულატორი");
   static double a;
   static double b;
    static char action;
        static JButton button = new JButton("0");
    static JButton button1 = new JButton("1");
    static JButton button2 = new JButton("2");
    static JButton button3 = new JButton("3");
    static JButton button4 = new JButton("4");
    static JButton button5= new JButton("5");
    static JButton button6 = new JButton("6");
    static JButton button7= new JButton("7");
    static JButton button8= new JButton("8");
    static JButton button9= new JButton("9");
    static JButton button10= new JButton("+");
    static JButton button11= new JButton("-");
    static JButton button12= new JButton("*");
    static JButton button13= new JButton("/");
    static JButton button14= new JButton("=");
    static JButton button15= new JButton("c");
   static  JTextField field = new JTextField();
    public static void main(String[] args) {

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(field.getText()+ "0");
            }

        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(field.getText()+ "1");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(field.getText()+ "2");
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(field.getText()+ "3");
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 field.setText(field.getText()+ "4");
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(field.getText()+ "5");
            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(field.getText()+"6");
            }
        });

        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(field.getText()+ "7");
            }
        });
          button8.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  field.setText(field.getText()+ "8");
              }
          });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(field.getText()+ "9");
            }
        });
        button10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = Double.parseDouble(field.getText());
                field.setText(field.getText()+ "+");

                action='+';

            }
        });


        button11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = Double.parseDouble(field.getText());
                field.setText(field.getText()+ "-");
                action='-';
            }
        });
        button12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = Double.parseDouble(field.getText());
                field.setText(field.getText()+"*");
                action='*';
            }
        });

        button13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = Double.parseDouble(field.getText());
                field.setText(field.getText()+ "/");
                action='/';
            }
        });
        button15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               field.setText("");


            }
        });
        final String plus;
        plus = "+";
        button14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hi");
                if (action == '+') {
                    System.out.println("Plus");
                    String[] numbers = field.getText().split(plus);
                    b = Double.parseDouble(numbers[1]);
                    double sum = a + b;
                    field.setText(Double.toString(sum));
                }
                if (action == '-') {
                    System.out.println("Minus");
                    String[] numbers = field.getText().split("-");
                    b = Double.parseDouble(numbers[1]);
                    field.setText(Double.toString(a - b));
                }

                if (action == '*') {
                    System.out.println("multiply");
                    String[] numbers = field.getText().split("*");
                    b = Double.parseDouble(numbers[1]);
                    field.setText(Double.toString(a * b));

                }
                if (action == '/') {
                    System.out.println("divide");
                    String[] numbers = field.getText().split("/");
                    b = Double.parseDouble(numbers[1]);
                    field.setText(Double.toString(a / b));
                }

            }
        });
        frame.setLayout(new GridLayout(2,1));
          JPanel mainPanel = new JPanel(new GridLayout(1,1));
        mainPanel.setSize(40, 40);
        mainPanel.setMaximumSize(new Dimension(40,100));

        JPanel panel = new JPanel(new GridLayout(4,4));
        mainPanel.add(field);
        frame.add(mainPanel);
        panel.add(button);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);

        panel.add(button10);
        panel.add(button11);
        panel.add(button12);
        panel.add(button13);
        panel.add(button14);
        panel.add(button15);

        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
