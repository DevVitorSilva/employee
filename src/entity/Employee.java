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

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getSalary(){
        return this.salary;
    }

    public void increaseSalary(double percent){
        this.salary += percent * salary / 100;
    }
}
