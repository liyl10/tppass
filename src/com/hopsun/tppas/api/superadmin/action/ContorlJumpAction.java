/*************** 版权声明***************
*
* Copyright (C) 2012 西安辉盛科技发展有限责任公司.
*
********************************************
*/
package com.hopsun.tppas.api.superadmin.action;

import java.util.Date;

import com.hopsun.framework.base.action.BaseAction;
import com.hopsun.tppas.common.Constants;

/**
 * @comment 跳转控制类
 * @author liush
 * @DATE: 2013-5-23 @TIME: 下午2:09:37
 * @Vsersion: 1.0
 */
public class ContorlJumpAction  extends BaseAction{
	
	private static final long serialVersionUID = 8957654216422232791L;
	
	private String jumpFlg;
	private String actionName;
	private String subPage;
	
	/**
	 * @Comments 跳转控制方法
	 * @return
	 * @Vsersion: 1.0
	 */
	public String JumpAction() {
		
		// 待办事项（业务处）
		if (Constants.JUMP_FLG_0.equals(jumpFlg)) {
			actionName ="?now="+ new Date().getTime();
		}
		// 项目初审
		else if (Constants.JUMP_FLG_1.equals(jumpFlg)) {
			actionName ="/api/report/beforeReviewAction!showBeforeReviewSearch.action?now="+ new Date().getTime();
		// 评审专家选择
		} else if (Constants.JUMP_FLG_2.equals(jumpFlg)) {
			actionName = "/api/audit/projectApplication!showAuditExpertManage.action?now="+ new Date().getTime();
		// 项目审核
		} else if (Constants.JUMP_FLG_3.equals(jumpFlg)) {
			actionName = "/api/audit/projectApplication!showAuditManage.action?now="+ new Date().getTime();
		// 联席会审核
		} else if (Constants.JUMP_FLG_4.equals(jumpFlg)) {
			actionName = "/api/audit/projectApplicationJoint!showJointAuditManage.action?now="+ new Date().getTime();
		//立项建议
		} else if (Constants.JUMP_FLG_31.equals(jumpFlg)){
			actionName = "/api/audit/projectApplicationProposals!showProposalsManage.action?now="+ new Date().getTime();
		// 局办公会意见
		} else if(Constants.JUMP_FLG_32.equals(jumpFlg)){
			actionName = "/api/audit/projectApplicationOffice!showOfficeAuditManage.action?now="+ new Date().getTime();
		}
		// 分计划管理
		else if (Constants.JUMP_FLG_5.equals(jumpFlg)) {
			actionName = "/api/planManage/planManageAction!showPlanManage.action?now="+ new Date().getTime();
		// 合同管理
		} else if (Constants.JUMP_FLG_6.equals(jumpFlg)) {
			actionName = "/api/contract/tcontract!list.action?now="+ new Date().getTime();
		}
		// 项目监理
		else if (Constants.JUMP_FLG_7.equals(jumpFlg)) {
			actionName = "/api/supervisor/tsupervisorAction!supervisorManager.action?now=" + new Date().getTime();
		}
		// 项目验收
		else if (Constants.JUMP_FLG_8.equals(jumpFlg)) {
			actionName = "/api/acceptance/acceptance!init.action?now=" + new Date().getTime();
		}

		// 待办事项（计划处）
		else if (Constants.JUMP_FLG_9.equals(jumpFlg)) {
			actionName = "/api/report/waitThingItemAction!query.action?now="
					+ new Date().getTime();
		}

		// 项目调配
		else if (Constants.JUMP_FLG_10.equals(jumpFlg)) {
			actionName = "/api/report/projectDeployAction!showDeploySearch.action?now=?now=" + new Date().getTime();
		}

		// 分计划查看
		else if (Constants.JUMP_FLG_11.equals(jumpFlg)) {
			actionName = "/api/plan/plan!showPlanManage.action?now=" + new Date().getTime();
		}

		// 计划汇总
		else if (Constants.JUMP_FLG_12.equals(jumpFlg)) {
			actionName = "/api/planCollect/tplanCollectAction!initSearch.action?now=" + new Date().getTime();
		}

		// 分计划下发
		else if (Constants.JUMP_FLG_13.equals(jumpFlg)) {
			actionName = "?now=" + new Date().getTime();
		}

		// 归档管理
		else if (Constants.JUMP_FLG_14.equals(jumpFlg)) {
			actionName = "/api/report/tprojectApplicationAction!showArchivalManage.action?now=" + new Date().getTime();
		}

		// 专家库管理
		else if (Constants.JUMP_FLG_15.equals(jumpFlg)) {
			actionName = "?now=" + new Date().getTime();
		}
		// 申报单位管理
		else if (Constants.JUMP_FLG_16.equals(jumpFlg)) {
			actionName = "/api/reportingunit/TreportingUnitAction!list.action?now="
					+ new Date().getTime();
		}
		// 查询
		else if (Constants.JUMP_FLG_17.equals(jumpFlg)) {
			if ("1".equals(subPage)) {
				// 项目查询
				actionName = "/api/query/projectQuery!init.action?now=" + new Date().getTime();
			} else if ("2".equals(subPage)) {
				// 合同查询
				actionName = "/api/query/contractQuery!init.action?now=" + new Date().getTime();
			} else if ("3".equals(subPage)) {
				// 申报单位查询
				actionName = "/api/query/companyQuery!init.action?now=" + new Date().getTime();
			} else if ("4".equals(subPage)) {
				// 专家评审查询
				actionName = "/api/query/expertQuery!init.action?now=" + new Date().getTime();
			}
		}
		// 统计
		else if (Constants.JUMP_FLG_18.equals(jumpFlg)) {
			if ("1".equals(subPage)) {
				// 项目统计
				actionName = "/api/statistics/statisticsProject!init.action?now=" + new Date().getTime();
			} else if ("2".equals(subPage)) {
				// 项目结果汇总
				actionName = "/api/statistics/vprojectResultCollectAction!initSearch.action?now=" + new Date().getTime();
			} else if ("3".equals(subPage)) {
				// 项目结果汇总
				actionName = "/api/statistics/fundsAction!init.action?now=" + new Date().getTime();
			}else if("4".equals(subPage)){
				// 项目评审通过率统计
				actionName = "/api/report/tprojectApplicationAction!showProjectViewManage.action?now=" + new Date().getTime();
				
			}else if("5".equals(subPage)){
				// 项目评审通过率统计
				actionName = "/api/expert/texpertAction!showExpertStatistic.action?now=" + new Date().getTime();
			}else if("6".equals(subPage)){
				// 产业处项目统计
				actionName = "/api/industry/industryAction!showProjectIndustryManage.action?now=" + new Date().getTime();
			}
		}
		// 模板配置
		else if(Constants.JUMP_FLG_19.equals(jumpFlg)){
			if ("1".equals(subPage)) {
				actionName ="/api/superadmin/reportModel!init.action?now="+ new Date().getTime();
			} else if ("2".equals(subPage)) {
				actionName ="/api/superadmin/contractModel!init.action?now="+ new Date().getTime();
			} else if ("3".equals(subPage)) {
				actionName ="/api/superadmin/supervisorModel!init.action?now="+ new Date().getTime();
			} else if ("4".equals(subPage)) {
				actionName ="/api/superadmin/acceptanceModel!init.action?now="+ new Date().getTime();
			} else if ("5".equals(subPage)) {
				actionName ="/api/superadmin/typeModel!init.action?now="+ new Date().getTime();
			}
		}
		// 基础数据配置
		else if (Constants.JUMP_FLG_20.equals(jumpFlg)) {
			actionName = "/api/superadmin/mitem!init.action?subPage=" + subPage
					+ "&now=" + new Date().getTime();
		}
		// 项目撤销
		else if (Constants.JUMP_FLG_21.equals(jumpFlg)) {
			actionName = "/api/cancel/projectCancel!init.action?now=" + new Date().getTime();
		}
		//专家评审管理
		else if (Constants.JUMP_FLG_28.equals(jumpFlg)) {
			actionName = "/api/expert/texpertScoreAction!auditManager.action?subPage=" + subPage + "&now=" + new Date().getTime();
		}
		//专家信息维护
		else if (Constants.JUMP_FLG_29.equals(jumpFlg)) {
			actionName = "/api/expert/texpertInfoAction!expertManager.action?subPage=" + subPage + "&now=" + new Date().getTime();
		}
		//专家库管理
		else if (Constants.JUMP_FLG_30.equals(jumpFlg)) {
			actionName = "/api/expert/texpertAction!experManager.action?subPage=" + subPage
					+ "&now=" + new Date().getTime();
		}
		return "jump";
	}
	
	public String getJumpFlg() {
		return jumpFlg;
	}
	public void setJumpFlg(String jumpFlg) {
		this.jumpFlg = jumpFlg;
	}
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public String getSubPage() {
		return subPage;
	}
	public void setSubPage(String subPage) {
		this.subPage = subPage;
	}
}
