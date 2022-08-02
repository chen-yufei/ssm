package com.chenyuhui.spring.tx.annotation.service.impl;


import com.chenyuhui.spring.tx.annotation.service.BookService;
import com.chenyuhui.spring.tx.annotation.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    private BookService bookService;

    @Override
    @Transactional
    public void checkout(Integer custId, Integer[] bookIds) {
        for(Integer bookId : bookIds) {
            bookService.buyBook(custId,bookId);
        }
    }
}
