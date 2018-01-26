package com.invoicing.core.dao.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.invoicing.core.bean.system.RoleMenu;
import com.invoicing.core.bean.system.RoleMenuBatchDO;
import com.invoicing.core.bean.system.RoleMenuQuery;

public interface RoleMenuDao {
    int countByExample(RoleMenuQuery example);

    int deleteByExample(RoleMenuQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoleMenu record);

    int insertSelective(RoleMenu record);

    int insertBatch(RoleMenuBatchDO batchDO);

    List<RoleMenu> selectByExample(RoleMenuQuery example);

    RoleMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoleMenu record, @Param("example") RoleMenuQuery example);

    int updateByExample(@Param("record") RoleMenu record, @Param("example") RoleMenuQuery example);

    int updateByPrimaryKeySelective(RoleMenu record);

    int updateByPrimaryKey(RoleMenu record);
}
