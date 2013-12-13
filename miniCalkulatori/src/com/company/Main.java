package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class Main {
        static JFrame frame = new JFrame("ნიკუშა აპლიკაცია");
        static JTextField field = new JTextField();
        static  JLabel label = new JLabel("შეიყვანეთ სიტყვა");
         static  JLabel label1= new JLabel();
        static  JButton button = new JButton("OK");
    public static void main(String[] args) {
        field.setPreferredSize(new Dimension(70,40));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(field.getText().length()>0){
                    if(field.getText().substring(field.getText().length()-1).equals("a")){
                        label1.setText(field.getText() + "m");
                    }
                    else label1.setText(field.getText());
                }

            }
        });

     frame.setLayout(new FlowLayout());
        frame.add(label);
        frame.add(field);
        frame.add(label1);
        frame.add(button);
        frame.setResizable(false);
        frame.setSize(900, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    }