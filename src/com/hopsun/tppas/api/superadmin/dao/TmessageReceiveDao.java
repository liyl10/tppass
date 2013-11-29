package com.hopsun.tppas.api.superadmin.dao;

import java.util.List;

import com.hopsun.tppas.entity.TmessageReceive;
import com.hopsun.framework.base.dao.BaseDao;
/**
 * @Comments:   后台Dao接口-主要用来定义消息接收的接口
 * @author  yk
 * @date 2013-08-04
 * @version 1.0
 *
 */
public interface TmessageReceiveDao extends BaseDao<TmessageReceive, String>{
	/**
	 * 查询消息接收信息
	 * @param recevierId
	 * @return
	 */
	public List<TmessageReceive>  queryTMessageReceiverByReceiverId(String recevierId);
	
	
}
