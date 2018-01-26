package com.invoicing.core.dao.receipt;

import com.invoicing.core.bean.receipt.ReceiptDetail;
import com.invoicing.core.bean.receipt.ReceiptDetailQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReceiptDetailDao {
    int countByExample(ReceiptDetailQuery example);

    int deleteByExample(ReceiptDetailQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReceiptDetail record);

    int insertSelective(ReceiptDetail record);

    List<ReceiptDetail> selectByExample(ReceiptDetailQuery example);

    ReceiptDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReceiptDetail record, @Param("example") ReceiptDetailQuery example);

    int updateByExample(@Param("record") ReceiptDetail record, @Param("example") ReceiptDetailQuery example);

    int updateByPrimaryKeySelective(ReceiptDetail record);

    int updateByPrimaryKey(ReceiptDetail record);
}