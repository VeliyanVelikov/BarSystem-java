package com.company.customUI;

import com.company.models.Product;

import javax.swing.*;

public class BarButton extends JButton {

    public Product product;

    public BarButton(String title){ // juzdavame nov tip buton koito da zamesti Jbutton

        super(title);
    }
}
