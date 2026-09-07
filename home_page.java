package DBpgms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class home_page extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;


    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {

                	home_page frame = new home_page();
                    frame.setVisible(true);

                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
        });
    }


    public home_page() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(
            100,
            100,
            500,
            350
        );


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
        // TITLE
        // =========================

        JLabel lblTitle =
            new JLabel("ONLINE SHOPPING MANAGEMENT SYSTEM");

        lblTitle.setFont(
            new Font("Tahoma", Font.BOLD, 16)
        );

        lblTitle.setBounds(
            76,
            41,
            362,
            30
        );

        contentPane.add(lblTitle);


        // =========================
        // HOME LABEL
        // =========================

        JLabel lblHome =
            new JLabel("HOME PAGE");

        lblHome.setFont(
            new Font("Tahoma", Font.BOLD, 15)
        );

        lblHome.setBounds(
            195,
            81,
            93,
            25
        );

        contentPane.add(lblHome);


        // =========================
        // CUSTOMERS BUTTON
        // =========================

        JButton btnCustomers =
            new JButton("CUSTOMERS");

        btnCustomers.setBounds(
            170,
            125,
            150,
            30
        );

        contentPane.add(btnCustomers);


        btnCustomers.addActionListener(
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


        // =========================
        // PRODUCTS BUTTON
        // =========================

        JButton btnProducts =
            new JButton("PRODUCTS");

        btnProducts.setBounds(
            170,
            170,
            150,
            30
        );

        contentPane.add(btnProducts);


        btnProducts.addActionListener(
            new ActionListener() {

                public void actionPerformed(
                    ActionEvent e) {

                    Products products =
                        new Products();

                    products.setVisible(true);

                    dispose();
                }
            }
        );


        // =========================
        // ORDERS BUTTON
        // =========================

        JButton btnOrders =
            new JButton("ORDERS");

        btnOrders.setBounds(
            170,
            215,
            150,
            30
        );

        contentPane.add(btnOrders);


        btnOrders.addActionListener(
            new ActionListener() {

                public void actionPerformed(
                    ActionEvent e) {

                    Orders orders =
                        new Orders();

                    orders.setVisible(true);

                    dispose();
                }
            }
        );


        // =========================
        // BACK BUTTON
        // =========================

        JButton btnBack =
            new JButton("BACK");

        btnBack.setBounds(
            10,
            280,
            84,
            20
        );

        contentPane.add(btnBack);


        btnBack.addActionListener(
            new ActionListener() {

                public void actionPerformed(
                    ActionEvent e) {

                    Login login =
                        new Login();

                    login.setVisible(true);

                    dispose();
                }
            }
        );

    }
}