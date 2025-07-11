package com.example.domain;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 分页查询实体类
 *
 * @author Lion Li
 */

@Data
public class PageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 分页大小
     */
    @JsonProperty("PAGE_SIZE")
    private Integer pageSize;

    /**
     * 当前页数
     */
    @JsonProperty("PAGE_NUM")
    private Integer pageNum;

    /**
     * 当前记录起始索引 默认值
     */
    public static final int DEFAULT_PAGE_NUM = 1;

    /**
     * 每页显示记录数 默认值 默认查全部
     */
    public static final int DEFAULT_PAGE_SIZE = Integer.MAX_VALUE;

    public <T> Page<T> build() {
        Integer pageNum = Objects.isNull(getPageNum())?DEFAULT_PAGE_NUM:getPageNum();
        Integer pageSize = Objects.isNull(getPageSize())?DEFAULT_PAGE_SIZE:getPageSize();
        if (pageNum <= 0) {
            pageNum = DEFAULT_PAGE_NUM;
        }
        Page<T> page = new Page<>(pageNum, pageSize);
//        List<OrderItem> orderItems = buildOrderItem();
//        if (CollUtil.isNotEmpty(orderItems)) {
//            page.addOrder(orderItems);
//        }
        return page;
    }

    /**
     * 构建排序
     *
     * 支持的用法如下:
     * {isAsc:"asc",orderByColumn:"id"} order by id asc
     * {isAsc:"asc",orderByColumn:"id,createTime"} order by id asc,create_time asc
     * {isAsc:"desc",orderByColumn:"id,createTime"} order by id desc,create_time desc
     * {isAsc:"asc,desc",orderByColumn:"id,createTime"} order by id asc,create_time desc
     */
    private List<OrderItem> buildOrderItem() {
//        if (StringUtils.isBlank(orderByColumn) || StringUtils.isBlank(isAsc)) {
//            return null;
//        }
//        String orderBy = SqlUtil.escapeOrderBySql(orderByColumn);
//        orderBy = StringUtils.toUnderScoreCase(orderBy);
//
//        // 兼容前端排序类型
//        isAsc = StringUtils.replaceEach(isAsc, new String[]{"ascending", "descending"}, new String[]{"asc", "desc"});
//
//        String[] orderByArr = orderBy.split(StringUtils.SEPARATOR);
//        String[] isAscArr = isAsc.split(StringUtils.SEPARATOR);
//        if (isAscArr.length != 1 && isAscArr.length != orderByArr.length) {
//            throw new ServiceException("排序参数有误");
//        }
//
//        List<OrderItem> list = new ArrayList<>();
//        // 每个字段各自排序
//        for (int i = 0; i < orderByArr.length; i++) {
//            String orderByStr = orderByArr[i];
//            String isAscStr = isAscArr.length == 1 ? isAscArr[0] : isAscArr[i];
//            if ("asc".equals(isAscStr)) {
//                list.add(OrderItem.asc(orderByStr));
//            } else if ("desc".equals(isAscStr)) {
//                list.add(OrderItem.desc(orderByStr));
//            } else {
//                throw new ServiceException("排序参数有误");
//            }
//        }
//        return list;
        return null;
    }

}
