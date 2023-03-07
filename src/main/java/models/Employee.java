package models;

import org.apache.commons.lang3.RandomStringUtils;

public class Employee {

    int id;
    String name;
    int salary;
    int age;

    public Employee() {
        this.id = Integer.parseInt(RandomStringUtils.randomNumeric(4));
        this.name = RandomStringUtils.randomAlphabetic(7);
        this.age = Integer.parseInt(RandomStringUtils.randomNumeric(2));
        this.salary = Integer.parseInt(RandomStringUtils.randomNumeric(6));
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public int getSalary() {
        return this.salary;
    }

    public int getAge() {
        return this.age;
    }
}
