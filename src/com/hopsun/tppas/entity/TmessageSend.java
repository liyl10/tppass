package com.hopsun.tppas.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TmessageSend entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_MESSAGE_SEND")
public class TmessageSend implements java.io.Serializable {

	private static final long serialVersionUID = 5947322877446498032L;
	// Fields

	private String sendId;
	private String sendUserId;
	private String sendTitle;
	private String sendContent;
	private boolean sendType;
	private Timestamp sendTime;
	private boolean sendState;
	private String deleteFlag;
	private String remark;
	private List<TmessageReceive> tmessageReceives = new ArrayList<TmessageReceive>(0);

	// Constructors

	/** default constructor */
	public TmessageSend() {
	}

	/** full constructor */
	public TmessageSend(String sendUserId, String sendTitle,
			String sendContent, boolean sendType, Timestamp sendTime,
			boolean sendState, String deleteFlag, String remark,
			List<TmessageReceive> tmessageReceives) {
		this.sendUserId = sendUserId;
		this.sendTitle = sendTitle;
		this.sendContent = sendContent;
		this.sendType = sendType;
		this.sendTime = sendTime;
		this.sendState = sendState;
		this.deleteFlag = deleteFlag;
		this.remark = remark;
		this.tmessageReceives = tmessageReceives;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "SEND_ID", unique = true, nullable = false, length = 40)
	public String getSendId() {
		return this.sendId;
	}

	public void setSendId(String sendId) {
		this.sendId = sendId;
	}

	@Column(name = "SEND_USER_ID", length = 40)
	public String getSendUserId() {
		return this.sendUserId;
	}

	public void setSendUserId(String sendUserId) {
		this.sendUserId = sendUserId;
	}

	@Column(name = "SEND_TITLE", length = 200)
	public String getSendTitle() {
		return this.sendTitle;
	}

	public void setSendTitle(String sendTitle) {
		this.sendTitle = sendTitle;
	}

	@Column(name = "SEND_CONTENT", length = 4000)
	public String getSendContent() {
		return this.sendContent;
	}

	public void setSendContent(String sendContent) {
		this.sendContent = sendContent;
	}

	@Column(name = "SEND_TYPE", precision = 1, scale = 0)
	public boolean getSendType() {
		return this.sendType;
	}

	public void setSendType(boolean sendType) {
		this.sendType = sendType;
	}

	@Column(name = "SEND_TIME")
	public Timestamp getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}

	@Column(name = "SEND_STATE", precision = 1, scale = 0)
	public boolean getSendState() {
		return this.sendState;
	}

	public void setSendState(boolean sendState) {
		this.sendState = sendState;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tmessageSend")
	public List<TmessageReceive> getTmessageReceives() {
		return this.tmessageReceives;
	}

	public void setTmessageReceives(List<TmessageReceive> tmessageReceives) {
		this.tmessageReceives = tmessageReceives;
	}

}