package com.invoicing.core.dao.goods;

import com.invoicing.core.bean.goods.Goods;
import com.invoicing.core.bean.goods.GoodsQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsDao {
    int countByExample(GoodsQuery example);

    int deleteByExample(GoodsQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExample(GoodsQuery example);

    Goods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsQuery example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsQuery example);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
}