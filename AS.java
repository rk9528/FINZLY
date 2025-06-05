import java.util.Scanner;

public class AS {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("ENTER HOW MANY EMPLOYEES: ");
        int n = input.nextInt();
        input.nextLine(); // Clear leftover newline

        // Arrays
        String[] names = new String[n];
        int[] bs = new int[n];
        int[] hra = new int[n];
        float[] tr = new float[n];
        boolean[] istr = new boolean[n];

        // Input loop
        for (int i = 0; i < n; i++) {
            System.out.println("\nENTER THE DETAILS FOR EMPLOYEE " + (i + 1));

            System.out.print("ENTER THE NAME: ");
            names[i] = input.nextLine(); // String input

            System.out.print("ENTER THE BASIC SALARY: ₹");
            bs[i] = input.nextInt();

            System.out.print("ENTER THE HRA: ₹");
            hra[i] = input.nextInt();

            System.out.print("Is tax applicable? (t/f): ");
            String taxInput = input.next();
            istr[i] = taxInput.equalsIgnoreCase("t");

            System.out.print("ENTER THE TAX RATE IN % (e.g., 10 for 10%): ");
            tr[i] = input.nextFloat() / 100; // Convert % to decimal

            input.nextLine(); // Clear newline after nextFloat
        }

        // Output loop
        for (int i = 0; i < n; i++) {
            int grossSalary = bs[i] + hra[i];
            float tax = istr[i] ? (grossSalary * tr[i]) : 0;
            float netSalary = grossSalary - tax;

            System.out.println("\n----- SALARY SLIP FOR " + names[i] + " -----");
            System.out.println("Gross Salary: ₹" + grossSalary);
            System.out.println("Tax Deducted: ₹" + tax);
            System.out.println("Net Salary: ₹" + netSalary);
        }

        input.close();
    }
}
