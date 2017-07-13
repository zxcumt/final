/**
 * 
 */
package Service;

import Entity.User;


public interface UserService {
	boolean registUser(User user);
	boolean queryUserByUsername(String username);
	boolean login(User user);
	boolean changePassword(User user);
}
