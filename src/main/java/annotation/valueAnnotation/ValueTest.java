package annotation.valueAnnotation;

public class ValueTest {
    public static void main(String[] args) throws Exception{
        User user = new User();
        System.out.println(user.toString());
        ValueUtil.getValue(user); // value注释
        System.out.println(user.toString());
    }
}
