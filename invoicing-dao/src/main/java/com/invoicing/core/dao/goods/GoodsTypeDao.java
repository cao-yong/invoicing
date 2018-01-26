package com.invoicing.core.dao.goods;

import com.invoicing.core.bean.goods.GoodsType;
import com.invoicing.core.bean.goods.GoodsTypeQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsTypeDao {
    int countByExample(GoodsTypeQuery example);

    int deleteByExample(GoodsTypeQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsType record);

    int insertSelective(GoodsType record);

    List<GoodsType> selectByExample(GoodsTypeQuery example);

    GoodsType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsType record, @Param("example") GoodsTypeQuery example);

    int updateByExample(@Param("record") GoodsType record, @Param("example") GoodsTypeQuery example);

    int updateByPrimaryKeySelective(GoodsType record);

    int updateByPrimaryKey(GoodsType record);
}