package com.wucstone.api.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("center_order")
public class CenterOrderDO extends Model<CenterOrderDO>{


        private static final long serialVersionUID = 1L;

        /**
         * id
         */
        @TableId(value = "id", type = IdType.AUTO)
        private Integer id;

        /**
         * 订单号
         */
        private String orderNo;
        /**
         * 订单号
         */
        private String name;
}
