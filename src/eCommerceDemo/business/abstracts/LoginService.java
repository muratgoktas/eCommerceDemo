package eCommerceDemo.business.abstracts;

import eCommerceDemo.entites.concretes.User;

public interface LoginService {
	void singIn(User user);
	void singOut(User user);
	
}
