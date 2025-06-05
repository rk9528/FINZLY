import java.util.Scanner;
class exc extends Exception {
    public exc(String message) {
        super(message); 
    }
}

public class excep {
    static void validatesalary(int salary) throws exc {
        if (salary < 10000) { 
            throw new exc("Salary must be at least 10,000");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter how many employees: ");
        int n = input.nextInt();
        input.nextLine(); 

        String[] names = new String[n];
        int[] salary = new int[n];

        for (int i = 0; i < n; i++) {
            try {
                System.out.println("\nEnter the details of the employee " + (i + 1));
                System.out.print("Enter the name: ");
                names[i] = input.nextLine();

                System.out.print("Enter the salary: ");
                salary[i] = input.nextInt();

                validatesalary(salary[i]);

                System.out.println("Salary Accepted for " + names[i]);
            } catch (exc e) {
                System.out.println(" Error: " + e.getMessage());
                names[i] = "Invalid Salary";
                salary[i] = 0;
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e);
                names[i] = "Error";
                salary[i] = 0;
                input.nextLine(); 
            } finally {
                input.nextLine();
                System.out.println("FINISHED PROCESSING EMPLOYEE DETAILS " + (i + 1));
            }
        }
        System.out.println("\n=========== EMPLOYEE SALARY REPORT ===========");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ". Name: " + names[i] + " | Salary: " + salary[i]);
        }

        input.close();
    }
}
