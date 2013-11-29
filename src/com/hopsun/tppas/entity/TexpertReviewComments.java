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
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * TexpertReviewComments entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_EXPERT_REVIEW_COMMENTS")
public class TexpertReviewComments implements java.io.Serializable {
	
	private static final long serialVersionUID = -543611229570466860L;
	// Fields
	private String expertReviewCommentsId;
	private TprojectType tprojectType;
	private String expertType;
	private String expertReviewCommentsName;
	private String evaluationIndex1;
	private String evaluationIndex2;
	private String evaluationIndex3;
	private String evaluationIndex4;
	private String evaluationIndex5;
	
	private String evaluationShows1;
	private String evaluationShows2;
	private String evaluationShows3;
	private String evaluationShows4;
	private String evaluationShows5;
	private Integer score1;
	private Integer score2;
	private Integer score3;
	private Integer score4;
	private Integer score5;
	private String codePoints1;
	private String codePoints2;
	private String codePoints3;
	private String codePoints4;
	private String codePoints5;
	private String codePoints6;
	private String codePoints7;
	private String codePoints8;
	private String codePoints9;
	private String codePoints10;
	private String codePoints11;
	private String codePoints12;
	private String codePoints13;
	private String codePoints14;
	private String codePoints15;
	private Integer remarksScore1;
	private Integer remarksScore2;
	private Integer remarksScore3;
	private Integer remarksScore4;
	private Integer remarksScore5;
	private Integer remarksScore6;

	private String deleteFlag;
	private Timestamp createTime;
	private String createUser;
	private Timestamp updateDate;
	private String updateUser;
	private String remark;
	// 临时字段，显示计划类别
	private String typeShowName1;
	private String expertTypeName;
	private String typeId;
	
	// Constructors

	/** default constructor */
	public TexpertReviewComments() {
	}

	/** full constructor */
	public TexpertReviewComments(TprojectType tprojectType,String expertType,String expertReviewCommentsName,String evaluationIndex1,String evaluationIndex2,String evaluationIndex3,
			String evaluationIndex4,String evaluationIndex5,String evaluationShows1,String evaluationShows2,
			String evaluationShows3,String evaluationShows4,String evaluationShows5,
			Integer score1, Integer score2, Integer score3, Integer score4, Integer score5,String codePoints1,
			String codePoints2, String codePoints3, String codePoints4, String codePoints5,String codePoints6,
			String codePoints7,String codePoints8,String codePoints9,String codePoints10,String codePoints11,
			String codePoints12, String codePoints13, String codePoints14, String codePoints15,
			Integer remarksScore1, Integer remarksScore2, Integer remarksScore3, Integer remarksScore4,
			Integer remarksScore5,Integer remarksScore6,
			String deleteFlag,Timestamp createTime, String createUser, Timestamp updateDate,
			String updateUser, String remark,String typeShowName1,String expertTypeName,String typeId) {
		this.tprojectType = tprojectType;
		this.expertType = expertType;
		this.expertReviewCommentsName = expertReviewCommentsName;
		this.evaluationIndex1 = evaluationIndex1;
		this.evaluationIndex2 = evaluationIndex2;
		this.evaluationIndex3 = evaluationIndex3;
		this.evaluationIndex4 = evaluationIndex4;
		this.evaluationIndex5 = evaluationIndex5;
		this.evaluationShows1 = evaluationShows1;
		this.evaluationShows2 = evaluationShows2;
		this.evaluationShows3 = evaluationShows3;
		this.evaluationShows4 = evaluationShows4;
		this.evaluationShows5 = evaluationShows5;
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
		this.score4 = score4;
		this.score5 = score5;
		this.codePoints1 = codePoints1;
		this.codePoints2 = codePoints2;
		this.codePoints3 = codePoints3;
		this.codePoints4 = codePoints4;
		this.codePoints5 = codePoints5;
		this.codePoints1 = codePoints6;
		this.codePoints2 = codePoints7;
		this.codePoints3 = codePoints8;
		this.codePoints4 = codePoints9;
		this.codePoints5 = codePoints10;
		this.codePoints1 = codePoints11;
		this.codePoints2 = codePoints12;
		this.codePoints3 = codePoints13;
		this.codePoints4 = codePoints14;
		this.codePoints5 = codePoints15;
		this.remarksScore1 = remarksScore1;
		this.remarksScore2 = remarksScore2;
		this.remarksScore3 = remarksScore3;
		this.remarksScore4 = remarksScore4;
		this.remarksScore5 = remarksScore5;
		this.remarksScore6 = remarksScore6;
		
		this.deleteFlag = deleteFlag;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
		this.remark = remark;
		this.typeShowName1 = typeShowName1;
		this.expertTypeName = expertTypeName;
		this.typeId = typeId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "EXPERT_REVIEW_COMMENTS_ID", unique = true, nullable = false, length = 40)
	public String getExpertReviewCommentsId() {
		return expertReviewCommentsId;
	}
	
	public void setExpertReviewCommentsId(String expertReviewCommentsId) {
		this.expertReviewCommentsId = expertReviewCommentsId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TYPE_ID")
	public TprojectType getTprojectType() {
		return tprojectType;
	}
	
	public void setTprojectType(TprojectType tprojectType) {
		this.tprojectType = tprojectType;
	}

	@Column(name = "EXPERT_TYPE", length = 40)
	public String getExpertType() {
		return expertType;
	}

	public void setExpertType(String expertType) {
		this.expertType = expertType;
	}

	@Column(name = "EXPERT_REVIEW_COMMENTS_NAME", length = 200)
	public String getExpertReviewCommentsName() {
		return expertReviewCommentsName;
	}

	public void setExpertReviewCommentsName(String expertReviewCommentsName) {
		this.expertReviewCommentsName = expertReviewCommentsName;
	}

	@Column(name = "EVALUATION_INDEX_1", length = 20)
	public String getEvaluationIndex1() {
		return evaluationIndex1;
	}

	public void setEvaluationIndex1(String evaluationIndex1) {
		this.evaluationIndex1 = evaluationIndex1;
	}
	@Column(name = "EVALUATION_INDEX_2", length = 20)
	public String getEvaluationIndex2() {
		return evaluationIndex2;
	}

	public void setEvaluationIndex2(String evaluationIndex2) {
		this.evaluationIndex2 = evaluationIndex2;
	}
	@Column(name = "EVALUATION_INDEX_3", length = 20)
	public String getEvaluationIndex3() {
		return evaluationIndex3;
	}

	public void setEvaluationIndex3(String evaluationIndex3) {
		this.evaluationIndex3 = evaluationIndex3;
	}
	@Column(name = "EVALUATION_INDEX_4", length = 20)
	public String getEvaluationIndex4() {
		return evaluationIndex4;
	}

	public void setEvaluationIndex4(String evaluationIndex4) {
		this.evaluationIndex4 = evaluationIndex4;
	}
	@Column(name = "EVALUATION_INDEX_5", length = 20)
	public String getEvaluationIndex5() {
		return evaluationIndex5;
	}

	public void setEvaluationIndex5(String evaluationIndex5) {
		this.evaluationIndex5 = evaluationIndex5;
	}
	@Column(name = "EVALUATION_SHOWS_1", length = 50)
	public String getEvaluationShows1() {
		return evaluationShows1;
	}

	public void setEvaluationShows1(String evaluationShows1) {
		this.evaluationShows1 = evaluationShows1;
	}
	@Column(name = "EVALUATION_SHOWS_2", length = 50)
	public String getEvaluationShows2() {
		return evaluationShows2;
	}

	public void setEvaluationShows2(String evaluationShows2) {
		this.evaluationShows2 = evaluationShows2;
	}
	@Column(name = "EVALUATION_SHOWS_3", length = 50)
	public String getEvaluationShows3() {
		return evaluationShows3;
	}

	public void setEvaluationShows3(String evaluationShows3) {
		this.evaluationShows3 = evaluationShows3;
	}
	@Column(name = "EVALUATION_SHOWS_4", length = 50)
	public String getEvaluationShows4() {
		return evaluationShows4;
	}

	public void setEvaluationShows4(String evaluationShows4) {
		this.evaluationShows4 = evaluationShows4;
	}
	@Column(name = "EVALUATION_SHOWS_5", length = 50)
	public String getEvaluationShows5() {
		return evaluationShows5;
	}

	public void setEvaluationShows5(String evaluationShows5) {
		this.evaluationShows5 = evaluationShows5;
	}
	@Column(name = "SCORE1", precision = 4, scale = 0)
	public Integer getScore1() {
		return score1;
	}

	public void setScore1(Integer score1) {
		this.score1 = score1;
	}
	@Column(name = "SCORE2", precision = 4, scale = 0)
	public Integer getScore2() {
		return score2;
	}

	public void setScore2(Integer score2) {
		this.score2 = score2;
	}
	@Column(name = "SCORE3", precision = 4, scale = 0)
	public Integer getScore3() {
		return score3;
	}

	public void setScore3(Integer score3) {
		this.score3 = score3;
	}
	@Column(name = "SCORE4", precision = 4, scale = 0)
	public Integer getScore4() {
		return score4;
	}

	public void setScore4(Integer score4) {
		this.score4 = score4;
	}
	@Column(name = "SCORE5", precision = 4, scale = 0)
	public Integer getScore5() {
		return score5;
	}

	public void setScore5(Integer score5) {
		this.score5 = score5;
	}
	@Column(name = "CODE_POINTS_1", length = 50)
	public String getCodePoints1() {
		return codePoints1;
	}

	public void setCodePoints1(String codePoints1) {
		this.codePoints1 = codePoints1;
	}
	@Column(name = "CODE_POINTS_2", length = 50)
	public String getCodePoints2() {
		return codePoints2;
	}

	public void setCodePoints2(String codePoints2) {
		this.codePoints2 = codePoints2;
	}
	@Column(name = "CODE_POINTS_3", length = 50)
	public String getCodePoints3() {
		return codePoints3;
	}

	public void setCodePoints3(String codePoints3) {
		this.codePoints3 = codePoints3;
	}
	@Column(name = "CODE_POINTS_4", length = 50)
	public String getCodePoints4() {
		return codePoints4;
	}

	public void setCodePoints4(String codePoints4) {
		this.codePoints4 = codePoints4;
	}
	@Column(name = "CODE_POINTS_5", length = 50)
	public String getCodePoints5() {
		return codePoints5;
	}

	public void setCodePoints5(String codePoints5) {
		this.codePoints5 = codePoints5;
	}
	
	@Column(name = "CODE_POINTS_6", length = 50)
	public String getCodePoints6() {
		return codePoints6;
	}

	public void setCodePoints6(String codePoints6) {
		this.codePoints6 = codePoints6;
	}
	@Column(name = "CODE_POINTS_7", length = 50)
	public String getCodePoints7() {
		return codePoints7;
	}

	public void setCodePoints7(String codePoints7) {
		this.codePoints7 = codePoints7;
	}
	@Column(name = "CODE_POINTS_8", length = 50)
	public String getCodePoints8() {
		return codePoints8;
	}

	public void setCodePoints8(String codePoints8) {
		this.codePoints8 = codePoints8;
	}
	@Column(name = "CODE_POINTS_9", length = 50)
	public String getCodePoints9() {
		return codePoints9;
	}

	public void setCodePoints9(String codePoints9) {
		this.codePoints9 = codePoints9;
	}
	@Column(name = "CODE_POINTS_10", length = 50)
	public String getCodePoints10() {
		return codePoints10;
	}

	public void setCodePoints10(String codePoints10) {
		this.codePoints10 = codePoints10;
	}
	@Column(name = "CODE_POINTS_11", length = 50)
	public String getCodePoints11() {
		return codePoints11;
	}

	public void setCodePoints11(String codePoints11) {
		this.codePoints11 = codePoints11;
	}
	@Column(name = "CODE_POINTS_12", length = 50)
	public String getCodePoints12() {
		return codePoints12;
	}

	public void setCodePoints12(String codePoints12) {
		this.codePoints12 = codePoints12;
	}
	@Column(name = "CODE_POINTS_13", length = 50)
	public String getCodePoints13() {
		return codePoints13;
	}

	public void setCodePoints13(String codePoints13) {
		this.codePoints13 = codePoints13;
	}
	@Column(name = "CODE_POINTS_14", length = 50)
	public String getCodePoints14() {
		return codePoints14;
	}

	public void setCodePoints14(String codePoints14) {
		this.codePoints14 = codePoints14;
	}
	@Column(name = "CODE_POINTS_15", length = 50)
	public String getCodePoints15() {
		return codePoints15;
	}

	public void setCodePoints15(String codePoints15) {
		this.codePoints15 = codePoints15;
	}

	@Column(name = "REMARKS_SCORE1", precision = 4, scale = 0)
	public Integer getRemarksScore1() {
		return remarksScore1;
	}

	public void setRemarksScore1(Integer remarksScore1) {
		this.remarksScore1 = remarksScore1;
	}
	@Column(name = "REMARKS_SCORE2", precision = 4, scale = 0)
	public Integer getRemarksScore2() {
		return remarksScore2;
	}

	public void setRemarksScore2(Integer remarksScore2) {
		this.remarksScore2 = remarksScore2;
	}
	@Column(name = "REMARKS_SCORE3", precision = 4, scale = 0)
	public Integer getRemarksScore3() {
		return remarksScore3;
	}

	public void setRemarksScore3(Integer remarksScore3) {
		this.remarksScore3 = remarksScore3;
	}
	@Column(name = "REMARKS_SCORE4", precision = 4, scale = 0)
	public Integer getRemarksScore4() {
		return remarksScore4;
	}

	public void setRemarksScore4(Integer remarksScore4) {
		this.remarksScore4 = remarksScore4;
	}
	@Column(name = "REMARKS_SCORE5", precision = 4, scale = 0)
	public Integer getRemarksScore5() {
		return remarksScore5;
	}

	public void setRemarksScore5(Integer remarksScore5) {
		this.remarksScore5 = remarksScore5;
	}
	@Column(name = "REMARKS_SCORE6", precision = 4, scale = 0)
	public Integer getRemarksScore6() {
		return remarksScore6;
	}

	public void setRemarksScore6(Integer remarksScore6) {
		this.remarksScore6 = remarksScore6;
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

	@Column(name = "REMARK", length = 1000)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Transient
	public String getTypeShowName1() {
		return typeShowName1;
	}

	public void setTypeShowName1(String typeShowName1) {
		this.typeShowName1 = typeShowName1;
	}
	
	@Transient
	public String getExpertTypeName() {
		return expertTypeName;
	}

	

	public void setExpertTypeName(String expertTypeName) {
		this.expertTypeName = expertTypeName;
	}
	@Transient
	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	
	
}