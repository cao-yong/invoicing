package com.invoicing.core.bean.repository;

import java.io.Serializable;
import java.util.Date;

public class Repository implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 仓库编号
     */
    private String repoNo;

    /**
     * 仓库名称
     */
    private String repoName;

    /**
     * 仓库地址
     */
    private String repoAddress;

    /**
     * 仓库联系人
     */
    private String contact;

    /**
     * 联系方式
     */
    private String contactPhone;

    /**
     * 性别(0女，1男)
     */
    private Byte contactSex;

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

    public String getRepoNo() {
        return repoNo;
    }

    public void setRepoNo(String repoNo) {
        this.repoNo = repoNo == null ? null : repoNo.trim();
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName == null ? null : repoName.trim();
    }

    public String getRepoAddress() {
        return repoAddress;
    }

    public void setRepoAddress(String repoAddress) {
        this.repoAddress = repoAddress == null ? null : repoAddress.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public Byte getContactSex() {
        return contactSex;
    }

    public void setContactSex(Byte contactSex) {
        this.contactSex = contactSex;
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
        sb.append(", repoNo=").append(repoNo);
        sb.append(", repoName=").append(repoName);
        sb.append(", repoAddress=").append(repoAddress);
        sb.append(", contact=").append(contact);
        sb.append(", contactPhone=").append(contactPhone);
        sb.append(", contactSex=").append(contactSex);
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