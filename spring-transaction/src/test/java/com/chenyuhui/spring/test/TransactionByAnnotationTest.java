package com.chenyuhui.spring.test;

import com.chenyuhui.spring.tx.annotation.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-tx.xml")
public class TransactionByAnnotationTest {

    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook() {
        bookController.buyBook(1,1);
    }

    @Test
    public void testCheckout() {
        bookController.checkout(1,new Integer[] {1,2});
    }

}
