package generic;

//解决反省擦除导致的类型无法判断问题
public class GenericType<T> {
    Class<T> classType;

    public GenericType(Class<T> classType) {
        this.classType = classType;
    }

    public boolean isInstance(Object object){
        return classType.isInstance(object);
    }

    public static void main(String[] args){
        GenericType<String> genericType = new GenericType<>(String.class);
        System.out.println(genericType.isInstance(new String()));
    }
}
