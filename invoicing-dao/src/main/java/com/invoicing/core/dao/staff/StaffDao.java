package com.invoicing.core.dao.staff;

import com.invoicing.core.bean.staff.Staff;
import com.invoicing.core.bean.staff.StaffQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaffDao {
    int countByExample(StaffQuery example);

    int deleteByExample(StaffQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Staff record);

    int insertSelective(Staff record);

    List<Staff> selectByExample(StaffQuery example);

    Staff selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Staff record, @Param("example") StaffQuery example);

    int updateByExample(@Param("record") Staff record, @Param("example") StaffQuery example);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);
}