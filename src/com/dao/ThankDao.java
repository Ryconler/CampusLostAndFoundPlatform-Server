package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.HibernateSessionFactory;
import com.entity.Thank;
import com.entity.User;

public class ThankDao {
	public List listThankByRUid(int rUid){
		List<Object> list=new ArrayList<Object>();
		
		Session s=HibernateSessionFactory.getSession();
		s.clear();
		Transaction tx=s.beginTransaction();
		
		String hql="from Thank t where t.userByRuid=? order by tid desc";
		try{
			User user=new User();
			user.setUid(rUid);
			Query query=s.createQuery(hql);
			query.setEntity(0, user);
			list=query.list();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		tx.commit();
		return list;
	}
	public List listThank(){
		List<Object> list=new ArrayList<Object>();
		
		Session s=HibernateSessionFactory.getSession();
		s.clear();
		Transaction tx=s.beginTransaction();
		
		String hql="from Thank t order by tid desc";
		try{
			Query query=s.createQuery(hql);
			int size=query.list().size(); 
			Random r=new Random(); 
			query.setMaxResults(10); 
			query.setFirstResult(r.nextInt(size-10)+1); 
			list=query.list();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		tx.commit();
		return list;
	}
	public int addThank(Thank t){
		List<Object> list=new ArrayList<Object>();
		Session s=HibernateSessionFactory.getSession();
		s.clear();
		Transaction tx=s.beginTransaction();
		int result=0;
		try{
			s.save(t);
		
			tx.commit();
			result=1;
		}catch(Exception e){
			tx.rollback();
			e.printStackTrace();	
		}
		finally{
			
			s.close();
		}
		return result;
	}
}
