
        import org.json.simple.JSONArray;
        import org.json.simple.JSONObject;
        import org.json.simple.parser.JSONParser;

        import javax.swing.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.net.URL;
        import java.text.DecimalFormat;
        import java.util.Scanner;

class Urlcon2 {
    JFrame f;
    JComboBox cb;
    JLabel latitude1;
    JLabel longi1;
    JButton submit;
    String longt;
    String lat;
    JLabel temp_max1;
    JLabel temp1;
    JLabel temp_min1;
    JLabel pressure1;
    JLabel humidity1;
    public void form()
    {
        f=new JFrame("ComboBox Example");
        String distict[]={"Ajmer","Alwar","Banswara","Baran","Barmer","Barmer","Bharatpur","Bhilwara","Bikaner","Bundi"," Chittorgarh",
                "Churu"," Dausa", "Dausa", "Dholpur", "Dungarpur", "Hanumangarh", "Jaipur", "jaisalmer", "Jalor", "Jalor",
                "Jhalawar", "Jhunjhunu", "Jodhpur", "Karauli","Kota", "Nagaur", "Pali","Pratapgarh","Rajsamand","Rajsamand",
                "Sawai Madhopur", 	"Sikar", "Sirohi",  "Sri Ganganagar", "Tonk", "Udaipur"};

        cb=new JComboBox(distict);
        cb.setBounds(50, 50,200,30);
        f.add(cb);
        f.setLayout(null);
        submit = new JButton("submit");
        submit.setBounds(70, 100,100,30);
        f.add(submit);
        JLabel longi = new JLabel("Longitude: ");
        longi.setBounds(50, 150,150,30);
        f.add(longi);

        longi1 = new JLabel(" ");
        longi1.setBounds(250, 150,150,30);
        f.add(longi1);

        JLabel latitude = new JLabel("Latitude: ");
        latitude.setBounds(50, 200,150,30);
        f.add(latitude);

        latitude1 = new JLabel(" ");
        latitude1.setBounds(250, 200,150,30);
        f.add(latitude1);

        JLabel temp = new JLabel("Temprature: ");
        temp.setBounds(50, 240,200,30);
        f.add(temp);

        temp1 = new JLabel(" ");
        temp1.setBounds(270, 240,200,30);
        f.add(temp1);

        JLabel temp_min = new JLabel("Temp_Min: ");
        temp_min.setBounds(50, 280,200,30);
        f.add(temp_min);

        temp_min1 = new JLabel(" ");
        temp_min1.setBounds(270, 280,200,30);
        f.add(temp_min1);

        JLabel temp_max = new JLabel("Temp_Max: ");
        temp_max.setBounds(50, 320,200,30);
        f.add(temp_max);

        temp_max1 = new JLabel(" ");
        temp_max1.setBounds(270, 320,200,30);
        f.add(temp_max1);

        JLabel pressure = new JLabel("Pressure: ");
        pressure.setBounds(50, 360,200,30);
        f.add(pressure);

        pressure1 = new JLabel(" ");
        pressure1.setBounds(270, 360,200,30);
        f.add(pressure1);


        JLabel humidity = new JLabel("Humidity: ");
        humidity.setBounds(50, 400,200,30);
        f.add(humidity);

        humidity1 = new JLabel(" ");
        humidity1.setBounds(270, 400,200,30);
        f.add(humidity1);

        f.setSize(400,700);
        f.setVisible(true);
    }
    public void longi_Latitude (){
        form();
        ActionListener click = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dis=cb.getSelectedItem().toString();

                try {
           /* Scanner obj2 = new Scanner(System.in);
            System.out.println("Enter your district");
            String dis=obj2.nextLine();*/
                    URL url = new URL("http://api.openweathermap.org/geo/1.0/direct?q="+dis+",rajasthan,india&limit1&appid=e34d930991360bd6b5727677d0eae368");
// connection established karne ke liye
                    Scanner sc = new Scanner(url.openStream());
                    String str = "";
                    while(sc.hasNextLine()){
                        str+=sc.nextLine();
                    }
                    //System.out.println(str);
                    JSONParser jp = new JSONParser();
                    //JSONObject obj = (JSONObject)jp.parse(str);
                    //JSONObject obj1 = (JSONObject)obj.get("channel");
                    //System.out.println("id: "+obj1.get("id"));
                    //System.out.println("name: "+obj1.get("name"));
                    //JSONArray arr = (JSONArray)obj.get("name");
                    JSONArray arr = (JSONArray)jp.parse(str);
                    for(int i=0;i<arr.size();i++){
                        JSONObject obj3 = (JSONObject)arr.get(i);

                        lat = obj3.get("lat").toString();
                        System.out.println(lat);
                        latitude1.setText(lat);
                        longt = obj3.get("lon").toString();
                        longi1.setText(longt);
                        System.out.println(longt);
                    }
                    // wether api calling
                    String lon11 = longi1.getText();
                    String lat11 = latitude1.getText();
                    System.out.println(lon11+lat11);
                    URL url1 = new URL("https://api.openweathermap.org/data/2.5/weather?lat="+lat11+"&lon="+lon11+"&appid=e34d930991360bd6b5727677d0eae368");
                    Scanner sc1 = new Scanner(url1.openStream());
                    String str1 = "";
                    while(sc1.hasNextLine()){
                        str1+=sc1.nextLine();
                    }
                    System.out.println(str1);
                    JSONParser jp1 = new JSONParser();
                    JSONObject obj3 = (JSONObject)jp1.parse(str1);
                    JSONObject obj4 = (JSONObject)obj3.get("main");
                    System.out.println("temp: "+obj4.get("temp"));
                    String temp = obj4.get("temp").toString();
                    double temp2 = Double.parseDouble(temp);
                    double temp3 = temp2-273;


                    temp1.setText(new DecimalFormat("##.##").format(temp3));
                    String temp_min= obj4.get("temp_min").toString();
                    double temp2_min = Double.parseDouble(temp_min);
                    double temp3_min = temp2_min-273;
                    temp_min1.setText(new DecimalFormat("##.##").format(temp3_min));

                    String temp_max= obj4.get("temp_max").toString();
                    double temp2_max = Double.parseDouble(temp_max);
                    double temp3_max = temp2_min-273;
                    temp_max1.setText(new DecimalFormat("##.##").format(temp3_max));

                    String pressure2= obj4.get("pressure").toString();
                    pressure1.setText(pressure2);
                    String humidity= obj4.get("humidity").toString();
                    humidity1.setText(humidity);

                }

                catch (Exception ex){
                    System.out.println(ex);
                }
            }
        };
        submit.addActionListener(click);
    }
}
public class Longitude_latitude {
    public static void main(String[] args) {
        Urlcon2 obj1 = new Urlcon2();
        obj1.longi_Latitude();
    }
}