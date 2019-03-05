package com.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Article;
import com.entity.HibernateSessionFactory;
import com.entity.User;

public class ArticleDao {
	
	public List articleDetail(int id){
		List<Object> list=new ArrayList<Object>();
		Session s=HibernateSessionFactory.getSession();
		s.clear();
		Transaction tx=s.beginTransaction();
		String hql="from Article a where a.aid=?";
		try{
//			int id=Integer.parseInt(aid);
			Query query=s.createQuery(hql);
			query.setInteger(0,id);
			list=query.list();
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
	public List listAllArticle(){
		List list;
		Session s=HibernateSessionFactory.getSession();
		s.clear();
		Transaction tx=s.beginTransaction();

		String hql="from Article a ";
		
		Query query=s.createQuery(hql);
		list=query.list();
		
		
		return list;
	}
	
	public List listArticle(String school,int type,String difDate){
		List<Object> list=new ArrayList<Object>();
		Session s=HibernateSessionFactory.getSession();
		s.clear();
		Transaction tx=s.beginTransaction();
	
//		String hql="select a.aid,a.title from Article a";
		String hql="from Article a where a.school=? and type=? " +
				"and a.date>? order by aid desc";
		try{
			Query query=s.createQuery(hql);
			query.setString(0, school);
			query.setInteger(1, type);
			if(difDate.equals("三天内")){
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date=new Date();  
			    Calendar calendar = Calendar.getInstance();  
			    calendar.setTime(date);  
			    calendar.add(Calendar.DAY_OF_MONTH, -3);  
			    date = calendar.getTime();
				query.setString(2, df.format(date));
			}
			if(difDate.equals("当天")){
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date=new Date();  
			    Calendar calendar = Calendar.getInstance();  
			    calendar.setTime(date);  
			    calendar.add(Calendar.DAY_OF_MONTH, -1);  
			    date = calendar.getTime();
				query.setString(2, df.format(date));
			}
			if(difDate.equals("七天内")){
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date=new Date();  
			    Calendar calendar = Calendar.getInstance();  
			    calendar.setTime(date);  
			    calendar.add(Calendar.DAY_OF_MONTH, -7);  
			    date = calendar.getTime();
				query.setString(2, df.format(date));
			}
			if(difDate.equals("一个月内")){
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date=new Date();  
			    Calendar calendar = Calendar.getInstance();  
			    calendar.setTime(date);  
			    calendar.add(Calendar.DAY_OF_MONTH, -30);  
			    date = calendar.getTime();
				query.setString(2, df.format(date));
			}
			
			list=query.list();
			tx.commit
			();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public List listArticleByArticleType(String school,String articleType,int type,String difDate){
		List<Object> list=new ArrayList<Object>();
		Session s=HibernateSessionFactory.getSession();
		s.clear();
		Transaction tx=s.beginTransaction();
		String hql="from Article a where a.school=? and a.articleType=? and a.type=? " +
				"and a.date>? order by aid desc";
		try{
			Query query=s.createQuery(hql);
			query.setString(0, school);
			query.setString(1, articleType);
			query.setInteger(2, type);
			if(difDate.equals("三天内")){
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date=new Date();  
			    Calendar calendar = Calendar.getInstance();  
			    calendar.setTime(date);  
			    calendar.add(Calendar.DAY_OF_MONTH, -3);  
			    date = calendar.getTime();
				query.setString(3, df.format(date));
			}
			if(difDate.equals("当天")){
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date=new Date();  
			    Calendar calendar = Calendar.getInstance();  
			    calendar.setTime(date);  
			    calendar.add(Calendar.DAY_OF_MONTH, -1);  
			    date = calendar.getTime();
				query.setString(3, df.format(date));
			}
			if(difDate.equals("七天内")){
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date=new Date();  
			    Calendar calendar = Calendar.getInstance();  
			    calendar.setTime(date);  
			    calendar.add(Calendar.DAY_OF_MONTH, -7);  
			    date = calendar.getTime();
				query.setString(3, df.format(date));
			}
			if(difDate.equals("一个月内")){
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date=new Date();  
			    Calendar calendar = Calendar.getInstance();  
			    calendar.setTime(date);  
			    calendar.add(Calendar.DAY_OF_MONTH, -30);  
			    date = calendar.getTime();
				query.setString(3, df.format(date));
			}
			list=query.list();
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}	
		
		return list;
	}
	public List listArticleBySearch(String searchContent){
		List<Object> list=new ArrayList<Object>();
		Session s=HibernateSessionFactory.getSession();
		s.clear();
//		String hql="select a.aid,a.title from Article a";
		String hql="from Article a where a.title like?";
		try{
		
			Query query=s.createQuery(hql);
			query.setString(0, "%"+searchContent+"%");
		
			list=query.list();

		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
	public List listMyArticle(String username,int type){
		List<Object> list=new ArrayList<Object>();
		Session s=HibernateSessionFactory.getSession();
		s.clear();
//		String hql="select a.aid,a.title from Article a";
		String hql="from Article a where a.user=? and a.type=? order by aid desc";
		try{
			User user=new User();
			UserDao dao=new UserDao();
			user=dao.searchUserByUsername(username);
			Query query=s.createQuery(hql);
			query.setEntity(0, user);
			query.setInteger(1, type);
			list=query.list();
			

		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int addArticle(Article lost){
		int result=0;
		Session s=HibernateSessionFactory.getSession();
		s.clear();
		Transaction tx=s.beginTransaction();
		
		try{
			s.save(lost);
		
			tx.commit();
			result=1;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			s.close();
		}
		
		return result;
	}
	public Article searchArticleByAid(int id){
		List<Object> list=new ArrayList<Object>();
		Session s=HibernateSessionFactory.getSession();
		s.clear();
		Transaction tx=s.beginTransaction();
		Article a=new Article();
		String hql="from Article a where a.aid=?";
		try{
//			int id=Integer.parseInt(aid);
			Query query=s.createQuery(hql);
			query.setInteger(0,id);
			list=query.list();
			Iterator it=list.iterator();
			a=null;
			if(it.hasNext()){
				a=(Article)it.next();
			}
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		return a;
	}
	public int setHasFound(int id){
		int result=0;
		Session s=HibernateSessionFactory.getSession();
		s.clear();
		Transaction tx=s.beginTransaction();
		String hql="update Article a set a.state=1 where a.aid=?";
		try{
			Query query=s.createQuery(hql);
			query.setInteger(0,id);
			query.executeUpdate();
			tx.commit();
			result=1;
		}catch(Exception e){
			e.printStackTrace();
		}finally{			
			s.close();
		}
		
		return result;
	}
	
}
