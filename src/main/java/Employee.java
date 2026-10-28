public class Employee {
    private int employeeID;
    private String name;
    private double hoursWorked, payRate;

    // Constructor with parameters
    public Employee(int employeeID, String name, double payRate, double hoursWorked) {
        this.employeeID = employeeID;
        this.name = name;
        this.payRate = payRate;
    }
    // Getter and Setters
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }
}
