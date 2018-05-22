package com.bugsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bugsystem.domain.Bug;

public interface BugMapper {
    @Delete({
        "delete from bug",
        "where bug_id = #{bugId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer bugId);

    @Insert({
        "insert into bug (bug_id, bug_name, ",
        "detail, project_id, ",
        "level, finished_status, ",
        "create_time)",
        "values (#{bugId,jdbcType=INTEGER}, #{bugName,jdbcType=CHAR}, ",
        "#{detail,jdbcType=CHAR}, #{projectId,jdbcType=INTEGER}, ",
        "#{level,jdbcType=INTEGER}, #{finishedStatus,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(Bug record);

    int insertSelective(Bug record);

    @Select({
        "select",
        "bug_id, bug_name, detail, project_id, level, finished_status, create_time",
        "from bug",
        "where bug_id = #{bugId,jdbcType=INTEGER}"
    })
    @ResultMap("com.bugsystem.dao.BugMapper.BaseResultMap")
    Bug selectByPrimaryKey(Integer bugId);

    int updateByPrimaryKeySelective(Bug record);

    @Update({
        "update bug",
        "set bug_name = #{bugName,jdbcType=CHAR},",
          "detail = #{detail,jdbcType=CHAR},",
          "project_id = #{projectId,jdbcType=INTEGER},",
          "level = #{level,jdbcType=INTEGER},",
          "finished_status = #{finishedStatus,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where bug_id = #{bugId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Bug record);
    
    List<Bug> getAllBug();
    List<Bug> getBugByUserId(@Param("userId")Integer userId);
    List<Bug> getBugByProjectId(@Param("projectId")Integer projectId);
 }