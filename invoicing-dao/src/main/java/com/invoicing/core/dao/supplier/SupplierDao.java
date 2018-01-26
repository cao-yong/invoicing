package com.invoicing.core.dao.supplier;

import com.invoicing.core.bean.supplier.Supplier;
import com.invoicing.core.bean.supplier.SupplierQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupplierDao {
    int countByExample(SupplierQuery example);

    int deleteByExample(SupplierQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    List<Supplier> selectByExample(SupplierQuery example);

    Supplier selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Supplier record, @Param("example") SupplierQuery example);

    int updateByExample(@Param("record") Supplier record, @Param("example") SupplierQuery example);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);
}