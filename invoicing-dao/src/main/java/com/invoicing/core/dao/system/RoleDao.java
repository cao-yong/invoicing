package com.invoicing.core.dao.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.invoicing.core.bean.system.Role;
import com.invoicing.core.bean.system.RoleQuery;

public interface RoleDao {
    int countByExample(RoleQuery example);

    int deleteByExample(RoleQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleQuery example);

    Role selectByPrimaryKey(Long id);

    Role selectRoleMenusByRoleId(String roleId);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleQuery example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleQuery example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}
