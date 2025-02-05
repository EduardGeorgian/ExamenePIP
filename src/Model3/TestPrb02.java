package Model3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.RandomAccessFile;

public class TestPrb02 {
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        frame.setTitle("Examen PIP");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JTextArea leftArea=new JTextArea();
        leftArea.setEditable(true);
        leftArea.setBounds(300,100,200,300);
        frame.add(leftArea);

        JLabel leftLabel=new JLabel("Left JTextArea");
        leftLabel.setBounds(300,50,200,50);
        frame.add(leftLabel);

        JTextArea rightArea=new JTextArea();
        rightArea.setEditable(true);
        rightArea.setBounds(510,100,200,300);
        rightArea.setVisible(true);
        frame.add(rightArea);


        JLabel rightLabel=new JLabel("Right JTextArea");
        rightLabel.setBounds(510,50,200,50);
        frame.add(rightLabel);


        JCheckBox checkBox = new JCheckBox();
        checkBox.setBounds(0,0,100,30);
        checkBox.setSelected(false);
        checkBox.setText("Checkbox");
        frame.add(checkBox);


        JButton loadButton = new JButton("Load");
        loadButton.setBounds(0,100,100,50);
        frame.add(loadButton);


        JButton processButton=new JButton("Process");
        processButton.setBounds(0,200,100,50);
        frame.add(processButton);

        JButton unHideButton = new JButton("(un)Hide");
        unHideButton.setBounds(0,300,100,50);
        frame.add(unHideButton);

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(0,400,100,50);
        frame.add(saveButton);








        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(saveButton.getText());
            }
        });

        unHideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rightArea.isVisible()==true)
                    rightArea.setVisible(false);
                else
                    rightArea.setVisible(true);
            }
        });


        StringBuilder stringBuilder=new StringBuilder();
        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(processButton.getText());
                String text=leftArea.getText();
                String[] words=text.split("\\r?\\n");

                for(int i=1;i<words.length;i+=2){
                    stringBuilder.append(words[i]).append("\n");
                }
                rightArea.setText(stringBuilder.toString());
            }
        });



        //folosim un string reprezentand o linie, apoi while cu metoda readLine() si construim un String cu
        //StringBuilder
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(loadButton.getText());
                try{
                    RandomAccessFile file=new RandomAccessFile("/home/eduard/IdeaProjects/ExamenePIP/src/Model3/input.txt","r");
                    StringBuilder stringBuilder=new StringBuilder();
                    String linie;

                    while((linie=file.readLine())!=null){
                        stringBuilder.append(linie).append("\n");
                    }
                    file.close();
                    leftArea.setText(stringBuilder.toString());
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });




        frame.setVisible(true);
    }
}
