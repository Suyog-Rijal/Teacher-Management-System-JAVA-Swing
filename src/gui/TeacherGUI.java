package gui;
import functions.Teacher;
import my.MyButton;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TeacherGUI extends JFrame {
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JPanel header = new JPanel();
    private JLabel headerText = new JLabel("Teacher GUI");
    private JButton addLecturer = new MyButton("Add Lecturer");
    private JButton addTutor = new MyButton("Add Tutor");
    private JButton gradeAssignment = new MyButton("Grade Assignment");
    private JButton setSalary = new MyButton("Set Salary");
    private JButton removeTutor = new MyButton("Remove Tutor");
    private JButton display = new MyButton("Display");
    ArrayList<Teacher> teachers = new ArrayList<>();

    public TeacherGUI() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setTitle("Teacher GUI");
        frame.setSize(screenSize.width , screenSize.height - 30);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setSize(frame.getSize());
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        header.setPreferredSize(new Dimension(frame.getWidth(), 70));
        header.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        headerText.setFont(new Font("Arial", Font.BOLD, 30));
        header.add(headerText);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 10, 20, 10);
        panel.add(addLecturer, gbc);

        gbc.gridy = 1;
        panel.add(addTutor, gbc);

        gbc.gridy = 2;
        panel.add(gradeAssignment, gbc);

        gbc.gridy = 3;
        panel.add(setSalary, gbc);

        gbc.gridy = 4;
        panel.add(removeTutor, gbc);

        gbc.gridy = 5;
        panel.add(display, gbc);

        frame.add(header, BorderLayout.NORTH);
        frame.add(panel);
        frame.setVisible(true);

        addLecturer.addActionListener(e -> {
            new AddLecturer(teachers);
        });

        addTutor.addActionListener(e -> {
            new AddTutor(teachers);
        });

        gradeAssignment.addActionListener(e -> {
            new GradeAssignment(teachers);
        });

        setSalary.addActionListener(e -> {
            new SetSalary(teachers);
        });

        removeTutor.addActionListener(e -> {
            new RemoveTutor(teachers);
        });

        display.addActionListener(e -> {
            new Display(teachers);
        });
    }

    public static void main(String[] args) {
        new TeacherGUI();
    }
}
