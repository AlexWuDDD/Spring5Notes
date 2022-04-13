package alex.com.aopxml.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import alex.com.aopxml.Book;

public class TestXML {

    @Test
    public void testAopAnno(){
        ApplicationContext context = 
            new ClassPathXmlApplicationContext("bean13.xml");
        
        Book book = context.getBean("book", Book.class);
        book.buy();

        ((ClassPathXmlApplicationContext)context).close();
    }
    
}
