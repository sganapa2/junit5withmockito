package org.junit.mockito;

public class EmployeeService {


    private final DatabaseService databaseService;
    public EmployeeService() {
            this.databaseService = new DatabaseService();
    }

    public EmployeeService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public double calculateSalary(Employee employee, int perDayWages) {
        return perDayWages * employee.numberOfWorkDays;
    }

    public final String finalMethod() {
        return "Response from original final method";
    }

    public static String staticMethod() {
        return "Response from original static method";
    }

    public int calculateDoubleSalary(int numberOfDays) {
        if (numberOfDays <= 0)
            return 1;
        return numberOfDays * 2;
    }

    public String getDataFromDB(String input) {
        return databaseService.query(input);
    }

    public void deleteEmployeeEntry(Employee employee) {
        databaseService.deleteEmployee(employee);
    }

}
