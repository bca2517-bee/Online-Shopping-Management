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


public class Orders extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JTable table;

    private JTextField textField;      // Order ID
    private JTextField textField_1;    // Order Date
    private JTextField textField_2;    // Quantity

    private JComboBox<String> comboBox;    // Customer ID
    private JComboBox<String> comboBox_1;  // Product ID


    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {

                    Orders frame = new Orders();
                    frame.setVisible(true);

                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
        });
    }


    public Orders() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(100, 100, 600, 350);


        // =========================
        // PANEL
        // =========================

        contentPane = new JPanel();

        contentPane.setBackground(
            new Color(173, 216, 230)
        );

        contentPane.setBorder(
            new EmptyBorder(5, 5, 5, 5)
        );

        setContentPane(contentPane);

        contentPane.setLayout(null);


        // =========================
        // TABLE
        // =========================

        JScrollPane scrollPane =
            new JScrollPane();

        scrollPane.setBounds(
            194, 71, 370, 139
        );

        contentPane.add(scrollPane);


        table = new JTable();

        table.setModel(
            new DefaultTableModel(

                new Object[][] {},

                new String[] {
                    "Order_id",
                    "Customer_id",
                    "Product_id",
                    "Order_date",
                    "Quantity"
                }
            )
        );

        scrollPane.setViewportView(table);


        // =========================
        // TITLE
        // =========================

        JLabel lblTitle =
            new JLabel("ORDER OPERATIONS");

        lblTitle.setForeground(
            new Color(0, 0, 0)
        );

        lblTitle.setBackground(
            new Color(255, 255, 255)
        );

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
                            "SELECT * FROM orders";


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

        JLabel lblOrderId =
            new JLabel("Order_id");

        lblOrderId.setBounds(
            20, 101, 70, 12
        );

        contentPane.add(lblOrderId);


        JLabel lblCustomerId =
            new JLabel("Customer_id");

        lblCustomerId.setBounds(
            20, 123, 80, 12
        );

        contentPane.add(lblCustomerId);


        JLabel lblProductId =
            new JLabel("Product_id");

        lblProductId.setBounds(
            20, 145, 70, 12
        );

        contentPane.add(lblProductId);


        JLabel lblOrderDate =
            new JLabel("Order_date");

        lblOrderDate.setBounds(
            20, 167, 70, 12
        );

        contentPane.add(lblOrderDate);


        JLabel lblQuantity =
            new JLabel("Quantity");

        lblQuantity.setBounds(
            20, 189, 60, 12
        );

        contentPane.add(lblQuantity);


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

                        String customerId =
                            comboBox.getSelectedItem().toString();

                        String productId =
                            comboBox_1.getSelectedItem().toString();

                        String orderDate =
                            textField_1.getText();

                        String quantity =
                            textField_2.getText();


                        // INSERT

                        String sql =
                            "INSERT INTO orders " +
                            "(order_id, customer_id, product_id, order_date, quantity) " +
                            "VALUES (?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?)";


                        PreparedStatement pstmt =
                            con.prepareStatement(sql);


                        pstmt.setInt(
                            1,
                            Integer.parseInt(id)
                        );

                        pstmt.setInt(
                            2,
                            Integer.parseInt(customerId)
                        );

                        pstmt.setInt(
                            3,
                            Integer.parseInt(productId)
                        );

                        pstmt.setString(
                            4,
                            orderDate
                        );

                        pstmt.setInt(
                            5,
                            Integer.parseInt(quantity)
                        );


                        pstmt.executeUpdate();


                        System.out.println(
                            "Order inserted"
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
                            "DELETE FROM orders " +
                            "WHERE order_id = ?";


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
                                "Order deleted"
                            );

                        } else {

                            System.out.println(
                                "Order ID not found"
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

                        String customerId =
                            comboBox.getSelectedItem().toString();

                        String productId =
                            comboBox_1.getSelectedItem().toString();

                        String orderDate =
                            textField_1.getText();

                        String quantity =
                            textField_2.getText();


                        // UPDATE

                        String sql =
                            "UPDATE orders SET " +
                            "customer_id = ?, " +
                            "product_id = ?, " +
                            "order_date = TO_DATE(?, 'YYYY-MM-DD'), " +
                            "quantity = ? " +
                            "WHERE order_id = ?";


                        PreparedStatement pstmt =
                            con.prepareStatement(sql);


                        pstmt.setInt(
                            1,
                            Integer.parseInt(customerId)
                        );

                        pstmt.setInt(
                            2,
                            Integer.parseInt(productId)
                        );

                        pstmt.setString(
                            3,
                            orderDate
                        );

                        pstmt.setInt(
                            4,
                            Integer.parseInt(quantity)
                        );

                        pstmt.setInt(
                            5,
                            Integer.parseInt(id)
                        );


                        int rows =
                            pstmt.executeUpdate();


                        if (rows > 0) {

                            System.out.println(
                                "Order updated"
                            );

                        } else {

                            System.out.println(
                                "Order ID not found"
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
        // ORDER ID
        // =========================

        textField =
            new JTextField();

        textField.setBounds(
            105, 98, 68, 18
        );

        contentPane.add(textField);

        textField.setColumns(10);


        // =========================
        // CUSTOMER ID COMBOBOX
        // =========================

        comboBox =
            new JComboBox<String>();

        comboBox.setEditable(true);

        comboBox.setBounds(
            105, 120, 68, 20
        );

        contentPane.add(comboBox);


        comboBox.addItem("1");
        comboBox.addItem("2");
        comboBox.addItem("3");
        comboBox.addItem("4");
        comboBox.addItem("5");


        // =========================
        // PRODUCT ID COMBOBOX
        // =========================

        comboBox_1 =
            new JComboBox<String>();

        comboBox_1.setEditable(true);

        comboBox_1.setBounds(
            105, 141, 68, 20
        );

        contentPane.add(comboBox_1);


        comboBox_1.addItem("1");
        comboBox_1.addItem("2");
        comboBox_1.addItem("3");
        comboBox_1.addItem("4");
        comboBox_1.addItem("5");


        // =========================
        // ORDER DATE
        // =========================

        textField_1 =
            new JTextField();

        textField_1.setBounds(
            105, 164, 68, 18
        );

        contentPane.add(textField_1);

        textField_1.setColumns(10);


        // =========================
        // QUANTITY
        // =========================

        textField_2 =
            new JTextField();

        textField_2.setBounds(
            105, 186, 68, 18
        );

        contentPane.add(textField_2);

        textField_2.setColumns(10);


        // =========================
        // BACK BUTTON
        // =========================

        JButton btnNewButton =
            new JButton("BACK");

        btnNewButton.addActionListener(
            new ActionListener() {

                public void actionPerformed(
                    ActionEvent e) {

                    Db_operations db =
                        new Db_operations();

                    db.setVisible(true);

                    dispose();
                }
            }
        );


        btnNewButton.setBounds(
            10, 283, 84, 20
        );

        contentPane.add(btnNewButton);

    }
}