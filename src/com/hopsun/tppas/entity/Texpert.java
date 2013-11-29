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
 * Texpert entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_EXPERT")
public class Texpert implements java.io.Serializable {
	
	private static final long serialVersionUID = 3697613480398876256L;
	// Fields
	private String expertId;
	private String expertName;
	private String expertMajor;
	private String expertWork;
	private String expertJob;
	private String expertDegree;
	private String expertIncumbency;
	private String expertPrestige;
	private Timestamp registerTime;
	private String expertComment;
	private String sex;
	private Timestamp birthday;
	private String schooling;
	private String graduateSchool;
	private String skillJob;
	private String academicTitle;
	private String expertMajor1;
	private String expertMajor2;
	private String expertMajor3;
	private String recommendWork;
	private String workPhone;
	private String housePhone;
	private String phone;
	private String email;
	private String portraiture;
	private String researchFindings;
	private String expertStatus;
	private String deleteFlag;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateDate;
	private String updateUser;
	private String remark;
	private String deptType;
	private Set<TacceptanceExpertAudit> tacceptanceExpertAudits = new HashSet<TacceptanceExpertAudit>(0);
	private Set<TexpertScore> texpertScores = new HashSet<TexpertScore>(0);
	//2013-10-24加字段-专家类型
	private String expertType;

	// Constructors

	/** default constructor */
	public Texpert() {
	}

	/** full constructor */
	public Texpert(String expertName, String expertMajor, String expertWork,
			String expertJob, String expertDegree, String expertIncumbency,
			String expertPrestige, Timestamp registerTime, String expertComment,
			String sex, Timestamp birthday, String schooling,
			String graduateSchool, String skillJob, String academicTitle,
			String expertMajor1, String expertMajor2, String expertMajor3,
			String recommendWork, String workPhone, String housePhone,
			String phone, String email, String portraiture,
			String researchFindings, String expertStatus, String deleteFlag,
			Timestamp createTime, String createUser, Timestamp updateDate,
			String updateUser, String remark,String deptType,
			Set<TacceptanceExpertAudit> tacceptanceExpertAudits,
			Set<TexpertScore> texpertScores,
			String expertType) {
		this.expertName = expertName;
		this.expertMajor = expertMajor;
		this.expertWork = expertWork;
		this.expertJob = expertJob;
		this.expertDegree = expertDegree;
		this.expertIncumbency = expertIncumbency;
		this.expertPrestige = expertPrestige;
		this.registerTime = registerTime;
		this.expertComment = expertComment;
		this.sex = sex;
		this.birthday = birthday;
		this.schooling = schooling;
		this.graduateSchool = graduateSchool;
		this.skillJob = skillJob;
		this.academicTitle = academicTitle;
		this.expertMajor1 = expertMajor1;
		this.expertMajor2 = expertMajor2;
		this.expertMajor3 = expertMajor3;
		this.recommendWork = recommendWork;
		this.workPhone = workPhone;
		this.housePhone = housePhone;
		this.phone = phone;
		this.email = email;
		this.portraiture = portraiture;
		this.researchFindings = researchFindings;
		this.expertStatus = expertStatus;
		this.deleteFlag = deleteFlag;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
		this.remark = remark;
		this.deptType = deptType;
		this.tacceptanceExpertAudits = tacceptanceExpertAudits;
		this.texpertScores = texpertScores;
		this.expertType = expertType;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "EXPERT_ID", unique = true, nullable = false, length = 40)
	public String getExpertId() {
		return this.expertId;
	}

	public void setExpertId(String expertId) {
		this.expertId = expertId;
	}

	@Column(name = "EXPERT_NAME", length = 50)
	public String getExpertName() {
		return this.expertName;
	}

	public void setExpertName(String expertName) {
		this.expertName = expertName;
	}

	@Column(name = "EXPERT_MAJOR", length = 50)
	public String getExpertMajor() {
		return this.expertMajor;
	}

	public void setExpertMajor(String expertMajor) {
		this.expertMajor = expertMajor;
	}

	@Column(name = "EXPERT_WORK", length = 50)
	public String getExpertWork() {
		return this.expertWork;
	}

	public void setExpertWork(String expertWork) {
		this.expertWork = expertWork;
	}

	@Column(name = "EXPERT_JOB", length = 50)
	public String getExpertJob() {
		return this.expertJob;
	}

	public void setExpertJob(String expertJob) {
		this.expertJob = expertJob;
	}

	@Column(name = "EXPERT_DEGREE", length = 50)
	public String getExpertDegree() {
		return this.expertDegree;
	}

	public void setExpertDegree(String expertDegree) {
		this.expertDegree = expertDegree;
	}

	@Column(name = "EXPERT_INCUMBENCY", length = 1)
	public String getExpertIncumbency() {
		return this.expertIncumbency;
	}

	public void setExpertIncumbency(String expertIncumbency) {
		this.expertIncumbency = expertIncumbency;
	}

	@Column(name = "EXPERT_PRESTIGE", length = 40)
	public String getExpertPrestige() {
		return this.expertPrestige;
	}

	public void setExpertPrestige(String expertPrestige) {
		this.expertPrestige = expertPrestige;
	}

	@Column(name = "REGISTER_TIME")
	public Timestamp getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

	@Column(name = "EXPERT_COMMENT", length = 100)
	public String getExpertComment() {
		return this.expertComment;
	}

	public void setExpertComment(String expertComment) {
		this.expertComment = expertComment;
	}

	@Column(name = "SEX", length = 1)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "BIRTHDAY")
	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	@Column(name = "SCHOOLING", length = 50)
	public String getSchooling() {
		return this.schooling;
	}

	public void setSchooling(String schooling) {
		this.schooling = schooling;
	}

	@Column(name = "GRADUATE_SCHOOL", length = 50)
	public String getGraduateSchool() {
		return this.graduateSchool;
	}

	public void setGraduateSchool(String graduateSchool) {
		this.graduateSchool = graduateSchool;
	}

	@Column(name = "SKILL_JOB", length = 50)
	public String getSkillJob() {
		return this.skillJob;
	}

	public void setSkillJob(String skillJob) {
		this.skillJob = skillJob;
	}

	@Column(name = "ACADEMIC_TITLE", length = 50)
	public String getAcademicTitle() {
		return this.academicTitle;
	}

	public void setAcademicTitle(String academicTitle) {
		this.academicTitle = academicTitle;
	}

	@Column(name = "EXPERT_MAJOR1", length = 50)
	public String getExpertMajor1() {
		return this.expertMajor1;
	}

	public void setExpertMajor1(String expertMajor1) {
		this.expertMajor1 = expertMajor1;
	}

	@Column(name = "EXPERT_MAJOR2", length = 50)
	public String getExpertMajor2() {
		return this.expertMajor2;
	}

	public void setExpertMajor2(String expertMajor2) {
		this.expertMajor2 = expertMajor2;
	}

	@Column(name = "EXPERT_MAJOR3", length = 50)
	public String getExpertMajor3() {
		return this.expertMajor3;
	}

	public void setExpertMajor3(String expertMajor3) {
		this.expertMajor3 = expertMajor3;
	}

	@Column(name = "RECOMMEND_WORK", length = 50)
	public String getRecommendWork() {
		return this.recommendWork;
	}

	public void setRecommendWork(String recommendWork) {
		this.recommendWork = recommendWork;
	}

	@Column(name = "WORK_PHONE", length = 50)
	public String getWorkPhone() {
		return this.workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	@Column(name = "HOUSE_PHONE", length = 50)
	public String getHousePhone() {
		return this.housePhone;
	}

	public void setHousePhone(String housePhone) {
		this.housePhone = housePhone;
	}

	@Column(name = "PHONE", length = 50)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "EMAIL", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "PORTRAITURE", length = 50)
	public String getPortraiture() {
		return this.portraiture;
	}

	public void setPortraiture(String portraiture) {
		this.portraiture = portraiture;
	}

	@Column(name = "RESEARCH_FINDINGS", length =2000)
	public String getResearchFindings() {
		return this.researchFindings;
	}

	public void setResearchFindings(String researchFindings) {
		this.researchFindings = researchFindings;
	}

	@Column(name = "EXPERT_STATUS", length = 40)
	public String getExpertStatus() {
		return this.expertStatus;
	}

	public void setExpertStatus(String expertStatus) {
		this.expertStatus = expertStatus;
	}

	@Column(name = "DELETE_FLAG", length = 1)
	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Column(name = "CREATE_TIME")
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "CREATE_USER", length = 50)
	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(name = "UPDATE_DATE")
	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "UPDATE_USER", length = 50)
	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	@Column(name = "REMARK", length = 4000)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name = "DEPT_TYPE", length = 40)
	public String getDeptType() {
		return deptType;
	}

	public void setDeptType(String deptType) {
		this.deptType = deptType;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "texpert")
	public Set<TacceptanceExpertAudit> getTacceptanceExpertAudits() {
		return this.tacceptanceExpertAudits;
	}

	public void setTacceptanceExpertAudits(
			Set<TacceptanceExpertAudit> tacceptanceExpertAudits) {
		this.tacceptanceExpertAudits = tacceptanceExpertAudits;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "texpert")
	public Set<TexpertScore> getTexpertScores() {
		return this.texpertScores;
	}

	public void setTexpertScores(Set<TexpertScore> texpertScores) {
		this.texpertScores = texpertScores;
	}


	@Column(name = "EXPERT_TYPE", length = 40)
	public String getExpertType() {
		return expertType;
	}

	public void setExpertType(String expertType) {
		this.expertType = expertType;
	}
}