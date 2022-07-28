package com.chenyuhui.mybatis.test;

import com.chenyuhui.mybatis.mapper.DepartmentMapper;
import com.chenyuhui.mybatis.mapper.EmployeeMapper;
import com.chenyuhui.mybatis.pojo.Department;
import com.chenyuhui.mybatis.pojo.Employee;
import com.chenyuhui.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ResultMapperTest {

    @Test
    public void testTuofeng() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = employeeMapper.getEmployeeById(1);
        System.out.println(employee);
    }

    @Test
    public void testGetEmpDept() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> list = employeeMapper.getAllEmployee();
        for(Employee employee : list) {
            System.out.println(employee);
        }
    }

    @Test
    public void testGetDeptEmpById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        Department department = departmentMapper.getDeptEmpById(1);
        System.out.println(department);
    }

    @Test
    public void testGetDeptEmpByStep() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        Department department = departmentMapper.getDeptEmpByStep(1);
        System.out.println(department);
    }


}
