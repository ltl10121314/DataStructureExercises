package com.example.demo.mapper;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author liutianlong
 */
@Mapper
public interface UserDao {
    /**
     * 查询所有用户
     * @return 返回用户实体
     */
    List<User> findAll();
}
