import java.lang.Math;

public class Main {
    static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        baseTask();

    }

    public static void baseTask() {
        createBook();
        readBook();
        sumSalary();
        minSalary();
        maxSalary();
        System.out.println("\nСредняя зарплата: " + averageSalary() + "\n");
        showFio();
    }


    public static String randomFio() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String fullName = "";
        char[] FIO = new char[3];
        for (int i = 0; i < FIO.length; i++) {
            FIO[i] = alphabet.charAt((int) (Math.random() * alphabet.length()));
            fullName += (FIO[i]);
        }
        return fullName.toUpperCase();
    }

    public static char randomDep() {
        String departmentNumbers = "12345";
        char department;
        department = departmentNumbers.charAt((int) ((Math.random()) * departmentNumbers.length()));
        return (department);
    }

    public static void createBook() {
        for (int i = 0; i < employees.length; i++) {
            employees[i] = new Employee(randomFio(), randomDep(), (int) (Math.random() * 100));
        }
    }

    public static void readBook() {
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].toString());

        }
    }

    public static void sumSalary() {
        int sumSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            sumSalary = sumSalary + employees[i].getSalary();
        }
        System.out.println("\nСумма затрат на зарплату: " + sumSalary);
    }

    public static void minSalary() {
        int minSalary = employees[0].getSalary();
        int minSalaryId = 0;
        for (int i = 1; i < employees.length; i++) {
            if (employees[i].getSalary() < minSalary) {
                minSalaryId = i;
                minSalary = employees[i].getSalary();
            }
        }
        System.out.println("\nСотрудник с минимальной зарплата: " + employees[minSalaryId].toString());
    }

    public static void maxSalary() {
        int maxSalary = 0;
        int maxSalaryId = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > maxSalary) {
                maxSalaryId = i;
                maxSalary = employees[i].getSalary();
            }
        }
        System.out.println("\nСотрудник с максимальной зарплатой: " + employees[maxSalaryId].toString());
    }

    public static int averageSalary() {
        int averageSalary;
        int amount = 0;
        int sumSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            sumSalary = sumSalary + employees[i].getSalary();
            if (employees[i].getId() != 0) amount++;
        }
        averageSalary = (sumSalary / amount);
        return averageSalary;
    }

    public static void showFio() {
        for (int i = 0; i < employees.length; i++) {
            System.out.println("ФИО: " + employees[i].getFullName());
        }
    }

}