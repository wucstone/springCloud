package com.wucstone.order.mapper.sharding;

import com.wucstone.order.domain.OrderDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {


    @Insert("insert into order (id,order_no) values (#{id},#{orderNo})")
    void saveOrder(OrderDO orderDO);

    @Select("select id , order_no  from order")
    List<OrderDO> selectOrders();
}
