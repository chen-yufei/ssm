package com.chenyuhui.mybatis.mapper;

import com.chenyuhui.mybatis.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {


    Employee getEmployeeById(@Param("empId") int empId);

    List<Employee> getAllEmployee();

    List<Employee> getEmployeeByDeptId(@Param("deptId") int deptId);

}
