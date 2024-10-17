
package it2b.alcaya;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class IT2BAlcaya{
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int choice;
            String response;
            do {
                System.out.println("1. ADD :");
                System.out.println("2. VIEW : ");
                System.out.println("3. UPDATE ");
                System.out.println("4. DELETE ");
                System.out.println("5. EXIT");
                
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                IT2BAlcaya course = new IT2BAlcaya();
                sc.nextLine();
                
                
                switch (choice) {
                    case 1:
                        course.addCourse(sc);
                        break;
                    case 2:
                        course.viewCourse();
                        break;
                    case 3:
                        course.viewCourse();
                        course.updateCourse(sc);
                        course.viewCourse();
                        break;
                    case 4:
                        course.viewCourse();
                        course.deleteCourse(sc);
                        course.viewCourse();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
                System.out.println("do you want to continue ? (yes/no) :");
                response = sc.next();
            } while (response.equalsIgnoreCase("yes"));
            System.out.println("Thank you, See you soonest!");
        }
    }
    public static void addCourse(Scanner sc) {
        config conf = new config();
        
        System.out.print("Course Name: ");
        String course_name = sc.nextLine();
        System.out.print("Course Code: ");
        String course_code= sc.nextLine();
        System.out.print("Course Credits: ");
        String credits = sc.nextLine(); 
        System.out.print("Course Semester:");
        String semester = sc.nextLine();
        System.out.print("Course Year:");
        String year = sc.nextLine();
        
        String sql = "INSERT INTO tbl_course (course_name ,course_code ,credits, semester, year) VALUES (?, ?, ?, ?, ?)";
        conf.addCourse(sql,course_name ,course_code ,credits, semester, year);
        
    }
    public static void viewCourse() {
        config conf = new config();
        String sqlQuery = "SELECT * FROM tbl_course";
        String[] columnHeaders = {"course_id","course_name","course_code","credits","semester","year"};
        String[] columnNames =   {"course_id","course_name","course_code","credits","semester","year"};
        conf.viewCourse(sqlQuery, columnHeaders, columnNames);
    }
    public static void updateCourse(Scanner sc) {
        config conf = new config();
        
        System.out.print("Enter the ID of Course to edit: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Enter new First Name: ");
        String course_name = sc.nextLine();
        System.out.println("Enter new Course Code");
        String course_code = sc.nextLine();
        System.out.print("Enter new Credits: ");
        String credits = sc.nextLine();
        System.out.println("Enter new Semester:");
        String semester = sc.nextLine();
        System.out.println("Enter new Year:");
        String year = sc.nextLine();
        String sql = "UPDATE tbl_course SET course_name = ?, course_code = ?, credits = ?, semester = ?, year = ? WHERE course_id = ?";
        conf.updateCourse(sql, course_name, course_code, credits, semester, year, id);
        System.out.println("Course updated successfully.");
    }
    public static void deleteCourse(Scanner sc) {
        config conf = new config();
        System.out.print("Enter the ID of Course to delete: ");
        int id = sc.nextInt();
        String sql = "DELETE FROM tbl_course WHERE p_id = ?";
        conf.deleteCourse(sql, id);
        System.out.println("Course deleted successfully.");
    }
}