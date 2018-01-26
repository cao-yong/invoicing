package com.invoicing.core.bean.goods;

import java.io.Serializable;
import java.util.Date;

public class Goods implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 商品编号
     */
    private String goodsNo;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 数量
     */
    private Integer number;

    /**
     * 单位
     */
    private String unit;

    /**
     * 规格
     */
    private String spec;

    /**
     * 类型
     */
    private String goodsType;

    /**
     * 出厂地
     */
    private String productionSite;

    /**
     * 助记码
     */
    private String mnemonicCode;

    /**
     * 最大库存
     */
    private Integer upperLimit;

    /**
     * 销售价格
     */
    private String price;

    /**
     * 采购价
     */
    private String purchasePrice;

    /**
     * 主图片名
     */
    private String mainPicName;

    /**
     * 从图片
     */
    private String secondaryPicName;

    /**
     * 商品状态
     */
    private Integer goodsStatus;

    /**
     * 供应商编号
     */
    private String supplierCode;

    /**
     * 商品类别编号
     */
    private String goodsTypeNo;

    /**
     * 仓库编号
     */
    private String repoNo;

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

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo == null ? null : goodsNo.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
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

    public String getMnemonicCode() {
        return mnemonicCode;
    }

    public void setMnemonicCode(String mnemonicCode) {
        this.mnemonicCode = mnemonicCode == null ? null : mnemonicCode.trim();
    }

    public Integer getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(Integer upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(String purchasePrice) {
        this.purchasePrice = purchasePrice == null ? null : purchasePrice.trim();
    }

    public String getMainPicName() {
        return mainPicName;
    }

    public void setMainPicName(String mainPicName) {
        this.mainPicName = mainPicName == null ? null : mainPicName.trim();
    }

    public String getSecondaryPicName() {
        return secondaryPicName;
    }

    public void setSecondaryPicName(String secondaryPicName) {
        this.secondaryPicName = secondaryPicName == null ? null : secondaryPicName.trim();
    }

    public Integer getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Integer goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode == null ? null : supplierCode.trim();
    }

    public String getGoodsTypeNo() {
        return goodsTypeNo;
    }

    public void setGoodsTypeNo(String goodsTypeNo) {
        this.goodsTypeNo = goodsTypeNo == null ? null : goodsTypeNo.trim();
    }

    public String getRepoNo() {
        return repoNo;
    }

    public void setRepoNo(String repoNo) {
        this.repoNo = repoNo == null ? null : repoNo.trim();
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
        sb.append(", goodsNo=").append(goodsNo);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", number=").append(number);
        sb.append(", unit=").append(unit);
        sb.append(", spec=").append(spec);
        sb.append(", goodsType=").append(goodsType);
        sb.append(", productionSite=").append(productionSite);
        sb.append(", mnemonicCode=").append(mnemonicCode);
        sb.append(", upperLimit=").append(upperLimit);
        sb.append(", price=").append(price);
        sb.append(", purchasePrice=").append(purchasePrice);
        sb.append(", mainPicName=").append(mainPicName);
        sb.append(", secondaryPicName=").append(secondaryPicName);
        sb.append(", goodsStatus=").append(goodsStatus);
        sb.append(", supplierCode=").append(supplierCode);
        sb.append(", goodsTypeNo=").append(goodsTypeNo);
        sb.append(", repoNo=").append(repoNo);
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