package spring_mvn.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring_mvn.dao.UserDao;
import spring_mvn.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(User user) {
		sessionFactory.openSession().save(user);
	}

	@Override
	public User getUser(Long id) {
		return sessionFactory.openSession().get(User.class, id);
	}

	@Override
	public List<User> listUsers() {
		TypedQuery<User> q = sessionFactory.openSession().createQuery("from User", User.class);
		return q.getResultList();
	}
}
