import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener
{
    JFrame frame = new JFrame();
    JButton myButton = new JButton("Login");
    JPanel panel = new JPanel();
    JLabel userLabel = new JLabel("Username");
    JTextField userText = new JTextField();
    JLabel passwordLabel = new JLabel("Password");
    JPasswordField passwordText = new JPasswordField();
    JLabel tryAgain = new JLabel("");
    JLabel label = new JLabel();

    GUI()
    {
        frame.setTitle("Hotel Booking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);

        userLabel.setBounds(50,100,175,25);
        panel.add(userLabel);

        userText.setBounds(185,100,200,25);
        panel.add(userText);

        passwordLabel.setBounds(50,150,175,25);
        panel.add(passwordLabel);

        passwordText.setBounds(185,150,200,25);
        panel.add(passwordText);

        myButton.setBounds(50,200,100,35);
        myButton.setFocusable(false);
        myButton.addActionListener(this);

        tryAgain.setBounds(125,250,300,25);
        panel.add(tryAgain);

        label.setIcon(new ImageIcon("/Users/aleksbuha/Desktop/dfdfd.jpeg"));

        frame.add(userLabel);
        userLabel.setFont(new Font(null,Font.PLAIN,20));
        frame.add(userText);
        frame.add(passwordLabel);
        passwordLabel.setFont(new Font(null,Font.PLAIN,20));
        frame.add(passwordText);
        frame.add(myButton);
        myButton.setFont(new Font(null,Font.PLAIN,20));
        frame.add(tryAgain);
        tryAgain.setFont(new Font(null,Font.PLAIN,20));
        frame.add(label);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = passwordText.getText();
        if(user.equals("Aleks") && password.equals("12345")){
            frame.dispose();
            HotelMenu hotelMenu = new HotelMenu();
        }
        tryAgain.setForeground(Color.red);
        tryAgain.setText("Wrong input. Try again!");
    }
}
