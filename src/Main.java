import java.io.IOException;
import java.lang.Math;

public class Main {
    static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        baseTask();
        mediumDifficultTask();
    }

    public static void baseTask() {
        createBook();
        readBook();
        sumSalary();
        System.out.println("\nСотрудник с минимальной зарплата: " + employees[minSalary()].toString());
        System.out.println("\nСотрудник с максимальной зарплатой: " + employees[maxSalary()].toString());
        System.out.println("\nСредняя зарплата: " + averageSalary() + "\n");
        showFio();
    }

    public static void mediumDifficultTask() {
        salaryIndexation();
        System.out.println("getDepWithMinSalary() = " + getDepWithMinSalary());
        System.out.println("getDepWithMaxSalary() = " + getDepWithMaxSalary());
        System.out.println("getDepAverageSalary(\"Отдел № 2\") = " + getDepAverageSalary("Отдел № 2"));
        indexDepSalary("Отдел № 2", 20);
        depList("Отдел № 4");
        salaryBelow(50000);
        salaryAbove(60000);
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

    public static String randomDep() {
        String departmentNumbers = "12345";
        String department;
        department = "Отдел № " + departmentNumbers.charAt((int) ((Math.random()) * departmentNumbers.length()));
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
            sumSalary += employees[i].getSalary();
        }
        System.out.println("\nСумма затрат на зарплату: " + sumSalary);
    }

    public static int minSalary() {
        int minSalary = 0;
        int i = 0;
        while (minSalary == 0)
            if (employees[i].getSalary() != 0) {
                minSalary = employees[i].getSalary();
                i++;
            }
        int minSalaryId = 0;
        for (int j = i + 1; j < employees.length; j++) {
            if (employees[j].getSalary() < minSalary) {
                minSalaryId = j;
                minSalary = employees[j].getSalary();
            }
        }
        return minSalaryId;
    }

    public static int maxSalary() {
        int maxSalary = 0;
        int maxSalaryId = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > maxSalary) {
                maxSalaryId = i;
                maxSalary = employees[i].getSalary();
            }
        }
        return maxSalaryId;
    }

    public static int averageSalary() {
        int averageSalary;
        int amount = 0;
        int sumSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            sumSalary += employees[i].getSalary();
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

    public static void salaryIndexation() {
        System.out.println("ЗП после индексации:");
        for (int i = 0; i < employees.length; i++) {
            int indexSalary = (int) (employees[i].getSalary() * 1.1);
            employees[i].setSalary(indexSalary);
            System.out.println("ID" + employees[i].getId() + ": " + employees[i].getSalary());
        }
    }

    public static String getDepWithMinSalary() {
        return employees[minSalary()].getDepartment();
    }

    public static String getDepWithMaxSalary() {
        return employees[maxSalary()].getDepartment();
    }

    public static double getDepAverageSalary(String depForCalculate) {
        if (depForCalculate.length() == randomDep().length()) {
            int amountWorkersInDep = 0;
            int sumSalary = 0;
            float averageSalary = 0;
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getDepartment().equals(depForCalculate)) {
                    amountWorkersInDep++;
                    sumSalary += employees[i].getSalary();
                }
            }
            if (amountWorkersInDep != 0) {
                averageSalary = sumSalary / amountWorkersInDep;
            } else System.out.println("Отдел пуст");
            System.out.println("В " + depForCalculate + " средняя зарплата: " + averageSalary);
            return averageSalary;
        } else throw new RuntimeException("Такого отдела не существует");

    }

    public static void indexDepSalary(String depForCalculate, int Index) {
        if (depForCalculate.length() == randomDep().length()) {
            int amountWorkersInDep = 0;
            int indexSalary;
            double index = (Index * 0.01);
            //System.out.println("index = " + index);
            System.out.println("depForCalculate = " + depForCalculate);
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getDepartment().equals(depForCalculate)) {
                    amountWorkersInDep++;
                    //System.out.printf("ID: %d, ЗП до индексации  %d\n",employees[i].getId(), employees[i].getSalary());
                    indexSalary = (int) (employees[i].getSalary() * 1.2);
                    employees[i].setSalary(indexSalary);
                    System.out.println("ID: " + employees[i].getId() + ", ФИО: " +
                            employees[i].getFullName() + ", Новая ЗП - " + employees[i].getSalary());

                }
            }
            if (amountWorkersInDep == 0) {
                System.out.println("Отдел пуст");
            }
        } else throw new RuntimeException("Нельзя проиндексированить зарплату, такого отдела не существует");
    }

    public static void depList(String depForListing) {
        if (depForListing.length() == randomDep().length()) {
            System.out.println("depForListing = " + depForListing);
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getDepartment().equals(depForListing)) {
                    System.out.println("ID: " + employees[i].getId() + ", ФИО: " +
                            employees[i].getFullName() + ", ЗП - " + employees[i].getSalary());

                }
            }
        } else throw new RuntimeException("Нельзя составить список отдела,такого отдела не существует");
    }

    public static void salaryBelow(int limit) {
        System.out.println("Список сотрудников c ЗП ниже " + limit + ":");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < limit) {
                System.out.println("ID: " + employees[i].getId() + ", ФИО: " +
                        employees[i].getFullName() + ", ЗП - " + employees[i].getSalary());

            }
        }
    }
    public static void salaryAbove(int limit) {
        System.out.println("Список сотрудников с ЗП выше " + limit + ":");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > limit) {
                System.out.println("ID: " + employees[i].getId() + ", ФИО: " +
                        employees[i].getFullName() + ", ЗП - " + employees[i].getSalary());

            }
        }
    }


}
