package com.hopsun.tppas.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
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
 *@comments 代码类型实体类
 *@author wangxiaodong
 *@date 2013-5-17 下午4:11:40 
 *@version 1.0
 */
@Entity
@Table(name = "M_TYPE")
public class Mtype implements java.io.Serializable {

	private static final long serialVersionUID = 1028206331185955046L;
	// Fields
	private String typeId;
	private String typeName;
	private String typeDsc;
	private String pTypeFlag;
	private String PTypeId;
	private String delFlg;
	private String ptypeName;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Set<Mitem> mitems = new HashSet<Mitem>(0);

	// Constructors

	/** default constructor */
	public Mtype() {
	}

	/** full constructor */
	public Mtype(String typeName, String typeDsc, String pTypeFlag,
			String PTypeId, String delFlg, Timestamp createTime,Timestamp updateTime,Set<Mitem> mitems) {
		this.typeName = typeName;
		this.typeDsc = typeDsc;
		this.pTypeFlag = pTypeFlag;
		this.PTypeId = PTypeId;
		this.delFlg = delFlg;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.mitems = mitems;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "TYPE_ID", unique = true, nullable = false, length = 40)
	public String getTypeId() {
		return this.typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	@Column(name = "TYPE_NAME", length = 100)
	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Column(name = "TYPE_DSC", length = 1000)
	public String getTypeDsc() {
		return this.typeDsc;
	}

	public void setTypeDsc(String typeDsc) {
		this.typeDsc = typeDsc;
	}

	@Column(name = "P_TYPE_FLAG", length = 1)
	public String getPTypeFlag() {
		return this.pTypeFlag;
	}

	public void setPTypeFlag(String pTypeFlag) {
		this.pTypeFlag = pTypeFlag;
	}

	@Column(name = "P_TYPE_ID", length = 40)
	public String getPTypeId() {
		return this.PTypeId;
	}

	public void setPTypeId(String PTypeId) {
		this.PTypeId = PTypeId;
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
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "UPDATE_TIME")
	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mtype")
	public Set<Mitem> getMitems() {
		return this.mitems;
	}

	public void setMitems(Set<Mitem> mitems) {
		this.mitems = mitems;
	}

	public String getPtypeName() {
		return ptypeName;
	}

	public void setPtypeName(String ptypeName) {
		this.ptypeName = ptypeName;
	}

}