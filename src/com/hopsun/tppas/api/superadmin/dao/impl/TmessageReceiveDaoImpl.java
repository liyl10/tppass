package com.hopsun.tppas.api.superadmin.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hopsun.framework.base.dao.impl.BaseDaoImpl;
import com.hopsun.tppas.api.superadmin.dao.TmessageReceiveDao;
import com.hopsun.tppas.entity.TmessageReceive;
/**
 * @Comments:   后台Dao接口-主要用来实现消息接收的接口
 * @author  yk
 * @date 2013-08-04
 * @version 1.0
 *
 */
@Repository
public class TmessageReceiveDaoImpl extends BaseDaoImpl<TmessageReceive, String> implements TmessageReceiveDao {
	/**
	 * 查询消息接收信息
	 * @param recevierId
	 * @return
	 */
	  @Override
	public List<TmessageReceive> queryTMessageReceiverByReceiverId(
			String recevierId) {
		String hql="SELECT messageReceiver FROM TmessageReceive messageReceiver left join fetch messageReceiver.tmessageSend where messageReceiver.receiveUserId=? and messageReceiver.isRead=false ";
		return createQueryList(hql, new String[]{recevierId});
	}
	  
}
