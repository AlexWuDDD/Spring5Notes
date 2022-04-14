package alex.com.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import alex.com.jdbc.entity.Book;

@Repository
public class BookDaoImpl implements BookDao{

    //注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(Book book) {
        //1. 创建sql语句
        String sql = "insert into books(user_id,user_name,user_sts) values(?,?,?)";
        //2.调用方法实现
        Object[] args = {book.getUser_id(),book.getUser_name(),book.getUser_sts()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }

    @Override
    public void updateBook(Book book) {
        String sql = "update books set user_name=?, user_sts=? where user_id=?";
        Object[] args = {book.getUser_name(), book.getUser_sts(), book.getUser_id()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
        
    }

    @Override
    public void deleteBook(String id) {
        String sql = "delete from books where user_id=?";
        Object[] args = {id};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
        
    }

    @Override
    public int selectCount() {
        String sql = "select count(*) from books";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public Book findBookInfo(String id) {
        String sql = "select * from books where user_id=?";
        Object[] args = {id};
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), args);
        return book;
    }

    @Override
    public List<Book> findAllBooks() {
        String sql = "select * from books";
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return bookList;
    }
    
}
