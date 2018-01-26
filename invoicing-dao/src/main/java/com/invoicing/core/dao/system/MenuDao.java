package com.invoicing.core.dao.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.invoicing.core.bean.system.Menu;
import com.invoicing.core.bean.system.MenuQuery;
import com.invoicing.core.bean.system.MenuQueryDTO;

public interface MenuDao {
    int countByExample(MenuQuery example);

    int deleteByExample(MenuQuery example);

    int deleteByPrimaryKey(String id);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuQuery example);

    List<Menu> selectMenuList(MenuQueryDTO query);

    List<Menu> selectMenuListByUserId(Integer userId);

    Menu queryMenuById(String id);

    Integer countMenuList();

    Menu selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuQuery example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuQuery example);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}
