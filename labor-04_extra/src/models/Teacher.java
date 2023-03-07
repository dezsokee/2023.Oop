package models;

import utils.Degree;
import utils.Department;

public class Teacher {
    static private int currentNumberOfTeachers;
    private String firstName;
    private String lastName;
    private String degree;
    private String department;

    public Teacher(String firstName, String lastName, String degree, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.degree = degree;
        this.department = department;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " - " + degree + " from " +department;
    }
}
