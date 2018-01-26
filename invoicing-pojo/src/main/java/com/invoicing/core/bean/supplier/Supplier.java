package com.invoicing.core.bean.supplier;

import java.io.Serializable;
import java.util.Date;

public class Supplier implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 供货商编号
     */
    private String supplierNo;

    /**
     * 供货商名称
     */
    private String supplierName;

    /**
     * 供应商简称
     */
    private String shortName;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 联系人名字
     */
    private String name;

    /**
     * 性别(0女，1男)
     */
    private Byte sex;

    /**
     * 地址
     */
    private String address;

    /**
     * 开户行
     */
    private String depositBank;

    /**
     * 银行账号
     */
    private String accountNumber;

    /**
     * 商品类别编号
     */
    private String goodsTypeNo;

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

    public String getSupplierNo() {
        return supplierNo;
    }

    public void setSupplierNo(String supplierNo) {
        this.supplierNo = supplierNo == null ? null : supplierNo.trim();
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getDepositBank() {
        return depositBank;
    }

    public void setDepositBank(String depositBank) {
        this.depositBank = depositBank == null ? null : depositBank.trim();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber == null ? null : accountNumber.trim();
    }

    public String getGoodsTypeNo() {
        return goodsTypeNo;
    }

    public void setGoodsTypeNo(String goodsTypeNo) {
        this.goodsTypeNo = goodsTypeNo == null ? null : goodsTypeNo.trim();
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
        sb.append(", supplierNo=").append(supplierNo);
        sb.append(", supplierName=").append(supplierName);
        sb.append(", shortName=").append(shortName);
        sb.append(", phone=").append(phone);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", address=").append(address);
        sb.append(", depositBank=").append(depositBank);
        sb.append(", accountNumber=").append(accountNumber);
        sb.append(", goodsTypeNo=").append(goodsTypeNo);
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