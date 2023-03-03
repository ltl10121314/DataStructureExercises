package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Liu Tianlong
 * @program data-structure-exercises
 * @create 2023-03-02 23:10
 * @description 学生控制层
 */
@RestController
@RequestMapping("student")
@Slf4j
public class StudentController {
    /**
     * 服务对象
     */
    @Autowired
    private StudentService studentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Student selectOne(Integer id) {
        log.info("hello world");
        return this.studentService.queryById(id);
    }
}