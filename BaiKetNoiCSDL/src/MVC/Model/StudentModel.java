package MVC.Model;
 
public class StudentModel {
    private String studentID;
    private String fullName;
    private int gender;
    private String dateOfBirth;
    private String classID;
 
    public StudentModel(String studentID, String fullName, int gender, String dateOfBirth, String classID) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.classID = classID;
    }
 
    // Getters and setters
    public String getStudentID() {
        return studentID;
    }
 
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
 
    public String getFullName() {
        return fullName;
    }

    public void setFirstName(String fullName) {
        this.fullName = fullName;
    }
 
    public int getGender() {
        return gender;
    }
 
    public void setGender(int gender) {
        this.gender = gender;
    }
 
    public String getDateOfBirth() {
        return dateOfBirth;
    }
 
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
 
    public String getClassID() {
        return classID;
    }
 
    public void setClassID(String classID) {
        this.classID = classID;
    }
}
