public class EmployeeBook {
    private final Employee[] employees;
    private static int size = 0;            //сделала эту переменную(size), чтоб не проверять ячейки массива на null
    private final int capacity;                   //она покажет, в какую ячейку класть нового сотрудника, и сколько их имеется

    //если так нельзя, то переделаю
    public EmployeeBook(int capacity) {
        employees = new Employee[capacity];
        this.capacity = capacity;
    }

    public void add(String firstName, String middleName, String lastName, float salary, int department) {
        employees[size++] = new Employee(firstName, middleName, lastName, salary, department);
    }

    public void delete(String firstName, String middleName, String lastName) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getLastName().equals(lastName) && employees[i].getFirstName().equals(firstName) &&
                    employees[i].getMiddleName().equals(middleName)) {
                while (i < size - 1) {
                    employees[i] = employees[i + 1];    //сдвигаю все влево
                    i++;
                }
                employees[i] = null;
                size--;
                return;
            }
        }
    }

    public float getSumInMonth() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += employees[i].getSalary();
        }
        return sum;
    }

    public float getMinSalary() {
        if (size == 0) {
            return 0f;
        } else {
            float min = employees[0].getSalary();
            for (int i = 1; i < size; i++) {
                if (employees[i].getSalary() < min) {
                    min = employees[i].getSalary();
                }
            }
            return min;
        }
    }

    public float getMaxSalary() {
        float max = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i].getSalary() > max) {
                max = employees[i].getSalary();
            }
        }
        return max;
    }

    public float getAverage() {
        return getSumInMonth() / size;
    }

    public void printAllNames() {
        for (int i = 0; i < size; i++) {
            employees[i].printOnlyName();
        }
    }

    public void indexSalary(int percent) {
        for (int i = 0; i < size; i++) {
            employees[i].setSalary(employees[i].getSalary() * (1 + percent / 100f));
        }       // 1 - это 100% + проценты/100 - коэфф-т повышения. Возможно, нужно их (1 и 100)
    }           //сделать переменными с именами??

    public Employee findMinInDepartment(int dep) {
        Employee temp = null;
        float min = 1000000000; // Допустимо ли здесь так делать?
        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == dep && employees[i].getSalary() < min) {
                temp = employees[i];
                min = employees[i].getSalary();
            }
        }
        return temp;
    }

    public Employee findMaxInDepartment(int dep) {
        Employee temp = null;
        float max = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == dep && employees[i].getSalary() > max) {
                temp = employees[i];
                max = employees[i].getSalary();
            }
        }
        return temp;
    }

    public float getSumInDepartment(int dep) {
        float sum = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == dep) {
                sum += employees[i].getSalary();
            }
        }
        return sum;
    }

    public float getAverageInDepartment(int dep) {
        float sum = 0;
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == dep) {
                sum += employees[i].getSalary();
                count++;
            }
        }
        return sum / count;
    }

    public void indexSalaryInDepartment(int dep, int percent) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == dep) {
                employees[i].setSalary(employees[i].getSalary() * (1 + percent / 100f));
            }
        }
    }

    public void printOneDepartment(int dep) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == dep) {
                employees[i].printWithoutDepartment();
            }
        }
    }

    public void printSalaryLessThan(float salary) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getSalary() < salary) {
                employees[i].printWithoutDepartment();
            }
        }
    }

    public void printSalaryMoreThan(float salary) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getSalary() >= salary) {
                employees[i].printWithoutDepartment();
            }
        }
    }

    public void changeSalary(String firstName, String middleName, String lastName, float salary) {
        if (findEmployee(firstName, middleName, lastName) != null) {
            findEmployee(firstName, middleName, lastName).setSalary(salary);
        } else System.out.println("Сотрудник не найден\n");
    }

    public void changeDepartment(String firstName, String middleName, String lastName, int dep) {
        if (findEmployee(firstName, middleName, lastName) != null) {
            findEmployee(firstName, middleName, lastName).setDepartment(dep);
        } else System.out.println("Сотрудник не найден\n");
    }

    public Employee findEmployee(String firstName, String middleName, String lastName) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getLastName().equals(lastName) && employees[i].getFirstName().equals(firstName) &&
                    employees[i].getMiddleName().equals(middleName)) {
                return employees[i];
            }
        }
        return null;
    }

    public void printAllByDepartment(int numberOfDepartment) {
        for (int i = 1; i <= numberOfDepartment; i++) {
            System.out.printf("Отдел %d:\n", i);
            for (int j = 0; j < size; j++) {
                if (employees[j].getDepartment() == i) {
                    employees[j].printOnlyName();
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(employees[i].toString()).append('\n');
        }
        return sb.toString();
    }
}
