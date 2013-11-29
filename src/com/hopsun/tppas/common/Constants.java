package com.hopsun.tppas.common;

/**
 *@comments 常量文件配置类
 *@author wangxiaodong
 *@date 2013-5-17 下午5:02:04 
 *@version 1.0
 */
public class Constants {
	
	public static final String STRING_EMPTY = "";
	public static final String SESSION_CMDKEY = "cmdkey";
	public static final String STRING_LINK = "-";
	
	/**公用是否删除 */
	/**公用是否删除-默认 */
	public static final String COMMON_STATE_DEFAULT="9";
	/**公用是否删除-不删除 */
	public static final String COMMON_STATE_NOTDELETE="0";
	/**公用是否删除 -删除*/
	public static final String COMMON_STATE_DELETE="1";
	
	/**合同、监理、验收公用类型*/
	/**合同、监理、验收                                                              公用类型-项目类*/
	public static final String COMMON_TYPE_PROJECT="0";
	/**合同、监理、验收公用类型-平台类*/
	public static final String COMMON_TYPE_PLATFORM="1";
	
	/**项目申报类型*/
	public static final String TYPE_PROJECT_TYPE = "402882433e694af8013e6967ccb50000";
	/**项目申报类型-产业集群发展类*/
	public static final String PROJECT_TYPE_01="402882433e696e18013e696ed9b40000";
	/**项目申报类型-企业规模发展类*/
	public static final String PROJECT_TYPE_02="402882433e696e18013e696f0bb00001";
	/**项目申报类型-企业快速增长类*/
	public static final String PROJECT_TYPE_03="402882433e696e18013e696f480e0002";
	/**项目申报类型-公共服务平台类*/
	public static final String PROJECT_TYPE_04="402882433e696e18013e696f7f3b0003";
	
	/**项目申报状态*/
	public static final String TYPE_PROJECT_REPORT="402882433e681d8d013e687c15d00004";
	
	/**项目申报状态-填写中*/
	public static final String PROJECT_REPORT_WRITE="402882433e681d8d013e687dc72a0005";
	/**项目申报状态-已申报*/
	public static final String PROJECT_REPORT_SUBMIT="402882433e681d8d013e687eecbe0006";
	/**项目申报状态-审核中*/
	public static final String PROJECT_REPORT_VERIFY="402882433e68e13b013e68e413360000";
	/**项目申报状态-已通过*/
	public static final String PROJECT_REPORT_PASS="402882433e68e13b013e68e4b38d0001";
	/**项目申报状态-未通过(可修改)*/
	public static final String PROJECT_REPORT_NOTPASS="402882433e68e13b013e68e52f550002";
	/**项目申报状态-未通过(不可修改)*/
	public static final String PROJECT_REPORT_NOTPASS_N="402882433e68e13b013e68e52f550002";
	/** 项目申报状态-等待调配 */
	public static final String PROJECT_REPORT_REDISTRIBUTE= "402882a241019294014101be1c830000";
	/** 项目申报状态-初审中 */
	public static final String PROJECT_REPORT_BEFOREREIEW_ING= "402882a24125b43a014125e3656c0000";
	/** 初审通过 */
	public static final String PROJECT_REPORT_BEFOREREVIEW_PASS = "402882a24105dc82014105f2aedf0000";
	/** 初审不通过（可修改）*/
	public static final String PROJECT_REPORT_BEFOREREVIEW_NOPASS = "402882a24105dc82014105f356d60001";
	/** 初审不通过（不可修改） */
	public static final String PROJECT_REPORT_BEFOREREVIEW_NOPASS_N = "402882a24105dc82014105f392390002";
	/**项目申报状态-申请撤销*/
	public static final String PROJECT_REPORT_APPLY_REVOCATION="40288125414f356901414f388a3c0000";
	
	/**项目申报状态-联席会审核中*/
	public static final String PROJECT_REPORT_JOINT_ING="402881d34129b85a014129bc3b340000";
	/**项目申报状态-联席会审核通过*/
	public static final String PROJECT_REPORT_JOINT_PASS="402881d34129a4ba014129a6ce480000";
	/**项目申报状态-联席会审核未通过*/
	public static final String PROJECT_REPORT_JOINT_NOPASS="402881d34129a4ba014129a711d90001";
	
	/**合同状态*/
	public static final String TYPE_CONTRACT_STATE = "402882433e696e18013e69716ce20004";
	/**合同状态-已下发*/
	public static final String CONTRACT_STATE_ISSUED="402882433e696e18013e697206050005";
//	/**合同状态-填报中*/
//	public static final String CONTRACT_STATE_WRITE="402882433e696e18013e6972fc1d0006";
//	/**合同状态-已提交*/
//	public static final String CONTRACT_STATE_SUBMIT="402882433e696e18013e697344220007";
//	/**合同状态-审核中*/
//	public static final String CONTRACT_STATE_VERIFY="402882433e696e18013e69736bee0008";
//	/**合同状态-合同不通过(可修改)*/
//	public static final String CONTRACT_STATE_NOTPASS_MODIFI="402882433e696e18013e6974be9d0009";
//	/**合同状态-合同不通过（不可修改）*/
//	public static final String CONTRACT_STATE_NOTPASS_NOMODIFY="4028825041102ea801411031f3090000";
//	/**合同状态-合同签订*/
//	public static final String CONTRACT_STATE_SIGNED="402882433e696e18013e6974fccf000a";
	/**合同状态-未下发*/
	public static final String CONTRACT_STATE_NOISSUED="402882504206f6b4014206f90c980000";
	
	/**监理状态*/
	public static final String TYPE_SUPERVISOR_STATE = "402882433e6817b1013e6819caca0000";
	/**监理状态-工作报告阶段*/
	public static final String SUPERVISOR_STATE_REPORT="402882433e681d8d013e68506be50000";
	/**监理状态-已申请监理审核*/
	public static final String SUPERVISOR_STATE_APPLY="402882433e681d8d013e6864dc710001";
	/**监理状态-监理不通过可修改 */
	public static final String SUPERVISOR_STATE_NOTPASS_EDIT="402882433e681d8d013e686551ef0002";
	/**监理状态-监理不通过不可修改 */
	public static final String SUPERVISOR_STATE_NOTPASS_NOEDIT="ff8080814106d1ea01410b6933340000";
	/**监理状态-监理通过*/
	public static final String SUPERVISOR_STATE_PASS="402882433e681d8d013e6865c4ae0003";
	
	/**流程状态*/
	public static final String TYPE_FLOW_STATUS = "402882433e68e13b013e68e85c810004";
	/**流程状态-开始*/
	public static final String FLOW_STATUS_START="402882433e68e13b013e68eafa5d0005";
	/**流程状态-已提交*/
	public static final String FLOW_STATUS_SUBMIT="402882433e68e13b013e68ec2a230006";
	/**流程状态-项目审核 */
	public static final String FLOW_STATUS_VERIFY="402882433e68e13b013e68eca7fd0007";
	/**流程状态-项目立项*/
	public static final String FLOW_STATUS_PROJECT_APPROVAL="402882433e68e13b013e68ed064a0008";
	/**流程状态-合同下发*/
	public static final String FLOW_STATUS_CONTRACT_ISSUED ="402882433e68e13b013e68eda4cc0009";
	/**流程状态-合同审核*/
	public static final String FLOW_STATUS_CONTRACT_VERIFY="402882433e68e13b013e68ee170e000a";
	/**流程状态-合同签订*/
	public static final String FLOW_STATUS_CONTRACT_SIGNED="402882433e68e13b013e68ee7f5d000b";
	/**流程状态-项目监理*/
	public static final String FLOW_STATUS_SUPERVISION="402882433e68e13b013e69031ec8000c";
	/**流程状态-监理通过*/
	public static final String FLOW_STATUS_SUPERVISION_PASS="402882433e68e13b013e69043eb0000d";
	/**流程状态-项目验收*/
	public static final String FLOW_STATUS_ACCEPTANCE="402882433e68e13b013e6904b130000e";
	/**流程状态-验收结束*/
	public static final String FLOW_STATUS_ACCEPTANCE_END="402882433e68e13b013e690539c9000f";
	/**流程状态-结束*/
	public static final String FLOW_STATUS_TOTAL_END="402882433ea1b088013ea26dbd860000";
	
	/**项目申报菜单*/
	/**项目申报菜单-类型*/
	public static final String PROJECT_REPORT_MENU_TYPE="402882433e7ca111013e7cafad6d0000";
	/**项目申报菜单-西安市科技计划项目申报书*/
	public static final String PROJECT_REPORT_MENU_01="402882433e7ca111013e7cb015200001";
	/**项目申报菜单-项目须知*/
	public static final String PROJECT_REPORT_MENU_02="402882433e7ca111013e7cb042b80002";
	/**项目申报菜单-项目基本信息*/
	public static final String PROJECT_REPORT_MENU_03="402882433e7ca111013e7cb07fff0003";
	/**项目申报菜单-企业简介和发展前景*/
	public static final String PROJECT_REPORT_MENU_04="402882433e7ca111013e7cb0b2a80004";
	/**项目申报菜单-项目概况和市场分析*/
	public static final String PROJECT_REPORT_MENU_05="402882433e7ca111013e7cb0ecf20005";
	/**项目申报菜单-主要技术内容与技术创新点*/
	public static final String PROJECT_REPORT_MENU_06="402882433e7ca111013e7cb118760006";
	/**项目申报菜单-前期基础及现有条件和优势*/
	public static final String PROJECT_REPORT_MENU_07="402882433e7ca111013e7cb145050007";
	/**项目申报菜单-进度安排和经济指标*/
	public static final String PROJECT_REPORT_MENU_08="402882433e7ca111013e7cb1779e0008";
	/**项目申报菜单-主要研究人员*/
	public static final String PROJECT_REPORT_MENU_09="402882433e7ca111013e7cb1a7680009";
	/**项目申报菜单-执行期内企业完成的经济指标*/
	public static final String PROJECT_REPORT_MENU_10="402882433e7ca111013e7cb1e934000a";
	/**项目申报菜单-经费概算*/
	public static final String PROJECT_REPORT_MENU_11="402882433e7ca111013e7cb21c79000b";
	/**项目申报菜单-资金主要用途及用款计划*/
	public static final String PROJECT_REPORT_MENU_12="402882433e7ca111013e7cb24bd6000c";
	/**项目申报菜单-审查意见*/
	public static final String PROJECT_REPORT_MENU_13="402882433e7ca111013e7cb27c6b000d";
	/**项目申报菜单-附件清单*/
	public static final String PROJECT_REPORT_MENU_14="402882433e7ca111013e7cb2a792000e";
	/**项目申报菜单-提交申报*/
	public static final String PROJECT_REPORT_MENU_15="402881d33ed59d98013ed5c14cf90000";
	
	public static final String PROJECT_REPORT_MENU_17="4028812540b882200140b88cff4b0001";
	/**项目申报菜单(非高新)*/
	/**项目申报菜单(非高新)-类型*/
	public static final String PROJECT_REPORT_NONTECT_MENU_TYPE = "402881d340946b4d0140946fd0340000";
	/**项目申报菜单-西安市科技计划项目申报书*/
	public static final String PROJECT_REPORT_NONTECT_MENU_01="402881d340946b4d01409472a5ca0001";
	/**项目申报菜单-项目须知*/
	public static final String PROJECT_REPORT_NONTECT_MENU_02="402881d340946b4d01409472fd120002";
	/**项目申报菜单-项目基本信息*/
	public static final String PROJECT_REPORT_NONTECT_MENU_03="402881d340946b4d01409473f2cc0003";
	/**项目申报菜单-项目摘要*/
	public static final String PROJECT_REPORT_NONTECT_MENU_04="402881d340946b4d0140947417c90004";
	/**项目申报菜单-研究水平、发展趋势和市场需求*/
	public static final String PROJECT_REPORT_NONTECT_MENU_05="402881d340946b4d0140947441590005";
	/**项目申报菜单-主要研究内容与技术创新点*/
	public static final String PROJECT_REPORT_NONTECT_MENU_06="402881d340946b4d01409474e8090006";
	/**项目申报菜单-前期基础及现有条件和优势*/
	public static final String PROJECT_REPORT_NONTECT_MENU_07="402881d340946b4d01409475091e0007";
	/**项目申报菜单-项目进度计划*/
	public static final String PROJECT_REPORT_NONTECT_MENU_08="402881d340946b4d014094752a900008";
	/**项目申报菜单-主要研究人员*/
	public static final String PROJECT_REPORT_NONTECT_MENU_09="402881d340946b4d0140947550c60009";
	/**项目申报菜单-执行期内企业完成的经济指标*/
	public static final String PROJECT_REPORT_NONTECT_MENU_10="402881d340946b4d01409475b26e000a";
	/**项目申报菜单-项目实现后的经济效益*/
	public static final String PROJECT_REPORT_NONTECT_MENU_11="402881d340946b4d01409475d7d8000b";
	/**项目申报菜单-经费概算*/
	public static final String PROJECT_REPORT_NONTECT_MENU_12="402881d340946b4d01409475fb1f000c";
	/**项目申报菜单-资金主要用途及用款计划*/
	public static final String PROJECT_REPORT_NONTECT_MENU_13="402881d340946b4d01409476b45d000d";
	/**项目申报菜单-审查意见*/
	public static final String PROJECT_REPORT_NONTECT_MENU_14="402881d340946b4d01409476da83000e";
	/**项目申报菜单-企业自主知识产权汇总 */
	public static final String PROJECT_REPORT_NONTECT_MENU_15="402881d340946b4d01409476fdab000f";
	/**项目申报菜单-企业培育计划推荐*/
	public static final String PROJECT_REPORT_NONTECT_MENU_16="402881d340946b4d01409477b8ec0010";
	/**项目申报菜单-附件清单*/
	public static final String PROJECT_REPORT_NONTECT_MENU_17="402881d340946b4d01409477f75c0011";
	/**项目申报菜单-提交申报*/
	public static final String PROJECT_REPORT_NONTECT_MENU_18="402881d340946b4d01409478912b0012";
	
	
	/**项目申报管理菜单(高新处)后台*/
	/**项目申报管理菜单-类型*/
	public static final String API_PROJECT_REPORT_MENU_TYPE="402881d33ed59d98013ed5c295d40001";
	/**项目申报管理菜单-西安市科技计划项目申报书*/
	public static final String API_PROJECT_REPORT_MENU_01="402882433e7ca111113e7cb015200001";
	/**项目申报管理菜单-项目须知*/
	public static final String API_PROJECT_REPORT_MENU_02="402882433e7ca111113e7cb042b80002";
	/**项目申报管理菜单-项目基本信息*/
	public static final String API_PROJECT_REPORT_MENU_03="402882433e7ca111113e7cb07fff0003";
	/**项目申报管理菜单-企业简介和发展前景*/
	public static final String API_PROJECT_REPORT_MENU_04="402882433e7ca111113e7cb0b2a80004";
	/**项目申报管理菜单-项目概况和市场分析*/
	public static final String API_PROJECT_REPORT_MENU_05="402882433e7ca111113e7cb0ecf20005";
	/**项目申报管理菜单-主要技术内容与技术创新点*/
	public static final String API_PROJECT_REPORT_MENU_06="402882433e7ca111113e7cb118760006";
	/**项目申报管理菜单-前期基础及现有条件和优势*/
	public static final String API_PROJECT_REPORT_MENU_07="402882433e7ca111113e7cb145050007";
	/**项目申报管理菜单-进度安排和经济指标*/
	public static final String API_PROJECT_REPORT_MENU_08="402882433e7ca111113e7cb1779e0008";
	/**项目申报管理菜单-主要研究人员*/
	public static final String API_PROJECT_REPORT_MENU_09="402882433e7ca111113e7cb1a7680009";
	/**项目申报管理菜单-执行期内企业完成的经济指标*/
	public static final String API_PROJECT_REPORT_MENU_10="402882433e7ca111113e7cb1e934000a";
	/**项目申报管理菜单-项目实现后的经济效益*/
	public static final String API_PROJECT_REPORT_MENU_11="4028098140f272f40140f27dec070000";
	/**项目申报管理菜单-经费概算*/
	public static final String API_PROJECT_REPORT_MENU_12="402882433e7ca111113e7cb21c79000b";
	/**项目申报管理菜单-资金主要用途及用款计划*/
	public static final String API_PROJECT_REPORT_MENU_13="402882433e7ca111113e7cb24bd6000c";
	/**项目申报管理菜单-审查意见*/
	public static final String API_PROJECT_REPORT_MENU_14="402882433e7ca111113e7cb27c6b000d";
	/**项目申报管理菜单-企业项目基本信息表*/
	public static final String API_PROJECT_REPORT_MENU_15="4028825040ce9c270140ce9eb5190000";
	/**项目申报管理菜单-附件清单*/
	public static final String API_PROJECT_REPORT_MENU_16="402882433e7ca111113e7cb2a792000e";
	
	/**项目申报管理菜单(非高新)后台*/
	/**项目申报管理菜单(非高新)-类型*/
	public static final String API_REPORT_NONTECT_MENU_TYPE = "4028824340c3b3f90140c3b5dc980000";
	/**项目申报管理菜单-西安市科技计划项目申报书*/
	public static final String API_REPORT_NONTECT_MENU_01="4028824340c3b3f90140c3b71e7e0001";
	/**项目申报管理菜单-项目须知*/
	public static final String API_REPORT_NONTECT_MENU_02="4028824340c3b3f90140c3b75e650002";
	/**项目申报管理菜单-项目基本信息*/
	public static final String API_REPORT_NONTECT_MENU_03="4028824340c3b3f90140c3b7b2fe0003";
	/**项目申报管理菜单-项目摘要*/
	public static final String API_REPORT_NONTECT_MENU_04="4028824340c3b3f90140c3b7d5d70004";
	/**项目申报管理菜单-研究水平、发展趋势和市场需求*/
	public static final String API_REPORT_NONTECT_MENU_05="4028824340c3b3f90140c3b7f8540005";
	/**项目申报管理菜单-主要研究内容与技术创新点*/
	public static final String API_REPORT_NONTECT_MENU_06="4028824340c3b3f90140c3b81eb80006";
	/**项目申报管理菜单-前期基础及现有条件和优势*/
	public static final String API_REPORT_NONTECT_MENU_07="4028824340c3b3f90140c3b852890007";
	/**项目申报管理菜单-项目进度计划*/
	public static final String API_REPORT_NONTECT_MENU_08="4028824340c3b3f90140c3b878320008";
	/**项目申报管理菜单-主要研究人员*/
	public static final String API_REPORT_NONTECT_MENU_09="4028824340c3b3f90140c3b89a700009";
	/**项目申报管理菜单-执行期内企业完成的经济指标*/
	public static final String API_REPORT_NONTECT_MENU_10="4028824340c3b3f90140c3b8c1ce000a";
	/**项目申报管理菜单-项目实现后的经济效益*/
	public static final String API_REPORT_NONTECT_MENU_11="4028824340c3b3f90140c3b8e803000b";
	/**项目申报管理菜单-经费概算*/
	public static final String API_REPORT_NONTECT_MENU_12="4028824340c3b3f90140c3b90a12000c";
	/**项目申报管理菜单-资金主要用途及用款计划*/
	public static final String API_REPORT_NONTECT_MENU_13="4028824340c3b3f90140c3b92d49000d";
	/**项目申报管理菜单-审查意见*/
	public static final String API_REPORT_NONTECT_MENU_14="4028824340c3b3f90140c3b9499b000e";
	/**项目申报管理菜单-企业自主知识产权汇总 */
	public static final String API_REPORT_NONTECT_MENU_15="4028824340c3b3f90140c3b96c56000f";
	/**项目申报管理菜单-企业项目基本信息表 */
	public static final String API_REPORT_NONTECT_MENU_16="4028824340c3b3f90140c3b9b2a60011";
	/**项目申报管理菜单-附件清单*/
	public static final String API_REPORT_NONTECT_MENU_17="ff808081415a344e0141678eb81c0006";

	/**合同填报（签订）菜单  （高新）*/
	/**合同填报（签订）菜单-类型*/
	public static final String CONTRACT_MENU_TYPE="402882433ea0be1a013ea0f500170001";
	/**合同填报（签订）菜单-合同封皮*/
	public static final String CONTRACT_MENU_01="402882433ea0be1a013ea0f819bb0002";
	/**合同填报（签订）菜单-合同内容*/
	public static final String CONTRACT_MENU_02="402882433ea0be1a013ea0f861ef0003";
	/**合同填报（签订）菜单-项目经费使用表*/
	public static final String CONTRACT_MENU_03="402882433ea0be1a013ea0f89cf40004";
	/**合同填报（签订）菜单-说明*/
	public static final String CONTRACT_MENU_04="402882433ea0be1a013ea0f90ae10005";
	/**合同填报（签订）菜单-附件清单*/
	public static final String CONTRACT_MENU_05="402882433ea0be1a013ea0f9741b0006";
	/**合同填报（签订）菜单-提交合同*/
	public static final String CONTRACT_MENU_06="402881d33ed59d98013ed5e3fcdb0002";
	
	
	/**合同填报（签订）菜单   （非高新）*/
	/**合同填报（签订）菜单-类型*/
	public static final String CONTRACT_MENU_NONTECH_TYPE="402882504095e749014095ea9bb30000";
	/**合同填报（签订）菜单-合同封皮*/
	public static final String CONTRACT_MENU_NONTECH_01="402882504095e749014095ed758f0001";
	/**合同填报（签订）菜单-项目总体情况及主要内容*/
	public static final String CONTRACT_MENU_NONTECH_02="402882504095e749014095eed2120002";
	/**合同填报（签订）菜单-项目经费计划*/
	public static final String CONTRACT_MENU_NONTECH_03="402882504095e749014095ef21c80003";
	/**合同填报（签订）菜单-合同说明*/
	public static final String CONTRACT_MENU_NONTECH_04="402882504095e749014095ef63740004";
	/**合同填报（签订）菜单-填表说明*/
	public static final String CONTRACT_MENU_NONTECH_05="402882504095e749014095efb7be0005";
	/**合同填报（签订）菜单-附件清单*/
	public static final String CONTRACT_MENU_NONTECH_06="402882504095e749014095f002640006";
	/**合同填报（签订）菜单-提交合同*/
	public static final String CONTRACT_MENU_NONTECH_07="402882504095e749014095f08e480007";
	
	/**合同填报管理（签订）菜单   （高新）*/
	/**合同填报管理（签订）菜单-类型*/
	public static final String API_CONTRACT_MENU_TYPE="402881d33ed59d98013ed5e639fa0003";
	/**合同填报管理（签订）菜单-合同封皮*/
	public static final String API_CONTRACT_MENU_01="402881d33ed59d98013ed5e7dab90004";
	/**合同填报管理（签订）菜单-合同内容*/
	public static final String API_CONTRACT_MENU_02="402881d33ed59d98013ed5e848c50005";
	/**合同填报管理（签订）菜单-项目经费使用表*/
	public static final String API_CONTRACT_MENU_03="402881d33ed59d98013ed5e8abc50006";
	/**合同填报管理（签订）菜单-说明*/
	public static final String API_CONTRACT_MENU_04="402881d33ed59d98013ed5e91d1c0007";
	/**合同填报管理（签订）菜单-附件清单*/
	public static final String API_CONTRACT_MENU_05="402881d33ed59d98013ed5e980b80008";
	/**合同填报管理（签订）菜单-合同审核*/
	public static final String API_CONTRACT_MENU_06="402881d33ed59d98013ed5e9f1740009";
	
	/**合同填报管理（签订）菜单   （非高新）*/
	/**合同填报管理（签订）菜单-类型*/
	public static final String API_CONTRACT_MENU_NONTECH_TYPE="40288250410bf10301410bf5c9ed0000";
	/**合同填报管理（签订）菜单-合同封皮*/
	public static final String API_CONTRACT_MENU_NONTECH_01="40288250410bf10301410c01f5190001";
	/**合同填报管理（签订）菜单-项目总体情况及主要内容*/
	public static final String API_CONTRACT_MENU_NONTECH_02="40288250410bf10301410c02bef10002";
	/**合同填报管理（签订）菜单-项目经费计划*/
	public static final String API_CONTRACT_MENU_NONTECH_03="40288250410bf10301410c02fa350003";
	/**合同填报管理（签订）菜单-合同说明*/
	public static final String API_CONTRACT_MENU_NONTECH_04="40288250410bf10301410c035c890004";
	/**合同填报管理（签订）菜单-填表说明*/
	public static final String API_CONTRACT_MENU_NONTECH_05="40288250410bf10301410c03b0370005";
	/**合同填报管理（签订）菜单-附件清单*/
	public static final String API_CONTRACT_MENU_NONTECH_06="40288250410bf10301410c0403e50006";
	/**合同填报管理（签订）菜单-合同审核*/
	public static final String API_CONTRACT_MENU_NONTECH_07="40288250410bf10301410c04fb450007";
	
	
	/**项目验收菜单（项目类）*/
	/**项目验收菜单（项目类）-类型*/
	public static final String ACCEPTANCE_XM_TYPE="402882433ea0be1a013ea1092e690007";
	/**项目验收菜单（项目类）-项目验收申请表封皮*/
	public static final String ACCEPTANCE_XM_01="402882433ea0be1a013ea109c6820008";
	/**项目验收菜单（项目类）-专项项目各类指标完成情况*/
	public static final String ACCEPTANCE_XM_02="402882433ea0be1a013ea109fb1f0009";
	/**项目验收菜单（项目类）-资金使用情况*/
	public static final String ACCEPTANCE_XM_03="402882433ea0be1a013ea10a36d0000a";
	/**项目验收菜单（项目类）-执行期内企业取得的成果*/
	public static final String ACCEPTANCE_XM_04="402882433ea0be1a013ea10a6d13000b";
	/**项目验收菜单（项目类）-项目执行情况总结*/
	public static final String ACCEPTANCE_XM_05="402882433ea0be1a013ea10c017e000c";
	/**项目验收菜单（项目类）-附件清单*/
	public static final String ACCEPTANCE_XM_06="402882433ea0be1a013ea10c232f000d";
	/**项目验收菜单（项目类）-提交项目验收表*/
	public static final String ACCEPTANCE_XM_07="402881d33ed46bb3013ed494e6a10000";
	
	/**项目验收菜单（平台类）*/
	/**项目验收菜单（平台类）-类型*/
	public static final String ACCEPTANCE_PT_TYPE="402882433ea0be1a013ea10c9af0000e";
	/**项目验收菜单（平台类）-项目验收申请表封皮*/
	public static final String ACCEPTANCE_PT_01="402882433ea0be1a013ea10d0f26000f";
	/**项目验收菜单（平台类）-各类指标情况*/
	public static final String ACCEPTANCE_PT_02="402882433ea0be1a013ea10dabe30010";
	/**项目验收菜单（平台类）-资金使用情况*/
	public static final String ACCEPTANCE_PT_03="402882433ea0be1a013ea10de9d60011";
	/**项目验收菜单（平台类）-执行期内取得的成效*/
	public static final String ACCEPTANCE_PT_04="402882433ea0be1a013ea10e296f0012";
	/**项目验收菜单（平台类）-项目执行情况总结*/
	public static final String ACCEPTANCE_PT_05="402882433ea0be1a013ea10e5d120013";
	/**项目验收菜单（平台类）-附件清单*/
	public static final String ACCEPTANCE_PT_06="402882433ea0be1a013ea10ea1fb0014";
	/**项目验收菜单（平台类）-提交项目验收表*/
	public static final String ACCEPTANCE_PT_07="402881d33ed46bb3013ed495794c0001";
	
	
	/**项目验收管理菜单（非高新）后台*/
	/**项目验收管理菜单（非高新）-类型*/
	public static final String API_ACCEPTANCE_XM_TYPE="402881d33ed46bb3013ed497397a0002";
	/**项目验收管理菜单（非高新）-项目验收基本信息*/
	public static final String API_ACCEPTANCE_XM_01="402881d33ed46bb3013ed498888f0004";
	/**项目验收管理菜单（非高新）-项目经费落实和使用情况 */
	public static final String API_ACCEPTANCE_XM_02="402881d33ed46bb3013ed49918aa0005";
	/**项目验收管理菜单（非高新）-项目取得成果情况 */
	public static final String API_ACCEPTANCE_XM_03="402881d33ed46bb3013ed499a3370006";
	/**项目验收管理菜单（非高新）-项目总结说明*/
	public static final String API_ACCEPTANCE_XM_04="402881d33ed46bb3013ed49a06460007";
	/**项目验收管理菜单（非高新）-附件清单*/
	public static final String API_ACCEPTANCE_XM_05="402881d33ed46bb3013ed49a730a0008";
	
	/**项目验收管理菜单（高新处）后台*/
	/**项目验收管理菜单（高新处）-类型*/
	public static final String API_ACCEPTANCE_HT_TYPE="402881d33ed46bb3013ed497920a0003";
	/**项目验收管理菜单（高新处）-项目验收申请表封皮*/
	public static final String API_ACCEPTANCE_HT_01="402881d33ed46bb3013ed49e7d09000b";
	/**项目验收管理菜单（高新处）-项目经费落实和使用情况*/
	public static final String API_ACCEPTANCE_HT_02="402881d33ed46bb3013ed49ecf40000c";
	/**项目验收管理菜单（高新处）-对照合同项目任务完成情况 */
	public static final String API_ACCEPTANCE_HT_03="402881d33ed46bb3013ed49f4b55000d";
	/**项目验收管理菜单（高新处）-企业获得资金支持情况*/
	public static final String API_ACCEPTANCE_HT_04="402881d33ed46bb3013ed49ff958000e";
	/**项目验收管理菜单（高新处）-企业发展情况*/
	public static final String API_ACCEPTANCE_HT_05="402881d33ed46bb3013ed4a04a18000f";
	/**项目验收管理菜单（高新处）-验收意见*/
	public static final String API_ACCEPTANCE_HT_06="402881d33ed46bb3013ed4a0c4490010";
	/**项目验收管理菜单（高新处）-单位意见*/
	public static final String API_ACCEPTANCE_HT_07="402881d33ed46bb3013ed4a1a1c90011";
	/**项目验收管理菜单（高新处）-项目主要参加人员名单*/
	public static final String API_ACCEPTANCE_HT_08="40280981410ffdb40141103d7db40000";
	/**项目验收管理菜单（高新处）-验收小组名单*/
	public static final String API_ACCEPTANCE_HT_09="40280981410ffdb40141103f59340001";
	/**项目验收管理菜单（高新处）-项目验收经费登记表*/
	public static final String API_ACCEPTANCE_HT_10="40280981410ffdb401411042786b0002";
	/**项目验收管理菜单（高新处）-附件清单*/
	public static final String API_ACCEPTANCE_HT_11="40280981410ffdb401411042c5f10003";
	
	/*******************************************项目监理管理菜单-高新-前台***************************************/
	/**项目监理管理菜单-类型*/
	public static final String TSUPERVISOR_TYPE="402881d33ee4e7f0013ee501241f0000";
	/**项目监理管理菜单-监理封面*/
	public static final String TSUPERVISOR_01="402881d33ee4e7f0013ee503df370002";
	/**项目监理管理菜单-填表说明*/
	public static final String TSUPERVISOR_02="402881d33ee4e7f0013ee50446db0003";
	/**项目监理管理菜单-基本信息*/
	public static final String TSUPERVISOR_03="402881d33ee4e7f0013ee5048b270004";
	/**项目监理管理菜单-项目资金情况*/
	public static final String TSUPERVISOR_04="402881d33ee4e7f0013ee50518540005";
	/**项目监理管理菜单-附件清单*/
	public static final String TSUPERVISOR_05="";
	/**项目监理管理菜单-监理提交*/
	public static final String TSUPERVISOR_06="402881d33ee4e7f0013ee505d6450007";
	
	/*******************************************项目监理管理菜单-高新-后台***************************************/
	/**项目监理管理菜单-类型*/
	public static final String TSUPERVISOR_TYPE_ADMIN="402881d33ee4e7f0013ee50160d90001";
	/**项目监理管理菜单-监理封面*/
	public static final String TSUPERVISOR_ADMIN_01="402881d33ee4e7f0013ee506aa2f0008";
	/**项目监理管理菜单-填表说明*/
	public static final String TSUPERVISOR_ADMIN_02="402881d33ee4e7f0013ee506ee2d0009";
	/**项目监理管理菜单-基本信息*/
	public static final String TSUPERVISOR_ADMIN_03="402881d33ee4e7f0013ee50793d3000a";
	/**项目监理管理菜单-项目资金情况*/
	public static final String TSUPERVISOR_ADMIN_04="402881d33ee4e7f0013ee50812a8000b";
	/**项目监理管理菜单-附件清单*/
	public static final String TSUPERVISOR_ADMIN_05="";
	/**项目监理管理菜单-监理审核*/
	public static final String TSUPERVISOR_ADMIN_06="402881d33ee4e7f0013ee508acb5000d";
	
	/********************************项目监理管理菜单-非高新-前台*******************************************/
	/**项目监理管理菜单-非高新-类型*/
	public static final String TSUPERVISOR_OTHER_TYPE="402881f240c3dfd70140c3f23fa3000f";
	/**项目监理管理菜单-非高新-监理封面*/
	public static final String TSUPERVISOR_OTHER_MENU1="402881f240c3dfd70140c3f3a9a30010";
	/**项目监理管理菜单-非高新-填表说明*/
	public static final String TSUPERVISOR_OTHER_MENU2="402881f240c3dfd70140c3f420c70011";
	/**项目监理管理菜单-非高新-资金情况*/
	public static final String TSUPERVISOR_OTHER_MENU3="402881f240c3dfd70140c3f4922e0012";
	/**项目监理管理菜单-非高新-对照合同项目任务完成情况*/
	public static final String TSUPERVISOR_OTHER_MENU4="402881f240c3dfd70140c3f523b00013";
	/**项目监理管理菜单-非高新-项目取得成果情况*/
	public static final String TSUPERVISOR_OTHER_MENU5="402881f240c3dfd70140c3f58da50014";
	/**项目监理管理菜单-非高新-项目产业化进展情况*/
	public static final String TSUPERVISOR_OTHER_MENU6="402881f240c3dfd70140c3f637630015";
	/**项目监理管理菜单-非高新-项目实施管理情况*/
	public static final String TSUPERVISOR_OTHER_MENU7="402881f240c3dfd70140c3f69f540016";
	/**项目监理管理菜单-非高新-企业发展情况*/
	public static final String TSUPERVISOR_OTHER_MENU8="402881f240c3dfd70140c3f711380017";
	/**项目监理管理菜单-非高新-项目承担单位真实性承诺*/
	public static final String TSUPERVISOR_OTHER_MENU9="402881f240c3dfd70140c3f772920018";
	/**项目监理管理菜单-非高新-附件清单*/
	public static final String TSUPERVISOR_OTHER_MENU10="402881f240c3dfd70140c3f7ca570019";
	/**项目监理管理菜单-非高新-监理提交*/
	public static final String TSUPERVISOR_OTHER_MENU11="402881f240c3dfd70140c3f81c01001a";
	
	/********************************项目监理管理菜单-非高新-后台*******************************************/
	/**项目监理管理菜单-非高新-后台-类型*/
	public static final String TSUPERVISOR_ADMIN_OTHER_TYPE="ff808081412ac5e60141445aaa2d0000";
	/**项目监理管理菜单-非高新-后台-监理封面*/
	public static final String TSUPERVISOR_ADMIN_OTHER_MENU1="ff808081412ac5e60141445b93620001";
	/**项目监理管理菜单-非高新-后台-填表说明*/
	public static final String TSUPERVISOR_ADMIN_OTHER_MENU2="ff808081412ac5e60141445c626f0002";
	/**项目监理管理菜单-非高新-后台-资金情况*/
	public static final String TSUPERVISOR_ADMIN_OTHER_MENU3="ff808081412ac5e60141445d0fd60003";
	/**项目监理管理菜单-非高新-后台-对照合同项目任务完成情况*/
	public static final String TSUPERVISOR_ADMIN_OTHER_MENU4="ff808081412ac5e60141445ea7540004";
	/**项目监理管理菜单-非高新-后台-项目取得成果情况*/
	public static final String TSUPERVISOR_ADMIN_OTHER_MENU5="ff808081412ac5e60141445f74290005";
	/**项目监理管理菜单-非高新-后台-项目产业化进展情况*/
	public static final String TSUPERVISOR_ADMIN_OTHER_MENU6="ff808081412ac5e6014144601a4d0006";
	/**项目监理管理菜单-非高新-后台-项目实施管理情况*/
	public static final String TSUPERVISOR_ADMIN_OTHER_MENU7="ff808081412ac5e601414460f7280007";
	/**项目监理管理菜单-非高新-后台-企业发展情况*/
	public static final String TSUPERVISOR_ADMIN_OTHER_MENU8="ff808081412ac5e60141446242610008";
	/**项目监理管理菜单-非高新-后台-项目承担单位真实性承诺*/
	public static final String TSUPERVISOR_ADMIN_OTHER_MENU9="ff808081412ac5e601414462d5f40009";
	/**项目监理管理菜单-非高新-后台-附件清单*/
	public static final String TSUPERVISOR_ADMIN_OTHER_MENU10="ff808081412ac5e6014144637d12000a";
	/**项目监理管理菜单-非高新-后台-监理评审*/
	public static final String TSUPERVISOR_ADMIN_OTHER_MENU11="ff808081412ac5e60141446c8e42000b";
	
	/*********************************项目监理-非高新处-项目实施进展情况***************************************************/
	public static final String  TSUPERVISOR_OTHER_SCHEDULE_TYPE = "402881f240c3dfd70140c3e19f790000";
	
	/**按计划*/
	public static final String  TSUPERVISOR_OTHER_SCHEDULE_1 = "402881f240c3dfd70140c3e4bc690002";
	/**进度超前*/
	public static final String  TSUPERVISOR_OTHER_SCHEDULE_2 = "402881f240c3dfd70140c3e50aa80003";
	/**滞后*/
	public static final String  TSUPERVISOR_OTHER_SCHEDULE_3 = "402881f240c3dfd70140c3e545ec0004";
	/**申请延期*/
	public static final String  TSUPERVISOR_OTHER_SCHEDULE_4 = "402881f240c3dfd70140c3e57c2f0005";
	/**无法完成*/
	public static final String  TSUPERVISOR_OTHER_SCHEDULE_5 = "402881f240c3dfd70140c3e5b6880006";
	
	/****************************************项目监理-非高新处-项目未按计划进行的原因**************************************/
	public static final String  TSUPERVISOR_OTHER_STOP_REASON = "402881f240c3dfd70140c3e2f6200001";
	
	/**技术变化*/
	public static final String  TSUPERVISOR_OTHER_STOP_REASON_1 = "402881f240c3dfd70140c3e7ba180007";
	/**市场变化*/
	public static final String  TSUPERVISOR_OTHER_STOP_REASON_2 = "402881f240c3dfd70140c3e7f5ca0008";
	/**经费不到位*/
	public static final String  TSUPERVISOR_OTHER_STOP_REASON_3 = "402881f240c3dfd70140c3e82f1a0009";
	/**项目或技术骨干变动*/
	public static final String  TSUPERVISOR_OTHER_STOP_REASON_4 = "402881f240c3dfd70140c3e86a5d000a";
	/**计划性调整*/
	public static final String  TSUPERVISOR_OTHER_STOP_REASON_5 = "402881f240c3dfd70140c3e8a1d9000b";
	/**设备、材料不落实*/
	public static final String  TSUPERVISOR_OTHER_STOP_REASON_6 = "402881f240c3dfd70140c3e8dea3000c";
	/**协作关系影响*/
	public static final String  TSUPERVISOR_OTHER_STOP_REASON_7 = "402881f240c3dfd70140c3e91cb6000d";
	/**其它*/
	public static final String  TSUPERVISOR_OTHER_STOP_REASON_8 = "402881f240c3dfd70140c3e956f0000e";
	
	/** 统计菜单 */
	/** 类型 */
	public static final String STATISTICS_TYPE= "402882a240a46ac20140a46e8cac0000"; 
	/** 项目结果汇总 */
	public static final String STATISTICS_PROJECT_RESULT_COLLECT = "402882a240a46ac20140a47244c30001";
	
	
	/**PDF相关常量*/
	/**PDF-模板路径*/
	public static final String PDF_TEMPLATE_PATH="402882433e78fb36013e79cd08490004";

	/**PDF-存储路径*/
	/**PDF-存储路径*/
	public static final String PDF_STORAGE_PATH="402882433e78fb36013e79cd5deb0005";

	/**附件上传路径 */
	public static final String FILE_UPLOAD_PATH="402882433e78fb36013e79c9be1f0001";

	/**上传附件大小限制 */
	public static final String FILE_UPLOAD_SIZE="402882433e78fb36013e79ca66460002";
	
	/**上传附件类型限制 */
	public static final String FILE_UPLOAD_TYPE="402882433e78fb36013e79cc6f740003";
	
	/** 评审意见表下载路径 */
	public static final String WORD_DOWNLOAD_PATH="402882433e78fb36013e79cd5deb0004";
	
	/** 评审意见表名称 */
	public static final String WORD_DOWNLOAD_NAME="评审意见表.doc";
	
	/** 专家评审统计 */
	public static final String EXPERT_STATISTIC_NAME="专家评审统计";
	
	/** 项目评审通过率统计*/
	public static final String PROJECT_PASS_NAME="项目评审通过率统计";
	
	/** 专家意见 */
	public static final String EXPERT_OPINIONS_NAME="专家意见";
	
	/** 分计划管理 */
	public static final String PLAN_DETAIL_NAME="分计划详细";
	
	/**申报年度 */
	public static final String APPLY_YEAR = "402882433e822784013e82eefc280034";
	
	/**申报开始时间 */
	public static final String APPLY_TIME_AREA_BEGIN = "402882433e888bc5013e891b6a7d0003";
	
	/**申报结束时间 */
	public static final String APPLY_TIME_AREA_END = "402882433f230801013f23210a6f0000";
	
	/**企业信息 */
	public static final String SESSION_COMPANYINFO = "companyInfo";
	
	/**系统参数*/
	public static final String SYSTEM_SETTING = "402882433e78fb36013e79c8c9110000";
	
	/**归口部门 */
	public static final String TYPE_CENTRALIZED_TYPE = "402882433e822784013e8228524e0000";
	
	/**单位技术领域  */
	public static final String TYPE_TECHNICAL_FISLD = "402882433e822784013e82c83c6b0013";
	
	/**单位行业领域1 */
	public static final String TYPE_INDUSTRIES1 = "402882433e822784013e82e2f414001c";
	
	/**单位行业领域2 */
	public static final String TYPE_INDUSTRIES2 = "402882433e822784013e82e35f70001d";
	
	/**单位行业领域3 */
	public static final String TYPE_INDUSTRIES3 = "402882433e822784013e82e3b88d001e";
	
	/**单位行业领域4 */
	public static final String TYPE_INDUSTRIES4 = "402882433e822784013e82e3ed29001f";
	
	/**验收状态 */
	public static final String TYPE_ACCEPTANCE_STATUS = "402882433e7da560013e7da6185f0000";	
	/**验收状态-可申请  */
	public static final String ACCEPTANCE_APPLY = "402882433e7da560013e7db327c20001";	
	/**验收状态-填写中 */
	public static final String ACCEPTANCE_WRITE = "402882433e7da560013e7db37fd40002";	
	/**验收状态-已申请 */
	public static final String ACCEPTANCE_APPLIED = "402882433e7da560013e7db3f8dd0003";	
	/**验收状态-评审中 */
	public static final String ACCEPTANCE_REVIEW = "402882433e7da560013e7db44e7f0004";	
	/**验收状态-验收不合格 */
	public static final String ACCEPTANCE_NOPASS = "402882433e7da560013e7db499910005";
	/**验收状态-验收合格*/
	public static final String ACCEPTANCE_PASS = "402882433e7da560013e7db4ca080006";	
	/**验收状态-验收基本合格*/
	public static final String ACCEPTANCE_BASIC_PASS = "402882433e7da560013e7db511520007";
	/**验收状态-结题*/
	public static final String ACCEPTANCE_END = "402882433ea0be1a013ea0f438620000";
	
	/**分计划状态*/
	public static final String TYPE_PLAN_STATUS = "40288125412a8a7801412a8c40ee0000";
	/**分计划状态-分计划作成中*/
	public static final String PLAN_APPLY = "40288125412a8a7801412a8cf46f0001";
	/**分计划状态-分计划已提交*/
	public static final String PLAN_APPLIED = "40288125412a8a7801412a8d2b100002";
	/**分计划状态-分计划汇总中*/
	public static final String PLAN_TOGETHER = "40288125412a8a7801412a8d51350003";
	/**分计划状态-分计划汇总完成*/
	public static final String PLAN_FINISH = "40288125412a8a7801412a8d7d270004";
	/**分计划状态-分计划已下发*/
	public static final String PLAN_ISSUED = "40288125412a8a7801412a8e0e1d0005";
	
	/**计划批次*/
	public static final String TYPE_PLANBATCH_STATUS = "40288125412a9a0401412a9b34df0000";
	/**计划批次-第一批次*/
	public static final String PLANBATCH_FIRST = "40288125412a9a0401412ac7abde0001";
	/**计划批次-第二批次*/
	public static final String PLANBATCH_SECOND = "40288125412a9a0401412ac7d9570002";
	/**计划批次-第三批次*/
	public static final String PLANBATCH_THIRD= "40288125412a9a0401412ac8049d0003";
	
	/** 分计划选择状态 */
	public static final String TYPE_PLANSELECT_STATUS = "402881d341c458490141c45b0d2c0000";
	/** 拟立项 */
	public static final String PLANSELECT_1 = "402881d341c458490141c45b7cfd0001";
	/** 备选 */
	public static final String PLANSELECT_2 = "402881d341c458490141c45be22f0002";
	/** 落选 */
	public static final String PLANSELECT_3 = "402881d341c458490141c45c389c0003";
	
	
	/** 推荐意见 */
	public static final String COMPANY_RECOMMENDATION = "402809814125e7a2014125ec2df70000";
	/** 推荐意见-推荐 */
	public static final String RECOMMENDATION_RECOMMEND = "402809814125f322014125f5287a0000";
	/** 推荐意见-备选 */
	public static final String RECOMMENDATION_ALTERNATIVE = "402809814125f322014125f585ff0001";
	/** 推荐意见-落选 */
	public static final String RECOMMENDATION_FAIL = "402809814125f322014125f5bb620002";
	
	/** 局办公会意见 */
	public static final String OFFICE_TYPE = "402886d3427adf1801427ae0a7040000";
	/** 局办公会意见-通过 */
	public static final String OFFICE_PASS = "402886d3427adf1801427ae209630001";
	/** 局办公会意见-不通过 */
	public static final String OFFICE_NOPASS = "402886d3427adf1801427ae2899f0002";
	
	
	// 项目执行情况监理表（画面）---START---
	/**项目所属领域 */
	public static final String  TYPE_PROJECT_FIELD = "402882433e7da560013e7dbe3d290008";
	
	/**计算机软件 */
	public static final String  PROJECT_FIELD_1 = "402882433e7da560013e7dbfa61f0009";
	/**机电一体化 */
	public static final String  PROJECT_FIELD_2 = "402882433e7da560013e7dbfd77f000a";
	/**生物医药*/
	public static final String  PROJECT_FIELD_3 = "402882433e7da560013e7dc00f58000b";
	/**新材料*/
	public static final String  PROJECT_FIELD_4 = "402882433e7da560013e7dc0452e000c";
	/**集成电路*/
	public static final String  PROJECT_FIELD_5 = "402882433e7da560013e7dc06b53000d";
	/**光电子*/
	public static final String  PROJECT_FIELD_6 = "402882433e7da560013e7dc0a7ef000e";
	/**其它*/
	public static final String  PROJECT_FIELD_7 = "402882433e7da560013e7dc0d21c000f";
	
	/**学历 */
	public static final String  TYPE_PROJECT_PERSON_EDUCATION = "402882433e7df0e1013e7df1fe1f0000";
	
	/**博士*/
	public static final String  PROJECT_PERSON_EDUCATION_1 = "402882433e7df2bc013e7df411ad0000";
	/**硕士*/
	public static final String  PROJECT_PERSON_EDUCATION_2 = "402882433e7df2bc013e7df430600001";
	/**本科*/
	public static final String  PROJECT_PERSON_EDUCATION_3 = "402882433e7df2bc013e7df453f60002";
	/**其它*/
	public static final String  PROJECT_PERSON_EDUCATION_4 = "402882433e7df2bc013e7df478850003";
	
	/**项目实施进展情况*/
	public static final String  TYPE_PROJECT_SCHEDULE = "402882433e7df2bc013e7df5131f0004";
	
	/**按计划进行*/
	public static final String  PROJECT_SCHEDULE_1 = "402882433e7df2bc013e7df5a6470005";
	/**进度超前*/
	public static final String  PROJECT_SCHEDULE_2 = "402882433e7df2bc013e7df5d0640006";
	/**拖延*/
	public static final String  PROJECT_SCHEDULE_3 = "402882433e7df2bc013e7df6acca0007";
	/**停顿*/
	public static final String  PROJECT_SCHEDULE_4 = "402882433e7df2bc013e7df6d3fa0008";
	/**申请撤销*/
	public static final String  PROJECT_SCHEDULE_5 = "402882433e7df2bc013e7df6f4820009";
	
	/**项目未按计划进行的原因*/
	public static final String  TYPE_PROJECT_STOP_REASON = "402882433e7df2bc013e7df73a64000a";
	
	/**计划性调整*/
	public static final String  PROJECT_STOP_REASON_1 = "402882433e7df2bc013e7df9c4c8000b";
	/**设备、材料不落实*/
	public static final String  PROJECT_STOP_REASON_2 = "402882433e7df2bc013e7df9e773000c";
	/**协作关系影响*/
	public static final String  PROJECT_STOP_REASON_3 = "402882433e7df2bc013e7dfa3c3a000d";
	/**资金不到位*/
	public static final String  PROJECT_STOP_REASON_4 = "402882433e7df2bc013e7dfa6137000e";
	/**市场变化*/
	public static final String  PROJECT_STOP_REASON_5 = "402882433e7df2bc013e7dfa820d000f";
	/**技术骨干变化*/
	public static final String  PROJECT_STOP_REASON_6 = "402882433e7df2bc013e7dfaa69d0010";
	/**立题不当*/
	public static final String  PROJECT_STOP_REASON_7 = "402882433e7df2bc013e7dfae8c60011";
	/**其它*/
	public static final String  PROJECT_STOP_REASON_8 = "402882433e7df2bc013e7dfb10050012";
	
	/**职称 */
	public static final String  TYPE_PROJECT_PERSON_TITLE = "402882433e7df2bc013e7dfe55ca0013";
	
	/**教授*/
	public static final String  PROJECT_PERSON_TITLE_1 = "402882433e7df2bc013e7dfee79a0014";
	/**副教授*/
	public static final String  PROJECT_PERSON_TITLE_2 = "402882433e7df2bc013e7dff0c390015";
	/**工程师/讲师*/
	public static final String  PROJECT_PERSON_TITLE_3 = "402882433e7df2bc013e7dff2e290016";
	/**助工/助教*/
	public static final String  PROJECT_PERSON_TITLE_4 = "402882433e7df2bc013e7dff4eef0017";
	/**其它*/
	public static final String  PROJECT_PERSON_TITLE_5 = "402882433e7df2bc013e7dff72f20018";
	
	/**情报信息存在区分  1：存在 0：不存在*/
	public static final String SUPERVISOR_INFO_EXIST = "1";
	public static final String SUPERVISOR_INFO_UNEXIST = "0";
	/** 是否已最终申请 1：是 0：不是   */
	public static final String IS_LAST_APPLY_YES = "1";
	public static final String IS_LAST_APPLY_NO = "0";
	// 项目执行情况监理表（画面）---END---
	
	// 后台跳转状态
	
	/**待办事项（业务处）*/
	public static final String JUMP_FLG_0 = "0";
	/**项目初审*/
	public static final String JUMP_FLG_1 = "1";
	/**项目审核*/
	public static final String JUMP_FLG_2 = "2";
	/**处长审核*/
	public static final String JUMP_FLG_3 = "3";
	/**联席会审核*/
	public static final String JUMP_FLG_4 = "4";
	/**分计划管理*/
	public static final String JUMP_FLG_5 = "5";
	/**合同管理*/
	public static final String JUMP_FLG_6 = "6";
	/**项目监理*/
	public static final String JUMP_FLG_7 = "7";
	/**项目验收*/
	public static final String JUMP_FLG_8 = "8";
	
	/**待办事项（计划处）*/
	public static final String JUMP_FLG_9 = "9";
	/**项目调配*/
	public static final String JUMP_FLG_10 = "10";
	/**分计划查看*/
	public static final String JUMP_FLG_11 = "11";
	/**计划汇总*/
	public static final String JUMP_FLG_12 = "12";
	/**分计划下发*/
	public static final String JUMP_FLG_13 = "13";
	/**归档管理*/
	public static final String JUMP_FLG_14 = "14";
	/**专家库管理*/
	public static final String JUMP_FLG_15 = "15";
	/**申报单位管理*/
	public static final String JUMP_FLG_16 = "16";
	/**查询*/
	public static final String JUMP_FLG_17 = "17";
	/**统计*/
	public static final String JUMP_FLG_18 = "18";
	/**模板配置*/
	public static final String JUMP_FLG_19 = "19";
	/**基础数据配置*/
	public static final String JUMP_FLG_20 = "20";
	/**项目撤销*/
	public static final String JUMP_FLG_21 = "21";
	/**专家评审管理*/
	public static final String JUMP_FLG_28 = "28";
	/**专家信息维护*/
	public static final String JUMP_FLG_29 = "29";
	/**专家库管理*/
	public static final String JUMP_FLG_30 = "30";
	/**立项建议*/
	public static final String JUMP_FLG_31 = "31";
	/**局办公会意见*/
	public static final String JUMP_FLG_32 = "32";

	
	/**地址（省） */
	public static final String TYPE_REGION_1 = "402882433e888bc5013e88ac7cc80000";
	/**地址（市） */
	public static final String TYPE_REGION_2 = "402882433e888bc5013e88acdb530001";
	/**地址（区县） */
	public static final String TYPE_REGION_3 = "402882433e888bc5013e88ad33180002";
	/**陕西省 */
	public static final String SHANNXI = "00003716";
	/**西安市 */
	public static final String XIAN = "00003717";
	/**支持方式 */
	public static final String SUPPORT_FUNCTION = "402882433e888bc5013e892234190004";
	/**无偿资助*/
	public static final String SUPPORT_FUNCTION_1 = "402882433e888bc5013e8922dda70005";
	/**贷款贴息*/
	public static final String SUPPORT_FUNCTION_2 = "402882433e888bc5013e8923042a0006";
	/**股权投入*/
	public static final String SUPPORT_FUNCTION_3 = "402882433e888bc5013e89232a120007";
	
	/**项目申报计划类别*/
	public static final String TYPE_PLANFLAG_TYPE = "402882433e9266e0013e92729da50000";
	/**系统名称（西安市高新技术产业发展领导小组办公室编制）*/
	public static final String PROJECT_REPORT_TEXT ="402882433eb0f5be013eb0f807780000";
	/**系统日期（ 二〇一〇年十一月）*/
	public static final String PROJECT_REPORT_TIME = "402882433eb0f5be013eb0f86b240001";
	//项目基本信息
	/**项目基本信息-项目所属技术领域 */
	public static final String  TYPE_PROJECTINFO_FIELD = "ff8080813ef2f4e5013ef3bcc7990001";
	/**项目基本信息-项目所属技术领域 1*/
	public static final String  TYPE_PROJECTINFO_FIELD1 = "402882a24196973c014196eab8bd0000";
	/**项目基本信息-项目所属技术领域2 */
	public static final String  TYPE_PROJECTINFO_FIELD2 = "402882a24196973c014196eadde90001";
	/**项目基本信息-项目所属技术领域 3*/
	public static final String  TYPE_PROJECTINFO_FIELD3 = "402882a24196973c014196eb021b0002";
	/**项目基本信息-项目所属技术领域 -新一代信息技术*/
	public static final String PROJECTINFO_FIELD_1="ff8080813ef2f4e5013ef3bdb6ac0002";
	/**项目基本信息-项目所属技术领域 -新能源*/
	public static final String PROJECTINFO_FIELD_2="ff8080813ef2f4e5013ef3be09700003";
	/**项目基本信息-项目所属技术领域 -新材料*/
	public static final String PROJECTINFO_FIELD_3="402882433ef3ee03013ef3f833670000";
	/**项目基本信息-项目所属技术领域 -高端装备制造*/
	public static final String PROJECTINFO_FIELD_4="402882433ef3ee03013ef3fac29d0001";
	/**项目基本信息-项目所属技术领域 -生物医药*/
	public static final String PROJECTINFO_FIELD_5="402882433ef41493013ef41bf19c0000";
	/**项目基本信息-项目所属技术领域 -节能与环保*/
	public static final String PROJECTINFO_FIELD_6="402882433ef41d38013ef41e526f0000";
	/**项目基本信息-项目所属技术领域 -其他*/
	public static final String PROJECTINFO_FIELD_7="402882433ef41d38013ef41f1d700001";
	
	/**部门划分 */
	public static final String  TYPE_DEPARTMENT = "402882434052a69c014052a9278c0000";
	
	/**委 托 单 位 （甲方）*/
	public static final String ENTRUSTMENT_COMPANY = "402882433ef430a1013ef436d8c10000";
	
	/**单位性质*/
	public static final String TYPE_COMPANY_RETY = "ff8080813ef815a5013ef915a3790003";
	/**知识产权*/
	public static final String TYPE_INTELLECTUAL = "402882433f1dbf25013f1dc011ad0000";
	/**技术来源*/
	public static final String TYPE_TECHNOLOGY = "402882433f1dbf25013f1dc068b60001";
	/**项目初审-等待调配*/
	public static final String PROJECTAPPLICATION_APPLYSTATE="等待调配";
	/**项目归档*/
	public static final String PROJECTAPPLICATION_FLOWSTATUS="处长审核不通过";
	/**联系会审核阶段*/
	public static final String PLAN_BUSINESSAPPOVE_STATE="联席会审核不通过";
	/**分计划审核中*/
	public static final String PLAN_SUBPLANSTATE="分计划计划处审核中";
	/**项目归档阶段状态*/
	public static final String TACCEPTANCE_END="结题";
	public static final String TACCEPTANCE_TACCEPTANCEGOOD="验收基本合格";
	public static final String TACCEPTANCE_GOOD="验收合格";
	/**消息未读*/
	public static final Boolean RECEIVERMESSAGE_NOTREAD=false;
	/**消息只读*/
	public static final Boolean RECEIVERMESSAGE_READ=true;
	/**项目初审*/
	public static final String  BUSINSESSPROJECTFIRSTCHECK_STATE="初审中";
	/**项目审核中*/
	public static final String  BUSINESSPROJECTWATINGCHECK_STATE="初审通过";
	/**待处长待审核*/
	public static final String  BUSINESSPROJECTCHUZHANGCHECK_STATE="审核通过";
	/**待合同审核项目*/
	public static final  String  WAITTINGCHECKCONSTRUTCT_STATE="已提交";
	/**待监理项目*/
	public static final  String  WAITINGPROJECT_JIANLI_STATE="已申请监理审核";
	
	/**待验收项目*/
	public static final  String WAITINGPROJECT_CHECK_STATE="402882433e7da560013e7db3f8dd0003";
	
	/**显示类型*/
	public static final  String PROJECT_VIEW_TYPE_STATE="4028812541b9f6360141b9f853620000";
	/**柱图*/
	public static final  String PROJECT_ZVIEW_TYPE_STATE="4028812541b9f6360141b9f961860001";
	/**饼图*/
	public static final  String PROJECT_BVIEW_TYPE_STATE="4028812541b9f6360141b9f9999d0002";
	
	/***********专家库***********/
	/**学历*/
	public static final String SCHOOLING_TYPE="402882433e7df0e1013e7df1fe1f0000";
	/**性别*/
	public static final String SEX_TYPE="485f1f09fc734b39bc32b0ae111737e0";
	/**学位*/
	public static final String EXPERTDEGREE_TYPE="485f1f09fc764b39bc32b0ae111737e0";
	/** 专家职务 */
	public static final String EXPERTJOB_TYPE="485f1f09fc764b39bc32b0ae111737f0";
	
	/** 专家职称 */
	public static final String SKILLJOB_TYPE="485f1f09fc764b39bc32b0ae111737f9";
	
	/**正高*/
	public static final String SKILLJOB_PROFESSOR="385f1f09fc764b39bc32b0ae111737f9";
	/**擅长专业1*/
	public static final String EXPERTMAJOR1_TYPE="114ba481bd694f4bb2c786f4f64b99c6";
	/**擅长专业2*/
	// 585f1f09fc764b39bc32b0ae111737f9
	public static final String EXPERTMAJOR2_TYPE="114ba481bd694f4bb2c786f4f64b99c6";
	/**擅长专业3*/
	// 402881f24148a50a014148a986f70000
	public static final String EXPERTMAJOR3_TYPE="114ba481bd694f4bb2c786f4f64b99c6";
	/** 单位性质*/
	public static final String DEPTTYPE_TYPE="685f1f09fc764b39bc32b0ae111837f9";
	/** 在职状态*/
	public static final String EXPERTINCUMBENCY_TYPE="685f1f09fc764b39bc32b0ae11183769";
	/**在职*/
	public static final String EXPERTINCUMBENCY_1="在职";
	/**离职*/
	public static final String EXPERTINCUMBENCY_0="离职";
	/**信誉等级*/
	public static final String EXPERTPRESTIGE_TYPE="e9876de3663c4d8cbbf2f0aa20f6dcba";
	/**专家类型**/
	public static final String EXPERT_TYPE = "402881f241e835200141e85c3eac0003"; 
	/**专家类型--技术专家**/
	public static final String EXPERT_TYPE1 = "402881f241e835200141e85d06130004";
	/**专家类型--投资专家**/
	public static final String EXPERT_TYPE2 = "402881f241e835200141e85d4adc0005";
	/**出生年份*/
	public static final String BIRTHDAY_YEAR="402881d34114ff560141150185040000";
	
	/**专家职务**/
	public static final String EXPERT_JOB_TYPE = "402886d34279b068014279b1b3c70000"; 
	/**专家职务--有职务**/
	public static final String EXPERT_JOB_TYPE1 = "402886d34279b068014279b2928f0001";
	/**专家职务--无职务**/
	public static final String EXPERT_JOB_TYPE2 = "402886d34279b068014279b2dfd40002";
	
	/** 部门 */
	/** 计财处 */
	public static final String PLANNING_DEPARTMENT = "402882a24057a77a014057b072f10000";
	/** 高新处 */
	public static final String HIGHTECH_DEPARTMENT = "402880e53ce79923013ceacdbc090019";
	
	/** 后台统计页面模板文件名 */
	public static final String DATA_COUNT_MODEL_FILENAME = "DataCountModel.xls";
	/** 后台拨款单统计页面模板文件名 */
	public static final String DATA_COUNT_MODEL_FUNDS = "fundsDataCountModel.xls";
	/** 后台专家评审统计页面模板文件名 */
	public static final String EXPERT_STATISTIC_FILENAME = "expertStatisticModel.xls";
	/** 项目评审通过率统计页面模板文件名*/
	public static final String REPORT_PASS_FILENAME = "reportPassModel.xls";
	/** 后台计划汇总模板文件名 */
	public static final String EXPERT_PLAN_COLLECT_FILENAME = "PlanCollectModel.xls";
	/** 专家意见模板文件名 */
	public static final String EXPERT_OPINIONS_FILENAME= "expertOpinionsModel.xls";
	/** 专家评审意见模板-技术专家 */
	public static final String EXPERT_REVIEW_FILENAME= "ExpertReviewComments.xls";
	/** 专家评审意见模板-投资专家 */
	public static final String EXPERT_REVIEW_FILENAME_T= "ExpertReviewCommentsT.xls";
	/**下载压缩文件的时候看到的专家签到表的excel名字*/
	public static final String EXPERT_IN_TABLE= "ExpertsInTable.xls";
	/**下载压缩文件的时候看到的费用领取表的excel名字*/
	public static final String FEES_WILL_RECEIVE= "FeesWillReceive.xls";
	/**下载压缩文件的时候看到的技术专家的excel名字*/
	public static final String TECHNICAL_EXPER_NAME= "TechnicalExpertMarkSheet.xls";
	/**下载压缩文件的时候看到的投资专家的excel名字*/
	public static final String INVESTMENT_EXPER_NAME= "InvestmentExpertMarkSheet.xls";
	/** 专家签到模板 */
	public static final String EXPERT_FILENAME= "expertScore.xls";
	/** 费用领取表模板 */
	public static final String FEECOLLECTION_FILENAME= "feeCollection.xls";
	/** 分计划详细模板文件名 */
	public static final String PLAN_DETAIL_FILENAME="planDetailModel.xls";
	
	/**发送email配置*/
	/**发送email-url*/
	public static final String SEND_EMAIL_URL = "http://mcenter.xatrm.com/server_mcenter/receive/email_send.jsp";
	/**发送email-contractCode*/
	public static final String SEND_EMAIL_CONTRACTCODE = "xmsb_email";
	/**发送email-userName*/
	public static final String SEND_EMAIL_USERNAME = "xmkxmsb";
	/**发送email-passWord*/
	public static final String SEND_EMAIL_PASSWORD = "ldsk^_^l4ewr";
	
	/**发送短信配置*/
	/**发送短信-url*/
	public static final String SEND_SMS_URL = "http://mcenter.xatrm.com/server_mcenter/receive/sms_send.jsp";
	/**发送短信-contractCode*/
	public static final String SEND_SMS_CONTRACTCODE = "xmsb_sms";
	/**发送短信-userName*/
	public static final String SEND_SMS_USERNAME = "xmkxmsb";
	/**发送短信-passWord*/
	public static final String SEND_SMS_PASSWORD = "ldsk^_^l4ewr";
	
	/********************************项目履历类型*********************************************************/
	/**项目申报 */
	public static final Integer PROJECT_RECORD_TYPE1 = 1;
	
	/**项目合同*/
	public static final Integer PROJECT_RECORD_TYPE2 = 2;
	
	/**项目监理 */
	public static final Integer PROJECT_RECORD_TYPE3 = 3;
	
	/**项目验收*/
	public static final Integer PROJECT_RECORD_TYPE4 = 4;
	
	/********************************项目履历操作者类型*********************************************************/
	
	/**企业 */
	public static final Integer PROJECT_RECORD_USER_TYPE1 = 1;
	
	/**处室管理员*/
	public static final Integer PROJECT_RECORD_USER_TYPE2 = 2;
	
	
	//============项目申报履历表  操作类型 START===============
	/**企业用户提交监理申请*/
	public static final String PROJECT_RECORD_COMPANY_COMIT_APPLY = "企业用户提交监理申请";
	
	/**处室监理审批*/
	public static final String PROJECT_RECORD_SUPERVISOR_AUDIT = "监理申请审批";
	//============项目申报履历表  操作类型 END===============
	
	/**执行期跨度*/
	public static final String TYPE_TIME_AREA = "402882434187c387014187e4d6fd0000";
	
	/** 产业处合同类型  无偿资助 */
	public static final String CONTRACT_TYPE_FREE = "0";
	
	/** 产业处合同类型  贷款贴息 */
	public static final String CONTRACT_TYPE_CREDIT = "1";
	
	/**合同封皮备注：西安市科学技术局制*/
	public static final String CONTRACT_COMMENT = "ff8080813f7a54e2013f7fa6de950001";
	/** 专家评估模板*//*
	public static final String EXPER_COMMENT = "402881254207408a01420741907f0000";
	*//** 技术专家模板*//*
	public static final String EXPER_TECHNICION_COMMENT = "402881254207408a0142074241ed0001";
	*//** 投资专家模板*//*
	public static final String EXPER_INVEST_COMMENT = "402881254207408a01420742909a0002";
	*/
	/******************特殊页大小********************************/
	public static final Integer PAGE_SIZE = 30;
	
}
