package com.chenyuhui.spring.tx.xml.service.impl;


import com.chenyuhui.spring.tx.xml.service.BookService;
import com.chenyuhui.spring.tx.xml.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    private BookService bookService;

    @Override
    public void checkout(Integer custId, Integer[] bookIds) {
        for(Integer bookId : bookIds) {
            bookService.buyBook(custId,bookId);
        }
    }
}
