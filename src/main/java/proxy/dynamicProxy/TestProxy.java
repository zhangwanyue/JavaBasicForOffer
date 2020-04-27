package proxy.dynamicProxy;

import proxy.IUserDao;
import proxy.UserDaoWithImpl;

public class TestProxy {
    public static void main(String[] args){
        //目标对象
        IUserDao target = new UserDaoWithImpl();
        System.out.println(target.getClass());
        //代理对象
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());
        //执行代理对象方法
        proxy.save();
        proxy.print();
    }
}
