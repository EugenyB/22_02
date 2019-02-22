package entities;

import java.util.Objects;

public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;
    private char sex;
    private String location;

    public Employee(int id, String name, int age, double salary, char sex, String location) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.sex = sex;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                age == employee.age &&
                Double.compare(employee.salary, salary) == 0 &&
                sex == employee.sex &&
                Objects.equals(name, employee.name) &&
                Objects.equals(location, employee.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, salary, sex, location);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", sex=" + sex +
                ", location='" + location + '\'' +
                '}';
    }
}
