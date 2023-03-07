package models;

import utils.Degree;
import utils.Major;
import utils.Department;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Degree {
    public static void main(String[] args) {
        Major major = new Major();

        major.getMajors().add("Computer Science");
        major.getMajors().add("Dentistry");
        major.getMajors().add("Biology");

        Student student1 = new Student("AVLMO7", "Anne", "Bell", major.getMajors().get(1));
        Student student2 = new Student("FPK7YE", "Dezso", "Szabolcs", major.getMajors().get(0));
        Student student3 = new Student("ASD123", "Kadar", "Akos", major.getMajors().get(1));
        Student student4 = new Student("YUO7GO", "Bekk", "Norbert", major.getMajors().get(0));
        Student student5 = new Student("19UY7T", "Cseh", "Barna", major.getMajors().get(2));

        Degree degree = new Degree();
        Department department = new Department();
        department.getDepartments().add("Medical department");
        degree.getDegrees().add("Labor technician");
        department.getDepartments().add("Math Info Department");
        degree.getDegrees().add("Docent");

        Teacher teacher1 = new Teacher("Suzanne", "Grey", degree.getDegrees().get(0) , department.getDepartments().get(0));
        Teacher teacher2 = new Teacher("John", "Black", degree.getDegrees().get(1), department.getDepartments().get(1));

        Course course1 = new Course("MB_INFO20", 5, DayOfWeek.FRIDAY);

        course1.setTeacher(teacher1);
        course1.enrollStudent(student1);
        course1.enrollStudent(student5);

        System.out.println(course1);

        ArrayList<Course> courses = new ArrayList<>();

        int i = 1, j = -1;

        try (Scanner scanner = new Scanner(new File("university.csv"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(",");
                if (i % 2 == 1)
                {
                    String courseID = items[0].trim();
                    int numOfCredits = Integer.parseInt(items[1].trim());
                    int num_dayOfWeek = Integer.parseInt(items[2].trim());
                    DayOfWeek dayOfWeek = getDayOfWeek(num_dayOfWeek);
                    courses.add(new Course(courseID, numOfCredits, dayOfWeek));
                    ++i;
                    ++j;
                }
                else
                {
                    String firstName = items[0].trim();
                    String lastName = items[1].trim();

                    String actualDegree = items[2].trim();
                    if(!degree.getDegrees().contains(actualDegree))
                    {
                        degree.getDegrees().add(actualDegree);
                    }

                    String actualDepartment = items[3].trim();
                    if(!department.getDepartments().contains(actualDepartment))
                    {
                        department.getDepartments().add(actualDepartment);
                    }

                    Teacher teacher = new Teacher(firstName, lastName, actualDegree, actualDepartment);
                    courses.get(j).setTeacher(teacher);
                    i++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        i = 1;
        try (Scanner scanner = new Scanner(new File("students.csv"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.isEmpty()) {
                    continue;
                }

                String[] items = line.split(",");
                String neptunCode = items[0].trim();
                String firstName = items[1].trim();
                String lastName = items[2].trim();
                String actualMajor =  items[3].trim();

                Student actualStudent = new Student(neptunCode, firstName, lastName, actualMajor);
                System.out.println(actualStudent);

                ++i;
                line = scanner.nextLine();
                items = line.split(",");

                for (String item: items) {
                    for (Course course : courses) {
                        if(course.getCourseID().equals(item)) {
                            course.enrollStudent(actualStudent);
                        }
                    }
                }


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(courses);
    }

    public static DayOfWeek getDayOfWeek (int num_dayOfWeek)
    {
        switch (num_dayOfWeek) {
            case 1: return DayOfWeek.MONDAY;
            case 2: return DayOfWeek.TUESDAY;
            case 3: return DayOfWeek.WEDNESDAY;
            case 4: return DayOfWeek.THURSDAY;
            case 5: return DayOfWeek.FRIDAY;
            case 6: return DayOfWeek.SATURDAY;
            case 7: return DayOfWeek.SUNDAY;
            default: return null;
        }
    }
}