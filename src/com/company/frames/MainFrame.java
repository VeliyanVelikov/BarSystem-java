package com.company.frames;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    public MainDataProvider dataProvider;
    public MainRouter router;
    public MainFrame(){
        super("Bar System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,800);
        dataProvider = new MainDataProvider(this);//suzdavame dataProvider
        dataProvider.fetchUsers();//zarejdame arreylistite
        dataProvider.fetchTables();
        dataProvider.fetchCategories();
        dataProvider.orders = new ArrayList<>();
        //first panel to be loaded on start
        router = new MainRouter(this);//suzdavame ruter
        router.showLoginPanel();

        setLocationRelativeTo(null);
        setVisible(true);

    }
}


