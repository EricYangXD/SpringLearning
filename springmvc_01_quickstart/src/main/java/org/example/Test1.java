package org.example;

import org.springframework.beans.BeanUtils;

import java.util.Date;

public class Test1 {

    public static void main(String[] args) {
        OrderDTO orderDTO = new OrderDTO();
//        orderDTO.setId(1L);
//        orderDTO.setUserId(123L);
//        orderDTO.setOrderNo("20210518000001");
//        orderDTO.setGmtCreated(new Date());
//
//        OrderVO orderVO = new OrderVO();
//        orderVO.setId(orderDTO.getId());
//        orderVO.setUserId(orderDTO.getUserId());
//        orderVO.setOrderNo(orderDTO.getOrderNo());
//        orderVO.setGmtCreated(orderDTO.getGmtCreated());
//
//        System.out.println(orderVO.getId());
//        System.out.println(orderVO.getUserId());
//        System.out.println(orderVO.getOrderNo());
//        System.out.println(orderVO.getGmtCreated());

        OrderVO orderVO = new OrderVO();
//        很多公司都禁止在项目中使用该工具BeanUtils.copyProperties。
        BeanUtils.copyProperties(orderDTO,orderVO);

    }
}

