import java.util.Scanner;
import java.io.*; // Classes for reading writing files
import java.util.ArrayList; // Importing Array List
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner read = new Scanner(System.in);
        System.out.print("Enter name of employee file to read: ");
        String employeeFile = read.nextLine().trim();

        System.out.print("Enter the name of payroll file to create: ");
        String payrollFile = read.nextLine().trim();
        // Loading employees from input file
        ArrayList<Employee> employees = loadEmployees(employeeFile);
        FileWriter fileWriter = new FileWriter(payrollFile);
        try {
            // Payroll output file
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
            // Checking if output is JSON
            if (payrollFile.toLowerCase().endsWith(".json")) {
                bufWriter.write("[");
                bufWriter.newLine();
                for (int i = 0; i < employees.size(); i++) { // Looping through all employees
                    Employee employee = employees.get(i); // Get employees at current postion
                    bufWriter.write(String.format( // Writing info as JSON
                            "    { \"id\": %d, \"name\": \"%s\", \"grossPay\": %.2f }",
                            employee.getEmployeeId(),
                            employee.getName(),
                            employee.getGrossPay()
                        )
                    );

                    if (i < employees.size() - 1) {// Add "," if not last employee
                        bufWriter.write(",");
                    }
                    bufWriter.newLine(); // Moving to next line
                }
                bufWriter.write("]"); // Closing bracket for JSON
                bufWriter.newLine();

            } else { // Creating as csv file
                bufWriter.write("id|name|gross pay");
                bufWriter.newLine();

                for (Employee employee : employees) { // Looping though all employees
                    // Writing employee information
                    bufWriter.write(employee.getEmployeeId() + "|" + employee.getName() + "|"
                            + String.format("%.2f", employee.getGrossPay())
                    );
                    bufWriter.newLine();
                }
            }
            bufWriter.close();
            System.out.println("Payroll file created!");
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        read.close();
    }
    // Method to load employees from file
    public static ArrayList<Employee> loadEmployees(String fileName) {
        // Creating array list to store employee objects
        ArrayList<Employee> employees = new ArrayList<>();

        try {
            // Opens employee file to read
            BufferedReader bufReader = new BufferedReader(new FileReader(fileName));
            bufReader.readLine();
            String line; // Storing each line

            while ((line = bufReader.readLine()) != null) {//Continues reading until no more lines
                String[] parts = line.split("\\|"); // Splits line with "|"
                Employee employee = new Employee(Integer.parseInt(parts[0]),// Id
                        parts[1],// Name
                        Double.parseDouble(parts[3]),// Pay Rate
                        Double.parseDouble(parts[2]));// Hours Worked
                employees.add(employee); // Adds employee to arraylist
            }
            bufReader.close();
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return employees; // Returns completed list of employees
    }
}


