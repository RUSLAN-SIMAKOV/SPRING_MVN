package spring_mvn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_mvn.dao.UserDao;
import spring_mvn.model.User;
import spring_mvn.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public void add(User user) {
		userDao.add(user);
	}

	@Override
	public User getUser(Long id) {
		return userDao.getUser(id);
	}

	public List<User> listUsers() {
		return userDao.listUsers();
	}
}
