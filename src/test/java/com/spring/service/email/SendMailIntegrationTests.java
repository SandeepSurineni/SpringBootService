package com.spring.service.email;

import static org.junit.Assert.assertEquals;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SendMailIntegrationTests {

  @Autowired
  private TestRestTemplate restTemplate;
  private String success;

  @Test
  public void corsWithAnnotation() throws Exception {
    ResponseEntity<MyForm> entity = this.restTemplate.exchange(
        RequestEntity.get(uri("/send-mail")).header(HttpHeaders.ORIGIN, "http://localhost:9080").build(),MyForm.class);
    assertEquals(HttpStatus.OK, entity.getStatusCode());
    assertEquals("http://localhost:9080", entity.getHeaders().getAccessControlAllowOrigin());
    MyForm greeting = entity.getBody();
    assertEquals("Hello",  greeting.getContent());
  }

  @Test
  public void corsWithJavaconfig() {
    ResponseEntity<MyForm> entity = this.restTemplate.exchange(
        RequestEntity.get(uri("/send-mail-javaconfig")).header(HttpHeaders.ORIGIN, "http://localhost:9080").build(),
        MyForm.class);
    assertEquals(HttpStatus.OK, entity.getStatusCode());
    assertEquals("http://localhost:9080", entity.getHeaders().getAccessControlAllowOrigin());
    MyForm greeting = entity.getBody();
    assertEquals("Hello, World!", greeting.getContent());
  }

  private URI uri(String path) {
    return restTemplate.getRestTemplate().getUriTemplateHandler().expand(path);
  }

}