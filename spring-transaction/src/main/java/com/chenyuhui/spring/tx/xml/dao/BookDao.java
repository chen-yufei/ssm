package com.chenyuhui.spring.tx.xml.dao;

public interface BookDao {

    int getPriceByBookId(Integer bookId);

    void updateBookStock(Integer bookId);

    void updateCustBalance(Integer custId, int price);
}
