package org.gushi.gushici.entity;

import lombok.Data;

/**
 * Author: fang
 * Date:   2022-02-20 10:00 星期日
 * Class:  OrderInfo
 **/

@Data
public class OrderInfo {

    private Long id;
    private String author_id;
    private String works_id;

    /**
     * 1 作者
     * 2 作品
     * 3 作品类别
     * 4 作品 词牌名
     */
    private Integer order_type;

    private Integer order_num;
}
