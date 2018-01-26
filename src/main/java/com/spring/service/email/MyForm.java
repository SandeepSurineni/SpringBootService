package com.spring.service.email;

public class MyForm {

	  private final long id;
	    private final String content= " I have excuted ";

	    public MyForm() {
	        this.id = -1;
	        getContent();
	    }

	    public String getContent() {
	        return content;
	    }
}
