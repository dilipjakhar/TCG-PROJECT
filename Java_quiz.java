import javax.swing.*;
import java.awt.*;

class Javaquiz1{
    public void quiz() {
        JFrame frm = new JFrame("Java Quiz");
        frm.setBounds(100, 100, 600, 600);
        frm.setLayout(null);



        JLabel qy = new JLabel("Java Questions");
        qy.setBounds(150,10,200,100);
        qy.setForeground(Color.BLUE);
        qy.setFont(new Font("Verdana",Font.PLAIN,20));
        frm.add(qy);

        JLabel qz = new JLabel("1. What are different between c and java ?");
        qz.setBounds(30,50,400,100);
        qz.setForeground(Color.BLACK);
        qz.setFont(new Font("Verdana",Font.PLAIN,14));
        frm.add(qz);
        JPanel p= new JPanel();
        p.setBounds(30,70,100,100);
        p.setLayout(new GridLayout(4,2,10,10));
        frm.add(p);
        JRadioButton ans1=new JRadioButton("java highlevel");
        ans1.setBounds(30,110,120,80);


        JRadioButton ans2=new JRadioButton("c midlevel");
        ans2.setBounds(240,110,100,80);


        JRadioButton ans3=new JRadioButton("both are same");
        ans3.setBounds(30,160,120,80);


        JRadioButton ans4=new JRadioButton("none");
        ans4.setBounds(240,160,100,80);

        ButtonGroup group =new ButtonGroup();
        group.add(ans1);
        group.add(ans2);
        group.add(ans3);
        group.add(ans4);

        frm.add(ans1);
        frm.add(ans2);
        frm.add(ans3);
        frm.add(ans4);

        JButton bt=new JButton("Next");
        bt.setBounds(140,250,100,50);
        frm.add(bt);

        frm.setVisible(true);
    }
    }

public class Java_quiz {
    public static void main(String[] args) {
     Javaquize1 obj=new Javaquize1();
     obj.quiz();
    }
}
