package com.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class Test {
	public static void main(String[]args){
		
		Session s=HibernateSessionFactory.getSession();
		Transaction tx=s.beginTransaction();
		
		try{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			String date = df.format(new Date());
			Date date=new Date();  
		    Calendar calendar = Calendar.getInstance();  
		    calendar.setTime(date);  
		    calendar.add(Calendar.DAY_OF_MONTH, -3);  
		    date = calendar.getTime();  
//			Date d1 = df.parse(date); 
//			Date d2 = df.parse("2018-6-25 18:30:24");
//			long difMin=(d1.getTime() - d2.getTime())/(1000*60);
			System.out.println(df.format(date));
//			
//			String str="1121212121";
//			String regEx = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
//			Pattern pattern = Pattern.compile(regEx);
//			Matcher matcher = pattern.matcher(str);
//			boolean rs = matcher.matches();
//			
//			Pattern pattern1 = Pattern.compile("[0-9]*");
//			Matcher m=pattern1.matcher(str);
//		    System.out.println(rs);
		    
//		    String x="[[1,'2'],[2,'2']";
//		    List l=new ArrayList();
//		    String s1[]=x.split("[\\[\\]\\,\\']");
//		    String s2[];
//		    for(String a : s1){
//	            System.out.println(a);
//	        }
//		    System.out.println(s1[1]);
		    
		   
			
//			User user=new User();
//			user.setUsername("xxx");
//			user.setPassword("000000");
//			user.setSchool("南通大学");
//			user.setTel("138xxx");
			
//			User user=(User)s.get(User.class, 2);
//			Article a=new Article();
//			a.setAddress("一食堂");
//			a.setArticleType("校园卡");
//			a.setContactName("徐杨");
//			a.setContactTel("13862925128");
//			a.setDate(date);
//			a.setSchool("南通大学");
//			a.setTitle("捡到一张校园卡");
//			a.setUser(user);
//			a.setViewNum(0);
//			a.setType(0);
//			
//			s.save(a);
//			tx.commit();
//			s.close();
			
		}catch(Exception e){
			tx.rollback();
			e.printStackTrace();
			
		}
		
	}
}
