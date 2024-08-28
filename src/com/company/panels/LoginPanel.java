package com.company.panels;

import com.company.base.BasePanel;
import com.company.frames.MainFrame;
import com.company.models.UserType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPanel extends BasePanel {

    public JTextField pinField;
    public JButton loginButton;
    public JButton newUserButton;


    public LoginPanel(MainFrame frame) {
        super(frame);
        JLabel loginLabel = new JLabel("Bar System");
        loginLabel.setBounds(frame.getWidth()/2 -50,10,100,40);
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);// za horizontalno pozicionirane
        loginLabel.setFont(new Font("Serif", Font.BOLD, 20));// shrift



        add(loginLabel);

        pinField = new JTextField("Enter PASSWORD");
        pinField.setBounds(frame.getWidth()/2 -75,60,150,40);
        pinField.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldRemoval();
        add(pinField);

        JButton loginButton = new JButton("LOGIN");
        loginButton.setBounds(frame.getWidth()/2 -75,100,150,40);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (frame.dataProvider.isPinCorrect(pinField.getText())){
                    frame.router.showTablesPanel();
                }
                else if (frame.dataProvider.isEmpty(pinField.getText())){
                    showError("This field cannot be empty");
                }
                else{
                    showError("Pin is not corrected");
                }
            }
        });
        add(loginButton);

        JButton newUserButton = new JButton("New User ");
        newUserButton.setBounds(frame.getWidth()/2-75, 150,150,40);
        newUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(frame.dataProvider.isManager(pinField.getText())){
                     frame.router.showNewUserPanel();
                 }
                else if (frame.dataProvider.isEmpty(pinField.getText())){
                    showError("This field cannot be empty");
                }
                else{
                    showError("Only Managers have access!");
                }
            }

        });
        add(newUserButton);

    }
    public void textFieldRemoval(){
        pinField.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pinField.setText("");
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
        });
    }
}
