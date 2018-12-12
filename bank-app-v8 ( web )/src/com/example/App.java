package com.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.BankAppConfiguration;
import com.example.service.TxrService;

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
		applicationContext = new AnnotationConfigApplicationContext(BankAppConfiguration.class);

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
