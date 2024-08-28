package com.company.panels;

import com.company.base.BasePanel;
import com.company.customUI.BarButton;
import com.company.frames.MainFrame;
import com.company.models.Order;
import com.company.models.Product;
import com.company.models.ProductType;
import database.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class OrderPanel extends BasePanel {
    private final ProductType productType;
    public int tableNumber;
    //orders table
    public JTable ordersTable;
    public static DefaultTableModel ordersTableModel;
    //products table
    public JTable productsTable;
    public DefaultTableModel productsTableModel;
    public Order selectedOrder;
    public ArrayList<Product> products;
    public Product selectedProduct;
    public int currentSelectedProductRow;
    public ArrayList<JButton>productButtons;


    public OrderPanel(MainFrame frame, int tableNumber, ProductType productType) {
        super(frame);
        this.tableNumber = tableNumber;
        this.productType = productType;
        products = Database.getProducts();
        createHeader();
        //orders table
        createOrdersTable();
        createOrdersButtons();
        //products table
        crateProductsTable();
        createProductButtons();
        createSettingsButton();
        refreshOrders();

    }


   public void refreshOrders(){
        frame.dataProvider.refreshOrdersTable(ordersTableModel, this.tableNumber);

    }
    public void loadProducts(){
        frame.dataProvider.loadProducts(productsTableModel,this.selectedOrder);

    }

    public void createProductButtons() {

        int buttonPositionX = 260;
        int buttonPositionY = 50;

        for   (Product product : products)   {
            if(!product.getType().equals(productType))
                continue;
                buttonPositionY += 55;

                BarButton productButton = new BarButton(product.getBrand());
                productButton.product = product;
                productButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (selectedOrder != null ) {
                            boolean isProductFound = false;
                            for (Product product : selectedOrder.getProducts()) {
                                if (product.getUid().equals(((BarButton) e.getSource()).product.getUid())) {
                                    product.increaseProductCount();
                                    isProductFound = true;
                                    break;
                                }
                            }
                            if (!isProductFound) {
                                selectedOrder.getProducts().add(((BarButton) e.getSource()).product);
                            }
                            refreshOrders();
                            loadProducts();

                        } else {
                            showError("No orders for this table");
                        }
                    }
                });
                productButton.setBounds(buttonPositionX, buttonPositionY, 280, 50);
                add(productButton);
            }




    }
    public void createHeader () {
        JLabel tableNumberLabel = new JLabel("Table " + this.tableNumber);
        tableNumberLabel.setBounds(frame.getWidth() / 2 - 50, 10, 100, 40);
        tableNumberLabel.setFont(new Font("Serif", Font.BOLD, 20));
        add(tableNumberLabel);
    }
    public void crateProductsTable(){
        String[] columns = {"Product", "Quantity", "Price"};
        productsTableModel = new DefaultTableModel();
        productsTableModel.setColumnIdentifiers(columns);

        productsTable = new JTable(productsTableModel);
        productsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                currentSelectedProductRow =productsTable.getSelectedRow();
                selectedProduct = selectedOrder.getProducts().get(productsTable.getSelectedRow());
            }
        });


        JScrollPane pane = new JScrollPane(productsTable);
        pane.setBounds(frame.getWidth()-250, 46, 250, 500);
        add(pane);

    }
    public void createSettingsButton(){
        // BACK button
        JButton backButton = new JButton("BACK");
        backButton.setBounds(frame.getWidth()-150,5,150,40);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.router.showProductCategoryPanel(tableNumber);
            }
        });
        add(backButton);

        // + Button
        JButton increaseButton = new JButton("+");
        increaseButton.setBounds(frame.getWidth()-250, 544,44,44);
        increaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                modifyProduct(true,selectedOrder);
            }
        });
        add(increaseButton);

        // - Button
        JButton decreaseButton = new JButton("-");
        decreaseButton.setBounds(frame.getWidth()-200, 544,44,44);
        decreaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                modifyProduct(false,selectedOrder);
            }
        });
        add(decreaseButton);

    }
    public void modifyProduct(boolean isIncreasing,Order selectedOrder){
        if(selectedProduct == null){
            showError("Please select a product!");
            return;
        }
        if(isIncreasing){
            selectedProduct.increaseProductCount();

        } else {
            if(selectedProduct.getCount()==1){
                selectedOrder.getProducts().remove(selectedProduct);

            }else {
                selectedProduct.decreaseProductCount();
            }
        }
        refreshOrders();
        loadProducts();
        if(currentSelectedProductRow >= selectedOrder.getProducts().size()) {
            productsTable.setColumnSelectionInterval(currentSelectedProductRow, currentSelectedProductRow);
        }


    }

    public void createOrdersTable () {
        String columns[] = {"Number", "Products", "Price"};
        ordersTableModel = new DefaultTableModel();
        ordersTableModel.setColumnIdentifiers(columns);

        ordersTable = new JTable(ordersTableModel);
        ordersTable.addMouseListener(new MouseAdapter() {// MouseAdapter- selektirame koito metod si pojelaem
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                selectedOrder = frame.dataProvider.orders.get(ordersTable.getSelectedRow());
                loadProducts();



            }
        });
        JScrollPane pane = new JScrollPane(ordersTable);
        pane.setBounds(0, 46, 250, 500);
        add(pane);


    }// Create order Button and Finish Order Button
    public void createOrdersButtons () {
        JButton createOrderButton = new JButton("Create Order");
        createOrderButton.setBounds(0, 0, 120, 44);
        createOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.router.showProductCategoryPanel(tableNumber);
                int result = showQuestionPopup("Please select product category,to create a new order");
                if(result == JOptionPane.YES_OPTION) {
                    frame.router.showProductCategoryPanel(tableNumber);
                    createOrderAction();

                }if (result == JOptionPane.NO_OPTION){
                    frame.router.showOrdersPanel(tableNumber,null);
                }

            }
        });
        add(createOrderButton);

        JButton finishOrderButton = new JButton("Finish Order");
        finishOrderButton.setBounds(130, 0, 120, 44);
        finishOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(selectedOrder ==null) {
                    showError("No selected order!");
                    return;
                }
                int confirm = showQuestionPopup("Finish order");
                if (confirm == JOptionPane.YES_OPTION) {
                    //creating cash receipt, Request ->Server -> Remove order -> Ok 200
                    frame.dataProvider.orders.remove(selectedOrder);
                    frame.router.showOrdersPanel(tableNumber,null);
                }
            }

        });
        add(finishOrderButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(0, 544, 250, 44);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.router.showTablesPanel();

            }
        });
        add(cancelButton);
    }
    public void createOrderAction() {
            String uid = Integer.toString(frame.dataProvider.orders.size() + 1);
            Order order = new Order(uid, this.tableNumber, new ArrayList<>());
            frame.dataProvider.orders.add(order);
            refreshOrders();

    }
}
