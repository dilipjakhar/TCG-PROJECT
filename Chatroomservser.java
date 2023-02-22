import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class Chatroomserver1{
    JFrame frmserver;
    JButton send;
    JPanel pl2;
    Box vertical = Box.createVerticalBox();
    ServerSocket ss;
    String str1;

    public void chatrooms1()
    {
        frmserver = new JFrame("Server Chat Room");
        frmserver.setBounds(20,50,400, 500 );
        frmserver.setLayout(null);
        frmserver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmserver.setResizable(false);
        JPanel pl1 = new JPanel();
        pl1.setBounds(0,0,400,50);
        pl1.setBackground(new Color(7,94,84));
        JLabel head = new JLabel(" CHAT ROOM Server");
        head.setBounds(15,30,300,40);
        head.setFont(new Font("DS Chocolade", Font.BOLD, 22));
        head.setForeground(Color.RED);
        pl1.add(head);



        frmserver.add(pl1);

        pl2 = new JPanel();
        pl2.setBounds(0,80,400,300);
        //pl2.setBackground(new Color(229,204,255));
        frmserver.add(pl2);

        JPanel pl3 = new JPanel();
        pl3.setBounds(0,380,400,60);
        pl3.setBackground(new Color(190,190,190));

        JTextField txt1 = new JTextField();
        txt1.setBounds(5,5,250,50);
        pl3.add(txt1);
        pl3.setLayout(null);
        frmserver.add(pl3);
        send = new JButton("SEND");
        send.setBounds(265,5,110,50);
        send.setFont(new Font("Arial", Font.BOLD, 12));
        send.setForeground(Color.DARK_GRAY);
        pl3.add(send);


        frmserver.add(pl3);

        frmserver.setVisible(true);


        ActionListener clickserver = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String output = txt1.getText();
                JLabel output1 = new JLabel("<html><p style=\"width:150px\">"+output+"</p></html>");
                JPanel p2 = new JPanel();
                p2.setBounds(200,0,30,30);
                p2.add(output1);
                pl2.setLayout(new BorderLayout());
                JPanel right = new JPanel(new BorderLayout());
                right.add(p2,BorderLayout.LINE_END);
                vertical.add(right);
                vertical.add(Box.createVerticalStrut(15));
                pl2.add(vertical,BorderLayout.PAGE_START);

                p2.setLayout(new BoxLayout(p2,BoxLayout.Y_AXIS));

                output1.setBackground(new Color(95,95,95,95));
                output1.setFont(new Font("Tahoma",Font.PLAIN,14));
                output1.setOpaque(true);
                output1.setBorder(new EmptyBorder(15,15,15,20));

                try{
                    ServerSocket ss=new ServerSocket(6666);

                    Socket s = ss.accept();//establishes connection
                    DataInputStream dis = new DataInputStream(s.getInputStream());
                    str1 = (String) dis.readUTF();
                    //System.out.println("message= "+str1);

                    DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                    dout.writeUTF(output);
                    dout.flush();
                    //dout.close();
                    ss.close();
                }
                catch(Exception ex){System.out.println(e);}

                JLabel output2 = new JLabel("<html><p style=\"width:150px\">"+str1+"</p></html>");
                JPanel p3 = new JPanel();
                p3.setBounds(10,35,30,30);
                p3.add(output2);
                pl2.setLayout(new BorderLayout());
                JPanel left = new JPanel(new BorderLayout());
                left.add(p3,BorderLayout.LINE_START);
                vertical.add(left);
                vertical.add(Box.createVerticalStrut(15));
                pl2.add(vertical,BorderLayout.PAGE_START);

                p3.setLayout(new BoxLayout(p3,BoxLayout.Y_AXIS));

                output2.setBackground(new Color(95,95,95,95));
                output2.setFont(new Font("Tahoma",Font.PLAIN,14));
                output2.setOpaque(true);
                output2.setBorder(new EmptyBorder(15,15,15,20));



                frmserver.repaint();
                frmserver.invalidate();
                frmserver.validate();
                txt1.setText("");
                try{
                    ServerSocket ss=new ServerSocket(6666);
                    Socket s=ss.accept();//establishes connection
                    DataInputStream dis=new DataInputStream(s.getInputStream());
                    str1=(String)dis.readUTF();
                    //System.out.println("message= "+str1);

                    DataOutputStream dout=new DataOutputStream(s.getOutputStream());
                    dout.writeUTF(output);
                    dout.flush();
                    dout.close();
                    ss.close();
                }
                catch(Exception ex){System.out.println(e);}
            }

        };


        send.addActionListener(clickserver);


    }


}


public class Chatroomservser {
    public static void main(String[] args) {
        Chatroomserver1 obj = new Chatroomserver1();
        obj.chatrooms1();
    }
}