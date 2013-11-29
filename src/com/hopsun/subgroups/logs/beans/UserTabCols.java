/**
 * @filename LogAction.java
 * @author zzze
 * @date Jan 5, 2013
 * @vsersion 1.0
 * Copyright (C) 2013 辉盛科技发展责任有限公司
 */
package com.hopsun.subgroups.logs.beans; 

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 *@comment 库中表属性及备注�? 
 *@author zzze
 *@date Jan 15, 2013
 *@version 1.0
 */
public class UserTabCols implements java.io.Serializable { 

	// Fields
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String columnName;
	private String comments;
	private String tableName;
	private String dataType;
	private String dataTypeMod;
	private String dataTypeOwner;
	private Long dataLength;
	private Long dataPrecision;
	private Long dataScale;
	private String nullable;
	private Long columnId;
	private Long defaultLength;
	private String dataDefault;
	private Long numDistinct;
	private String lowValue;
	private String highValue;
	private Long density;
	private Long numNulls;
	private Long numBuckets;
	private Date lastAnalyzed;
	private Long sampleSize;
	private String characterSetName;
	private Long charColDeclLength;
	private String globalStats;
	private String userStats;
	private Long charLength;
	private String charUsed;
	private String v80FmtImage;
	private String dataUpgraded;
	private String histogram;
	public String getTableName() {
		return tableName;
	}
	public void setTableName(final String tableName) {
		this.tableName = tableName;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(final String columnName) {
		this.columnName = columnName;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(final String dataType) {
		this.dataType = dataType;
	}
	public String getDataTypeMod() {
		return dataTypeMod;
	}
	public void setDataTypeMod(final String dataTypeMod) {
		this.dataTypeMod = dataTypeMod;
	}
	public String getDataTypeOwner() {
		return dataTypeOwner;
	}
	public void setDataTypeOwner(final String dataTypeOwner) {
		this.dataTypeOwner = dataTypeOwner;
	}
	public Long getDataLength() {
		return dataLength;
	}
	public void setDataLength(final Long dataLength) {
		this.dataLength = dataLength;
	}
	public Long getDataPrecision() {
		return dataPrecision;
	}
	public void setDataPrecision(final Long dataPrecision) {
		this.dataPrecision = dataPrecision;
	}
	public Long getDataScale() {
		return dataScale;
	}
	public void setDataScale(final Long dataScale) {
		this.dataScale = dataScale;
	}
	public String getNullable() {
		return nullable;
	}
	public void setNullable(final String nullable) {
		this.nullable = nullable;
	}
	public Long getColumnId() {
		return columnId;
	}
	public void setColumnId(final Long columnId) {
		this.columnId = columnId;
	}
	public Long getDefaultLength() {
		return defaultLength;
	}
	public void setDefaultLength(final Long defaultLength) {
		this.defaultLength = defaultLength;
	}
	public String getDataDefault() {
		return dataDefault;
	}
	public void setDataDefault(final String dataDefault) {
		this.dataDefault = dataDefault;
	}
	public Long getNumDistinct() {
		return numDistinct;
	}
	public void setNumDistinct(final Long numDistinct) {
		this.numDistinct = numDistinct;
	}
	public String getLowValue() {
		return lowValue;
	}
	public void setLowValue(final String lowValue) {
		this.lowValue = lowValue;
	}
	public String getHighValue() {
		return highValue;
	}
	public void setHighValue(final String highValue) {
		this.highValue = highValue;
	}
	public Long getDensity() {
		return density;
	}
	public void setDensity(final Long density) {
		this.density = density;
	}
	public Long getNumNulls() {
		return numNulls;
	}
	public void setNumNulls(final Long numNulls) {
		this.numNulls = numNulls;
	}
	public Long getNumBuckets() {
		return numBuckets;
	}
	public void setNumBuckets(final Long numBuckets) {
		this.numBuckets = numBuckets;
	}
	public Date getLastAnalyzed() {
		return lastAnalyzed;
	}
	public void setLastAnalyzed(final Date lastAnalyzed) {
		this.lastAnalyzed = lastAnalyzed;
	}
	public Long getSampleSize() {
		return sampleSize;
	}
	public void setSampleSize(final Long sampleSize) {
		this.sampleSize = sampleSize;
	}
	public String getCharacterSetName() {
		return characterSetName;
	}
	public void setCharacterSetName(final String characterSetName) {
		this.characterSetName = characterSetName;
	}
	public Long getCharColDeclLength() {
		return charColDeclLength;
	}
	public void setCharColDeclLength(final Long charColDeclLength) {
		this.charColDeclLength = charColDeclLength;
	}
	public String getGlobalStats() {
		return globalStats;
	}
	public void setGlobalStats(final String globalStats) {
		this.globalStats = globalStats;
	}
	public String getUserStats() {
		return userStats;
	}
	public void setUserStats(final String userStats) {
		this.userStats = userStats;
	}
	public Long getCharLength() {
		return charLength;
	}
	public void setCharLength(final Long charLength) {
		this.charLength = charLength;
	}
	public String getCharUsed() {
		return charUsed;
	}
	public void setCharUsed(final String charUsed) {
		this.charUsed = charUsed;
	}
	public String getV80FmtImage() {
		return v80FmtImage;
	}
	public void setV80FmtImage(final String fmtImage) {
		v80FmtImage = fmtImage;
	}
	public String getDataUpgraded() {
		return dataUpgraded;
	}
	public void setDataUpgraded(final String dataUpgraded) {
		this.dataUpgraded = dataUpgraded;
	}
	public String getHistogram() {
		return histogram;
	}
	public void setHistogram(final String histogram) {
		this.histogram = histogram;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(final String comments) {
		this.comments = comments;
	}
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("lastAnalyzed",
				this.lastAnalyzed).append("userStats", this.userStats).append(
				"histogram", this.histogram).append("columnId", this.columnId)
				.append("highValue", this.highValue).append("numNulls",
						this.numNulls).append("characterSetName",
						this.characterSetName).append("dataTypeOwner",
						this.dataTypeOwner).append("charUsed", this.charUsed)
				.append("numBuckets", this.numBuckets).append("sampleSize",
						this.sampleSize).append("dataPrecision",
						this.dataPrecision).append("lowValue", this.lowValue)
				.append("V80FmtImage", this.getV80FmtImage()).append(
						"dataDefault", this.dataDefault).append("numDistinct",
						this.numDistinct).append("globalStats",
						this.globalStats).append("charColDeclLength",
						this.charColDeclLength).append("dataUpgraded",
						this.dataUpgraded)
				.append("dataLength", this.dataLength).append("nullable",
						this.nullable).append("dataTypeMod", this.dataTypeMod)
				.append("dataScale", this.dataScale).append("tableName",
						this.tableName).append("comments", this.comments)
				.append("charLength", this.charLength).append("columnName",
						this.columnName).append("density", this.density)
				.append("defaultLength", this.defaultLength).append("dataType",
						this.dataType).toString();
	}

	// Constructors
	
	
}
