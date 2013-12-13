package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
     static    JFrame frame = new JFrame();
    static JLabel label = new JLabel("შეიყვანეთ სიტყვა");
    static JButton button = new JButton("ok");
    static JTextField filed = new JTextField();
    public static void main(String[] args) {
	   frame=new JFrame("ნიკას პროგრამა");
        button = new JButton("ok");
        filed.setPreferredSize(new Dimension(80,30));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(filed.getText().length() >0){
                    if(filed.getText().substring(filed.getText().length()-5).equals("giorg")){
                        label.setText(filed.getText()+ "s " + "mankana");
                    }
                }
            }
        });
        frame.setLayout(new FlowLayout());
        frame.add(label);
        frame.add(filed);
        frame.add(button);
        frame.setSize(600,400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
