package com.bugsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bugsystem.domain.UserInfo;

public interface UserInfoMapper {
    @Delete({
        "delete from user_info",
        "where user_id = #{userId,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String userId);

    @Delete({
        "delete from user_info",
        "where user_name = #{userId,jdbcType=CHAR}"
    })
    int deleteByUserName(String userId);
    
    @Insert({
        "insert into user_info (user_id, name, ",
        "department, create_time, ",
        "user_name, email)",
        "values (#{userId,jdbcType=CHAR}, #{name,jdbcType=CHAR}, ",
        "#{department,jdbcType=CHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{userName,jdbcType=CHAR}, #{email,jdbcType=VARCHAR})"
    })
    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    @Select({
        "select",
        "user_id, name, department, create_time, user_name, email",
        "from user_info",
        "where user_id = #{userId,jdbcType=CHAR}"
    })
    @ResultMap("com.bugsystem.dao.UserInfoMapper.BaseResultMap")
    UserInfo selectByPrimaryKey(String userId);
    
    @Select({
        "select",
        "user_id, name, department, create_time, user_name, email",
        "from user_info",
        "where user_name = #{userName,jdbcType=CHAR}"
    })
    @ResultMap("com.bugsystem.dao.UserInfoMapper.BaseResultMap")
    UserInfo selectByUserName(String userName);

    
    
    int updateByPrimaryKeySelective(UserInfo record);

    @Update({
        "update user_info",
        "set name = #{name,jdbcType=CHAR},",
          "department = #{department,jdbcType=CHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "user_name = #{userName,jdbcType=CHAR},",
          "email = #{email,jdbcType=VARCHAR}",
        "where user_id = #{userId,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(UserInfo record);
    List<UserInfo> getAllUserInfo();
}