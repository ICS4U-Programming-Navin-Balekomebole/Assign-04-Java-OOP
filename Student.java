import java.util.ArrayList;
/**
* This file contains the main class.
*
* @author  Navin Balekomebole
* @version 1.0
* @since   2023-06-14
*/

class Student {
    private String name;
    private int id;
    // List to store the courses enrolled by the student
    ArrayList<Course> courses;
    // List to store the corresponding grades for the enrolled courses
    private ArrayList<Double> grades;

    /**
    * Constructor for this class.
    *
    * @param name from main.
    * @param id from main.
    */
    Student(String name, int id) {
        this.name = name;
        this.id = id;
        // Initialize the courses list
        this.courses = new ArrayList<>();
        // Initialize the grades list
        this.grades = new ArrayList<>();
    }

    /**
    * Enroll student in course.
    *
    * @param course from main.
    */
    public void enrollCourse(Course course) {
        // Add the course to the student's course list
        courses.add(course);
        // Enroll the student in the course
        course.enrollStudent(this);
    }

    /**
    * Set student's grade.
    *
    * @param course from main.
    * @param grade from main.
    */
    public void setGrade(Course course, double grade) {
        // Find the index of the course in the course list
        final int index = courses.indexOf(course);
        // If the course is found in the list
        if (index != -1) {
            // Set the grade at the corresponding index in the grades list
            grades.add(grade);
        }
    }

    /**
    * Get student's grade.
    *
    * @param course from main.
    * @return index of course.
    */
    public double getGrade(Course course) {
        // Find the index of the course in the course list
        final int index = courses.indexOf(course);
        final double returnValue;
        // If the course is found in the list
        if (index != -1) {
            // Return the grade at the
            // corresponding index in the grades list
            returnValue = grades.get(index);
        } else {
            // Course grade not found
            returnValue = -1;
        }
        return returnValue;

    }

    /**
    * Get student's GPA.
    *
    * @return GPA.
    */
    public double calculateGpa() {
        // Initialize a variable to store the sum of grades
        double sum = 0;
        // Iterate through each grade in the 'grades' list
        for (double grade : grades) {
            // Add the grade to the sum
            sum += grade;
        }
        // Calculate and return the average grade
        return ((sum / grades.size()) / 100) * 4;
    }

    public String getName() {
        return name;
    }
}
