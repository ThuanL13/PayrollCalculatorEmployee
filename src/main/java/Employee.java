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

    public void setEmployeeId(int employeeID) {
        this.employeeId = employeeID;
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

    public double getGrossPay() {
        return hoursWorked * payRate;
    }
}
