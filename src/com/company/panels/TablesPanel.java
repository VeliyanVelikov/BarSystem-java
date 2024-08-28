package com.company.panels;

import com.company.base.BasePanel;
import com.company.frames.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TablesPanel extends BasePanel implements ActionListener {
    public int numRows = (int) Math.ceil((double) frame.dataProvider.tables.size() / 5);
    public TablesPanel(MainFrame frame) {
        super(frame);

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < 5; col++) {
                int buttonPositionX = 255 + col * 60;
                int buttonPositionY = frame.getHeight() / 2 + (row * 100) - 300;

                int buttonIndex = row * 5 + col+1;

                for(int i =0 ; i<frame.dataProvider.tables.size(); i++) {
                    if(buttonIndex <= frame.dataProvider.tables.size()) {

                    JButton tableButton = new JButton(Integer.toString(buttonIndex));
                    tableButton.addActionListener(this);
                    tableButton.setBounds(buttonPositionX, buttonPositionY, 50, 50);
                    add(tableButton);
                    }else
                        break;
                }
            }
        }

        JButton backButton = new JButton("BACK");
        int positionLastTableY = frame.getHeight() / 2 + (numRows * 100) - 300;
        backButton.setBounds(frame.getWidth()/2 -75,positionLastTableY,150,40);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.router.showLoginPanel();

            }
        });
        add(backButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int tableNumber = Integer.parseInt(((JButton)e.getSource()).getText());
        frame.router.showProductCategoryPanel(tableNumber);



    }

}
