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
 * TacceptanceOpinionA entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_ACCEPTANCE_OPINION_A")
public class TacceptanceOpinionA implements java.io.Serializable {

	private static final long serialVersionUID = -4116447717817654778L;
	// Fields
	private String opinionId;
	private Tacceptance tacceptance;
	private String acceptanceOpinion;
	private String acceptanceLeader;
	private String acceptanceDeputyLeader1;
	private String acceptanceDeputyLeader2;
	private Timestamp acceptanceTime;
	private String presideOpinion;
	private String presideLeader;
	private Timestamp presideTime;
	private String organizeOpinion;
	private String organizeLeader;
	private Timestamp organizeTime;
	private String createUser;
	private Timestamp createTime;
	private String updateUser;
	private Timestamp updateTime;
	private String deleteFlag;

	// Constructors

	/** default constructor */
	public TacceptanceOpinionA() {
	}

	/** full constructor */
	public TacceptanceOpinionA(Tacceptance tacceptance,
			String acceptanceOpinion, String acceptanceLeader,
			String acceptanceDeputyLeader1, String acceptanceDeputyLeader2,
			Timestamp acceptanceTime, String presideOpinion, String presideLeader,
			Timestamp presideTime, String organizeOpinion, String organizeLeader,
			Timestamp organizeTime, String createUser, Timestamp createTime,
			String updateUser, Timestamp updateTime, String deleteFlag) {
		this.tacceptance = tacceptance;
		this.acceptanceOpinion = acceptanceOpinion;
		this.acceptanceLeader = acceptanceLeader;
		this.acceptanceDeputyLeader1 = acceptanceDeputyLeader1;
		this.acceptanceDeputyLeader2 = acceptanceDeputyLeader2;
		this.acceptanceTime = acceptanceTime;
		this.presideOpinion = presideOpinion;
		this.presideLeader = presideLeader;
		this.presideTime = presideTime;
		this.organizeOpinion = organizeOpinion;
		this.organizeLeader = organizeLeader;
		this.organizeTime = organizeTime;
		this.createUser = createUser;
		this.createTime = createTime;
		this.updateUser = updateUser;
		this.updateTime = updateTime;
		this.deleteFlag = deleteFlag;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "OPINION_ID", unique = true, nullable = false, length = 40)
	public String getOpinionId() {
		return this.opinionId;
	}

	public void setOpinionId(String opinionId) {
		this.opinionId = opinionId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCEPTANCE_ID")
	public Tacceptance getTacceptance() {
		return this.tacceptance;
	}

	public void setTacceptance(Tacceptance tacceptance) {
		this.tacceptance = tacceptance;
	}

	@Column(name = "ACCEPTANCE_OPINION", length = 4000)
	public String getAcceptanceOpinion() {
		return this.acceptanceOpinion;
	}

	public void setAcceptanceOpinion(String acceptanceOpinion) {
		this.acceptanceOpinion = acceptanceOpinion;
	}

	@Column(name = "ACCEPTANCE_LEADER", length = 15)
	public String getAcceptanceLeader() {
		return this.acceptanceLeader;
	}

	public void setAcceptanceLeader(String acceptanceLeader) {
		this.acceptanceLeader = acceptanceLeader;
	}

	@Column(name = "ACCEPTANCE_DEPUTY_LEADER_1", length = 15)
	public String getAcceptanceDeputyLeader1() {
		return this.acceptanceDeputyLeader1;
	}

	public void setAcceptanceDeputyLeader1(String acceptanceDeputyLeader1) {
		this.acceptanceDeputyLeader1 = acceptanceDeputyLeader1;
	}

	@Column(name = "ACCEPTANCE_DEPUTY_LEADER_2", length = 15)
	public String getAcceptanceDeputyLeader2() {
		return this.acceptanceDeputyLeader2;
	}

	public void setAcceptanceDeputyLeader2(String acceptanceDeputyLeader2) {
		this.acceptanceDeputyLeader2 = acceptanceDeputyLeader2;
	}

	@Column(name = "ACCEPTANCE_TIME")
	public Timestamp getAcceptanceTime() {
		return this.acceptanceTime;
	}

	public void setAcceptanceTime(Timestamp acceptanceTime) {
		this.acceptanceTime = acceptanceTime;
	}

	@Column(name = "PRESIDE_OPINION", length = 4000)
	public String getPresideOpinion() {
		return this.presideOpinion;
	}

	public void setPresideOpinion(String presideOpinion) {
		this.presideOpinion = presideOpinion;
	}

	@Column(name = "PRESIDE_LEADER", length = 15)
	public String getPresideLeader() {
		return this.presideLeader;
	}

	public void setPresideLeader(String presideLeader) {
		this.presideLeader = presideLeader;
	}

	@Column(name = "PRESIDE_TIME")
	public Timestamp getPresideTime() {
		return this.presideTime;
	}

	public void setPresideTime(Timestamp presideTime) {
		this.presideTime = presideTime;
	}

	@Column(name = "ORGANIZE_OPINION", length = 4000)
	public String getOrganizeOpinion() {
		return this.organizeOpinion;
	}

	public void setOrganizeOpinion(String organizeOpinion) {
		this.organizeOpinion = organizeOpinion;
	}

	@Column(name = "ORGANIZE_LEADER", length = 15)
	public String getOrganizeLeader() {
		return this.organizeLeader;
	}

	public void setOrganizeLeader(String organizeLeader) {
		this.organizeLeader = organizeLeader;
	}

	@Column(name = "ORGANIZE_TIME")
	public Timestamp getOrganizeTime() {
		return this.organizeTime;
	}

	public void setOrganizeTime(Timestamp organizeTime) {
		this.organizeTime = organizeTime;
	}

	@Column(name = "CREATE_USER", length = 40)
	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(name = "CREATE_TIME")
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "UPDATE_USER", length = 40)
	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	@Column(name = "UPDATE_TIME")
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "DELETE_FLAG", length = 1)
	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}