package proxy.staticProxy;

import proxy.IUserDao;
import proxy.UserDaoWithImpl;

public class TestProxy {
    public static void main(String[] args){
        //目标对象
        IUserDao target = new UserDaoWithImpl();
        //代理对象
        UserDaoProxy proxy = new UserDaoProxy(target);
        //执行代理对象方法
        proxy.save();
        proxy.print();
    }
}
