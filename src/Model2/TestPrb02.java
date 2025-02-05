package Model2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TestPrb02 {
    public static void main(String[] args) throws FileNotFoundException {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Examen PIP");


        frame.setLayout(null);

        JTextArea leftTextArea=new JTextArea();
        leftTextArea.setEditable(true);
        leftTextArea.setBounds(400,200,100,200);
        frame.add(leftTextArea);

        JTextArea rightTextArea=new JTextArea();
        rightTextArea.setEditable(true);
        rightTextArea.setBounds(520,200,100,200);
        frame.add(rightTextArea);

        JLabel leftLabel=new JLabel("Left JTextArea");
        leftLabel.setBounds(400,150,100,50);
        frame.add(leftLabel);

        JLabel rightLabel=new JLabel("Right JTextArea");
        rightLabel.setBounds(520,150,100,50);
        frame.add(rightLabel);

        JCheckBox checkBox=new JCheckBox();
        checkBox.setBounds(0,400,100,100);
        checkBox.setText("Checkbox");
        checkBox.setSelected(false);
        frame.add(checkBox);

        JMenuBar menuBar=new JMenuBar();
        menuBar.setBounds(0,0,100,300);

        JMenu menu=new JMenu("Options");

        JMenuItem loadItem = new JMenuItem("Load");
        loadItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(loadItem.getText());
            }
        });
        JMenuItem processItem = new JMenuItem("Process");

        JMenuItem checkItem = new JMenuItem("(un)Check");
        checkItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkBox.isSelected()){
                    checkBox.setSelected(false);
                }
                else{
                    checkBox.setSelected(true);
                }
            }
        });
        JMenuItem saveItem = new JMenuItem("Save");


        menu.add(loadItem);
        menu.add(processItem);
        menu.add(checkItem);
        menu.add(saveItem);

        menuBar.add(menu);

        frame.setJMenuBar(menuBar);

        //pentru meniu trebuie mai intai un menu bar, apoi un meniu apoi elemente de meniu





        StringBuilder rez=new StringBuilder();
        processItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String [] linii=new String[100];
                try {
                    for (int i = 0; i < leftTextArea.getLineCount(); i++) {
                        int start = leftTextArea.getLineStartOffset(i);
                        int end = leftTextArea.getLineEndOffset(i);
                        linii[i] = leftTextArea.getText(start, end - start).trim(); // Elimină spațiile goale
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                for(String s:linii){
                    System.out.println(s);
                }
                System.out.println(processItem.getText());

                //eliminam extensiile de aici, cu last index of "."
                for(int i=0;i<linii.length;i++){
                    if(linii[i]!=null) {
                        int dotIndex = linii[i].lastIndexOf(".");
                        if (dotIndex != -1) {
                            linii[i] = linii[i].substring(0, dotIndex);
                        }
                        rez.append(linii[i]).append("\n");
                    }
                }
                rightTextArea.setText(rez.toString());
            }

        });


        RandomAccessFile file =new RandomAccessFile("output.txt","rw");
        saveItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(saveItem.getText());
                try {
                    file.setLength(0);
                    file.writeBytes(rez.toString());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });








        frame.setVisible(true);
    }
}
