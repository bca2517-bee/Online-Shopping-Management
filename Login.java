package DBpgms;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.sql.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class Login {

    private JFrame frame;
    private JTextField txtEmail;
    private JPasswordField txtPassword;

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {

                    Login window = new Login();

                    window.frame.setVisible(true);

                } catch (Exception e) {

                    e.printStackTrace();

                }
            }
        });
    }


    public Login() {

        initialize();

    }


    private void initialize() {

        // Create JFrame

        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(173, 216, 230));
        frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 12));

        frame.setTitle("Online Shopping Management System");

        frame.setBounds(100,100,500,350);

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setLayout(null);

        JLabel lblTitle =  new JLabel("ONLINE SHOPPING MANAGEMENT SYSTEM");
        lblTitle.setBackground(new Color(255, 255, 255));

        lblTitle.setFont(
                new Font("Tahoma", Font.BOLD, 12)
        );

        lblTitle.setBounds(
                127,
                47,
                287,
                30
        );

        frame.getContentPane().add(lblTitle);


        JLabel lblEmail = new JLabel(
                "Email:"
        );

        lblEmail.setFont(
                new Font("Tahoma", Font.PLAIN, 14)
        );

        lblEmail.setBounds(
                80,
                100,
                80,
                25
        );

        frame.getContentPane().add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(
                150,
                100,
                250,
                25
        );

        frame.getContentPane().add(txtEmail);

        txtEmail.setColumns(10);
        JLabel lblPassword = new JLabel(
                "Password:"
        );

        lblPassword.setFont(
                new Font("Tahoma", Font.PLAIN, 14)
        );

        lblPassword.setBounds(
                80,
                145,
                80,
                25
        );

        frame.getContentPane().add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBackground(new Color(255, 255, 255));

        txtPassword.setBounds(
                150,
                145,
                250,
                25
        );

        frame.getContentPane().add(txtPassword);

        JButton btnLogin = new JButton(
                "LOGIN"
        );
        btnLogin.setBackground(new Color(224, 255, 255));

        btnLogin.setBounds(
                200,
                205,
                100,
                30
        );

        frame.getContentPane().add(btnLogin);

        btnLogin.addActionListener(
                new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","YOUR USERNAME","YOUR PASSWORD");
                    String email =txtEmail.getText();
                    String password =new String(txtPassword.getPassword());
                    PreparedStatement pstmt =con.prepareStatement("SELECT * FROM customers " +"WHERE email=? AND password=?");
                    pstmt.setString(1,email);
                    pstmt.setString(2,password);

                    ResultSet rs =pstmt.executeQuery();
                    if (rs.next()) {

                        JOptionPane.showMessageDialog(
                            frame,
                            "Login Successful!"
                        );
                       

                    } else {

                        JOptionPane.showMessageDialog(
                            frame,
                            "Invalid Email or Password"
                        );
                    }

                    rs.close();
                    pstmt.close();
                    con.close();

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(
                        frame,
                        "Error: " + ex.getMessage()
                    );

                }
            }

			
        });
    }
}
