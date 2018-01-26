package com.invoicing.core.dao.system;

import com.invoicing.core.bean.system.Module;
import com.invoicing.core.bean.system.ModuleQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModuleDao {
    int countByExample(ModuleQuery example);

    int deleteByExample(ModuleQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Module record);

    int insertSelective(Module record);

    List<Module> selectByExample(ModuleQuery example);

    Module selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Module record, @Param("example") ModuleQuery example);

    int updateByExample(@Param("record") Module record, @Param("example") ModuleQuery example);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);
}