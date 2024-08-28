package com.company.panels;

import com.company.base.BasePanel;
import com.company.frames.MainDataProvider;
import com.company.frames.MainFrame;
import com.company.models.User;
import com.company.models.UserType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class NewUserPanel extends BasePanel implements MouseListener {



    public JTextField nameField;
    public JTextField phoneField;
    public JTextField pinField;
    public JRadioButton userType1;
    public JRadioButton userType2;
    public String newUserName;
    public String newPhoneNumber;
    public String newPin;
    public UserType newUserType;




    public NewUserPanel(MainFrame frame) {
        super(frame);
        JLabel newUserPanel = new JLabel("New User");
        newUserPanel.setBounds(frame.getWidth()/2 -50,10,100,40);
        newUserPanel.setHorizontalAlignment(SwingConstants.CENTER);// za horizontalno pozicionirane
        newUserPanel.setFont(new Font("Serif", Font.BOLD, 20));// shrift

        add(newUserPanel);

        nameField = new JTextField("Enter Name");
        nameField.setBounds(frame.getWidth()/2 -250,100,150,40);
        nameField.setHorizontalAlignment(SwingConstants.CENTER);
        nameField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                nameField.setText("");
            }

        });
        add(nameField);

        phoneField = new JTextField("Enter Phone");
        phoneField.setBounds(frame.getWidth()/2 -250,160,150,40);
        phoneField.setHorizontalAlignment(SwingConstants.CENTER);
        phoneField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                phoneField.setText("");

            }
        });
        add(phoneField);

        pinField = new JTextField("Enter PIN");
        pinField.setBounds(frame.getWidth()/2 -250,220,150,40);
        pinField.setHorizontalAlignment(SwingConstants.CENTER);
        pinField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                pinField.setText("");
            }
        });
        add(pinField);

        userType1 = new JRadioButton("Manager");
        userType1.setBounds(frame.getWidth()/2 -260,280,150,40);
        userType1.setHorizontalAlignment(SwingConstants.CENTER);
        userType1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newUserType = UserType.MANAGER;

            }
        });
        add(userType1);

        userType2 = new JRadioButton("Waitress");
        userType2.setBounds(frame.getWidth()/2 -260,340,150,40);
        userType2.setHorizontalAlignment(SwingConstants.CENTER);
        userType2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newUserType = UserType.WAITRESS;


            }
        });
        add(userType2);

        ButtonGroup userType = new ButtonGroup();
        userType.add(userType1);
        userType.add(userType2);


        JButton saveNewUserButton = new JButton("Save");
        saveNewUserButton.setBounds(frame.getWidth()/2 -75,100,150,40);
        saveNewUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                newUserName = frame.dataProvider.CheckField(nameField.getText(),"Name is Required");
                newPhoneNumber = frame.dataProvider.CheckField(phoneField.getText(),"Phone Number is Required");
                newPin = frame.dataProvider.CheckField(pinField.getText(),"Pin is Required");


                if (userType1.isSelected()){
                    newUserType = UserType.MANAGER;
                }
                else if(userType2.isSelected()){
                    newUserType = UserType.WAITRESS;
                }
                else {
                    showError("Please select User Type");
                }
                frame.dataProvider.addNewUser(newUserName,newPhoneNumber,newPin,newUserType);


            }
        });
        add(saveNewUserButton);

        JButton backButton = new JButton("BACK");
        backButton.setBounds(frame.getWidth()/2 -75,500,150,40);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.router.showLoginPanel();

            }
        });
        add(backButton);


    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
