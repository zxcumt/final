/**
 * 
 */
package Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Dao.UserDao;
import Entity.User;
import Service.UserService;


@Service
public class UserServiceImpl implements UserService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see IService.UserService#registUser(Entity.User)
	 */
	@Autowired
	private UserDao userDao;

	/**
	 * 注册
	 */
	@Override
	@Transactional
	public boolean registUser(User user) {
		// TODO Auto-generated method stub
		int i = userDao.addUser(user);
		return i > 0 ? true : false;
	}

	/*
	 * 查看是否用户名已经被注册
	 * 
	 * @see Service.UserService#queryUserByUsername(java.lang.String)
	 */
	@Override
	public boolean queryUserByUsername(String username) {
		// TODO Auto-generated method stub
		User user = userDao.queryUser(username);
		return user != null ? true : false;
	}

	/*
	 * 登录
	 * 
	 * @see Service.UserService#login(Entity.User)
	 */
	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		User theuser = userDao.queryUser(user.getUsername());
		return theuser!=null&&theuser.getPassword().equals(user.getPassword()) ? true : false;
	}

	/* (non-Javadoc)
	 * @see Service.UserService#changePassword(Entity.User)
	 */
	@Override
	@Transactional
	public boolean changePassword(User user) {
		// TODO Auto-generated method stub
		return 	userDao.changePassword(user)==1?true:false;
	}

}
