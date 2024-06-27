package functions;

/**
 * Write a description of class Lecturer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lecturer extends Teacher{
    private String department;
    private int yearOfExperience;
    private int gradedScore;
    private boolean hasGraded;

    public Lecturer(int teacherID, String teacherName, String address, String workingType, String employmentStatus, int gradedScore, int yearOfExperience) {
        super(teacherID, teacherName, address, workingType, employmentStatus);
        this.gradedScore = gradedScore;
        this.yearOfExperience = yearOfExperience;
        this.hasGraded = false;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearOfExperience(){
        return yearOfExperience;
    }

    public int getGradedScore(){
        return gradedScore;
    }

    public boolean isHasGraded(){
        return hasGraded;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String gradeAssignment(int gradedScore, String department, int yearsOfExperience) {
        String message = "";
        if (!hasGraded) {
            if (yearsOfExperience >= 5 && this.department.equals(department)) {
                if (gradedScore >= 70) {
                    this.gradedScore = gradedScore;
                    hasGraded = true;
                    message = "Assignments graded: A (70 and above)";
                } else if (gradedScore >= 60) {
                    this.gradedScore = gradedScore;
                    hasGraded = true;
                    message = "Assignments graded: B (60 and above)";
                } else if (gradedScore >= 50) {
                    this.gradedScore = gradedScore;
                    hasGraded = true;
                    message = "Assignments graded: C (50 and above)";
                } else if (gradedScore >= 40) {
                    this.gradedScore = gradedScore;
                    hasGraded = true;
                    message = "Assignments graded: D (40 and above)";
                } else {
                    this.gradedScore = gradedScore;
                    hasGraded = true;
                    message = "Assignments graded: E (Less than 40)";
                }
            } else {
                message = "Lecturer is not eligible to grade assignments yet.";
            }
        } else {
            System.out.println("Assignments is already graded.");
        }
        return message;
    }

    public void display() {
        super.display();
        System.out.println("Department: " + department);
        System.out.println("Year of Experience: " + yearOfExperience);

        if (hasGraded) {
            System.out.println("Graded Score: " + gradedScore);
        } else {
            System.out.println("Graded Score: Not graded yet");
        }
    }
}
