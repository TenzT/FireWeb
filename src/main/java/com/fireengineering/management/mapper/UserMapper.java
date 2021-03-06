package com.fireengineering.management.mapper;

import com.fireengineering.management.po.User;
import com.fireengineering.management.po.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectByLimitAndOffset(@Param("offset")Integer offset, @Param("limit")Integer limit);

    User selectByUsername(@Param("userUsername") String userUsername);

    List<User> getAllName();

}