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


public class Products extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JTable table;

    private JTextField textField;      // Product ID
    private JTextField textField_1;    // Product Name
    private JTextField textField_2;    // Price
    private JTextField textField_3;    // Quantity


    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {

                    Products frame = new Products();
                    frame.setVisible(true);

                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
        });
    }


    public Products() {

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
                    "Product_id",
                    "Product_name",
                    "Price",
                    "Quantity"
                }
            )
        );

        scrollPane.setViewportView(table);


        // =========================
        // TITLE
        // =========================

        JLabel lblTitle =
            new JLabel("PRODUCT OPERATIONS");

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
            212, 29, 220, 18
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

                                "your username",
                                "your password"
                            );


                        String sql =
                            "SELECT * FROM products";


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

        JLabel lblProductId =
            new JLabel("Product_id");

        lblProductId.setBounds(
            20, 101, 70, 12
        );

        contentPane.add(lblProductId);


        JLabel lblProductName =
            new JLabel("Product_name");

        lblProductName.setBounds(
            20, 123, 80, 12
        );

        contentPane.add(lblProductName);


        JLabel lblPrice =
            new JLabel("Price");

        lblPrice.setBounds(
            20, 145, 44, 12
        );

        contentPane.add(lblPrice);


        JLabel lblQuantity =
            new JLabel("Quantity");

        lblQuantity.setBounds(
            20, 167, 60, 12
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

                                "your username",
                                "your password"
                            );


                        // Get values

                        String id =
                            textField.getText();

                        String name =
                            textField_1.getText();

                        String price =
                            textField_2.getText();

                        String quantity =
                            textField_3.getText();


                        // INSERT

                        String sql =
                            "INSERT INTO products " +
                            "(product_id, product_name, price, quantity) " +
                            "VALUES (?, ?, ?, ?)";


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

                        pstmt.setDouble(
                            3,
                            Double.parseDouble(price)
                        );

                        pstmt.setInt(
                            4,
                            Integer.parseInt(quantity)
                        );


                        pstmt.executeUpdate();


                        System.out.println(
                            "Product inserted"
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

                                "your username",
                                "your password"
                            );


                        String id =
                            textField.getText();


                        String sql =
                            "DELETE FROM products " +
                            "WHERE product_id = ?";


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
                                "Product deleted"
                            );

                        } else {

                            System.out.println(
                                "Product ID not found"
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

                                "your username",
                                "your password"
                            );


                        // Get values

                        String id =
                            textField.getText();

                        String name =
                            textField_1.getText();

                        String price =
                            textField_2.getText();

                        String quantity =
                            textField_3.getText();


                        // UPDATE

                        String sql =
                            "UPDATE products SET " +
                            "product_name = ?, " +
                            "price = ?, " +
                            "quantity = ? " +
                            "WHERE product_id = ?";


                        PreparedStatement pstmt =
                            con.prepareStatement(sql);


                        pstmt.setString(
                            1,
                            name
                        );

                        pstmt.setDouble(
                            2,
                            Double.parseDouble(price)
                        );

                        pstmt.setInt(
                            3,
                            Integer.parseInt(quantity)
                        );

                        pstmt.setInt(
                            4,
                            Integer.parseInt(id)
                        );


                        int rows =
                            pstmt.executeUpdate();


                        if (rows > 0) {

                            System.out.println(
                                "Product updated"
                            );

                        } else {

                            System.out.println(
                                "Product ID not found"
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
        // PRODUCT ID
        // =========================

        textField =
            new JTextField();

        textField.setBounds(
            105, 98, 68, 18
        );

        contentPane.add(textField);

        textField.setColumns(10);


        // =========================
        // PRODUCT NAME
        // =========================

        textField_1 =
            new JTextField();

        textField_1.setBounds(
            105, 120, 68, 18
        );

        contentPane.add(textField_1);

        textField_1.setColumns(10);


        // =========================
        // PRICE
        // =========================

        textField_2 =
            new JTextField();

        textField_2.setBounds(
            105, 142, 68, 18
        );

        contentPane.add(textField_2);

        textField_2.setColumns(10);


        // =========================
        // QUANTITY
        // =========================

        textField_3 =
            new JTextField();

        textField_3.setBounds(
            105, 164, 68, 18
        );

        contentPane.add(textField_3);

        textField_3.setColumns(10);


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
