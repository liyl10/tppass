package com.hopsun.tppas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *@comments 行政区划实体类
 *@author wangxiaodong
 *@date 2013-5-17 下午4:10:10 
 *@version 1.0
 */
@Entity
@Table(name = "M_ADDR")
public class Maddr implements java.io.Serializable {

	private static final long serialVersionUID = 7877015403243842617L;
	// Fields
	private String addrId;
	private String addrName;
	private String PAddrId;
	private String abbreviation;
	private short addrOrder;
	private String delFlg;

	// Constructors

	/** default constructor */
	public Maddr() {
	}

	/** full constructor */
	public Maddr(String addrName, String PAddrId, String abbreviation,
			short addrOrder, String delFlg) {
		this.addrName = addrName;
		this.PAddrId = PAddrId;
		this.abbreviation = abbreviation;
		this.addrOrder = addrOrder;
		this.delFlg = delFlg;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ADDR_ID", unique = true, nullable = false, length = 40)
	public String getAddrId() {
		return this.addrId;
	}

	public void setAddrId(String addrId) {
		this.addrId = addrId;
	}

	@Column(name = "ADDR_NAME", length = 50)
	public String getAddrName() {
		return this.addrName;
	}

	public void setAddrName(String addrName) {
		this.addrName = addrName;
	}

	@Column(name = "P_ADDR_ID", length = 10)
	public String getPAddrId() {
		return this.PAddrId;
	}

	public void setPAddrId(String PAddrId) {
		this.PAddrId = PAddrId;
	}

	@Column(name = "ABBREVIATION", length = 20)
	public String getAbbreviation() {
		return this.abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	@Column(name = "ADDR_ORDER", precision = 3, scale = 0)
	public short getAddrOrder() {
		return this.addrOrder;
	}

	public void setAddrOrder(short addrOrder) {
		this.addrOrder = addrOrder;
	}

	@Column(name = "DEL_FLG", length = 1)
	public String getDelFlg() {
		return this.delFlg;
	}

	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

}