import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    static  JFrame frm;
    static JTextField txtval;
    static JButton bt1, bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt0,dot,div,multi,div1,add,sub,bteq, clr, mod, del,bt00;
    static double a=0, b=0, result=0,addresult=0;
    static int op=0;


    public static void main(String[] args) {

        frm = new JFrame("Simple Calcultor");
        frm.setBounds(300,200,300,350);
        JLabel val = new JLabel("Value");
        val.setBounds(15,15,50,10);
        txtval = new JTextField();
        txtval.setBounds(60,10,200,30);
        frm.add(val);
        frm.add(txtval);
        frm.setLayout(null);




        //p.setSize(400,200);
        JPanel p = new JPanel();
        p.setBounds(10,60,250,200);
        p.setLayout(new GridLayout(5,4,10,10));

        JButton bt1 = new JButton("1");
        bt2 = new JButton("2");
        bt2.setSize(200,30);
        bt3 = new JButton("3");
        add = new JButton("+");
        bt4 = new JButton("4");
        bt5 = new JButton("5");
        bt6 = new JButton("6");
        sub = new JButton("-");
        bt7 = new JButton("7");
        bt8 = new JButton("8");
        bt9 = new JButton("9");
        multi = new JButton("*");
        bteq = new JButton("=");
        dot = new JButton(".");
        bt0 = new JButton("0");
        div = new JButton("/");
        clr = new JButton("C");
        mod = new JButton("%");
        del = new JButton("D");
        bt00 = new JButton("00");
        // adding button to jframs

        p.add(bt1);
        p.add(bt2);
        p.add(bt3);
        p.add(add);
        p.add(bt4);
        p.add(bt5);
        p.add(bt6);
        p.add(sub);
        p.add(bt7);
        p.add(bt8);
        p.add(bt9);
        p.add(multi);
        p.add(bteq);
        p.add(dot);
        p.add(bt0);
        p.add(div);
        p.add(bt00);
        p.add(clr);
        p.add(del);
        p.add(mod);
//frm.add(p1);

        frm.add(p);
        // setting the grid layout

        //p.setLayout(new GridLayout(4,4,10,10));
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setResizable(false);

        frm.setVisible(true);

        ActionListener clickeq = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==bt1)
                {
                    txtval.setText(txtval.getText().concat("1"));
                }
                if(e.getSource()==bt2)
                {
                    txtval.setText(txtval.getText().concat("2"));
                }
                if(e.getSource()==bt3)
                {
                    txtval.setText(txtval.getText().concat("3"));
                }
                if(e.getSource()==bt4)
                {
                    txtval.setText(txtval.getText().concat("4"));
                }
                if(e.getSource()==bt5)
                {
                    txtval.setText(txtval.getText().concat("5"));
                }
                if(e.getSource()==bt6)
                {
                    txtval.setText(txtval.getText().concat("6"));
                }
                if(e.getSource()==bt7)
                {
                    txtval.setText(txtval.getText().concat("7"));
                }
                if(e.getSource()==bt8)
                {
                    txtval.setText(txtval.getText().concat("8"));
                }
                if(e.getSource()==bt9)
                {
                    txtval.setText(txtval.getText().concat("9"));
                }
                if(e.getSource()==bt0)
                {
                    txtval.setText(txtval.getText().concat("0"));
                }
                if(e.getSource()==bt00)
                {
                    txtval.setText(txtval.getText().concat("00"));
                }

                if(e.getSource()==clr)
                {
                    txtval.setText("");
                }
                if(e.getSource()==dot)
                {
                    txtval.setText(txtval.getText().concat("."));
                }
                if(e.getSource()==add)
                {

                    a = Double.parseDouble(txtval.getText());

                    op=1;
                    txtval.setText("");
                }
                if(e.getSource()==multi)
                {
                    a=Double.parseDouble(txtval.getText());
                    op=2;
                    txtval.setText("");
                }
                if(e.getSource()==div)
                {
                    a=Double.parseDouble(txtval.getText());
                    op=3;
                    txtval.setText("");
                }
                if(e.getSource()==sub)
                {
                    a=Double.parseDouble(txtval.getText());
                    op=4;
                    txtval.setText("");

                }
                if(e.getSource()==mod)
                {
                    a=Double.parseDouble(txtval.getText());
                    op=5;
                    txtval.setText("");
                }
                if(e.getSource()==del)
                {
                    String s = txtval.getText();

                    for(int i=0;i<s.length();i++)
                    {
                        txtval.setText(txtval.getText()+s.charAt(i));
                    }
                    txtval.setText("");
                }

                if(e.getSource()==bteq)
                {
                    b=Double.parseDouble(txtval.getText());
                    switch (op)
                    {
                        case 1: result=a+b;
                            break;
                        case 2:result =a*b;
                            break;
                        case 3: result =a/b;
                            break;
                        case 4: result = a-b;
                            break;
                        case 5: result=a%b;
                    }
                    txtval.setText(""+result);
                }

            }
        };
        bt1.addActionListener(clickeq);
        bt2.addActionListener(clickeq);
        bt3.addActionListener(clickeq);
        bt4.addActionListener(clickeq);
        bt5.addActionListener(clickeq);
        bt6.addActionListener(clickeq);
        bt7.addActionListener(clickeq);
        bt8.addActionListener(clickeq);
        bt9.addActionListener(clickeq);
        bt0.addActionListener(clickeq);
        dot.addActionListener(clickeq);
        add.addActionListener(clickeq);
        multi.addActionListener(clickeq);
        div.addActionListener(clickeq);
        sub.addActionListener(clickeq);
        bteq.addActionListener(clickeq);
        bt00.addActionListener(clickeq);
        clr.addActionListener(clickeq);
        mod.addActionListener(clickeq);
        del.addActionListener(clickeq);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
