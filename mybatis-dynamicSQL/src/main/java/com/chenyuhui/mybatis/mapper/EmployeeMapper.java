package com.chenyuhui.mybatis.mapper;

import com.chenyuhui.mybatis.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {


    List<Employee> getEmployeeByCondition(@Param("emp") Employee emp);

    List<Employee> getEmployeeByChoose(Employee emp);

    int insertMoreEmp(@Param("employees") List<Employee> employees);

    int deleteMoreEmp(@Param("empIds") int[] empIds);

    List<Employee> getAllEmployee();

}
