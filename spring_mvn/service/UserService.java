package spring_mvn.service;

import java.util.List;

import spring_mvn.model.User;

public interface UserService {

	void add(User user);

	List<User> listUsers();
}
