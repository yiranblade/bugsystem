package com.bugsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bugsystem.domain.Project;

public interface ProjectMapper {
    @Delete({
        "delete from project",
        "where project_id = #{projectId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer projectId);

    @Insert({
        "insert into project (project_id, name, ",
        "create_user, type, document_id, ",
        "create_time, descr)",
        "values (#{projectId,jdbcType=INTEGER}, #{name,jdbcType=CHAR}, ",
        "#{createUser,jdbcType=CHAR}, #{type,jdbcType=VARCHAR}, #{documentId,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{descr,jdbcType=LONGVARCHAR})"
    })
    int insert(Project record);

    int insertSelective(Project record);

    @Select({
        "select",
        "project_id, name, create_user, type, document_id, create_time, descr",
        "from project",
        "where project_id = #{projectId,jdbcType=INTEGER}"
    })
    @ResultMap("com.bugsystem.dao.ProjectMapper.ResultMapWithBLOBs")
    Project selectByPrimaryKey(Integer projectId);

    int updateByPrimaryKeySelective(Project record);

    @Update({
        "update project",
        "set name = #{name,jdbcType=CHAR},",
          "create_user = #{createUser,jdbcType=CHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "document_id = #{documentId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "descr = #{descr,jdbcType=LONGVARCHAR}",
        "where project_id = #{projectId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Project record);

    @Update({
        "update project",
        "set name = #{name,jdbcType=CHAR},",
          "create_user = #{createUser,jdbcType=CHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "document_id = #{documentId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where project_id = #{projectId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Project record);
    
    List<Project> selectAllProject();
    List<Project> selectProjectByUserName(@Param("userName")String username);
}