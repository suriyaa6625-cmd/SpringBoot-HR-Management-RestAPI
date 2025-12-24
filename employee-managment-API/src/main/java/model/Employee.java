package model;

public class Employee {

    private int id;
    private String name;
    private String department;
    private String designation;
    private double salary;
    private SalaryBand salaryBand;
    private String contact;

    

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public SalaryBand getSalaryBand() {
        return salaryBand;
    }

    public void setSalaryBand(SalaryBand salaryBand) {
        this.salaryBand = salaryBand;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}

