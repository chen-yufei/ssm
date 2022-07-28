package com.chenyuhui.mybatis.mapper;

import com.chenyuhui.mybatis.pojo.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {

    Department getDeptById(@Param("deptId") int deptId);

    Department getDeptEmpById(@Param("deptId") int deptId);

    Department getDeptEmpByStep(@Param("deptId") int deptId);

}
