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
 *@comments 代码表实体类
 *@author wangxiaodong
 *@date 2013-5-17 下午4:10:37 
 *@version 1.0
 */
@Entity
@Table(name = "M_ITEM")
public class Mitem implements java.io.Serializable {

	private static final long serialVersionUID = 2818291583235071581L;

	// Fields
	private String itemId;
	private Mtype mtype;
	private String PItemId;
	private String itemName;
	private String itemDesc;
	private short itemOrd;
	private String delFlg;
	private Timestamp createTime;

	// Constructors

	
	
	
	/** default constructor */
	public Mitem() {
	}

	
	/** full constructor */
	public Mitem(Mtype mtype, String PItemId, String itemName, String itemDesc,
			short itemOrd, String delFlg, Timestamp createTime) {
		this.mtype = mtype;
		this.PItemId = PItemId;
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.itemOrd = itemOrd;
		this.delFlg = delFlg;
		this.createTime = createTime;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ITEM_ID", unique = true, nullable = false, length = 40)
	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TYPE_ID")
	public Mtype getMtype() {
		return this.mtype;
	}

	public void setMtype(Mtype mtype) {
		this.mtype = mtype;
	}

	@Column(name = "P_ITEM_ID", length = 10)
	public String getPItemId() {
		return this.PItemId;
	}

	public void setPItemId(String PItemId) {
		this.PItemId = PItemId;
	}

	@Column(name = "ITEM_NAME", length = 100)
	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Column(name = "ITEM_DESC", length = 1000)
	public String getItemDesc() {
		return this.itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	@Column(name = "ITEM_ORD", precision = 3, scale = 0)
	public short getItemOrd() {
		return this.itemOrd;
	}

	public void setItemOrd(short itemOrd) {
		this.itemOrd = itemOrd;
	}

	@Column(name = "DEL_FLG", length = 1)
	public String getDelFlg() {
		return this.delFlg;
	}

	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	@Column(name = "CREATE_TIME")
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Override
	public boolean equals(Object obj) {
		boolean flag = true;
		if (obj == null || getClass() != obj.getClass()){
			return false;
		}
		Mitem pojo = (Mitem) obj;
		if(!itemId.equals(pojo.getItemId())){
			flag = false;
		}
		return flag;
	}
}