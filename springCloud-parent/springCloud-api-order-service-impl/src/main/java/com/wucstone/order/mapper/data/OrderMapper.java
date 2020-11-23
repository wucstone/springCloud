package com.wucstone.order.mapper.data;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wucstone.api.order.entity.CenterOrderDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface OrderMapper extends BaseMapper<CenterOrderDO>{


    @Select("select * from card_search where merchant_id = 50 ")
    Map<String,String> saveOrder();
}
