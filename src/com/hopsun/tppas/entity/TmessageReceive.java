package com.hopsun.tppas.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TmessageReceive entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_MESSAGE_RECEIVE")
public class TmessageReceive implements java.io.Serializable {
	
	private static final long serialVersionUID = 4241265357668400299L;

	// Fields
	private String receiveId;
	private TmessageSend tmessageSend;
	private String receiveUserId;
	private Timestamp receiveTime;
	private boolean isRead;
	private String deleteFlag;
	private String remark;

	// Constructors

	/** default constructor */
	public TmessageReceive() {
	}

	/** full constructor */
	public TmessageReceive(TmessageSend tmessageSend, String receiveUserId,
			Timestamp receiveTime, boolean isRead, String deleteFlag, String remark) {
		this.tmessageSend = tmessageSend;
		this.receiveUserId = receiveUserId;
		this.receiveTime = receiveTime;
		this.isRead = isRead;
		this.deleteFlag = deleteFlag;
		this.remark = remark;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "RECEIVE_ID", unique = true, nullable = false, length = 40)
	public String getReceiveId() {
		return this.receiveId;
	}

	public void setReceiveId(String receiveId) {
		this.receiveId = receiveId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SEND_ID")
	public TmessageSend getTmessageSend() {
		return this.tmessageSend;
	}

	public void setTmessageSend(TmessageSend tmessageSend) {
		this.tmessageSend = tmessageSend;
	}

	@Column(name = "RECEIVE_USER_ID", length = 40)
	public String getReceiveUserId() {
		return this.receiveUserId;
	}

	public void setReceiveUserId(String receiveUserId) {
		this.receiveUserId = receiveUserId;
	}

	@Column(name = "RECEIVE_TIME")
	public Timestamp getReceiveTime() {
		return this.receiveTime;
	}

	public void setReceiveTime(Timestamp receiveTime) {
		this.receiveTime = receiveTime;
	}

	@Column(name = "IS_READ", precision = 1, scale = 0)
	public boolean getIsRead() {
		return this.isRead;
	}

	public void setIsRead(boolean isRead) {
		this.isRead = isRead;
	}

	@Column(name = "DELETE_FLAG", length = 1)
	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Column(name = "REMARK", length = 1000)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}