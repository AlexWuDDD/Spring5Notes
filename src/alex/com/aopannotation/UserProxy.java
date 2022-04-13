package alex.com.aopannotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//增强类
@Component
@Aspect //生成代理对象
@Order(3)
public class UserProxy {

    //相同切入点抽取
    @Pointcut(value="execution(* alex.com.aopannotation.User.add(..))")
    public void pointDemo(){

    }
    
    //前置通知
    //@Before注解表示前置通知
    @Before(value="pointDemo()")
    public void before(){
        System.out.println("before...........");
    }


    //最终通知
    @After(value="pointDemo()")
    public void after(){
        System.out.println("after...........");
    }

    //后置通知（返回通知）
    @AfterReturning(value="pointDemo()")
    public void AfterReturning(){
        System.out.println("afterReturning...........");
    }

    //异常通知
    @AfterThrowing(value="pointDemo()")
    public void AfterThrowing(){
        System.out.println("afterThrowing...........");
    }

    //环绕通知
    @Around(value="pointDemo()")
    public void Around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("环绕之前...........");
        //被增强的方法执行
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后...........");
    }
}
 