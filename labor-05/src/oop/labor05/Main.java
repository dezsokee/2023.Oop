package oop.labor05;

import oop.labor05.model.Course;
import oop.labor05.model.Student;
import oop.labor05.model.Training;
import oop.labor02.myDate;

import javax.management.relation.RelationNotFoundException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Course> courses = readCourses("courses.csv");
        System.out.println(courses);

        ArrayList<Student> students = readStudents("students.csv");
        System.out.println(students);

        Course course1 = new Course("Java SE 17", "Java Standard Edition 17", 40);

        Random random = new Random();
        double pricePerStudent = random.nextInt((2000 - 1001) + 1000);

        Training training1 = new Training(course1, new myDate(2023,3,21), new myDate(2023,3,25), pricePerStudent);

        int i = 0;

        while (i < 10) {

            int studentRandom = random.nextInt(students.size());
            if(training1.enroll(students.get(studentRandom))) {
                i++;
            }
        }

        System.out.println(training1);
        training1.printToFile();

    }
    private static ArrayList<Course> readCourses (String filename)
    {
        ArrayList<Course> courses = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File(filename)))
        {
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                if (line.isEmpty())
                {
                    continue;
                }
                String[] items = line.split(",");
                String name = items[0].trim();
                String description = items[1].trim();
                int numHours = Integer.parseInt(items[2].trim());
                Course actualCourse = new Course(name, description, numHours);
                courses.add(actualCourse);

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return courses;
    }

    private static ArrayList<Student> readStudents (String filename)
    {
        ArrayList<Student> students = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filename)))
        {
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();

                if (line.isEmpty())
                {
                    continue;
                }

                String[] items = line.split(",");
                String ID = items[0].trim();
                String firstName = items[1].trim();
                String lastName = items[2].trim();

                Student actualStudent = new Student(ID, firstName, lastName);

                students.add(actualStudent);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return students;
    }
}
