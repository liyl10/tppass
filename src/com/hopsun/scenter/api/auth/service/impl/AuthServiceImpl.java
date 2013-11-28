/************************* 版权声明 *********************************
 *
 * Copyright (C) 2012 西安辉盛科技发展有限责任公司.
 *
 ******************************************************************
 */
package com.hopsun.scenter.api.auth.service.impl;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.framework.util.StrutsUtil;
import com.hopsun.scenter.api.auth.dao.AuthDao;
import com.hopsun.scenter.api.auth.service.AuthService;
import com.hopsun.scenter.entity.ScAuth;
import com.hopsun.scenter.entity.ScUsers;
import com.hopsun.subgroups.paramconfig.bean.ParamConfigBean;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
 
/**
 * @comments  权限服务接口实现
 * @author yinxy
 * @date Dec 26, 2012
 * @version 1.0
 */
@Service
public class AuthServiceImpl extends BaseServiceImpl<ScAuth, String> implements AuthService {

	@Resource
	private AuthDao authServiceDao;

	@Resource
	public void setBaseDao(AuthDao authServiceDao) {
		super.setBaseDao(authServiceDao);
	}
	 
	/**
	 * 根据上级id查询子权限
	 * @param pid
	 * @return String
	 */
	public String authDataTree(String pid) {
		if (pid == null || ("").equals(pid)) {
			pid = "";
		}
		String nodesvee = null;
		List<ScAuth> authDataList = authServiceDao.queryAuthListByParent(pid);
		String isParent = "false";// 是否存在字节点标志。
		if (authDataList != null && authDataList.size() > 0) {
			// 遍历查询出来的子节点
			StringBuffer strres = new StringBuffer(""); // 存放所有节点数据
			strres.append("[");
			for (ScAuth authDataA : authDataList) {
				// 再次查询该节点下是否有子节点。
				String authid = authDataA.getAuthId();
				List<ScAuth> authDataList2 = authServiceDao.queryAuthListByParent(authid);// 查询
				if (authDataList2 != null && authDataList2.size() > 0) {// 若列表不为空，则isParent的值为“true”
					isParent = "true";
				} else {
					isParent = "false";
				}
				strres.append("{id:'" + authDataA.getAuthId() + "',name:'" + authDataA.getAuthName().toString().replaceAll("\'", "\\\\'") + "',isParent:" + isParent + "},");
			}
			strres.deleteCharAt(strres.length() - 1); // 删除最后一个多余的逗号。
			strres.append("]");
			// nodesvee=JSONArray.fromObject(strres.toString())//
			// 将字符串转为json格式输出。
			nodesvee = strres.toString();
		} else {
			nodesvee = "[{id:'"+pid+"',name:'暂无权限',isParent:false}]";
		}
		return nodesvee;
	}
	/**
	 * 查询所有权限列表。（注：未删除的）
	 * @param pid
	 * @param authList
	 * @return List
	 */
	public List<ScAuth> getAllAuthByParent(String pid, ArrayList<ScAuth> authList) {
		List<ScAuth> allAuthList = authServiceDao.queryAllAuth();
		return allAuthList;
	}

	/**
	 * 添加权限
	 * 
	 * @param authId
	 * @param authName
	 * @param authParentId
	 * @param authCode
	 * @param authUrl
	 * @param authType
	 * @param authIcon
	 * @param authDesc
	 * @param authOrder
	 * @param rootState
	 * @param enableState
	 * @param verifyState
	 * @param deleteState
	 * @param createUserName
	 * @param createDate
	 * @param modifyUserName
	 * @param modifyDate
	 * @param roleType
	 * @return
	 */
 
	public Map<String, Object> saveAuth(String authId, String authName, String authParentId, String authCode, String authUrl, String authType, String authIcon, String authDesc, String authOrder, String rootState, String enableState, String verifyState, String deleteState, String createUserName, String createDate, String modifyUserName, String modifyDate, String roleType,String opentypeState) {
		Map<String, Object> result = new HashMap<String, Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long newAuthOrder = new Long(1);
		Date newCreateDate = new Date();

		String newDeleteState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("DEL_STATE")).getBeansByCode("enable").getValue(); // 未删除
		String newEnableState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getBeansByCode("enable").getValue();// 启用
		String newVerifyState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("verifypass").getValue();// 审核通过
		result.put("msg", "0");
		if (deleteState != null && !"".equals(deleteState)) {
			newDeleteState = deleteState;
		}
		if (enableState != null && !"".equals(enableState)) {
			newEnableState = enableState;
		}
		if (verifyState != null && !"".equals(verifyState)) {
			newVerifyState = verifyState;
		}

		// 排序字符转为Long
		if (authOrder != null && !("").equals(authOrder)) {
			newAuthOrder = Long.parseLong(authOrder);
		}
		// 创建日期转为Date型
		if (createDate != null && !("").equals(createDate)) {
			try {
				newCreateDate = sdf.parse(createDate);
			} catch (ParseException e) {
				return result;
			}
		}
		ScAuth pScAuth = null; // 上级权限
		if (authParentId != null && !"".equals(authParentId)) {
			// 若为添加子节点，则获取上级权限
			pScAuth = authServiceDao.get(authParentId);
			if (pScAuth == null) {
				// 若不存在上级权限，则操作失败
				result.put("msg", "0");
				return result;
			}
		} else {// 若是添加根节点，则判断是否已有根节点。
			List<ScAuth> rootAuth_list = (List<ScAuth>) authServiceDao.queryAuthRoot();
			if (rootAuth_list != null && rootAuth_list.size() > 0) {
				// 已经存在根节点，操作失败
				result.put("info", "根节点已经存在，操作失败！");
				result.put("msg", "0");
				return result;
			}
		}
		//判断code是否重复
		Map<String,Object> condition=new HashMap<String,Object>();
		condition.put("enableState", ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getValueByCode("enable"));
		condition.put("authCode", authCode);
		List<ScAuth> list_query_auth=authServiceDao.queryAuthList(condition);
		if(list_query_auth!=null&&list_query_auth.size()>0){
			result.put("info", "权限code重复，操作失败！");
			result.put("msg", "0");
			return result;
		}
		// 给实体属性赋值
		ScAuth newScAuth = new ScAuth();
		newScAuth.setScAuth(pScAuth);
		newScAuth.setAuthCode(authCode);
		newScAuth.setAuthDesc(authDesc);
		newScAuth.setAuthIcon(authIcon);
		newScAuth.setAuthName(authName);
		newScAuth.setAuthOrder(newAuthOrder);
		newScAuth.setAuthType(authType);
		newScAuth.setAuthUrl(authUrl);
		newScAuth.setCreateDate(newCreateDate);
		newScAuth.setCreateUserName(createUserName);
		newScAuth.setDeleteState(newDeleteState);
		newScAuth.setVerifyState(newVerifyState);
		newScAuth.setEnableState(newEnableState);
		newScAuth.setRoleType(roleType);
		newScAuth.setOpentypeState(opentypeState);
		// 保存实体
		authServiceDao.save(newScAuth);
		String newScAuthStr = "";
		newScAuthStr = "[{authId:'" + newScAuth.getAuthId() + "',authName:'" + newScAuth.getAuthName() + "'}]";
		result.put("msg", "1");
		result.put("authinfo", newScAuthStr);
		return result;
	}

 
	/**
	 * 根据权限id查询权限信息,返回带有json。
	 * 
	 * @param id
	 * @return
	 */
	public Map<String, Object> queryAuthById(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "0");
		if (id == null || "".equals(id)) {
			return result;
		}
		// 获取实体
		ScAuth scAuth = authServiceDao.get(id);
		if (scAuth != null) {
			String authParentId = null;
			String authParentName = null;
			if (scAuth.getScAuth() != null) {
				authParentId = scAuth.getScAuth().getAuthId();
				authParentName = scAuth.getScAuth().getAuthName();
			}
			Map<String, Object> scAuthMap = new HashMap<String, Object>();
			scAuthMap.put("authId", scAuth.getAuthId());
			scAuthMap.put("authName", scAuth.getAuthName());
			scAuthMap.put("authCode", scAuth.getAuthCode());
			scAuthMap.put("authUrl", scAuth.getAuthUrl());
			scAuthMap.put("authType", scAuth.getAuthType());
			scAuthMap.put("authIcon", scAuth.getAuthIcon());
			scAuthMap.put("authDesc", scAuth.getAuthDesc());
			scAuthMap.put("authOrder", scAuth.getAuthOrder());
			scAuthMap.put("rootState", scAuth.getRootState());
			scAuthMap.put("enableState", scAuth.getEnableState());
			scAuthMap.put("verifyState", scAuth.getVerifyState());
			scAuthMap.put("deleteState", scAuth.getDeleteState());
			scAuthMap.put("roleType", scAuth.getRoleType());
			scAuthMap.put("authParentId", authParentId);
			scAuthMap.put("authParentName", authParentName);

			JSONArray thisScAuthJs = JSONArray.fromObject(scAuthMap);
			result.put("authinfo", thisScAuthJs);
			result.put("msg", "1");
		}
		return result;
	}
 
	/**
	 * 根据权限id查询权限信息。
	 * 
	 * @param id
	 * @return
	 */
	public Map<String, Object> queryAuthByIdObj(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "0");
		if (id == null || "".equals(id)) {
			return result;
		}
		// 获取实体
		ScAuth scAuth = authServiceDao.get(id);
		if (scAuth != null) {
			result.put("objinfo", scAuth);
			result.put("msg", "1");
		}
		return result;
	}

	/**
	 * 更新权限信息
	 * 
	 * @param authId
	 * @param authName
	 * @param authParentId
	 * @param authCode
	 * @param authUrl
	 * @param authType
	 * @param authIcon
	 * @param authDesc
	 * @param authOrder
	 * @param rootState
	 * @param enableState
	 * @param verifyState
	 * @param deleteState
	 * @param createUserName
	 * @param createDate
	 * @param modifyUserName
	 * @param modifyDate
	 * @param roleType
	 * @return
	 */
	public Map<String, Object> updateAuth(String authId, String authName, String authParentId, String authCode, String authUrl, String authType, String authIcon, String authDesc, String authOrder, String rootState, String enableState, String verifyState, String deleteState, String createUserName, String createDate, String modifyUserName, String modifyDate, String roleType,String opentypeState) {
		Map<String, Object> result = new HashMap<String, Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long newAuthOrder = new Long(1);
		Date newModifyDate = new Date();
		String newDeleteState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("DEL_STATE")).getBeansByCode("enable").getValue(); // 未删除
		String newEnableState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getBeansByCode("enable").getValue();// 启用
		String newVerifyState = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("VERIFY_STATE")).getBeansByCode("verifypass").getValue();// 审核通过
		result.put("msg", "0");
		if (deleteState != null && !"".equals(deleteState)) {
			newDeleteState = deleteState;
		}
		if (enableState != null && !"".equals(enableState)) {
			newEnableState = enableState;
		}
		if (verifyState != null && !"".equals(verifyState)) {
			newVerifyState = verifyState;
		}

		// 排序字符转为Long
		if (authOrder != null && !("").equals(authOrder)) {
			newAuthOrder = Long.parseLong(authOrder);
		}
		// 创建日期转为Date型
		if (modifyDate != null && !("").equals(modifyDate)) {
			try {
				newModifyDate = sdf.parse(modifyDate);
			} catch (ParseException e) {
				return result;
			}
		}
		// 给实体属性赋值
		ScAuth newScAuth = authServiceDao.get(authId);
		if (newScAuth == null) {
			return result;
		}
		//判断code是否重复
		Map<String,Object> condition=new HashMap<String,Object>();
		condition.put("enableState", ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getValueByCode("enable"));
		condition.put("authCode", authCode);
		List<ScAuth> list_query_auth=authServiceDao.queryAuthList(condition);
		if(list_query_auth!=null&&list_query_auth.size()>1){
			result.put("info", "权限code重复，操作失败！");
			result.put("msg", "0");
			return result;
		}else if(list_query_auth!=null&&list_query_auth.size()==1){
			ScAuth scAuth_select=(ScAuth)list_query_auth.get(0);
			if(!authId.equals(scAuth_select.getAuthId())){
				result.put("info", "权限code重复，操作失败！");
				result.put("msg", "0");
				return result;
			}
		}
		// 获取上级实体
		ScAuth pScAuth = authServiceDao.get(authParentId);
     	//
		newScAuth.setAuthId(authId);
		newScAuth.setScAuth(pScAuth);
		newScAuth.setAuthCode(authCode);
		newScAuth.setAuthDesc(authDesc);
		newScAuth.setAuthIcon(authIcon);
		newScAuth.setAuthName(authName);
		newScAuth.setAuthOrder(newAuthOrder);
		newScAuth.setAuthType(authType);
		newScAuth.setAuthUrl(authUrl);
		newScAuth.setModifyDate(newModifyDate);
		newScAuth.setModifyUserName(modifyUserName);
		newScAuth.setDeleteState(newDeleteState);
		newScAuth.setVerifyState(newVerifyState);
		newScAuth.setEnableState(newEnableState);
		newScAuth.setRoleType(roleType);
		newScAuth.setOpentypeState(opentypeState);
		
		// 保存实体
		// authServiceDao.save(newScAuth);
		authServiceDao.update(newScAuth);
//		String newScAuthStr = "";
//		newScAuthStr = "[{authId:'" + newScAuth.getAuthId() + "',authName:'" + newScAuth.getAuthName() + "'}]";
//      result.put("authinfo", newScAuthStr);
		result.put("msg", "1");
		return result;
	}

	/**
	 * 删除权限
	 * 
	 * @param id
	 * @return
	 */
	public Map<String, Object> deleteAuthById(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		String deleteType = ((ParamConfigBean) StrutsUtil.getApplication().getAttribute("AUTH_DELETE_TYPE")).getConfigDefault().getValue();// 权限默认删除方式
		result.put("msg", "0");
		result.put("info", "");
		if (id == null || "".equals(id)) {
			return result;
		}
		// 获取实体
		ScAuth scAuth = authServiceDao.get(id);

		if (scAuth != null) {
			// 不能删除根节点
			if (scAuth.getScAuth() == null) {
				// 若不存在上级权限，则为根权限，不能删除。
				//result.put("info", "[{'info':'false_2'}]");
				result.put("info", "删除失败，不能删除权限树根节点！");
				return result;
			}
			List<ScAuth> authDataList = authServiceDao.queryAuthListByParent(scAuth.getAuthId());

			if (authDataList != null && authDataList.size() > 0) {
				// 若存在子权限
				if ("1".equals(deleteType)) {
					// 如果是删除方式为1，则不能删除
					//result.put("info", "[{'info':'false_1'}]");
					result.put("info", "删除失败，请先删除其下级权限！");
					return result;
				} else {// 遍历删除子权限
					for (ScAuth perScAuth : authDataList) {
						deleteAuthByIdLoop(perScAuth.getAuthId());
					}
				}
			}
			scAuth.setDeleteState(((ParamConfigBean) StrutsUtil.getApplication().getAttribute("DEL_STATE")).getBeansByCode("disable").getValue());
			authServiceDao.update(scAuth);
			//result.put("info", "[{'info':'true'}]");
			result.put("info", "操作完成！");
			result.put("msg", "1");
		}
		return result;
	}

	/**
	 * 遍历删除权限及子权限
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteAuthByIdLoop(String id) {
		boolean result = false;
		if (id == null || "".equals(id)) {
			return result;
		}
		// 获取实体
		ScAuth scAuth = authServiceDao.get(id);
		if (scAuth != null) {
			List<ScAuth> authDataList = authServiceDao.queryAuthListByParent(scAuth.getAuthId());

			if (authDataList != null && authDataList.size() > 0) {
				// 若存在子权限
				for (ScAuth perScAuth : authDataList) {
					deleteAuthByIdLoop(perScAuth.getAuthId());
				}
			}
			scAuth.setDeleteState(((ParamConfigBean) StrutsUtil.getApplication().getAttribute("DEL_STATE")).getBeansByCode("disable").getValue());
			authServiceDao.update(scAuth);
		}
		return result;
	}

	/**
	 * 移动权限
	 * 
	 * @param selectedId
	 * @param tagertId
	 * @return
	 */
	public Map<String, Object> updateMoveAuthById(String selectedId, String tagertId) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "0");
		result.put("info", "[{'info':'false'}]");
		if (selectedId == null || "".equals(selectedId)) {
			result.put("info", "[{'info':'false_1'}]");
			return result;
		}
		if (tagertId == null || "".equals(tagertId)) {
			result.put("info", "[{'info':'false_2'}]");
			return result;
		}
		// 获取实体
		ScAuth scAuthSelect = authServiceDao.get(selectedId);
		ScAuth scAuthTarget = authServiceDao.get(tagertId);
		if (scAuthSelect != null && scAuthTarget != null) {
			//判断权限类型级别
			//页面不能大类型权限不能移动至小级别类型权限下
			if(Integer.parseInt(scAuthSelect.getAuthType().toString())<Integer.parseInt(scAuthTarget.getAuthType().toString())){
				result.put("info", "[{'info':'false_3'}]");
				return result;
			}else{
			scAuthSelect.setScAuth(scAuthTarget);
			authServiceDao.update(scAuthSelect);
			result.put("info", "[{'info':'true'}]");
			result.put("msg", "1");
			}
		}
		return result;

	}

	/**
	 * 根据id查询权限及子权限
	 * 
	 * @param id
	 * @return
	 */
	public Map<String, Object> queryAuthCollectById(String id) {
		Map<String, Object> result = new HashMap<String, Object>();

		return result;
	}

	// 杜雷修改 start
	/**
	 * 根据用户查询权限跟节点信息
	 * 
	 * @return
	 */
	public List<ScAuth> getAuthByUser(ScUsers user) {
		return authServiceDao.getAuthByUser(user);
	}

	/**
	 * 根据用户，权限信息查询权限子节点信息
	 * 
	 * @return
	 */
	public List<ScAuth> getAuths(ScUsers user, String authid) {
		return authServiceDao.getAuths(user, authid);
	}
	/**
	 * 根据用户查询用户所有权限信息
	 * @return
	 */
	public JSONArray getAuthsByUser(ScUsers user) {
		return authServiceDao.getAuthsByUser(user);
	}

	// 杜雷修改 end
	
	/**
	  * 方法描述：上传图片
	  * @param: 
	  * @return: 
	  * @version: Dec 31, 2012 4:56:49 PM
	 */
	public String upload(String file,File fi,String fileName,String userName,String userId)  {
		String msg = "";
		File targetFile = new File(file); // 指定上传文件
		try {
			Image src = javax.imageio.ImageIO.read(targetFile);
			int wideth=src.getWidth(null); //得到源图宽
		    int height=src.getHeight(null); //得到源图长
		    BufferedImage tag = new BufferedImage(wideth,height,BufferedImage.TYPE_INT_RGB);
	        tag.getGraphics().drawImage(src,0,0,wideth,height,null); 
	        FileOutputStream out=new FileOutputStream(fi+"\\"+fileName); //输出到文件流
	        targetFile=new File(fi+"\\"+fileName);
	        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
	        encoder.encode(tag); //JPEG编码
	        out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		String targetURL = ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("UPLOAD_URL")).getConfigDefault().getValue()+"?user="+userName+"&userid="+userId+"&allPath=1";
		PostMethod filePost = new PostMethod(targetURL);
		StringBuffer sb = new StringBuffer();
		try {
			Part[] parts = { new FilePart(targetFile.getName(), targetFile) };
			filePost.setRequestEntity(new MultipartRequestEntity(parts, filePost.getParams()));
			HttpClient client = new HttpClient();
			client.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
			int status = client.executeMethod(filePost);
			if (status == HttpStatus.SC_OK) {
			    String s=	HttpStatus.getStatusText(status);
			    System.out.println(s);
				System.out.println("上传成功");
				BufferedReader _reader = new BufferedReader(new InputStreamReader(filePost.getResponseBodyAsStream()));
				String line;
				while ((line = _reader.readLine()) != null) {
					sb.append(line);
				}
				_reader.close();
			} else {
				System.out.println("上传失败");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			filePost.releaseConnection();
			deleteFile(fi+"\\"+fileName);
		}

		String result = sb.toString();

		if (!"".equals(sb.toString())) {
			result = result.substring(result.indexOf("filepath:'") + 10);
			msg = result.substring(0, result.indexOf("'"));

		}

		return msg;
	}
	/**
	 * 删除单个文件
	 * 
	 * @param sPath
	 *            被删除文件的文件名
	 * @return 单个文件删除成功返回true，否则返回false
	 */
	public  void deleteFile(String sPath) {

		File file = new File(sPath);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
		}
	}
	/**
	 * 查询可用的系统权限列表
	 */
	public List<ScAuth> getAuthListAllUsed() {
		Map<String,Object> condition=new HashMap<String,Object>();
		condition.put("enableState", ((ParamConfigBean)StrutsUtil.getApplication().getAttribute("CONFIG_STATE")).getValueByCode("enable"));
		List<ScAuth> list_query_auth=authServiceDao.queryAuthList(condition);
		return list_query_auth;
	}
	
	/**
	 * 根据用户，权限CODE查询该权限url
	 * 
	 * @return
	 */
	public String getUrlByCodeAndUser(ScUsers user, String code){
		return authServiceDao.getUrlByCodeAndUser(user, code);
	}
}
