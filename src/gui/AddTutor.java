package gui;

import functions.Teacher;
import functions.Tutor;
import my.OtherButton;
import my.OtherLabels;
import my.OtherTextFields;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

public class AddTutor {
    private JPanel panel = new JPanel();
    private JPanel header = new JPanel();
    private JLabel addLecturer = new JLabel("Add Tutor");
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
    private JLabel workingHoursLabel = new OtherLabels("Working Hours:");
    private JTextField workingHoursField = new OtherTextFields();
    private JLabel salaryLabel = new OtherLabels("Salary:");
    private JTextField salaryField = new OtherTextFields();
    private JLabel specializationsLabel = new OtherLabels("Specializations:");
    private JTextField specializationsField = new OtherTextFields();
    private JLabel academicQualificationsLabel = new OtherLabels("Academic Qul:");
    private JTextField academicQualificationsField = new OtherTextFields();
    private JLabel performanceIntexLabel = new OtherLabels("Performance Index:");
    private JTextField performanceIntexField = new OtherTextFields();
    private JButton add = new OtherButton("Add");
    private JButton clear = new OtherButton("Clear");
    private JButton display = new OtherButton("Display");

    public AddTutor(ArrayList<Teacher> teachers) {
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
        gbc.insets = new Insets(0, 10, 20, 10);
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
        panel.add(workingHoursLabel, gbc);
        gbc.gridx = 1;
        panel.add(workingHoursField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(salaryLabel, gbc);
        gbc.gridx = 1;
        panel.add(salaryField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(specializationsLabel, gbc);
        gbc.gridx = 1;
        panel.add(specializationsField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(academicQualificationsLabel, gbc);
        gbc.gridx = 1;
        panel.add(academicQualificationsField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        panel.add(performanceIntexLabel, gbc);
        gbc.gridx = 1;
        panel.add(performanceIntexField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 10, 10, 10);
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
                int teacherID = Integer.parseInt(teacherIDField.getText());
                String teacherName = teacherNameField.getText();
                String teacherAddress = teacherAddressField.getText();
                String workingType = (String) workingTypeField.getSelectedItem();
                String employmentStatus = (String) employmentStatusField.getSelectedItem();
                int workingHours = Integer.parseInt(workingHoursField.getText());
                double salary = Double.parseDouble(salaryField.getText());
                String specializations = specializationsField.getText();
                String academicQualifications = academicQualificationsField.getText();
                int performanceIndex = Integer.parseInt(performanceIntexField.getText());

               if (teacherIDField.getText().isEmpty() || teacherNameField.getText().isEmpty() || teacherAddressField.getText().isEmpty() || workingHoursField.getText().isEmpty() || salaryField.getText().isEmpty() || specializationsField.getText().isEmpty() || academicQualificationsField.getText().isEmpty() || performanceIntexField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields.");
                } else {
                    boolean exist = false;
                    for (Teacher teacher : teachers) {
                        if (teacher instanceof Tutor && teacher.getTeacherID() == teacherID) {
                            exist = true;
                            break;
                        }
                    }
                   if (exist) {
                       JOptionPane.showMessageDialog(null, "Teacher ID already exists");
                       return;
                   }

                   Tutor tutor = new Tutor(teacherID, teacherName, teacherAddress, workingType, employmentStatus, workingHours, salary, specializations, academicQualifications, performanceIndex);
                   teachers.add(tutor);
                   JOptionPane.showMessageDialog(null, "Tutor added successfully");
                   clear();

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid data!!");
            }
        });

        clear.addActionListener(e-> {
            clear();
        });

        display.addActionListener(e-> {
            JFrame displayFrame = new JFrame("Display Tutor");
            displayFrame.setSize(1100, 600);
            displayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            displayFrame.setLocationRelativeTo(null);

            displayFrame.add(display(teachers));

            displayFrame.setVisible(true);
        });

    }

    public void clear() {
        teacherIDField.setText("");
        teacherNameField.setText("");
        teacherAddressField.setText("");
        workingTypeField.setSelectedIndex(0);
        employmentStatusField.setSelectedIndex(0);
        workingHoursField.setText("");
        salaryField.setText("");
        specializationsField.setText("");
        academicQualificationsField.setText("");
        performanceIntexField.setText("");
    }

    private JPanel display(ArrayList<Teacher> teachers) {
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());

        String[] column = {"Teacher ID", "Teacher Name", "Teacher Address", "Working Type", "Employment Status", "Working Hours", "Salary", "Specializations", "Academic Qualifications", "Performance Index"};
        ArrayList<Tutor> tutors = new ArrayList<>();
        for (Teacher teacher : teachers) {
            if (teacher instanceof Tutor) {
                tutors.add((Tutor) teacher);
            }
        }

        String[][] data = new String[tutors.size()][column.length];
        for (int i = 0; i < tutors.size(); i++) {
            data[i][0] = String.valueOf(tutors.get(i).getTeacherID());
            data[i][1] = tutors.get(i).getTeacherName();
            data[i][2] = tutors.get(i).getAddress();
            data[i][3] = tutors.get(i).getWorkingType();
            data[i][4] = tutors.get(i).getEmploymentStatus();
            data[i][5] = String.valueOf(tutors.get(i).getWorkingHour());
            data[i][6] = String.valueOf(tutors.get(i).getSalary());
            data[i][7] = tutors.get(i).getSpecialization();
            data[i][8] = tutors.get(i).getAcademicQualification();
            data[i][9] = String.valueOf(tutors.get(i).getPerformanceIndex());
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
