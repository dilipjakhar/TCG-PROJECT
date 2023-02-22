import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class notes1 {
    JFrame frm1;
    JTextField txt_subject;
    JTextField txt_topic;
    JTextArea txtarea_description;
    JButton addtopic;
    JButton show_notes;
    JLabel message;
    JFrame frm_show;
    JComboBox comboBox1;
    JComboBox comboBox2;
    JButton showdata;
    JTable jtable1;
    JButton back;

    public void notes1()
    {
        frm1 = new JFrame("Technical Core Groups Notes");
        frm1.setBounds(100,50,700,700);
        frm1.setLayout(null);
        JLabel lbl_title = new JLabel("Add Your Technical Notes");
        lbl_title.setBounds(250,50,400,30);
        lbl_title.setFont(new Font("Arial", Font.BOLD, 20));
        lbl_title.setForeground(Color.GRAY);
        frm1.add(lbl_title);

        JLabel lbl_sub = new JLabel("Add Subject :");
        lbl_sub.setBounds(50,100,150,30);
        lbl_sub.setFont(new Font("Arial", Font.BOLD, 14));
        lbl_sub.setForeground(Color.RED);
        //lbl_title.setBackground(Color.BLACK);
        frm1.add(lbl_sub);

       /* txt_subject = new JTextField();
        txt_subject.setBounds(200,100,300,30);
        txt_subject.setFont(new Font("Arial", Font.BOLD, 14));
        frm1.add(txt_subject);*/

        String select_sub1[]={"java","mysql","c language","c++ language"};
        comboBox1 = new JComboBox(select_sub1);
        comboBox1.setBounds(200,100,300,30);
        comboBox2.setFont(new Font("Arial", Font.BOLD, 14));
        frm1.add(comboBox1);

        JLabel lbl_topic = new JLabel("Add Topic Name :");
        lbl_topic.setBounds(50,140,150,30);
        lbl_topic.setFont(new Font("Arial", Font.BOLD, 14));
        lbl_topic.setForeground(Color.RED);
        //lbl_title.setBackground(Color.BLACK);
        frm1.add(lbl_topic);

        txt_topic = new JTextField();
        txt_topic.setBounds(200,140,300,30);
        txt_topic.setFont(new Font("Arial", Font.BOLD, 14));
        frm1.add(txt_topic);

        JLabel lbl_description = new JLabel("Topic Description :");
        lbl_description.setBounds(50,180,150,30);
        lbl_description.setFont(new Font("Arial", Font.BOLD, 14));
        lbl_description.setForeground(Color.RED);
        //lbl_title.setBackground(Color.BLACK);
        frm1.add(lbl_description);

        txtarea_description = new JTextArea();
        txtarea_description.setBounds(200,180,300,300);
        txtarea_description.setFont(new Font("Arial", Font.BOLD, 14));
        frm1.add(txtarea_description);

        addtopic = new JButton("Add New");
        addtopic.setBounds(200,500,150,30);
        addtopic.setFont(new Font("Arial", Font.BOLD, 14));
        frm1.add(addtopic);

        show_notes = new JButton("Show Notes");
        show_notes.setBounds(360,500,150,30);
        show_notes.setFont(new Font("Arial", Font.BOLD, 14));
        frm1.add(show_notes);

        message = new JLabel(":");
        message.setBounds(50,550,400,30);
        message.setFont(new Font("Arial", Font.BOLD, 14));
        message.setForeground(Color.RED);
        frm1.add(message);

        JScrollBar s=new JScrollBar();
        frm1.add(s);
        frm1.setResizable(false);
        frm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frm1.setVisible(true);
    }

    public void show_notes()
    {
        frm_show = new JFrame("Show all notes");
        frm_show.setBounds(100,50,700,700);
        frm_show.setResizable(false);
        frm_show.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm_show.setLayout(null);
        JLabel lbl_title = new JLabel("Display All Technical Notes");
        lbl_title.setBounds(250,50,400,30);
        lbl_title.setFont(new Font("Arial", Font.BOLD, 20));
        lbl_title.setForeground(Color.GRAY);
        String select_sub[]={"java","mysql","c language","c++ language"};
        comboBox2 = new JComboBox(select_sub);
        comboBox2.setBounds(50,100,150,30);
        comboBox2.setFont(new Font("Arial", Font.BOLD, 16));

        frm_show.add(lbl_title);
        frm_show.add(comboBox2);

        showdata = new JButton("Show Notes");
        showdata.setBounds(220, 100, 150,30);
        frm_show.add(showdata);

        back = new JButton("Back");
        back.setBounds(360, 100, 100,30);
        frm_show.add(back);

        ActionListener clickshow = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tcg_notes", "root", "9887288339");
                    String dis=comboBox2.getSelectedItem().toString();
                    String qr = "Select id,subject_name,topic_name,description from notes_tb1 where subject_name='"+dis+"'";

                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(qr);
                    System.out.println(rs);
                    //int i=0;
                    DefaultTableModel model = new DefaultTableModel();
                    jtable1 = new JTable(model);

                    //model.addColumn("Id");
                    model.addColumn("Subject name");
                    model.addColumn("Topic name");
                    model.addColumn("Description");


                    while (rs.next()) {
                        model.addRow(new Object[]{rs.getString(2),rs.getString(3),rs.getString(4)});

                        jtable1.setBounds(30, 150, 600, 400);
                        frm_show.add(jtable1);


                    }
                    // adding it to JScrollPane
                }
                catch (Exception ep)
                {
                    System.out.println(ep);
                }
            }
        };
        showdata.addActionListener(clickshow);


    }

    public void note_code()
    {
        show_notes();
        notes1();
        show_notes();
        ActionListener clickadd = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sub1=comboBox1.getSelectedItem().toString();
                if(sub1.equals(""))
                {
                    message.setText("Please select Subject");
                }
                else if(txt_topic.getText().equals(""))
                {
                    message.setText("Please fill New Topic name");
                }
                else if(txtarea_description.getText().equals(""))
                {
                    message.setText("Please fill topic description");
                }
                else {
                    /*String subject= txt_subject.getText();*/
                    String sub2=comboBox1.getSelectedItem().toString();
                    String topic = txt_topic.getText();
                    String description = txtarea_description.getText();

                    try{
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tcg_notes","root","9887288339");
                        //String ct = "create table java(id  int, name varchar(50))";
                        String query = "insert  into notes_tb1 (subject_name,topic_name,description ) values('"+sub2+"','"+topic+"','"+description+"')";


                        Statement st = con.createStatement();
                        //ResultSet rs = st.executeQuery(ct);
                        st.executeUpdate(query);

                        //txt_subject.setText("");
                        txt_topic.setText("");
                        txtarea_description.setText("");
                        message.setText("New topic add accessfully");
                    }
                    catch (Exception y)
                    {
                        System.out.println(y);
                    }

                }

            }
        };
        addtopic.addActionListener(clickadd);

        ActionListener click_show_frm = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frm_show.setVisible(true);
                frm1.setVisible(false);
                message.setText("");
            }
        };
        show_notes.addActionListener(click_show_frm);
        ActionListener click_back = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frm_show.setVisible(false);
                frm1.setVisible(true);
            }
        };
        back.addActionListener(click_back);

    }

}

public class Notes {

    public static void main(String[] args) {

        notes1 obj_notes1 = new notes1();
        obj_notes1.note_code();
    }
}
