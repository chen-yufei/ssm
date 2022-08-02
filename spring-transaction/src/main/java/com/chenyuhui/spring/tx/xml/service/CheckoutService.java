package com.chenyuhui.spring.tx.xml.service;

public interface CheckoutService {
    void checkout(Integer custId, Integer[] bookIds);
}
