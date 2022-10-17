package pages;

public class RegistrantPojo {

    private String Ssn;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;

    public String getSsn() {
        return Ssn;
    }

    public void setSsn(String ssn) {
        this.Ssn = ssn;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "RegistrantPojo{" +
                "ssn='" + Ssn + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public RegistrantPojo(){

    }

    public RegistrantPojo(String ssn, String firstName, String lastName, String userName, String email, String password) {
        this.Ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}
