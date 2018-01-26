package com.invoicing.core.dao.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.invoicing.core.bean.system.Role;
import com.invoicing.core.bean.system.User;
import com.invoicing.core.bean.system.UserQuery;

public interface UserDao {
    int countByExample(UserQuery example);

    int deleteByExample(UserQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserQuery example);

    User queryUserAndRolesByUsername(@Param("username") String username);

    List<Role> selectUserRoleById(Integer id);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserQuery example);

    int updateByExample(@Param("record") User record, @Param("example") UserQuery example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
