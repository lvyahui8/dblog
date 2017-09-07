package org.lyh.dblog.ds.service;


import org.lyh.dblog.domain.BaseEntity;

import java.util.List;
import java.util.Map;

/**
 * @author samlv
 */
public interface IBaseService<T extends BaseEntity> {
    boolean save(T entity);

    List<T> select(Map<String,Object> conditions,
                   String orderFiled,
                   String sort,
                   Integer offset,
                   Integer size
    );

    T find(Integer id);

    List<T> all();
}
