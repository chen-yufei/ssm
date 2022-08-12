package com.chenyuhui.ssm.service.impl;

import com.chenyuhui.ssm.mapper.EmployeeMapper;
import com.chenyuhui.ssm.pojo.Employee;
import com.chenyuhui.ssm.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    @Override
    public PageInfo<Employee> getEmployeePage(Integer pageNum) {
        PageHelper.startPage(pageNum, 4);
        List<Employee> list = employeeMapper.getAllEmployee();
        PageInfo<Employee> page = new PageInfo<>(list, 5);
        return page;
    }
}
