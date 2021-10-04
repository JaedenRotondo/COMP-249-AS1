// -----------------------------------------------------
// Assignment 1
// Question: N/A
// Written by: Jaeden Rotondo 40160803
// Description can be found in Driver.java
// -----------------------------------------------------
public class Consumer {
    private enum maritalStatus { // Used String
        MARRIED, WIDDOWED, DIVORCED, SEPERATED, SINGLE;

        private maritalStatus() {
        }
    }

    private enum education { // Used String
        PRIMARY, SECONDARY, TERTIARY;

        private education() {
        }
    }

    // 9 attributes of the Consumer Object
    private String name;
    private int streetNumber;
    private String streetName;
    private String city;
    private String postalCode;
    private int age;
    private String gender;
    private String maritalStatus;
    private String education;
    // Every time this method is called, the menu will print and the last number
    // entered by the user will be returned as "num"
    static int consumerCount = 0; // The number of users already inputted into the system

    public Consumer() {
    }

    // Generate Constructor
    public Consumer(String name, int streetNumber, String streetName, String city, String postalCode, int age,
            String gender, String education, String maritalStatus) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.postalCode = postalCode;
        this.age = age;
        this.gender = gender;
        this.name = name;
        this.education = education;
        this.maritalStatus = maritalStatus;

    }

    // Generate Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    // Generate equals() method
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Consumer other = (Consumer) obj;
        if (age != other.age)
            return false;
        if (gender == null) {
            if (other.gender != null)
                return false;
        } else if (!gender.equals(other.gender))
            return false;
        return true;
    }

    // Generate toString Method
    @Override
    public String toString() {
        return "Consumer [age=" + age + ", city=" + city + ", education=" + education + ", gender=" + gender
                + ", maritalStatus=" + maritalStatus + ", name=" + name + ", postalCode=" + postalCode + ", streetName="
                + streetName + ", streetNumber=" + streetNumber + "]";
    }

}