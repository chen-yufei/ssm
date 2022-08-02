package com.chenyuhui.spring.tx.annotation.dao;

public interface BookDao {

    int getPriceByBookId(Integer bookId);

    void updateBookStock(Integer bookId);

    void updateCustBalance(Integer custId, int price);
}
