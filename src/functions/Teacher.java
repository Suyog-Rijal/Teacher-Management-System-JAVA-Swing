package functions;

/**
 * Write a description of class Teacher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Teacher {
    private int teacherID;
    private String teacherName;
    private String address;
    private String workingType;
    private String employmentStatus;
    private int workingHour;

    public Teacher(int teacherID, String teacherName, String address, String workingType, String employmentStatus) {
        this.teacherID = teacherID;
        this.teacherName = teacherName;
        this.address = address;
        this.workingType = workingType;
        this.employmentStatus = employmentStatus;
    }

    public int getTeacherID(){
        return teacherID;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getAddress() {
        return address;
    }

    public String getWorkingType() {
        return workingType;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public int getWorkingHour() {
        return workingHour;
    }


    public void setWorkingHour(int working_hour) {
        this.workingHour = working_hour;
    }

    public void display(){
        System.out.println("Teacher ID: " + teacherID);
        System.out.println("Teacher Name: " + teacherName);
        System.out.println("Address: " + address);
        System.out.println("Working Type: " + workingType);
        System.out.println("Employment Status: " + employmentStatus);
        if (workingHour > 0) {
            System.out.println("Working hour is not assigned !!");
        }
        else {
            System.out.println("Working hour: " + workingHour);
        }
    }
}
