package eCommerceDemo.dataAccess.abstracts;

import java.util.List;

import eCommerceDemo.entites.concretes.User;


public interface UserDao {
	void add(User user);
	void delete(User user);
	void update(User user);
	User get(int id);
	List<String> getAll();// Bu List interface C# da IList 
	//List<User> getAll(); veritabanýna baþlanmadýðý için iptal ettim. Saat 01:18 kafam yandý resmen. 
}
