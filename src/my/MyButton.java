package my;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButton extends JButton {
    public MyButton(String text) {
        super(text);
        this.setBackground(new java.awt.Color(0, 0, 0));
        this.setForeground(new java.awt.Color(255, 255, 255));
        this.setFont(new java.awt.Font("Arial", 1, 16));
        this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        this.setFocusPainted(false);
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        this.setPreferredSize(new java.awt.Dimension(200, 50));
        UIManager.put("Button.select", new java.awt.Color(66, 66, 66));
    }
}
