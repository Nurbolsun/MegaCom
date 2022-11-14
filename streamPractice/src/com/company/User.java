package com.company;

public class User {
    private long id;
    private  double salary;
    private  int age;
    private String name;
    private  Role role;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", salary=" + salary +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }

    public User() {
    }

    public User(long id, double salary, int age, String name, Role role) {
        this.id = id;
        this.salary = salary;
        this.age = age;
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
