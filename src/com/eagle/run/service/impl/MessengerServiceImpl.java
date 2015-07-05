package com.eagle.run.service.impl;

import java.util.List;

import com.eagle.run.common.bean.Memberinfo;
import com.eagle.run.common.bean.Messagerecord;
import com.eagle.run.common.exception.MessengerServiceException;
import com.eagle.run.service.IMessengerService;

public class MessengerServiceImpl implements IMessengerService{

	public Integer findNewMessageNum(String nickname)
			throws MessengerServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public Memberinfo findOneMemberinfo() throws MessengerServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Memberinfo> findFriends(String age, String gender, String city)
			throws MessengerServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveMessage(Messagerecord message)
			throws MessengerServiceException {
		// TODO Auto-generated method stub
		
	}

	public List<Messagerecord> listSendMessage(String senderName)
			throws MessengerServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Messagerecord> listRecieveMessage(String recieveName)
			throws MessengerServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public Messagerecord findMessage(Long id) throws MessengerServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public void delRecieveMessage(Long id) throws MessengerServiceException {
		// TODO Auto-generated method stub
		
	}

	public void delSendMessage(Long id) throws MessengerServiceException {
		// TODO Auto-generated method stub
		
	}

}
