package controllers;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Service;


import hibernate.User;
import hibernate.Pics;
import util.HibernateUtil;

@Service
@Transactional
public class HibernateManager {
	public void save(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}
	
	public void savePic(Pics pictures) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(pictures);
		session.getTransaction().commit();
		session.close();

	}

}
