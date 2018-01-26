package com.invoicing.core.bean.receipt;

import java.io.Serializable;
import java.util.Date;

public class ReceiptDetail implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 单据号
     */
    private String receiptNo;

    /**
     * 商品编号
     */
    private String goodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品类型
     */
    private String goodsType;

    /**
     * 产地
     */
    private String productionSite;

    /**
     * 单位
     */
    private String unit;

    /**
     * 数量
     */
    private Integer number;

    /**
     * 价格
     */
    private String price;

    /**
     * 库存
     */
    private String stock;

    /**
     * 已发货数量
     */
    private Integer deliveredNumber;

    /**
     * 未发货数量
     */
    private Integer undeliveredNumber;

    /**
     * 已收货数量
     */
    private Integer receivedNumber;

    /**
     * 未收货数量
     */
    private Integer unreceivedNumber;

    /**
     * 备注
     */
    private String remark;

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

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo == null ? null : receiptNo.trim();
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType == null ? null : goodsType.trim();
    }

    public String getProductionSite() {
        return productionSite;
    }

    public void setProductionSite(String productionSite) {
        this.productionSite = productionSite == null ? null : productionSite.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock == null ? null : stock.trim();
    }

    public Integer getDeliveredNumber() {
        return deliveredNumber;
    }

    public void setDeliveredNumber(Integer deliveredNumber) {
        this.deliveredNumber = deliveredNumber;
    }

    public Integer getUndeliveredNumber() {
        return undeliveredNumber;
    }

    public void setUndeliveredNumber(Integer undeliveredNumber) {
        this.undeliveredNumber = undeliveredNumber;
    }

    public Integer getReceivedNumber() {
        return receivedNumber;
    }

    public void setReceivedNumber(Integer receivedNumber) {
        this.receivedNumber = receivedNumber;
    }

    public Integer getUnreceivedNumber() {
        return unreceivedNumber;
    }

    public void setUnreceivedNumber(Integer unreceivedNumber) {
        this.unreceivedNumber = unreceivedNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
        sb.append(", receiptNo=").append(receiptNo);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", goodsType=").append(goodsType);
        sb.append(", productionSite=").append(productionSite);
        sb.append(", unit=").append(unit);
        sb.append(", number=").append(number);
        sb.append(", price=").append(price);
        sb.append(", stock=").append(stock);
        sb.append(", deliveredNumber=").append(deliveredNumber);
        sb.append(", undeliveredNumber=").append(undeliveredNumber);
        sb.append(", receivedNumber=").append(receivedNumber);
        sb.append(", unreceivedNumber=").append(unreceivedNumber);
        sb.append(", remark=").append(remark);
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