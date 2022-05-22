import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelMenu extends JFrame implements ActionListener
{
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;
    JButton button10;
    JButton button11;
    JButton button12;

    FileIO fileIO = new FileIO();

    HotelMenu()
    {
        fileIO.readData();

        this.setTitle("Hotel Booking System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,1000);
        this.setLayout(new GridLayout(3,4, 5,5));
        this.setVisible(true);

        button1 = new JButton("Register guest");
        this.add(button1);
        button1.setFont(new Font("MV Boli",Font.PLAIN,20));
        button2 = new JButton("See all registered guests");
        this.add(button2);
        button2.setFont(new Font("MV Boli",Font.PLAIN,18));
        button3 = new JButton("Show all rooms");
        this.add(button3);
        button3.setFont(new Font("MV Boli",Font.PLAIN,20));
        button4 = new JButton("Show available rooms");
        this.add(button4);
        button4.setFont(new Font("MV Boli",Font.PLAIN,20));
        button5 = new JButton("Book a room");
        this.add(button5);
        button5.setFont(new Font("MV Boli",Font.PLAIN,20));
        button6 = new JButton("View all bookings");
        this.add(button6);
        button6.setFont(new Font("MV Boli",Font.PLAIN,20));
        button7 = new JButton("See menu card");
        this.add(button7);
        button7.setFont(new Font("MV Boli",Font.PLAIN,20));
        button8 = new JButton("Check out of room");
        this.add(button8);
        button8.setFont(new Font("MV Boli",Font.PLAIN,20));
        button9 = new JButton("Cancel reservation");
        this.add(button9);
        button9.setFont(new Font("MV Boli",Font.PLAIN,20));
        button10 = new JButton("Save and Exit");
        this.add(button10);
        button10.setFont(new Font("MV Boli",Font.PLAIN,20));
        button11 = new JButton("Exit without saving");
        this.add(button11);
        button11.setFont(new Font("MV Boli",Font.PLAIN,20));
        button12 = new JButton("Hotel Booking System");
        this.add(button12);
        button12.setFont(new Font("MV Boli",Font.PLAIN,20));

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        button10.addActionListener(this);
        button11.addActionListener(this);
        button12.addActionListener(this);

        button1.setBackground(new Color(3, 52, 126));
        button1.setForeground(new Color(3, 52, 126));
        button1.setOpaque(true);
        button2.setBackground(new Color(3, 52, 126));
        button2.setForeground(new Color(3, 52, 126));
        button2.setOpaque(true);
        button3.setBackground(new Color(3, 52, 126));
        button3.setForeground(new Color(3, 52, 126));
        button3.setOpaque(true);
        button4.setBackground(new Color(3, 52, 126));
        button4.setForeground(new Color(3, 52, 126));
        button4.setOpaque(true);
        button5.setBackground(new Color(3, 52, 126));
        button5.setForeground(new Color(3, 52, 126));
        button5.setOpaque(true);
        button6.setBackground(new Color(3, 52, 126));
        button6.setForeground(new Color(3, 52, 126));
        button6.setOpaque(true);
        button7.setBackground(new Color(3, 52, 126));
        button7.setForeground(new Color(3, 52, 126));
        button7.setOpaque(true);
        button8.setBackground(new Color(3, 52, 126));
        button8.setForeground(new Color(3, 52, 126));
        button8.setOpaque(true);
        button9.setBackground(new Color(3, 52, 126));
        button9.setForeground(new Color(3, 52, 126));
        button9.setOpaque(true);
        button10.setBackground(new Color(3, 126, 29));
        button10.setForeground(new Color(3, 126, 29));
        button10.setOpaque(true);
        button11.setBackground(new Color(232, 7, 33));
        button11.setForeground(new Color(232, 7, 33));
        button11.setOpaque(true);
        button12.setBackground(new Color(232, 142, 7));
        button12.setForeground(new Color(232,142,7));
        button12.setOpaque(true);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== button1){
            fileIO.registerGuest();
        }
        if(e.getSource()== button2){
            fileIO.showAllRegisteredGuests();
        }
        if(e.getSource()== button3){
            fileIO.showAllRooms();
        }
        if(e.getSource()== button4){
            fileIO.showAvailableRooms();
        }
        if(e.getSource()== button5){
            fileIO.bookRoom();
        }
        if(e.getSource()== button6){
            fileIO.showAllBookings();
        }
        if(e.getSource()== button7){
            fileIO.showFoodMenu();
        }
        if(e.getSource()== button8){
            fileIO.checkout();
        }
        if(e.getSource()== button9){
            fileIO.cancelBooking();
        }
        if(e.getSource()== button10){
            fileIO.saveData();
        }
        if(e.getSource()== button11){
            System.exit(0);
        }
    }
}
