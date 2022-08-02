package com.chenyuhui.spring.tx.xml.service.impl;

import com.chenyuhui.spring.tx.xml.dao.BookDao;
import com.chenyuhui.spring.tx.xml.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
@Transactional注解标识的位置
@Transactional标识在方法上，咋只会影响该方法
@Transactional标识的类上，咋会影响类中所有的方法
**/

/**
 一、事务属性：只读
    对一个查询操作来说，如果我们把它设置成只读，就能够明确告诉数据库，这个操作不涉及写操作。这
    样数据库就能够针对查询操作来进行优化。
    使用方式：@Transactional(readOnly = true)
    对增删改操作设置只读会抛出下面异常：
    Caused by: java.sql.SQLException: Connection is read-only. Queries leading to data modification are not allowed
 二、事务属性：超时
     事务在执行过程中，有可能因为遇到某些问题，导致程序卡住，从而长时间占用数据库资源。而长时间
     占用资源，大概率是因为程序运行出现了问题（可能是Java程序或MySQL数据库或网络连接等等）。
     此时这个很可能出问题的程序应该被回滚，撤销它已做的操作，事务结束，把资源让出来，让其他正常
     程序可以执行。
     概括来说就是一句话：超时回滚，释放资源。
     使用方式：@Transactional(timeout = 3)
    执行过程中抛出异常：
    org.springframework.transaction.TransactionTimedOutException: Transaction timed out: deadline was Fri Jun 04 16:25:39 CST 2022
 三、事务属性：回滚策略
     声明式事务默认只针对运行时异常回滚，编译时异常不回滚。
     可以通过@Transactional中相关属性设置回滚策略
     rollbackFor属性：需要设置一个Class类型的对象
     rollbackForClassName属性：需要设置一个字符串类型的全类名
     noRollbackFor属性：需要设置一个Class类型的对象
     rollbackFor属性：需要设置一个字符串类型的全类名
    使用方式:@Transactional(noRollbackFor = ArithmeticException.class)
 四、事务属性：事务隔离级别
     数据库系统必须具有隔离并发运行各个事务的能力，使它们不会相互影响，避免各种并发问题。一个事
     务与其他事务隔离的程度称为隔离级别。SQL标准中规定了多种事务隔离级别，不同隔离级别对应不同
     的干扰程度，隔离级别越高，数据一致性就越好，但并发性越弱。
     隔离级别一共有四种：
     读未提交：READ UNCOMMITTED  允许Transaction01读取Transaction02未提交的修改。
     读已提交：READ COMMITTED    要求Transaction01只能读取Transaction02已提交的修改。
     可重复读：REPEATABLE READ   确保Transaction01可以多次从一个字段中读取到相同的值，即Transaction01执行期间禁止其它事务对这个字段进行更新。
     串行化：SERIALIZABLE       确保Transaction01可以多次从一个表中读取到相同的行，在Transaction01执行期间，禁止其它事务对这个表进行添加、更新、删除操作。可以避免任何并发问题，但性能十分低下。
     使用方式：
     @Transactional(isolation = Isolation.DEFAULT)//使用数据库默认的隔离级别
     @Transactional(isolation = Isolation.READ_UNCOMMITTED)//读未提交
     @Transactional(isolation = Isolation.READ_COMMITTED)//读已提交
     @Transactional(isolation = Isolation.REPEATABLE_READ)//可重复读
     @Transactional(isolation = Isolation.SERIALIZABLE)//串行化
 五、事务属性：事务传播行为
     当事务方法被另一个事务方法调用时，必须指定事务应该如何传播。
     例如：方法可能继续在现有事务中运行，也可能开启一个新事务，并在自己的事务中运行。
     可以通过@Transactional中的propagation属性设置事务传播行为
     @Transactional(propagation = Propagation.REQUIRED)，默认情况，表示如果当前线程上有已经开
     启的事务可用，那么就在这个事务中运行。经过观察，购买图书的方法buyBook()在checkout()中被调
     用，checkout()上有事务注解，因此在此事务中执行。所购买的两本图书的价格为80和50，而用户的余
     额为100，因此在购买第二本图书时余额不足失败，导致整个checkout()回滚，即只要有一本书买不
     了，就都买不了
     @Transactional(propagation = Propagation.REQUIRES_NEW)，表示不管当前线程上是否有已经开启
     的事务，都要开启新事务。同样的场景，每次购买图书都是在buyBook()的事务中执行，因此第一本图
     书购买成功，事务结束，第二本图书购买失败，只在第二次的buyBook()中回滚，购买第一本图书不受
     影响，即能买几本就买几本
 **/

@Service
public class BookServiceImpl implements BookService {


    @Autowired
    private BookDao bookDao;

    @Override
    public void buyBook(Integer custId, Integer bookId) {
        //查询出图书的价格
        int price = bookDao.getPriceByBookId(bookId);
        // 更新图书的库存
        bookDao.updateBookStock(bookId);
        //更新客户的余额
        bookDao.updateCustBalance(custId,price);
    }
}
