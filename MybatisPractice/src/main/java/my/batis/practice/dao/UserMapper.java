package my.batis.practice.dao;

import my.batis.practice.vo.User;

public interface UserMapper {

	public int insertUser(User user);
	public User selectUser(User user);
	public int deleteUser(String id);
	public int updateUser(User user);
}
