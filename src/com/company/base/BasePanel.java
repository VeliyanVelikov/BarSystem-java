package com.company.base;

import com.company.frames.MainDataProvider;
import com.company.frames.MainFrame;
import com.company.models.Order;
import com.company.models.ProductType;
import com.company.panels.OrderPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// Base panela vkluchva clasove koito se izpolzvat vuv vsichki paneli
public class BasePanel extends JPanel {


    public static MainFrame frame;
    int tableNumber;

    public BasePanel (MainFrame frame){
        setLayout(null);// za ruchno pozicionirane na prozoreca
        this.frame = frame;
    }
    public void showError(String message){
        JOptionPane.showMessageDialog(null, message, "Error",JOptionPane.ERROR_MESSAGE);
    }
    public int showQuestionPopup(String message){
        int result = JOptionPane.showConfirmDialog(null,message,"Attention required",JOptionPane.YES_NO_OPTION);
        if(result == JOptionPane.YES_OPTION){
        }return result;

    }


}
