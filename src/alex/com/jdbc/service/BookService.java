package alex.com.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alex.com.jdbc.dao.BookDao;
import alex.com.jdbc.entity.Book;

@Service
public class BookService {
    
    //注入dao
    @Autowired
    private BookDao bookDao;

    //添加的方法
    public void addBook(Book book){
        bookDao.add(book);
    }

    //修改的方法
    public void updateBook(Book book){
        bookDao.updateBook(book);
    }

    //删除的方法
    public void deleteBook(String id){
        bookDao.deleteBook(id);
    }

    //查询表中的记录数
    public int findCount(){
        return bookDao.selectCount();
    }

    //查询返回对象
    public Book findOne(String id){
        return bookDao.findBookInfo(id);
    }

    //查询返回集合
    public List<Book> findAll(){
        return bookDao.findAllBooks();
    }
}
