public class Main {
    public static void main(String[] args) {
        var catalog = new EmployeeBook(10);

        catalog.add("Иван", "Иванович", "Иванов", 53000, 1);
        catalog.add("Николай", "Петрович", "Розенблюм", 55000, 2);
        catalog.add("Светлана", "Витальевна", "Перова", 53600, 3);
        catalog.add("Денис", "Михайлович", "Васильев", 58000, 1);
        catalog.add("Михаил", "Сергеевич", "Павленко", 44300, 4);
        catalog.add("Фаина", "Аркадьевна", "Шереметьева", 73900, 5);
        catalog.add("Дарья", "Алексанровна", "Кузнецова", 39900, 1);
        catalog.add("Ирина", "Анатольевна", "Краснова", 49000, 1);
        catalog.add("Вячеслав", "Сергеевич", "Краснов", 49000, 3);
        catalog.add("Анастасия", "Станиславовна", "Шираз", 49000, 2);

        System.out.println(catalog);
        System.out.println(catalog.getSumInMonth());
        System.out.println(catalog.getMinSalary());
        System.out.println(catalog.getMaxSalary());
        System.out.println(catalog.getAverage());
        catalog.printAllNames();
        catalog.indexSalary(8);
        System.out.println(catalog);
        System.out.println(catalog.findMinInDepartment(1));
        System.out.println(catalog.findMaxInDepartment(1));
        System.out.println(catalog.getSumInDepartment(1));
        System.out.println(catalog.getAverageInDepartment(1));
        catalog.indexSalaryInDepartment(1, 11);
        catalog.printOneDepartment(1);
        System.out.println("+++++++++");
        catalog.printSalaryLessThan(60000);
        System.out.println("+++++++++");
        catalog.printSalaryMoreThan(60000);
        catalog.delete("Денис", "Михайлович", "Васильев");
        System.out.println("+++++++++");
        System.out.println(catalog);
        catalog.changeSalary("Светлана", "Витальевна", "Перова", 99000);
        catalog.changeDepartment("Светлана", "Витальевна", "Перова", 1);
        System.out.println("+++++++++");
        System.out.println(catalog.findEmployee("Светлана", "Витальевна", "Перова"));
        catalog.printAllByDepartment(5);
    }

}