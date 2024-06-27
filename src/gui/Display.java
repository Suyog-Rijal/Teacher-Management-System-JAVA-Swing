package gui;

import functions.Teacher;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

public class Display {
    public Display(ArrayList<Teacher> teachers) {
        JFrame frame = new JFrame("Display");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1100, 600);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        String[] column = {"ID", "Name", "Address", "Type", "Emp status"};
        String[][] data = new String[teachers.size()][5];
        for (Teacher teacher : teachers) {
            data[teachers.indexOf(teacher)][0] = String.valueOf(teacher.getTeacherID());
            data[teachers.indexOf(teacher)][1] = teacher.getTeacherName();
            data[teachers.indexOf(teacher)][2] = teacher.getAddress();
            data[teachers.indexOf(teacher)][3] = teacher instanceof functions.Lecturer ? "Lecturer" : "Tutor";
            data[teachers.indexOf(teacher)][4] = teacher.getEmploymentStatus();
        }

        JTable jt = new JTable(data, column);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int x = 0; x < column.length; x++) {
            jt.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
        }

        jt.setSize(frame.getWidth(), frame.getHeight());
        jt.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane sp = new JScrollPane(jt);
        panel.add(sp, BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);
    }

}
