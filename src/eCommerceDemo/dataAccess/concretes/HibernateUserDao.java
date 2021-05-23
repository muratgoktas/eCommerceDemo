package eCommerceDemo.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.entites.concretes.User;

public class HibernateUserDao implements UserDao {

	@Override
	public void add(User user) {
		System.out.println(user.getFullName()+" User added into HibernateDao");
		
	}

	@Override
	public void delete(User user) {
		System.out.println(user.getFullName()+" User deleted into HibernateDao");
		
	}

	@Override
	public void update(User user) {
		System.out.println(user.getFullName()+" User update into HibernateDao");
		
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAll() {
		List<String> values=new ArrayList<String>();
		values.add("huseyingoktas@biryetmez.com");
		values.add("H456ertZ@");
		
		return null;
	}

}
