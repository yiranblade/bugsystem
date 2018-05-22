package com.bugsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bugsystem.domain.Bug_user;

public interface Bug_userMapper {
    @Delete({
        "delete from bug_user",
        "where bug_userid = #{bugUserid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer bugUserid);

    @Insert({
        "insert into bug_user (bug_userid, bug_id, ",
        "user_id, create_time)",
        "values (#{bugUserid,jdbcType=INTEGER}, #{bugId,jdbcType=INTEGER}, ",
        "#{userId,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(Bug_user record);

    int insertSelective(Bug_user record);

    @Select({
        "select",
        "bug_userid, bug_id, user_id, create_time",
        "from bug_user",
        "where bug_userid = #{bugUserid,jdbcType=INTEGER}"
    })
    @ResultMap("com.bugsystem.dao.Bug_userMapper.BaseResultMap")
    Bug_user selectByPrimaryKey(Integer bugUserid);
    
    @Select({
        "select",
        "bug_userid, bug_id, user_id, create_time",
        "from bug_user"
    })
    @ResultMap("com.bugsystem.dao.Bug_userMapper.BaseResultMap")
    List<Bug_user> selectAll();

    int updateByPrimaryKeySelective(Bug_user record);

    @Update({
        "update bug_user",
        "set bug_id = #{bugId,jdbcType=INTEGER},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where bug_userid = #{bugUserid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Bug_user record);
}