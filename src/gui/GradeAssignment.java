package gui;

import functions.Lecturer;
import functions.Teacher;
import my.OtherButton;
import my.OtherLabels;
import my.OtherTextFields;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GradeAssignment {
    private JPanel panel = new JPanel();
    private JPanel header = new JPanel();
    private JLabel addLecturer = new JLabel("Grade the Assignment");
    private JLabel teacherIDLabel = new OtherLabels("Teacher ID:");
    private JTextField teacherIDField = new OtherTextFields();
    private JLabel gradedScoreLabel = new OtherLabels("Graded Score:");
    private JTextField gradedScoreField = new OtherTextFields();
    private JLabel departmentLabel = new OtherLabels("Department:");
    private JTextField departmentField = new OtherTextFields();
    private JLabel yearsOfExperienceLabel = new OtherLabels("Years of Experience:");
    private JTextField yearsOfExperienceField = new OtherTextFields();
    private JButton grade = new OtherButton("Grade");
    private JButton clear = new OtherButton("Clear");

    public GradeAssignment(ArrayList<Teacher> teachers){
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
        panel.add(gradedScoreLabel, gbc);
        gbc.gridx = 1;
        panel.add(gradedScoreField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(departmentLabel, gbc);
        gbc.gridx = 1;
        panel.add(departmentField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(yearsOfExperienceLabel, gbc);
        gbc.gridx = 1;
        panel.add(yearsOfExperienceField, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(grade, gbc);
        gbc.gridx = 1;
        panel.add(clear, gbc);

        frame.add(header, BorderLayout.NORTH);
        frame.add(panel);
        frame.setResizable(false);
        frame.setVisible(true);

        grade.addActionListener(e-> {
            try {
                int teacherID = Integer.parseInt(teacherIDField.getText());
                int gradedScore = Integer.parseInt(gradedScoreField.getText());
                String department = departmentField.getText();
                int yearsOfExperience = Integer.parseInt(yearsOfExperienceField.getText());

                if (teacherIDField.getText().isEmpty() || gradedScoreField.getText().isEmpty() || departmentField.getText().isEmpty() || yearsOfExperienceField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields!!");
                    return;
                }

                boolean teacherFound = false;
                for(Teacher teacher : teachers) {
                    if (teacher instanceof Lecturer && teacher.getTeacherID() == teacherID) {
                        ((Lecturer) teacher).setDepartment(department);
                         String message = ((Lecturer) teacher).gradeAssignment(gradedScore, department, yearsOfExperience);
                        JOptionPane.showMessageDialog(null, message);
                        clear();
                        teacherFound = true;
                        break;
                    }
                }

                if (!teacherFound) {
                    JOptionPane.showMessageDialog(null, "The teacher with Teacher-id: " + teacherID + " doesn't exist!!");
                }

            } catch (Exception ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(null, "Please enter the correct data!!");
            }
        });

        clear.addActionListener(e -> clear());
    }

    public void clear() {
        teacherIDField.setText("");
        gradedScoreField.setText("");
        departmentField.setText("");
        yearsOfExperienceField.setText("");
    }
}
