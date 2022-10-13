public class Employee {
    private final String fullName;
    private char department;
    private int salary;
    private final int id;
    static int count;

    public static int id() {
        count++;
        return count;
    }

    public Employee(String fullName, char department, int salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary * 1000;
        this.id = id();
    }

    public String getFullName() {
        return this.fullName;
    }

    public char getDepartment() {
        return this.department;
    }

    public void setDepartment(char department) {
        this.department = department;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return this.id;
    }

    public String toString() {
        return "ID: " + this.id + " ФИО: " + this.fullName + " Отдел: " + this.department + " Зарплата: " + this.salary;
    }

}
