package gui;

import functions.Teacher;
import functions.Tutor;
import my.OtherButton;
import my.OtherLabels;
import my.OtherTextFields;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RemoveTutor {
    private JPanel panel = new JPanel();
    private JPanel header = new JPanel();
    private JLabel addLecturer = new JLabel("Remove Tutor");
    private JLabel teacherIDLabel = new OtherLabels("Teacher ID:");
    private JTextField teacherIDField = new OtherTextFields();
    private JButton remove = new OtherButton("Remove");
    private JButton clear = new OtherButton("Clear");

    public RemoveTutor(ArrayList<Teacher> teachers) {
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
        gbc.insets = new Insets(0, 10, 70, 10);
        panel.add(teacherIDLabel, gbc);
        gbc.gridx = 1;
        panel.add(teacherIDField, gbc);


        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(remove, gbc);
        gbc.gridx = 1;
        panel.add(clear, gbc);

        frame.add(header, BorderLayout.NORTH);
        frame.add(panel);
        frame.setResizable(false);
        frame.setVisible(true);

        remove.addActionListener(e-> {
            try {
                int teacherID = Integer.parseInt(teacherIDField.getText());
                boolean teacherFound = false;
                for (Teacher teacher : teachers) {
                    if (teacher instanceof Tutor && teacher.getTeacherID() == teacherID) {
                        teachers.remove(teacher);
                        JOptionPane.showMessageDialog(null, "Tutor removed successfully");
                        clear();
                        teacherFound = true;
                        break;
                    }
                }

                if (!teacherFound) {
                    JOptionPane.showMessageDialog(null, "Teacher not found");
                    clear();
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid data!!");
            }
        });

    }

    public void clear() {
        teacherIDField.setText("");
    }
}
