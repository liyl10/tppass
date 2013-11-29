/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.scenter.api.auth.action;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.framework.base.bean.Pager;
import com.hopsun.framework.util.StrutsUtil;
import com.hopsun.scenter.api.auth.service.AuthService;
import com.hopsun.scenter.entity.ScAuth;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.subgroups.paramconfig.bean.ParamConfigBean;

/**
 * @comments 权限管理，查看权限树
 * @author yinxy
 * @date Dec 26, 2012
 * @version 1.0
 */
 
public class AuthAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private String authId; // 根据权限id查询子权限
	private String authCode; // 根据权限权限code查询子权限
	private String pid; // 根据上级id获取子权限
	private String select_node_id; // 选择的节点id
	private String select_node_name; // 选择的节点名称
	private String up_imgurl;//上传的路径

	public String nodesvee; // 权限树
	public ParamConfigBean auth_type_config; // 权限类型
	public ParamConfigBean auth_opentype_config; // 权限打开方式类型
	public ParamConfigBean enable_state_config; // 启用禁用类型
	public ParamConfigBean verify_state_config; // 审核状态类型
	public ParamConfigBean delete_state_config; // 删除状态类型
	public ScAuth pScAuth;// 上级权限
	private String msg;
	private File fileMaterial;//Ajax获取图片文件,与控件type=File中的name属性一样   
	private String fileMaterialFileName;//Ajax获取图片文件名称,相应的name属性名称+FileName   
	/**
	 * 返回结果
	 */
	public Map<String, Object> pro_result = new HashMap<String, Object>();
	/**
	 * 添加权限的参数
	 */
	private String new_auth_parent_id;  //上级id
	private String new_auth_name;  //权限名称
	private String new_auth_code;	//权限code
	private String new_auth_type;   //权限类型
	private String new_auth_url;	//权限url
	private String new_auth_icon;	//权限图标
	private String new_auth_desc;	//权限描述
	private String new_auth_order;	//权限排序
	private String new_enable_state; //权限可用状态	
	/**
	 * 修改权限的参数
	 */
	private String edit_auth_id;     //权限id
	private String edit_auth_parent_id;  	//权限上级id
	private String edit_auth_name;		//权限名称
	private String edit_auth_code;		//权限code
	private String edit_auth_type;		//权限类型
	private String edit_auth_url;		//权限url
	private String edit_auth_icon;		//权限图标
	private String edit_auth_desc;		//权限描述
	private String edit_auth_order;		//权限排序
	private String edit_enable_state;	//权限可用状态
	
	private String go_moudle;// 模块跳转地址
	
	private String opentype_state;		//权限打开方式
	/**
	 * 移动权限参数
	 */
	private String target_node_id;			
	/**
	 * 存放权限列表
	 */
	public List<ScAuth> all_auth_list ;		//所有权限
	public List<ScAuth> firlevlist;			//一级权限

	@Resource
	private AuthService authService;

 
	  /**
     * 
      * 方法描述：上传权限图标
      * @param: 
      * @return: 
      * @version: 1.0
      * @author: a
      * @version: Dec 31, 2012 4:54:36 PM
     */
	@SuppressWarnings("deprecation")
	public String uploadImage() throws IOException{
		ScUsers user = (ScUsers) getSession().get("sysUser");
    	HttpServletResponse response=ServletActionContext.getResponse();    
        response.setContentType("application/html");    
        response.setCharacterEncoding("utf-8");    
    	HttpServletRequest request =ServletActionContext.getRequest();
    	if(fileMaterial!=null){  
            String fileName=fileMaterialFileName;  
            String filePath = request.getRealPath("/");
            String tmpPath = filePath+"folder";   
            File tmpDir=new File(tmpPath);
            if (!(tmpDir.isDirectory())){
            	tmpDir.mkdir();
            }
            String tmp=fileMaterial.getPath();
            msg=authService.upload(tmp,tmpDir,fileName,user.getUserName(),user.getUserId()); 
            try {
				response.setContentType("text/html; charset=UTF-8");
				response.setHeader("Pragma", "No-cache");
				response.setHeader("Cache-Control", "no-cache");
				response.setDateHeader("Expires", 0);
				response.getWriter().write("[{msg:'" + msg+ "',flag:'1'}]");
				response.getWriter().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }else{  
        	//上传失败
        	response.getWriter().write("[{flag:'0'}]");
        }  
    	return "ajaxresult";
    }
	/**
	 * 查询权限列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list() {
		if (null == pager) {
			setPager(new Pager());
		}
		all_auth_list= authService.getAuthListAllUsed();
		//显示一级权限
		String nodeleteflag = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("DEL_STATE")).getBeansByCode("enable").getValue();// 未删除
		firlevlist=new ArrayList<ScAuth>();
		String rootAuthid=null;
		if(all_auth_list!=null&&all_auth_list.size()>0){
			for(ScAuth perAuth:all_auth_list){
				if(perAuth.getScAuth()==null&& nodeleteflag.equals(perAuth.getDeleteState())){
					rootAuthid=perAuth.getAuthId();
					rootAuthid=rootAuthid.toLowerCase();
					break;
				}
			}
			if(rootAuthid!=null&&!"".equals(rootAuthid)){
				for(ScAuth perAuth:all_auth_list){
					if(perAuth.getScAuth()!=null&&rootAuthid.equals(perAuth.getScAuth().getAuthId().toLowerCase())){
						firlevlist.add(perAuth);
					}
				}
			}
			
		}
		// 
		pager = authService.findByPager(pager);
		return "list";
	}

	/**
	 * 查询权限树
	 * 
	 * @return
	 */
	public String tree() {
		if (authId != null && !"".equals(authId)) {// 根据authid查询
		} else if (authCode != null && !"".equals(authCode)) {// 根据authcode查询

		}
		return "tree";
	}

	/**
	 * 跳转至添加页
	 * 
	 * @return
	 * @throws Exception
	 */
	public String insert() {
		// 读取可选系统参数
		// 启用类型
		enable_state_config = (ParamConfigBean) getApplication().getAttribute("CONFIG_STATE");
		// 审核状态类型
		verify_state_config = (ParamConfigBean) getApplication().getAttribute("VERIFY_STATE");
		// 权限类型
		auth_type_config = (ParamConfigBean) getApplication().getAttribute("AUTH_TYPE");
		// 权限打开方式类
		auth_opentype_config=(ParamConfigBean) getApplication().getAttribute("OPENTYPE_STATE");
		
		// 删除状态
		delete_state_config = (ParamConfigBean) getApplication().getAttribute("DEL_STATE");

		if (select_node_id != null && !"".equals(select_node_id)) {
			pScAuth = authService.get(select_node_id);
			if (pScAuth != null) {
				pro_result.put("parentId", pScAuth.getAuthId());
				pro_result.put("parentName", pScAuth.getAuthName());
				pro_result.put("pScAuth", pScAuth);
				return "insert";
			} else {
				this.redirectUrl = "/api/auth/auth_list.action";
				addActionMessage("操作失败，权限信息不正确！!");
				return ERROR;
			}
		} else {
			pro_result.put("parentId", "");
			pro_result.put("parentName", "");
			pro_result.put("pScAuth", null);
		}
		return "insert";
	}

	/**
	 * 添加保存
	 * 
	 * @return
	 */
	public String insertsave() {
		ScUsers user = (ScUsers) getSession().get("sysUser");
		String newauthId = null;
		String newrootState = "0";
		String newverifyState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("verifypass").getValue();// 审核通过
		String newdeleteState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("DEL_STATE")).getBeansByCode("enable").getValue();// 未删除
		String opentypeState= ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("OPENTYPE_STATE")).getConfigDefault().getValue();//  默认打开方式
		String newcreateUserName = user.getUserName();
		String newcreateDate = null;
		String newmodifyUserName = null;
		String newmodifyDate = null;
		String newroleType = null;
		if (new_auth_parent_id == null || "".equals(new_auth_parent_id)) {
			newrootState = "1";
		}
		if (new_auth_type == null || "".equals(new_auth_type)) {
			new_auth_type = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("AUTH_TYPE")).getConfigDefault().getValue();// 权限类型默认
		}
		if (new_enable_state == null || "".equals(new_enable_state)) {
			new_enable_state = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getBeansByCode("enable").getValue();// 启用
		}
		if(opentype_state!=null&&!"".equals(opentype_state)){
			opentypeState=opentype_state;
		}
		pro_result = authService.saveAuth(newauthId, new_auth_name, new_auth_parent_id, new_auth_code, new_auth_url, new_auth_type, up_imgurl, new_auth_desc, new_auth_order, newrootState, new_enable_state, newverifyState, newdeleteState, newcreateUserName, newcreateDate, newmodifyUserName, newmodifyDate, newroleType ,opentypeState);

		if (pro_result != null && "1".equals(pro_result.get("msg"))) {
			this.redirectUrl = "/api/auth/auth_list.action";
			addActionMessage("操作完成！");
			return SUCCESS;
		} else if (pro_result != null && pro_result.get("info") != null && !"".equals(pro_result.get("info"))) {
			this.redirectUrl = "/api/auth/auth_list.action";
			addActionMessage(pro_result.get("info").toString());
			return ERROR;
		} else {
			this.redirectUrl = "/api/auth/auth_list.action";
			addActionMessage("操作失败！");
			return ERROR;
		}

	}
	/**
	 * 跳转至查看页
	 * 
	 * @return
	 */
	public String view() {
		// 读取可选系统参数
		// 启用类型
		enable_state_config = (ParamConfigBean) getApplication().getAttribute("CONFIG_STATE");
		// 审核状态类型
		verify_state_config = (ParamConfigBean) getApplication().getAttribute("VERIFY_STATE");
		// 权限类型
		auth_type_config = (ParamConfigBean) getApplication().getAttribute("AUTH_TYPE");
		// 权限打开方式类
		auth_opentype_config=(ParamConfigBean) getApplication().getAttribute("OPENTYPE_STATE");
		// 删除状态
		delete_state_config = (ParamConfigBean) getApplication().getAttribute("DEL_STATE");

		if (select_node_id != null && !"".equals(select_node_id)) {
			pro_result = authService.queryAuthByIdObj(select_node_id);
			if (pro_result != null && "1".equals(pro_result.get("msg"))) {
				return "view";
			} else {
				this.redirectUrl = "/api/auth/auth_list.action";
				addActionMessage("操作失败，权限信息不正确！!");
				return ERROR;
			}
		} else {
			this.redirectUrl = "/api/auth/auth_list.action";
			addActionMessage("操作失败，权限信息不正确！!");
			return ERROR;
		}

	}
	/**
	 * 跳转至相应的模块
	 * 
	 * @return
	 */
	public String tomodule(){
		String gourl="scenter";
		 
		return gourl;
	}

	/**
	 * 跳转至修改页
	 * 
	 * @return
	 */
	public String modify() {
		// 读取可选系统参数
		// 启用类型
		enable_state_config = (ParamConfigBean) getApplication().getAttribute("CONFIG_STATE");
		// 审核状态类型
		verify_state_config = (ParamConfigBean) getApplication().getAttribute("VERIFY_STATE");
		// 权限类型
		auth_type_config = (ParamConfigBean) getApplication().getAttribute("AUTH_TYPE");
		// 权限打开方式类
		auth_opentype_config=(ParamConfigBean) getApplication().getAttribute("OPENTYPE_STATE");
		// 删除状态
		delete_state_config = (ParamConfigBean) getApplication().getAttribute("DEL_STATE");

		if (select_node_id != null && !"".equals(select_node_id)) {
			pro_result = authService.queryAuthByIdObj(select_node_id);
			if (pro_result != null && "1".equals(pro_result.get("msg"))) {
				return "modify";
			} else {
				this.redirectUrl = "/api/auth/auth_list.action";
				addActionMessage("操作失败，权限信息不正确！!");
				return ERROR;
			}
		} else {
			this.redirectUrl = "/api/auth/auth_list.action";
			addActionMessage("操作失败，权限信息不正确！!");
			return ERROR;
		}

	}

	/**
	 * 修改保存
	 * 
	 * @return
	 */
	public String modifysave() {
		ScUsers user = (ScUsers) getSession().get("sysUser");
		String authId = null;
		String rootState = "0";
		String verifyState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("verifypass").getValue();// 审核通过
		String deleteState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("DEL_STATE")).getBeansByCode("enable").getValue();// 未删除
		String opentypeState= ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("OPENTYPE_STATE")).getConfigDefault().getValue();//  默认打开方式
		String createUserName = null;
		String createDate = null;
		String modifyUserName = user.getUserName();
		String modifyDate = null;
		String roleType = null;
		if (new_auth_parent_id == null || "".equals(new_auth_parent_id)) {
			rootState = "1";
		}
		if (edit_auth_id == null || "".equals(edit_auth_id)) {
			this.redirectUrl = "/api/auth/auth_list.action";
			addActionMessage("操作失败，权限信息不正确！!");
			return ERROR;
		} else {
			authId = edit_auth_id;
		}
		if(opentype_state!=null&&!"".equals(opentype_state)){
			opentypeState=opentype_state;
		}
		pro_result = authService.updateAuth(authId, edit_auth_name, edit_auth_parent_id, edit_auth_code, edit_auth_url, edit_auth_type, up_imgurl, edit_auth_desc, edit_auth_order, rootState, edit_enable_state, verifyState, deleteState, createUserName, createDate, modifyUserName, modifyDate, roleType ,opentypeState);
		if (pro_result != null && "1".equals(pro_result.get("msg"))) {
			this.redirectUrl = "/api/auth/auth_list.action";
			addActionMessage("操作完成！");
			return SUCCESS;
		} else if (pro_result != null && pro_result.get("info") != null && !"".equals(pro_result.get("info"))) {
			this.redirectUrl = "/api/auth/auth_list.action";
			addActionMessage(pro_result.get("info").toString());
			return ERROR;
		} else {
			this.redirectUrl = "/api/auth/auth_list.action";
			addActionMessage("操作失败！");
			return ERROR;
		}

	}

	/**
	 * 删除权限
	 * 
	 * @return
	 */
	public String delete() {
		if (select_node_id != null && !"".equals(select_node_id)) {
			pro_result = authService.deleteAuthById(select_node_id);
			if (pro_result != null && "1".equals(pro_result.get("msg"))) {
				this.redirectUrl = "/api/auth/auth_list.action";
				addActionMessage(pro_result.get("info").toString());
				return SUCCESS;
			} else {
				this.redirectUrl = "/api/auth/auth_list.action";
				addActionMessage(pro_result.get("info").toString());
				return ERROR;
			}
		} else {
			this.redirectUrl = "/api/auth/auth_list.action";
			addActionMessage("操作失败！");
			return ERROR;
		}
	}

	/**
	 * 添加权限
	 * 
	 * @return
	 */
	public String ajaxinsert() {
		ScUsers user = (ScUsers) getSession().get("sysUser");
		String newauthId = null;
		String newrootState = "0";
		String newverifyState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("submit").getValue();// 提交审核
		String opentypeState= ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("OPENTYPE_STATE")).getConfigDefault().getValue();//  默认打开方式
		String newdeleteState = "0";
		String newcreateUserName = user.getUserName();
		String newcreateDate = null;
		String newmodifyUserName = null;
		String newmodifyDate = null;
		String newroleType = null;
		if (new_auth_parent_id == null || "".equals(new_auth_parent_id)) {
			newrootState = "1";
		}
		if(opentype_state!=null&&!"".equals(opentype_state)){
			opentypeState=opentype_state;
		}
		Map<String, Object> result = authService.saveAuth(newauthId, new_auth_name, new_auth_parent_id, new_auth_code, new_auth_url, new_auth_type, new_auth_icon, new_auth_desc, new_auth_order, newrootState, new_enable_state, newverifyState, newdeleteState, newcreateUserName, newcreateDate, newmodifyUserName, newmodifyDate, newroleType,opentypeState);
		if (result != null && result.size() > 0 && ("1").equals(result.get("msg"))) {

			HttpServletResponse response = null;
			response = ServletActionContext.getResponse();
			try {
				response.setContentType("text/html; charset=UTF-8");
				response.setHeader("Pragma", "No-cache");
				response.setHeader("Cache-Control", "no-cache");
				response.setDateHeader("Expires", 0);
				if (result.get("authinfo") != null) {
					response.getWriter().write(result.get("authinfo").toString());
				}
				response.getWriter().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "ajaxresult";
	}

	/**
	 * 修改保存权限信息
	 * 
	 * @return
	 */
	public String ajaxsave() {
		ScUsers user = (ScUsers) getSession().get("sysUser");
		String authId = null;
		String rootState = "0";
		String verifyState = "1";
		String deleteState = "0";
		String opentypeState= ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("OPENTYPE_STATE")).getConfigDefault().getValue();//  默认打开方式
		String createUserName = null;
		String createDate = null;
		String modifyUserName = user.getUserName();
		String modifyDate = null;
		String roleType = null;
		if (new_auth_parent_id == null || "".equals(new_auth_parent_id)) {
			rootState = "1";
		}
		if (edit_auth_id == null || "".equals(edit_auth_id)) {
			return "ajaxresult";
		} else {
			authId = edit_auth_id;
		}
		if(opentype_state!=null&&!"".equals(opentype_state)){
			opentypeState=opentype_state;
		}
		Map<String, Object> result = authService.updateAuth(authId, edit_auth_name, edit_auth_parent_id, edit_auth_code, edit_auth_url, edit_auth_type, edit_auth_icon, edit_auth_desc, edit_auth_order, rootState, edit_enable_state, verifyState, deleteState, createUserName, createDate, modifyUserName, modifyDate, roleType,opentypeState);
		if (result != null && result.size() > 0 && ("1").equals(result.get("msg"))) {

			HttpServletResponse response = null;
			response = ServletActionContext.getResponse();
			try {
				response.setContentType("text/html; charset=UTF-8");
				response.setHeader("Pragma", "No-cache");
				response.setHeader("Cache-Control", "no-cache");
				response.setDateHeader("Expires", 0);
				if (result.get("authinfo") != null) {
					response.getWriter().write(result.get("authinfo").toString());
				}
				response.getWriter().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "ajaxresult";
	}

	/**
	 * 根据id查询权限信息
	 * 
	 * @return
	 */
	public String ajaxQueryById() {
		if (select_node_id != null && !"".equals(select_node_id)) {
			Map<String, Object> result = authService.queryAuthById(select_node_id);
			if (result != null && result.size() > 0 && ("1").equals(result.get("msg"))) {
				HttpServletResponse response = null;
				response = ServletActionContext.getResponse();
				try {
					response.setContentType("text/html; charset=UTF-8");
					response.setHeader("Pragma", "No-cache");
					response.setHeader("Cache-Control", "no-cache");
					response.setDateHeader("Expires", 0);
					if (result.get("authinfo") != null) {
						response.getWriter().write(result.get("authinfo").toString());
					}
					response.getWriter().flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "ajaxresult";
	}

	/**
	 * ajax删除权限
	 * 
	 * @return
	 */
	public String ajaxdelete() {
		if (select_node_id != null && !"".equals(select_node_id)) {
			Map<String, Object> result = authService.deleteAuthById(select_node_id);

			if (result != null && result.size() > 0) {
				HttpServletResponse response = null;
				response = ServletActionContext.getResponse();
				try {
					response.setContentType("text/html; charset=UTF-8");
					response.setHeader("Pragma", "No-cache");
					response.setHeader("Cache-Control", "no-cache");
					response.setDateHeader("Expires", 0);
					if (result.get("info") != null) {
						response.getWriter().write(result.get("info").toString());
					}
					response.getWriter().flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return "ajaxresult";

	}

	/**
	 * 移动权限
	 * 
	 * @return
	 */
	public String ajaxmove() {
		if (select_node_id != null && !"".equals(select_node_id) && target_node_id != null && !"".equals(target_node_id)) {
			Map<String, Object> result = authService.updateMoveAuthById(select_node_id, target_node_id);

			if (result != null && result.size() > 0) {
				HttpServletResponse response = null;
				response = ServletActionContext.getResponse();
				try {
					response.setContentType("text/html; charset=UTF-8");
					response.setHeader("Pragma", "No-cache");
					response.setHeader("Cache-Control", "no-cache");
					response.setDateHeader("Expires", 0);
					if (result.get("info") != null) {
						response.getWriter().write(result.get("info").toString());
					}
					response.getWriter().flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return "ajaxresult";

	}

	/**
	 * 添加权限
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() {
		return "add";
	}

	/**
	 * 输出权限树
	 * 
	 * @return
	 */
	public String outputtree() {
		nodesvee = authService.authDataTree(pid);
		HttpServletResponse response = null;
		response = ServletActionContext.getResponse();
		try {
			response.setContentType("text/html; charset=UTF-8");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			if(nodesvee==null){
				nodesvee="[]";
			}
			response.getWriter().write(nodesvee);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "ajaxresult";
	}

	public String getAuthId() {
		return authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getedit_auth_parent_id() {
		return new_auth_parent_id;
	}

	public void setNew_auth_parent_id(String new_auth_parent_id) {
		this.new_auth_parent_id = new_auth_parent_id;
	}

	public String getNew_auth_name() {
		return new_auth_name;
	}

	public void setNew_auth_name(String new_auth_name) {
		this.new_auth_name = new_auth_name;
	}

	public String getNew_auth_code() {
		return new_auth_code;
	}

	public void setNew_auth_code(String new_auth_code) {
		this.new_auth_code = new_auth_code;
	}

	public String getNew_auth_type() {
		return new_auth_type;
	}

	public void setNew_auth_type(String new_auth_type) {
		this.new_auth_type = new_auth_type;
	}

	public String getNew_auth_icon() {
		return new_auth_icon;
	}

	public void setNew_auth_icon(String new_auth_icon) {
		this.new_auth_icon = new_auth_icon;
	}

	public String getNew_auth_desc() {
		return new_auth_desc;
	}

	public void setNew_auth_desc(String new_auth_desc) {
		this.new_auth_desc = new_auth_desc;
	}

	public String getNew_auth_order() {
		return new_auth_order;
	}

	public void setNew_auth_order(String new_auth_order) {
		this.new_auth_order = new_auth_order;
	}

	public String getNew_enable_state() {
		return new_enable_state;
	}

	public void setNew_enable_state(String new_enable_state) {
		this.new_enable_state = new_enable_state;
	}

	public String getSelect_node_id() {
		return select_node_id;
	}

	public void setSelect_node_id(String select_node_id) {
		this.select_node_id = select_node_id;
	}

	public String getEdit_auth_parent_id() {
		return edit_auth_parent_id;
	}

	public void setEdit_auth_parent_id(String edit_auth_parent_id) {
		this.edit_auth_parent_id = edit_auth_parent_id;
	}

	public String getEdit_auth_name() {
		return edit_auth_name;
	}

	public void setEdit_auth_name(String edit_auth_name) {
		this.edit_auth_name = edit_auth_name;
	}

	public String getEdit_auth_code() {
		return edit_auth_code;
	}

	public void setEdit_auth_code(String edit_auth_code) {
		this.edit_auth_code = edit_auth_code;
	}

	public String getEdit_auth_type() {
		return edit_auth_type;
	}

	public void setEdit_auth_type(String edit_auth_type) {
		this.edit_auth_type = edit_auth_type;
	}

	public String getEdit_auth_icon() {
		return edit_auth_icon;
	}

	public void setEdit_auth_icon(String edit_auth_icon) {
		this.edit_auth_icon = edit_auth_icon;
	}

	public String getEdit_auth_desc() {
		return edit_auth_desc;
	}

	public void setEdit_auth_desc(String edit_auth_desc) {
		this.edit_auth_desc = edit_auth_desc;
	}

	public String getEdit_auth_order() {
		return edit_auth_order;
	}

	public void setEdit_auth_order(String edit_auth_order) {
		this.edit_auth_order = edit_auth_order;
	}

	public String getEdit_enable_state() {
		return edit_enable_state;
	}

	public void setEdit_enable_state(String edit_enable_state) {
		this.edit_enable_state = edit_enable_state;
	}

	public String getEdit_auth_id() {
		return edit_auth_id;
	}

	public void setEdit_auth_id(String edit_auth_id) {
		this.edit_auth_id = edit_auth_id;
	}

	public String getNew_auth_parent_id() {
		return new_auth_parent_id;
	}

	public String getTarget_node_id() {
		return target_node_id;
	}

	public void setTarget_node_id(String target_node_id) {
		this.target_node_id = target_node_id;
	}

	public String getNew_auth_url() {
		return new_auth_url;
	}

	public void setNew_auth_url(String new_auth_url) {
		this.new_auth_url = new_auth_url;
	}

	public String getEdit_auth_url() {
		return edit_auth_url;
	}

	public void setEdit_auth_url(String edit_auth_url) {
		this.edit_auth_url = edit_auth_url;
	}

	public String getSelect_node_name() {
		return select_node_name;
	}

	public void setSelect_node_name(String select_node_name) {
		this.select_node_name = select_node_name;
	}
	public File getFileMaterial() {
		return fileMaterial;
	}
	public void setFileMaterial(File fileMaterial) {
		this.fileMaterial = fileMaterial;
	}
	public String getFileMaterialFileName() {
		return fileMaterialFileName;
	}
	public void setFileMaterialFileName(String fileMaterialFileName) {
		this.fileMaterialFileName = fileMaterialFileName;
	}
	public String getUp_imgurl() {
		return up_imgurl;
	}
	public void setUp_imgurl(String up_imgurl) {
		this.up_imgurl = up_imgurl;
	}
	public String getOpentype_state() {
		return opentype_state;
	}
	public void setOpentype_state(String opentype_state) {
		this.opentype_state = opentype_state;
	}
	public String getGo_moudle() {
		return go_moudle;
	}
	public void setGo_moudle(String go_moudle) {
		this.go_moudle = go_moudle;
	}
}
