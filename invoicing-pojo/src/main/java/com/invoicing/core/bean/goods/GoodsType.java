package com.invoicing.core.bean.goods;

import java.io.Serializable;
import java.util.Date;

public class GoodsType implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 商品类别编号
     */
    private String goodTypeNo;

    /**
     * 类别名称
     */
    private String typeName;

    /**
     * 所属类别ID(父id)
     */
    private String parendId;

    /**
     * url地址
     */
    private String url;

    /**
     * 复选框
     */
    private Integer checkbox;

    /**
     * 显示的节点图标
     */
    private String nodeIcon;

    /**
     * 节点状态，open 或 closed
     */
    private String nodeType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 修改者
     */
    private String modifier;

    /**
     * 扩展字段
     */
    private String extraInfo;

    /**
     * 是否删除（Y：是，N：否）
     */
    private String isDeleted;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodTypeNo() {
        return goodTypeNo;
    }

    public void setGoodTypeNo(String goodTypeNo) {
        this.goodTypeNo = goodTypeNo == null ? null : goodTypeNo.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getParendId() {
        return parendId;
    }

    public void setParendId(String parendId) {
        this.parendId = parendId == null ? null : parendId.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getCheckbox() {
        return checkbox;
    }

    public void setCheckbox(Integer checkbox) {
        this.checkbox = checkbox;
    }

    public String getNodeIcon() {
        return nodeIcon;
    }

    public void setNodeIcon(String nodeIcon) {
        this.nodeIcon = nodeIcon == null ? null : nodeIcon.trim();
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType == null ? null : nodeType.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo == null ? null : extraInfo.trim();
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", goodTypeNo=").append(goodTypeNo);
        sb.append(", typeName=").append(typeName);
        sb.append(", parendId=").append(parendId);
        sb.append(", url=").append(url);
        sb.append(", checkbox=").append(checkbox);
        sb.append(", nodeIcon=").append(nodeIcon);
        sb.append(", nodeType=").append(nodeType);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", creator=").append(creator);
        sb.append(", modifier=").append(modifier);
        sb.append(", extraInfo=").append(extraInfo);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}