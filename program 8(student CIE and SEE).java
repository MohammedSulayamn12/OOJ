// File: CIE/Student.java
package CIE;

public class Student {

    protected String usn;
    protected String name;
    protected int sem;

    public Student(String usn, String name, int sem) {
        this.usn = usn;
        this.name = name;
        this.sem = sem;
    }

 
    public String getUsn() {
        return usn;
    }

    public String getName() {
        return name;
    }

    public int getSem() {
        return sem;
    }
}

// File: CIE/Internals.java
package CIE;

public class Internals {

    protected int[] internalMarks;

    public Internals(int[] marks) {
        this.internalMarks = marks;
    }

    public int[] getInternalMarks() {
        return internalMarks;
    }
}
// File: SEE/External.java
package SEE;

import CIE.Student;
import CIE.Internals;

public class External extends Student {
    // Array to store SEE marks for 5 courses
    private int[] externalMarks;

    // Constructor to initialize both student info and external marks
    public External(String usn, String name, int sem, int[] internalMarks, int[] externalMarks) {
        super(usn, name, sem);
        this.externalMarks = externalMarks;
        // Instantiate the Internals class with the internal marks
        Internals internals = new Internals(internalMarks);
    }

    // Method to get SEE marks
    public int[] getExternalMarks() {
        return externalMarks;
    }

    // Method to calculate final marks (sum of internal and external marks for each course)
    public int[] calculateFinalMarks(int[] internalMarks) {
        int[] finalMarks = new int[5]; // To store final marks of 5 courses
        for (int i = 0; i < 5; i++) {
            finalMarks[i] = internalMarks[i] + externalMarks[i]; // Internal + External = Final
        }
        return finalMarks;
    }
}
// File: FinalMarks.java
import CIE.*;
import SEE.*;

import java.util.Scanner;

public class FinalMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();  

        for (int i = 0; i < n; i++) {
            sc.nextLine();  

            // Input student details
            System.out.print("Enter USN: ");
            String usn = sc.nextLine();
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter semester: ");
            int sem = sc.nextInt();

            // Input internal marks (5 courses)
            System.out.println("Enter internal marks for 5 courses: ");
            int[] internalMarks = new int[5];
            for (int j = 0; j < 5; j++) {
                internalMarks[j] = sc.nextInt();
            }

            // Input external marks (5 courses)
            System.out.println("Enter external marks for 5 courses: ");
            int[] externalMarks = new int[5];
            for (int j = 0; j < 5; j++) {
                externalMarks[j] = sc.nextInt();
            }

            // Create an object of the External class (derived from Student)
            External student = new External(usn, name, sem, internalMarks, externalMarks);

            // Calculate final marks
            int[] finalMarks = student.calculateFinalMarks(internalMarks);

            // Display student information and final marks
            System.out.println("\nStudent Details:");
            System.out.println("USN: " + student.getUsn());
            System.out.println("Name: " + student.getName());
            System.out.println("Semester: " + student.getSem());

            System.out.println("\nFinal Marks for 5 Courses: ");
            for (int j = 0; j < 5; j++) {
                System.out.println("Course " + (j + 1) + ": " + finalMarks[j]);
            }
            System.out.println();
        }

        sc.close();
    }
}
