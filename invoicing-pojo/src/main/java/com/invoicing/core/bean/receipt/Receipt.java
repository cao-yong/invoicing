package com.invoicing.core.bean.receipt;

import java.io.Serializable;
import java.util.Date;

public class Receipt implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 单据编号：CGDJ-20150823-001 单据名+日期+三位数编号
     */
    private String receiptNo;

    /**
     * 单据日期
     */
    private Date receiptDate;

    /**
     * 单据类型：1=采购订单，2=采购退货单，3=销售订单，4=销售退货单，5=采购入库单，6=销售退货入库单，7=调拨入库单，8=销售出库单，9=采购退货出库单，9=调拨出库单，10=报损单，11=质检单，12=调拨单
     */
    private Byte receiptType;

    /**
     * 单据状态：1=待审核，2=审核通过，3=审核驳回，4=完成，5=部分收货，6=部分发货，7=预付款，8=预收款，9=全款已付，10=全款已收，11=调拨中,12=待收货
     */
    private Byte status;

    /**
     * 收货仓库
     */
    private String receiveDepot;

    /**
     * 发货仓库
     */
    private String sendDepot;

    /**
     * 来往单位，销售订单：电商，实体等
     */
    private String correspondents;

    /**
     * 发起人
     */
    private String originator;

    /**
     * 审计人
     */
    private String auditor;

    /**
     * 经手人
     */
    private String brokerage;

    /**
     * 单据来源
     */
    private String source;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 已结算金额
     */
    private String settledAmount;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 收货人
     */
    private String receiver;

    /**
     * 收货地址
     */
    private String receiverAddress;

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

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Byte getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(Byte receiptType) {
        this.receiptType = receiptType;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getReceiveDepot() {
        return receiveDepot;
    }

    public void setReceiveDepot(String receiveDepot) {
        this.receiveDepot = receiveDepot == null ? null : receiveDepot.trim();
    }

    public String getSendDepot() {
        return sendDepot;
    }

    public void setSendDepot(String sendDepot) {
        this.sendDepot = sendDepot == null ? null : sendDepot.trim();
    }

    public String getCorrespondents() {
        return correspondents;
    }

    public void setCorrespondents(String correspondents) {
        this.correspondents = correspondents == null ? null : correspondents.trim();
    }

    public String getOriginator() {
        return originator;
    }

    public void setOriginator(String originator) {
        this.originator = originator == null ? null : originator.trim();
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }

    public String getBrokerage() {
        return brokerage;
    }

    public void setBrokerage(String brokerage) {
        this.brokerage = brokerage == null ? null : brokerage.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getSettledAmount() {
        return settledAmount;
    }

    public void setSettledAmount(String settledAmount) {
        this.settledAmount = settledAmount == null ? null : settledAmount.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress == null ? null : receiverAddress.trim();
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
        sb.append(", receiptDate=").append(receiptDate);
        sb.append(", receiptType=").append(receiptType);
        sb.append(", status=").append(status);
        sb.append(", receiveDepot=").append(receiveDepot);
        sb.append(", sendDepot=").append(sendDepot);
        sb.append(", correspondents=").append(correspondents);
        sb.append(", originator=").append(originator);
        sb.append(", auditor=").append(auditor);
        sb.append(", brokerage=").append(brokerage);
        sb.append(", source=").append(source);
        sb.append(", userName=").append(userName);
        sb.append(", settledAmount=").append(settledAmount);
        sb.append(", phone=").append(phone);
        sb.append(", receiver=").append(receiver);
        sb.append(", receiverAddress=").append(receiverAddress);
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