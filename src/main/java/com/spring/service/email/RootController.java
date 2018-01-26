package com.spring.service.email;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
	
	@Autowired
	private SmtpMailSender smtpMailSender;
	private String isOk;
	
	@CrossOrigin(origins = "http://localhost:9080")
	@RequestMapping("/send-mail")
	public MyForm sendMail()  {
		
		try {
			System.out.println("Test is pass ...!");
		
		List<String> lst = new ArrayList<String>();
		lst.add("surinenisandeep@gmail.com");
	    lst.add("s.sandeep716@gmail.com");
	   // lst.add("");
		
		for(String lst1:lst) {
			smtpMailSender.send(lst1, "Test mail from Spring", "Hii");
			
			
		}
		
		
		}
		catch(Exception e) {
			
			isOk="AM Not";
			e.printStackTrace();
			
		}
		
		finally {
			
			System.out.println(" Test is success ..! ");
		}
		
		return new MyForm();
	}
	
	   @GetMapping("/send-mail-javaconfig")
	    public MyForm sendMailWithJavaconfig() {
		   try {
				System.out.println("Test is pass ...!");
			
			List<String> lst = new ArrayList<String>();
			lst.add("surinenisandeep@gmail.com");
		    lst.add("s.sandeep716@gmail.com");
		   // lst.add("");
			
			for(String lst1:lst) {
				smtpMailSender.send(lst1, "Test mail from Spring", "Hii");
				
				
			}
			isOk ="AM Okay Config";
			
			}
			catch(Exception e) {
				
				isOk="AM Not Config";
				e.printStackTrace();
				
			}
			
			finally {
				
				System.out.println(" Test is success ..! ");
			}
			
			return new MyForm();
	    }
	

}
