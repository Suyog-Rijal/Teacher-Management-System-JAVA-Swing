package functions;

/**
 * Write a description of class Tutor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tutor extends Teacher{
    private double salary;
    private String specialization;
    private String academicQualification;
    private int performanceIndex;
    private boolean isCertified;

    public Tutor(int teacherID, String teacherName, String address, String workingType, String employmentStatus, int workingHour, double salary, String specialization, String academicQualification, int performanceIndex) {
        super(teacherID, teacherName, address, workingType, employmentStatus);
        setWorkingHour(workingHour);
        this.salary = salary;
        this.specialization = specialization;
        this.academicQualification = academicQualification;
        this.performanceIndex = performanceIndex;
        this.isCertified = false;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getAcademicQualification() {
        return academicQualification;
    }

    public int getPerformanceIndex() {
        return performanceIndex;
    }

    public boolean isCertified() {
        return isCertified;
    }

    public String setSalaryWithAppraisal(double newSalary, int newPerformanceIndex) {
        double appraisal = 0.0;
        if (!isCertified) {
            if (newPerformanceIndex > 5 && getWorkingHour() > 20) {
                if (newPerformanceIndex >= 5 && newPerformanceIndex <= 7) {
                    appraisal = 0.05;
                } else if (newPerformanceIndex >= 8 && newPerformanceIndex <= 9) {
                    appraisal = 0.10;
                } else if (newPerformanceIndex == 10) {
                    appraisal = 0.20;
                }
                this.salary = newSalary + (appraisal * newSalary);
                this.isCertified = true;
                String message = "Salary approved with appraisal: " + this.salary;
                System.out.println(message);
                return message;
            } else {
                String message = "Salary cannot be approved. Performance index or working hours do not meet criteria.";
                System.out.println(message);
                return message;
            }
        } else {
            System.out.println("Salary cannot be approved. Tutor is not certified yet.");
            return "Something went wrong. Please try again.";
        }
    }

    public void removeTutor() {
        if (!isCertified) {
            this.salary = 0.0;
            this.specialization = "";
            this.academicQualification = "";
            this.performanceIndex = 0;
            this.isCertified = false;
            System.out.println("Tutor removed.");
        } else {
            System.out.println("Tutor cannot be removed. Tutor is certified.");
        }
    }

    public void display() {
        super.display();
        if (isCertified) {
            System.out.println("Salary: " + salary);
            System.out.println("Specialization: " + specialization);
            System.out.println("Academic Qualifications: " + academicQualification);
            System.out.println("Performance Index: " + performanceIndex);
        }
    }
}
