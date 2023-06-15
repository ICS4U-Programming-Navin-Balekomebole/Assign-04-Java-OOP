import java.util.ArrayList;
import java.util.List;

/**
* This file contains the main class.
*
* @author  Navin Balekomebole
* @version 1.0
* @since   2023-06-14
*/

class Course {
    private String name;
    private List<Student> students;

    /**
    * Constructor for this class.
    *
    * @param name from main.
    */
    Course(String name) {
        this.name = name;
        // Initialize the list of students
        this.students = new ArrayList<>();
    }

    /**
    * Enroll student in a course.
    *
    * @param student from main.
    */
    public void enrollStudent(Student student) {
        // Add the student to the list of students
        students.add(student);
    }

    /**
    * Record student's grade.
    *
    * @param student from main
    * @param grade from user
    */
    public void recordGrade(Student student, double grade) {
        // Set the grade for the student in this course
        student.setGrade(this, grade);
    }

    /**
    * Calculate average of course.
    *
    * @return average of course
    */
    public double getCourseAverageGrade() {
        double sum = 0;
        for (Student student : students) {
            // Get the grade for each student in
            // the course and add it to the sum.
            sum += student.getGrade(this);
        }
        // Calculate and return the average grade
        return sum / students.size();
    }

    public String getName() {
        return this.name;
    }
}
