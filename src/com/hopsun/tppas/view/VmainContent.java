/**
 *@filename VmainContent.java
 *@author wanglw
 *@date 2013-11-15
 *@version 1.0
 *Copyright (C) 2013 辉盛科技发展责任有限公司
 */
/**
 * 
 */
package com.hopsun.tppas.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @comments 项目主要内容
 * @author wanglw
 * @date 2013-11-15 @time 下午4:43:06
 * @Version 1.0
 */
@Entity
@Table(name = "V_MAIN_CONTENT")
public class VmainContent implements java.io.Serializable{
	
	private static final long serialVersionUID = -7085501337732032032L;
	private String projectId;
	private String mainContent;
	
	public VmainContent() {
	}

	public VmainContent(String projectId, String mainContent) {
		super();
		this.projectId = projectId;
		this.mainContent = mainContent;
	}

	@Id
	@Column(name = "PROJECT_ID", unique = true, nullable = false, length = 40)
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	@Column(name = "MAIN_CONTENT", length = 60)
	public String getMainContent() {
		return mainContent;
	}

	public void setMainContent(String mainContent) {
		this.mainContent = mainContent;
	}
	
	
}

