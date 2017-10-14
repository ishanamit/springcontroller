package springcontrollertest;


import static org.junit.Assert.*;

import org.apache.catalina.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.stack.main.Repo;
import org.stack.main.repocontroller.Repos;
@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Repo.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringControllerTest {
    String user1;
//    @LocalServerPort
//    private int port;
    ConfigurableApplicationContext context;
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    Repos repo;
    @Before
    public void setUp() throws Exception {
         repo = new Repos("R4","mark","java");
    }
    private String createURLWithPort(String uri) {
        return "http://localhost:8080/repos/"+uri;
    }
    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void testGetRepo() throws Exception {
        HttpEntity<Repos> entity = new HttpEntity<Repos>(repo);
       /* ResponseEntity<String> response = restTemplate.exchange(
        		"http://localhost:8080/repos/R4",
                HttpMethod.PUT, entity, String.class);*/
        ResponseEntity<String> response = restTemplate.exchange(
        		createURLWithPort("R4"),
                HttpMethod.PUT, entity, String.class);
        
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("Repo does not exist!",actual);
    }
    @Test
    public void testDeleteRepo() throws Exception {
        HttpEntity<Repos> entity = new HttpEntity<Repos>(repo);
       /* ResponseEntity<String> response = restTemplate.exchange(
        		"http://localhost:8080/repos/R4",
                HttpMethod.PUT, entity, String.class);*/
        ResponseEntity<String> response = restTemplate.exchange(
        		createURLWithPort("R4"),
                HttpMethod.DELETE, entity, String.class);
        
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("Repo does not exist!",actual);
    }
   
    
    
}
