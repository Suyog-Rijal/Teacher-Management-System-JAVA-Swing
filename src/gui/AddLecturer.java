package gui;

import functions.Lecturer;
import functions.Teacher;
import my.OtherButton;
import my.OtherLabels;
import my.OtherTextFields;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;


public class AddLecturer {
    private JPanel panel = new JPanel();
    private JPanel header = new JPanel();
    private JLabel addLecturer = new JLabel("Add Lecturer");
    private JLabel teacherIDLabel = new OtherLabels("Teacher ID:");
    private JTextField teacherIDField = new OtherTextFields();
    private JLabel teacherNameLabel = new OtherLabels("Teacher Name:");
    private JTextField teacherNameField = new OtherTextFields();
    private JLabel teacherAddressLabel = new OtherLabels("Teacher Address:");
    private JTextField teacherAddressField = new OtherTextFields();
    private JLabel workingTypeLabel = new OtherLabels("Working Type:");
    private JComboBox<String> workingTypeField = new JComboBox<>(new String[]{"Full-time", "Part-time", "External", "Visiting"});
    private JLabel employmentStatusLabel = new OtherLabels("Employment Status:");
    private JComboBox<String> employmentStatusField = new JComboBox<>(new String[]{"Employed", "Unemployed", "Retired", "Partially Employed", "Fully-time Employed"});
    private JLabel gradedScoreLabel = new OtherLabels("Graded Score:");
    private JTextField gradedScoreField = new OtherTextFields();
    private JLabel yearsOfExperienceLabel = new OtherLabels("Years of Experience:");
    private JTextField yearsOfExperienceField = new OtherTextFields();
    private JButton add = new OtherButton("Add");
    private JButton clear = new OtherButton("Clear");
    private JButton display = new OtherButton("Display");

    public AddLecturer(ArrayList<Teacher> teachers) {
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
        panel.add(teacherNameLabel, gbc);
        gbc.gridx = 1;
        panel.add(teacherNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(teacherAddressLabel, gbc);
        gbc.gridx = 1;
        panel.add(teacherAddressField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(workingTypeLabel, gbc);
        gbc.gridx = 1;
        panel.add(workingTypeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(employmentStatusLabel, gbc);
        gbc.gridx = 1;
        panel.add(employmentStatusField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(gradedScoreLabel, gbc);
        gbc.gridx = 1;
        panel.add(gradedScoreField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(yearsOfExperienceLabel, gbc);
        gbc.gridx = 1;
        panel.add(yearsOfExperienceField, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(add, gbc);
        gbc.gridx = 1;
        panel.add(clear, gbc);
        gbc.gridx = 2;
        panel.add(display, gbc);

        frame.add(header, BorderLayout.NORTH);
        frame.add(panel);
        frame.setResizable(false);
        frame.setVisible(true);

        add.addActionListener(e -> {
            try {
                int teacherID = (Integer.parseInt(teacherIDField.getText()));
                String teacherName = teacherNameField.getText();
                String address = teacherAddressField.getText();
                String workingType = (String) workingTypeField.getSelectedItem();
                String employmentStatus = (String) employmentStatusField.getSelectedItem();
                int gradedScore = Integer.parseInt(gradedScoreField.getText());
                int yearsOfExperience = Integer.parseInt(yearsOfExperienceField.getText());

                if (String.valueOf(teacherID).isBlank() || teacherName.isEmpty() || address.isEmpty() || String.valueOf(gradedScore).isBlank() || String.valueOf(yearsOfExperience).isBlank()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields");
                } else {
                    boolean exist = false;
                    for (Teacher teacher : teachers) {
                        if (teacher instanceof Lecturer) {
                            if (teacher.getTeacherID() == teacherID) {
                                exist = true;
                                break;
                            }
                        }
                    }
                    if (exist) {
                        JOptionPane.showMessageDialog(null, "Teacher ID already exists");
                        return;
                    }

                    Lecturer lecturer = new Lecturer(teacherID, teacherName, address, workingType, employmentStatus, gradedScore, yearsOfExperience);
                    teachers.add(lecturer);
                    JOptionPane.showMessageDialog(null, "Lecturer added successfully");
                    clear();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid data!");
            }

        });

        clear.addActionListener(e-> {
            clear();
        });

        display.addActionListener(e-> {
            JFrame displayFrame = new JFrame("Display Lecturers");
            displayFrame.setSize(1100, 600);
            displayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            displayFrame.setLocationRelativeTo(null);
            displayFrame.add(display(teachers));

            displayFrame.setVisible(true);
        });
    }


    private void clear() {
        teacherIDField.setText("");
        teacherNameField.setText("");
        teacherAddressField.setText("");
        workingTypeField.setSelectedIndex(0);
        employmentStatusField.setSelectedIndex(0);
        gradedScoreField.setText("");
        yearsOfExperienceField.setText("");
    }

    private JPanel display(ArrayList<Teacher> teachers) {
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());

        String[] column = {"Teacher ID", "Teacher Name", "Address", "Working Type", "Employment Status", "Graded Score", "Years of Experience"};
        ArrayList<Lecturer> lecturers = new ArrayList<>();
        for(Teacher teacher: teachers) {
            if (teacher instanceof Lecturer) {
                lecturers.add((Lecturer) teacher);
            }
        }

        String[][] data = new String[lecturers.size()][column.length];
        for (int i = 0; i < lecturers.size(); i++) {
            data[i][0] = String.valueOf(lecturers.get(i).getTeacherID());
            data[i][1] = lecturers.get(i).getTeacherName();
            data[i][2] = lecturers.get(i).getAddress();
            data[i][3] = lecturers.get(i).getWorkingType();
            data[i][4] = lecturers.get(i).getEmploymentStatus();
            data[i][5] = String.valueOf(lecturers.get(i).getGradedScore());
            data[i][6] = String.valueOf(lecturers.get(i).getYearOfExperience());
        }

        JTable jt = new JTable(data, column);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int x = 0; x < column.length; x++) {
            jt.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
        }

        jt.setPreferredScrollableViewportSize(new Dimension(1050, 550));
        jt.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane sp = new JScrollPane(jt);
        displayPanel.add(sp, BorderLayout.CENTER);
        return displayPanel;
    }
}
