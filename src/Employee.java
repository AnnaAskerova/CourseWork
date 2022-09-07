public class Employee {
    private static int count = 1;
    private final int id = count++;
    private final String firstName;
    private final String middleName;
    private final String lastName;            //ФИО final, т к по условию на них нет сеттеров
    private float salary;
    private int department;

    public Employee(String firstName, String middleName, String lastName, float salary, int department) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }

    public static int getCount() {
        return count;                    //по условию нужны геттеры всех полей, поэтому добавила счетчик тоже
    }                                    //если вдруг понадобится посмотреть его текущее состояние

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public float getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format("ID %d, ФИО %s %s %s, ЗП %.2f, отдел %d", id, firstName, middleName, lastName, salary, department);
    }

    public void printWithoutDepartment() {
        System.out.printf("ID %d, ФИО %s %s %s, ЗП %.2f\n", id, lastName, firstName, middleName, salary);
    }
    public void printOnlyName() {
        System.out.printf("%s %s %s\n", lastName, firstName, middleName);
    }
}
