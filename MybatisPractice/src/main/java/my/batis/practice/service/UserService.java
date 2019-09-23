package my.batis.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.batis.practice.dao.UserDAO;
import my.batis.practice.vo.User;

@Service
public class UserService {
	@Autowired
	UserDAO dao;
	
	public int insertUser(User user){
		return dao.insertUser(user);
	}
	
	public User selectUser(User user){
		return dao.selectUser(user);
	}
				
	public int deleteUser(String id){
		return dao.deleteUser(id);
	}
	
	public int updateUser(User user){
		int result = dao.updateUser(user);
		return result;
	}
	
}
