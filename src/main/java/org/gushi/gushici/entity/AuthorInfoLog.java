package org.gushi.gushici.entity;

import lombok.Data;

import java.util.Date;

/**
 * Author: fang
 * Date:   2022-02-19 21:04 星期六
 * Class:  AuthorInfoLog
 **/
@Data
public class AuthorInfoLog {

    private Long log_id;

    /**
     *  操作人ID
     */
    private String operatorID;

    /**
     *  操作人
     */
    private String operator;

    /**
     *  操作IP
     */
    private String operatorIP;

    /**
     *  操作名称
     */
    private String operate;
    /**
     *操作内容
     */
    private Date operationContent;

    /**
     *操作时间
     */
    private Date operationTime;

    /**
     *模块名称
     */
    private String module_name;
    /**
     *类名称
     */
    private String class_name;

    /**
     *方法名称
     */
    private String method_name;

    /**
     *传入参数
     */
    private String params;


    private String desc;

    private String desc2;


}
