package com.chenyuhui.spring.pojo;

/**
 CREATE TABLE `t_cyh_customer` (
 `cust_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
 `custname` VARCHAR(20) DEFAULT NULL COMMENT '用户名',
 `balance` INT(10) UNSIGNED DEFAULT NULL COMMENT '余额（无符号）',
 PRIMARY KEY (`cust_id`)
 ) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
 INSERT INTO `t_cyh_customer`(`cust_id`,`custname`,`balance`) VALUES (1,'admin',50);
 `ssm``ssm``t_cyh_employee``t_cyh_employee`
**/

public class Customer {

    private Integer custId;
    private String custName;
    private Integer balance;

    public Customer() {
    }

    public Customer(Integer custId, String custName, Integer balance) {
        this.custId = custId;
        this.custName = custName;
        this.balance = balance;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
