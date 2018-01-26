package com.spring.service.email;
import java.util.List;

import javax.jws.WebMethod;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringFrameworkEmailServiceApplicationTests {

	@Autowired
	private SmtpMailSender smtpMailSender;
	
	@Test
	public void contextLoads() {
		try {
			System.out.println("Test is pass ...!");
		
		List<String> lst = new ArrayList<String>();
		lst.add("surinenisandeep@gmail.com");
	    lst.add("s.sandeep716@gmail.com");
	   // lst.add("surinenisandeep@gmail.com");
	 
		
		for(String lst1:lst) {
			smtpMailSender.send("surinenisandeep@gmail.com", "Test mail from Spring", "Hii");
			
		}
		
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		finally {
			
			System.out.println(" Test is success ..! ");
		}
	}

}
