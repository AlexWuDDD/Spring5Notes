package alex.com.spring_demo1.service;
import alex.com.spring_demo1.dao.UserDao;

public class UserService {

    //创建UserDao类型属性，生成set方法
    private UserDao userDao;
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }
    
    public void add(){
        System.out.println("service add........");
        //原始方式：创建UserDao对象
        // UserDao userDao = new UserDaoImpl();
        // userDao.update();
        userDao.update();
    }
}
