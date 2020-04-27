package proxy.cglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {

    private Object target;//维护一个目标对象

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //为目标对象生成代理对象
    public Object getProxyInstance() {
        //工具类
        Enhancer en = new Enhancer();
        //设置父类
        en.setSuperclass(target.getClass());
        //设置回调函数
        en.setCallback(this);
        //创建子类对象代理
        return en.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println(method);

        if(method.getName().equals("save")) {
            System.out.println("开启事务");
            // 执行目标对象方法
            Object returnValue = method.invoke(target, args);
            System.out.println("提交事务");
            return returnValue;
        }

        if(method.getName().equals("print")){
            System.out.println("开始打印");
            Object returnValue = method.invoke(target, args);
            System.out.println("结束打印");
            return returnValue;
        }

        return null;
    }
}
