package my.batis.practice.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import my.batis.practice.vo.User;

@Repository
public class UserDAO {

	@Autowired
	SqlSession session;
	
	
	public int insertUser(User user){
		int result = 0;
		try{
			UserMapper mapper = session.getMapper(UserMapper.class);
			result = mapper.insertUser(user);
		}catch(Exception e ){
			e.printStackTrace();
			return result;
		}		
		return result;
	}
	
	public User selectUser(User user){
		User result = null;
		try{
		UserMapper mapper = session.getMapper(UserMapper.class);
		result = mapper.selectUser(user); 
		}catch(Exception e){
			e.printStackTrace();
			return result;
		}
		System.out.println(user);
		return result;
	}
	

	public int deleteUser(String id){
		int result=0;
		try{
		UserMapper mapper = session.getMapper(UserMapper.class);
		result = mapper.deleteUser(id); 
		}catch(Exception e){
			e.printStackTrace();
			return result;
		}
		return result;
	}

	public int updateUser(User user) {
		int result=0;
		try{
		UserMapper mapper = session.getMapper(UserMapper.class);
		result = mapper.updateUser(user); 
		}catch(Exception e){
			e.printStackTrace();
			return result;
		}
		return result;
	}
}
