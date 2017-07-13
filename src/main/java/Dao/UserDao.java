package Dao;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import Entity.User;


public interface UserDao {
	
	int addUser(User user);

	User queryUser(@Param("username") String username);
    
	int changePassword(User user);	
	
	User queryById(@Param("id") int id);
	
	
}
