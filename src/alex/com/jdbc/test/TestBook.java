package alex.com.jdbc.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import alex.com.jdbc.entity.Book;
import alex.com.jdbc.service.BookService;

public class TestBook {

    @Test
    public void testJdbcTemplate(){
        ApplicationContext context = 
            new ClassPathXmlApplicationContext("beanJDBC_1.xml");
        
        BookService bookService = context.getBean("bookService", BookService.class);

        //添加
        // Book book = new Book();
        // book.setUser_id("1");
        // book.setUser_name("java");
        // book.setUser_sts("a");

        // bookService.addBook(book);

        //修改
        // Book book = new Book();
        // book.setUser_id("1");
        // book.setUser_name("javaupup");
        // book.setUser_sts("atguigu");
        // bookService.updateBook(book);

        //删除
        // bookService.deleteBook("1");

        //查询某个值
        // int count = bookService.findCount();
        // System.out.println(count);

        // Book book = bookService.findOne("1");
        // System.out.println(book);

        List<Book> books = bookService.findAll();
        System.out.println(books);
    }

}
