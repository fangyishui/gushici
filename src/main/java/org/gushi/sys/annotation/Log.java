package org.gushi.sys.annotation;

import org.gushi.sys.enums.BusinessType;
import org.gushi.sys.enums.OperatorType;

import java.lang.annotation.*;


/**
 * 自定义操作日志记录注解
 *
 * @author ruoyi
 *
 *  //@Inherited如果被用于一个class，这个注解（annotation）将被用于该class的子类
 * // 声明注解的保留期限
 * @Target({ ElementType.PARAMETER, ElementType.METHOD })
 * // 声明可以使用该注解的目标类型
 * @Retention(RetentionPolicy.RUNTIME)
 * // 标记可被如javadoc的工具文档化
 * @Documented
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log
{
    /**
     * 模块
     */
    public String title() default "";

    /**
     * 功能
     */
    public BusinessType businessType() default BusinessType.OTHER;

    /**
     * 操作人类别
     */
    public OperatorType operatorType() default OperatorType.MANAGE;

    /**
     * 是否保存请求的参数
     */
    public boolean isSaveRequestData() default true;

    /**
     * 是否保存响应的参数
     */
    public boolean isSaveResponseData() default true;
}
