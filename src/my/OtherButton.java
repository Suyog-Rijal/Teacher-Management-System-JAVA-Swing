package my;

import javax.swing.*;

public class OtherButton extends JButton {
    public OtherButton(String text) {
        super(text);
        this.setBackground(new java.awt.Color(0, 0, 0));
        this.setForeground(new java.awt.Color(255, 255, 255));
        this.setFont(new java.awt.Font("Arial", 1, 18));
        this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        this.setFocusPainted(false);
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        this.setPreferredSize(new java.awt.Dimension(150, 30));
        UIManager.put("Button.select", new java.awt.Color(66, 66, 66));
    }
}
