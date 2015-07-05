package com.eagle.run.dao.impl;

import java.util.List;

import com.eagle.run.common.bean.Memberinfo;
import com.eagle.run.common.bean.Messagerecord;
import com.eagle.run.common.exception.DataAccessException;
import com.eagle.run.dao.IMessengerDao;

public class MessengerDaoImpl implements IMessengerDao{

	public Integer findNewMessageNum(String nickname)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer findMemberinfoNum() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public Memberinfo findOneMemberinfo(int sum) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public List findFriends(String age, String gender, String city)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveMessage(Messagerecord message) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	public List<Messagerecord> listSendMessage(String senderName)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Messagerecord> listRecieveMessage(String recieveName)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public Messagerecord findMessage(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteRecieveMessage(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	public void deleteSendMessage(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
