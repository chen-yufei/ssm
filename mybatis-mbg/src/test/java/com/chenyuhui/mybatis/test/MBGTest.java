package com.chenyuhui.mybatis.test;

import com.chenyuhui.mybatis.mapper.EmployeeMapper;
import com.chenyuhui.mybatis.pojo.Employee;
import com.chenyuhui.mybatis.pojo.EmployeeExample;
import com.chenyuhui.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MBGTest {

    @Test
    public void testMBG() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andEmpNameEqualTo("admin").andAgeEqualTo(23);
        employeeExample.or().andAgeEqualTo(22);
        List<Employee> list = employeeMapper.selectByExample(employeeExample);
        list.forEach(System.out::println);
    }

}
