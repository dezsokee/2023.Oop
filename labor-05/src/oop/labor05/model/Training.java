package oop.labor05.model;

import oop.labor02.myDate;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Training {
    Course course;
    ArrayList<Student> students = new ArrayList<>();
    myDate startDate;
    myDate endDate;
    double pricePerStudent;

    public Training(Course course, myDate startDate, myDate endDate, double pricePerStudent) {
        this.course = course;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pricePerStudent = pricePerStudent;
    }

    public boolean enroll (Student student)
    {
        for (int i = 0; i < students.size(); i++)
        {
            if (students.get(i).getID().equals(student.getID()))
            {
                return false;
            }
        }

        students.add(student);
        return true;

    }

    public Student findStudentById (String ID)
    {
        for (Student student : students)
        {
            if (student.getID().equals(ID))
            {
                return student;
            }
        }
        return null;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Training{" +
                "course=" + course +
                ", students=" + students +
                ", startDate=" + startDate.toString() +
                ", endDate=" + endDate.toString() +
                ", pricePerStudent=" + pricePerStudent +
                '}';
    }

    int numEnrolled ()
    {
        return students.size();
    }

    public void unEnroll (String ID)
    {
        for (int i = 0; i < students.size(); i++)
        {
            if (students.get(i).getID().equals(ID))
            {
                students.remove(i);
            }
        }
    }

    public void printToFile ()
    {
        try
        {
            String createdFileName = String.format("%s_%s_%s.csv", course.getName(), startDate, endDate);

            FileWriter fileWriter = new FileWriter(createdFileName);

            fileWriter.write(students.toString());

            fileWriter.close();

            System.out.println("File is created successfully!");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
