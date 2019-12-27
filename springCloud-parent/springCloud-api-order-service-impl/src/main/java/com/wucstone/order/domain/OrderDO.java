package com.wucstone.order.domain;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class OrderDO {

    private Long id;

    private String orderNo;

    private LocalDateTime createTime;


}
