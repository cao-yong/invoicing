package com.invoicing.core.dao.finance;

import com.invoicing.core.bean.finance.FinanceAccount;
import com.invoicing.core.bean.finance.FinanceAccountQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FinanceAccountDao {
    int countByExample(FinanceAccountQuery example);

    int deleteByExample(FinanceAccountQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(FinanceAccount record);

    int insertSelective(FinanceAccount record);

    List<FinanceAccount> selectByExample(FinanceAccountQuery example);

    FinanceAccount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FinanceAccount record, @Param("example") FinanceAccountQuery example);

    int updateByExample(@Param("record") FinanceAccount record, @Param("example") FinanceAccountQuery example);

    int updateByPrimaryKeySelective(FinanceAccount record);

    int updateByPrimaryKey(FinanceAccount record);
}