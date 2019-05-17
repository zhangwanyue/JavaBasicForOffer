package container.normalCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        Employee[] employees = new Employee[4];
        employees[0] = new Employee(10, "A");
        employees[1] = new Employee(0, "B");
        employees[2] = new Employee(3, "C");
        employees[3] = new Employee(1, "D");
        Arrays.sort(employees);
        System.out.println(Arrays.toString(employees));
    }

}

class Employee implements Comparable<Employee> {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Employee employee) { // 逻辑大概可以理解为: if(return > 0){swap two elements;}
        return (this.id - employee.id);
    }
}