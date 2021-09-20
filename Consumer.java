public class Consumer{ 
    public enum maritalStatus{
        MARRIED, NONMARRIED 
    }
    String education;
    private int streetNumber;
    private String streetName;
    private String city;
    private String postalCode;
    private int age;
    private String gender;
    private String name;

    //Generate Constructor
    public Consumer(int streetNumber, String streetName, String city, String postalCode, int age, String gender,
            String maritalStauts, String education, String name) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.postalCode = postalCode;
        this.age = age;
        this.gender = gender;
        this.maritalStatus = maritalStauts;
        this.education = education;
        this.name = name;
    }

    // Generate Getters and Setters
    public String getName(){
        return name; 
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
    public String getMaritalStatus() {
        return maritalStatus;
    }
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
    public String getEducation() {
        return education;
    }
    public void setEducation(String education) {
        this.education = education;
    }

    // Generate toString Method
    @Override
    public String toString() {
        return "Consumer [age=" + age + ", city=" + city + ", education=" + education + ", gender=" + gender
                + ", maritalStatus=" + maritalStatus + ", name=" + name + ", postalCode=" + postalCode + ", streetName="
                + streetName + ", streetNumber=" + streetNumber + "]";
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
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (education == null) {
            if (other.education != null)
                return false;
        } else if (!education.equals(other.education))
            return false;
        if (gender == null) {
            if (other.gender != null)
                return false;
        } else if (!gender.equals(other.gender))
            return false;
        if (maritalStatus == null) {
            if (other.maritalStatus != null)
                return false;
        } else if (!maritalStatus.equals(other.maritalStatus))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (postalCode == null) {
            if (other.postalCode != null)
                return false;
        } else if (!postalCode.equals(other.postalCode))
            return false;
        if (streetName == null) {
            if (other.streetName != null)
                return false;
        } else if (!streetName.equals(other.streetName))
            return false;
        if (streetNumber != other.streetNumber)
            return false;
        return true;
    }


}