package com.bugsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bugsystem.domain.User;

public interface UserMapper {
    @Delete({
        "delete from user",
        "where user_name = #{userName,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String userName);

    @Insert({
        "insert into user (user_name, user_password, ",
        "role, create_time)",
        "values (#{userName,jdbcType=CHAR}, #{userPassword,jdbcType=CHAR}, ",
        "#{role,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(User record);

    int insertSelective(User record);

    @Select({
        "select",
        "user_name, user_password, role, create_time",
        "from user",
        "where user_name = #{userName,jdbcType=CHAR}"
    })
    @ResultMap("com.bugsystem.dao.UserMapper.BaseResultMap")
    User selectByPrimaryKey(String userName);


	@Select({
		"select",
        "user_name,user_password,role,create_time",
        "from user",
        "where user_name = #{userName,jdbcType=CHAR} and user_password=#{password,jdbcType=CHAR}"
		
	})
	@ResultMap("com.bugsystem.dao.UserMapper.BaseResultMap")
	User LoginService(@Param("userName")String userName,@Param("password")String password); 
    
	int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
        "set user_password = #{userPassword,jdbcType=CHAR},",
          "role = #{role,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where user_name = #{userName,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(User record);
    
    
    List<User> selectAllUser();
}