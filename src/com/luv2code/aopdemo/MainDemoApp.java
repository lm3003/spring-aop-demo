package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//Read the spring config java class
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from the spring config
		AccountDAO theAccountDAO=context.getBean("accountDAO",AccountDAO.class);
		
		//get the membership bean from the spring config
		MembershipDAO theMembershipDAO=context.getBean("membershipDAO",MembershipDAO.class);
		
		//call methods on it
		Account theAccount=new Account();
		theAccountDAO.addAccount(theAccount, true);
		theAccountDAO.doingWork();
		
		//call method on membershipdao
		theMembershipDAO.addAccount();		
		
		
		//close the context
		context.close();

	}

}
