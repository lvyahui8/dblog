package org.lyh.dblog.ds.dao;

import org.apache.ibatis.annotations.Param;
import org.lyh.dblog.domain.Post;

import java.util.List;
import java.util.Map;

public interface IPostDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Post record);

    int insertSelective(Post record);

    Post selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKeyWithBLOBs(Post record);

    int updateByPrimaryKey(Post record);

    List<Post> select(@Param("conditions") Map<String, Object> conditions,
                      @Param("orderFiled") String orderFiled,
                      @Param("sort") String sort,
                      @Param("offset") Integer offset,
                      @Param("size") Integer size);
}