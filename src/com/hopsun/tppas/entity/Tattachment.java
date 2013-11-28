package com.hopsun.tppas.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *@comments 附件实体类
 *@author wangxiaodong
 *@date 2013-5-17 下午4:20:26 
 *@version 1.0
 */
@Entity
@Table(name = "T_ATTACHMENT")
public class Tattachment implements java.io.Serializable {

	private static final long serialVersionUID = 3571336519361256733L;
	// Fields
	private String attachmentId;
	private String tableName;
	private String key1;
	private String key2;
	private String key3;
	private String attachmentName;
	private String fileType;
	private String attachmentType;
	private String attachmentSize;
	private String attachmentAddress;
	private Timestamp uploadTime;
	private String userId;
	private int sequence;
	private String explanation;

	// Constructors

	/** default constructor */
	public Tattachment() {
	}

	/** full constructor */
	public Tattachment(String tableName, String key1, String key2, String key3,
			String attachmentName, String fileType, String attachmentType,
			String attachmentSize, String attachmentAddress, Timestamp uploadTime,
			String userId, int sequence, String explanation) {
		this.tableName = tableName;
		this.key1 = key1;
		this.key2 = key2;
		this.key3 = key3;
		this.attachmentName = attachmentName;
		this.fileType = fileType;
		this.attachmentType = attachmentType;
		this.attachmentSize = attachmentSize;
		this.attachmentAddress = attachmentAddress;
		this.uploadTime = uploadTime;
		this.userId = userId;
		this.sequence = sequence;
		this.explanation = explanation;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ATTACHMENT_ID", unique = true, nullable = false, length = 40)
	public String getAttachmentId() {
		return this.attachmentId;
	}

	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}

	@Column(name = "TABLE_NAME", length = 50)
	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Column(name = "KEY1", length = 40)
	public String getKey1() {
		return this.key1;
	}

	public void setKey1(String key1) {
		this.key1 = key1;
	}

	@Column(name = "KEY2", length = 40)
	public String getKey2() {
		return this.key2;
	}

	public void setKey2(String key2) {
		this.key2 = key2;
	}

	@Column(name = "KEY3", length = 40)
	public String getKey3() {
		return this.key3;
	}

	public void setKey3(String key3) {
		this.key3 = key3;
	}

	@Column(name = "ATTACHMENT_NAME", length = 100)
	public String getAttachmentName() {
		return this.attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	@Column(name = "FILE_TYPE", length = 10)
	public String getFileType() {
		return this.fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	@Column(name = "ATTACHMENT_TYPE", length = 10)
	public String getAttachmentType() {
		return this.attachmentType;
	}

	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}

	@Column(name = "ATTACHMENT_SIZE", length = 100)
	public String getAttachmentSize() {
		return this.attachmentSize;
	}

	public void setAttachmentSize(String attachmentSize) {
		this.attachmentSize = attachmentSize;
	}

	@Column(name = "ATTACHMENT_ADDRESS", length = 200)
	public String getAttachmentAddress() {
		return this.attachmentAddress;
	}

	public void setAttachmentAddress(String attachmentAddress) {
		this.attachmentAddress = attachmentAddress;
	}

	@Column(name = "UPLOAD_TIME")
	public Timestamp getUploadTime() {
		return this.uploadTime;
	}

	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}

	@Column(name = "USER_ID", length = 40)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Column(name = "SEQUENCE", length = 10)
	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	@Column(name = "EXPLANATION", length = 60)
	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	
	
	
	
	

}