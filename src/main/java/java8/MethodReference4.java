package java8;

import java.util.Arrays;
import java.util.List;

public class MethodReference4 {
    public static void main(String[] args) {
        Student student1 = new Student("zhangsan",60);
        Student student2 = new Student("lisi",70);
        Student student3 = new Student("wangwu",80);
        Student student4 = new Student("zhaoliu",90);
        List<Student> students = Arrays.asList(student1,student2,student3,student4);

        // 0. Lambda表达式
        students.sort((o1, o2) -> o1.getScore() - o2.getScore());

        // 1. 类名::静态方法名
        students.sort(Student::compareStudentByScore1);

        // 2. 对象::实例方法名
        StudentComparator studentComparator = new StudentComparator();
        students.sort(studentComparator::compareStudentByScore2);

        // 3. 类名::实例方法名
        // 当使用 类名::实例方法名 方法引用时，一定是lambda表达式所接收的第一个参数为隐藏的this，
        // 如果lambda表达式接收多个参数，其余的参数作为方法的参数传递进去。
        students.sort(Student::compareStudentByScore3);

    }
}


class StudentComparator {
    public int compareStudentByScore2(Student student1, Student student2){
        return student2.getScore() - student1.getScore();
    }
}

class Student {
    private String name;
    private int score;

    public Student(){

    }

    public Student(String name,int score){
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static int compareStudentByScore1(Student student1, Student student2){
        return student1.getScore() - student2.getScore();
    }

    public int compareStudentByScore3(Student student){
        return this.getScore() - student.getScore();
    }
}