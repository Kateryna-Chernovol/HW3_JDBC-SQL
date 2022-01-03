public class Students {
    private int studentId;
    private String firstName;
    private String lastName;
    private int yearOfBirth;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "Student " +
                "id = " + studentId +
                ",  name '" + firstName + ' ' + lastName + '\'' +
                ", yearOfBirth " + yearOfBirth +
                " ";
    }
}
