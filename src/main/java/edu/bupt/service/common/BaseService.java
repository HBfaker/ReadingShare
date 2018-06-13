package edu.bupt.service.common;

import edu.bupt.mapper.BaseMapper;

import java.io.Serializable;

/**
 * Created by 73681 on 2018/6/13.
 */
public interface BaseService<T,ID extends Serializable> {
    BaseMapper<T, ID> getMapper();
    int deleteByPrimaryKey(ID id);
    int insert(T record);
    int insertSelective(T record);
    T selectByPrimaryKey(ID id);
    int updateByPrimaryKeySelective(T record);
    int updateByPrimaryKeyWithBLOBs(T record);
    int updateByPrimaryKey(T record);
}
