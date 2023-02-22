import javax.swing.*;
import javax.swing.JScrollPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import javax.swing.table.DefaultTableModel;

class Login_registion
{
    JButton update;
    JButton delete;
    JTable records;
    JFrame homepage;
    JButton btlogin;
    JFrame frmlogin;

    JFrame frmreg;
    JButton btreg;
    JButton btreg1;
    JTextField txtemail1;
    JTextField txtpass;
    JTextField txtname,txtfname,txtaddress,txtmobile,txtemail,txtrank;
    JLabel error;
    JLabel error1;
    JButton btloginnow;
    JTable table;
    public void log()
    {
        frmlogin = new JFrame("Log In Page");
        frmlogin.setBounds(100,50,400,400);
        frmlogin.setLayout(null);
        frmlogin.setResizable(false);
        frmlogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("LogIn");
        title.setBounds(150,50,300,30);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(Color.DARK_GRAY);
        title.setBackground(Color.lightGray);
        frmlogin.add(title);

        JLabel lemail = new JLabel("Email Id : ");
        lemail.setBounds(30,100,100,30);
        lemail.setFont(new Font("Arial", Font.BOLD, 16));
        lemail.setForeground(Color.DARK_GRAY);
        lemail.setBackground(Color.DARK_GRAY);
        frmlogin.add(lemail);

        txtemail1 = new JTextField("");
        txtemail1.setBounds(150,100,200,30);
        txtemail1.setFont(new Font("Arial", Font.BOLD, 16));
        txtemail1.setForeground(Color.DARK_GRAY);
        txtemail1.setBackground(Color.LIGHT_GRAY);
        frmlogin.add(txtemail1);



        JLabel lpass = new JLabel("Password : ");
        lpass.setBounds(30,150,100,30);
        lpass.setFont(new Font("Arial", Font.BOLD, 16));
        lpass.setForeground(Color.DARK_GRAY);
        lpass.setBackground(Color.DARK_GRAY);
        frmlogin.add(lpass);

        txtpass = new JTextField("");
        txtpass.setBounds(150,150,200,30);
        txtpass.setFont(new Font("Arial", Font.BOLD, 16));
        txtpass.setForeground(Color.DARK_GRAY);
        txtpass.setBackground(Color.LIGHT_GRAY);
        frmlogin.add(txtpass);

        btlogin = new JButton("LogIn");
        btlogin.setBounds(150,190,70,30);
        btlogin.setFont(new Font("Arial", Font.BOLD, 12));
        btlogin.setForeground(Color.DARK_GRAY);
        btlogin.setBackground(Color.LIGHT_GRAY);
        frmlogin.add(btlogin);

        btreg = new JButton("Registration");
        btreg.setBounds(230,190,120,30);
        btreg.setFont(new Font("Arial", Font.BOLD, 12));
        btreg.setForeground(Color.DARK_GRAY);
        btreg.setBackground(Color.LIGHT_GRAY);
        frmlogin.add(btreg);

        error1 = new JLabel("");
        error1.setBounds(30,230,200,30);
        error1.setFont(new Font("Arial", Font.BOLD, 12));
        error1.setForeground(Color.RED);
        error1.setBackground(Color.LIGHT_GRAY);
        frmlogin.add(error1);

        frmlogin.setVisible(true);



        homepage = new JFrame("HOME PAGE");
        homepage.setBounds(50,50,600,900);
        homepage.setLayout(null);
        JLabel homepage1 = new JLabel("Home Page");
        homepage1.setBounds(200,30,500,30);
        homepage1.setFont(new Font("Arial", Font.BOLD, 20));
        homepage1.setForeground(Color.DARK_GRAY);
        homepage.add(homepage1);
        JLabel homepage2 = new JLabel("You hava login sucessfully");
        homepage2.setBounds(30,70,500,30);
        homepage2.setFont(new Font("Arial", Font.BOLD, 16));
        homepage2.setForeground(Color.RED);

        JButton logout = new JButton("Logout");
        logout.setBounds(30,100,100,30);
        logout.setFont(new Font("Arial", Font.BOLD, 16));
        logout.setForeground(Color.DARK_GRAY);
        homepage.add(logout);
        ActionListener clicklogout = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homepage.setVisible(false);
                frmlogin.setVisible(true);
            }
        };
        logout.addActionListener(clicklogout);

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tcg_reg", "root", "9887288339");
            String qr = "Select * from reg3";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(qr);
            System.out.println(rs);
            String rows1 [] = {"User Id","User Name","Father Name","Address","Mobile No", "Eamil","Rank"};
            int id ;
            String name;
            String fname ;
            String address ;
            String mobile ;
            String email ;
            String rank ;

            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(rows1);
            table = new JTable();
            table.setBounds(30,150,500,400);

            table.setModel(model);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            table.setPreferredScrollableViewportSize(new Dimension(250,63));
            table.setFillsViewportHeight(true);
            JScrollPane scroll = new JScrollPane(table);
            scroll.setHorizontalScrollBarPolicy(
                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scroll.setVerticalScrollBarPolicy(
                    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);



            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("uname");
                fname = rs.getString("fname");
                address = rs.getString("address");
                mobile = rs.getString("mobile");
                email = rs.getString("email");
                rank = rs.getString("rank1");
                // System.out.println(name);
                model.addRow(new Object[]{id,name,fname,address,mobile,email,rank});


                //int id=rs.getInt("help_topic_id");
                //String name =rs.getString("");
                String ids=String.valueOf(id);
                String cols[][] = {{ids,name,fname,address,mobile,email,rank},{ids,name,fname,address,mobile,email,rank}
                };
                homepage.add(scroll);
                records = new JTable(cols,rows1);
                records.setBounds(30,60,600,400);

            }


        }
        catch (Exception ey)
        {
            System.out.println(ey);
        }
        JScrollPane sp = new JScrollPane(records);
        homepage.add(sp);
        homepage.add(table);
        homepage.add(homepage2);
        //homepage.setVisible(true);




    }

    public void registration()
    {
        log();
        frmreg = new JFrame("User Registration");
        frmreg.setBounds(100,50,600,700);
        frmreg.setLayout(null);
        frmreg.setResizable(false);
        frmreg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel(" User Registration Form ");
        title.setBounds(150,50,300,30);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(Color.DARK_GRAY);
        title.setBackground(Color.lightGray);
        frmreg.add(title);

        JLabel lname = new JLabel("Name : ");
        lname.setBounds(30,110,100,30);
        lname.setFont(new Font("Arial", Font.BOLD, 16));
        lname.setForeground(Color.DARK_GRAY);
        lname.setBackground(Color.DARK_GRAY);
        frmreg.add(lname);

        txtname = new JTextField("");
        txtname.setBounds(170,110,200,30);
        txtname.setFont(new Font("Arial", Font.BOLD, 16));
        txtname.setForeground(Color.DARK_GRAY);
        txtname.setBackground(Color.LIGHT_GRAY);
        frmreg.add(txtname);

        JLabel lfname = new JLabel("Father's Name : ");
        lfname.setBounds(30,150,130,30);
        lfname.setFont(new Font("Arial", Font.BOLD, 16));
        lfname.setForeground(Color.DARK_GRAY);
        lfname.setBackground(Color.DARK_GRAY);
        frmreg.add(lfname);

        txtfname = new JTextField("");
        txtfname.setBounds(170,150,200,30);
        txtfname.setFont(new Font("Arial", Font.BOLD, 16));
        txtfname.setForeground(Color.DARK_GRAY);
        txtfname.setBackground(Color.LIGHT_GRAY);
        frmreg.add(txtfname);

        JLabel laddress = new JLabel("Address : ");
        laddress.setBounds(30,190,120,30);
        laddress.setFont(new Font("Arial", Font.BOLD, 16));
        laddress.setForeground(Color.DARK_GRAY);
        laddress.setBackground(Color.DARK_GRAY);
        frmreg.add(laddress);

        txtaddress = new JTextField("");
        txtaddress.setBounds(170,190,200,30);
        txtaddress.setFont(new Font("Arial", Font.BOLD, 16));
        txtaddress.setForeground(Color.DARK_GRAY);
        txtaddress.setBackground(Color.LIGHT_GRAY);
        frmreg.add(txtaddress);

        JLabel lmobile = new JLabel("Mobile No : ");
        lmobile.setBounds(30,230,120,30);
        lmobile.setFont(new Font("Arial", Font.BOLD, 16));
        lmobile.setForeground(Color.DARK_GRAY);
        lmobile.setBackground(Color.DARK_GRAY);
        frmreg.add(lmobile);

        txtmobile = new JTextField("");
        txtmobile.setBounds(170,230,200,30);
        txtmobile.setFont(new Font("Arial", Font.BOLD, 16));
        txtmobile.setForeground(Color.DARK_GRAY);
        txtmobile.setBackground(Color.LIGHT_GRAY);
        frmreg.add(txtmobile);

        JLabel lemail = new JLabel("Email Id : ");
        lemail.setBounds(30,270,120,30);
        lemail.setFont(new Font("Arial", Font.BOLD, 16));
        lemail.setForeground(Color.DARK_GRAY);
        lemail.setBackground(Color.DARK_GRAY);
        frmreg.add(lemail);

        txtemail = new JTextField("");
        txtemail.setBounds(170,270,200,30);
        txtemail.setFont(new Font("Arial", Font.BOLD, 16));
        txtemail.setForeground(Color.DARK_GRAY);
        txtemail.setBackground(Color.LIGHT_GRAY);
        frmreg.add(txtemail);

        JLabel lrank = new JLabel("Rank : ");
        lrank.setBounds(30,310,120,30);
        lrank.setFont(new Font("Arial", Font.BOLD, 16));
        lrank.setForeground(Color.DARK_GRAY);
        lrank.setBackground(Color.DARK_GRAY);
        frmreg.add(lrank);

        txtrank = new JTextField("");
        txtrank.setBounds(170,310,200,30);
        txtrank.setFont(new Font("Arial", Font.BOLD, 16));
        txtrank.setForeground(Color.DARK_GRAY);
        txtrank.setBackground(Color.LIGHT_GRAY);
        frmreg.add(txtrank);


        btreg1 = new JButton("Registration");
        btreg1.setBounds(170,370,120,30);
        btreg1.setFont(new Font("Arial", Font.BOLD, 12));
        btreg1.setForeground(Color.DARK_GRAY);
        btreg1.setBackground(Color.LIGHT_GRAY);
        frmreg.add(btreg1);
        btloginnow = new JButton("LogIn Now");
        btloginnow.setBounds(300,370,120,30);
        btloginnow.setFont(new Font("Arial", Font.BOLD, 12));
        btloginnow.setForeground(Color.DARK_GRAY);
        btloginnow.setBackground(Color.LIGHT_GRAY);
        frmreg.add(btloginnow);




        error = new JLabel("");
        error.setBounds(30,420,550,30);
        error.setFont(new Font("Arial", Font.BOLD, 10));
        error.setForeground(Color.RED);
        error.setBackground(Color.LIGHT_GRAY);
        frmreg.add(error);
        //frmreg.setVisible(true);

    }
    public void login_regis()
    {
        registration();
        ActionListener clickreg = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmreg.setVisible(true);
                //frmlogin.setVisible(false);
            }
        };
        btreg.addActionListener(clickreg);

        ActionListener click_loginpaage = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmreg.setVisible(false);
                frmlogin.setVisible(true);
            }
        };
        btloginnow.addActionListener(click_loginpaage);






        ActionListener clickreg1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtname.getText().equals(""))
                {
                    error.setText("Please fill name fields");
                }
                else if(txtfname.getText().equals(""))
                {
                    error.setText("Please fill father's name fields");
                }
                else if(txtaddress.getText().equals(""))
                {
                    error.setText("Please fill address fields");
                }
                else if(txtmobile.getText().equals(""))
                {
                    error.setText("Please fill mobile no fields");
                }
                else if(txtemail.getText().equals(""))
                {
                    error.setText("Please fill email fields");
                }
                else if(txtrank.getText().equals(""))
                {
                    error.setText("Please fill rank fields");
                }

                else {
                    Random password = new Random();
                    String name= txtname.getText();
                    String fname = txtfname.getText();
                    String address = txtaddress.getText();
                    String mobile = txtmobile.getText();
                    String email = txtemail.getText();
                    String rank = txtrank.getText();
                    int pass = password.nextInt(5000)*100;
                    //System.out.println(name+fname+address+mobile+email+rank);
                    //System.out.println(pass);


                    try{
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tcg_reg","root","9887288339");
                        //String ct = "create table java(id  int, name varchar(50))";
                        String query = "insert  into reg3 (uname,fname,address,mobile,email,pass,rank1 ) values('"+name+"','"+fname+"','"+address+"','"+mobile+"','"+email+"',"+pass+",'"+rank+"')";


                        Statement st = con.createStatement();
                        //ResultSet rs = st.executeQuery(ct);
                        st.executeUpdate(query);

                        error.setText("your account has been created sucessfully. your email Id:- "+email+" and password :- "+pass);
                        txtname.setText("");
                        txtfname.setText("");
                        txtaddress.setText("");
                        txtmobile.setText("");
                        txtemail.setText("");
                        txtrank.setText("");
                    }
                    catch (Exception y)
                    {
                        System.out.println(y);
                    }

                    //frmlogin.setVisible(true);
                    //frmreg.setVisible(false);
                }
            }
        };
        btreg1.addActionListener(clickreg1);

        ActionListener clicklogin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtemail1.getText().equals(""))
                {
                    error1.setText("Please fill your email id");
                }
                else if(txtpass.getText().equals(""))
                {
                    error1.setText("Please fill password");
                }

                else {
                    try {

                        Class.forName("com.mysql.cj.jdbc.Driver");

                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tcg_reg","root","9887288339");
                        String email1 =txtemail1.getText();
                        String password1 = txtpass.getText();
                        String qr ="Select email,pass from reg3 where email='"+email1+"' && pass='"+password1+"'";
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(qr);
                        System.out.println(rs);
                        String email="";
                        String password="";
                        while(rs.next())
                        {
                            email = rs.getString("email");
                            password = rs.getString("pass");
                            //int id=rs.getInt("help_topic_id");
                            //String name =rs.getString("");
                            System.out.println(email+password);
                        }
                        if(txtemail1.getText().equals(email) && txtpass.getText().equals(password)) {

                            homepage.setVisible(true);
                            txtemail1.setText("");
                            txtpass.setText("");
                            frmlogin.setVisible(false);


                        }
                        else
                        {
                            error1.setText("email and password incorect, try again");
                        }
                    }
                    catch (Exception ex)
                    {
                        System.out.println(ex);
                    }






                }
            }
        };
        btlogin.addActionListener(clicklogin);

    }


}

public class Login_registration_user {
    public static void main(String[] args) {
        Login_registion obj = new Login_registion();
        //obj.log();
        //obj.registration();
        obj.login_regis();

    }
}