package com.invoicing.core.dao.customer;

import com.invoicing.core.bean.customer.Customer;
import com.invoicing.core.bean.customer.CustomerQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerDao {
    int countByExample(CustomerQuery example);

    int deleteByExample(CustomerQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Customer record);

    int insertSelective(Customer record);

    List<Customer> selectByExample(CustomerQuery example);

    Customer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerQuery example);

    int updateByExample(@Param("record") Customer record, @Param("example") CustomerQuery example);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
}