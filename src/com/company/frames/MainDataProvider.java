package com.company.frames;

import com.company.base.BasePanel;
import com.company.models.*;
import com.company.panels.NewUserPanel;
import database.Database;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class MainDataProvider {
    // All type of date (including server requests )
    public MainFrame currentFrame;
    public ArrayList<User>users;
    public ArrayList<Integer>tables;
    public ArrayList<Order>orders;
    public ArrayList<Category>categories;
    private com.company.frames.MainFrame MainFrame;
    BasePanel basePanel = new BasePanel(MainFrame);


    public MainDataProvider(MainFrame currentFrame){

        this.currentFrame = currentFrame;
    }
    public void fetchUsers(){
        users = new ArrayList<>();
        User user1 = new User("Georgi todorov","0888483948", "0101", UserType.WAITRESS);
        User user2 = new User("Petur vasilev","088d234328", "0102", UserType.WAITRESS);
        User user3 = new User("Georgi todorov","08883456765", "0103", UserType.MANAGER);
        users.add(user1);
        users.add(user2);
        users.add(user3);
    }
    public void fetchCategories(){
        this.categories = Database.getCategories();

    }
    public void addNewUser(String newUserName, String newUserPhone, String newUserPin, UserType newUserType){
        users.add(new User(newUserName,newUserPhone,newUserPin,newUserType));


    }

    public void fetchTables(){
        tables = new ArrayList<>();
        tables.add(1);
        tables.add(2);
        tables.add(3);
        tables.add(4);
        tables.add(5);
        tables.add(6);
        tables.add(7);
        tables.add(8);
        tables.add(9);
        tables.add(10);
        tables.add(11);
        tables.add(12);


    }
    public boolean isPinCorrect(String pinCode){
        for(User user : users){
            if (user.getPin().equals(pinCode)){
                return true;
            }
        }
        return false;
    }

    public boolean isManager(String pinCode) {
        for (User user : users){
            if(user.getPin().equals(pinCode) && user.getType() ==(UserType.MANAGER)){
                return true;
            }
        }
        return false;

    }
    public boolean isEmpty(String textFieldContent){
        if(textFieldContent.isEmpty()){
            return true;
        }
        return false;
    }


    public  void refreshOrdersTable(DefaultTableModel model, int tableNumber){
        model.setRowCount(0);
        for(Order order :this.orders){
            if(order.getTableNumber() == tableNumber) {
                String row[] = new String[3];
                row[0] = order.getUid();
                row[1] = order.getProductCount();
                row[2] = order.getTotalAmountString();
                model.addRow(row);
            }
        }
    }
    public void loadProducts(DefaultTableModel model, Order order){
        model.setRowCount(0);// za da ne se dyblirat productite s vsqko clickane
        for (Product product : order.getProducts()){
            String row[] = new String[3];
            row[0] = product.getBrand();
            row[1] = product.getCountString();
            row[2] = product.getTotalPriceString();
            model.addRow(row);

        }

    }
    public String CheckField(String textFieldContent, String massage ){

        if(textFieldContent.isEmpty()) {
            basePanel.showError(massage);
            return null;
        }else {
            return textFieldContent;
        }
    }


}
