package org.lyh.dblog.ds.dao;


import org.apache.ibatis.annotations.Mapper;
import org.lyh.dblog.domain.Post;

@Mapper
public interface IPostDao extends IBaseDao<Post> {

}