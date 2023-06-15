import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
* This file contains the main class.
*
* @author  Navin Balekomebole
* @version 1.0
* @since   2023-06-09
*/
public final class Main {
    /**
    * For style checks.
    *
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */
    private Main() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * Main body of code.
    *
    * @param args unused
    */
    public static void main(String[] args) {
        try {
            // Get input from file.
            final File input = new File("Input.txt");
            final Scanner scanFile = new Scanner(input);
            final ArrayList<String> fileList = new ArrayList<String>();

            // Loop for reading each line of input file.
            while (scanFile.hasNextLine()) {
                // Add next line.
                fileList.add(scanFile.nextLine());
            }

            // Create a new course object for Mathematics
            final Course mathCourse = new Course(fileList.get(0));
            // Create a new course object for Physics
            final Course physicsCourse = new Course(fileList.get(1));

            // Create a new student object with name "logan Sweeney" and ID 1
            final Student student1 = new Student(fileList.get(2), 1);
            // Create a new student object with name "Anthony Peirrera" and ID 2
            final Student student2 = new Student(fileList.get(5), 2);

            // Enroll student1 in the Mathematics course
            student1.enrollCourse(mathCourse);
            // Enroll student1 in the Physics course
            student1.enrollCourse(physicsCourse);

            // Enroll student2 in the Physics course
            student2.enrollCourse(physicsCourse);

            // Enroll student2 in the Mathematics course
            student2.enrollCourse(mathCourse);

            // Call the recordGrades method to record grades for student1
            recordGrades(student1, fileList, 3);

            // Call the recordGrades method
            // to record grades for student2
            recordGrades(student2, fileList, 6);
            // Print student1's name and GPA
            System.out.println(student1.getName()
                + "'s GPA: " + student1.calculateGpa());
            // Print student2's name and GPA
            System.out.println(student2.getName()
                + "'s GPA: " + student2.calculateGpa());
            // Print the average grade for the Mathematics course
            System.out.println("Math course average: "
                + mathCourse.getCourseAverageGrade());
            // Print the average grade for the Physics course
            System.out.println("Physics course average: "
                + physicsCourse.getCourseAverageGrade());
        } catch (IOException err) {
            System.out.println("No file found");
        }
    }

    /**
    * Main body of code.
    *
    * @param student to record grade for.
    */
    public static void recordGrades(Student student, ArrayList<String> inputs, int counter) {
        // Create a scanner object to read user input
        final Scanner scanner = new Scanner(System.in);
        // Iterate over the courses in which the student is enrolled
        for (Course course : student.courses) {
            // Read the grade entered by the user
            final double grade = Double.parseDouble(inputs.get(counter));
            // Set the grade for the course in the student's record
            student.setGrade(course, grade);
            counter++;
        }
    }
}
