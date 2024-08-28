package com.company.frames;

import com.company.models.ProductType;
import com.company.panels.*;

public class MainRouter {
    // tozi class sudurja methodi za pokazvane na vsichki paneli
    public MainFrame currentFrame;

    public MainRouter(MainFrame currentFrame){

        this.currentFrame = currentFrame;
    }
    public void showLoginPanel(){
        LoginPanel login = new LoginPanel(this.currentFrame);
        this.currentFrame.setContentPane(login);
        this.currentFrame.validate();

    }
    public void showTablesPanel(){
        TablesPanel tables = new TablesPanel(this.currentFrame);
        this.currentFrame.setContentPane(tables);
        this.currentFrame.validate();
    }
    public void showOrdersPanel(int tableNumber, ProductType productType){
        OrderPanel orders = new OrderPanel(this.currentFrame,tableNumber,productType);
        this.currentFrame.setContentPane(orders);
        this.currentFrame.validate();

    }
    public void showNewUserPanel(){
        NewUserPanel newUser = new NewUserPanel(this.currentFrame);
        this.currentFrame.setContentPane(newUser);
        this.currentFrame.validate();
    }
    public void showProductCategoryPanel(int tableNumber){
        ProductCategoryPanel product = new ProductCategoryPanel(this.currentFrame,tableNumber);
        this.currentFrame.setContentPane(product);
        this.currentFrame.validate();
    }

}
