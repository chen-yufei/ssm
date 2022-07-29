package com.chenyuhui.mybatis.test;

import com.chenyuhui.mybatis.mapper.EmployeeMapper;
import com.chenyuhui.mybatis.pojo.Employee;
import com.chenyuhui.mybatis.utils.SqlSessionUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class PageHelperTest {

    /*
    a>在查询功能之前使用PageHelper.startPage(int pageNum, int pageSize)开启分页功能
      pageNum：当前页的页码
      pageSize：每页显示的条数
    b>在查询获取list集合之后，使用PageInfo<T> pageInfo = new PageInfo<>(List<T> list, intnavigatePages)获取分页相关数据
      list：分页之后的数据
      navigatePages：导航分页的页码数
    c>分页相关数据
    PageInfo{
    pageNum=8, pageSize=4, size=2, startRow=29, endRow=30, total=30, pages=8,
    list=Page{count=true, pageNum=8, pageSize=4, startRow=28, endRow=32, total=30,
    pages=8, reasonable=false, pageSizeZero=false},
    prePage=7, nextPage=0, isFirstPage=false, isLastPage=true, hasPreviousPage=true,
    hasNextPage=false, navigatePages=5, navigateFirstPage4, navigateLastPage8,
    navigatepageNums=[4, 5, 6, 7, 8]
    }
    pageNum：当前页的页码
    pageSize：每页显示的条数
    size：当前页显示的真实条数
    total：总记录数
    pages：总页数
    prePage：上一页的页码
    nextPage：下一页的页码
    isFirstPage/isLastPage：是否为第一页/最后一页
    hasPreviousPage/hasNextPage：是否存在上一页/下一页
    navigatePages：导航分页的页码数
    navigatepageNums：导航分页的页码，[1,2,3,4,5]
    */

    @Test
    public void testPageHelper() {
        PageHelper.startPage(1, 5);
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> list = employeeMapper.selectByExample(null);
        list.forEach(System.out::println);
        PageInfo<Employee> pageInfo = new PageInfo<>(list,6);
        System.out.println(pageInfo);
    }

}
