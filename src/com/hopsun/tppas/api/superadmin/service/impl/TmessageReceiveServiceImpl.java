package com.hopsun.tppas.api.superadmin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hopsun.framework.base.service.impl.BaseServiceImpl;
import com.hopsun.tppas.api.superadmin.dao.TmessageReceiveDao;
import com.hopsun.tppas.api.superadmin.service.TmessageReceiveService;
import com.hopsun.tppas.common.Constants;
import com.hopsun.tppas.entity.TmessageReceive;
/**
 * @Comments:   后台Service接口-主要用来实现消息接收的接口
 * @author  yk
 * @date 2013-08-04
 * @version 1.0
 *
 */
@Service
public class TmessageReceiveServiceImpl extends BaseServiceImpl<TmessageReceive,String> implements TmessageReceiveService{
	
	@Resource
	private TmessageReceiveDao tmessageReceiveDao;
	
	@Resource
	public void setBaseDao(TmessageReceiveDao tmessageReceiveDao) {
		super.setBaseDao(tmessageReceiveDao);
	}

	/**
	 * 查询消息接收信息
	 * @param recevierId
	 * @return
	 */
	@Override
	public List<TmessageReceive> queryTMessageReceiverByReceiverId(
			String recevierId) {
		/**
		 * 查询待接收的消息
		 */
		List<TmessageReceive> listResult=tmessageReceiveDao.queryTMessageReceiverByReceiverId(recevierId);
		/**
		 * 修改消息状态
		 */
		if(listResult!=null&&!listResult.isEmpty()){
			for(TmessageReceive tmessageReceiver : listResult){
				if(tmessageReceiver!=null){
					tmessageReceiver.setIsRead(Constants.RECEIVERMESSAGE_READ);
					tmessageReceiveDao.update(tmessageReceiver);
				
				}
				
			}
		}
		
		return listResult;
	}
	
	
}
