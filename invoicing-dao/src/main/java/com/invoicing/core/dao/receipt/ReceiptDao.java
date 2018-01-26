package com.invoicing.core.dao.receipt;

import com.invoicing.core.bean.receipt.Receipt;
import com.invoicing.core.bean.receipt.ReceiptQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReceiptDao {
    int countByExample(ReceiptQuery example);

    int deleteByExample(ReceiptQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Receipt record);

    int insertSelective(Receipt record);

    List<Receipt> selectByExample(ReceiptQuery example);

    Receipt selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Receipt record, @Param("example") ReceiptQuery example);

    int updateByExample(@Param("record") Receipt record, @Param("example") ReceiptQuery example);

    int updateByPrimaryKeySelective(Receipt record);

    int updateByPrimaryKey(Receipt record);
}