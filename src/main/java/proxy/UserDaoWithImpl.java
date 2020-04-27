package proxy;

// 继承了接口
public class UserDaoWithImpl implements IUserDao {

    @Override
    public void save() {
        System.out.println("保存数据");
    }

    @Override
    public void print() {
        System.out.println("打印数据");
    }
}
