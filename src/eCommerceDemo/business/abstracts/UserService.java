package eCommerceDemo.business.abstracts;

import java.util.List;

import eCommerceDemo.entites.concretes.User;

public interface UserService {

	void add(User user);
	void delete(User user);
	void update(User user);
	List<User> getAll();
	
}
