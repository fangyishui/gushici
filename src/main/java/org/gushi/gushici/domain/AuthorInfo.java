package org.gushi.gushici.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName author_info
 */
@TableName(value ="author_info")
@Data
public class AuthorInfo implements Serializable {
    /**
     * ID
     * ASSIGN_ID	分配 ID(主键类型为 Number(Long 和 Integer)或 String)(since 3.3.0),
     * 使用接口IdentifierGenerator的方法nextId(默认实现类为DefaultIdentifierGenerator雪花算法)
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 作者ID
     */
    @TableField(fill = FieldFill.INSERT)
    private String authorId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 姓
     */
    private String xing;

    /**
     * 名
     */
    private String ming;

    /**
     * 字
     */
    private String zi;

    /**
     * 号
     */
    private String hao;

    /**
     * 年代
     */
    private String years;

    /**
     * 短介绍
     */
    private String shortDescription;

    /**
     * 详细介绍
     */
    private String description;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 更新人
     */
    private String updatePerson;

    /**
     * 是否启用
     */
//    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer enable;

    /**
     * 备注
     */
    private String remarks;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AuthorInfo other = (AuthorInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAuthorId() == null ? other.getAuthorId() == null : this.getAuthorId().equals(other.getAuthorId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getXing() == null ? other.getXing() == null : this.getXing().equals(other.getXing()))
            && (this.getMing() == null ? other.getMing() == null : this.getMing().equals(other.getMing()))
            && (this.getZi() == null ? other.getZi() == null : this.getZi().equals(other.getZi()))
            && (this.getHao() == null ? other.getHao() == null : this.getHao().equals(other.getHao()))
            && (this.getYears() == null ? other.getYears() == null : this.getYears().equals(other.getYears()))
            && (this.getShortDescription() == null ? other.getShortDescription() == null : this.getShortDescription().equals(other.getShortDescription()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdatePerson() == null ? other.getUpdatePerson() == null : this.getUpdatePerson().equals(other.getUpdatePerson()))
            && (this.getEnable() == null ? other.getEnable() == null : this.getEnable().equals(other.getEnable()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAuthorId() == null) ? 0 : getAuthorId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getXing() == null) ? 0 : getXing().hashCode());
        result = prime * result + ((getMing() == null) ? 0 : getMing().hashCode());
        result = prime * result + ((getZi() == null) ? 0 : getZi().hashCode());
        result = prime * result + ((getHao() == null) ? 0 : getHao().hashCode());
        result = prime * result + ((getYears() == null) ? 0 : getYears().hashCode());
        result = prime * result + ((getShortDescription() == null) ? 0 : getShortDescription().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdatePerson() == null) ? 0 : getUpdatePerson().hashCode());
        result = prime * result + ((getEnable() == null) ? 0 : getEnable().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", authorId=").append(authorId);
        sb.append(", name=").append(name);
        sb.append(", xing=").append(xing);
        sb.append(", ming=").append(ming);
        sb.append(", zi=").append(zi);
        sb.append(", hao=").append(hao);
        sb.append(", years=").append(years);
        sb.append(", shortDescription=").append(shortDescription);
        sb.append(", description=").append(description);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updatePerson=").append(updatePerson);
        sb.append(", enable=").append(enable);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}