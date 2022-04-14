package alex.com.jdbc.dao;

import java.util.List;

import alex.com.jdbc.entity.Book;

public interface BookDao {

    //添加的方法
    void add(Book book);

    void updateBook(Book book);

    void deleteBook(String id);

    int selectCount();

    Book findBookInfo(String id);

    List<Book> findAllBooks();
    
}
