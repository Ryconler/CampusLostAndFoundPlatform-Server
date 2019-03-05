package com.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.entity.Article;
import com.entity.HibernateSessionFactory;
import com.entity.User;

public class UserDao {
	public User searchUserByUsername(String username){  //根据用户名查询user
		User user=new User();
		Session session=HibernateSessionFactory.getSession();
		Transaction tx=session.beginTransaction();
		String hql="from User u where u.username=?";
		Query query=session.createQuery(hql);
		query.setString(0,username);
		user=null;
		List list=query.list();
		Iterator it=list.iterator();
		if(it.hasNext()){
			user=(User)it.next();
		}

		tx.commit();
		return user;
	}
	public User searchUserByUid(int id){  //根据id查询user
		User user=new User();
		Session session=HibernateSessionFactory.getSession();
		Transaction tx=session.beginTransaction();
		String hql="from User u where u.uid=?";
		Query query=session.createQuery(hql);
		query.setInteger(0,id);
		user=null;
		List list=query.list();
		Iterator it=list.iterator();
		if(it.hasNext()){
			user=(User)it.next();
		}
		tx.commit();
		return user;
	}
	
	public User search(User user){
		Session session=HibernateSessionFactory.getSession();
		Transaction tx=session.beginTransaction();
		String hql="from User u where u.username=? and u.password=?";
		Query query=session.createQuery(hql);
		query.setString(0,user.getUsername());
		query.setString(1,user.getPassword());
		user=null;
		List list=query.list();
		Iterator it=list.iterator();
		if(it.hasNext()){
			user=(User)it.next();	
		}
		tx.commit();
		return user;
	}
	
	public int add(User user){
		int result=0;
		Session s=HibernateSessionFactory.getSession();
		Transaction tx=s.beginTransaction();
		
		User isUserExist=new User();
		isUserExist=searchUserByUsername(user.getUsername());
		try{
			if(isUserExist==null){
				s.save(user);
			
				tx.commit();
				
				result=1;
			}
		}catch(Exception e){
			tx.rollback();
			e.printStackTrace();		
		}finally{
		
			s.close();
		}
		return result;
	}
}
