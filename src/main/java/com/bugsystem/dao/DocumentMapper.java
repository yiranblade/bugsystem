package com.bugsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bugsystem.domain.Document;

public interface DocumentMapper {
    @Delete({
        "delete from document",
        "where docum_id = #{documId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer documId);

    @Insert({
        "insert into document (docum_id, docum_url, ",
        "docum_type, project_id, ",
        "create_time)",
        "values (#{documId,jdbcType=INTEGER}, #{documUrl,jdbcType=CHAR}, ",
        "#{documType,jdbcType=CHAR}, #{projectId,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(Document record);

    int insertSelective(Document record);

    @Select({
        "select",
        "docum_id, docum_url, docum_type, project_id, create_time",
        "from document",
        "where docum_id = #{documId,jdbcType=INTEGER}"
    })
    @ResultMap("com.bugsystem.dao.DocumentMapper.BaseResultMap")
    Document selectByPrimaryKey(Integer documId);

    int updateByPrimaryKeySelective(Document record);

    @Update({
        "update document",
        "set docum_url = #{documUrl,jdbcType=CHAR},",
          "docum_type = #{documType,jdbcType=CHAR},",
          "project_id = #{projectId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where docum_id = #{documId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Document record);
    
    List<Document> getAllDocuments();
    List<Document> getDocumentByProjectId(@Param("projectId")Integer projectId);
}