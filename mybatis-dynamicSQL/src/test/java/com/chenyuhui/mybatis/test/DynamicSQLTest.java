package com.chenyuhui.mybatis.test;

import com.chenyuhui.mybatis.mapper.EmployeeMapper;
import com.chenyuhui.mybatis.pojo.Employee;
import com.chenyuhui.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DynamicSQLTest {


    @Test
    public void testGetEmployeeByCondition() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = new Employee(null,"admin",23,"男");
        List<Employee> list = employeeMapper.getEmployeeByCondition(employee);
        list.forEach(System.out::println);
    }

    @Test
    public void testGetEmployeeByChoose() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = new Employee(null,"xxx",23,"男");
        List<Employee> list = employeeMapper.getEmployeeByChoose(employee);
        list.forEach(System.out::println);
    }

    @Test
    public void testInsertMoreEmployee() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee1 = new Employee(null,"xxx",23,"男");
        Employee employee2 = new Employee(null,"xxx",23,"男");
        Employee employee3 = new Employee(null,"xxx",23,"男");
        Employee employee4 = new Employee(null,"xxx",23,"男");
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        int result = employeeMapper.insertMoreEmp(employees);
        System.out.println("插入的条数为：" + result);
    }

    @Test
    public void testDeleteMoreEmployee() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        int[] empIds = {9,10,11,12};
        int result = employeeMapper.deleteMoreEmp(empIds);
        System.out.println("删除的条数为：" + result);
    }

    @Test
    public void testGetAllEmployee() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> list = employeeMapper.getAllEmployee();
        list.forEach(System.out::println);
    }

}
