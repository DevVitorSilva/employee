# Employee

Fazer um programa para ler um número inteiro N e depois os dados (id, nome e salário) de N funcionários.
Não deve haver repetição de id.

Em seguida, efetuar o aumento de X por cento no salário de um determinado funcionário.
Para isso, o programa deve ler um id e o valor X. Se o id informado não existir, mostrar uma mensagem e abortar a
operação. Ao final, mostrar a listagem atualizada dos funcionários, conforme exemplos.

Lembre-se de aplicar a técnica de encapsulamento para não permitir que o salário possa ser mudado livremente. Um salário
só pode ser aumentado com base em uma operação de aumento por porcentagem dada.

**Employee Class**
```java
package entity;

public class Employee {
    private final Integer id;
    private String name;
    private Double salary;
    public Employee(int id, String name, double salary ){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Integer getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Double getSalary(){
        return this.salary;
    }

    public void increaseSalary(double percent){
        this.salary += percent * salary / 100;
    }
}
```

**Main Class**
```java
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
        System.out.println();
        System.out.print("Enter the employee id that will have salary increase: ");
        int idEmployee = sc.nextInt();
        Employee employeeFilter = employees.stream().filter(x -> x.getId() == idEmployee).findFirst().orElse(null);
        if(employeeFilter == null){
            System.out.println("Id not found");
        }
        else if(employeeFilter.getId() == idEmployee){
            System.out.print("Enter the percentage: ");
            double percent = sc.nextDouble();
            employeeFilter.increaseSalary(percent);
        }
        System.out.println();
        for(Employee employee : employees){
            System.out.printf("%d, %s, %.2f\n", employee.getId(), employee.getName(), employee.getSalary());
        }
        sc.close();
    }
}
```