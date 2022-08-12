package com.chenyuhui.ssm.service;

import com.chenyuhui.ssm.pojo.Employee;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    PageInfo<Employee> getEmployeePage(Integer pageNum);

}
