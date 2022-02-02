import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DigitalWatch implements  Runnable{
    Thread t=null;
    JFrame frame;
    String s = "";
    JButton b;




    DigitalWatch(){
        JFrame frame = new JFrame("DigitalWatch");

        t = new Thread(this);
        t.start();

        b = new JButton();
        b.setBounds(100,100,100,100);
        b.setAlignmentX(Component.CENTER_ALIGNMENT);
        b.setAlignmentY(Component.CENTER_ALIGNMENT);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.add(b);
        frame.setLayout(null);
        frame.setVisible(true);


    }





    public void run() {
        try {
            while (true) {
                DateTimeFormatter u = DateTimeFormatter.ofPattern("HH:mm:ss");
                LocalTime d = LocalTime.now();

                String timeColonPattern = "HH:mm:ss";
                DateTimeFormatter timeColonFormatter = DateTimeFormatter.ofPattern(timeColonPattern);
                LocalTime colonTime = LocalTime.now();
                s = timeColonFormatter.format(colonTime);




                print();

                t.sleep( 1000 );

            }
        }
        catch (Exception e) { }



    }

    public void print() {
        b.setText(s);
    }





    public static void main(String[] args) {


        new DigitalWatch();






    }
}