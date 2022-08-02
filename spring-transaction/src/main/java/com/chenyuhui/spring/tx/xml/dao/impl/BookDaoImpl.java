package com.chenyuhui.spring.tx.xml.dao.impl;

import com.chenyuhui.spring.tx.xml.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int getPriceByBookId(Integer bookId) {
        String sql = "select price from t_cyh_book where book_id = ?";
        return jdbcTemplate.queryForObject(sql,Integer.class,bookId);
    }

    @Override
    public void updateBookStock(Integer bookId) {
        String sql = "update t_cyh_book set stock = stock-1 where book_id = ?";
        jdbcTemplate.update(sql,bookId);
    }

    @Override
    public void updateCustBalance(Integer custId, int price) {
        String sql = "update t_cyh_customer set balance = balance - ? where cust_id = ?";
        jdbcTemplate.update(sql,price,custId);
    }
}
