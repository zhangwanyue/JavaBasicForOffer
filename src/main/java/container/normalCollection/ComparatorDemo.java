package container.normalCollection;

import java.util.*;

public class ComparatorDemo {
    public static void main(String[] args){
        // sort primitives array like int array
        System.out.println("-----------sort primitives array-----------");
        int[] intArr = {5,9,1,10};
        Arrays.sort(intArr);
        System.out.println(Arrays.toString(intArr));

        // sorting String array
        System.out.println("-----------sorting String array-----------");
        String[] strArr = {"A", "C", "B", "Z", "E"};
        Arrays.sort(strArr);
        System.out.println(Arrays.toString(strArr));

        // sorting list of objects of Wrapper classes
        System.out.println("-----------sorting list of objects of Wrapper classes-----------");
        List<String> strList = new ArrayList<String>();
        Collections.addAll(strList, "A", "C", "B", "Z", "E");
        Collections.sort(strList);
        strList.forEach(x->System.out.print(x + " "));

        // sort object array
        System.out.println("-----------sort object array-----------");
        Employee[] employees = new Employee[5];
        employees[0] = new Employee(10, "A", 100);
        employees[1] = new Employee(0, "B", 101);
        employees[2] = new Employee(3, "C", 200);
        employees[3] = new Employee(1, "D", 80);
        employees[4] = new Employee(1, "E", 70);
        Arrays.sort(employees);
        System.out.println("default: id asec: " + Arrays.toString(employees));

        // comparator sort
        System.out.println("-----------comparator sort-----------");
        Arrays.sort(employees, Employee.salaryComparator);
        System.out.println("salary asec: " + Arrays.toString(employees));
        Arrays.sort(employees, Employee.idComparator);
        System.out.println("id asec: " + Arrays.toString(employees));
        Arrays.sort(employees, Employee.salaryAndIdComparator);
        System.out.println("salary and id asec: " + Arrays.toString(employees));

        List<Employee> employeeList = new ArrayList<>(employees.length);
        Collections.addAll(employeeList, employees);
        Collections.sort(employeeList, Employee.idComparator);
        System.out.print("salary and id asec: ");
        employeeList.forEach(x->System.out.print(x + " "));
    }

}

class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Employee employee) {
        return (this.id - employee.id);
    }


    public static Comparator<Employee> salaryComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return (o1.getSalary() - o2.getSalary());
        }
    };

    public static Comparator<Employee> idComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return (o1.getId() - o2.getId());
        }
    };

    public static Comparator<Employee> salaryAndIdComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            int flag = o1.getId() - o2.getId();
            if(flag==0) flag = o1.getSalary() - o2.getSalary();
            return flag;
        }
    };
}