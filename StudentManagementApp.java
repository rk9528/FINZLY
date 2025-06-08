package tuition.student;

import java.util.Scanner;

enum Performance {
    EXCELLENT, GOOD, AVERAGE, POOR
}

class InvalidMarkException extends Exception {
    public InvalidMarkException(String message) {
        super(message);
    }
}

class Student {
    private String name;
    private final String studentId;
    protected int[] marks;
    static int count = 0;
    final static int SUBJECTS = 3;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.marks = new int[SUBJECTS];
        count++;
    }

    public void setMarks(int[] marks) throws InvalidMarkException {
        for (int m : marks) {
            if (m < 0 || m > 100) {
                throw new InvalidMarkException("Mark " + m + " is invalid. It should be between 0 and 100.");
            }
        }
        this.marks = marks;
    }

    public double getAverage() {
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return sum / (double) SUBJECTS;
    }

    public Performance getPerformance() {
        double avg = getAverage();
        if (avg >= 85) return Performance.EXCELLENT;
        else if (avg >= 70) return Performance.GOOD;
        else if (avg >= 50) return Performance.AVERAGE;
        else return Performance.POOR;
    }

    public void display() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.print("Marks: ");
        for (int m : marks) {
            System.out.print(m + " ");
        }
        System.out.println("\nAverage: " + getAverage());
        System.out.println("Performance: " + getPerformance());
    }
}

class RegularStudent extends Student {
    private String classroom;

    public RegularStudent(String name, String studentId, String classroom) {
        super(name, studentId);
        this.classroom = classroom;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Classroom: " + classroom);
    }
}

class OnlineStudent extends Student {
    private String platform;

    public OnlineStudent(String name, String studentId, String platform) {
        super(name, studentId);
        this.platform = platform;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Platform: " + platform);
    }
}

public class StudentManagementApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            RegularStudent rStudent = new RegularStudent("Raghu", "R001", "Room A");
            rStudent.setMarks(new int[]{88, 76, 92});
            rStudent.display();

            System.out.println();

            OnlineStudent oStudent = new OnlineStudent("Santho", "O001", "Zoom");
            oStudent.setMarks(new int[]{65, 70, 80});
            oStudent.display();

            System.out.println("\nTotal Students Registered: " + Student.count);

        } catch (InvalidMarkException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
