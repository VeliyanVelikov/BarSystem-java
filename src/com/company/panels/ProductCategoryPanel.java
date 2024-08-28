package com.company.panels;

import com.company.base.BasePanel;
import com.company.customUI.BarButton;
import com.company.frames.MainDataProvider;
import com.company.frames.MainFrame;
import com.company.models.Category;
import com.company.models.Order;
import com.company.models.Product;
import com.company.models.ProductType;
import database.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProductCategoryPanel extends BasePanel {
    public int tableNumber;




    public ProductCategoryPanel(MainFrame frame, int tableNumber) {// dobavqme table number ruchno za da go imame kogato otvorim poruchkite na konkretnata masa
        super(frame);
        this.tableNumber = tableNumber;
        createHeader();
        createCategoriesButtons();
        createSettingsButton();

    }
    // Problem found, creates only one initial order on first chosen table-- !!

    public void createFirstOrderAction(int currentTableNumber){
        OrderPanel orderPanel = new OrderPanel(frame,tableNumber,null);

            boolean isThereAnyOrder = frame.dataProvider.orders.contains(new Order(null, currentTableNumber, null));
            if (!isThereAnyOrder) {
                orderPanel.createOrderAction();
            }

    }
    public void testMethod(){

    }


    public void createCategoriesButtons(){

        int buttonPositionX = 260;
        int buttonPositionY = 55;

        BarButton alcoholButton = new BarButton("Alcohol drinks");
        alcoholButton.setBounds(buttonPositionX, buttonPositionY, 280, 50);
        alcoholButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               //createFirstOrderAction(tableNumber);
                frame.router.showOrdersPanel(tableNumber,ProductType.ALCOHOLIC);

                }
            });
            add(alcoholButton);

        BarButton nonAlcoholButton = new BarButton("Non-alcohol drinks");
        nonAlcoholButton.setBounds(buttonPositionX, buttonPositionY+55, 280, 50);
        nonAlcoholButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //createFirstOrderAction(tableNumber);
                frame.router.showOrdersPanel(tableNumber,ProductType.NONALCOHOLIC);
            }
        });
        add(nonAlcoholButton);

        BarButton foodButton = new BarButton("Food");
        foodButton.setBounds(buttonPositionX, buttonPositionY+110, 280, 50);
        foodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //createFirstOrderAction(tableNumber);
                frame.router.showOrdersPanel(tableNumber,ProductType.FOOD);

            }
        });
        add(foodButton);


    }

        public void createHeader () {
            JLabel tableNumberLabel = new JLabel("Table " + this.tableNumber);
            tableNumberLabel.setBounds(frame.getWidth() / 2 - 50, 10, 100, 40);
            tableNumberLabel.setFont(new Font("Serif", Font.BOLD, 20));
            add(tableNumberLabel);
        }

        public void createSettingsButton(){
        // BACK button
        JButton backButton = new JButton("BACK");
        backButton.setBounds(frame.getWidth()-150,5,150,40);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.router.showTablesPanel();
            }
        });
        add(backButton);

        }

}
