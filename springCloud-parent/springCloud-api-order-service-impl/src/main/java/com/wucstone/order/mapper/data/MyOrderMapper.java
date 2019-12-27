package com.wucstone.order.mapper.data;

import com.wucstone.order.domain.OrderDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyOrderMapper {


    @Insert("insert into order (id,order_no) values (#{id},#{orderNo})")
    void saveOrder(OrderDO orderDO);
}
