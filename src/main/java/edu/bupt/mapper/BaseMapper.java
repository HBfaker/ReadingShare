package edu.bupt.mapper;

import java.io.Serializable;

/**
 * Created by 73681 on 2018/6/13.
 * 基础mapper
 */
public interface BaseMapper<T,ID extends Serializable> {

    int deleteByPrimaryKey(ID id);
    int insert(T record);
    int insertSelective(T record);
    T selectByPrimaryKey(ID id);
    int updateByPrimaryKeySelective(T record);
    int updateByPrimaryKeyWithBLOBs(T record);
    int updateByPrimaryKey(T record);
}
