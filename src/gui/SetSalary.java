package gui;

import functions.Teacher;
import functions.Tutor;
import my.OtherButton;
import my.OtherLabels;
import my.OtherTextFields;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SetSalary {
    private JPanel panel = new JPanel();
    private JPanel header = new JPanel();
    private JLabel addLecturer = new JLabel("Set New Salary");
    private JLabel teacherIDLabel = new OtherLabels("Teacher ID:");
    private JTextField teacherIDField = new OtherTextFields();
    private JLabel newSalaryLabel = new OtherLabels("New Salary:");
    private JTextField newSalaryField = new OtherTextFields();
    private JLabel newPerformanceIndexLabel = new OtherLabels("New Perf Index:");
    private JTextField newPerformanceIndexField = new OtherTextFields();
    private JButton add = new OtherButton("Set");
    private JButton clear = new OtherButton("Clear");

    public SetSalary(ArrayList<Teacher> teachers) {
        JFrame frame = new JFrame("Add Lecturer");
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        GridBagConstraints gbc = new GridBagConstraints();

        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        addLecturer.setFont(new Font("Arial", Font.BOLD, 30));
        addLecturer.setBorder(BorderFactory.createEmptyBorder(20, 10, 0, 10));
        header.add(addLecturer);


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 10, 30, 10);
        panel.add(teacherIDLabel, gbc);
        gbc.gridx = 1;
        panel.add(teacherIDField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(newSalaryLabel, gbc);
        gbc.gridx = 1;
        panel.add(newSalaryField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(newPerformanceIndexLabel, gbc);
        gbc.gridx = 1;
        panel.add(newPerformanceIndexField, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(add, gbc);
        gbc.gridx = 1;
        panel.add(clear, gbc);

        frame.add(header, BorderLayout.NORTH);
        frame.add(panel);
        frame.setResizable(false);
        frame.setVisible(true);

        add.addActionListener(e-> {
            if (teacherIDField.getText().isEmpty() || newSalaryField.getText().isEmpty() || newPerformanceIndexField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields.");
                return;
            }

            try {
                int teacherID = Integer.parseInt(teacherIDField.getText());
                double newSalary = Double.parseDouble(newSalaryField.getText());
                int newPerformanceIndex = Integer.parseInt(newPerformanceIndexField.getText());

                boolean teacherFound = false;
                for (Teacher teacher : teachers) {
                    if (teacher.getTeacherID() == teacherID) {
                        if (teacher instanceof Tutor) {
                            String message = ((Tutor) teacher).setSalaryWithAppraisal(newSalary, newPerformanceIndex);
                            JOptionPane.showMessageDialog(null, message);
                            clear();
                            teacherFound = true;
                            break;
                        }
                    }
                }

                if (!teacherFound) {
                    JOptionPane.showMessageDialog(null, "Teacher not found");
                    clear();
                }
            } catch (Exception ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(null, "Please enter a valid data!!");
            }
        });

        clear.addActionListener(e -> clear());

    }

    public void clear() {
        teacherIDField.setText("");
        newSalaryField.setText("");
        newPerformanceIndexField.setText("");
    }
}
