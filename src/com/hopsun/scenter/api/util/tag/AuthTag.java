package com.hopsun.scenter.api.util.tag;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.hopsun.scenter.entity.ScAuth;
import com.hopsun.scenter.entity.ScUsers;
 

/**
 * 按钮权限代码标签
 * @comments
 * @author app_2006
 * @date Jan 8, 2013
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public class AuthTag extends TagSupport{
 
	private static final long serialVersionUID = 1L;
	
	@Override
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}
	private String code; //权限代码
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
 	@Override
	public int doStartTag() throws JspException {
		if(code==null || "".equals(code)) return SKIP_BODY;
		String[] codes = code.split(",");
		// 权限限制标记
		boolean flag_cando = false;
		for(String code : codes){ 
			// 确认Session中是否存在sysUser
			HttpServletRequest request= (HttpServletRequest) this.pageContext.getRequest();
			HttpSession session = request.getSession();
			ScUsers user = (ScUsers) session.getAttribute("sysUser");
			//
			if (user != null) {
				// 存在的情况下进行后续操作。
				// 用户拥有的权限
				Set<ScAuth> userAuths =(Set<ScAuth>)session.getAttribute("userAuths");
				// 系统配置的权限
				//Set<ScAuth> sysAuths = (Set<ScAuth>)session.getAttribute("sysAuths");
				// 遍历用户拥有的权限
				for (ScAuth perUserAuth : userAuths) {
					if (code.equals(perUserAuth.getAuthCode())) {
						// 若用户拥有该权限，则可执行
						flag_cando = true;
						break;
					}
				}
				
			}
			if(flag_cando){
				break;
			}
		}
		if (flag_cando) {
			// 显示标签中内容
			return EVAL_BODY_INCLUDE;
		}  
		return SKIP_BODY;
	}
}
