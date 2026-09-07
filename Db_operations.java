package DBpgms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;


public class Db_operations extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JTable table;

    private JTextField textField;     
    private JTextField textField_1;   
    private JTextField textField_3;   
    private JTextField textField_4;   
    private JComboBox<String> comboBox;   


    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {

                    Db_operations frame = new Db_operations();
                    frame.setVisible(true);

                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
        });
    }


    public Db_operations() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(100, 100, 600, 350);


        // =========================
        // PANEL
        // =========================

        contentPane = new JPanel();

        contentPane.setBackground(new Color(173, 216, 230));

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        contentPane.setLayout(null);


        // =========================
        // TABLE
        // =========================

        JScrollPane scrollPane = new JScrollPane();

        scrollPane.setBounds(194, 71, 370, 139);

        contentPane.add(scrollPane);


        table = new JTable();

        table.setModel(new DefaultTableModel(

            new Object[][] {},

            new String[] {
                "Customer_id",
                "Name",
                "Email",
                "Phone",
                "Password"
            }
        ));

        scrollPane.setViewportView(table);


        // =========================
        // TITLE
        // =========================

        JLabel lblTitle =
            new JLabel("DATABASE OPERATIONS");
        lblTitle.setBackground(new Color(255, 255, 255));

        lblTitle.setFont(
            new Font("Tahoma", Font.BOLD, 17)
        );

        lblTitle.setBounds(
            212, 29, 206, 18
        );

        contentPane.add(lblTitle);


        // =========================
        // SHOW BUTTON
        // =========================

        JButton btnShow =
            new JButton("SHOW");

        btnShow.setBounds(
            360, 220, 84, 25
        );

        contentPane.add(btnShow);


        btnShow.addActionListener(
            new ActionListener() {

                public void actionPerformed(
                    ActionEvent e) {

                    try {

                        Class.forName(
                            "oracle.jdbc.driver.OracleDriver"
                        );


                        Connection con =
                            DriverManager.getConnection(

                                "jdbc:oracle:thin:@localhost:1521:orcl",

                                "bca",
                                "bca"
                            );


                        String sql =
                            "SELECT * FROM customers";


                        PreparedStatement pstmt =
                            con.prepareStatement(sql);


                        ResultSet rs =
                            pstmt.executeQuery();


                        table.setModel(
                            DbUtils.resultSetToTableModel(rs)
                        );


                        rs.close();

                        pstmt.close();

                        con.close();


                    } catch (Exception ex) {

                        ex.printStackTrace();
                    }
                }
            }
        );


        // =========================
        // LABELS
        // =========================

        JLabel lblCustomerId =
            new JLabel("Customer_id");

        lblCustomerId.setBounds(
            10, 101, 70, 12
        );

        contentPane.add(lblCustomerId);


        JLabel lblName =
            new JLabel("Name");

        lblName.setBounds(
            20, 123, 44, 12
        );

        contentPane.add(lblName);


        JLabel lblEmail =
            new JLabel("Email");

        lblEmail.setBounds(
            20, 145, 44, 12
        );

        contentPane.add(lblEmail);


        JLabel lblPhone =
            new JLabel("Phone");

        lblPhone.setBounds(
            20, 167, 44, 12
        );

        contentPane.add(lblPhone);


        JLabel lblPassword =
            new JLabel("Password");

        lblPassword.setBounds(
            20, 189, 60, 12
        );

        contentPane.add(lblPassword);


        // =========================
        // ADD BUTTON
        // =========================

        JButton btnAdd =
            new JButton("ADD");

        btnAdd.setBounds(
            43, 220, 84, 25
        );

        contentPane.add(btnAdd);


        btnAdd.addActionListener(
            new ActionListener() {

                public void actionPerformed(
                    ActionEvent e) {

                    try {

                        Class.forName(
                            "oracle.jdbc.driver.OracleDriver"
                        );


                        Connection con =
                            DriverManager.getConnection(

                                "jdbc:oracle:thin:@localhost:1521:orcl",

                                "bca",
                                "bca"
                            );


                        // Get values
                        String id =
                            textField.getText();

                        String name =
                            textField_1.getText();

                        String email =
                            comboBox.getSelectedItem().toString();

                        String phone =
                            textField_3.getText();

                        String password =
                            textField_4.getText();


                        // INSERT
                        String sql =
                            "INSERT INTO customers " +
                            "(customer_id, name, email, phone, password) " +
                            "VALUES (?, ?, ?, ?, ?)";


                        PreparedStatement pstmt =
                            con.prepareStatement(sql);


                        pstmt.setInt(
                            1,
                            Integer.parseInt(id)
                        );

                        pstmt.setString(
                            2,
                            name
                        );

                        pstmt.setString(
                            3,
                            email
                        );

                        pstmt.setString(
                            4,
                            phone
                        );

                        pstmt.setString(
                            5,
                            password
                        );


                        pstmt.executeUpdate();


                        System.out.println(
                            "Values inserted"
                        );


                        pstmt.close();

                        con.close();


                    } catch (Exception ex) {

                        ex.printStackTrace();
                    }
                }
            }
        );


        // =========================
        // DELETE BUTTON
        // =========================

        JButton btnDelete =
            new JButton("DELETE");

        btnDelete.setBounds(
            145, 220, 84, 25
        );

        contentPane.add(btnDelete);


        btnDelete.addActionListener(
            new ActionListener() {

                public void actionPerformed(
                    ActionEvent e) {

                    try {

                        Class.forName(
                            "oracle.jdbc.driver.OracleDriver"
                        );


                        Connection con =
                            DriverManager.getConnection(

                                "jdbc:oracle:thin:@localhost:1521:orcl",

                                "bca",
                                "bca"
                            );


                        String id =
                            textField.getText();


                        String sql =
                            "DELETE FROM customers " +
                            "WHERE customer_id = ?";


                        PreparedStatement pstmt =
                            con.prepareStatement(sql);


                        pstmt.setInt(
                            1,
                            Integer.parseInt(id)
                        );


                        int rows =
                            pstmt.executeUpdate();

                        if (rows > 0) {

                            System.out.println(
                                "Customer deleted"
                            );

                        } else {

                            System.out.println(
                                "Customer ID not found"
                            );
                        }


                        pstmt.close();

                        con.close();


                    } catch (Exception ex) {

                        ex.printStackTrace();
                    }
                }
            }
        );


        // =========================
        // UPDATE BUTTON
        // =========================

        JButton btnUpdate =
            new JButton("UPDATE");

        btnUpdate.setBounds(
            250, 220, 84, 25
        );

        contentPane.add(btnUpdate);


        btnUpdate.addActionListener(
            new ActionListener() {

                public void actionPerformed(
                    ActionEvent e) {

                    try {

                        Class.forName(
                            "oracle.jdbc.driver.OracleDriver"
                        );


                        Connection con =
                            DriverManager.getConnection(

                                "jdbc:oracle:thin:@localhost:1521:orcl",

                                "bca",
                                "bca"
                            );


                        // Get values
                        String id =
                            textField.getText();

                        String name =
                            textField_1.getText();

                        String email =
                            comboBox.getSelectedItem().toString();

                        String phone =
                            textField_3.getText();

                        String password =
                            textField_4.getText();


                        // UPDATE
                        String sql =
                            "UPDATE customers SET " +
                            "name = ?, " +
                            "email = ?, " +
                            "phone = ?, " +
                            "password = ? " +
                            "WHERE customer_id = ?";


                        PreparedStatement pstmt =
                            con.prepareStatement(sql);


                        pstmt.setString(
                            1,
                            name
                        );

                        pstmt.setString(
                            2,
                            email
                        );

                        pstmt.setString(
                            3,
                            phone
                        );

                        pstmt.setString(
                            4,
                            password
                        );

                        pstmt.setInt(
                            5,
                            Integer.parseInt(id)
                        );


                        int rows =
                            pstmt.executeUpdate();

                        if (rows > 0) {

                            System.out.println(
                                "Customer updated"
                            );

                        } else {

                            System.out.println(
                                "Customer ID not found"
                            );
                        }


                        pstmt.close();

                        con.close();


                    } catch (Exception ex) {

                        ex.printStackTrace();
                    }
                }
            }
        );


        // =========================
        // CUSTOMER ID
        // =========================

        textField =
            new JTextField();

        textField.setBounds(
            77, 98, 96, 18
        );

        contentPane.add(textField);

        textField.setColumns(10);


        // =========================
        // NAME
        // =========================

        textField_1 =
            new JTextField();

        textField_1.setBounds(
            77, 120, 96, 18
        );

        contentPane.add(textField_1);

        textField_1.setColumns(10);


        // =========================
        // EMAIL COMBOBOX
        // =========================

        comboBox =
            new JComboBox<String>();
        comboBox.setEditable(true);

        comboBox.setBounds(
            77, 141, 96, 20
        );

        contentPane.add(comboBox);


        // Add email options
        comboBox.addItem("ann@gmail.com");
        comboBox.addItem("john@gmail.com");
        comboBox.addItem("feba@gmail.com");
        comboBox.addItem("sona@gmail.com");
        comboBox.addItem("diya@gmail.com");


        // =========================
        // PHONE
        // =========================

        textField_3 =
            new JTextField();

        textField_3.setBounds(
            77, 164, 96, 18
        );

        contentPane.add(textField_3);

        textField_3.setColumns(10);


        // =========================
        // PASSWORD
        // =========================

        textField_4 =
            new JTextField();

        textField_4.setBounds(
            77, 186, 96, 18
        );

        contentPane.add(textField_4);

        textField_4.setColumns(10);

    }
}