package com.invoicing.core.dao.repository;

import com.invoicing.core.bean.repository.Repository;
import com.invoicing.core.bean.repository.RepositoryQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepositoryDao {
    int countByExample(RepositoryQuery example);

    int deleteByExample(RepositoryQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Repository record);

    int insertSelective(Repository record);

    List<Repository> selectByExample(RepositoryQuery example);

    Repository selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Repository record, @Param("example") RepositoryQuery example);

    int updateByExample(@Param("record") Repository record, @Param("example") RepositoryQuery example);

    int updateByPrimaryKeySelective(Repository record);

    int updateByPrimaryKey(Repository record);
}