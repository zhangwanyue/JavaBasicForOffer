package proxy.staticProxy;

import proxy.IUserDao;

public class UserDaoProxy implements IUserDao {

    private IUserDao target;
    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开启事务");//扩展了额外功能
        target.save();
        System.out.println("提交事务");
    }

    @Override
    public void print() {
        System.out.println("开始打印");
        target.print();
        System.out.println("提交事务");
    }
}
