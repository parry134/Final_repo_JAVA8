package com.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.repository.JpaAccountRepository;
import com.example.service.TxrService;
import com.example.service.TxrServiceImpl;

public class App {

	public static void main(String[] args) {

		// third-party / container ==> application context

		// ---------
		// Init / boot
		// ---------

		System.out.println("---------------------------");

//		AccountRepository jdbcAccRepository = new JdbcAccountRepository();
//		AccountRepository jpaAccRepository = new JpaAccountRepository();
//		TxrService txrService = new TxrServiceImpl(jpaAccRepository);

		ConfigurableApplicationContext applicationContext = null;
		applicationContext = new ClassPathXmlApplicationContext("bank-app.xml","data-source.xml");

		System.out.println("---------------------------");

		// ---------
		// Use
		// ---------

		TxrService txrService = applicationContext.getBean("txrService", TxrService.class);
		System.out.println("---------------------------");
		txrService.txr(1927500.00, "1", "2");
		

		System.out.println("---------------------------");

		// ---------
		// Destroy
		// ---------
		///
		System.out.println("---------------------------");
		applicationContext.close();
		System.out.println("---------------------------");

	}

}
