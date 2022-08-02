package com.chenyuhui.spring.tx.xml.controller;

import com.chenyuhui.spring.tx.xml.service.BookService;
import com.chenyuhui.spring.tx.xml.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CheckoutService checkoutService;


    public void buyBook(Integer custId,Integer bookId) {
        bookService.buyBook(custId,bookId);
    }

    public void checkout(Integer custId,Integer[] bookIds) {
        checkoutService.checkout(custId,bookIds);
    }

}
