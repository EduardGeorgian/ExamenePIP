package Model1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TestPrb02 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setTitle("Prb02");
        frame.setVisible(true);
        frame.setLayout(null);

        frame.setLocationRelativeTo(null);

        JTextField textField=new JTextField();
        textField.setEditable(true);
        textField.setBounds(100,50,200,50);



        JButton buton=new JButton("Printeaza");
        buton.setBounds(320,50,100,50);



        Thread thread=new Thread(new Runnable() {

            @Override
            public void run() {
                String text=textField.getText().toString();
                try {
                    RandomAccessFile file=new RandomAccessFile("output.txt","rw");
                    file.setLength(0);
                    for(int i=0;i<10000;i++){
                        file.writeBytes(text+"\n");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        });

        buton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                thread.start();
            }
        });


        frame.add(textField);
        frame.add(buton);
        frame.setVisible(true);
    }
}
