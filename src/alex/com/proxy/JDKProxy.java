package alex.com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKProxy {
    public static void main(String[] args){
        //创建接口的实现类代理对象
        Class[] interfaces = new Class[]{UserDao.class};
        // Proxy.newProxyInstance(JDKProxy.class, interfaces, new InvocationHandler() {
      
        //     @Override
        //     public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //         // TODO Auto-generated method stub
        //         return null;
        //     }
        // });
        UserDaoImpl userDao = new UserDaoImpl();
        UserDao dao = (UserDao)Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        int result = dao.add(1, 2);
        System.out.println(result);
    }
}


//创建代理对象代码
class UserDaoProxy implements InvocationHandler{

    //1. 把创建的是谁的代理对象，把谁传递过来
    //有参数构造
    private Object target;
    public UserDaoProxy(Object target){
        this.target = target;
    }
    //增强的逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        
        //方法之前
        System.out.println("方法之前执行..." + method.getName() + " :传递的参数..." + Arrays.toString(args));
        
        //被增强的方法执行
        Object res = method.invoke(target, args);

        //方法之后
        System.out.println("方法之后执行..."  + target);
        return res;
    }
    
}