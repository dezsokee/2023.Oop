package models;

import java.time.DayOfWeek;
import java.util.ArrayList;

public class Course {
    private String courseID;
    private int numberOfCredits;
    private Teacher teacher;
    private DayOfWeek dayOfCourse;
    private ArrayList<Student> enrolledStudents = new ArrayList<>();

    public Course(String courseID, int numberOfCredits, DayOfWeek dayOfCourse) {
        this.courseID = courseID;
        this.numberOfCredits = numberOfCredits;
        this.dayOfCourse = dayOfCourse;
    }

    public String getCourseID() {
        return courseID;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public DayOfWeek getDayOfCourse() {
        return dayOfCourse;
    }

    public int numberOfEnrolledStudents()
    {
        return enrolledStudents.size();
    }
    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    void enrollStudent (Student student) {
        this.enrolledStudents.add(student);
    }

    @Override
    public String toString() {
        return "Course: " + courseID + ": \n \t Teacher: " + teacher + "\n \t Credits: " + numberOfCredits + "\n \t Occurs every: " + dayOfCourse + "\n \t Enrolled students: " + enrolledStudents.size() + "\n \t " + enrolledStudents + "\n";
    }
}
