package org.lyh.dblog.ds.dao;

import org.apache.ibatis.annotations.Param;
import org.lyh.dblog.domain.BaseEntity;
import org.lyh.dblog.ds.bean.Condition;

import java.util.List;

/**
 * @author samlv
 */

public interface IBaseDao<T extends BaseEntity> {
    int deleteByPrimaryKey(Integer id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    List<T> select(@Param("conditions") List<Condition> conditions,
                      @Param("orderField") String orderField,
                      @Param("sort") String sort,
                      @Param("offset") Integer offset,
                      @Param("size") Integer size);

    List<T> all();
}
