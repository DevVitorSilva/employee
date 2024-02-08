import entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("How many employees will be registered? ");
        int employeeNumbers = sc.nextInt();
        List<Employee> employees = new ArrayList<>();
        for(int i = 0; i < employeeNumbers; i++){
            int id;
            String name;
            double salary;
            Employee employee;
            System.out.println();
            System.out.println("Employee #" + i + ":");
            System.out.print("Id: ");
            id = sc.nextInt();
            for(Employee employeeId : employees){
                if(employeeId.getId() == id){
                    System.out.println("Id not allowed");
                    System.out.print("Id: ");
                    id = sc.nextInt();
                }
            }
            sc.nextLine();
            System.out.print("Name: ");
            name = sc.nextLine();
            System.out.print("Salary: ");
            salary = sc.nextDouble();
            employee = new Employee(id, name, salary);
            employees.add(employee);
        }
        for(Employee employee : employees){
            System.out.printf("%d, %s, %.2f\n", employee.getId(), employee.getName(), employee.getSalary());
        }
        sc.close();
    }
}