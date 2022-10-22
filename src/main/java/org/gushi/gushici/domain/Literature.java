package org.gushi.gushici.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName literature
 */
@TableName(value ="literature")
@Data
public class Literature implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 作品id
     */
    @TableField(fill = FieldFill.INSERT)
    private String literatureId;

    /**
     * 作者id
     */
    private String authorId;

    /**
     * 作品图片
     */
    private String literatureImg;

    /**
     * 文体 ：1 诗 2词 3歌 4赋 5元曲
     */
    private Integer type;

    /**
     * 词牌名
     */
    private String detailType;

    /**
     * 内容
     */
    private String content;

    /**
     * 释义
     */
    private String interpretation;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy年MM月dd日")
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
     * 是否启用 1 启用 0 未启用
     */
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
        Literature other = (Literature) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLiteratureId() == null ? other.getLiteratureId() == null : this.getLiteratureId().equals(other.getLiteratureId()))
            && (this.getAuthorId() == null ? other.getAuthorId() == null : this.getAuthorId().equals(other.getAuthorId()))
            && (this.getLiteratureImg() == null ? other.getLiteratureImg() == null : this.getLiteratureImg().equals(other.getLiteratureImg()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getDetailType() == null ? other.getDetailType() == null : this.getDetailType().equals(other.getDetailType()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getInterpretation() == null ? other.getInterpretation() == null : this.getInterpretation().equals(other.getInterpretation()))
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
        result = prime * result + ((getLiteratureId() == null) ? 0 : getLiteratureId().hashCode());
        result = prime * result + ((getAuthorId() == null) ? 0 : getAuthorId().hashCode());
        result = prime * result + ((getLiteratureImg() == null) ? 0 : getLiteratureImg().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getDetailType() == null) ? 0 : getDetailType().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getInterpretation() == null) ? 0 : getInterpretation().hashCode());
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
        sb.append(", literatureId=").append(literatureId);
        sb.append(", authorId=").append(authorId);
        sb.append(", literatureImg=").append(literatureImg);
        sb.append(", type=").append(type);
        sb.append(", detailType=").append(detailType);
        sb.append(", content=").append(content);
        sb.append(", interpretation=").append(interpretation);
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