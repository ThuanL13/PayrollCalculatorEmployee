public class Employee {
    private int employeeId;
    private String name;
    private double hoursWorked, payRate;

    // Constructor with parameters
    public Employee(int employeeID, String name, double payRate, double hoursWorked) {
        this.employeeId = employeeID;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;

    }
    // Getter and Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getGrossPay() {
        return hoursWorked * payRate;
    }
}
