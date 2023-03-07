package models;

import utils.Major;

public class Student {
    private String neptunCode;
    private String firstName;
    private String lastName;
    private String major;

    public Student(String neptunCode, String firstName, String lastName, String major) {
        this.neptunCode = neptunCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + neptunCode + ")";
    }
}
