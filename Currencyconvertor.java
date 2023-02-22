import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class Corrency_conv_pro{
    JComboBox c1,c2;
    public void correncyconvert()
    {


        String[] currency={"SELECT YOUR CHOICE","US Dollar","Indian Rupee","British Pound","Euro","Emirati Driham","Chinese Yuan"};
        c1=new JComboBox(currency);
        c1.setSelectedIndex(0);
        c2=new JComboBox(currency);
        c2.setSelectedIndex(0);



        JFrame frm1 = new JFrame("Corrency Converter ");
        frm1.setBounds(80,50,600,600);
        frm1.setLayout(null);
        JLabel title1 = new JLabel("Currency Converter");
        title1.setBounds(150,50,300,30);
        title1.setFont(new Font("Arial", Font.BOLD, 24));
        title1.setForeground(Color.DARK_GRAY);
        title1.setBackground(Color.lightGray);
        frm1.add(title1);

        JLabel title2 = new JLabel("Enter INR Amount :  ");
        title2.setBounds(30,120,180,30);
        title2.setFont(new Font("Arial", Font.BOLD, 16));
        title2.setForeground(Color.DARK_GRAY);
        title2.setBackground(Color.lightGray);
        frm1.add(title2);

        JTextField amount = new JTextField();
        amount.setBounds(220,120,230,30);
        amount.setFont(new Font("Arial", Font.BOLD, 16));
        amount.setForeground(Color.DARK_GRAY);
        amount.setBackground(Color.lightGray);
        frm1.add(amount);


        JLabel title3 = new JLabel("Convert To :  ");
        title3.setBounds(30,170,180,30);
        title3.setFont(new Font("Arial", Font.BOLD, 16));
        title3.setForeground(Color.DARK_GRAY);
        title3.setBackground(Color.lightGray);
        frm1.add(title3);

        c1.setBounds(220,170,230,30);
        c1.setForeground(Color.DARK_GRAY);
        c1.setBackground(Color.lightGray);
        frm1.add(c1);


        JLabel title4 = new JLabel("Converted :  ");
        title4.setBounds(30,220,180,30);
        title4.setFont(new Font("Arial", Font.BOLD, 16));
        title4.setForeground(Color.DARK_GRAY);
        title4.setBackground(Color.lightGray);
        frm1.add(title4);
        JTextField txtresult = new JTextField();
        txtresult.setBounds(220,220,230,30);
        txtresult.setForeground(Color.DARK_GRAY);
        txtresult.setBackground(Color.lightGray);
        frm1.add(txtresult);

       /* c2.setBounds(220,220,200,30);
        c2.setForeground(Color.DARK_GRAY);
        c2.setBackground(Color.lightGray);
        frm1.add(c2);*/

        JButton btconvert = new JButton("Convert");
        btconvert.setBounds(220,280,100,30);
        btconvert.setFont(new Font("Arial", Font.BOLD, 16));
        btconvert.setForeground(Color.DARK_GRAY);
        btconvert.setBackground(Color.lightGray);
        frm1.add(btconvert);

        JButton btclose = new JButton("Close");
        btclose.setBounds(330,280,90,30);
        btclose.setFont(new Font("Arial", Font.BOLD, 16));
        btclose.setForeground(Color.DARK_GRAY);
        btclose.setBackground(Color.lightGray);
        frm1.add(btclose);

        JLabel result = new JLabel("");
        result.setBounds(30,330,400,30);
        result.setFont(new Font("Arial", Font.BOLD, 16));
        result.setForeground(Color.RED);
        result.setBackground(Color.lightGray);
        frm1.add(result);


        frm1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frm1.setResizable(false);
        frm1.setVisible(true);


        ActionListener clickconvert = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if(amount.getText().equals("") )
                {
                    result.setText("Please Enter Indian Rupees Corrency Only");
                }
                else {
                    double amount1 = Double.parseDouble(amount.getText());
                    System.out.println(amount1);
                    String op=c1.getSelectedItem().toString();
                    System.out.println(op);
                    switch (op)
                    {
                        case "US Dollar":
                            double doular =amount1/81.50;
                            txtresult.setText(String.valueOf(doular)+"  US doullar");
                            break;
                        case "Indian Rupee":
                            double rupees =amount1*1;
                            txtresult.setText(String.valueOf(rupees)+"  INR");
                            break;
                        case "British Pound":
                            double Pound =amount1/101;
                            txtresult.setText(String.valueOf(Pound)+"  British Pound");
                            break;

                        case "Euro":
                            double Euro =amount1/84;
                            txtresult.setText(String.valueOf(Euro)+"  Rusian Euro");
                            break;

                        case "Emirati Driham":
                            double Driham =amount1/84;
                            txtresult.setText(String.valueOf(Driham)+"  Emirati Driham");
                            break;
                        case "Chinese Yuan":
                            double Yuan =amount1/82;
                            txtresult.setText(String.valueOf(Yuan)+"  Chinese Yuan");
                            break;
                        default:
                            txtresult.setText("invalid choice");

                    }
                }

                //","","","","Canadian Dollar","","Chinese Yuan




            }
        };
        btconvert.addActionListener(clickconvert);
        ActionListener clickclose = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frm1.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frm1.setVisible(false);
            }
        };
        btclose.addActionListener(clickclose);


    }
}


public class Currencyconvertor {
    public static void main(String[] args) {
        Corrency_conv_pro obj = new Corrency_conv_pro();
        obj.correncyconvert();

    }
}