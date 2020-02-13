package spring_mvn.dao;

import java.util.List;

import spring_mvn.model.User;

public interface UserDao {

	void add(User user);

	List<User> listUsers();
}
