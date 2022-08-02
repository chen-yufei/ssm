package com.chenyuhui.spring.pojo;

/**
 CREATE TABLE `t_cyh_book` (
 `book_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
 `book_name` VARCHAR(20) DEFAULT NULL COMMENT '图书名称',
 `price` INT(11) DEFAULT NULL COMMENT '价格',
 `stock` INT(10) UNSIGNED DEFAULT NULL COMMENT '库存（无符号）',
 PRIMARY KEY (`book_id`)
 ) ENGINE=INNODB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
 INSERT INTO `t_cyh_book`(`book_id`,`book_name`,`price`,`stock`) VALUES (1,'斗破苍
 穹',80,100),(2,'斗罗大陆',50,100);
**/


public class Book {

    private Integer bookId;
    private String bookName;
    private Integer price;
    private Integer stock;

    public Book() {
    }

    public Book(Integer bookId, String bookName, Integer price, Integer stock) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
        this.stock = stock;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
