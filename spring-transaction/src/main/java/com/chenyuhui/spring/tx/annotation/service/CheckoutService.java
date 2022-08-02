package com.chenyuhui.spring.tx.annotation.service;

public interface CheckoutService {
    void checkout(Integer custId, Integer[] bookIds);
}
